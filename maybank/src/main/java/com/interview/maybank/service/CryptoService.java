package com.interview.maybank.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.maybank.entity.Crypto;
import com.interview.maybank.repository.CryptoRepo;
import com.interview.maybank.utils.Utility;

@Service
public class CryptoService {
	private final static Logger log = (Logger) LoggerFactory.getLogger(CryptoService.class);
	@Autowired
	private CryptoRepo cryptoRepo;
	@Autowired
	private Utility utility;

	public String getCryptoListByPagination(int pages, int count) {
		String url = "https://finance.yahoo.com/crypto/?offset=" + pages + "&count=" + count;
		Element html = null;
		try {
			html = Jsoup.connect(url).get().getElementById("scr-res-table");
			List<String> output = new ArrayList<String>();
			List<Crypto> cryptos = new ArrayList<Crypto>();
			html.getElementsByClass("simpTblRow").forEach(result -> {
				// get cryto name
				output.add(result.getElementsByAttributeValue("data-test", "quoteLink").html());
				String keyPrice = "data-symbol";
				String cryptoName = result.getElementsByAttributeValue("data-test", "quoteLink").html();
				String price = result.getElementsByAttributeValue(keyPrice, cryptoName).attr("value");
				String marketCap = result.getElementsByAttributeValue("data-field", "marketCap").attr("value");
				Crypto crypto = new Crypto(cryptoName, price, marketCap);
				cryptos.add(crypto);

			});
			utility.saveData(cryptos);
			return utility.objToJSONString(cryptos);
		} catch (IOException e) {
			return e.getMessage();
		}
	}

}
