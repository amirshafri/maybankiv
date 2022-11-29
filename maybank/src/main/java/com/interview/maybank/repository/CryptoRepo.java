package com.interview.maybank.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.interview.maybank.entity.Crypto;

@Transactional
public interface CryptoRepo extends JpaRepository<Crypto, Long>, JpaSpecificationExecutor<Crypto> {

	public Crypto findByCryptoName(String cryptoName);
}
