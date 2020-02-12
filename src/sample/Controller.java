package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Controller {
    public Button btnFile;
    public Button btnEncrypt;
    public Button btnDecrypt;
    public Label lblOriginal;
    public Label lblChanged;
    public TextField txtText;
    public Label lblPath;

    private DataFile dataFile = new DataFile();
    JFileChooser fileChooser = new JFileChooser(".");
    File selectedFile;


    public void initialize() {


        btnEncrypt.setDisable(true);
        btnDecrypt.setDisable(true);


    }

    public void handleOtherCharacters(){
        txtText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                txtText.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
    }

    public void handleKeyReleased() {
        String text = txtText.getText();
        boolean disableBtn = text.isEmpty() || text.trim().isEmpty();
        btnEncrypt.setDisable(disableBtn);
        btnDecrypt.setDisable(disableBtn);


    }


    public void showFileChooser() {

        int status = fileChooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            System.out.println(selectedFile.getAbsolutePath());
            lblPath.setText("You selected: " + selectedFile.getAbsolutePath());
            lblOriginal.setText("Original text:" + dataFile.printFileData(selectedFile.getAbsolutePath()));
            lblChanged.setText("");


        } else if (status == JFileChooser.CANCEL_OPTION) {
            System.out.println("canceled");
        }
    }

    public void encrypt() throws IOException {

        selectedFile = fileChooser.getSelectedFile();
        String target = selectedFile.getParent() + "\\data_encrypted.txt";
        dataFile.encrypt(selectedFile.getAbsolutePath(), target, lblOriginal.getText(), txtText.getText());


        lblChanged.setText("Encrypted text: " + dataFile.printFileData(target));


    }


    public void decrypt() throws IOException {

        selectedFile = fileChooser.getSelectedFile();
        String target = selectedFile.getParent() + "\\data_decrypted.txt";
        dataFile.decrypt(selectedFile.getAbsolutePath(), target, lblOriginal.getText(), txtText.getText());

        lblChanged.setText("Decrypted text: " + dataFile.printFileData(target));
    }

}
