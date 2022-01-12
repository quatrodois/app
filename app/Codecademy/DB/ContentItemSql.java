package app.Codecademy.DB;

public class ContentItemSql {
    
    //Create
    public String insertContentItemSql(String input[]){
        return "INSERT INTO ContentItem(Status, PublicationDate, Title, Discription) VALUES ('" + input[0] + "', GETDATE(), '" + input[2] + "', '" + input[3] + "')";
    }

    //Update
    public String updateContentItemSql(String ID, String input[]){
        return "UPDATE ContentItem SET Status = '" + input[0] + "', Title = '" + input[1] + "',  Discription = '" + input[2] + " WHERE ContentItemID = '" + ID + "'";
    }

    //Delete
    public String deleteContentItemSql(String ID){
        return "DELETE FROM ContentItem WHERE ContentItemID = '" + ID + "'";
    }
}
