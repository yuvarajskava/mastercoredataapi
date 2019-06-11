package com.blume.core.mapper;

import org.mapstruct.factory.Mappers;

public class MapperUtil {
	/**
	 * This method is used to get object model mapper for the dynamic object.
	 * 
	 * @param clazz Class for which the model mapper needs to retrieved
	 * @param       <T> the generic type- dynamic object
	 * @return the generic type- dynamic object
	 */
	public static <T> T getModelMapper(Class<T> clazz) {
		return Mappers.getMapper(clazz);
	}
}
