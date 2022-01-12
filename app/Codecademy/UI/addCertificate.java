package app.Codecademy.UI;

import java.sql.Date;

public class addCertificate {
   
    private String studentEmail; 
    private String courseName; 
    private Date registrationDate; 
    private int certificateID;

    public addCertificate(String studentEmail, String courseName, Date registrationDate, int certificateID) {
        this.studentEmail = studentEmail;
        this.courseName = courseName;
        this.registrationDate = registrationDate;
        this.certificateID = certificateID;
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

	public int getCertificateID() {
		return certificateID;
	}

	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}

}
