package it.fp.crypto.rtp.ts.tsmanager.persistence.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import it.fp.crypto.rtp.ts.tsmanager.persistence.model.Price;

@Repository
public class PriceRepository {
	
	  private static final Logger logger = LoggerFactory.getLogger(PriceRepository.class);

	
	@Autowired
	private MongoTemplate mt;
	
	public void insert(Price p) {
		this.mt.insert(p);
		logger.info("Added {} - {} - {}", p.getCurrency(), p.getTime(), p.getPrice());
	}
	
	public List<Price> findAll(){
		return this.mt.findAll(Price.class);
	}
	
	public List<Price> findByAsset(String asset){
		Query query = new Query();
		query.addCriteria(Criteria.where("currency").is(asset));
		return this.mt.find(query, Price.class);
	}


}
