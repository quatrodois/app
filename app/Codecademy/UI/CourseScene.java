package app.Codecademy.UI;

import java.io.IOException;
import java.util.ArrayList;

import app.Codecademy.Domain.Course;
import app.Codecademy.UI.SelectedCourseScene;
import app.Codecademy.UI.addCertificate;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class CourseScene extends Application {

    @Override
    public void start(Stage courseStage) throws Exception {
        courseStage.setTitle("Wessel Kuijstermans(2166881), Mark Gonzalez Avila(), Mart van Holten(), Rico Schouten()");

        Label welcomeText = new Label("Cursussen");
        welcomeText.setStyle("-fx-font-size:8em; ");

        // Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        // Putting the grid inside an HBox
        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(grid);
        hbox1.setAlignment(Pos.CENTER);

        // Button to go back to previous scene
        Button backButton = new Button("Terug");
        backButton.setStyle("-fx-font-size: 2em; ");
        backButton.setLineSpacing(25);

        // Label for the tables
        Label tableViewAllLabel = new Label("Alle cursussen: ");
        tableViewAllLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(tableViewAllLabel, 1, 0);
        grid.getChildren().add(tableViewAllLabel);

        Label tableViewTop3Label = new Label("Top 3 cursussen: ");
        tableViewTop3Label.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(tableViewTop3Label, 2, 0);
        grid.getChildren().add(tableViewTop3Label);

        // Button to create a new course
        Button createCourseButton = new Button("Cursus aanmaken");
        createCourseButton.setStyle("-fx-font-size: 2em; ");
        GridPane.setConstraints(createCourseButton, 0, 1);
        grid.getChildren().add(createCourseButton);

        // table for all courses
        TableView tableViewAll = new TableView();
        tableViewAll.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableViewAll.setPrefSize(600, 600);

        // Make columns
        TableColumn<Course, String> column1 = new TableColumn<>("Naam");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Course, String> column2 = new TableColumn<>("Onderwerp");
        column2.setCellValueFactory(new PropertyValueFactory<>("subject"));
        TableColumn<Course, String> column3 = new TableColumn<>("Inleiding");
        column3.setCellValueFactory(new PropertyValueFactory<>("introductoryText"));
        TableColumn<Course, String> column4 = new TableColumn<>("Niveau");
        column4.setCellValueFactory(new PropertyValueFactory<>("difficulty"));

        // Add columns to table
        tableViewAll.getColumns().add(column1);
        tableViewAll.getColumns().add(column2);
        tableViewAll.getColumns().add(column3);
        tableViewAll.getColumns().add(column4);

        // Request the database information and store it in an arraylist
        Course course = new Course("", "", "", "");
        course.getCourseResult();
        ArrayList<Course> courseList = course.getCourseInfoArrayList();

        // Create a row for every entry in the table and add its information to the
        // right spot
        for (Course x : courseList) {
            tableViewAll.getItems()
                    .add(new addCourse(x.getName(), x.getSubject(), x.getIntroductoryText(), x.getDifficulty()));
        }

        // Add the table to the grid
        GridPane.setConstraints(tableViewAll, 1, 1);
        grid.getChildren().add(tableViewAll);

        // Table for top 3 courses
        TableView tableViewTop3 = new TableView();
        tableViewTop3.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableViewTop3.setPrefSize(600, 30);
        tableViewTop3.setMaxHeight(98);

        // Make columns
        TableColumn<Course, String> column5 = new TableColumn<>("Naam");
        column5.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Course, String> column6 = new TableColumn<>("Onderwerp");
        column6.setCellValueFactory(new PropertyValueFactory<>("subject"));
        TableColumn<Course, String> column7 = new TableColumn<>("Inleiding");
        column7.setCellValueFactory(new PropertyValueFactory<>("introductoryText"));
        TableColumn<Course, String> column8 = new TableColumn<>("Niveau");
        column8.setCellValueFactory(new PropertyValueFactory<>("difficulty"));

        // Add columns to table
        tableViewTop3.getColumns().add(column5);
        tableViewTop3.getColumns().add(column6);
        tableViewTop3.getColumns().add(column7);
        tableViewTop3.getColumns().add(column8);

        int i = 0;
        for (Course x : courseList) {
            if (i == 3){
                break;
            }
            tableViewTop3.getItems()
                    .add(new addCourse(x.getName(), x.getSubject(), x.getIntroductoryText(), x.getDifficulty()));
            i++;
        }

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(tableViewTop3);
        hbox2.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(hbox2, 2, 1);
        grid.getChildren().add(hbox2);

        // create a layout
        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(backButton, Pos.BOTTOM_LEFT);
        layout.setBottom(backButton);
        layout.setAlignment(hbox1, Pos.CENTER);
        layout.setCenter(hbox1);

        Scene sc = new Scene(layout, 960, 600, Color.GREY);

        layout.setStyle("-fx-background-color: #d6d6d6;");
        courseStage.setScene(sc);
        courseStage.setMaximized(true);
        courseStage.show();

        // Back Button Action
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Main main = new Main();
                Stage scene2 = new Stage();
                try {
                    main.start(scene2);
                    courseStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });

        tableViewAll.setOnMouseClicked(new EventHandler<MouseEvent>() {


            @Override
            public void handle(MouseEvent event) {
                // TODO Auto-generated method stub
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("layout2.fxml"));
                    Parent root = loader.load();
            
                    //The following both lines are the only addition we need to pass the arguments
                    SelectedCourseScene selectedCourseScene = loader.getController();
                    selectedCourseScene.setLabelText(courseList.get(tableViewAll.getSelectionModel().getSelectedIndex()).getName());
            
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Layout2 + Controller2");
                    stage.show();
            
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Button action for create course
        createCourseButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                CreateCourseScene CreateCourseScene = new CreateCourseScene();
                Stage scene2 = new Stage();
                try {
                    CreateCourseScene.start(scene2);
                    courseStage.close();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
    }
}