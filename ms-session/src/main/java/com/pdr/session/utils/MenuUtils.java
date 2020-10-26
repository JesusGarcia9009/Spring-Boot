/**
 * 
 */
package com.pdr.session.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.pdr.session.dto.CollapsedComponentDTO;
import com.pdr.session.dto.CollapsedItemDTO;
import com.pdr.session.dto.ItemDTO;
import com.pdr.session.dto.MenuDTO;

/**
 * @author BS2
 *
 */
public class MenuUtils {
	
	
	public static List<MenuDTO> objectToMenu(List<Object> list){
		List<MenuDTO> result = new ArrayList<>();
		
		if (Objects.isNull(list)) {
            return null;
        }
		MenuDTO temp = null;
        
        for (Object object : list) {
        	Object[] arraysObjects = (Object[]) object;
        	temp = new MenuDTO();
        	temp.setIdApplication((BigDecimal) arraysObjects[0]);
        	temp.setNameApp((String) arraysObjects[1]);
        	temp.setIdSubMenuApp((BigDecimal) arraysObjects[2]);
        	temp.setNameSubMenuApp((String) arraysObjects[3]);
        	temp.setValidSubMenuApp( ((char)arraysObjects[4]) == '1' ? Boolean.TRUE : Boolean.FALSE );
        	temp.setIdSubMenuFunc((BigDecimal) arraysObjects[5]);
        	temp.setNameSubMenuFunc((String) arraysObjects[6]);
        	temp.setUrlSubMenuFunc((String) arraysObjects[7]);
        	temp.setValidSubMenuFunc(((char)arraysObjects[8]) == '1' ? Boolean.TRUE : Boolean.FALSE);
        	
        	result.add(temp);
        }
        return result;
	}
	
	public static List<BigDecimal> getListOfApps(List<MenuDTO> request) {
        List<BigDecimal> result = new ArrayList<>();
        if (!request.isEmpty()) {
            for (MenuDTO menu : request) {
                if (!result.contains(menu.getIdApplication())) {
                    result.add(menu.getIdApplication());
                }
            }
        } 
        return result;
    }
	
	public static List<ItemDTO> getListOfIems(List<MenuDTO> request, BigDecimal idApp) {
        ArrayList<ItemDTO> result = new ArrayList<>();
        if (!request.isEmpty()) {
        	List<MenuDTO> listadoFiltrado = request.stream().filter(x-> x.getIdApplication().compareTo(idApp) == 0).collect(Collectors.toList());
            for (MenuDTO menu : listadoFiltrado) {
            	if(!contains(result, menu.getIdSubMenuApp())) {
	            	ItemDTO temp = new ItemDTO();
	            	temp.setId(menu.getIdSubMenuApp());
	            	temp.setTitle(menu.getNameSubMenuApp());
	            	temp.setActive(menu.isValidSubMenuApp());
	            	temp.setDataTarget("#collapseTwo");
	            	temp.setIcon(getIcon(menu.getNameSubMenuApp()));
	            	temp.setCollapsedComponent(new ArrayList<CollapsedComponentDTO>());
	                result.add(temp);
            	}
            }
        } 
        return result;
    }
	
	public static boolean contains(List<ItemDTO> items, BigDecimal id) {
		List<ItemDTO> lista = items.stream().filter(x -> x.getId().compareTo(id) == 0).collect(Collectors.toList());
		boolean resultado = false;
		if(!lista.isEmpty())
			resultado = true;
		
		return resultado;
	}
	
	public static List<CollapsedItemDTO> getListOfCollapsedItem(List<MenuDTO> request, BigDecimal idApp, BigDecimal idItem) {
        ArrayList<CollapsedItemDTO> result = new ArrayList<>();
        if (!request.isEmpty()) {
        	List<MenuDTO> listadoFiltrado = request.stream().filter(x-> x.getIdApplication().compareTo(idApp) == 0 && x.getIdSubMenuApp().compareTo(idItem) == 0).collect(Collectors.toList());
            for (MenuDTO menu : listadoFiltrado) {
            	CollapsedItemDTO temp = new CollapsedItemDTO();
            	temp.setActive(menu.isValidSubMenuFunc());
            	temp.setTitle(menu.getNameSubMenuFunc());
            	temp.setUrl(menu.getUrlSubMenuFunc());
            	
                result.add(temp);
            }
        } 
        return result;
    }
	
	private static String getIcon(String name) {
		String result = "fa fa-user-edit";
		if(name.contains("Simulaciones"))
			result = "fab fa-hornbill";
		if(name.contains("Consulta"))
			result = "fa fa-address-card";
		
		return result;
	}
	
	
}
