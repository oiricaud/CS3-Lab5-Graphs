package lab5_6;

import java.util.LinkedList;
// Euler path 
/* This class will determine if the graph has an Euler Path
 * Recall an Euler Path has to touch all edges but could only
 * touch each edge once.
 */
public class eulerPath {
	//	 S A F C B D 
	public static void calculator(int n, Object[][] adjacencyMatrix, LinkedList<String> listofEdges) {

		listofEdges.get(0);
		System.out.println(" ");
		int rowCount = 0;
		int numOfOddVertices = 0;
		for(int row = 1 ; row < n ; row ++){
			for(int column = 1; column < n; column++){
				rowCount = rowCount + (int) adjacencyMatrix[row][column]; 
				// Debuggin System.out.print(adjacencyMatrix[row][column] + " ");	
			}
			// Debugging System.out.println("Row " + row + " has a sum of " + rowCount);
			// If the sum is odd //
			if(rowCount % 2 != 0){
				numOfOddVertices++;
			}
			rowCount=0;
		}
		if(numOfOddVertices > 2 || numOfOddVertices == 1){
			System.out.println("The number of odd vertices is = " + numOfOddVertices);
			System.out.println("The graph does not have an Euler path ");
		}
		else{
			System.out.println("The number of odd vertices is = " + numOfOddVertices);
			System.out.println("The graph may have an Euler path");
			int rowPointer = 1;
			LinkedList <String> edgeList = new LinkedList<String> ();
			eulerPath(adjacencyMatrix,  rowPointer, edgeList, n);
		}
		
	}


	private static LinkedList<String> eulerPath(Object[][] adjacencyMatrix,  int rowPointer, LinkedList <String> edgeList, int n) {
		// S A F C B D
		int column = 1;
		int row = 1;
		int numOfEdges = 0;
		boolean isItaCompleteGraph = (completeGraph(adjacencyMatrix, n));

		if(isItaCompleteGraph == false){
			while(numOfEdges < adjacencyMatrix.length){
				System.out.println("The graph is not a complete graph ");
				System.out.println("The number of edges is: " + (adjacencyMatrix.length));
				// Debugging	System.out.println("Iteration: " + numOfEdges);
				// Debugging    System.out.println("edge:" + edgeList);
				String opposite = "{" + adjacencyMatrix[0][column] + " " +  adjacencyMatrix[rowPointer][0] + "}";
				//Debugging System.out.println("Opposite string: " + opposite);
				String nonOpposite = "{" + adjacencyMatrix[rowPointer][0] + " " + adjacencyMatrix[0][column] + "}";
				//Debugging System.out.println("Opposite string: " + opposite);
				if(adjacencyMatrix[rowPointer][column].equals(1) && (!(edgeList.contains(opposite))&& (!(edgeList.contains(nonOpposite))))){
					String edge = "{" + adjacencyMatrix[rowPointer][0] + " " + adjacencyMatrix[0][column] + "}";
					//Debugging System.out.println("Edge {" + adjacencyMatrix[rowPointer][0] + " " + adjacencyMatrix[0][column] + "}");
					edgeList.add(edge);
					//Debugging System.out.println("edge:" + edgeList);
					numOfEdges++;
					rowPointer = column;
					column = 1;
				}
				else{
					column++;
				}
				//Debugging System.out.println("Edge list{ " + edgeList );
			}
		}
		else{
			System.out.println("The graph is complete graph ");
			int edgeFormula = ((adjacencyMatrix.length-1))*(adjacencyMatrix.length-2)/2;
			//	System.out.println("The number of edges is: " +  edgeFormula);
			LinkedList <String> edgeList2 = new LinkedList<String> ();
			buildEulerPath(adjacencyMatrix, edgeFormula, edgeList2);
		}
		System.out.println("Euler path = " + edgeList );
		return edgeList;
	}

	private static void buildEulerPath(Object[][] adjacencyMatrix, int edgeFormula, LinkedList <String> edgeList2) {
		int rowPointer2 = 1;
		int numOfEdges2 = 0;
		int column2 = 1;
		int row2 = 1;

		while(numOfEdges2 < edgeFormula){
			//System.out.println("numOfEdges2: " + numOfEdges2 + " < " + "edgeFormula "  + edgeFormula);

			// Debugging	System.out.println("Iteration: " + numOfEdges);
			// Debugging    System.out.println("edge:" + edgeList);
			String opposite = "{" + adjacencyMatrix[0][column2] + " " +  adjacencyMatrix[rowPointer2][0] + "}";
			//	System.out.println("--> Opposite string: " + opposite);
			String nonOpposite = "{" + adjacencyMatrix[rowPointer2][0] + " " + adjacencyMatrix[0][column2] + "}";
			//	System.out.println("---> Non Opposite string: " + nonOpposite);
			if(adjacencyMatrix[rowPointer2][column2].equals(1) && (!(edgeList2.contains(opposite))&& (!(edgeList2.contains(nonOpposite))))){
				String edge = "{" + adjacencyMatrix[rowPointer2][0] + " " + adjacencyMatrix[0][column2] + "}";
				//System.out.println("Edge {" + adjacencyMatrix[rowPointer2][0] + " " + adjacencyMatrix[0][column2] + "}");
				edgeList2.add(edge);
				//System.out.println("edge:" + edgeList2);
				numOfEdges2++;
				rowPointer2 = column2;
				column2 = 1;
			}
			else{
				/* Handles the situation where we reach the last column */
				column2++;
				if(column2 == adjacencyMatrix.length){
					System.out.println("Error" );
					//column2--;
					System.out.println("column numbber" + column2);
					System.out.println("row number" + rowPointer2);
					rowPointer2 = column2-1;
					column2 = 0;
				}
			}
			//Debugging System.out.println("Edge list{ " + edgeList );
		}
		System.out.println("Euler path = " + edgeList2 );
	}


	// Boolean determines if graph is a complete graph // 
	private static boolean completeGraph(Object[][] adjacencyMatrix, int n) {
		// TODO Auto-generated method stub
		int rowCount = 0;
		boolean findOut = false;
		for(int row = 1 ; row < n ; row ++){
			for(int column = 1; column < n; column++){
				rowCount = rowCount + (int) adjacencyMatrix[row][column]; 

				// Debuggin System.out.print(adjacencyMatrix[row][column] + " ");	
			}
			// Debugging System.out.println("Row " + row + " has a sum of " + rowCount);
			// If the sum is odd //
			//	System.out.println("Value for row: " + rowCount);
			//	System.out.println("Number of vertices: " + (adjacencyMatrix.length-2));
			if(rowCount == (adjacencyMatrix.length-2)){
				findOut = true;
			}

			rowCount=0;
		}
		return findOut;
	}
}
