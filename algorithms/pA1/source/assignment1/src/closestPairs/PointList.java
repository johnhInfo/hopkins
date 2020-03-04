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
import java.util.Comparator;
import java.util.List;

public class PointList {
	
	public ArrayList<Point> list;
	public double distance;
	
	/**************************************************************
	 * Constructor Method creates an object of the class PointList
	 **************************************************************/
	public PointList() {
		ArrayList<Point> temp = new ArrayList<Point>();
		this.list = temp;
	}
	/***************************************************************
	 * print prints all of the Points in the PointList
	 * 
	 ***************************************************************/
	public void print() {
		
		for(int i = 0; i < this.list.size(); i++) {
			this.list.get(i).fPrint();
		}
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
	/***************************************************************
	 * size Returns the size of an arrayList
	 ***************************************************************/
	public int size()
	{
		return this.list.size();
	}
	/***************************************************************
	 * createPair creates a PairList which contains only two points
	 * 
	 * @param Point A The first Point in the pair
	 * @param Point B The second Point in the pair
	 * @return Distance The distance between the two points 
	 ***************************************************************/
	public double createPair(Point A, Point B)
	{
		ArrayList<Point> temp = new ArrayList<Point>();
		temp.add(A);
		temp.add(B);
		this.list = temp;
		return this.distance = A.distance(B.x,  B.y);
	}
	/***************************************************************
	 * withinRange Returns a subList which fits within the bounds
	 * 
	 * @param valueHigh
	 * @param valueLow
	 * @param axis 
	 ***************************************************************/
	public ArrayList<Point> withinRange(double low, double high, Cartesian axis)
	{
		int minIndexInRange = -1; 				/* Minimum Index Found w/in Range */
		int maxIndexInRange = -1;				/* Maximum Index Found w/in Range */
		boolean somethingInRangeFound = false;
		
		/********************************************************************
		 * If Axis is set to Y-Axis - Find Y-Axis Values within Range
		 ********************************************************************/
		if(axis == Cartesian.ySort) {
			Collections.sort(this.list, new SortYAxis());
										/*Iterate through array finding 
										 *... values w/in a range        */
			for(int i = 0; i < this.list.size(); i++)
			{
				double value = this.list.get(i).y;
				if( value <= high && value >= low)
				{
										/*First element found must be 
										 *the minimum index found since
										 *the list is sorted			*/
					if(!somethingInRangeFound) {
						minIndexInRange = i;
						maxIndexInRange = i;
						somethingInRangeFound = true;
					}
					else				/*All others found extend maxIndex*/
					{
						maxIndexInRange = i;
					}
				}

			}
			/* If values within the range found, create a subList        */
			if(somethingInRangeFound) {
				List<Point> range = this.list.subList(minIndexInRange, maxIndexInRange + 1);
				return new ArrayList<Point>(range); 
			}
			else {return null;}
		}
		/********************************************************************
		 * Otherwise, Find X-Axis Values within Range
		 ********************************************************************/
		else { 
			Collections.sort(this.list, new SortXAxis());
			for(int i = 0; i < this.list.size(); i++)
			{
				double value = this.list.get(i).x;
				if( value <= high && value >= low)
				{
										/*First element found must be 
										 *the minimum index found since
										 *the list is sorted			*/
					if(!somethingInRangeFound) {
						minIndexInRange = i;
						maxIndexInRange = i;
						somethingInRangeFound = true;
					}
					else				/*All others found extend maxIndex*/
					{
						maxIndexInRange = i;
					}
				}

			}
			/* If values within the range found, create a subList        */
			if(somethingInRangeFound) {
				List<Point> range = this.list.subList(minIndexInRange, maxIndexInRange + 1);
				return new ArrayList<Point>(range); 
			}
			else { return null;}
		}								
	}
}
/*****************************************************************************
 * SortByDistance Compares two Pairs by their distance
 * 
 * @param Point The first point to compare
 * @param Point The second point to compare
 *****************************************************************************/
class SortByDistance implements Comparator<PointList>{
	public int compare(PointList o, PointList d) {
			if(o.distance > d.distance){return 1;}
			else if(o.distance < d.distance) {return -1;}
			else {return 0;}
		}
	}


