package lab5_6;

public class adjacencyMatrices {
	public static Object[][] matrix;
	
	public static Object[][] buildMatrix(int n) {
		/* Creates empty matrix */
		matrix = new Object [n][n];
		for(int row = 0 ; row < n ; row ++){
			
			for(int column = 0; column < n; column++){
				matrix[row][column] = 0;	
			}
		}
		return matrix;
		
	}		
}

