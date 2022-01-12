package app.Codecademy.DB;

public class CertificateSql {
    
    //create
    public String insertCertificateSql(String input[]){
        return "INSERT INTO Certificate(Grade, SignatoryName) VALUE ('" + input[0] + "', '" + input[1] + "')";
    }

    //read
    public String selectCertificateInRegistrationSql(){
        return "SELECT * FROM Certificate INNER JOIN Registration ON Certificate.CertificateID = Registration.CertificateID";
    }

    //Courses for which a student has a certificate
    public String selectCertificatesEarnedSql(String email){
        return "SELECT Registration.CourseName FROM Student INNER JOIN Registration ON Student.StudentEmail = Registration.StudentEmail INNER JOIN Certificate ON Registration.CertificateID = Certificate.CertificateID WHERE Student.StudentEmail = '" + email + "' AND SignatoryName IS NOT NULL";
    }

    //Certificate from specific student.
    public String selectCertificateSpecificStudent(String ID){
        return "SELECT * FROM Certificate INNER JOIN Registration ON Certificate.CertificateID = Registration.CertificateID WHERE Registration.StudentEmail = '" + ID + "'";
    }

    //Certificates that have a student but no signatory name 
    public String selectUnfinishedCertificates(){ 
        return "SELECT Certificate.CertificateID, Grade, StudentEmail, CourseName, RegistrationDate, SignatoryName FROM Certificate INNER JOIN Registration ON Certificate.CertificateID = Registration.CertificateID WHERE SignatoryName IS NULL"; 
    } 

    //update
    public String updateCertificateSql(int i, String string){
        return "UPDATE Certificate SET SignatoryName = '" + string + "' WHERE CertificateID = '" + i + "'";
    }

    //delete
    public String deleteCertificateSql(String ID){
        return "DELETE FROM Certificate WHERE CertificateID = '" + ID + "'";
    }
}
