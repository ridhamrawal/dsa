
class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        // If already cloned, return the clone
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create a new cloned node
        Node clone = new Node(node.val);

        // Store original -> cloned node mapping
        map.put(node, clone);

        // Clone all neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
