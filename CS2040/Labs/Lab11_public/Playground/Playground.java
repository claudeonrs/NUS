/**
 * Name : Claudeon Reinard Susanto
 * Matric. No : A0239079R
 */

import java.util.*;
import java.io.*;

class Vertex {
    boolean isFinalized;
    int id;
    long distance;
    ArrayList<Vertex> neighbours = new ArrayList<>();
    HashMap<Vertex, Integer> edgeWeights = new HashMap<>(); // to store edge weights

    Vertex(int id) {
        this.id = id;
    }

}

class Dummy {
    int id;
    long distance;
    Dummy(int id, long distance) {
        this.id=id;
        this.distance=distance;
    }
}

class DummyComparator implements Comparator<Dummy> {
    // for min heap
    public int compare(Dummy v1, Dummy v2) {
        if (v1.distance < v2.distance) {
            return -1;
        } else if (v1.distance > v2.distance) {
            return 1;
        }
        return 0;
    }
}

public class Playground {
    // set .distance attributes for all vertices
    public static long[] findDistances(int src, Vertex[] vertices) {

        long[] shortestDistances = new long[vertices.length];
        // initialization
        for (int i=1; i<vertices.length; i++) {
            shortestDistances[i] = Integer.MAX_VALUE;
        }
        shortestDistances[src] = 0;

        // min heap to store vertices
        DummyComparator comp = new DummyComparator();
        PriorityQueue<Dummy> pq = new PriorityQueue<>(comp);
        pq.offer(new Dummy(src, 0));

        while (!pq.isEmpty()) {
            Dummy dummy = pq.poll();
            if (dummy.distance == shortestDistances[dummy.id]) {
                for (Vertex neighbour: vertices[dummy.id].neighbours) {
                    int cost = vertices[dummy.id].edgeWeights.get(neighbour);
                    if (shortestDistances[neighbour.id] > shortestDistances[dummy.id] + cost) {
                        shortestDistances[neighbour.id] = shortestDistances[dummy.id] + cost;
                        pq.offer(new Dummy(neighbour.id, shortestDistances[neighbour.id]));
                    }
                }
            }
        }



        return shortestDistances;

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] words = br.readLine().split(" ");
        int numVertices = Integer.parseInt(words[0]);
        int numEdges = Integer.parseInt(words[1]);
        int numFriends = Integer.parseInt(words[2]);

        Vertex[] vertices = new Vertex[numVertices+1];
        for (int v=0; v<=numVertices; v++) {
            vertices[v] = new Vertex(v);
        }

        words = br.readLine().split(" ");
        int timmy = Integer.parseInt(words[0]);
        int tunnelStart = Integer.parseInt(words[1]);
        int tunnelEnd = Integer.parseInt(words[2]);

        for (int e=0; e<numEdges; e++) {
            words = br.readLine().split(" ");

            int edgeStart = Integer.parseInt(words[0]);
            int edgeEnd = Integer.parseInt(words[1]);
            int edgeWeight = Integer.parseInt(words[2]);
            Vertex vertexStart = vertices[edgeStart];
            Vertex vertexEnd = vertices[edgeEnd];

            // add to each vertex's neighbours
            vertexStart.neighbours.add(vertexEnd);
            vertexEnd.neighbours.add(vertexStart);

            // add edge weight to weights HashMap
            vertexStart.edgeWeights.put(vertexEnd, edgeWeight);
            vertexEnd.edgeWeights.put(vertexStart, edgeWeight);
        }

        int[] friends = new int[numFriends];
        for (int f=0; f<numFriends; f++) {
            friends[f] = Integer.parseInt(br.readLine());
        }

        long[] distFromTimmy = findDistances(timmy, vertices);
        long[] distFromTunnelStart = findDistances(tunnelStart, vertices);
        long[] distFromTunnelEnd = findDistances(tunnelEnd, vertices);

        long[] distWithTunnel = new long[numVertices+1];
        long tunnelLength = vertices[tunnelStart].edgeWeights.get(vertices[tunnelEnd]);
        for (int i=1; i<=numVertices; i++) {
            long distFromStart = distFromTimmy[tunnelStart] + tunnelLength + distFromTunnelEnd[i];
            long distFromEnd = distFromTimmy[tunnelEnd] + tunnelLength + distFromTunnelStart[i];
            distWithTunnel[i] = (distFromStart < distFromEnd) ? distFromStart : distFromEnd;
        }

        //int timmyToTunnelStart = distFromTimmy[tunnelStart].distance;
        //int timmyToTunnelEnd = [tunnelEnd].distance;
        //int timmyToTunnel = (timmyToTunnelStart > timmyToTunnelEnd)

        //for (int i=1; i<=numVertices; i++) {
        //    pw.println(vertices[i].distance);
        //}

        PriorityQueue<Integer> output = new PriorityQueue<>();
        for (int i=0; i<numFriends; i++) {
            int friend = friends[i];
            if (distWithTunnel[friend] == distFromTimmy[friend]) {
                output.offer(friend);
            }
        }

        //pw.println(tunnelStartDist);
        //pw.println(tunnelEndDist);

        while (output.size() > 0) {
            pw.print(output.poll());
            if (output.size() > 0) {
                pw.print(" ");
            }
        }
        pw.println();

        pw.close();
        br.close();

    }
}
