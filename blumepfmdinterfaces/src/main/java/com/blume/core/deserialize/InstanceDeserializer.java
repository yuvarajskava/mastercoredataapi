package com.blume.core.deserialize;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.blume.core.common.AbstractUserOperation;
import com.blume.core.dto.CommodityClassDTO;
import com.blume.core.dto.CountryCurrencyDTO;
import com.blume.core.dto.EquipmentTypeDTO;
import com.blume.core.dto.PlatformLoadTypeDTO;
import com.blume.core.dto.PlatformModeDTO;
import com.blume.core.dto.PlatformMoveTypeDTO;
import com.blume.core.dto.PlatformPalletTypeDTO;
import com.blume.core.dto.PlatformRateBasisDTO;
import com.blume.core.dto.PlatformServiceLevelDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;

@Component
public class InstanceDeserializer extends JsonDeserializer<AbstractUserOperation> 
{

	@Override
	public AbstractUserOperation deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException
	{
		ObjectMapper mapper = (ObjectMapper) jp.getCodec();

		return mapper.treeToValue(mapper.readTree(jp), getRequestClass(getRequestType()));
	}
	
	public String getRequestType()
	{	
		String requestURI = getServletPath();
		return requestURI.substring(1, requestURI.indexOf('/', 1));
	}
	
	public String getServletPath()
	{
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getServletPath();
	}

	public Class<? extends AbstractUserOperation> getRequestClass(String requestType) 
	{
		return InstanceDeserializerUtil.getInstance().getInstanceClassMap().get(requestType);
	}

}

class InstanceDeserializerUtil
{
	private static InstanceDeserializerUtil singletonInstanceUtil = null;

	@Getter
	private Map<String, Class<? extends AbstractUserOperation>> instanceClassMap = new HashMap<>();
	@Getter
	private Pattern regexPatten = null;

	private InstanceDeserializerUtil()
	{
		instanceClassMap.put("commodityclass", CommodityClassDTO.class);
		instanceClassMap.put("countrycurrency", CountryCurrencyDTO.class);
		instanceClassMap.put("equipmenttype", EquipmentTypeDTO.class);
		instanceClassMap.put("platformloadtype", PlatformLoadTypeDTO.class);
		instanceClassMap.put("platformmode", PlatformModeDTO.class);
		instanceClassMap.put("platformmovetype", PlatformMoveTypeDTO.class);
		instanceClassMap.put("platformpallettype", PlatformPalletTypeDTO.class);
		instanceClassMap.put("platformratebasis", PlatformRateBasisDTO.class);
		instanceClassMap.put("platformservicelevel", PlatformServiceLevelDTO.class);
		instanceClassMap.put("platformtriptype", PlatformServiceLevelDTO.class);
		instanceClassMap.put("platformuom", PlatformServiceLevelDTO.class);
		
		regexPatten = Pattern.compile("\\/(.*)\\/");
	}
	
	public static InstanceDeserializerUtil getInstance() 
    { 
        if (singletonInstanceUtil == null) 
        	singletonInstanceUtil = new InstanceDeserializerUtil(); 
  
        return singletonInstanceUtil; 
    }
	
	

}
