package com.pdr.session.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Getter
@Setter
@ToString
public class MenuDTO {
	
	private BigDecimal idApplication;
	private String NameApp;
	private BigDecimal idSubMenuApp;
	private String nameSubMenuApp;
	private boolean validSubMenuApp;
	private BigDecimal idSubMenuFunc;
	private String nameSubMenuFunc;
	private String urlSubMenuFunc;
	private boolean validSubMenuFunc;
	
	public MenuDTO() {
		super();
	}

	public MenuDTO(BigDecimal idApplication, String nameApp, BigDecimal idSubMenuApp, String nameSubMenuApp,
			boolean validSubMenuApp, BigDecimal idSubMenuFunc, String nameSubMenuFunc, String urlSubMenuFunc,
			boolean validSubMenuFunc) {
		super();
		this.idApplication = idApplication;
		NameApp = nameApp;
		this.idSubMenuApp = idSubMenuApp;
		this.nameSubMenuApp = nameSubMenuApp;
		this.validSubMenuApp = validSubMenuApp;
		this.idSubMenuFunc = idSubMenuFunc;
		this.nameSubMenuFunc = nameSubMenuFunc;
		this.urlSubMenuFunc = urlSubMenuFunc;
		this.validSubMenuFunc = validSubMenuFunc;
	}

	
}
