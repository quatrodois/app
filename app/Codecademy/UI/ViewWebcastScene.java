package app.Codecademy.UI;

import app.Codecademy.Domain.ContentItems;
import app.Codecademy.Domain.Webcast;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewWebcastScene extends Application {
    @Override
    public void start(Stage viewWebcastStage) throws Exception {
        // TODO Auto-generated method stub
        viewWebcastStage.setTitle("Wessel Kuijstermans(2166881), Mark Gonzalez Avila(), Mart van Holten(), Rico Schouten()");

        // Welcome text and back button
        Label welcomeText = new Label("Webcast");
        welcomeText.setStyle("-fx-font-size:8em; ");
        Button backButton = new Button("Terug");
        Label labelData = new Label("Gegevens");
        Label allCertificates = new Label("Behaalde certificaten");

        TableView tableView = new TableView<>();

        TableColumn<ContentItems, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("ContentItemID"));
        TableColumn<Webcast, String> column2 = new TableColumn<>("Naam");
        column2.setCellValueFactory(new PropertyValueFactory<>("Title"));
        TableColumn<Webcast, String> column3 = new TableColumn<>("Naam spreker");
        column3.setCellValueFactory(new PropertyValueFactory<>("SpeakerName"));
        TableColumn<Webcast, String> column4 = new TableColumn<>("Organisatie");
        column4.setCellValueFactory(new PropertyValueFactory<>("Organisation"));
        TableColumn<Webcast, String> column5 = new TableColumn<>("Beschrijving");
        column5.setCellValueFactory(new PropertyValueFactory<>("Discription"));
        TableColumn<Webcast, String> column6 = new TableColumn<>("Publicatiedatum");
        column6.setCellValueFactory(new PropertyValueFactory<>("PublicationDate"));
        TableColumn<Webcast, String> column7 = new TableColumn<>("Status");
        column7.setCellValueFactory(new PropertyValueFactory<>("Status"));
        TableColumn<Webcast, String> column8 = new TableColumn<>("URL");
        column8.setCellValueFactory(new PropertyValueFactory<>("URL"));
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.getColumns().add(column8);

        HBox hbox = new HBox();
        hbox.setSpacing(50);

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
        viewWebcastStage.setScene(sc);
        viewWebcastStage.setMaximized(true);
        viewWebcastStage.show();

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
                    viewWebcastStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}
