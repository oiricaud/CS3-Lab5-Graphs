package lab5_6;

/****************************************************************************************************************************************************** //
//Author: Oscar Ivan Ricaud.
	/*Assignment: Lab 5-6
	Instructor: Professor Julio Urenda
	TA: Saiful Abu
	Course 2302
	Data of Last modification July 29th, 2016
	*/

//Program purpose:
	/*The purpose of this program is to implement and learn how graphs are used throughout the whole computer science field 
	 * My program should implement:
		• Breadth-First-Search 
		• Depth-First-Search
		• Topological Sort
		• Kruskal’s Algorithm
		• Dijkstra’s Algorithm 
		• Prim’s Algorithm
		• Connected Components
		• Strongly Connected Components
	    • Euler Path or Circuit
		• Hamiltonian Path or Cycle
		• Extra: Graph Isomorphism
	*/
		/*** I provided some test cases throughout the code most cases do pass for the following BDS, DPS, Kruskals and Euler Path.  **/

		// How to operate graphMain.java: First change the Adjacancy Matrix on line 44 - 55 change it as you wish.
		// Then the program calls multiple classes one by one to compute ONLY the following, BDS, DPS, Euler Path and Kruska'ls 
		// It then provides a nice output to verify the results. The most fun lab throughtout the semester! 

//________________________________________________________
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

//***************************************************************************************************************************************************** //

import java.util.LinkedList;
import java.util.Scanner;
public class graphMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int NumberOfvertices = 5+1;
		System.out.println("There are " + (NumberOfvertices-1) + " vertices in the graph." );
		Object[][] emptyMatrix = adjacencyMatrices.buildMatrix(NumberOfvertices);

		/* Print Empty Matrix  */
		System.out.println("Empty matrix: " );
		printMatrix(NumberOfvertices, emptyMatrix);
		System.out.print(" " );
		/* S A F C B D */ 
		System.out.println("Label your vertices in the graph, we'll start with the first row");

		/* Assign labels to the first row of the matrix  */
		for(int row = 1 ; row < NumberOfvertices; row++){
			emptyMatrix[0][row] = input.next();
		}

		/* Print Non-Empty Matrix, has references of the vertices  */
		System.out.println("Building our Adjacency Matrix: " );
		printMatrix(NumberOfvertices, emptyMatrix);
		System.out.print(" " );
		System.out.println("Now do the same for the first column");

		/* Assign labels to the first column of the matrix  */
		for(int column = 1 ; column < NumberOfvertices; column++){
			emptyMatrix[column][0] = input.next();
		}

		/* Print Non-Empty Matrix, has references of the vertices  */
		System.out.println("Building our Adjacency Matrix: " );
		printMatrix(NumberOfvertices, emptyMatrix);
		System.out.println(" " );

		/* Create a matrix to obtain the actual number of edges each vertex connects to */
		Object[][] adjacencyMatrix = connectVertices(NumberOfvertices, emptyMatrix);
		System.out.println("**** Adjancy-Matrix ****");
		printMatrix(NumberOfvertices, adjacencyMatrix);
		System.out.println("**** Adjancy-Matrix ****");
		/// Array [0] = color
		//  Array [1] = Predessesor
		// Array  [3] = distance
		LinkedList<String> listofEdges = printEdges(NumberOfvertices, adjacencyMatrix);
		System.out.println("Edges = " + listofEdges );
	
		LinkedList listVertices = getVertices(NumberOfvertices, adjacencyMatrix);
		System.out.println("vertices: " + listVertices);
		
		/* • Breadth Depth Search 			*/
		BreadthDepthSearch.calculator(adjacencyMatrix, listVertices, listofEdges, NumberOfvertices); 
		
		/*  • Depth First Search   			*/
		DepthSearch.calculator(adjacencyMatrix, listVertices, listofEdges, NumberOfvertices);
		/*  • Topological Sort 	   			*/
		//ToplogicalSort.calculator(adjacencyMatrix, listVertices, listofEdges, NumberOfvertices);
		/*  • Kruskal’s Algorithm  			*/
		Krukasls.calculator(adjacencyMatrix, listVertices, listofEdges, NumberOfvertices);
		/*  • Dijkstra’s Algorithm 			*/
		/*  • Prim’s Algorithm 	   			*/
		/*  • Euler Path or Circuit 		*/
				/* It determines if the graph has an Euler path */ 
		eulerPath.calculator(NumberOfvertices, adjacencyMatrix, listofEdges);
					/* Obtain the vertices */
		
		/* • Hamiltonian Path or Cycle 		*/
		
	

	}
	private static LinkedList getVertices(int vertices, Object[][] adjacencyMatrix) {
		LinkedList<Object> listVertices = new LinkedList<Object>();
		for(int column = 1; column < adjacencyMatrix.length; column++){
				Object vertex = adjacencyMatrix[0][column];
				listVertices.add(vertex); 
			}
		
		return listVertices;
	}
	private static LinkedList<String> printEdges(int n, Object[][] adjacencyMatrix) {
		int i = 1;
		System.out.println("");
		LinkedList <String> listofEdges = new <String> LinkedList ();
		/* Adds the edges to the list */
		for(int row = 0; row < n; row++){
			for(int column = 0 ; column < n; column++){
				if(adjacencyMatrix[row][column].equals(1)){
					String edges = "{" + adjacencyMatrix[0][row] + ", " + adjacencyMatrix[column][0] + "}";
					listofEdges.add(edges.toLowerCase());
					/* The following obtain non-repeated edges just uncomment
					String edges = "{" + adjacencyMatrix[0][row] + " -> " + adjacencyMatrix[column][0] + "}";
					String oppositeEdges = "{" + adjacencyMatrix[column][0] + " -> " + adjacencyMatrix[0][row] + "}";
					if(!(listofEdges.contains(edges.toLowerCase()))){
						if(!(listofEdges.contains(oppositeEdges.toLowerCase()))){
							listofEdges.add(edges.toLowerCase());
							i++;
						}
					}
					*/
				}
			}
		}
		return listofEdges;
	}
	private static Object[][] connectVertices(int n, Object[][] matrix) {
		/* Example: S A B C D */ 
		/* Assign edges here */
		int [][] edges = new int[][]{
			/*S  A  B  C  D  */
			{ 0, 1, 1, 0, 0 }, // S
			{ 1, 0, 1, 1, 1 }, // A 
			{ 1, 1, 0, 0, 1 }, // B
			{ 0, 1, 0, 0, 1 }, // C
			{ 0, 1, 1, 1, 0 }, // D
		//	{ 0, 0, 0, 1, 1 }  // D
			
		};
		/* Does comparison if edges contain 1 replace at the Adjacency Matrix */
		for(int row = 1; row < n; row++){
			for(int column = 1 ; column < n; column++){
				// Debuging -> System.out.print("Does " + matrix[0][row] + " connect with " + matrix[column][0] + "? ");
				// Debugin -> System.out.println("Value for edges[0][1]=" + edges[row-1][column-1]);
				if(edges[row-1][column-1] >= 1){
					matrix[row][column] = edges[row-1][column-1];
				}
			}
		}
		return matrix;
	}
	/* Print method to print any matrix */
	private static void printMatrix(int n, Object[][] emptyMatrix) {
		System.out.println("");
		for(int row = 0 ; row < n ; row ++){
			for(int column = 0; column < n; column++){
				System.out.print(emptyMatrix[row][column] + " ");	
			}
			System.out.println("");
		}
		System.out.println("");
	}

}
