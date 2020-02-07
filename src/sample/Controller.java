package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Controller {


    public Button btnChoose;
    public Pane pane;
    public TextField txtText;
    public Button btnEncrypt;
    public Button btnDecrypt;
    public Label lblOriginal;
    public Label lblPath;
    public Label lblEncrypted;

    JFileChooser fileChooser = new JFileChooser(".");


    public void initialize() {
//        if (txtText.getText().isEmpty()) {
//            btnEncrypt.setDisable(true);
//            btnDecrypt.setDisable(true);
//        }

        DataFile dataFile = new DataFile();
        dataFile.ddd("Computer programming is the process of designing and building an executable computer program to accomplish a specific computing result.",
                "zebra");


    }

    public void openFileChooser() {

//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open file");
//        Stage stage = (Stage) pane.getScene().getWindow();
//
//        fileChooser.showOpenDialog(stage);



        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();


            lblPath.setText(selectedFile.getPath());

            DataFile dataFile = new DataFile();
            dataFile.printFile(selectedFile.getPath());

            lblOriginal.setText(String.valueOf(dataFile.printFile(selectedFile.getPath())));


        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("canceled");
        }


    }



    public void encrypt() throws IOException {

        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            DataFile dataFile = new DataFile();



            dataFile.encrypt(selectedFile.getAbsolutePath(), selectedFile.getPath()+"_encrypted.txt", lblOriginal.getText(), txtText.getText().toUpperCase() );


        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("canceled");
        }
    }

}
