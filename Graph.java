package leetcode;
import java.util.*;

public class Graph<I extends Number> {

    private List<Edge<Integer>> allEdges;

    private Map<Long,Vertex<Integer>> allVertex;

    boolean isDirected = false;

    public Graph(boolean isDirected){

        allEdges = new ArrayList<Edge<Integer>>();
        allVertex = new HashMap<Long,Vertex<Integer>>();
        this.isDirected = isDirected;

    }

    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }
    public void addEdge(long id1,long id2, int weight){
        Vertex<Integer> vertex1 = null;

        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new Vertex<Integer>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<Integer> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new Vertex<Integer>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<Integer> edge = new Edge<Integer>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }
    }

    public Collection<Vertex<Integer>> getAllVertex(){
        return allVertex.values();
    }
}
