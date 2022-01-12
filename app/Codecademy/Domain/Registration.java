package app.Codecademy.Domain;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import app.Codecademy.DB.CertificateSql;
import app.Codecademy.DB.RegistrationSql;
import app.Codecademy.DB.SqlManager;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Registration {

    private String studentEmail;
    private String courseName;
    private Date registrationDate;
    private double grade;
    private String signatoryName;
    private int certificateID;
    protected ArrayList<Registration> registrationInfo;
    private TextField textField;
    protected ArrayList<Registration> unfinishedRegistrationInfo;

    public Registration(String studentEmail, String courseName, Date registrationDate, double grade, String signatoryName,
            int certificateID) {
        this.registrationInfo = new ArrayList<>();
        this.unfinishedRegistrationInfo = new ArrayList<>();
        this.studentEmail = studentEmail;
        this.courseName = courseName;
        this.registrationDate = registrationDate;
        this.grade = grade;
        this.signatoryName = signatoryName;
        this.certificateID = certificateID;
        this.textField = new TextField(signatoryName);

    }

    // give this class access to the functions in SqlManager and RegistrationSql
    SqlManager manager = new SqlManager();
    RegistrationSql registrationSql = new RegistrationSql();
    CertificateSql certificateSql = new CertificateSql();

    public void getRegistrationResult() {
        ResultSet registrationRS = manager.executeSql(registrationSql.selectRegistationsWithCertificateSql());
        ResultSet certificateRS = manager.executeSql(certificateSql.selectCertificateInRegistrationSql());
        try {
            while (registrationRS.next() && certificateRS.next()) {
                Registration registration = new Registration(registrationRS.getString("StudentEmail"),
                        registrationRS.getString("CourseName"), registrationRS.getDate("RegistrationDate"),
                        certificateRS.getFloat("Grade"), certificateRS.getString("SignatoryName"),
                        certificateRS.getInt("CertificateID"));
                registrationInfo.add(registration);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getUnfinishedRegistrationResult() {
        ResultSet certificateRS = manager.executeSql(certificateSql.selectUnfinishedCertificates());
        try {
            while (certificateRS.next()) {
                Registration unfinishedRegistration = new Registration(certificateRS.getString("StudentEmail"),
                certificateRS.getString("CourseName"), certificateRS.getDate("RegistrationDate"),
                        certificateRS.getFloat("Grade"), certificateRS.getString("SignatoryName"),
                        certificateRS.getInt("CertificateID"));
                unfinishedRegistrationInfo.add(unfinishedRegistration);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertRegistration(String[] input) {
        manager.executeSql(registrationSql.insertRegistrationSql(input));
        // System.out.println(manager.executeSql(registrationSql.insertRegistrationSql(input)));
    }

    public void updateRegistraion(String[] input) {
        manager.executeSql(registrationSql.updateRegistationSql(input));
        // System.out.println(manager.executeSql(registrationSql.updateRegistationSql(input)));
    }

    public void deleteRegistration(int certificateID) {
        manager.executeSql(registrationSql.deleteRegistrationSql(certificateID));
        // System.out.println(manager.executeSql(registrationSql.deleteRegistrationSql(certificateID)));
    }
    
    public void setSignatoryName(String signatoryName) {
        this.signatoryName = signatoryName;
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

    public String getCourseName() {
        return courseName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public double getGrade() {
        return grade;
    }

    public String getSignatoryName() {
        return signatoryName;
    }

    public int getCertificateID() {
        return certificateID;
    }

    public ArrayList<Registration> getRegistrationInfo() {
        return registrationInfo;
    }

    public ArrayList<Registration> getUnfinishedRegistrationInfo() {
        return unfinishedRegistrationInfo;
    }
}
