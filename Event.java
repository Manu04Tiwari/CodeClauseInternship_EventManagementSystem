public class Event {
    private int id;
    private String name;
    private String date;
    private String venue;
    private String description;

    public Event(String name, String date, String venue, String description) {
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.description = description;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getVenue() { return venue; }
    public String getDescription() { return description; }
}

