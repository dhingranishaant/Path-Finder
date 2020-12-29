A city is laid out as a rectangular grid, where the first intersection at bottom left is identified as (0,0) and the top right intersection as (n-1, m-1). 
Imagine a self driving car, which is left at a random intersection, is given the instruction to drive to a particular intersection. The car should be able to find the shortest path from the source intersection to the destination intersection. It is assumed that intersections have an equal distance from each other.

One of the basic strategies that it uses, is to choose a path that intuitively seems correct. With this strategy, if the destination is on the west, a path that goes to the east should not be chosen. If the destination is on the south, the path that goes to the north should not be chosen.

Task performed in this code :-

Task 1
  Implementing the constructor to build a city grid / construct the map of the city 
  
Task 2
  Writing a recursive method that returns a path from a source to a destination. Note that the starting and stopping intersection is given as the input       
  parameter.
  
  sample input: 5,5, 4, 1, " "
  one sample Expected output: (4,5) (4,4) (4,3) (4,2) (4,1)
  
Task 3
A client (i.e. a self driving car) cannot use these methods for directions since they have to be private. So in this third task, need to implement getPath method, which has two responsibilities. The first responsibility is to check if all the inputs are valid. If it was not valid, then this method should issue an IllegalArgumentException. It is our job to figure out what a valid input means.

  The second job of this function is to decide in which direction the car should travel ( i.e. south-west, south-east, north-west or north-east). It should       call   one of the four methods that you have just implemented, depending on the direction that the car is moving. This method is not a recursive method.

Task 5
  Bonus task ( implemented for complexity in code )
  Suppose that a police car is chasing the self-deriving car. The car wants to get out of the city map (i.e. the grid). We know that our police are capable       enough to catch the car ultimately, so we let the self- driving car to be adventurous for a while before the police car stops it. Whenever the car passes an   intersection, a police car is deployed at that intersection. This means that the car cannot pass an intersection for the second time, otherwise it will be     caught by the police. So, as long as the car does not pass an intersection more than once, it can travel to any direction to finally get out of the city. 

As the car starts to travel, it chooses the next intersection randomly. That is why the car may get caught by the police. If the car is caught by the police, the game resets and starts over. The car is positioned at its original place, where it starts to randomly choose a path out of the city.
Job for this problem is to implement the following method that takes in the intersection number and produces a path out of the city. If the car was caught by the police, the method should start over and keep doing this until it finds a path out.
