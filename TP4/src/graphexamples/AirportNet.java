package graphexamples;

import graphbase.Edge;
import graphbase.Graph;

import static graphbase.GraphAlgorithms.DepthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DEI-ESINF
 */

public class AirportNet {

    private Graph<String, Integer> airport;

    public AirportNet() {
        airport = new Graph<>(true);
    }

    public void addAirport(String a) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addRoute(String a1, String a2, double miles, Integer npasseng) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int keyAirport(String airp) {
        return airport.getKey(airp);
    }

    public String airportbyKey(int key) {
        String[] keysairport = airport.allkeyVerts();

        if (key < 0 || key >= keysairport.length) {
            return null;
        }

        return keysairport[key];
    }

    public Integer trafficAirports(String airp1, String airp2) {
        Edge<String, Integer> edge1 = airport.getEdge(airp1, airp2);
        if (edge1 == null)
            return null;

        return edge1.getElement();
    }

    public Double milesAirports(String airp1, String airp2) {
        Edge<String, Integer> edge1 = airport.getEdge(airp1, airp2);
        if (edge1 == null)
            return null;

        return edge1.getWeight();
    }

    public String nroutesAirport() {
        String routesAirp = "";

        for (String airp : airport.vertices()) { //Evitar usar esta estrutura
            int grau = airport.outDegree(airp) + airport.inDegree(airp);
            routesAirp += airp + " " + grau + "\n";
        }

        return routesAirp;
    }

    public String AirpMaxMiles() {
        String airpMaxMiles = "";
        String vDest = "";
        double maxMiles = 0;
        for (String airp : airport.vertices()) {
            for (Edge<String, Integer> edge : airport.outgoingEdges(airp)) {
                vDest = edge.getVDest();
                if (maxMiles == edge.getWeight())
                    airpMaxMiles += airp + " " + vDest + "\n";

                if (maxMiles < edge.getWeight()) {
                    maxMiles = edge.getWeight();
                    airpMaxMiles = "";
                    airpMaxMiles += airp + " " + vDest + "\n";
                }
            }
        }
        return airpMaxMiles;
    }

    public Boolean ConnectAirports(String airp1, String airp2) {
        LinkedList<String> qairps = DepthFirstSearch(airport, airp1);

        for (String airp : qairps) {
            if (airport.equals(qairps)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return airport.toString();
    }
}
