package com.session.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Setter
@Getter
@ToString
public class CollapsedComponentDTO {
	
	public CollapsedComponentDTO() {
		super();
	}

	private String header;
	
	private List<CollapsedItemDTO> collapsedItems = new ArrayList<>();
	
	public CollapsedComponentDTO(String header, List<CollapsedItemDTO> collapsedItems) {
		super();
		this.header = header;
		this.collapsedItems = collapsedItems;
	}


}
