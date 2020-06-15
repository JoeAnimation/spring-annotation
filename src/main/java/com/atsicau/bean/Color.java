package com.atsicau.bean;

public class Color {
	
	private Love love;

	public Love getLove() {
		return love;
	}

	public void setLove(Love love) {
		this.love = love;
	}

	@Override
	public String toString() {
		return "Color [love=" + love + "]";
	}
	
}
