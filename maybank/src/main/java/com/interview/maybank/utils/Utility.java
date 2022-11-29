package com.interview.maybank.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.maybank.entity.Crypto;
import com.interview.maybank.repository.CryptoRepo;

@Service
public class Utility {
	private final static Logger log = (Logger) LoggerFactory.getLogger(Utility.class);
	@Autowired
	private CryptoRepo cryptoRepo;

	public void saveData(List<Crypto> cryptos) {
		cryptos.stream().forEach(data -> {
			String cryptoName = data.getCryptoName();
			Crypto crypto = cryptoRepo.findByCryptoName(cryptoName);
			if (crypto != null) {
				data.setId(crypto.getId());
			}
			cryptoRepo.save(data);
		});
	}

	public String objToJSONString(Object obj) {
		String result = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);

		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error("Error in ObjToJSONString with error: " + e, e);
		}

		return result;
	}
}
