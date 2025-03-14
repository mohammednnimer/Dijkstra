package Lagorethem3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import Algorethem2.Main;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Talween extends Application {

	int width;
	int height;
	
	BufferedImage image;
	BufferedImage image2;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
	
		
	

	

			 

		File f1=new File("C:\\Users\\HP\\Desktop\\Project1\\Labs\\bin\\Labs\\Project3\\world3.png");
		
		File f2=new File("C:\\Users\\HP\\Desktop\\Project1\\Labs\\bin\\Labs\\Project3\\world2 - Copy.png");
		
				
			
					image = ImageIO.read(f1);
			
					

					image2 = ImageIO.read(f2);
					
					
					
					if(image == null)
					{
						Alert al=new Alert(AlertType.ERROR);
						al.setContentText("Please enter valied file");
						al.show();
						return;
						
					 	}
					 width = image.getWidth();
					 height = image.getHeight();
				
					 
					 
					
			
					for (int i = 0; i <width; i++) {
						for(int j=0;j<height;j++)
						{
							int pixel = image.getRGB(i, j);
						
							try {
								image2.setRGB(i, j, pixel);
								
							}catch (Exception e) {
								// TODO: handle exception
							}
							
							
						}
							
	
	}
					System.out.println("hjjszhjdsnnsd");
					

					File outputFile = new File("C:\\Users\\HP\\Desktop\\Project1\\Labs\\bin\\Labs\\Project3\\world2 --.png");
					ImageIO.write(image2, "png", outputFile);
					
					
	}
			
		

	public static void main(String[] args) {
		launch(args);
	}

	
	
}
