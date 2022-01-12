package app.Codecademy.DB;

public class ModuleCompletionSql {
    
    //create
    public String insertModuleCompletionSql(String certificate, String course){
        return "INSERT INTO ModuleCompletion(CertificateID, CourseName, PercentageCompleted) VALUE ('" + certificate + "', '" + course + "', 0)";
    }

    //read
    public String selectModuleCompletionSql(String certificate, String course){
        return "SELECT * FROM ModuleCompletion WHERE CertificateID = '" + certificate + "' && CourseName = '" + course + "'";
    }

    //update
    public String updateModuleCompletionSql(String certificate, String course, int grade){
        return "UPDATE ModuleCompletion SET CertificateID ='" + certificate + "', CourseName = '" + course + "', PercentageCompleted ='" + grade + "'";
    }

    //delete
    public String deleteModuleCompletionSql(String certificate, String course){
        return "DELETE FROM ModuleCompletion WHERE CertificateID = '" + certificate + "' && CourseName = '" + course + "'";
    }
}
