package app.Codecademy.UI;

import java.sql.Date;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class addRegistration {

    private String studentEmail;
    private String courseName;
    private Date registrationDate;
    private Double grade;
    // private String signatoryName;
    private TextField textField;

    public addRegistration(String studentEmail, String courseName, Date registrationDate, Double grade, String signatoryName) {
        this.studentEmail = studentEmail;
        this.courseName = courseName;
        this.registrationDate = registrationDate;
        this.grade = grade;
    
        this.textField = new TextField(signatoryName);
    }

    public TextField getSignatoryName() {
        return textField;
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
