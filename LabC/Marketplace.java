public class Marketplace {
    private String marketName;
    private String url;

    public Marketplace(String marketName, String url) {
        this.marketName = marketName;
        this.url = url;
    }

    public String displayInfo() {
        return 
        "Marketplace: " + marketName + "\n" + 
        "Website: " + url;
    }
}
