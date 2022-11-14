package gdi;

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
    
}
