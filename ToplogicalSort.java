package lab5_6;

import java.util.LinkedList;

public class ToplogicalSort {
	//	TOPOLOGICAL SORT
	// It is suppose to call the depth search method except it prints the path 'nicely' 
	// Lets say the path from S to T is T, X, Y , P , S. Topological sorting simply prints 
	// the vertices first then visits the adjacent vertices. So the output would be 
	// P, Y, X, T, reversed. 
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
	// UNWEIGHTED GRAPHS:
	// ------------ Begin Test 1  ------------------
	// 	 Graph#1   
	/*		     0 S A B C D
		    		 S 0 1 1 0 0
					 A 1 0 1 1 1
					 B 1 1 0 0 1
					 C 0 1 0 0 1
				 	 D 0 1 1 1 0
	 * 
	 */
	// Vertices = 5 
	// 	 Breadth Depth Search
	// 		Predecessor --> Vertex
	//			   null --> S, Black, 0 distance  
	//			   S    --> A, Black, 1 distance
	//			   S    --> B, Black, 1 distance
	//			   A    --> C, Black, 2 distance
	//			   A    --> D, Black, 2 distance
	// ------------- End Test 1 --------------------
	//
	//------------ Begin Test 2  ------------------
	// 	 Graph#2 
	//			0 S A B C D 
	//			S 0 1 0 1 1 
	//			A 1 0 1 1 1 
	//			B 1 1 0 1 1 
	//			C 1 1 1 0 1 
	//			D 1 1 1 1 0 	
	//
	// S A B C D
	static int temp = 0;	
	static LinkedList<Object> DPSpath = new LinkedList<Object>();
	public static void calculator(Object[][] adjacencyMatrix, LinkedList listVertices, LinkedList<String> listofEdges,
			int numberOfvertices) {
		// TODO Auto-generated method stub
		System.out.println(" ");
		System.out.println("2) *************** Begin depth first search ********************** " );
		System.out.println("Startin at vertex " + listVertices.get(0));


		graphClass DPSgraph = new graphClass (listVertices.size());
		for(int i = 0 ; i  < listVertices.size(); i ++ ){
			DPSgraph.addVertex(listVertices.get(i), i);
		}

		DPSgraph.info();

		int rowCount = 0;
		int distance = 0;
		DPSpath.add(DPSgraph.getVertex(rowCount));
		while(rowCount < listVertices.size()){
			// Start at any vertex 
			if(DPSgraph.getColor(rowCount).equals("black")){

				adjacentVertices(adjacencyMatrix,  DPSgraph.getVertex(rowCount), DPSgraph, rowCount, distance);

			}
			distance++;
			rowCount++;
		}

		System.out.println(" 	 | Vertex | Color | Predecessor | Distance");
		DPSgraph.info();
		System.out.println("*************** End depth first search ********************** " );
		System.out.println("" );
		System.out.println("DPS path : " + DPSpath);
	}

	private static LinkedList<Object> adjacentVertices(Object[][] adjacencyMatrix, Object vertex, graphClass graph, int rowCount, int distance) {
		int visitEdge = 1;

		/*
		 * 
		 * 0 A B C D E 
			   A 0 1 1 1 1 
			   B 1 0 1 1 1 
	           C 1 1 0 1 1 
	           D 1 1 1 0 1 
	           E 1 1 1 1 0 

		 * 
		 * 
		 */		
		System.out.println("Vertices adjacent to " + vertex +" are:");
		//DPSpath.add((String) vertex + "= (" + graph.getPredecessor(visitEdge-1) + ", ");
		while(visitEdge < adjacencyMatrix.length){

			if((Integer) adjacencyMatrix[rowCount+1][visitEdge] >= 1 && graph.getColor(visitEdge-1).equals("white")){
				distance = (Integer) adjacencyMatrix[rowCount+1][visitEdge];
				System.out.println("	Vertex: " + graph.getVertex(visitEdge-1) + " color " + graph.getColor(visitEdge-1));
				graph.setColor(visitEdge-1, "black");
				graph.setPredecessor(visitEdge-1, vertex);
				// distance =  distance + (Integer) adjacencyMatrix[rowCount+1][visitEdge] ;
				System.out.println("		Predecessor of vertex " + graph.getVertex(visitEdge-1) + 
						" is " + graph.getPredecessor(visitEdge-1) + " with weight of " +  distance);
				graph.setDistance(visitEdge-1, distance);
				DPSpath.add(graph.getVertex(visitEdge-1));

				adjacentVertices(adjacencyMatrix,  graph.getVertex(visitEdge-1), graph, distance, distance);
			}
			visitEdge++;
		}
		return DPSpath;
	}
}

