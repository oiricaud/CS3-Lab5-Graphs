package lab5_6;

import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthDepthSearch {
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
	//			 S A B C D 
	//    		 S 0 1 1 0 0
	//			 B 1 0 1 1 1
	//			 C 1 1 0 0 1
	//			 D 0 1 0 0 1
	//			 E 0 1 1 1 0
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

	public static void calculator(Object[][] adjacencyMatrix, LinkedList listVertices, LinkedList<String> listofEdges, int NumberOfvertices) {
		System.out.println("");
		System.out.println("************** Begin Breadth depth search ********************* " );
		String BDSpath = "";
		graphClass BDSgraph = new graphClass (listVertices.size());
		for(int i = 0 ; i  < listVertices.size(); i ++ ){
			BDSgraph.addVertex(listVertices.get(i), i);
		}

		BDSgraph.info();
		int rowCount = 0;
		int distance = 0;
		while(rowCount < listVertices.size()){
			if(BDSgraph.getColor(rowCount).equals("black")){
				BDSpath =  BDSpath + (adjacentVertices(adjacencyMatrix,  BDSgraph.getVertex(rowCount), BDSgraph, rowCount, distance));
				
			}
			distance++;
			rowCount++;
		}
		System.out.println(" 	 | Vertex | Color | Predecessor | Distance");
		BDSgraph.info();
		System.out.println("*************** End Breadth depth search ********************** " );
		System.out.println("" );
		System.out.println("Path using BDS:" + BDSpath);
	}
	private static Object adjacentVertices(Object[][] adjacencyMatrix, Object vertex, graphClass graph, int rowCount, int distance) {
		int visitEdge = 1;
		LinkedList<String> BDSpath = new LinkedList<String>();
		System.out.println("Vertices adjacent to " + vertex +" are:");
		BDSpath.add((String) vertex + "= (" + graph.getPredecessor(visitEdge-1) + ", ");
		while(visitEdge < adjacencyMatrix.length){
			if((Integer) adjacencyMatrix[rowCount+1][visitEdge] >= 1 && graph.getColor(visitEdge-1).equals("white")){
				//distance++;
				distance = (Integer) adjacencyMatrix[rowCount+1][visitEdge];
				System.out.println("	Vertex: " + graph.getVertex(visitEdge-1) + " color " + graph.getColor(visitEdge-1));
				graph.setColor(visitEdge-1, "black");
				graph.setPredecessor(visitEdge-1, vertex);
				// distance =  distance + (Integer) adjacencyMatrix[rowCount+1][visitEdge] ;
				System.out.println("		Predecessor of vertex " + graph.getVertex(visitEdge-1) + 
						" is " + graph.getPredecessor(visitEdge-1) + " with weight of " +  distance);
				graph.setDistance(visitEdge-1, distance);
				//System.out.println("get distance of " + graph.getDistance(visitEdge-1));
			}
			
			visitEdge++;
		}
		//BDSpath.add(("" + graph.getDistance() + ")"));
		
		return BDSpath;
	}
}
