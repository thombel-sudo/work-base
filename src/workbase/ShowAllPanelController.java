/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbase;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * Контролер для вікна перегляду всіх вакансій
 *
 * @author User
 */
public class ShowAllPanelController implements Initializable {

    private ObservableList<jobs> jobsData = FXCollections.observableArrayList();
    @FXML
    private TableView<jobs> tableJobs;
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
    private TableColumn<jobs, String> numberName;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    
}
