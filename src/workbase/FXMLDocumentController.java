/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Контролер головного вікна програми 
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private void menuDelAction(ActionEvent event){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("delJobPanel.fxml"));
            stage.setTitle("Видалення");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void menuClose(ActionEvent event){
        System.exit(0);
    }
    /**
     * 
     * @param event 
     */
    @FXML
    private void menuAboutDev(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Розробник");
        alert.setHeaderText("Розробником програми є Надточій Ілля Сергійович");
        alert.setContentText("Пошта для зв'язку noreply@gmail.com");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                alert.close();
            }
        });
    }
    /**
     * 
     * @param event 
     */
    @FXML
    private void menuAboutProg(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Програма");
        alert.setHeaderText("Программа Work Base призначеня для підбору вакансій. \nЕлементи керування описані в пункті меню 'Довідка'");
        alert.setContentText("Пошта для зв'язку noreply@gmail.com");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                alert.close();
            }
        });
    }
    /**
     * 
     * @param event 
     */
    @FXML
    private void menuWorkAction(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Довідка");
        alert.setHeaderText("Для підбору вакансії оберіть перший пункт головного меню.\nДля перегляду або додавання вакансій оберіть відповідний пункт меню");
        alert.setContentText("*Для виходу з програми натисніть відповідну кнопку");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                alert.close();
                 }
            });
    }
    /**
     * 
     * @param event 
     */
    @FXML
    private void btnSearchClicked(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("searchPanel.fxml"));
            stage.setTitle("Пошук вакансії");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
    /**
     * 
     * @param event 
     */
    @FXML
    private void btnCreateClicked(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("addNewJobPanel.fxml"));
            stage.setTitle("Створення вакансії");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
    /**
     * 
     * @param event 
     */
    @FXML
    private void btnShowAllClicked(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("showAllPanel.fxml"));
            stage.setTitle("Перегляд всіх вакансій");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }
    /**
     * 
     * @param event 
     */
    @FXML
    private void btnExitClicked(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
