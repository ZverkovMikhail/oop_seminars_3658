import InnerApp.InnerApp;
import InnerApp.InnerAppBuilder;

public class Main {
    public static void main(String[] args) {
        InnerApp innerApp = new InnerAppBuilder(null).build();
        innerApp.write();
    }
}


