public abstract class Publication implements LibraryItem {
    protected String title;

    public Publication(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}