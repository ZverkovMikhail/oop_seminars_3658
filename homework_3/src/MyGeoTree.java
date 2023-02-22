import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MyGeoTree implements GeoTree {
    public List<Node> nodes = new ArrayList<>();
    public Set<People> peoples = new HashSet<>();

    public MyGeoTree(List<Node> nodes, Set<People> peoples) {
        this.nodes = nodes;
        this.peoples = peoples;
    }

    public MyGeoTree() {
    }

    public MyGeoTree appendMarried(People fm1, People fm2) {
        nodes.add(new MyNode(fm1.id(), fm2.id(), Relationship.married));
        nodes.add(new MyNode(fm2.id(), fm1.id(), Relationship.married));
        peoples.add(fm1);
        peoples.add(fm2);
        return this;
    }

    public MyGeoTree appendChild(People parent, People child) {
        MyNode temp;
        List<Node> children = nodes.stream().filter(node ->
                (node.firstId() == parent.id()) && (node.rel() == Relationship.child)
        ).toList();

        nodes.add(new MyNode(parent.id(), child.id(), Relationship.child));
        nodes.add(new MyNode(child.id(), parent.id(), Relationship.parent));
        for (Node node : children) {
            temp = new MyNode(child.id(), node.secondId(), Relationship.sibling);
            if (!nodes.contains(temp))
                nodes.add(temp);
        }

        peoples.add(parent);
        peoples.add(child);

        return this;
    }

    public List<Node> nodes(People fm) {

        return nodes.stream().filter(node -> (node.firstId() == fm.id())).toList();
    }

    public List<Node> nodes() {
        return nodes;
    }

    @Override
    public Set<People> getPeoples() {
        return peoples;
    }

    @Override
    public People getPeopleById(int id) {
        for (People p: peoples) {
            if (p.id() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public Set<People> find(PeopleFilter filter) {
        return peoples.stream().filter(
                filter::check).collect(Collectors.toSet()
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes)
            sb.append(node).append("\n");
        return sb.toString();
    }
}
