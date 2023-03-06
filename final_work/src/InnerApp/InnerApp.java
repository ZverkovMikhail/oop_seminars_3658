package InnerApp;

public class InnerApp {
    IInterface v;

    public InnerApp(IInterface v) {
        this.v = v;
    }

    public void write() {
        v.print();
    }
}
