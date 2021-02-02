
package workbase;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Контролер для вікна підбору вакансій
 *
 * @author User
 */
public class SearchPanelController implements Initializable {

    private ObservableList<jobs> jobsData = FXCollections.observableArrayList();
    
    @FXML
    private TableColumn<jobs, String> jobName;
    
    @FXML
    private TableColumn<jobs, String> areaName;
    
    @FXML
    private TableColumn<jobs, String> eduName;
    
    @FXML
    private TableColumn<jobs, String> expName;
    
    @FXML
    private TableColumn<jobs, String> numberName;
    
    
    @FXML
    private ComboBox cbArea,cbEdu,cbExp;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView tableJobs;
    
    Connection co;
    int checkSuccesfull;
    
    @FXML
    private void btnSearchClicked(ActionEvent event){
        try {
            String filterArea = "%%";
            String filterExp = "%%";
            String filterEdu = "%%";
            System.out.println("here");
            
            try {
                filterArea = cbArea.getValue().toString();

            } catch (Exception e) {
                
            }
            try{
                filterExp = cbExp.getValue().toString();
            } catch (Exception e){
                
            }
            try{
                filterEdu = cbEdu.getValue().toString();
            } catch (Exception e){
                
            }
            System.out.println("her2e");
            tableJobs.getItems().clear();
            jobsData.removeAll();
            
            try {
                Statement statement = co.createStatement();
                String query
                        = "SELECT * "
                        + "FROM jobs_info WHERE area LIKE '" + filterArea 
                        + "' AND education LIKE '" + filterEdu + "' AND exp LIKE '" + filterExp + "'";
                
                System.out.println(query);
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    jobsData.add(new jobs(Integer.parseInt(rs.getString("id")),
                            rs.getString("name"),
                            rs.getString("area"),
                            rs.getString("education"),
                            rs.getString("exp"),
                            rs.getString("number")));
                }
                rs.close();
                statement.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }                    
            tableJobs.setItems(jobsData);
                
            
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка!");
            alert.setHeaderText("Помилка у введенні даних. Спробуйте ще раз");
            //alert.setContentText("*Для виходу з програми перейдіть до пункту 'Додатково' та оберіть 'Вихід з програми'");
            alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
            alert.close();
             }
            });
        }
    }
    @FXML
    private void cbAreaChanged(ActionEvent event){
        btnSearch.setDisable(false);
    }
    @FXML
    private void cbExpChanged(ActionEvent event){
        btnSearch.setDisable(false);
    }
    @FXML
    private void cbEduChanged(ActionEvent event){
        btnSearch.setDisable(false);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        cbArea.getItems().addAll("Розваги","IT","Бухгалтерія","Продажі","Транспорт","Охорона, безпека","Дизайн");
        cbEdu.getItems().addAll("Відсутня","Повна середня","Спеціальна середня","Початкова вища","Вища освіта");
        cbExp.getItems().addAll("Відcутній","1-3 роки","3-5 років","10+ років");
        jobName.setCellValueFactory(new PropertyValueFactory<jobs, String>("name"));
        areaName.setCellValueFactory(new PropertyValueFactory<jobs, String>("area"));
        eduName.setCellValueFactory(new PropertyValueFactory<jobs, String>("edu"));
        expName.setCellValueFactory(new PropertyValueFactory<jobs, String>("exp"));
        numberName.setCellValueFactory(new PropertyValueFactory<jobs, String>("number"));
    }    
    
}
