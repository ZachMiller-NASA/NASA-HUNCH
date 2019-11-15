package UML;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SimDriver extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		// title
		primaryStage.setTitle("NASA Simulator");
		// window is not scalable
		primaryStage.setResizable(false);
		// Title labels 
		Label variables = new Label("\t\tCustomizations");
		variables.setFont(Font.font("Rockwell", 20));

		Label chart = new Label("Chart");
		chart.setFont(Font.font("Rockwell", 20));
		center(chart);

		Label report = new Label("Report");
		report.setFont(Font.font("Rockwell", 20));
		center(report);
		//Labels for the left V Box
		Label drop = new Label("Drop height");
		Label spin = new Label("Spin speed");
		Label initialYVel = new Label("Initial Y velocity");
		Label initialXVel = new Label("Initial X velocity");
		// Labels for entry type
		Label meter = new Label("Meters");
		Label rpm = new Label("rpm");
		Label mpsOne = new Label("m/s");
		Label mpsTwo = new Label("m/s");
		// Labels for the top right box
		Label newTemp = new Label("Max Temp(°C)");
		Label newForce = new Label("Max Force(N)");
		Label newTime = new Label("Time(s)");
		Label newSurvival = new Label("Pod Survival");
		
		Label oldTemp = new Label("Max Temp(°C)");
		Label oldForce = new Label("Max Force(N)");
		Label oldTime = new Label("Time(s)");
		Label oldSurvival = new Label("Pod Survival");
		
		// Text fields
		
		// drop height entry box
		TextField dropHeight = new TextField();
		txtSize(dropHeight);
		// spin speed entry box
		TextField spinSpeed = new TextField();  
		txtSize(spinSpeed);
		// initial y velocity entry box
		TextField InitialY = new TextField();  
		txtSize(InitialY);
		// initial x velocity entry box
		TextField InitialX = new TextField();  
		txtSize(InitialX);
		// the new information is stored in these
		TextField newTempBox = new TextField();
		newTempBox.setDisable(true);
		
		TextField newForceBox = new TextField();
		newForceBox.setDisable(true);
		
		TextField newTimeBox = new TextField();
		newTimeBox.setDisable(true);
		
		TextField newSurvivalBox = new TextField();
		newSurvivalBox.setDisable(true);
		// The old information is stored in these
		TextField oldTempBox = new TextField();
		oldTempBox.setDisable(true);
		
		TextField oldForceBox = new TextField();
		oldForceBox.setDisable(true);
		
		TextField oldTimeBox = new TextField();
		oldTimeBox.setDisable(true);
		
		TextField oldSurvivalBox = new TextField();
		oldSurvivalBox.setDisable(true);
		// CSS
		String cssLayout = "-fx-border-color: black;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 3;\n"
				+ "-fx-border-style: solid;\n";

		// Panes

		// add the name of the variables into left inner
		VBox leftInner = new VBox();
		//leftInner.setStyle(cssLayout);
		leftInner.getChildren().addAll(drop,spin,initialYVel,initialXVel);
		space(leftInner,drop,spin,initialYVel,initialXVel);
		leftInner.setAlignment(Pos.CENTER_RIGHT);
		leftInner.setMinWidth(130);
		leftInner.setMaxWidth(130);

		// add the text fields into the inner Middle
		VBox innerMiddle = new VBox();
		//innerMiddle.setStyle(cssLayout);
		innerMiddle.getChildren().addAll(dropHeight,spinSpeed,InitialY,InitialX);
		space(innerMiddle,dropHeight,spinSpeed,InitialY,InitialX);
		innerMiddle.setMinWidth(130);
		innerMiddle.setMaxWidth(130);
		// contains the m/s etc.
		VBox rightInner = new VBox();
		rightInner.getChildren().addAll(meter,rpm,mpsOne,mpsTwo);
		space(rightInner,meter,rpm,mpsOne,mpsTwo);
		//rightInner.setStyle(cssLayout);
		rightInner.setMinWidth(70);
		rightInner.setMaxWidth(70);
		
		// h box that holds the title
		HBox title = new HBox();
		title.getChildren().addAll(variables); // title

		// left and right inner have to be in a h box to stay next to each other while
		// below title
		HBox containLRInner = new HBox(leftInner,innerMiddle,rightInner);

		// ENTIRE LEFT BOX
		VBox leftHold = new VBox(title, containLRInner);
		leftHold.setStyle(cssLayout);
		leftHold.setMinWidth(330);

		//************************************************************************************\\
		// top right left 
		HBox reportTitle = new HBox();
		reportTitle.getChildren().addAll(report);
		
		VBox topROne =new VBox(); 
		topROne.getChildren().addAll(newTemp,newForce,newTime,newSurvival);
		topROne.setStyle(cssLayout);
		
		VBox topRTwo =new VBox();
		topRTwo.getChildren().addAll(newTempBox,newForceBox,newTimeBox,newSurvivalBox);
		topRTwo.setStyle(cssLayout);
		
		VBox topRThree =new VBox(); 
		topRThree.getChildren().addAll(oldTemp,oldForce,oldTime,oldSurvival);
		topRThree.setStyle(cssLayout);
		
		VBox topRFour =new VBox();
		topRFour.getChildren().addAll(oldTempBox,oldForceBox,oldTimeBox,oldSurvivalBox);
		topRFour.setStyle(cssLayout);
		
		HBox holdTopRight = new HBox(topROne,topRTwo,topRThree,topRFour);
		
		// top right report box holds four v boxes
		VBox topRight = new VBox(reportTitle,holdTopRight);
		topRight.getChildren().addAll();
		topRight.setStyle(cssLayout);
		topRight.setMaxHeight(210);
		topRight.setMinHeight(210);
		//************************************************************************************\\
		// bottom right chart box
		HBox bottomRight = new HBox();
		bottomRight.getChildren().addAll(chart);
		bottomRight.setStyle(cssLayout);
		bottomRight.setMaxHeight(300);
		bottomRight.setMinHeight(300);

		VBox rightHold = new VBox(topRight, bottomRight);
		rightHold.setAlignment(Pos.CENTER);
		rightHold.setMinWidth(670);

		// just holds the 2 v boxes
		HBox hold = new HBox(leftHold, rightHold);

		Scene scene = new Scene(hold, 1000, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

// centers the reports and the chart labels
	/**
	 * 
	 * @param t
	 */
	public void center(Label t) {
		int top = 0;
		int right = 0;
		int bottom = 0;
		int left = (670 / 2) - 10;
		t.setPadding(new Insets(top, right, bottom, left));
	}
	public void txtSize(TextField t) {
		t.setMinSize(125,20);
	}
	public void space(VBox t,Label a,Label b,Label c,Label d) {
		final int TOP = 22;
		final int RIGHT = 0;
		final int BOTTOM = 20;
		final int LEFT = 5;
		
		t.setMargin(a,new Insets(TOP,RIGHT,BOTTOM-2,LEFT));
		t.setMargin(b,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(c,new Insets(TOP,RIGHT,BOTTOM-2,LEFT));
		t.setMargin(d,new Insets(TOP,RIGHT,BOTTOM,LEFT));
	}
	public void space(HBox t,Label a,Label b,Label c,Label d) {
		final int TOP = 20;
		final int RIGHT = 20;
		final int BOTTOM = 20;
		final int LEFT = 20;
		
		t.setMargin(a,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(b,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(c,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(d,new Insets(TOP,RIGHT,BOTTOM,LEFT));
	}
	public void space(VBox t,TextField a,TextField b,TextField c,TextField d) {
		final int TOP = 20;
		final int RIGHT = 0;
		final int BOTTOM = 13;
		final int LEFT = 5;
		
		t.setMargin(a,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(b,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(c,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(d,new Insets(TOP,RIGHT,BOTTOM-1,LEFT));
	}
	public void space(HBox t,TextField a,TextField b,TextField c,TextField d) {
		final int TOP = 20;
		final int RIGHT = 20;
		final int BOTTOM = 20;
		final int LEFT = 20;
		
		t.setMargin(a,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(b,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(c,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		t.setMargin(d,new Insets(TOP,RIGHT,BOTTOM,LEFT));
	}
}
