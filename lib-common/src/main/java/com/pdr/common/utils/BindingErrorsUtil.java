package com.pdr.common.utils;

import java.util.Collections;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

public class BindingErrorsUtil {
	
	
	public static BindingResult getErrors(List<String> errors) {
		BindingResult bindingResult = new MapBindingResult(Collections.singletonMap("a", "b"), "No se pudo validar");
		
		for(String error: errors)
			bindingResult.addError(new ObjectError("",error));
		
		return bindingResult;
		
	}

}
