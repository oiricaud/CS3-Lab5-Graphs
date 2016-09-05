package lab5_6;

import java.util.LinkedList;

public class graphClass {
	// This graph class is used throughout the the whole lab
	// It essentially makes a nice table such as the following:
	//			     ________________________________________________________
	//			    |	Column 0   |  Column 1  |   Column 2    | Column 3   |
	//				|____Vertex____|___Color____|__Predecessor__|__Distance_ |
	//		 _______|________________________________________________________|
	// 	    | Row 0 | 		 A     |  black     |	null		|   0		 |
	// 		| Row 1 | 	 	 B     |  white 	|  				|	0		 |
	// 		| Row 2 |        C     |  white		|				|	0		 |
	// 		| Row 3 |        D     |  white		|				|   0		 |
	//		   .
	//		   .
	//		   .
	// A B C D E

	Object [][] vertex;
	LinkedList<Object> source = new LinkedList<Object>();
	String predecessor = null;
	String color = "white";
	int distance = 0;
	/* Column positions */
	int vertexPos = 0;
	int colorPos = 1;
	int prePos = 2;
	int distPos = 3;

	public graphClass(int rowSize) {
		vertex = new Object[rowSize][4];
	}

	public void addVertex(Object node, int row) {

		vertex[row][vertexPos] = node;
		// This is our source paint it black 
		if(row == 0){
			vertex[row][colorPos] = "black";
		}
		else{
			vertex[row][colorPos] = color;	
		}

		//row++;
	}

	public Object getColor(int count ) {
		for(int i = 0; i < vertex.length; i++){
			if(i == count){
				return vertex[i][colorPos];
				//return 
			}
		}
		return null;

	}

	public Object setColor(int count, String tempColor) {
		for(int i = 0; i < vertex.length; i++){
			if(i == count){
				vertex[i][colorPos] = tempColor;
				//return 
			}
		}
		return null;

	}

	public void addPredecessor(Object object, Object predecessor) {
		//	vertex[row][prePos] = predecessor;
		//	vertex[count].add(object);
	}
	public void addDistance(Object object, int Distance) {
		//	vertex[row][columnPos] = Distance;
		//	vertex[count].add(object);

	}
	public void info(){
		for(int row = 0; row < vertex.length; row++){
			System.out.print("Vertex " + row);
			for(int column = 0; column < 4; column++){ 
				System.out.print(" | " + vertex[row][column] + " |   " );
				
			}
			System.out.println(" ");
		}
	}
	public int getSmallestEdge(){
		int smallest = (int) vertex[1][3];
		System.out.println("smallest" + smallest);
		for(int row = 1; row < vertex.length-1; row++){

			System.out.print("Vertex " + row);
			if((Integer) vertex[row][3] < smallest){
				smallest = (Integer) vertex[row][3];
			}
			System.out.println(" ");
		}
		return smallest;
		
	}
	public Object getVertex(int count) {
		for(int i = 0; i < vertex.length; i++){
			if(i == count){
				return vertex[i][vertexPos];
				//return 
			}
		}
		return null;
	}

	public void setPredecessor(int count, Object text) {
		for(int i = 0; i < vertex.length; i++){
			if(i == count){
				vertex[i][prePos] = text;
				//return 
			}
		}
	}
	public Object getPredecessor(int count) {
		for(int i = 0; i < vertex.length; i++){
			if(i == count){
				return vertex[i][prePos];
				//return 
			}
		}
		return null;
	}

	public void setDistance(int count, int distance) {
		// TODO Auto-generated method stub
		for(int i = 0; i < vertex.length; i++){
			if(i == count){
				vertex[i][distPos] = distance;
				//return 
			}
		}


	}
	
	public Object getDistance(int count) {
		for(int i = 0; i < vertex.length; i++){
			if(i == count){
				return vertex[i][vertexPos];
				//return 
			}
		}
		return null;
	}
}
