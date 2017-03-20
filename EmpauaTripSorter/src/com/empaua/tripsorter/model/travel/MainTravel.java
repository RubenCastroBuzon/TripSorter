package com.empaua.tripsorter.model.travel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainTravel extends Travel{
	
	public MainTravel() {
		super();
		this.transportTravel = new ArrayList<Travel>();
	}

	List<Travel> transportTravel;
	
	public void add(final Travel travel){
		this.transportTravel.add(travel);
	}
	
	public void remove(final Travel travel){
		this.transportTravel.remove(travel);
	}
	
	public List<Travel> getTransportTravel(){
		return this.transportTravel;
	}
	
	public void setTransportTravel(final List<Travel> transportTravel){
		this.transportTravel.addAll(transportTravel);
	}
	
	public final String toString(){
		final StringBuilder toString = new StringBuilder( "**Transports:**\n");
		for (Iterator<Travel> iter = this.transportTravel.iterator(); iter.hasNext(); ) {
			final Travel travel = iter.next();
			toString.append(" ").append(travel.toString()).append("\n");
		}
		return toString.toString();
	} 
	
}
