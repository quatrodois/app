package app.Codecademy.UI;

import javafx.scene.control.CheckBox;

public class addModule {

    private CheckBox checkBox;
    private String title;
    private String version;
    private String description;
    private String nameOfContact;

    public addModule(CheckBox checkBox, String title, String version, String speaker, String nameOfContact) {
        this.checkBox = checkBox;
        this.title = title;
        this.version = version;
        this.description = speaker;
        this.nameOfContact = nameOfContact;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameOfContact() {
        return nameOfContact;
    }

    public void setNameOfContact(String nameOfContact) {
        this.nameOfContact = nameOfContact;
    }

   
}
