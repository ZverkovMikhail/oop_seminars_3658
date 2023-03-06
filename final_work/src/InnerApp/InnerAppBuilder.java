package InnerApp;
import java.util.Objects;

public class InnerAppBuilder {
    IInterface printer;
    public InnerAppBuilder(IInterface printer) {
        setPrinter(printer);
    }

    public InnerAppBuilder setPrinter(IInterface printer) {
        this.printer = Objects.requireNonNullElseGet(printer, () -> new DefaultPrinter());
        return this;
    }

    public InnerApp build(){
        return new InnerApp(printer);
    }
}
