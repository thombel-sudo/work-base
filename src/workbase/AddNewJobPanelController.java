/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbase;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Контролер вікна додавання вакансій
 *
 * @author User
 */
public class AddNewJobPanelController implements Initializable {
    @FXML
    private TextField tbName, tbNumber;
    @FXML
    private ComboBox cbArea,cbExp, cbEdu;
    @FXML
    private Button btnAdd;
    
    Connection co;
    
    @FXML
    private void btnAddClicked(ActionEvent event){
        if(checkFill() == 1){
            
            try
		{
                //String text = txtQuestion.getText();
                
		String query = 
		"INSERT INTO jobs_info(name,area,education,exp,number) " +
		"VALUES(?,?,?,?,?)";
		PreparedStatement statement = co.prepareStatement(query);
                    statement.setString(1, tbName.getText());
                    statement.setString(2, cbArea.getValue().toString());
                    statement.setString(3, cbEdu.getValue().toString());
                    statement.setString(4, cbExp.getValue().toString());
                    statement.setString(5, tbNumber.getText());
                 
                
		statement.executeUpdate();
                statement.close();
                System.out.println("Success");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Результат дії");
                alert.setHeaderText(null);
                alert.setContentText("Запит виконано!");
                alert.showAndWait();
		}
		catch (Exception e)
		{
		System.out.println( e.getMessage());
		}
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Помилка");
                alert.setHeaderText(null);
                alert.setContentText("Заповніть всі поля!");
                alert.showAndWait();
        }
    }
    /**
     * Перевірка наявності даних
     * @return результат перевірки
     */
    int checkFill(){
        if(tbName.getText().isEmpty()|| tbNumber.getText().isEmpty()){
            return 0;
        }
        return 1;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbArea.getItems().addAll("Розваги","IT","Бухгалтерія","Продажі","Транспорт","Охорона, безпека","Дизайн");
        cbEdu.getItems().addAll("Відсутня","Повна середня","Спеціальна середня","Початкова вища","Вища освіта");
        cbExp.getItems().addAll("Відcутній","1-3 роки","3-5 років","10+ років");
        try
		{
			Class.forName("org.sqlite.JDBC");
			co = DriverManager.getConnection ( "jdbc:sqlite:database\\jobs_database.db" );
			System.out.println("Connected");
                       
		}
		catch (Exception e)
		{
			System.out.println( e.getMessage());
                       
		}
    }    
    
}
