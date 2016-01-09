# riddles-hopping
This is a riddle I came across:

![alt tag](https://raw.github.com/yaronma/riddles-hopping/master/images/original.jpg)

The solution is very simple and straightforward, but I wanted to solve it using automated algorithm. I also wanted to answer other questions, such as how many solutions are there? which one is the best? the worst?

# The Solution

In order to solve this riddle we will mark every dot with a unique number (regardless of dot color). 

This is the numbered dots version:

![alt tag](https://raw.github.com/yaronma/riddles-hopping/master/images/numbered.jpg)

If we assume the dots are vertexes on a graph and the connections between the dots are edges, we get a simple question of finding a path between two vertexes in an undirected graph. (When we build the graph we ignore connections between dots that have the same color)

In order to make things bit harder, I chose to implement this without using recursion.

The Graph and Edge implementaions are the most basic ones (I didn't implement deletion, for example) and have the bare functionality for answering this riddle.
