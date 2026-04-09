package hardware;

public class Laptop extends Hardware {
    public Laptop(String brand, int spec) {
        super(brand, spec);
    }

    @Override
    public String getType() {
        return "Laptop";
    }

    @Override
    public String interpretSpec() {
        return getSpec() + "GB RAM";
    }
}