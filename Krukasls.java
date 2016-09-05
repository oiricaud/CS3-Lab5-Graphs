package lab5_6;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Krukasls {

	//			     ________________________________________________________
	//			    |	Column 0   |  Column 1  |   Column 2    | Column 3   |
	//				|____EDGES____|___Color____|__Predecessor__|__Distance_ |
	//		 _______|________________________________________________________|
	// 	    | Row 0 | 		 A     |  black     |	null		|   0		 |
	// 		| Row 1 | 	 	 B     |  white 	|  				|	0		 |
	// 		| Row 2 |        C     |  white		|				|	0		 |
	// 		| Row 3 |        D     |  white		|				|   0		 |
	//		   .
	//		   .
	//		   .
	// This algorithm takes in a graph from the examples I provied 
	// It uses the adjacancy matrix to get the edges of all vertices then it adds random weights to the edges 
	// and sorts the list and starts building a graph.
	public static void calculator(Object[][] adjacencyMatrix, LinkedList listVertices, LinkedList<String> listofEdges,
			int numberOfvertices) {
		System.out.println("*************** KRUSKALS first search **********************");
		Random r = new Random();
		KruskalsTable edgesTable = new KruskalsTable(listofEdges.size());
		KruskalsTable tableInfo = new KruskalsTable(listofEdges.size());
		LinkedList elements = new LinkedList();
		// Add random values to the edges 
		Object array[][] = new Object [3][3];
		for(int i = 0; i  <listofEdges.size(); i++){
			int randomInt = r.nextInt((i+1)*10) + 1;
			elements.add(edgesTable.myTable[i].add(randomInt) + "" + listofEdges.get(i));

		}
		// print the edges with its corresponding weights 
		for(int i = 0 ; i < elements.size(); i++){
			System.out.println("elements: " + elements.get(i));
		}
		Collections.sort(elements);
		// Look for the smallest edge and begin building the tree //
		System.out.println("");
		int small = (int) elements.get(0);
		for(int i = 0 ; i < elements.size(); i++){
			System.out.println("elements: " + elements.get(i));
			
		}
	}

	private static void sortList(Object[][] myArray) {
		int n = (Integer) myArray.length;
		int temp = 0;
		for(int row = 0; row < myArray.length; row++){
			  for(int i=0; i < n; i++){
                  for(int j=1; j < (n-i); j++){
                         
                          if((Integer)myArray[0][j-1] > (Integer) myArray[j][0]){
                                  //swap the elements!
                                  temp = (Integer) myArray[j-1][0];
                                  myArray[j-1][0] = myArray[j];
                                  myArray[j][0] = temp;
                          }
                         
                  }
		}

	}

	}
}


