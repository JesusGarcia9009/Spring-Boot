/**
 * 
 */
package com.session.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.pdr.common.dto.solp.AplicacionSolpDTO;
import com.pdr.common.dto.solp.CollComponenteDTO;
import com.pdr.common.dto.solp.CollElementoDTO;
import com.pdr.common.dto.solp.ElementoDTO;
import com.session.dto.ApplicationDTO;
import com.session.dto.CollapsedComponentDTO;
import com.session.dto.CollapsedItemDTO;
import com.session.dto.ItemDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 */
@Slf4j
public class GenericUtils {

	private GenericUtils() {
	}

	public static List<ApplicationDTO> getListApp(List<AplicacionSolpDTO> listadoAppSolp) {
		log.info("[getListApp]:: Inicio del metodo");
		List<ApplicationDTO> result = new ArrayList<>();

		for (AplicacionSolpDTO solp : listadoAppSolp) {
			HashMap<String, ElementoDTO> navItemList = solp.getElementos();

			List<ItemDTO> itemListResult = new ArrayList<>();
			if (solp.getUrl() != null) {
				if (navItemList != null && !navItemList.isEmpty()) {
					for (Entry<String, ElementoDTO> navItem : navItemList.entrySet()) {
						List<CollComponenteDTO> collComponentList = navItem.getValue().getCollapsedComponent();

						List<CollapsedComponentDTO> collapsedComponentListResult = new ArrayList<>();
						for (CollComponenteDTO collItem : collComponentList) {
							List<CollElementoDTO> collapsedComponentList = collItem.getCollapsedItem();

							List<CollapsedItemDTO> collapsedItemListResult = new ArrayList<>();
							for (CollElementoDTO elemnto : collapsedComponentList) {
								CollapsedItemDTO item = new CollapsedItemDTO();
								item.setActive(elemnto.getValid() == '1' ? Boolean.TRUE : Boolean.FALSE);
								item.setTitle(elemnto.getNombre());
								item.setUrl(elemnto.getUrl());

								collapsedItemListResult.add(item);
							}
							CollapsedComponentDTO component = new CollapsedComponentDTO();
							component.setHeader(collItem.getHeader());
							component.setCollapsedItems(collapsedItemListResult.stream().filter(distinctByKey(x -> x.getTitle())).collect(Collectors.toList()));
							collapsedComponentListResult.add(component);
						}
						ItemDTO itmdto = new ItemDTO();
						itmdto.setActive(navItem.getValue().getValid() == '1' ? Boolean.TRUE : Boolean.FALSE);
						itmdto.setDataTarget(ConstantesUtil.DATA_TARGET);
						itmdto.setIcon((navItem.getValue().getIcono()));
						itmdto.setId(navItem.getValue().getIdSubMenuAplicacion());
						itmdto.setTitle(navItem.getValue().getNombre());
						itmdto.setUrl(navItem.getValue().getUrl());
						itmdto.setCollapsedComponent(collapsedComponentListResult);
						itemListResult.add(itmdto);
					}
				}
				ApplicationDTO temp = new ApplicationDTO(new BigDecimal(solp.getIdAplicacion()), solp.getNombre(),
						solp.getDescripcion(), getIcon(solp.getIcon()), getColor(solp.getColor()), solp.getUrl(),
						isExterno(solp.getElementos()), (solp.getValid() == '1' ? Boolean.TRUE : Boolean.FALSE),
						itemListResult);

				result.add(temp);
			}
		}
		log.info("[getListApp]:: Fin del metodo");
		return result;
	}

	private static String getIcon(String icon) {
		String result = ConstantesUtil.ICON;
		if (icon != null)
			result = icon;

		return result;
	}

	private static String getColor(String color) {
		String result = ConstantesUtil.COLOR;
		if (color != null)
			result = color;

		return result;
	}

	private static boolean isExterno(HashMap<String, ElementoDTO> elementos) {
		boolean result = true;
		if (elementos != null && !elementos.isEmpty()) {
			result = false;
		}
		return result;
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {

		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

}
