/**
 * 
 */
package com.pdr.session.utils;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.function.Predicate;

import com.pdr.common.dto.solp.AplicacionSolpDTO;
import com.pdr.common.dto.solp.CollComponenteDTO;
import com.pdr.common.dto.solp.CollElementoDTO;
import com.pdr.common.dto.solp.ElementoDTO;
import com.pdr.session.dto.ApplicationDTO;
import com.pdr.session.dto.CollapsedComponentDTO;
import com.pdr.session.dto.CollapsedItemDTO;
import com.pdr.session.dto.ItemDTO;

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

		List<AplicacionSolpDTO> listado = listadoAppSolp.stream().filter(distinctByKey(x -> x.getIdAplicacion())).collect(Collectors.toList());
		for (AplicacionSolpDTO solp : listado) {
			List<ElementoDTO> navItemList = solp.getElementos();

			List<ItemDTO> itemListResult = new ArrayList<>();
			if (solp.getUrl() != null) {
				if (!navItemList.isEmpty()) {
					for (ElementoDTO navItem : navItemList) {
						List<CollComponenteDTO> collComponentList = navItem.getCollapsedComponent();

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
							component.setCollapsedItems(collapsedItemListResult);
							collapsedComponentListResult.add(component);
						}
						ItemDTO itmdto = new ItemDTO();
						itmdto.setActive(navItem.getValid() == '1' ? Boolean.TRUE : Boolean.FALSE);
						itmdto.setDataTarget(ConstantesUtil.DATA_TARGET);
						itmdto.setIcon((navItem.getIcono()));
						itmdto.setId(navItem.getIdSubMenuAplicacion());
						itmdto.setTitle(navItem.getNombre());
						itmdto.setUrl(navItem.getUrl());
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
	
	private static boolean isExterno(List<ElementoDTO> elementos) {
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
