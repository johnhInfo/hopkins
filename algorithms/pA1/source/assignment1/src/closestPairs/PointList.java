package closestPairs;

import java.util.ArrayList;

public class PointList {
	
	public ArrayList<Point> list;
	private int median;
	private int length;

	
	/**************************************************************
	 * Constructor Method creates an object of the class PointList
	 **************************************************************/
	public PointList() {
		ArrayList<Point> temp = new ArrayList<Point>();
		this.list = temp;
		this.median = 0;
		this.length = 0;
	}
	
	/***************************************************************
	 * add Method adds a point to the PointList
	 * 
	 * @param e Point object to be added to the PointList
	 ***************************************************************/
	public void add(Point e) {
		
		this.list.add(e);
	}
	
	
	
	
}

