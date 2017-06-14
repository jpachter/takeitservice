package com.takeit.objectmapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class ObjectMapperProvider implements ContextResolver<Object> {

	private ObjectMapper objectMapper;

	public ObjectMapperProvider() {
		objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		// Do not serialize map key-value where value is null
		objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

		// Trying to ignore fields that have null values.
		objectMapper.setSerializationInclusion(Include.NON_NULL);
	}

	public Object getContext(Class<?> type) {
		return objectMapper;
	}
}