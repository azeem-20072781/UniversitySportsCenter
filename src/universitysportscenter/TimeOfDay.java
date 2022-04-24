package universitysportscenter;

/**
 * The enum Time of day.
 */
public enum TimeOfDay {
    /**
     * Morning time of day.
     */
    MORNING("Morning"),
    /**
     * Evening time of day.
     */
    EVENING("Evening"),
    /**
     * Afternoon time of day.
     */
    AFTERNOON("Afternoon");
    /**
     * The Time.
     */
    final String time;

    TimeOfDay(String time) {
        this.time = time;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }
}
