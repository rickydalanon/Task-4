package hardware;

public class Hardware {
    private int id;
    private String brand;
    private int spec;

    public Hardware(String brand, int spec) {
        this.brand = brand;
        this.spec = spec;
    }

    public int getSpec() { return spec; }
    public String getBrand() { return brand; }

    public String getType() {
        return "Unknown";
    }

    public String interpretSpec() {
        return spec + "";
    }
}