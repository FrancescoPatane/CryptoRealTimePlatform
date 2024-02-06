package it.fp.crypto.rtp.rtmanager.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PriceTsDto {
	
	private Date time;
	private BigDecimal price;
	private String asset;
	
	public PriceTsDto(Date time, BigDecimal price, String asset) {
		super();
		this.time = time;
		this.price = price;
		this.asset = asset;
	}

	public Date getTime() {
		return time;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getAsset() {
		return asset;
	}

	@Override
	public String toString() {
		return "PriceTsDto [time=" + time + ", price=" + price + ", asset=" + asset + "]";
	}
	
	

}
