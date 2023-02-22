import java.time.LocalDate;
import java.util.*;

public class GeoTreeParser extends JsonParser {


    public static String dump(GeoTree geoTree) {
        List<Node> nodes = geoTree.nodes();
        Set<People> peoples = geoTree.getPeoples();
        StringBuilder json = new StringBuilder();
        json.append("{\"peoples\":[");
        List<People> p = peoples.stream().sorted().toList();
        People tempP;
        Node tempN;
        for (int i = 0; i < p.size(); i++) {
            if (i > 0)
                json.append(",");
            tempP = p.get(i);
            json.append(String.format(
                    "{\"id\":\"%d\", \"first_name\":\"%s\", \"last_name\":\"%s\", \"sex\":\"%s\", \"birthday\":\"%s\"}",
                    tempP.id(), tempP.firstName(), tempP.lastName(), tempP.sex(), tempP.birthday()));
        }
        json.append("],\"nodes\":[");
        nodes = nodes.stream().sorted().toList();
        for (int i = 0; i < nodes.size(); i++) {
            if (i > 0)
                json.append(",");
            tempN = nodes.get(i);
            json.append(String.format("{\"first_id\":\"%d\", \"rel\":\"%s\", \"second_id\":\"%d\"}",
                    tempN.firstId(), tempN.rel(), tempN.secondId()));
        }
        json.append("]}");
        return json.toString();

    }

    public static GeoTree load(String jsonString) {
        List<Map<String, String>> peoplesFields = parse(jsonString, "peoples");
        List<Map<String, String>> nodesFields = parse(jsonString, "nodes");
        List<Node> nodes = new ArrayList<>();
        Set<People> peoples = new HashSet<>();

        System.out.println(nodesFields);
        for (Map<String, String> field : peoplesFields) {
            String[] date = field.get("birthday").split("-");
            peoples.add(new FamilyMember(
                    Integer.parseInt(field.get("id")),
                    field.get("first_name"),
                    field.get("last_name"),
                    People.Sex.valueOf(field.get("sex")),
                    LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]))
            ));
        }
        for (Map<String, String> field : nodesFields) {
            nodes.add(new MyNode(
                    Integer.parseInt(field.get("first_id")),
                    Integer.parseInt(field.get("second_id")),
                    Relationship.valueOf(field.get("rel"))
            ));
        }

        return new MyGeoTree(nodes, peoples);

    }
}
