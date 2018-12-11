package com.leftBoundaryFeature;

import com.tags.Tags;

public class Boundary implements BoundaryMapper {
	private String name;
	private String TagName;
	private Tags tag;
	private int frequency;
	private Double weight;
	
	public Boundary() {
		super();
		this.setFrequency(0);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Tags getTag() {
		return tag;
	}
	public void setTag(Tags tag) {
		this.tag = tag;
	}
	public String getTagName() {
		return TagName;
	}
	public void setTagName(String tagName) {
		TagName = tagName;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	@Override
	public String toString() {
		return "Boundary [name=" + name + ", TagName=" + TagName + ", tag=" + tag + ", frequency=" + frequency
				+ ", weight=" + weight + "]";
	}
	
}
