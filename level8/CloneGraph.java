package com.dr.level8;

import java.util.*;

/*Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

*/
public class CloneGraph {


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode source) {

        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(source);

        // To keep track of all the nodes which have been created
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm =
                new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

        hm.put(source,new UndirectedGraphNode(source.label));

        while (!q.isEmpty()) {

            // For the node, visit all its neighbours
            UndirectedGraphNode u = q.poll();

            // Get corresponding Cloned Graph Node
            UndirectedGraphNode cloneNodeU = hm.get(u);
            if (u.neighbors != null) {
                List<UndirectedGraphNode> v = u.neighbors;
                for (UndirectedGraphNode graphNode : v) {
                    // Get the corresponding cloned node
                    // If the node is not cloned, returns null
                    UndirectedGraphNode cloneNodeG = hm.get(graphNode);

                    // If this node has already been created
                    if (cloneNodeG == null) {
                        q.add(graphNode);

                        // If not, create a new Node and
                        // put into the HashMap
                        cloneNodeG = new UndirectedGraphNode(graphNode.label);
                        hm.put(graphNode,cloneNodeG);
                    }

                    // add the 'cloneNodeG' to neighbour
                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }
        }

        // Return cloned source Node
        return hm.get(source);
    }

    // Build the desired graph
    public UndirectedGraphNode buildGraph() {
        /*
            Note : All the edges are Undirected
            Given Graph:
            1--2
            |  |
            4--3
        */
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        Vector<UndirectedGraphNode> v = new Vector<UndirectedGraphNode>();
        v.add(node2);
        v.add(node4);
        node1.neighbors = v;
        v = new Vector<UndirectedGraphNode>();
        v.add(node1);
        v.add(node3);
        node2.neighbors = v;
        v = new Vector<UndirectedGraphNode>();
        v.add(node2);
        v.add(node4);
        node3.neighbors = v;
        v = new Vector<UndirectedGraphNode>();
        v.add(node3);
        v.add(node1);
        node4.neighbors = v;
        return node1;
    }

    // BFS traversal of a graph to
    // check if the cloned graph is correct
    public void bfs(UndirectedGraphNode source)
    {
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(source);
        HashMap<UndirectedGraphNode,Boolean> visit =
                new HashMap<UndirectedGraphNode,Boolean>();
        visit.put(source,true);
        while (!q.isEmpty())
        {
            UndirectedGraphNode u = q.poll();
            System.out.println("Label of Node " + u.label);
            if (u.neighbors != null)
            {
                List<UndirectedGraphNode> v = u.neighbors;
                for (UndirectedGraphNode g : v)
                {
                    if (visit.get(g) == null)
                    {
                        q.add(g);
                        visit.put(g,true);
                    }
                }
            }
        }
        System.out.println();
    }



    public static void main(String args[]) {

        UndirectedGraphNode source = new CloneGraph().buildGraph();
        System.out.println("BFS traversal of a graph before cloning");
        new CloneGraph().bfs(source);
        UndirectedGraphNode newSource = new CloneGraph().cloneGraph(source);
        System.out.println("BFS traversal of a graph after cloning");
        new CloneGraph().bfs(newSource);
    }

    HashMap<UndirectedGraphNode,UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        return auxCloneGraph(node);
    }

    public UndirectedGraphNode auxCloneGraph(UndirectedGraphNode node){
        if(node==null)
            return node;
        if(map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode clone=new UndirectedGraphNode(node.label);
        map.put(node,clone);
        for(UndirectedGraphNode neighbor : node.neighbors){
            clone.neighbors.add(auxCloneGraph(neighbor));
        }
        return clone;
    }
}

/**
 * Definition for undirected graph.
 */
 class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
 }