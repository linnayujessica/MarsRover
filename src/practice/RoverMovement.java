package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import exeption.InvalidCoordinatesException;
import exeption.InvalidPlateauException;

public class RoverMovement {
	
	private static final String[] directions = new String[]{"N", "S", "E", "W"};
	
	public static void main(String[] args) throws Exception {		 
		InputStream stream = RoverMovement.class.getResourceAsStream("/resources/test.properties");			    
		String line = new String();			    	    
		Coordinates coord = null;
		int maxX = 0, maxY = 0;	
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {	
			int i = 0;
			while((line = reader.readLine()) != null) {
				if (!line.isEmpty()) {
					if (i == 0) {
						// upper​ right coordinates of plateau: maximum of x y coordinates
						if(!isNumeric(line.split("\\s+")[0]) || !isNumeric(line.split("\\s+")[1]) ||
								Integer.valueOf(line.split("\\s+")[0]) < 0 ||
								Integer.valueOf(line.split("\\s+")[1]) < 0) {
							throw new InvalidPlateauException("Upper right coordinates of plateau is invalid.");	            		
	            		} else {
	            			maxX = Integer.valueOf(line.split("\\s+")[0]); 
			            	maxY = Integer.valueOf(line.split("\\s+")[1]); 
	            		}		            		
		            } else if (i%2 != 0) { 
		            	// odd line is rover's position
		            	if(!isNumeric(line.split("\\s+")[0]) || !isNumeric(line.split("\\s+")[1])) {
		            		throw new InvalidCoordinatesException("Rover's coordinates is invalid.");	
		            	}
		                int x = Integer.valueOf(line.split("\\s+")[0]);
		                int y = Integer.valueOf(line.split("\\s+")[1]);
		                String dir = line.split("\\s+")[2];	                	
		                if(!Arrays.asList(directions).contains(dir)){
		                	throw new InvalidCoordinatesException("Rover's orientation is invalid.");		                		
		                } else if(x > maxX || x < 0 || y > maxY || y < 0) {
		                	throw new InvalidCoordinatesException("Rover's coordinates is over boundary "
		                			+ "of plateau: (0 0) and (" + maxX + " " + maxY + ")");
		                } else {
		                	coord = new Coordinates(x, y, Direction.valueOf(dir));		                
		                }
		            } else { 
		                // even line is steps array rovers how to move		                	
		                String[] steps = line.split("");
		                movementCalculate(coord, steps, maxX, maxY);		                
		                System.out.println(coord.x + " " + coord.y + " " + coord.d.toString());	                	
		                // initialize a new Coordinates for next rover
		                coord = new Coordinates();
		            }
					i++;
	            }	            	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	                
	 }
	 
	 private static void movementCalculate(Coordinates coords, String[] steps, int maxX, int maxY) {
		for(String step : Arrays.asList(steps)) {
			if (step.equals("L")) {
				switch(coords.d) {
					case N:
						coords.d = Direction.W;
						break;
					case S:
						coords.d = Direction.E;
						break;
					case W:
						coords.d = Direction.S;
						break;
					case E:
						coords.d = Direction.N;
						break;
					default:
						break;				
				}
			}
			if (step.equals("R")) {
				switch(coords.d) {
					case N:
						coords.d = Direction.E;
						break;
					case S:
						coords.d = Direction.W;
						break;
					case W:
						coords.d = Direction.N;
						break;
					case E:
						coords.d = Direction.S;
						break;
					default:
						break;				
				}
			}
			// caution: steps cannot be over the boundary of plateau
			if (step.equals("M")) {
				switch(coords.d) {
					case N:
						coords.y = coords.y+1 > maxY ? maxY : coords.y+1;
						break;
					case S:
						coords.y = coords.y-1 < 0 ? 0 : coords.y-1;						
						break;
					case W:
						coords.x = coords.x-1  < 0 ? 0 : coords.x-1;
						break;
					case E:
						coords.x = coords.x+1 > maxX ? maxX : coords.x+1;
						break;
					default:
						break;				
				}
			}		
		}
		
	 }
	 
	private static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
}