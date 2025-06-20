class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If node already cloned, return it
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Clone the current node (without neighbors for now)
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Recursively clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
