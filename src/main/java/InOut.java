public enum InOut {

    IN("Przychód"),
    OUT("Wydatek");

    private final String description;

    InOut(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
