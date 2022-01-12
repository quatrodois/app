package app.Codecademy.DB;

public class PercentageWatchedSql {
    
    //create
    public String insertPercentageWachtedSql(String student, String contentItem){
        return "INSERT INTO PercentageWachted(StudentEmail, ContentItemID, PercentageWatched) VALUE ('" + student + "', '" + contentItem+ "', 0)";
    }
    
    //read
    public String selectPercentageWatchedSql(String student, String contentItem){
        return "SELECT * FROM PercentageWatched WHERE StudentEmail = '" + student + "' && ContentItemID = '" + contentItem + "'";
    }

    //update
    public String updatePercentageWatchedSql(String student, String contentItem, int percentage){
        return "UPDATE PercentageWatched SET StudentEmail = '" + student + "', ContentItemID = '" + contentItem + "', PercentageWatched = '" + percentage + "'";
    }

    //delete
    public String deletePercentageWatchedSql(String student, String contentItem){
        return "DELETE FROM PercentageWatched WHERE StudentEmail = '" + student + "' && ContentItemID = '" + contentItem + "'";
    }
}
