package app.Codecademy.UI;

public class addCourse {
   
    private String name; 
    private String subject; 
    private String introductoryText; 
    private String difficulty;

    public addCourse(String name, String subject, String introductoryText, String difficulty) {
        this.name = name;
        this.subject = subject;
        this.introductoryText = introductoryText;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIntroductoryText() {
        return introductoryText;
    }

    public void setIntroductoryText(String introductoryText) {
        this.introductoryText = introductoryText;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    
    
    
}
