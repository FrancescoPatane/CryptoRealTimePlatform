package it.fp.crypto.rtp.ts.tsmanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fp.crypto.rtp.ts.tsmanager.persistence.model.Price;
import it.fp.crypto.rtp.ts.tsmanager.persistence.repository.PriceRepository;

@Service
public class PriceService {
	
	@Autowired
	private PriceRepository repository;
	
	
	public List<Price> findAll(){
		return this.repository.findAll();
	}
	
	public List<Price> findByAsset(String asset){
		return this.repository.findByAsset(asset);
	}

}
