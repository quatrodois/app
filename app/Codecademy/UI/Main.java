package app.Codecademy.UI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Wessel Kuijstermans(2166881), Mark Gonzalez Avila(), Mart van Holten(), Rico Schouten()");

        // Welcome text
        // Label welcomeText = new Label("CodeCademy");
        // welcomeText.setStyle("-fx-font-size:8em; ");

        // fonts
        String fontFamily = "Arial";
        Font font1 = Font.font(fontFamily);

        // load the image
        Image image = new Image("app/Img/logoTransparant.png");

        // simple displays ImageView the image as is
        ImageView banner = new ImageView();
        banner.setImage(image);

        // Button
        HBox hboxButtons = new HBox();
        Button courses = new Button("Cursussen");
        Button students = new Button("Cursisten");
        Button certificates = new Button("Certificaten");
        Button webcast = new Button("Webcast");
        hboxButtons.getChildren().addAll(courses, students, certificates, webcast);
        courses.setStyle("-fx-font-size: 2em; -fx-background-color: #c4c4c4;");
        students.setStyle("-fx-font-size: 2em; -fx-background-color: #c4c4c4;");
        certificates.setStyle("-fx-font-size: 2em; -fx-background-color: #c4c4c4;");
        webcast.setStyle("-fx-font-size: 2em; -fx-background-color: #c4c4c4;");
        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.setSpacing(25);
        hboxButtons.setEffect(new DropShadow());

        BorderPane layout = new BorderPane();

        layout.setAlignment(banner, Pos.TOP_CENTER);
        layout.setAlignment(hboxButtons, Pos.CENTER);
        layout.setCenter(hboxButtons);
        layout.setTop(banner);

        Scene sc = new Scene(layout, 960, 600);

        layout.setStyle("-fx-background-color: #d6d6d6;");
        primaryStage.setScene(sc);
        primaryStage.setMaximized(true);
        primaryStage.show();

        // Button action for Course
        courses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CourseScene courseScene = new CourseScene();
                Stage scene2 = new Stage();
                try {
                    courseScene.start(scene2);
                    primaryStage.close();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        // Button action for Students
        students.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                StudentsScene studentsScene = new StudentsScene();
                Stage scene2 = new Stage();
                try {
                    studentsScene.start(scene2);
                    primaryStage.close();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        // Button action for Webcast
        webcast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                WebcastScene webcastScene = new WebcastScene();
                Stage scene2 = new Stage();
                try {
                    webcastScene.start(scene2);
                    primaryStage.close();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        // Button action for Certificate
        certificates.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CertificateScene certificateScene = new CertificateScene();
                Stage scene2 = new Stage();
                try {
                    certificateScene.start(scene2);
                    primaryStage.close();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        });
    }

    public static void main(String args[]) {
        launch(args);
    }
}
