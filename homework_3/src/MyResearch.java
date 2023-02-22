import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyResearch extends Research{
    public MyResearch(GeoTree gt) {
        super(gt);
    }
    public Map<Relationship, List<People>> complexSpend(People fm){
        Map<Relationship, List<People>> tree = new HashMap<>();
        for (Relationship rel: Relationship.values()){
            tree.put(rel, spend(fm, rel));
        }
        return tree;
    }
}
