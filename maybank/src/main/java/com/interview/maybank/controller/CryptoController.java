package com.interview.maybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.maybank.service.CryptoService;

@RestController
@CrossOrigin
@RequestMapping(value = "crypto")
public class CryptoController {

	@Autowired
	CryptoService cryptoService;

	@GetMapping("/getCryptoListByPagination")
	@ResponseBody
	public String getCryptoListByPagination(@RequestParam("page") int pages, @RequestParam("count") int count) {
		return cryptoService.getCryptoListByPagination(pages, count);
	}
}
