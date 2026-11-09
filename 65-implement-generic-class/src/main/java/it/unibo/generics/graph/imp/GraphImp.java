package it.unibo.generics.graph.imp;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import it.unibo.generics.graph.api.Graph;

public class GraphImp<N> implements Graph<N> {
    Map<N, Set<N>> graph = new HashMap<>();

    public void addNode(N node) {
        if (node != null && !graph.containsKey(node)) {
            graph.put(node, new HashSet<>());
        }
    }

    public void addEdge(N source, N target) {
       if(source != null && target != null) {
            addNode(source);
            addNode(target);
            Set<N> vicini = graph.get(source);
            vicini.add(target);
       }
    }

    public Set<N> nodeSet() {
        return graph.keySet();
    }

    public Set<N> linkedNodes(N node) {
        return graph.get(node);
    }

    public List<N> getPath(N source, N target) {
    if (source == null || target == null || !graph.containsKey(source)) {
        return null;
    }
    return findPath(source, target, new HashSet<>());
}

private List<N> findPath(N current, N target, Set<N> visited) {
    if (current.equals(target)) {
        List<N> path = new ArrayList<>();
        path.add(current);
        return path;
    }
    visited.add(current);
    for (N next : linkedNodes(current)) {
        if (!visited.contains(next)) {
            List<N> rest = findPath(next, target, visited);
            if (rest != null) {
                rest.add(0, current);
                return rest;
            }
        }
    }
    return null;
}
} 
