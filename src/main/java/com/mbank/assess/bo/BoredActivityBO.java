package com.mbank.assess.bo;

import java.math.BigDecimal;

public class BoredActivityBO {

	private String activity;
	
	private String type;
	
	private int participants;
	
	private BigDecimal price;
	
	private String link;
	
	private String key;
	
	private BigDecimal accessibility;

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public BigDecimal getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(BigDecimal accessibility) {
		this.accessibility = accessibility;
	}

	@Override
	public String toString() {
		return "BoredActivityBO [activity=" + activity + ", type=" + type + ", participants=" + participants
				+ ", price=" + price + ", link=" + link + ", key=" + key + ", accessibility=" + accessibility + "]";
	}
	
}
