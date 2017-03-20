package com.empaua.tripsorter.util;

import com.empaua.tripsorter.exception.TripSorterException;
import com.empaua.tripsorter.model.travel.Travel;

public interface ISorter {
	public Travel sort(final Travel travel) throws TripSorterException;
}
