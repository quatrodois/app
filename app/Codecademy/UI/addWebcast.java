package app.Codecademy.UI;

public class addWebcast {

    private String title;
    private int amountWatched;
    private String speakerName;
    private int timeSpan;

    public addWebcast(String title, int amountWatched, String speakerName, int timeSpan) {
        this.title = title;
        this.amountWatched = amountWatched;
        this.speakerName = speakerName;
        this.timeSpan = timeSpan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmountWatched() {
        return amountWatched;
    }

    public void setAmountWatched(int amountWatched) {
        this.amountWatched = amountWatched;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public int getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(Integer timeSpan) {
        this.timeSpan = timeSpan;
    }
}