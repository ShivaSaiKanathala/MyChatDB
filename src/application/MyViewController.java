package application;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.FileChooser;
import application.database;




public class MyViewController implements Initializable{	
	
	
//    @FXML	
//    ComboBox<Object> color = new ComboBox<Object>(); 
    @FXML	
    ComboBox<Object> color1 = new ComboBox<Object>(); 
    
    @FXML
	AnchorPane root = new AnchorPane();
    @FXML
   	AnchorPane root1 = new AnchorPane();
    
    @FXML
    ComboBox<Object> font1 = new ComboBox<Object>();
   
    @FXML
    TextArea text = new TextArea();
    @FXML
    Text t = new Text();
    @FXML
    TextArea text1 = new TextArea("Enter your message here...");
    
    @FXML
    ComboBox<Object> text_color1= new ComboBox<Object>();
    
    @FXML
    Button send1 = new Button("Send");
    
    @FXML
	Button clear1 = new Button("Clear");
    
    @FXML
	Button imgbtn = new Button();
    
    @FXML
    VBox flow = new VBox();
    @FXML
    TextArea newtext = new TextArea();
    @FXML
    TextFlow textflow1 = new TextFlow();
	@FXML 
	Stage window1 = new Stage();
    @FXML 
    ImageView myImageView = new ImageView();
    
    @FXML
    TextField message1 = new TextField();
    @FXML
    TextField message2 = new TextField();
    
    @FXML
    javafx.scene.control.TextField first = new javafx.scene.control.TextField();
    
    @FXML
    javafx.scene.control.TextField last = new javafx.scene.control.TextField();
    
    
    @FXML
    Button ButtonSave;
    
    @FXML
    RadioButton Male,Female;
    
    @FXML
    database db ;
    
    @FXML
    ComboBox<String> month,date,year;
    
    @FXML
    CheckBox c1,c2,c3,c4,c5,c6;
   
    
    public Label fileSelected;
    
    public String imageFile;
	
	
	 @FXML
	    ImageView image1 = new ImageView();
	 
	/* @FXML
	    ImageView image2 = new ImageView();*/
	
	public MyViewController() {
    	
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
  
    	root1.setStyle("-fx-background-color: pink;");
    	

	}
   
  
    @FXML
	final public void sendfunc1() {
    	
    	
    	int index1 = color1.getSelectionModel().getSelectedIndex();
    	if(index1 == 0) {
    		root1.setStyle("-fx-background-color: black;");
    	}else if(index1 == 1) {
    		root1.setStyle("-fx-background-color: silver;");
    	}else if(index1 == 2) {
    		root1.setStyle("-fx-background-color: grey;");
    	}else if(index1 == 3) {
    		root1.setStyle("-fx-background-color: pink;");
    	}else if(index1 == 4) {
    		root1.setStyle("-fx-background-color: white;");
    	}else if(index1 == 5) {
    		root1.setStyle("-fx-background-color: gold;");
    	}else if(index1 == 6) {
    		root1.setStyle("-fx-background-color: blue;");
    	}else if(index1 == 7) {
    		root1.setStyle("-fx-background-color: yellow;");
    	}else if(index1 == 8) {
    		root1.setStyle("-fx-background-color: red;");
    	}else if(index1 == 9) {
    		root1.setStyle("-fx-background-color: green;");
    	}else {
    		root1.setStyle("-fx-background-color: pink;");
    	}	
	 }
    
    @FXML
    public void setfont1() {
    	//text1.getStyleClass().add("block");
    	
    	int index3 = font1.getSelectionModel().getSelectedIndex();	
    	if(index3 == 0 || index3 == 1 ||index3 == 2 ||index3 == 3 ||index3 == 4 ||index3 == 5)
		
			text1.setStyle("-fx-font-size: "+font1.getValue()+"pt;" + "-fx-text-fill :" +text_color1.getValue() );
		
		}
    
   
    @FXML
    public void settextcolor1() {
    	//text1.getStyleClass().add("block");
    	//text1.setStyle("-fx-font-size :"+ font1.getValue()+"pt;");
    	int index5 = text_color1.getSelectionModel().getSelectedIndex();		
    	if(index5 == 0 || index5 == 1 ||index5 == 2 ||index5 == 3 ||index5 == 4 ||index5 == 5||index5 == 6 ||index5 == 7 ||index5 == 8 )
		
			text1.setStyle("-fx-font-size :"+ font1.getValue()+"pt;"+"-fx-text-fill :"+text_color1.getValue());
		}
    
  @FXML
  public void send1() {

			if (text1.getText()!= null)
			
			append1(LocalTime.now()+ "\n");
			append1("user1 :" +text1.getText());
			//append1(text1.getText());				
			append1("\n");
			
			refreshData1();
	  
	 
	  
  }
	
  
  
  
	 @FXML
	public void clear1() {
		 text1.clear();
	}


	@FXML
	public synchronized void append1(String text) {

		Text t1 = new Text(text);
		Text t2 = new Text(text);
		if(text.contains("user1 :")) {
		t1.setStyle("-fx-font-size :"+ font1.getValue()+"pt;"+"-fx-fill :"+text_color1.getValue());
	    t2.setStyle("-fx-font-size :"+ font1.getValue()+"pt;"+"-fx-fill :"+text_color1.getValue());
	   


	    
	    textflow1.getChildren().add(t1);
		
		
		}
		else {
			textflow1.getChildren().add(t1);
			
			
		}
		System.out.println(font1.getValue());	
	}
	
	@FXML
	private void refreshData1() {
		// TODO Auto-generated method stub
		text1.clear();
		
	}
	
	@FXML
	private void newimage() throws IOException {
		 FileChooser fileChooser = new FileChooser();
	        fileChooser.setTitle("Select Image File");
	        fileChooser.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("Image Files",
	                        "*.bmp", "*.png", "*.jpg", "*.gif")); // limit fileChooser options to image file
	        File selectedFile = fileChooser.showOpenDialog(null);
	       
	        

	        if(selectedFile != null) {
	        	
	        	 imageFile = selectedFile.toURI().toURL().toString();
	        	 javafx.scene.image.Image image = new javafx.scene.image.Image(imageFile);
	        	 //Image image = new Image(imageFile);
	        	 myImageView.setImage(image);
	        	 image1.setImage(image);
	        	
	        } else {
	        	
	        	image1.setImage(myImageView.getImage());
	        	
	        }      
	}
	@FXML
	private void imagepicker1() {
		try {
			imagepick();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@FXML 
	private void imagepick() throws IOException {
	
		
		FXMLLoader loader3 = new FXMLLoader(getClass().getResource("Info.fxml"));	
		Parent root1 = loader3.load();
		MyViewController first1 = loader3.getController();
		Scene scene3 = new Scene(root1, 600, 630);
		Stage stage3 = new Stage();
        stage3.setScene(scene3);
        stage3.setTitle("MyInfo");
		stage3.show();
		
		
		}
	
	@FXML
	private void cancel() {
		myImageView.getScene().getWindow().hide();
	}
	
	@FXML
	private void save() throws SQLException {
			
			String gender = null;
			if(Male.isSelected())
				gender = "Male";
			else if(Female.isSelected())
				gender = "Female";
			// for cb
			String checkbox = "";
			
			if(c1.isSelected())
			{
				checkbox+="1";
			}
			if(c2.isSelected())
			{
				checkbox+="2";
			}
			if(c3.isSelected())
			{
				checkbox+="3";
			}
			if(c4.isSelected())
			{
				checkbox+="4";
			}
			if(c5.isSelected())
			{
				checkbox+="5";
			}
			if(c6.isSelected())
			{
				checkbox+="6";
			}
	
			String firstname = first.getText().toString();
			String lastname = last.getText().toString();
			String image = imageFile.toString();
			String mon = month.getSelectionModel().getSelectedItem().toString();
			String dte = date.getSelectionModel().getSelectedItem().toString();
			String yr = year.getSelectionModel().getSelectedItem().toString();

			try {
				database.insertRecords(firstname, lastname, gender, mon, dte, yr, checkbox, image);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//myImageView.getScene().getWindow().hide();
			
			myImageView.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
				
				@Override
				public void handle(WindowEvent event) {
					// TODO Auto-generated method stub
					javafx.scene.image.Image image = new javafx.scene.image.Image(imageFile);
					System.out.println(myImageView.getImage().toString());
					image1.imageProperty().bindBidirectional(myImageView.imageProperty());
					System.out.println(image1.getImage().toString());
					
				}
			});
			
			myImageView.getScene().getWindow().fireEvent(new WindowEvent(myImageView.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
			
		}		


}
