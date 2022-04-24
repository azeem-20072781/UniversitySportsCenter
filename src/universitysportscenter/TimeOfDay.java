package universitysportscenter;

public enum TimeOfDay {
    MORNING("Morning"), EVENING("Evening"), AFTERNOON("Afternoon");
    final String time;

    TimeOfDay(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
