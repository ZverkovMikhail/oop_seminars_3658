import java.util.Objects;

public abstract class Node implements Comparable<Node>{
    private int firstId;
    private int secondId;
    private Relationship rel;

    public Node(int firstId, int secondId, Relationship rel) {
        this.firstId = firstId;
        this.secondId = secondId;
        this.rel = rel;
    }

    public int firstId() {
        return firstId;
    }

    public int secondId() {
        return secondId;
    }

    public Relationship rel() {
        return rel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(firstId, node.firstId) && Objects.equals(secondId, node.secondId) && rel == node.rel;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", firstId, rel, secondId);
    }
}
