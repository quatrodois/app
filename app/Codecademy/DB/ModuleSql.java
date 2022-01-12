package app.Codecademy.DB;

public class ModuleSql {
    
    //Create
    public String insertModuleSql(String ID, String input[]){
        return "INSERT INTO Module(ContentItemID, ContactName, ContactEmail, Version, SerialNumber) VALUES ('" + ID + "', '" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "', )";
    }

    //Read
    public String selectModuleSql(String ID){
        return "SELECT * FROM Module WHERE ContentItemID = '" + ID + "'";
    }

    public String selectModulesSql(){
        return "SELECT * from Module";
    }

    public String selectModulesInCourseSql(String ID){
        return "SELECT ContentItem.Title, ContentItem.Discription, Module.Version FROM Module INNER JOIN ContentItem ON Module.ContentItemID = ContentItem.ContentItemID WHERE Module.CourseName = '" + ID + "'";
    }

    //Update
    public String updateModuleSql(String ID, String input[]){
        return "UPDATE Module SET ContactName = '" + input[0] + "', ContactEmail ='" + input[1] + "', Version, ='" + input[2] + "', SerialNumber ='" + input[3] + "' WHERE ContentItemID = '" + ID + "',";
    }

    //Delete
    public String deleteModuleSql(String ID){
        return "DELETE FROM Module WHERE ContentItemID = '" + ID + "'";
    }
}
