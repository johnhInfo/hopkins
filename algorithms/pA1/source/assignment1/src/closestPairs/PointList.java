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
	public double distance;
	
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
		return this.distance = A.distance(B.x,  B.y);
	}
	
}

