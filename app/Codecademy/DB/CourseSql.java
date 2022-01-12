package app.Codecademy.DB;

public class CourseSql {
    
    //Create 
    public String insertCourseSql(String[] input){
        return "INSERT INTO Course(CourseName, Subject, IntroductoryText, Difficulty) VALUES ('" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "')";
    }

    //Read
    public String selectCourseSql(String ID){
        return "SELECT * FROM Course WHERE CourseName = '" + ID + "'";
    }

    public String selectCoursesSql(){
        return "SELECT * FROM Course";
    }

    //Amount course completed.
    public String selectCourseCompletionSql(){
        return "SELECT Course.CourseName, COUNT(ModuleCompletion.PercentageCompleted) FROM ModuleCompletion INNER JOIN Course ON ModuleCompletion.CourseName = Course.CourseName WHERE ModuleCompletion.PercentageCompleted = 100 GROUP BY Course.CourseName";
    }

    //Update
    public String updateCourseSql(String ID, String[] input){
        return "UPDATE Course SET CourseName = '" + input[0] + "', Subject = '" + input[1] + "', IntroductoryText = '" + input[2] + "', Difficulty = '" + input[3] + "' WHERE CourseName = '" + ID + "'";
    }

    //Delete
    public String deleteCourseSql(String ID){
        return "DELETE FROM Course WHERE CourseName = '" + ID + "'";
    }
}
