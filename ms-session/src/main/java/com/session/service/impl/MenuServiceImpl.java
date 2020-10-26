/**
 * 
 */
package com.session.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdr.common.dto.solp.AplicacionSolpDTO;
import com.pdr.common.session.entity.ApplicationModel;
import com.session.dto.ApplicationDTO;
import com.session.dto.CollapsedComponentDTO;
import com.session.dto.ItemDTO;
import com.session.dto.MenuDTO;
import com.session.repository.ApplicationRepository;
import com.session.repository.ProfileApplicationRepository;
import com.session.service.MenuService;
import com.session.utils.GenericUtils;
import com.session.utils.MenuUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author JesúsManuelGarcíaHer
 *
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

	@Autowired
	private ProfileApplicationRepository profileApplicationRepository;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public List<ApplicationDTO> findMenu(List<Long> profileList) {
		log.info("[findMenu]::inicio de metodo");

		List<MenuDTO> result = MenuUtils.objectToMenu(profileApplicationRepository.findMenuByIdsProfile(profileList));
		List<ApplicationDTO> apps = new ArrayList<>();

		List<ApplicationDTO> nameAppList = listadoAplicaciones(MenuUtils.getListOfApps(result));
		for (ApplicationDTO App : nameAppList) {

			if(App.isLandingEnable())
				App.setNavItems(MenuUtils.getListOfIems(result, App.getIdApplication()));

			for (ItemDTO item : App.getNavItems()) {
				CollapsedComponentDTO component = new CollapsedComponentDTO();
				component.setCollapsedItems(MenuUtils.getListOfCollapsedItem(result, App.getIdApplication(), item.getId()));
				component.setHeader("Operations");
				item.getCollapsedComponent().add(component);
			}
			apps.add(App);
		}

		log.info("[findMenu]::fin de metodo");
		return apps;
	}

	private List<ApplicationDTO> listadoAplicaciones(List<BigDecimal> idAppList) {
		List<ApplicationDTO> result = new ArrayList<>();
		List<ApplicationModel> listadoTotal = applicationRepository.findByLandingPageOrderByName("1");
		for (ApplicationModel applicationModel : listadoTotal) {
			ApplicationDTO temp = new ApplicationDTO(applicationModel.getIdApplication(), applicationModel.getName(),
					applicationModel.getDescription(), applicationModel.getImagen(), applicationModel.getColor(), "" , true, true, new ArrayList<ItemDTO>());
			if(idAppList.contains(applicationModel.getIdApplication())) {
				temp.setLandingEnable(true);
			} else {
				temp.setLandingEnable(false);
			}
			result.add(temp);
		}

		return result;
	}
	
	
	@Override
	public List<ApplicationDTO> findMenuFromSolp(List<AplicacionSolpDTO> listadoAppSolp) {
		log.info("[findMenuFromSolp]::inicio de metodo");
		log.info("[findMenuFromSolp]::fin de metodo");
		return GenericUtils.getListApp(listadoAppSolp);
	}
	
	
	
	

}
