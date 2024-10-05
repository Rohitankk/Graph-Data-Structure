import GraphDataStructure.List.MyList;
import GraphDataStructure.CreateGraph.Graph;
import GraphDataStructure.CreateGraph.NodesOfGraph;

import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner kbd = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("            GRAPH TRAVERSAL            ");
        System.out.println("=======================================");
        System.out.println(" ");
        execute();
    }
    public static void execute() {
        formatting();
        System.out.print("Enter the absolute path of the file you want to open: ");
        String path = kbd.nextLine();
        Graph graph = loadFile(path);
        while(true){
            System.out.println("=======================================");
            System.out.println("                  MENU                 ");
            System.out.println("---------------------------------------");
            System.out.println("1. Load graph data from file");
            System.out.println("2. Depth First Traversal");
            System.out.println("3. Breadth First Traversal");
            System.out.println("4. Shortest path to a vertex");
            System.out.println("5. Exit");
            System.out.println("---------------------------------------");
            System.out.print("Enter the number that corresponds to your choice: ");
            int choice = kbd.nextInt();
            System.out.println(" ");
            switch(choice){
                case 1:
                    formatting();
                    System.out.print("Enter the absolute path of the file you want to open: ");
                    path = kbd.nextLine();
                    graph = loadFile(path);
                    break;
                case 2:
                    System.out.println("=========================================");
                    System.out.println("Depth First Traversal");
                    System.out.println("=========================================");
                    System.out.print("Enter starting vertex: ");
                    NodesOfGraph src = graph.nodesData(kbd.next().charAt(0));
                    System.out.println("Nodes Traversed: ");
                    graph.DepthSearch(src);
                    break;
                case 3:
                    System.out.println("=========================================");
                    System.out.println("Breadth First Traversal");
                    System.out.println("=========================================");
                    System.out.print("Enter starting vertex: ");
                    src = graph.nodesData(kbd.next().charAt(0));
                    System.out.println("Nodes Traversed: ");
                    graph.BreadthSearch(src);
                    break;
                case 4:
                    System.out.println("---------------------------------------");
                    System.out.println("Shortest Path to Vertex");
                    System.out.println("---------------------------------------");
                    System.out.print("Enter starting vertex: ");
                    src = graph.nodesData(kbd.next().charAt(0));
                    MyList shortest = graph.performDjistra(src);
                    System.out.print("Enter the target: ");
                    src = graph.nodesData(kbd.next().charAt(0));
                    shortest.showListContent();
                    System.out.print("Path: ");
                    graph.revealPath(shortest,src);
                    break;
                case 5:
                    System.out.println("System terminated");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static Graph loadFile(String path) {
        Graph graph = new Graph<>();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String elements = br.readLine();
            String[] stringarray = elements.split(",");
            for (int i = 0; i < stringarray.length; i++) {
                graph.appendWeightedGNode(new NodesOfGraph<>(stringarray[i].charAt(0)));
            }
            while ((elements = br.readLine()) != null){
                stringarray = elements.split(",");
                graph.linkNodes(graph.nodesData(stringarray[0].charAt(0)),
                        graph.nodesData(stringarray[1].charAt(0)), Integer.parseInt(stringarray[2]));
            }
        } catch (IOException e) {
            System.out.println("Graph cannot be initialized from provided file");
        }
        return graph;
    }

    private static void formatting() {
        System.out.println("---------------------------------------");
        System.out.println("Format of File Content:");
        System.out.println("  * First line of file must contain all of the vertices of the graph with each separated" +
                "by a comma");
        System.out.println("  * The lines onwards contain the edges of the graph (from, to) and their corresponding " +
                "weight with each separated by a comma");
        System.out.println("Example of File Content: ");
        System.out.println("    A,B,C ");
        System.out.println("    A,B,15 ");
        System.out.println("    B,C,10 ");
        System.out.println("    C,A,20 ");
        System.out.println("---------------------------------------");
    }
}
