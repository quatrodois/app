package app.Codecademy.UI;

import java.security.Signature;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JOptionPane;

import app.Codecademy.DB.CertificateSql;
import app.Codecademy.DB.RegistrationSql;
import app.Codecademy.DB.SqlManager;
import app.Codecademy.Domain.Certificate;
import app.Codecademy.Domain.Course;
import app.Codecademy.Domain.Registration;
import app.Codecademy.Domain.Student;
import app.Codecademy.Domain.Webcast;
import app.Codecademy.Logic.Validator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
// import jdk.internal.util.xml.impl.Input;
import jdk.jfr.ValueDescriptor;

public class CertificateScene extends Application {

    @Override
    public void start(Stage certificateStage) throws Exception {
        // TODO Auto-generated method stub
        certificateStage.setTitle("Wessel Kuijstermans(2166881), Mark Gonzalez Avila(), Mart van Holten(), Rico Schouten()");

        Label welcomeText = new Label("Certificaat afronden");
        welcomeText.setStyle("-fx-font-size:8em; ");
        Button backButton = new Button("Terug");

        // Table view all webcasts
        TableView certificateView = new TableView();
        certificateView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        certificateView.setPrefSize(600, 400);

        // TextField textField = new TextField(input.get(count));
        // textField.setUserData(enumElement);
        // textField.setOnAction(event - > {
        //     System.out.println("Gotcha");
        // });
        // TextField textField = new TextField();
        // Make columns
        TextFieldTableCell textfield = new TextFieldTableCell < > ();
        TableColumn < Registration, String > column1 = new TableColumn < > ("Cursist");
        column1.setCellValueFactory(new PropertyValueFactory < > ("studentEmail"));
        TableColumn < Registration, String > column2 = new TableColumn < > ("Cursus");
        column2.setCellValueFactory(new PropertyValueFactory < > ("courseName"));
        TableColumn < Registration, Date > column3 = new TableColumn < > ("Registratie datum");
        column3.setCellValueFactory(new PropertyValueFactory < > ("registrationDate"));
        TableColumn < Registration, Double > column4 = new TableColumn < > ("Beoordeling");
        column4.setCellValueFactory(new PropertyValueFactory < > ("grade"));
        TableColumn < Registration, TextField > column5 = new TableColumn < > ("Ondertekenaar");
        column5.setCellValueFactory(new PropertyValueFactory < Registration, TextField > ("textField"));
        // TableColumn < Registration, String > column5 = new TableColumn < > ("Ondertekenaar");
        // column5.setCellValueFactory(new PropertyValueFactory < > ("textField"));

        // column5.setCellFactory(TextFieldTableCell. < tableClass > forTableColumn());

        // TableColumn<Registration, CheckBox> column5 = new TableColumn<>("Handtekening");
        // column5.setCellValueFactory(new PropertyValueFactory<>("signature"));

        // Add columns to table
        certificateView.getColumns().add(column1);
        certificateView.getColumns().add(column2);
        certificateView.getColumns().add(column3);
        certificateView.getColumns().add(column4);
        certificateView.getColumns().add(column5);

        // CheckBox checkBoxSignature = new CheckBox();
        // String str = "2020-03-31";
        // Date date = Date.valueOf(str);
        // Button registrationConfirmButton = new Button("ok");

        Registration registration = new Registration("", "", Date.valueOf("2020-03-31"), 0, "", 0);
        registration.getUnfinishedRegistrationResult();
        ArrayList < Registration > registrationList = registration.getUnfinishedRegistrationInfo();

        // Create a row for every entry in the table and add its information to the
        // right spot

        for (Registration x: registrationList) {
                int i = 1;
                certificateView.getItems().add(new addRegistration(x.getStudentEmail(), x.getCourseName(),
                    x.getRegistrationDate(), x.getGrade(), x.getSignatoryName()));
        }



        // Button to confirm
        Button button = new Button("Confirm");
        button.setStyle("-fx-font-size: 2em; ");

        // Adding a Label to display a response
        final Label label = new Label();
        label.setStyle("-fx-font-size: 2em; ");

        HBox hBox = new HBox();
        VBox vbox = new VBox();



        // VBox vboxTextfields = new VBox();
        // int length = registrationList.size();
        // for (int i = 0; i< length; i++){
        //     String textfieldname = "textfield" + i;
        //     TextField  = new TextField(textfieldname);
        // }


        // vboxTextfields.getChildren().addAll(tex);
        vbox.getChildren().addAll(certificateView, button, label);
        vbox.setSpacing(100);
        // hBox.getChildren().addAll(vbox, vboxTextfields);

        BorderPane layout = new BorderPane();
        layout.setAlignment(welcomeText, Pos.TOP_CENTER);
        layout.setTop(welcomeText);
        layout.setAlignment(backButton, Pos.BOTTOM_LEFT);
        layout.setBottom(backButton);
        layout.setAlignment(vbox, Pos.CENTER);
        layout.setCenter(vbox);

        Scene sc = new Scene(layout, 960, 600, Color.GREY);

        certificateStage.setScene(sc);
        certificateStage.setMaximized(true);
        certificateStage.show();


        // public void captureText(ActionEvent e) {
        //     registrationList.forEach(event -> {
        //         event.setCol1(event.getTextField().getText());
        //     });
        // }
        SqlManager manager = new SqlManager();
        CertificateSql certificateSql = new CertificateSql();

        button.setOnAction(new EventHandler < ActionEvent > () {
            @Override
            public void handle(ActionEvent e) {
                System.out.println(certificateView.getItems().size());
                for (int i = 0; i < certificateView.getItems().size(); i++) {
                    if (column5.getCellData(i).getText() != null) {
                        Validator validator = new Validator();
                        if (validator.signatoryNameValidator(column5.getCellData(i).getText())) {
                        manager.executeSql(certificateSql.updateCertificateSql(registrationList.get(i).getCertificateID(), column5.getCellData(i).getText()));
                        System.out.println(column5.getCellData(i).getText());
                        label.setText("Het certificaat van student " + registrationList.get(i).getStudentEmail() + " is afgerond!");
                    } else {
                        label.setText("Vul een valide naam in");
                        System.out.println("Wat in de tyfus");
                    }
                    }
                }
                System.out.println("button pressed");
                System.out.println(column5.getCellData(1).getText());


                //     for (Registration x: registrationList) {
                //         if (x.getTextField().getText() != null) {
                //             if (!x.getTextField().getText().isEmpty()) {
                //                 System.out.println("De signatory names zijn:");
                //                 System.out.println(x.getTextField().getText());
                //             }
                //         }
                //     }

                //     for (Registration x : registrationList) {
                //         if (x.getSignatoryName() != null) {
                //         if (!x.getSignatoryName().isEmpty()) {
                //             System.out.println("de signatory name met 'signatoryName' is:");
                //             System.out.println(x.getSignatoryName());
                //         }
                //     }
                // }
                // for (Registration x: registrationList){
                //     if(!x.getTextField().getText().isEmpty()){
                //         System.out.println(x.getTextField().getText());
                //     }
                // }
                // }
            }
        });
        // button.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent e) {
        //         boolean itemsChecked = false;
        //         for (Registration i : registrationList) {
        //             if (i.getSignature().isSelected()) {
        //                 label.setText("De certificatie (van " + i.getStudentEmail() + ") is goedgekeurd en opgeslagen");
        //                 itemsChecked = true;
        //             } else { 
        //             }
        //             System.out.println(i);
        //         }
        //         if (itemsChecked) {
        //         } else {
        //             label.setText("Er is iets misgegaan");
        //         }
        //     }
        // });
        backButton.setOnAction((EventHandler < ActionEvent > ) new EventHandler < ActionEvent > () {
            @Override
            public void handle(ActionEvent e) {
                Main main = new Main();
                Stage scene2 = new Stage();
                try {
                    main.start(scene2);
                    certificateStage.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}