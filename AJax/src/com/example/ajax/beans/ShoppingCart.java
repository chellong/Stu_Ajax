package com.example.ajax.beans;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	private Map<String,ShoppingCartItem> items = new HashMap<>();
	
	private String bookName;
	
	public void addToCart(String bookName,int price){
		
		this.bookName = bookName;
		
		if(items.containsKey(bookName)){
			ShoppingCartItem item = items.get(bookName);
			item.setNumber(item.getNumber() + 1);;
		}else{
			ShoppingCartItem item = new ShoppingCartItem();
			item.setNumber(1);
			item.setBookName(bookName);
			item.setPrice(price);
			
			items.put(bookName, item);
		}
	}
	
	public int getTotalBookNumber(){
		
		int total = 0;
		for(ShoppingCartItem item : items.values()){
			total += item.getNumber();
		}
		return total;
		
	}
	
	public int getTotalMoney(){
		
		int total = 0;
		for(ShoppingCartItem item : items.values()){
			total += item.getNumber() * item.getPrice() ;
		}
		return total;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
	
}
