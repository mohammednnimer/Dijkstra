
# Dijkstra Algorithm GUI

This project implements a graphical user interface (GUI) for a **Dijkstra Algorithm** solution that calculates the shortest path between nodes in a graph. The application is built using **JavaFX** and is designed for solving real-world navigation or optimization problems by computing the shortest paths based on various factors such as distance, cost, or time.

## Overview

The **Dijkstra Algorithm** is a well-known algorithm used for finding the shortest path between nodes in a graph, which may represent, for example, road networks, flight paths, or other types of connections. In this project, the user can select a source node and a target node from a list of vertices (representing locations), and the application will calculate and display the shortest path based on the selected metric.

### Key Features:
- **Graphical User Interface (GUI)**: Built using JavaFX to provide an intuitive and interactive way to use the algorithm.
- **Dynamic Graph Visualization**: Nodes and edges are visualized on a map, and the shortest path is highlighted.
- **Multiple Path Metrics**: Users can choose between different metrics (distance, cost, time) for calculating the shortest path.
- **Interactive Selection**: Users can select the source and target vertices via radio buttons, and the shortest path is dynamically calculated and displayed.
- **Real-time Updates**: The GUI updates in real-time as users make selections or change settings.

## Requirements

To run this project, you need the following:
- **Java Development Kit (JDK)** version 8 or higher.
- **JavaFX Library**: Ensure that the JavaFX library is included in the classpath.

## Running the Project

1. Clone the repository to your local machine.
2. Ensure that **JavaFX** is properly configured in your development environment.
3. Compile and run the application using your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
4. The application will load a map image and display interactive controls to select the source and target locations.
5. Upon selecting the source and target, the algorithm will compute the shortest path based on the chosen metric and display the result.

## File Format

The project accepts a file containing the graph data. The file should be formatted as follows:
- The first line contains two integers: the number of vertices and the number of edges.
- Each vertex is described on a new line with the format: `VertexName Latitude Longitude`.
- Each edge is described on a new line with the format: `SourceVertex TargetVertex Cost Time Distance`.

The program reads this data and generates the graph for use in the algorithm.

## How It Works

1. **Load the Graph Data**: The program loads vertices and edges from the file and creates a graphical representation.
2. **User Interaction**: Users select the source and target vertices.
3. **Dijkstra's Algorithm**: The algorithm calculates the shortest path from the source to the target vertex based on the selected metric (cost, time, or distance).
4. **Display Results**: The shortest path is displayed, and key metrics such as the total cost, time, and distance are shown.

## Example of Usage

1. Launch the application and load the graph file.
2. Select the **Source** and **Target** locations.
3. Choose the **Metric** (Distance, Cost, or Time) for the path calculation.
4. Click **Run** to calculate the shortest path, which will be displayed along with the path details (distance, time, cost).

## Contributing

Contributions to this project are welcome! If you'd like to improve the functionality, fix bugs, or add new features, feel free to fork the repository and submit a pull request.



![Screenshot 2025-04-09 141923](https://github.com/user-attachments/assets/c8e75d53-2523-4e28-9514-7cc3abf1a99c)

