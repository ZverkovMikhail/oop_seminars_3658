import java.util.ArrayList;
import java.util.List;

public class MyGeoTree implements GeoTree{
    private List<Node> nodes = new ArrayList<>();

    public MyGeoTree appendMarried(People fm1, People fm2) {
        nodes.add(new MyNode(fm1, fm2, Relationship.married));
        nodes.add(new MyNode(fm2, fm1, Relationship.married));
        return this;
    }
    public MyGeoTree appendChild(People parent, People child) {
        MyNode temp;
        List<Node> children = nodes.stream().filter(node ->
                (node.fm1().equals(parent)) && (node.rel() == Relationship.child)
        ).toList();

        nodes.add(new MyNode(parent, child, Relationship.child));
        nodes.add(new MyNode(child, parent, Relationship.parent));
        for (Node node : children) {
            temp = new MyNode(child, node.fm2(), Relationship.sibling);
            if(!nodes.contains(temp))
                nodes.add(temp);
        }
        return this;
    }

    public List<Node> nodes(People fm) {

        return nodes.stream().filter(node -> ((node.fm1().equals(fm)))).toList();
    }

    public List<Node> nodes() {
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
