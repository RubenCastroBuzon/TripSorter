package com.empaua.tripsorter.model.travel;

import com.empaua.tripsorter.exception.TripSorterException;
import com.empaua.tripsorter.model.transport.Transport;

public class TransportTravel extends Travel{
	
	private static final String PACKAGE = "com.empaua.tripsorter.model.transport.";
	private Transport transport;
	
	public TransportTravel(final String origin, final String target, final String id, final String type, final String seat) throws TripSorterException {
	
		try {
			this.transport = (Transport) Class.forName(PACKAGE + type).newInstance();
		} catch (InstantiationException e) {
			throw new TripSorterException("Can't create instance for type: " + type);
		} catch (IllegalAccessException e) {
			throw new TripSorterException("Can't create instance for type: " + type);
		} catch (ClassNotFoundException e) {
			throw new TripSorterException("Can't create instance for type: " + type);
		}
		
		setOrigin(origin);
		setTarget(target);
		this.transport.setOrigin(origin);
		this.transport.setTarget(target);
		this.transport.setIdentifier(id);
		this.transport.setType(type);
		this.transport.setSeat(seat);
	}

	public final String toString(){
		return this.transport.toString();
	}

	public final Transport getTransport() {
		return this.transport;
	}

	public final void setTransport(final Transport transport) {
		this.transport = transport;
	}
}
