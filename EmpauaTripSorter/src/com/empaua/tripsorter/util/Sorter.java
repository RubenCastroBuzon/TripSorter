package com.empaua.tripsorter.util;

import java.util.ArrayList;
import java.util.List;

import com.empaua.tripsorter.exception.TripSorterException;
import com.empaua.tripsorter.model.travel.MainTravel;
import com.empaua.tripsorter.model.travel.Travel;

/**
 * @author rcastrob
 * 
 * This class has the sorter implementation
 *
 */
public class Sorter implements ISorter{
			
	/**
	 * Constructor
	 */
	public Sorter() {
		super();
	}

	/**
	 * This method return a object Travel ordered
	 * 
	 * @param travel
	 * @return
	 * @throws TripSorterException
	 */
	public Travel sort(final Travel travel) throws TripSorterException {

		final String mainOrigin = travel.getOrigin();		
		if (mainOrigin == null || "".equals(mainOrigin)) {
			throw new TripSorterException("Main origin has a incorrect value");
		}
		
		final String mainTarget = travel.getTarget();		
		if (mainTarget == null || "".equals(mainTarget)) {
			throw new TripSorterException("Main target has a incorrect value");
		}
						
		final List<Travel> transports = ((MainTravel)travel).getTransportTravel();
		List<Travel> orderedTransports = new ArrayList<Travel>();
		String destinationToSearch = "";
		//1.0 Main origin and rest of origins
		destinationToSearch = mainOrigin;
		int i = 0;
		while (i < transports.size()) {		
			//1.1 We look for the destination of this first transport in the rest of transports, comparing it with the origin field and so with all until we reach the final destination
			final Travel transport = transports.get(i);
			if (destinationToSearch.equals(transport.getOrigin())){
				orderedTransports.add(transport);
				transports.remove(transport);
				destinationToSearch = transport.getTarget();
				i = 0;
			} else {
				i++;
			}			
		}
		//2.0 Main travel		
		Travel newTravel = new MainTravel();
		newTravel.setOrigin(mainOrigin);
		newTravel.setTarget(mainTarget);
		((MainTravel)newTravel).setTransportTravel(orderedTransports);
		
		return newTravel;
		
	}

}
