package universitysportscenter;

public enum Exercise {
    YOGA("Yoga", 100), ZUMBA("Zumba", 110),

    AQUACISE("Aquacise", 120), BOX_FIT("Box Fit", 130),

    BODY_BLITZ("Body Blitz", 140);
    final private String name;
    final private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    Exercise(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
