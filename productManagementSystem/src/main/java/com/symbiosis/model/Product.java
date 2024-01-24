package com.symbiosis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {

	 @Id
	   
	    private int id;
	    private String name;
	    private int quantity;
	    private double price;
	    
	    @Lob    //represents following attribute is  "LARGE OBJ TYPE"
		private byte[] image;
		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}

		public Product() {
			super();
		}

		public Product(int id, String name, int quantity, double price) {
			super();
			this.id = id;
			this.name = name;
			this.quantity = quantity;
			this.price = price;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
	    
	    
}
