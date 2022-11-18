package gdi;

import java.util.*;

public class Graph {

    String[] vertices;
    Integer[][] edges;
    
    void addVertex(String label) {
        String[] array = vertices;
        vertices = new String[vertices.length + 1];
        
        for (int i = 0; i < array.length; i++) {
            vertices[i] = array[i];
        }
        
        vertices[vertices.length - 1] = label;
        
        Integer[][] oldEdges = edges;
        edges = new Integer[vertices.length][vertices.length];
        
        for(int i = 0; i < oldEdges.length; i++) {
            for(int j = 0; j < oldEdges.length; j++) {
                edges[i][j] = oldEdges[i][j];
            }
        }
    }
    
    void addEdge(String a, String b, int value) {
        edges[getVertex(a)][getVertex(b)] = value;
    }
    
    int getVertex(String label) {
        for(int i=0; i< vertices.length; i++) {
            if(vertices[i].equals(label)) return i;
        } 
        return -1;
    }
    
    void removeEdge(String a, String b) {
        edges[getVertex(a)][getVertex(b)] = null;
    }
    
    String depthFirstSearch(String start) {
        return dfs(getVertex(start),new List());
    }
    
    String dfs(int current, List used) {
        if(used.contains(current)) {
            return "";
        }
        used.add(current);
        String result = vertices[current];
        int[] next = getNextVertices(current);
        for(int i = 0; i<next.length;i++) {
            result = result + dfs(next[i],used);
        }
        return result;
    }
    
    int[] getNextVertices(int vertex) {
       int size = 0;
        for(int i = 0; i<edges.length; i++) {
           if(edges[vertex][i]!= null) {
               size++;
           }
       } 
       int[] result = new int[size];
       int index = 0;
       for(int i = 0; i<edges.length; i++) {
           if(edges[vertex][i]!= null) {
               result[index] = i;
               index++;
           }
       } 
       return result;
       
    }
    
    String breadthFirstSearch(String start) {
        List used = new List();
        Queue<Integer> queue = new LinkedList<>();
        int current = getVertex(start);
        queue.offer(current);
        used.add(current);
        String result = "";
        while(!queue.isEmpty()) {
            current = queue.poll();
            result = result + vertices[current];
            int[] next = getNextVertices(current);
            for(int i = 0; i < next.length; i++) {
                if(!used.contains(next[i])) {
                    queue.offer(next[i]);
                }
            }
        }
        return result;
    }
    
}
