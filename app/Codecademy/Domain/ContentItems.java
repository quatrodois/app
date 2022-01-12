package app.Codecademy.Domain; 
 
import java.util.HashMap; 
 
public class ContentItems { 
    protected String publicatonDate; 
    protected String status; 
    protected HashMap<String, Integer> progression = new HashMap<>(); 
 
    public ContentItems(){ 
 
    } 
    public int getProgression(String studentEmail){ 
        for ( String key : progression.keySet() ){ 
            if(progression.get(key).equals(studentEmail)){ 
                return progression.get(key); 
            } 
        }  
        return 0; 
    } 
} 
