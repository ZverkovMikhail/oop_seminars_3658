import java.util.List;
import java.util.Set;

public interface GeoTree {
    List<Node> nodes(People fm);
    List<Node> nodes();
    Set<People> getPeoples();
    People getPeopleById(int id);
    Set<People> find(PeopleFilter filter);
}
