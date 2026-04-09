package hardware;

public class Phone extends Hardware {
    public Phone(String brand, int spec) {
        super(brand, spec);
    }

    @Override
    public String getType() {
        return "Phone";
    }

    @Override
    public String interpretSpec() {
        return getSpec() + " Megapixels";
    }
}