package com.interview.maybank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Crypto {

	@Id
	@GeneratedValue
	private Long id;

	private String cryptoName;
	private String price;
	private String marketCapital;

	public Crypto() {
		super();
	}

	public Crypto(String cryptoName, String price, String marketCapital) {
		super();
		this.cryptoName = cryptoName;
		this.price = price;
		this.marketCapital = marketCapital;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCryptoName() {
		return cryptoName;
	}

	public void setCryptoName(String cryptoName) {
		this.cryptoName = cryptoName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMarketCapital() {
		return marketCapital;
	}

	public void setMarketCapital(String marketCapital) {
		this.marketCapital = marketCapital;
	}

}
