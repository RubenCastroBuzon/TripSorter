package com.empaua.tripsorter.model.travel;

public abstract class Travel {
	
	private String origin;
	
	private String target;
	
	
	public final String getOrigin() {
		return this.origin;
	}
	public final void setOrigin(final String origin) {
		this.origin = origin;
	}
	public final String getTarget() {
		return this.target;
	}
	public final void setTarget(final String target) {
		this.target = target;
	}
	

}
