package com.empaua.tripsorter.model.transport;

public abstract class Transport {
	
	private String identifier;
	private String type;
	private String origin;
	private String target;
	private String seat;
	
	public final String getIdentifier() {
		return this.identifier;
	}
	public final void setIdentifier(final String identifier) {
		this.identifier = identifier;
	}
	public final String getType() {
		return this.type;
	}
	public final void setType(final String type) {
		this.type = type;
	}
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
	public final String getSeat() {
		return this.seat;
	}
	public final void setSeat(final String seat) {
		this.seat = seat;
	}
	
	public final String toString(){
		StringBuilder builder = new StringBuilder("Origin: " + this.origin)
				.append(" Target: " + this.target)
				.append(" Id: " + this.identifier)
				.append(" Type: " + this.type)
				.append(" Seat: " + this.seat);
		return builder.toString();
	}
}
