package com.javacodegeeks.resteasy.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cart {
	private List<Cartline> cartlineList;

	public Cart(List<Cartline> cartlineList) {
		this.cartlineList = cartlineList;
	}
	
	@XmlElement(name = "cartline")
	@XmlElementWrapper(name = "cartlines")
	public List<Cartline> getCartlineList() {
		return cartlineList;
	}

	public void setCartlineList(List<Cartline> cartlineList) {
		this.cartlineList = cartlineList;
	}
}
