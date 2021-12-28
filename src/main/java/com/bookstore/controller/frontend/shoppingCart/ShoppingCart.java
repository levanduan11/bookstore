package com.bookstore.controller.frontend.shoppingCart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Book;

public class ShoppingCart {
	private Map<Book, Integer>cart=new HashMap<Book, Integer>();
	
	public void add(Book book) {
		if (cart.containsKey(book)) {
			Integer quantity=cart.get(book)+1;
			cart.put(book, quantity);
		}else {
			cart.put(book, 1);
		}
	}
	public void remove(Book book) {
		cart.remove(book);
	}
	public int getTotalQuantity() {
		int total=0;
		Iterator<Book>iterator=cart.keySet().iterator();
		
		while (iterator.hasNext()) {
			Book next =  iterator.next();
			Integer quantity=cart.get(next);
			total+=quantity;
			
		}
		return total;
	}
	public float getTotalAmount() {
		float total=0.0f;
		Iterator<Book>iterator=cart.keySet().iterator();
		
		while (iterator.hasNext()) {
			Book next =  iterator.next();
			Integer quantity=cart.get(next);
			double subtotal=quantity*next.getPrice();
			total+=subtotal;
			
		}
//		String tString=String.format(".2%f", total);
//		total=Float.parseFloat(tString);
		return total;
	}
	public void updateCart(List<Integer>bookIds,List<Integer>quantities){
		
		for (int i = 0; i <bookIds.size(); i++) {
			Book key=new Book(bookIds.get(i));
			Integer value=quantities.get(i);
			cart.put(key, value);
		}
		
	
		
	}
	public void clear() {
		cart.clear();
		
	}
	public int getTotalItems() {
		return cart.size();
		
	}
	
	public Map<Book, Integer>getItems(){
		return this.cart;
	}
}
