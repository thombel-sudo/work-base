
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Контролер вікна видалення вакансій
 *
 * @author User
 */
public class DelJobPanelController implements Initializable {
    @FXML
    private TextField lblDelete;
    
    private ObservableList<jobs> jobsData = FXCollections.observableArrayList();
    @FXML
    private TableView<jobs> tableJobs;
    
    @FXML
    private TableColumn<jobs, String> idName;
    
    @FXML
    private TableColumn<jobs, String> jobName;
    
    @FXML
    private TableColumn<jobs, String> areaName;
    
    @FXML
    private TableColumn<jobs, String> eduName;
    
    @FXML
    private TableColumn<jobs, String> expName;
    Connection co;
    @FXML
    private void btnDeleteClick(ActionEvent event){
        if(lblDelete.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Результат дії");
                alert.setHeaderText(null);
                alert.setContentText("Помилка видалення!");
                alert.showAndWait();
		//System.out.println( e.getMessage());
        }else{
            try{
		String query = 
		"DELETE FROM jobs_info WHERE id= " + Integer.parseInt(lblDelete.getText()) +  ";";
		Statement statement = co.createStatement();
		statement.executeUpdate(query);
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
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Результат дії");
                alert.setHeaderText(null);
                alert.setContentText("Помилка видалення!");
                alert.showAndWait();
		System.out.println( e.getMessage());
		}
                loadTable();
        }
    }
    @FXML
    private TableColumn<jobs, String> numberName;
    /**
     * Функція для завантаження даних до таблиці
     */
    void loadTable(){
        
        
        try
                {
                Statement statement = co.createStatement();
                String query = 
                        "SELECT * "
                        + "FROM jobs_info "
                        + "ORDER BY id";
                ResultSet rs = statement.executeQuery (query);
                while (rs.next())
                        {
                         jobsData.add(new jobs(Integer.parseInt(rs.getString("id")),
                                                rs.getString("name"),
                                                rs.getString("area"),
                                                rs.getString("education"),
                                                rs.getString("exp"),
                                                rs.getString("number")));
                                               
                        }
                rs.close();
                statement.close();
                }
            catch (Exception e)
		{
		System.out.println( e.getMessage());
		}
        tableJobs.setItems(jobsData);
    }
    /**
     * Ініціалізація класу.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idName.setCellValueFactory(new PropertyValueFactory<jobs, String>("id"));
        jobName.setCellValueFactory(new PropertyValueFactory<jobs, String>("name"));
        areaName.setCellValueFactory(new PropertyValueFactory<jobs, String>("area"));
        eduName.setCellValueFactory(new PropertyValueFactory<jobs, String>("edu"));
        expName.setCellValueFactory(new PropertyValueFactory<jobs, String>("exp"));
        numberName.setCellValueFactory(new PropertyValueFactory<jobs, String>("number"));
        try
		{
			Class.forName("org.sqlite.JDBC");
			co = DriverManager.getConnection ( "jdbc:sqlite:database\\jobs_database.db" );
			//System.out.println("Connected");
                       
		}
		catch (Exception e)
		{
			System.out.println( e.getMessage());
                       
		}
        loadTable();
    }    
    
}
