package app.Codecademy.UI;

import java.util.ArrayList;
import java.util.List;

import app.Codecademy.DB.CertificateSql;
import app.Codecademy.Domain.Certificate;
import app.Codecademy.Domain.Student;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ViewStudentScene extends Application {
    protected String email;

    public ViewStudentScene(String email) {
        this.email = email;
    }

    @Override
    public void start(Stage viewStudentStage) throws Exception {
        // TODO Auto-generated method stub
        viewStudentStage.setTitle(
                "Wessel Kuijstermans(2166881), Mark Gonzalez Avila(), Mart van Holten(), Rico Schouten()");

        // Welcome text and back button
        Label welcomeText = new Label("Cursist");
        welcomeText.setStyle("-fx-font-size:8em; ");
        Button backButton = new Button("Terug");
        Label labelData = new Label("Gegevens");
        labelData.setFont(new Font(30.0));
        Label allCertificates = new Label("Behaalde certificaten");
        allCertificates.setFont(new Font(30.0));
        // Create Vboxes and Hboxes
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        VBox vbox3 = new VBox();

        // Listview for the student data
        ListView data = new ListView();

        Student studentEmail = new Student("a", "a", "a", "a", "a", "a", "a", "a");
        studentEmail.getStudentSingular(email);
        ArrayList<Student> list = studentEmail.getAllStudents();

        for (Student x : list) {
            data.getItems().add(x.getStudentEmail());
            data.getItems().add(x.getStudentName());
            data.getItems().add(x.getStudentBirthdate());
            data.getItems().add(x.getGender());
            data.getItems().add(x.getAddress());
            data.getItems().add(x.getCity());
            data.getItems().add(x.getCountry());
            data.getItems().add(x.getPostalCode());
        }

        vbox1.getChildren().addAll(labelData, data);

        // Listview for all the certificates

        Certificate c = new Certificate(1, 1, "");
        List<String> resultList = c.getStudentCertificates(email);

        ListView allCertificatesListView = new ListView();
        for(String x :resultList){
            allCertificatesListView.getItems().add(x);
        }
        

        // Listview for all the courses
        Student studentcourse = new Student(email,"a","a", "a", "a", "a", "a", "a");
        List<String> courList = studentcourse.getStudentCourses();
        ListView courses = new ListView();
        
        
        for(String x :courList){
            courses.getItems().add(x);
            
        }
        vbox2.getChildren().addAll(allCertificates, allCertificatesListView, courses);
        vbox2.setSpacing(10);

        // Progressbars
        ProgressBar pb1 = new ProgressBar(0.6);
        ProgressIndicator pi = new ProgressIndicator(0.6);

        ProgressBar pb2 = new ProgressBar(0.6);
        ProgressIndicator pi2 = new ProgressIndicator(0.6);

        HBox progresBar1 = new HBox();
        progresBar1.getChildren().addAll(pb1, pi);
        Label modules = new Label("Modules");
        modules.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        VBox prog1 = new VBox();
        prog1.getChildren().addAll(modules, progresBar1);

        HBox progresBar2 = new HBox();
        progresBar2.getChildren().addAll(pb2, pi2);
        Label webcasts = new Label("Webcasts");
        webcasts.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        VBox prog2 = new VBox(webcasts, progresBar2);

        vbox3.getChildren().addAll(prog1, prog2);
        vbox3.setSpacing(70);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(vbox1, vbox2, vbox3);
        hbox.setSpacing(150);
        hbox.setAlignment(Pos.CENTER);

        // Create a borderpane and add everything
        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(backButton, Pos.BOTTOM_LEFT);
        layout.setBottom(backButton);
        layout.setCenter(hbox);
        layout.setStyle("-fx-background-color: #d6d6d6;");

        Scene sc = new Scene(layout, 960, 600);

        // Create a scene

        viewStudentStage.setScene(sc);
        viewStudentStage.setMaximized(true);
        viewStudentStage.show();

        // Button to go back to the previous scene
        backButton.setStyle("-fx-font-size: 1em; -fx-background-color: #8F8F8F;");
        backButton.setEffect(new DropShadow());
        backButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Main main = new Main();
                Stage scene2 = new Stage();
                try {
                    main.start(scene2);
                    viewStudentStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

}
