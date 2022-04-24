package universitysportscenter;

/**
 * The enum Exercise.
 */
public enum Exercise {
    /**
     * Yoga exercise.
     */
    YOGA("Yoga", 100),
    /**
     * Zumba exercise.
     */
    ZUMBA("Zumba", 110),

    /**
     * Aquacise exercise.
     */
    AQUACISE("Aquacise", 120),
    /**
     * The Box fit.
     */
    BOX_FIT("Box Fit", 130),

    /**
     * The Body blitz.
     */
    BODY_BLITZ("Body Blitz", 140);
    final private String name;
    final private int price;

    Exercise(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }
}
