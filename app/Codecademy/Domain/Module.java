package app.Codecademy.Domain;

import java.sql.ResultSet;
import java.util.ArrayList;

import app.Codecademy.DB.ModuleSql;
import app.Codecademy.DB.SqlManager;

public class Module extends ContentItems{ 
    private String title; 
    private String version; 
    private int serialNumber; 
    private String description; 
    private String contactName; 
    private String contactEmail; 
    private ArrayList<Module> moduleInfo;
 
    //constructor for the module class
    public Module(String title, String version, int serialNumber, String description, String contactName, String contactEmail){ 
        this.title = title;
        this.version = version;
        this.serialNumber = serialNumber;
        this.description = description;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    //give this class access to the functions in SqlManager and ModuleSql
    SqlManager manager = new SqlManager();
    ModuleSql moduleSql = new ModuleSql();

    //Sql functions
    //get an arraylist of all Module in the database
    public void getModuleResult() {
        ResultSet moduleRS = manager.executeSql(moduleSql.selectModulesSql());
        try {
            while (moduleRS.next()) {
                //create new Module module
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

} 
