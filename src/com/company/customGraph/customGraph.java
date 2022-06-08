package com.company.customGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*

This is a representation of a graph using adjacency list.

Link to the source:

https://www.geeksforgeeks.org/implementing-generic-graph-in-java/

 */

public class customGraph<T> {

    /*
        With the map here, we store all new vertexes in a map
     */
    private Map<T, List<T>> adjList = new HashMap<>();

    /*
        Here we are adding new nodes to the adjList, with an empty Linked list representing the edges this node may contain
     */
    public void addVertex(T input){
        adjList.put(input, new LinkedList<T>());
    }

    /*
        This method adds the edges to two nodes. We take in the
     */
    public void addEdge(T source, T destination, boolean bidirectional){

        /*
            Remeber that maps are Key -> Value pairs

            So we check to see if the adj contains vertrexes
         */

        if(!adjList.containsKey(source))
            addVertex(source);

        if(!adjList.containsKey(destination))
            addVertex(destination);

        adjList.get(source).add(destination);
        if(bidirectional){
            adjList.get(destination).add(source);
        }

    }

    public void getVertexCount(){
        System.out.println("The graph has " + adjList.keySet().size() + " vertex");
    }

    public void getEdgesCount(boolean bidirectional){
        int count = 0;
        for(T v : adjList.keySet()){
            count += adjList.get(v).size();
        }
        if(bidirectional){
            count = count / 2;
        }
        System.out.println("The graph has " + count + " edges.");
    }

    public void hasVertex(T s){
        if(adjList.containsKey(s)){
            System.out.println("The graph contains " + s + " as a vertex.");
        }else{
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    public void hasEdge(T s, T d){
        if (adjList.get(s).contains(d)) {
            System.out.println("The graph has an edge between "
                    + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between "
                    + s + " and " + d + ".");
        }
    }

    // Prints the adjancency list of each vertex.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (T v : adjList.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : adjList.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }


}
