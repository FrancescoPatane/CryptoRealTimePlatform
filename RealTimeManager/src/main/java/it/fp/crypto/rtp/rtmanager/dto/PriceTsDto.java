package it.fp.crypto.rtp.rtmanager.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PriceTsDto {
	
	private Date time;
	private BigDecimal price;
	private String currency;
	
	public PriceTsDto(Date time, BigDecimal price, String currency) {
		super();
		this.time = time;
		this.price = price;
		this.currency = currency;
	}

	public Date getTime() {
		return time;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return "PriceTsDto [time=" + time + ", price=" + price + ", currency=" + currency + "]";
	}
	
	

}
