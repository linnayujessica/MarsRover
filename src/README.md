# Project: Robotic Rovers​
This project is aimed to help NASA to implement her "Mars Rover technical Challenge" to achieve robotic rovers.

I assume that all commands from NASA are written in a file called **test.properties** under resources folder which NASA can edit as they like easily.

## Get started

This instruction can tell you how to run this project on your local machine for development and testing purposes.

### Prerequisites

* Java IDE e.g.Eclipse, IntelliJ
* any version of the JDK

## Running and testing

First, let's demonstrate what does each line in **test.properties** file represent:

> The first line means the upper​ right coordinates of the plateau that the rover is in, the lower ​left coordinates are assumed to be (0,0), those **two pairs of coordinates** restrict the area rovers move.

> And then, the rest of lines are information showing rovers that are going to do the movement. Each rover has two lines of input. 
* The first line gives the rover's position, the position is made up of two integers and a letter separated by spaces, corresponding to the **(x,y) co​ordinates and the rover's orientation** - one of the four cardinal compass points.
* The second line is a series of instructions telling the rover how to move around the plateau. **L** means The output for each rover should be its final co-ordinates and heading. spin 90 degrees left, **R** means rovers spin 90 degrees right, **M** means moving forward one grid point and maintain the same heading.

To run the project, 

> Create a Java project in your IDE

> Expand the project in Package Explorer and click on the **src** folder

> Right-click on the **src** folder and Select **Import…**

> In the Import dialog, expand **General** and select **Archive File**. Click **Next**

> Browse for the JAR file that you want to import and click **Open**

> Open **RoverMovement.java** under practice folder and right_click to select **Run As** and then select **Java Application**

> Finally, output will be displayed in Console below, for each rover, the output should be its final coordinates and heading.

> Modify **test.properties** as the criteria above to see different test results







