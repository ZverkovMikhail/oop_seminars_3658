package Task1;

import java.util.ArrayList;
import java.util.List;

public class GeoTree {
    private ArrayList<Node> nodes = new ArrayList<>();

    public GeoTree appendMarried(FamilyMember fm1, FamilyMember fm2) {
        nodes.add(new Node(fm1, fm2, Relationship.married));
        nodes.add(new Node(fm2, fm1, Relationship.married));
        return this;
    }
    public GeoTree appendChild(FamilyMember parent, FamilyMember child) {
        Node temp;
        List<Node> children = nodes.stream().filter(node ->
                (node.fm1().equals(parent)) && (node.rel() == Relationship.child)
        ).toList();

        nodes.add(new Node(parent, child, Relationship.child));
        nodes.add(new Node(child, parent, Relationship.parent));
        for (Node node : children) {
            temp = new Node(child, node.fm2(), Relationship.sibling);
            if(!nodes.contains(temp))
                nodes.add(temp);
        }
        return this;
    }

    public List<Node> nodes(FamilyMember fm) {

        return nodes.stream().filter(node -> ((node.fm1().equals(fm)))).toList();
    }

    public ArrayList<Node> nodes() {
        return nodes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Node node: nodes)
            sb.append(node).append("\n");
        return sb.toString();
    }
}
