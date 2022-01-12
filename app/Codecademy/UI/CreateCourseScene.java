package app.Codecademy.UI;

import java.lang.reflect.Array;
import java.util.ArrayList;

import app.Codecademy.DB.CourseSql;
import app.Codecademy.Domain.Course;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CreateCourseScene extends Application {

    @Override
    public void start(Stage createCourseStage) throws Exception {
        createCourseStage.setTitle("Wessel Kuijstermans(2166881), Mark Gonzalez Avila(), Mart van Holten(), Rico Schouten()");
        Label welcomeText = new Label("Cursus aanmaken");
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

        // Labelling the input field
        Label courseNameLabel = new Label("Cursus naam: ");
        courseNameLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(courseNameLabel, 0, 0);
        grid.getChildren().add(courseNameLabel);

        Label courseSubjectLabel = new Label("Cursus onderwerp: ");
        courseSubjectLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(courseSubjectLabel, 0, 1);
        grid.getChildren().add(courseSubjectLabel);

        Label courseIntroductoryTextLabel = new Label("Cursus inleiding: ");
        courseIntroductoryTextLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(courseIntroductoryTextLabel, 0, 2);
        grid.getChildren().add(courseIntroductoryTextLabel);

        Label courseDifficultyLabel = new Label("Cursus niveau: ");
        courseDifficultyLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(courseDifficultyLabel, 0, 3);
        grid.getChildren().add(courseDifficultyLabel);

        Label courseModuleLabel = new Label("Cursus module(s): ");
        courseModuleLabel.setStyle("-fx-font-size:2em; ");
        GridPane.setConstraints(courseModuleLabel, 0, 4);
        grid.getChildren().add(courseModuleLabel);

        // Defining the Name text field
        final TextField courseName = new TextField();
        courseName.setPromptText("Voer naam van cursus in.");
        courseName.setPrefColumnCount(10);
        courseName.getText();
        GridPane.setConstraints(courseName, 1, 0);
        grid.getChildren().add(courseName);

        // Defining the subject text field
        final TextField courseSubject = new TextField();
        courseSubject.setPromptText("Voer onderwerp in.");
        GridPane.setConstraints(courseSubject, 1, 1);
        grid.getChildren().add(courseSubject);

        // Defining the intro text field
        final TextArea courseIntroductoryText = new TextArea();
        courseIntroductoryText.setPrefColumnCount(40);
        courseIntroductoryText.setPromptText("Voer inleiding in.");
        GridPane.setConstraints(courseIntroductoryText, 1, 2);
        grid.getChildren().add(courseIntroductoryText);

        // Defining the difficulty text field
        final ComboBox courseDifficulty = new ComboBox();
        courseDifficulty.setPromptText("Niveau");
        courseDifficulty.getItems().addAll("Beginner", "Gevorderd", "Expert");
        GridPane.setConstraints(courseDifficulty, 1, 3);
        grid.getChildren().add(courseDifficulty);

        // Defining the module
        TableView courseListModule = new TableView();
        courseListModule.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        courseListModule.setPrefSize(600, 600);

        // Make columns
        TableColumn<Module, CheckBox> column1 = new TableColumn<>("Toevoegen");
        column1.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        TableColumn<Module, String> column2 = new TableColumn<>("Titel");
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Module, String> column3 = new TableColumn<>("Versie");
        column3.setCellValueFactory(new PropertyValueFactory<>("version"));
        TableColumn<Module, String> column4 = new TableColumn<>("Beschrijving");
        column4.setCellValueFactory(new PropertyValueFactory<>("description"));
        TableColumn<Module, String> column5 = new TableColumn<>("Naam van contactpersoon");
        column5.setCellValueFactory(new PropertyValueFactory<>("nameOfContact"));

        // Add columns to table
        courseListModule.getColumns().add(column1);
        courseListModule.getColumns().add(column2);
        courseListModule.getColumns().add(column3);
        courseListModule.getColumns().add(column4);
        courseListModule.getColumns().add(column5);

        ArrayList<addModule> arrayListModule = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            addModule addModule1 = new addModule((new CheckBox()), "Elements and Structure", String.valueOf(04 + i),
                    "Learn about HTML elements and structure, the building blocks of websites.", "Harley Bray");
            courseListModule.getItems().add(addModule1);
            arrayListModule.add(addModule1);
        }

        GridPane.setConstraints(courseListModule, 1, 4);
        grid.getChildren().add(courseListModule);

        // Defining the Submit button
        Button submit = new Button("Aanmaken");
        submit.setStyle("-fx-font-size: 2em; -fx-background-color: #1da06a");
        GridPane.setConstraints(submit, 2, 0);
        grid.getChildren().add(submit);

        // Defining the Clear button
        Button clear = new Button("Leeg maken");
        clear.setStyle("-fx-font-size: 2em; -fx-background-color: #f2a81d");
        GridPane.setConstraints(clear, 2, 1);
        grid.getChildren().add(clear);

        // Adding a Label to display a response
        final Label label = new Label();
        label.setStyle("-fx-font-size: 2em; ");
        GridPane.setConstraints(label, 1, 5);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

        // Create a back button
        Button backButton = new Button("Terug");
        backButton.setStyle("-fx-font-size: 2em; -fx-background-color: #8F8F8F;");
        backButton.setEffect(new DropShadow());

        // Putting the backbutton inside hbox2
        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(backButton);

        // Create a layout
        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(hbox2, Pos.BOTTOM_LEFT);
        layout.setBottom(hbox2);
        layout.setAlignment(hbox1, Pos.CENTER);
        layout.setCenter(hbox1);

        // Start scene
        Scene sc = new Scene(layout, 960, 600, Color.GREY);

        layout.setStyle("-fx-background-color: #d6d6d6;");
        createCourseStage.setScene(sc);
        createCourseStage.setMaximized(true);
        createCourseStage.show();

        // Back Button Action
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                CourseScene courseScene = new CourseScene();
                Stage scene2 = new Stage();
                try {
                    courseScene.start(scene2);
                    createCourseStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // Setting an action for the Submit button
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Boolean isTrue = false;
                for (addModule i : arrayListModule) {
                    if (i.getCheckBox().isSelected()) {
                        isTrue = true;
                    }
                }
                if ((courseIntroductoryText.getText() != null && !courseIntroductoryText.getText().isEmpty())
                        && (courseName.getText() != null && !courseName.getText().isEmpty())
                        && (courseSubject.getText() != null && !courseSubject.getText().isEmpty())
                        && (courseDifficulty.getValue() != null) && isTrue) {
                            Course course = new Course("i", "i", "i", "i");
                            String[] input = {courseName.getText(), courseSubject.getText(), courseIntroductoryText.getText(), courseDifficulty.getValue().toString()};
                            course.insertCourse(input);
                    label.setText("Cursus, " + courseName.getText() + ", is aangemaakt.");
                } else {
                    if (!isTrue) {
                        label.setText("U heeft geen modules voor de cursus geselecteerd, probeer opnieuw.");
                    }

                    if (courseDifficulty.getValue() == null) {
                        label.setText("U heeft geen niveau voor de cursus ingevoerd, probeer opnieuw.");
                    }

                    if (courseIntroductoryText.getText().isEmpty()) {
                        label.setText("U heeft geen inleiding voor de cursus ingevoerd, probeer opnieuw.");
                    }

                    if (courseSubject.getText().isEmpty()) {
                        label.setText("U heeft geen onderwerp voor de cursus ingevoerd, probeer opnieuw.");
                    }

                    if (courseName.getText().isEmpty()) {
                        label.setText("U heeft geen naam voor de cursus ingevoerd, probeer opnieuw.");
                    }
                }
            }
        });

        // Setting an action for the Clear button
        clear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                courseName.clear();
                courseSubject.clear();
                courseIntroductoryText.clear();
                label.setText(null);
                courseDifficulty.setValue(null);
                courseDifficulty.setPromptText("Niveau");
                for (addModule i : arrayListModule) {
                    i.getCheckBox().setSelected(false);
                }
            }
        });
    }
}