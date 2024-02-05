package it.fp.crypto.rtp.ts.tsmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fp.crypto.rtp.ts.tsmanager.PriceService;
import it.fp.crypto.rtp.ts.tsmanager.persistence.model.Price;

@RestController
@RequestMapping("prices")
public class PriceController {
	
	@Autowired
	private PriceService service;
	
	@GetMapping
	public List<Price> findAll(){
		return this.service.findAll();
	}

	@GetMapping("/{asset}")
	public List<Price> findByAsset(@PathVariable("asset") String asset){
		return this.service.findByAsset(asset);
	}
	
	@GetMapping("/test")
	public String test(){
		return "test";
	}

}
