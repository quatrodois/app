package app.Codecademy.DB;

public class StudentSql {

    //Create
    public String insertStudentSql(String input[]){
        return "INSERT INTO Student (StudentEmail, StudentName, StudentBirthdate, Gender, Address, City, Country, Zipcode) VALUES ('" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "', '" + input[4] + "', '" + input[5] + "', '" + input[6] + "', '" + input[7] + "')";
    }

    //Read
    public String selectStudentsSql(){
        return "SELECT * FROM Student";
    }

    public String selectStudentSql(String ID){
        return "SELECT * FROM Student WHERE StudentEmail = '" + ID + "'";
    }

    //Get courses the student hasn't completed
    public String selectStudentCourses(String email){
        return "SELECT Registration.CourseName FROM Student INNER JOIN Registration ON Student.StudentEmail = Registration.StudentEmail INNER JOIN Certificate ON Registration.CertificateID = Certificate.CertificateID WHERE Student.StudentEmail = '" + email + "' AND SignatoryName IS NULL";
    }

    //progression of course for one student.
    public String selectStudentModuleCompletionOnCourse(String ID){
        return "SELECT ModuleCompletion.CourseName, ModuleCompletion.PercentageCompleted FROM ModuleCompletion INNER JOIN Certificate ON ModuleCompletion.CertificateID = Certificate.CertificateID INNER JOIN Registration ON Certificate.CertificateID = Registration.CertificateID INNER JOIN Student ON Registration.StudentEmail = Student.StudentEmail WHERE Student.StudentEmail = ' " + ID + "'";
    }
    
    //Update
    public String updateStudentSql(String ID, String input[]){
        return "UPDATE Student SET StudentEmail = '" + input[0] + "', StudentName = '" + input[1] + "', StudentBirthdate = '" + input[2] + "', Gender = '" + input[3] + "', Address = '" + input[4] + "', City = '" + input[5] + "', Country = '" + input[6] + "', Zipcode = '" + input[6] + " WHERE StudentEmail = ' " + ID + "'";
    }

    //Delete
    public String deleteStudentSql(String ID){
        return "DELETE FROM Student WHERE StudentEmail = " + ID + "'";
    }

}
