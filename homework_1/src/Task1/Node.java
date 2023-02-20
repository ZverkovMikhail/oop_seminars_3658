package Task1;

import java.util.Objects;

public class Node {
private FamilyMember fm1;
private FamilyMember fm2;
private Relationship rel;

    public Node(FamilyMember fm1, FamilyMember fm2, Relationship rel) {
        this.fm1 = fm1;
        this.fm2 = fm2;
        this.rel = rel;
    }

    public FamilyMember fm1() {
        return fm1;
    }

    public FamilyMember fm2() {
        return fm2;
    }

    public Relationship rel() {
        return rel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(fm1, node.fm1) && Objects.equals(fm2, node.fm2) && rel == node.rel;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", fm1, rel, fm2);
    }
}
