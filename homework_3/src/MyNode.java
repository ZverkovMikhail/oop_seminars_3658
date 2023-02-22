public class MyNode extends Node {
    public MyNode(int firstId, int secondId, Relationship rel) {
        super(firstId, secondId, rel);
    }

    @Override
    public int compareTo(Node o) {
        if (this.firstId() == o.firstId()) {
            if (this.secondId() < o.secondId()) {
                return -1;
            } else if (this.secondId() > o.secondId()) {
                return 1;
            }
        } else {
            if (this.firstId() < o.firstId()) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
