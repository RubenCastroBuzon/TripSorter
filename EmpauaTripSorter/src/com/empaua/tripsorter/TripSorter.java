package com.empaua.tripsorter;

import com.empaua.tripsorter.exception.TripSorterException;
import com.empaua.tripsorter.model.travel.MainTravel;
import com.empaua.tripsorter.model.travel.TransportTravel;
import com.empaua.tripsorter.model.travel.Travel;
import com.empaua.tripsorter.util.ISorter;
import com.empaua.tripsorter.util.Sorter;

public class TripSorter {

	private static final String BUS = "Bus";
	private static final String AIRPLANE = "Airplane";
	private static final String TRAIN = "Train";
	
	/**
	 * Main
	 * 
	 * @param args
	 * @throws TripSorterException 
	 */
	public static void main(String[] args) throws TripSorterException {
		
		final Travel principalTravel = new MainTravel(); 
		principalTravel.setOrigin("Madrid");
		principalTravel.setTarget("New York");

		//From Gerona Airport, take flight SK455 to Stockholm. Gate 45B, seat 3ª. Baggage drop at ticket counter 344.
		Travel transportTravel = new TransportTravel("Gerona", "Stockholm", "3", AIRPLANE,"3");
		((MainTravel)principalTravel).add(transportTravel);
		//From Stockholm, take flight SK22 to New York JFK. Gate 22, seat 7B. Baggage will we automatically transferred from your last leg.
		transportTravel = new TransportTravel("Stockholm", "New York", "4", AIRPLANE,"7B");
		((MainTravel)principalTravel).add(transportTravel);
		//Take the airport bus from Barcelona to Gerona Airport. No seat assignment.
		transportTravel = new TransportTravel("Barcelona", "Gerona", "2", BUS,"NA");
		((MainTravel)principalTravel).add(transportTravel);	
		//Take train 78ª from Madrid to Barcelona. Sit in seat 45B.
		transportTravel = new TransportTravel("Madrid", "Barcelona", "1", TRAIN,"45B");		
		((MainTravel)principalTravel).add(transportTravel);
	
		System.out.println("*******Test 1:\n" + principalTravel.toString());
		ISorter sorter = new Sorter();
		Travel orderedTravel = sorter.sort(principalTravel);
		System.out.println("***********ORDERED TRAVEL*********");
		System.out.println(orderedTravel.toString());
		
		
		//From Stockholm, take flight SK22 to New York JFK. Gate 22, seat 7B. Baggage will we automatically transferred from your last leg.
		transportTravel = new TransportTravel("Stockholm", "New York", "4", AIRPLANE,"7B");
		((MainTravel)principalTravel).add(transportTravel);
		//Take the airport bus from Barcelona to Gerona Airport. No seat assignment.
		transportTravel = new TransportTravel("Barcelona", "Gerona", "2", BUS,"NA");
		((MainTravel)principalTravel).add(transportTravel);	
		//Take train 78ª from Madrid to Barcelona. Sit in seat 45B.
		transportTravel = new TransportTravel("Madrid", "Barcelona", "1", TRAIN,"45B");		
		((MainTravel)principalTravel).add(transportTravel);
		//From Gerona Airport, take flight SK455 to Stockholm. Gate 45B, seat 3ª. Baggage drop at ticket counter 344.
		transportTravel = new TransportTravel("Gerona", "Stockholm", "3", AIRPLANE,"3");
		((MainTravel)principalTravel).add(transportTravel);

	
		System.out.println("*******Test 2:\n" + principalTravel.toString());
		sorter = new Sorter();
		orderedTravel = sorter.sort(principalTravel);
		System.out.println("***********ORDERED TRAVEL*********");
		System.out.println(orderedTravel.toString());
		
		
	}

}
