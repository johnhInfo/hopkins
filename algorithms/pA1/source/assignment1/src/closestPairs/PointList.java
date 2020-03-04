/******************************************************************************
 * File: PointList.java
 * Assignment: PA1
 * Author: John A. Herrmann
 * Class: EN.605.621.82.SP20 Foundations of Algorithms
 * Date: 3/2/2020
 *******************************************************************************/
package closestPairs;

import java.util.ArrayList;
import java.util.Collections;

public class PointList {
	
	public ArrayList<Point> list;
	
	/**************************************************************
	 * Constructor Method creates an object of the class PointList
	 **************************************************************/
	public PointList() {
		ArrayList<Point> temp = new ArrayList<Point>();
		this.list = temp;
	}
	/***************************************************************
	 * add Method adds a point to the PointList
	 * 
	 * @param e Point object to be added to the PointList
	 ***************************************************************/
	public void add(Point e) {
		
		this.list.add(e);
	}
	/***************************************************************
	 * sortXAxis Sorts the array list based on the X axis values
	 ***************************************************************/
	public void sortXAxis()
	{
		Collections.sort(this.list, new SortXAxis());
	}
	
	/***************************************************************
	 * sortYAxis Sorts the array list based on the X axis values
	 ***************************************************************/
	public void sortYAxis()
	{
		Collections.sort(this.list, new SortYAxis());
	}
	
}

