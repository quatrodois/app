package app.Codecademy.DB;

public class WebcastSql {
    
    //Create
    public String insertWebcastSql(String ID, String input[]){
        return "INSERT INTO Webcast(ContentItemID, TimeSpan, SpeakerName, Orginisation, URL) VALUES ('" + ID + "', '" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "', )";
    }

    //Read
    public String selectWebcastSql(String ID){
        return "SELECT * FROM Webcast WHERE ContentItemID = '" + ID + "'";
    }

    public String selectWebcastsSql(){
        return "SELECT Title, TimeSpan, Discription, SpeakerName, Organisation, URL, AmountWatched FROM Webcast INNER JOIN ContentItem ON Webcast.ContentItemID = ContentItem.ContentItemID";
    }

    public String selectWebcastsTopSql(){
        return "SELECT TOP 3 * FROM Webcast INNER JOIN ContentItem ON Webcast.ContentItemID = ContentItem.ContentItemID ORDER BY AmountWatched desc";
    }

    //Update
    public String updateWebcastSql(String ID, String input[]){
        return "UPDATE Webcast SET TimeSpan = '" + input[0] + "', SpeakerName ='" + input[1] + "', Orginisation, ='" + input[2] + "', URL ='" + input[3] + "' WHERE ContentItemID = '" + ID + "',";
    }

    //Delete
    public String deleteWebcastSql(String ID){
        return "DELETE FROM Webcast WHERE ContentItemID = '" + ID + "'";
    }
}
