package app.Codecademy.DB;

public class RegistrationSql {
    
    //create
    public String insertRegistrationSql(String input[]){
        return "INSERT INTO Registration(StudentEmail, CourseName, RegistrationDate) VALUES ('" + input[0] + "', '" + input[1] + "', GETDATE())";
    }

    //read
    public String selectRegistationsWithCertificateSql(){
        return "SELECT * FROM Registration INNER JOIN Certificate ON Registration.CertificateID = Certificate.CertificateID";
    }

    public String selectCourseByStudentSql(String ID){
        return "SELECT * FROM Course INNER JOIN Registration ON Course.CourseName = Registration.CourseName INNER JOIN Student ON Registration.StudentEmail = Student.StudentEmail WHERE Student.StudentEmail = '" + ID + "'";
    }

    //update
    public String updateRegistationSql(String input[]){
        return "UPDATE Registation SET StudentName = '" + input[0] + "', CourseName = '" + input[1] + "', CertificateID '" + input[2] + "'";
    }

    //delete
    public String deleteRegistrationSql(int certificate){
        return "DELETE FROM Registration WHERE CertificateID = '" + certificate + "'";
    }
}
