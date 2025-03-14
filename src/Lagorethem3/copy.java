package Lagorethem3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.validation.Validator;

import Algorethem2.Decompres;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class copy extends Application {

	ComboBox<String> source;

	ComboBox<String> target;
	RadioButton sourceRadio;
	RadioButton TargetRadio;

	ArrayList<Line> line = new ArrayList<>();

	byte n = 0;
	ArrayList<Vertex> country = new ArrayList<>();
	Hash<Dijekstra_Table> table = new Hash<>(100);
	// ArrayList<Dijekstra_Table> hash = new ArrayList<>();
	Hash<Vertex> hash = new Hash<>(120);
	Vertex sourc;
	Vertex destentian;

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {

		
		
		Image img = new Image("file:C:\\Users\\HP\\Desktop\\Project1\\Labs\\bin\\Labs\\Project3\\tearan.png");
		ImageView imag = new ImageView(img);
		imag.setFitWidth(800);
		imag.setFitHeight(600);
		Pane show=new Pane();
		show.getChildren().add(imag);
		Label la=new Label("Welcome to Dijkstra Project");
		la.setFont(new Font(35));
		
		
		
		show.setStyle("-fx-background: rgb(96, 100, 116);");
		Button choose=new Button("Start ");
		
		choose.setStyle(" -fx-margin: 20px;");
		choose.setPrefWidth(220);
		choose.setPrefHeight(25);
		choose.setFont(new Font(25));
		choose.setStyle("-fx-color:rgb(215, 220, 245) ;-fx-background-radius:20");
		choose.setLayoutX(290);
		choose.setLayoutY(300);
		show.getChildren().addAll(choose,la);
		
		Scene scen=new Scene(show,800,600);
		primaryStage.setScene(scen);
		primaryStage.show();
		
		
		
		choose.setOnAction(en->
		{
			

		
		
		
		
		
		Pane p1 = new Pane();
		p1.setPrefHeight(800);
		p1.setPrefWidth(1500);
	
		Image im = new Image("file:C:\\Users\\HP\\Desktop\\Project1\\Labs\\bin\\Labs\\Project3\\world3.png");
		ImageView image = new ImageView(im);
		p1.getChildren().add(image);
		image.setLayoutX(0);
		image.setLayoutY(0);
		image.setFitWidth(1200);
		image.setFitHeight(800);


		
		FileChooser ff = new FileChooser();
		ff.setInitialDirectory(new java.io.File("C:\\Users\\HP\\Desktop\\Project1\\Labs\\bin\\Labs\\Project3"));
		ff.setTitle("Choose File");
		
		
		
		File f1 =  ff.showOpenDialog(primaryStage);
		if(f1.getName().compareTo("list.txt")!=0)
		{
			Alert al=new Alert(AlertType.ERROR);
			al.setContentText("The file dosent work");
			al.show();
			return;
			
		}
		
		Scanner ss;
		try {
			ss = new Scanner(f1);
			String[] in = ss.nextLine().split(" ");

			int counter = Integer.parseInt(in[0]);
			int counterofEdge = Integer.parseInt(in[1]);
			/// System.out.println(counter);

			for (int i = 0; i < counter; i++) {
				in = ss.nextLine().split(" ");

				Vertex v1 = new Vertex(in[0]);

				v1.y = Double.parseDouble(in[1]);
				v1.x = Double.parseDouble(in[2]);

//				Dijekstra_Table di = new Dijekstra_Table();
//				di.vertex = v1;
//				di.Known = false;
//				di.data = Integer.MAX_VALUE;
//				hash.insert(di);
//				
//				table.add(di);

				country.add(v1);
				hash.insert(v1);

				RadioButton b1 = new RadioButton(in[0]);
				b1.setOnAction(this::handleButtonAction);

				double heigh = Double.parseDouble(in[1]);
				double wedth = Double.parseDouble(in[2]);



				b1.setStyle("-fx-font-size: 10px;");

				
//				b1.setLayoutX((wedth + 180) * (1100 / 362)); 
				// b1.setLayoutY((90 - heigh) * (800 / 180));  
				
//				b1.setLayoutY(800 - 3.9 * (heigh + 90));
//				b1.setLayoutX(1100 + 3.3 * (wedth - 180));

//				x = (((wedth + 180) / 360) * 1087) - 50;
//				y = ((1 - ((heigh + 90) / 180)) * 556) - 10;
				
				
				b1.setLayoutY(480 - 3.6 * (heigh));
				b1.setLayoutX(560 + 3.4 * (wedth));
				
			
				
//				  double x = ((wedth - (-180)) / (180 -(-180))) * 1000;
////				    double y = (1 - ((heigh - (-90)) / ((90 - (-90))))) * 800;
////				    
//				    double y = ((90 - heigh) / (90 - (-90))) * 800;
//				    
//				   b1.setLayoutX(x);
//				   b1.setLayoutY(y);
				    	
				p1.getChildren().add(b1);

				
				hashRadio.put(b1.getText(), b1);
			}
			
			
			
			
			Vertex sou = new Vertex("Washington_D.C.");

			for (int i = 0; i < counterofEdge; i++) {
				in = ss.nextLine().split(" ");

				Vertex sourse = new Vertex(in[0]);

				Vertex des = new Vertex(in[1]);
				int cost = Integer.parseInt(in[2]);
				int time = Integer.parseInt(in[3]);

				

				Vertex v = hash.find(sourse).getData();

				double x1 = v.x;
				double y1 = v.y;
				
				
				Vertex v2 = hash.find(des).getData();

				double x2 = v2.x;
				double y2 = v2.y;

				int dec = (int) (calculateDistance(y1, x1, y2, x2) * 1000);

				Edge edge = new Edge(v2, cost, time, dec);

				edge.data = dec;

				v.edges.add(edge);

				System.out.println(v+" --- "+edge);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		Label l1 = new Label("Source: ");
		Label l2 = new Label("Target: ");
		Label l3 = new Label("Filter: ");
		source = new ComboBox<>();
		target = new ComboBox<>();
		ComboBox<String> filter = new ComboBox<>();

		for (int i = 0; i < country.size(); i++) {

			source.getItems().add(country.get(i).name);

			target.getItems().add(country.get(i).name);

			// System.out.println(newn);

		}

		filter.getItems().add("Distance");
		filter.getItems().add("Time");
		filter.getItems().add("Cost");
		filter.setValue("Distance");
		filter.setOnAction(r -> {

			if (filter.getValue() == "Time") {
				for (int i = 0; i < country.size(); i++) {

					for (int j = 0; j < country.get(i).edges.size(); j++) {
						country.get(i).edges.get(j).data = country.get(i).edges.get(j).time;
					}

				}

			} else if (filter.getValue() == "Cost") {

				for (int i = 0; i < country.size(); i++) {

					for (int j = 0; j < country.get(i).edges.size(); j++) {

						country.get(i).edges.get(j).data = country.get(i).edges.get(j).cost;

					}

				}

			} else {

				for (int i = 0; i < country.size(); i++) {

					for (int j = 0; j < country.get(i).edges.size(); j++) {
						country.get(i).edges.get(j).data = country.get(i).edges.get(j).dectance;
					}

				}

			}

		});

		HBox h1 = new HBox();
		HBox h2 = new HBox();
		HBox h3 = new HBox();
		source.setOnAction(er -> {

			for (int i = 0; i < line.size(); i++) {

				p1.getChildren().remove(line.get(i));

			}

			line = new ArrayList<>();

			String n = source.getValue();

			if (n == "") {
				return;
			}

			if (sourceRadio != null) {
				sourceRadio.setStyle("-fx-color: white; -fx-text-fill: black;");
				sourceRadio.setSelected(false);
			}

			sourceRadio = hashRadio.get(n);
			if (destentian != null) {
				if (destentian.name.toLowerCase().compareTo(n.toLowerCase())==0) {
					destentian = null;
					TargetRadio.setStyle("-fx-color: whete; -fx-text-fill: black;");
					
					target.setValue("");
					return;
					
				}
			}
			sourceRadio.setStyle("-fx-color: Red; -fx-text-fill: black;");
			sourceRadio.setSelected(true);

			sourc = new Vertex(sourceRadio.getText());

		});
		target.setOnAction(er -> {

			for (int i = 0; i < line.size(); i++) {

				p1.getChildren().remove(line.get(i));

			}
			line = new ArrayList<>();

			String n = target.getValue();

			if (n == "") {
				return;
			}
			if (TargetRadio != null) {
				TargetRadio.setStyle("-fx-color: white; -fx-text-fill: black;");
				TargetRadio.setSelected(false);
			}
			TargetRadio = hashRadio.get(n);
			
			System.out.println(sourc.name.toLowerCase().compareTo(n.toLowerCase()));
			
		
			if (sourc != null) {
				if (sourc.name.toLowerCase().compareTo(n.toLowerCase())==0) {
					
					sourc = null;
					sourceRadio.setStyle("-fx-color: whete; -fx-text-fill: black;");
					source.setValue("");
					
				}
			}

			TargetRadio.setStyle("-fx-color: green; -fx-text-fill: black;");
			TargetRadio.setSelected(true);
			destentian = new Vertex(TargetRadio.getText());

		});

		h1.getChildren().addAll(l1, source);
		h2.getChildren().addAll(l2, target);
		h3.getChildren().addAll(l3, filter);

		VBox v1 = new VBox();
		v1.getChildren().addAll(new Label(), new Label(), h1, h2, h3);
		Label l4 = new Label("Path:       ");
		TextArea l5 = new TextArea();
		l5.setPrefWidth(180);
		l5.setPrefHeight(120);

		l5.setStyle("-fx-background-color: lightgrey ;-fx-border-color:Black ;");

		l1.setFont(new Font(20));
		l2.setFont(new Font(20));
		l3.setFont(new Font(20));
		l4.setFont(new Font(20));
		l5.setFont(new Font(10));

		HBox h4 = new HBox();
		h4.getChildren().addAll(l4, l5);
		v1.setLayoutX(1230);
		v1.setSpacing(30);
		v1.getChildren().addAll(h4);

		Label l6 = new Label("Distance:");

		Label l7 = new Label();
		l7.setPrefWidth(180);
		l7.setPrefHeight(30);

		l6.setFont(new Font(20));
		l7.setFont(new Font(20));
		l7.setStyle("-fx-background-color: lightgrey ;-fx-border-color:Black ;");
		HBox h5 = new HBox();
		h5.getChildren().addAll(l6, l7);
		v1.getChildren().addAll(h5);

		Label l8 = new Label("Cost:       ");

		Label l9 = new Label();
		l9.setPrefWidth(180);
		l9.setPrefHeight(30);

		l8.setFont(new Font(20));
		l9.setFont(new Font(20));
		l9.setStyle("-fx-background-color: lightgrey ;-fx-border-color:Black ;");
		HBox h6 = new HBox();
		h6.getChildren().addAll(l8, l9);

		Label l10 = new Label("Time:      ");

		Label l11 = new Label();
		l11.setPrefWidth(180);
		l11.setPrefHeight(30);

		l10.setFont(new Font(20));
		l11.setFont(new Font(20));
		l11.setStyle("-fx-background-color: lightgrey ;-fx-border-color:Black ;");
		HBox h7 = new HBox();
		h7.getChildren().addAll(l10, l11);

		Button run = new Button("Run");
		run.setStyle(" -fx-margin: 20px;");
		run.setPrefWidth(120);
		run.setPrefHeight(25);
		run.setFont(new Font(25));
		run.setStyle("-fx-color:rgb(215, 220, 225) ;-fx-background-radius:20");
		HBox h8 = new HBox();
		h8.getChildren().addAll(new Label("                   "), run);
		v1.getChildren().addAll(h6, h7, h8);

		p1.getChildren().add(v1);

		run.setOnAction(er -> {

			for (int i = 0; i < line.size(); i++) {

				p1.getChildren().remove(line.get(i));

			}
			line = new ArrayList<>();

			path = "";
			lestPath = new ArrayList<>();

			if (sourc == null || destentian == null) {
				Alert al = new Alert(AlertType.ERROR);
				al.setContentText("Please choose vartex ");
				al.show();
				return;

			}

			sourc = hash.find(sourc).getData();
			destentian = hash.find(destentian).getData();

			if (sourc == null || destentian == null) {
				Alert al = new Alert(AlertType.ERROR);
				al.setContentText("Please choose vartex ");
				al.show();
				return;

			}
			Dijecstra(sourc);
			l5.setText(print(destentian));

			Dijekstra_Table di = new Dijekstra_Table();
			di.vertex = destentian;
			di = table.find(di).getData();

			l11.setText(di.time + "min");
			l9.setText(di.cost + "$");
			l7.setText(di.dectance + "m");

			if (lestPath.size() == 1) {
				l5.setText("No Path");

			}

			for (int i = 0; i < lestPath.size() - 1; i++) {

				RadioButton prev = lestPath.get(i);
				RadioButton next = lestPath.get(i + 1);

				double startX = prev.getLayoutX() + prev.getWidth() / 10;
				double startY = prev.getLayoutY() + prev.getHeight() / 2;

				double endX = next.getLayoutX() + next.getWidth() / 10;
				double endY = next.getLayoutY() + next.getHeight() / 2;

				Line line = new Line(startX, startY, endX, endY);

				this.line.add(line);

				p1.getChildren().add(line);

			}

		});
	
		p1.setStyle("-fx-background:rgb(208, 215, 238);");
		
		Scene s1 = new Scene(p1, 1500, 800);
		primaryStage.setScene(s1);
		primaryStage.setTitle("World");

		primaryStage.show();

		});
		
	}

	public void Dijecstra(Vertex n) {
		Vertex v;
		table = new Hash<>(20);

		Dijekstra_Table smallest = initlliezed(n);

		Heab<Dijekstra_Table> heap = new Heab(20);

		heap.insert(smallest);
		while (!heap.isEmpty()) {
			smallest = heap.deletMin();
			smallest.Known = true;
			v = smallest.getVertex();

			for (int i = 0; i < v.edges.size(); i++) {
				Dijekstra_Table t1 = new Dijekstra_Table();
				t1.vertex = v.edges.get(i).destination;

				t1 = table.find(t1).getData();

				if (!t1.Known) {
					if (smallest.data + v.edges.get(i).data < t1.getData()) {

						t1.data = smallest.data + v.edges.get(i).data;

						t1.prev = v;
						System.out.println(t1);
						heap.insert(t1);

						t1.cost = smallest.cost + v.edges.get(i).cost;
						t1.dectance = smallest.dectance + v.edges.get(i).dectance;
						t1.time = smallest.time + v.edges.get(i).time;

					}
				}
			}
		}

	}

	String path = "";

	public Dijekstra_Table initlliezed(Vertex n) {

		Dijekstra_Table t1 = null;
		for (int i = 0; i < country.size(); i++) {
			Dijekstra_Table d1 = new Dijekstra_Table();
			d1.data = Integer.MAX_VALUE;
			d1.Known = false;
			d1.vertex = country.get(i);

			if (country.get(i).compareTo(n) == 0) {
				d1.Known = true;
				d1.data = 0;
				d1.prev = null;
				t1 = d1;
			}
			table.insert(d1);
		}

		return t1;

	}

	
	ArrayList<RadioButton> lestPath = new ArrayList<>();
	
	public String print(Vertex dec) {
		Dijekstra_Table di = new Dijekstra_Table();
		di.vertex = dec;
		di = table.find(di).getData();
		if (di.prev != null) {
			print(di.prev);
			path += dec.name + "->";
			RadioButton s = hashRadio.get(dec.name);
			} else {
			path += dec.name + "->";
		    }
		RadioButton s = hashRadio.get(dec.name);
		lestPath.add(s);
		return path;

	}

	private void handleButtonAction(ActionEvent event) {
		RadioButton source = (RadioButton) event.getSource();

		if (source.isSelected()) {
			if (sourc == null) {
				if (destentian != null) {
					if (destentian.name.toLowerCase() == source.getText().toLowerCase()) {
						source.setStyle("-fx-color: Red; -fx-text-fill: black;");
						sourc = new Vertex(source.getText());

						sourceRadio = source;

						destentian = null;
					}
				}

				source.setStyle("-fx-color: Red; -fx-text-fill: black;");

				sourc = new Vertex(source.getText());
				sourceRadio = source;

				this.source.setValue(source.getText());

			} else if (destentian == null) {
				destentian = new Vertex(source.getText());
				source.setStyle("-fx-color: Green; -fx-text-fill: black;");

				this.target.setValue(source.getText());

				TargetRadio = source;

			}
		} else {
			if (sourc != null && destentian != null) {

				if (sourc.name == source.getText()) {
					sourceRadio = null;
					sourc = null;
					source.setStyle("-fx-color: white; -fx-text-fill: black;");

					this.source.setValue("");
				} else if (destentian.name == source.getText()) {

					TargetRadio = null;
					destentian = null;
					source.setStyle("-fx-color: white; -fx-text-fill: black;");
					this.target.setValue("");
				}
			} else if (sourc != null) {
				sourceRadio = null;
				sourc = null;
				source.setStyle("-fx-color: white; -fx-text-fill: black;");

				this.source.setValue("");

			}

			else if (destentian != null) {
				TargetRadio = null;
				destentian = null;
				source.setStyle("-fx-color: white; -fx-text-fill: black;");
				this.target.setValue("");

			}

		}

		if (sourc != null && destentian != null && source.getText() != sourc.name
				&& source.getText() != destentian.name) {
			source.setSelected(false);
			return;
		}

	}

	// from world dectance
	public static double calculateDistance(double lt1, double ln1, double lt2, double ln2) {
		lt1 = Math.toRadians(lt1);
		ln1 = Math.toRadians(ln1);
		lt2 = Math.toRadians(lt2);
		ln2 = Math.toRadians(ln2);

		double deltaLat = lt2 - lt1;
		double deltaLon = ln2 - ln1;

		double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
				+ Math.cos(lt1) * Math.cos(lt2) * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double R = 6371.0;

		double distance = R * c;

		return distance;
	}

	public static void main(String[] args) {
		launch(args);
	}

	
//   	public void Dijecstra(ArrayList<Dijekstra_Table> newn) {
//		Vertex v, w;
//		int min;
//		min = smallest(newn);
//		for (;;) {
//
//			min = smallest(newn);
//			if (min == Integer.MAX_VALUE) {
//				break;
//			}
//
//			newn.get(min).Known = true;
//
//			for (int j = 0; j < newn.get(min).getVertex().edges.size(); j++) {
//
//				Dijekstra_Table di = new Dijekstra_Table();
//				di.vertex = newn.get(min).getVertex().edges.get(j).destination;
//
//				if (!hash.find(di).getData().getKnown()) {
//
//					if (newn.get(min).data + newn.get(min).getVertex().edges.get(j).data < hash.find(di).getData().getData()) {
//						hash.find(di).getData().data = newn.get(min).data + newn.get(min).getVertex().edges.get(j).data;
//						hash.find(di).getData().prev=newn.get(min).vertex;
//					}
//
//				}
//
//			
//
//			}
//			min = Integer.MAX_VALUE;
//
//		}
//
//	}
//
//	String path="";
//	
//	public String print(Vertex dec,ArrayList<Dijekstra_Table> newn)
//	{
//		Dijekstra_Table di=new Dijekstra_Table();
//		di.vertex=dec;
//		di=hash.find(di).getData();
//		
//		if(di.prev!=null)
//		{
//			path+=di.prev.name+"->";	
//		}
//		
//		
//		path+=dec.name;
//		return path;
//		
//	}
//	
//	
//	
//	
//	
//	public int smallest(ArrayList<Dijekstra_Table> newn) {
//
//		int min = newn.get(0).getData();
//		int v1 = 0;
//
//		for (int i = 1; i < newn.size(); i++) {
//
//			if (min > newn.get(i).getData() && newn.get(i).getKnown() == false) {
//				v1 = i;
//				min = newn.get(i).getData();
//
//			}
//
//		}
//		return v1;
//
//	}
	HashMap<String, RadioButton> hashRadio = new HashMap<>();

}
