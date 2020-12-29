
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
 the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Nishaant Dhingra
Student Number: 217537739
Course Section: B
*/

package Assignment1;
import java.util.*;
import java.util.Random;

/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean [][] map; 
	private int row;
	private int column;
	/**
	 * This is the constructor that constructs the city map, 
	 * which is a grid of row by column.
	 * @param row is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		this.row = row;
		this.column = column;
		// Please implement the constructor
	}
	/**
	 * This method checks the correctness of the input parameters. If the preconditions are not met 
	 * an exception is thrown, otherwise depending to the direction, it calls 
	 * one of the four recursive functions of goSouthWest, goSouthEast, goNorthWest and goNorthEast.
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0, N) if N is the number of east-west streets and [0, M) if 
	 * M is the number of north-south streets.) 
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		if(startRow < 0 || startRow > this.row - 1 || startCol < 0 || startCol > this.column - 1 || 
				destRow < 0 || destRow > this.row-1 || destCol < 0 || destCol > this.column -1)  
		{
			throw new IllegalArgumentException("parameters provided are outside city grid");
		} 
		
		else {
			if(destRow >= startRow && destCol >= startCol) { 
				path = goNorthEast(startRow, startCol, destRow, destCol, path) + path;	 	
			}
			else if(destRow >= startRow && destCol<=startCol) {
				path = goNorthWest(startRow, startCol, destRow, destCol, path) + path;
			}
			else if(destRow <= startRow && destCol >= startRow) {
				path = goSouthEast(startRow, startCol, destRow, destCol, path) + path;
			}
			else if(destRow <= startRow && destCol <= startCol) {
				path = goSouthWest(startRow, startCol, destRow, destCol, path) + path;
			}
		}
		return path;
		 
	}
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point.  
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol >= destCol </code>
	 */
	
	private String goSouthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = "(" + destRow + "," + destCol + ") ";
		
		if(startRow == destRow && startCol == destCol) {
			path = " ";
		} 
		
		else {
			if(destRow != startRow) {													
				path = goSouthWest(startRow, startCol, destRow + 1, destCol, path) + path;
			}
		
			else if(destCol != startCol) {													
				path = goSouthWest(startRow, startCol, destRow, destCol + 1, path) + path;
			}
		
		}
		
		return path;   
	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goSouthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = "(" + destRow + "," + destCol + ") ";
		
		if(startRow == destRow && startCol == destCol) {
			path = " ";
		}
		
		else {
			if(destRow != startRow) {	
				path = goSouthEast(startRow, startCol, destRow + 1, destCol, path) + path;
			}
			else if(destCol != startCol) {
				path = goSouthEast(startRow, startCol, destRow, destCol - 1, path) + path;
			}
	
		}
		return path; 

	}
	
	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and <code> startCol >= destCol </code>
	 */
	private String goNorthEast (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = "(" + destRow + "," + destCol + ") ";
		
		if(startRow == destRow && startCol == destCol) {
			path = " ";
		}
		
		else {
			if(destRow != startRow) {
				path = goNorthEast(startRow, startCol, destRow - 1, destCol, path) + path;
			}
			else if(destCol != startCol) {
				path = goNorthEast(startRow, startCol, destRow, destCol - 1, path) + path;
			}
	 
		}
		return path; 

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the destination (destRow, destCol).
	 * Please note that the returning path does not include the starting point. 
	 * @param startRow is the starting row of the path 
	 * @param startCol is the starting column of the path
	 * @param destRow is the destination row
	 * @param destCol is the destination column
	 * @param path is the path that is constructed while the recursive method is called. In first round,  it will be "".
	 * @return returns a string representing the path to the destination. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and <code> startCol <= destCol </code>
	 */
	private String goNorthWest (int startRow, int startCol, int destRow, int destCol , String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here to avoid compiler error.
		path = "(" + destRow + "," + destCol + ") ";
		
		if(startRow == destRow && startCol == destCol) {
			path = " ";
		}
		
		else {
			if(destRow != startRow) {
			path = goNorthWest(startRow, startCol, destRow - 1, destCol, path) + path;
			}
			else if(destCol != startCol) {
				path = goNorthWest(startRow, startCol, destRow, destCol + 1, path) + path; 
			}
		}
		return path; 
	}
	
	/**
	 * This method generates a newPoint randomly by giving a direction to the (startRow, startCol) and incrementing them accordingly.
	 * It then adds the new point generated into the ArrayList policeLocations.
	 * @param startRow
	 * @param startCol
	 * @return it return the new point that is generated in the form (startRow, startCol)
	 */
	
	
	public List<Integer> getNewPoint(int startRow, int startCol) { 
		Random random = new Random();
		char[] directions = {'n', 's', 'e', 'w'};
		int choice = random.nextInt(directions.length);	
		if (directions[choice] == 'n') {
			startRow += 1;
		} 
		else if (directions[choice] == 's') {
			startRow -= 1;
		}
		else if (directions[choice] == 'e') {
			startCol += 1;
		}
		else if (directions[choice] == 'w') {
			startCol -= 1;
	    }
			
		List<Integer> newPoints = new ArrayList<>();		
		newPoints.add(startRow);							//adding newly generated row from a random direction to ArrayList newPoints.
		newPoints.add(startCol);							//adding newly generated column from a random direction to ArrayList newPoints.
		
		return newPoints;  
	}
	
	/**
	 * this method checks if startRow or startCol is on border of the city grid or not.
	 * @param startRow
	 * @param startCol
	 * @return it returns true if the point is on the border and false otherwise.
	 */
	
	public boolean checkBorder(int startRow, int startCol) {
		// Check if point is at border and return TRUE or FALSE
		if (startRow == this.row - 1 || startRow == 0 || startCol == this.column - 1 || startCol == 0) {
			return true;
		}
		return false; 
	}
	
	/**
	 * This method checks if string newPoint is contained in the ArrayList policeLocations.
	 * @param newPoint
	 * @param policeLocations
	 * @return it returns true if the point is in ArrayList policeLocations  and false otherwise
	 */
	
	public boolean pointInPoliceLocations(String newPoint, ArrayList<String> policeLocations) {
		// If new point for car is already in police locations, return True -> restart game
		if (policeLocations.contains(newPoint)) {
			return true;
		}
		return false; 
	}
	
	/**
	 * This method find a path from (startRow, startCol) to a border point of the city. 
	 * Please note that the starting point should be included in the path.
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */
	public String findPath (int startRow, int startCol) { 	
		int originalRow = startRow;
		int originalCol = startCol;
		String finalCarPath = "";
		ArrayList<String> policeLocations = new ArrayList<String>();
		String carPath = "(" + startRow + "," + startCol + ")";
		policeLocations.add(carPath);
		 
		while (!checkBorder(startRow, startCol)) {
			List<Integer> newPoints = getNewPoint(startRow, startCol);
			String newPointString = "(" + newPoints.get(0) + "," + newPoints.get(1) + ")";
			if (pointInPoliceLocations(newPointString, policeLocations)) {
				// restarting the position of self driving car
				finalCarPath = findPath(originalRow, originalCol); 
				break;													//using break to cut recursion 
			} 
			else {
				startRow = newPoints.get(0);
				startCol = newPoints.get(1);
				policeLocations.add(newPointString);
			} 
		}
		
		
		// concatenating points in String finalCarPath using a for-each loop in ArrayList policeLocations
		if(finalCarPath.isEmpty()) {
			for(String point : policeLocations) { 
				finalCarPath += point + " ";
		}
		
		}
		return finalCarPath.trim(); 


	}
}//end of class

