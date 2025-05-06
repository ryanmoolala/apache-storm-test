# Apache Storm Test Project

This is a simple Apache Storm topology project that demonstrates the usage of spouts and bolts.

## Project Structure

- **src/main/java/test/storm/Main.java**: Sets up the topology, connects the spout and bolts, and runs the topology.
- **src/main/java/test/storm/RandomNumberSpout.java**: (Assumed) A spout that emits random numbers.
- **src/main/java/test/storm/FilterBolt.java**: A bolt that filters even numbers.
- **src/main/java/test/storm/PrintBolt.java**: (Assumed) A bolt that prints the tuples.

## How to Run

1. Make sure you have Apache Storm and all necessary dependencies installed.
2. Compile the project.
3. Run the `Main.java` file to start the topology.
4. The topology will run indefinitely (or for 60 seconds if using `Thread.sleep(60000)`), printing output to the console.

## Notes

- Modify the topology runtime and logic as needed.
- Ensure that you handle all necessary exception cases as required.
