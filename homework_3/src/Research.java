import java.util.ArrayList;
import java.util.List;

public abstract class Research {
    GeoTree gt;

    public Research(GeoTree gt) {
        this.gt = gt;
    }

    public List<People> spend(People fm, Relationship rel) {
        List<People> familyMembers = new ArrayList<>();
        for (Node node : gt.nodes(fm)) {
            if (node.rel().equals(rel))
                familyMembers.add(gt.getPeopleById(node.secondId()));
        }
        return familyMembers;
    }
}
