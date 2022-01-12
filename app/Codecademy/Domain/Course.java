package app.Codecademy.Domain;

import java.sql.ResultSet;
import java.util.ArrayList;

import app.Codecademy.DB.CourseSql;
import app.Codecademy.DB.SqlManager;
 
public class Course { 
    private String name; 
    private String subject; 
    private String introductoryText; 
    private String difficulty; 
    protected ArrayList<Course> courseInfo;
    
    SqlManager manager = new SqlManager();
    CourseSql courseSql = new CourseSql();

    ResultSet coursesRS = manager.executeSql(courseSql.selectCoursesSql());

    public Course(String name, String subject, String introductoryText, String difficulty) {
        this.courseInfo = new ArrayList<>();
        this.name = name;
        this.subject = subject;
        this.introductoryText = introductoryText;
        this.difficulty = difficulty;
    }

    public void getCourseResult() {
        ResultSet courseRS = manager.executeSql(courseSql.selectCoursesSql());
        try {
            while (courseRS.next()) {
                Course course = new Course(courseRS.getString("CourseName"), courseRS.getString("Subject"), courseRS.getString("IntroductoryText"), courseRS.getString("Difficulty"));
                courseInfo.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertCourse(String[] input){
        manager.executeSql(courseSql.insertCourseSql(input));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deleteCourse(String ID){
        manager.executeSql(courseSql.deleteCourseSql(ID));
    }

    public String getCourseName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getIntroductoryText() {
        return introductoryText;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public ArrayList<Course> getCourseInfoArrayList() {
        return courseInfo;
    }   
} 