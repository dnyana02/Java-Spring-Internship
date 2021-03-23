package org.demo.practice;

public class DrawTriangle {
	
	private String type;
	private String name;
	private int height;
	
	
	/*
	 * public String getName() { return name; }
	 * 
	 * public int getHeight() { return height; }
	 */
    
	
	public DrawTriangle(String name,int height)
	{
		this.name=name;
		this.height=height;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void draw()
	{
		System.out.println(name + " is " + getType() + " Triangle drawn whose height is " + height +" cm.");
	}

}
