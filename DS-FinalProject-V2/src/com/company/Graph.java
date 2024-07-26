package com.company;

import java.util.*;

// baraye hashing araye adjancy ro mod 16 vertix dar nazar begir ama felan na
// dfs moshkel dare
public class Graph {

    public int vertices;
    public ArrayList[] adjacencylist ;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new ArrayList[vertices+5];
        for (int i = 0; i < vertices+5 ; i++) {

            adjacencylist[i] = new ArrayList<Edge>();
        }
    }
    public void setVertices(){
        this.vertices++;
    }

    public void addEgde(int source, int destination, int weight) {

        adjacencylist[source].add(new Edge(source, destination, weight));
        adjacencylist[destination].add(new Edge(destination, source, weight));
        // adjacencylist[source].add(destination);
    }

    public void removeEdge(int s){
        for(int i=0;i<vertices;i++){
           /* for(Edge e : adjacencylist[i].get){
                if(e.getDestination()==s || e.getSource()==s){
                    adjacencylist[i].remove(e);
                }
            }*/
            ListIterator<Edge> itr = adjacencylist[i].listIterator();
            while (itr.hasNext()) {
                if (itr.next().getSource()==s || itr.next().getDestination()==s) {
                    itr.remove();
                    break;
                }
            }
        }

    }


   /* public  void removeEdge (int dest ){
        for (int i = 0; i < vertices; i++) {
           /* for( new Edge e : adjacencylist[i])
                if(dest == e.getDestination())
                    adjacencylist[i].remove(e);
        }
            Iterator<Edge> it = adjacencylist[i].iterator();
            while (it.hasNext()){
            if(dest == it.getDestination())
                adjacencylist[i].remove(it);
            }
        }

    }*/


    public void printGraph(){
        for (int i = 0; i <vertices ; i++) {
            ArrayList<Edge> list = adjacencylist[i];
            for (int j = 0; j <list.size() ; j++) {
                System.out.println("vertex-" + i + " is connected to " +
                        list.get(j).destination + " with weight " + list.get(j).weight);
            }
        }

    }
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Edge> i = adjacencylist[v].listIterator();
        while (i.hasNext()) {
            Edge n =  i.next();
            if (!visited[n.getDestination()])
                DFSUtil(n.getDestination(), visited);
        }
    }

    void DFS(int v) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(v, visited);
    }

   /*public void dfsWithoutRecursion(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[vertices];
        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!isVisited[current]) {
                isVisited[current] = true;
                System.out.print(current + " ");
                ListIterator i = adjacencylist[current].listIterator();
                while (i.hasNext()) {
                    Object n =  i.next();
                    if (!isVisited[(int)n])
                        stack.push((int)n);
                }
            }
        }
    }*/
}
