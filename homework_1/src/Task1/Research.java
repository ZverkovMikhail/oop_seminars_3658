package Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Research {
    GeoTree gt;

    public Research(GeoTree gt) {
        this.gt = gt;
    }

    public List<FamilyMember> spend(FamilyMember fm, Relationship rel) {
        List<FamilyMember> familyMembers = new ArrayList<>();
        for (Node node : gt.nodes(fm)) {
            if (node.rel().equals(rel))
                familyMembers.add(node.fm2());
        }
        return familyMembers;
    }

    public Map<Relationship, List<FamilyMember>>complexSpend(FamilyMember fm){
        Map<Relationship, List<FamilyMember>> tree = new HashMap<>();
        for (Relationship rel: Relationship.values()){
            tree.put(rel, spend(fm, rel));
        }
        return tree;
    }
}
