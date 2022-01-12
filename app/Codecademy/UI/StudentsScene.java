package app.Codecademy.UI;

import java.sql.Date;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

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
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StudentsScene extends Application {

    @Override
    public void start(Stage studentStage) throws Exception {
        studentStage.setTitle("Wessel Kuijstermans(2166881), Mark Gonzalez Avila(), Mart van Holten(), Rico Schouten()");

        Label welcomeText = new Label("Cursisten");
        welcomeText.setStyle("-fx-font-size:8em; ");
        Button backButton = new Button("Terug");
        backButton.setStyle("-fx-font-size: 1em; -fx-background-color: #8F8F8F;");
        backButton.setEffect(new DropShadow());

        // Lsit view
        ListView listView = new ListView();
        String str = "2020-03-31";
        Date date = Date.valueOf(str);

        Student studentEmail = new Student("a", "a", "a", "a", "a", "a", "a", "a");
        studentEmail.getStudentResult();
        ArrayList<Student> list = studentEmail.getAllStudents();

        for (Student x : list) {
            listView.getItems().add(x.getStudentEmail());
        }

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                String email = String.valueOf(listView.getSelectionModel().getSelectedItem());
                Stage x = new Stage();
                ViewStudentScene goToScene = new ViewStudentScene(email);
                try {
                    goToScene.start(x);
                    studentStage.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println(e);
                }
            }
        });


VBox vboxView = new VBox();
VBox vbox2 = new VBox();

//add progresionbars to vbox
ProgressBar pb = new ProgressBar(0.6);
ProgressIndicator pi = new ProgressIndicator(0.6);

ProgressBar pb2 = new ProgressBar(0.6);
ProgressIndicator pi2 = new ProgressIndicator(0.6);

HBox progresBar1 = new HBox();
progresBar1.getChildren().addAll(pb, pi);
Label male = new Label("Slaagpercentage mannen");
male.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
VBox prog1 = new VBox();
prog1.getChildren().addAll(male, progresBar1);

HBox progresBar2 = new HBox();
progresBar2.getChildren().addAll(pb2, pi2);
Label female = new Label("Slaagpercentage vrouwen");
female.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
VBox prog2 = new VBox(female, progresBar2);

Button create = new Button("Aanmaken");

create.setStyle("-fx-font-size: 2em; -fx-background-color: #8F8F8F;");
create.setEffect(new DropShadow());



vboxView.getChildren().addAll(listView);
vbox2.getChildren().addAll(prog1, prog2, create);
vbox2.setSpacing(70);

HBox hbox = new HBox();
hbox.getChildren().addAll(vboxView, vbox2);
hbox.setSpacing(200);
hbox.setAlignment(Pos.CENTER);

        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(backButton, Pos.BOTTOM_LEFT);
        layout.setBottom(backButton);
        layout.setCenter(hbox);
        layout.setStyle("-fx-background-color: #d6d6d6;");

        Scene sc = new Scene(layout, 960, 600, Color.BEIGE);

        studentStage.setScene(sc);
        studentStage.setMaximized(true);
        studentStage.show();

        // Back Button Action
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Main main = new Main();
                Stage scene2 = new Stage();
                try {
                    main.start(scene2);
                    studentStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }); 


        //Button action Create
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CreateStudentScene css = new CreateStudentScene();
                Stage scene2 = new Stage();
                try {
                    css.start(scene2);
                    studentStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
    
}