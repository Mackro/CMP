package warborn.controller;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {
	
	private ImageIcon image;
	private String name;
	private int index;
	
	public Card(String troop, ImageIcon image, int index){
		this.name = troop;
		this.image = image;
		this.index = index;
	}

	public ImageIcon getImage() {
		return image;
	}

	public String getName() {
		return name;
	}
	
	public int getIndex() {
		return index;
	}

}
