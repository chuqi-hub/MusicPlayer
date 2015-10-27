package musicplayer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;

public class SongsController implements Initializable {

    @FXML
    private TableView<Song> tableView;

    @FXML
    private TableColumn<Song, String> songColumn;

    @FXML
    private TableColumn<Song, String> artistColumn;

    @FXML
    private TableColumn<Song, String> albumColumn;

    @FXML
    private TableColumn<Song, String> lengthColumn;

    @FXML
    private TableColumn<Song, Integer> playsColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Song> songs = Library.getSongs();

        songColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        artistColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        albumColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        lengthColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        playsColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));

        songColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("title"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
        albumColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("album"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("lengthAsString"));
        playsColumn.setCellValueFactory(new PropertyValueFactory<Song, Integer>("playCount"));

        tableView.setItems(songs);
    }

}