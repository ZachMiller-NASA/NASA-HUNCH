package UML;


import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SimDriver extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void start(Stage primaryStage) {
		// title
		primaryStage.setTitle("NASA Simulator");
		// window is not scalable
		primaryStage.setResizable(false);
		// Title labels 
		Label variables = new Label("\t\tCustomizations");
		variables.setFont(Font.font("Rockwell", 20));

		//Data so chart can display. Phase this out when connecting projectile motion
		ArrayList<Double> xData = new ArrayList<Double>();
		ArrayList<Double> yData = new ArrayList<Double>();
		for (int count = 0; count <= 10; count++) {
			xData.add((double) count);
			yData.add(3000 - Math.pow(count, 2.105));
		}
		
		//Chart stuff
		Label chartTxt = new Label("Chart\nCustomizations");
		chartTxt.setFont(Font.font("Rockwell", 20));
		
		//creating combo boxes for chart
		ObservableList<String> options = FXCollections.observableArrayList (
				"Altitude",
				"Time",
				"Distance",
				"Temperature",
				"Force",
				"Speed",
				"Descent Angle"
				);
		final ComboBox xCombo = new ComboBox(options);
		final ComboBox yCombo = new ComboBox(options);
		xCombo.setValue("Time");
		yCombo.setValue("Altitude");
		LineChart chart = createChart(xData, yData,
				(String) xCombo.getValue(),(String) yCombo.getValue());
		
		//report padding
		Insets reportPadding = new Insets(7, 0, 7, 0);
		
		//report stuff
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
		newTemp.setPadding(reportPadding);
		Label newForce = new Label("Max Force(N)");
		newForce.setPadding(reportPadding);
		Label newTime = new Label("Time(s)");
		newTime.setPadding(reportPadding);
		Label newSurvival = new Label("Pod Survival");
		newSurvival.setPadding(reportPadding);
		
		Label oldTemp = new Label("Max Temp(°C)");
		oldTemp.setPadding(reportPadding);
		Label oldForce = new Label("Max Force(N)");
		oldForce.setPadding(reportPadding);
		Label oldTime = new Label("Time(s)");
		oldTime.setPadding(reportPadding);
		Label oldSurvival = new Label("Pod Survival");
		oldSurvival.setPadding(reportPadding);
		
		// Buttons
		Button exitBtn = new Button("Exit");
		exitBtn.setMinSize(324, 80);
		exitBtn.setOnAction(btnPress -> primaryStage.close());
		exitBtn.setStyle("-fx-background-color: Crimson");
		exitBtn.setFont(buttonsFont);

		Button startBtn = new Button("Start");
		startBtn.setMinSize(324, 80);
		startBtn.setStyle("-fx-background-color: LawnGreen");
		startBtn.setFont(buttonsFont);

		Button resetBtn = new Button("Reset");
		resetBtn.setMinSize(324, 80);
		resetBtn.setStyle("-fx-background-color: #00ced1");
		resetBtn.setFont(buttonsFont);
		
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
		String cssLayout2 = "-fx-border-color: LavenderBlush;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 3;\n"
				+ "-fx-border-style: solid;\n";

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
		VBox leftHold = new VBox(title, containLRInner, startBtn, resetBtn, exitBtn);
		leftHold.setStyle(cssLayout);
		leftHold.setMinWidth(330);

		//************************************************************************************\\
		
		//report text field padding
		Insets reportTxtBoxPadding = new Insets(5,0,5,0);
		
		// top right left 
		HBox reportTitle = new HBox();
		reportTitle.getChildren().addAll(report);
		
		VBox topROne =new VBox(); 
		topROne.getChildren().addAll(newTemp,newForce,newTime,newSurvival);
		topROne.setStyle(cssLayout2);
		
		VBox topRTwo =new VBox();
		topRTwo.getChildren().addAll(newTempBox,newForceBox,newTimeBox,newSurvivalBox);
		topRTwo.setStyle(cssLayout2);
		VBox.setMargin(newTempBox, reportTxtBoxPadding);
		VBox.setMargin(newTimeBox, reportTxtBoxPadding);
		
		VBox topRThree =new VBox(); 
		topRThree.getChildren().addAll(oldTemp,oldForce,oldTime,oldSurvival);
		topRThree.setStyle(cssLayout2);
		
		VBox topRFour =new VBox();
		topRFour.getChildren().addAll(oldTempBox,oldForceBox,oldTimeBox,oldSurvivalBox);
		topRFour.setStyle(cssLayout2);
		VBox.setMargin(oldTempBox, reportTxtBoxPadding);
		VBox.setMargin(oldTimeBox, reportTxtBoxPadding);
		
		HBox holdTopRight = new HBox(topROne,topRTwo,topRThree,topRFour);
		
		// top right report box holds four v boxes
		VBox topRight = new VBox(reportTitle,holdTopRight);
		topRight.getChildren().addAll();
		topRight.setStyle(cssLayout);
		topRight.setMaxHeight(210);
		topRight.setMinHeight(210);
		
		//************************************************************************************\\
		//Bottom Right Right
		VBox bottomRightRight = new VBox();
		bottomRightRight.getChildren().add(chart);
		
		//Combo box graph updating code
		xCombo.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				LineChart chartUpdate = createChart(xData, yData, t1, (String) yCombo.getValue());
				bottomRightRight.getChildren().remove(0);
				bottomRightRight.getChildren().add(chartUpdate);
			}
		});
		
		yCombo.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				LineChart chartUpdate = createChart(xData, yData, (String) xCombo.getValue(), t1);
				bottomRightRight.getChildren().remove(0);
				bottomRightRight.getChildren().add(chartUpdate);
			}
		});

		//Combo labels
		Label xComboTxt = new Label("x-axis");
		Label yComboTxt = new Label("y-axis");
		
		//Spacing region
		Region space = new Region();
		space.setPadding(new Insets(10, 0, 10, 0));
		
		//Bottom Right Left Bottom
		VBox brlb = new VBox(xComboTxt, xCombo, space, yComboTxt, yCombo);
		brlb.setPadding(new Insets(10, 0, 10, 0));
		
		//Bottom Right Left
		VBox bottomRightLeft = new VBox();
		bottomRightLeft.getChildren().addAll(chartTxt, brlb);
		
		//Spacing for bottomRight
		Region space2 = new Region();
		space2.setPadding(new Insets(0, 10, 0, 10));
		
		// bottom right chart box
		HBox bottomRight = new HBox();
		bottomRight.getChildren().addAll(space2, bottomRightLeft, bottomRightRight);
		bottomRight.setStyle(cssLayout);
		bottomRight.setMaxHeight(300);
		bottomRight.setMinHeight(300);
		
		//Right side
		VBox rightHold = new VBox(topRight, bottomRight);
		rightHold.setAlignment(Pos.CENTER);
		rightHold.setMinWidth(670);

		// just holds the 2 main VBoxes
		HBox hold = new HBox(leftHold, rightHold);

		//Final stuff
		Scene scene = new Scene(hold, 1000, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		resetBtn.setOnAction(btnPress -> {// Sets the new boxes equal null and the old boxes equal to what the value of
			// the new boxes was
			oldTempBox.setText(newTempBox.getText());
			oldForceBox.setText(newForceBox.getText());
			oldTimeBox.setText(newTimeBox.getText());
			oldSurvivalBox.setText(newSurvivalBox.getText());
			// clears the new boxes for a new set of data
			newTempBox.clear();
			newForceBox.clear();
			newTimeBox.clear();
			newSurvivalBox.clear();
			//clears data entry boxes
			dropHeight.clear();
			spinSpeed.clear();
			InitialX.clear();
			InitialY.clear();
			
			 LineChart chartNew = createChart(xData, yData, (String) xCombo.getValue(), (String) yCombo.getValue());
			 
			 xCombo.setValue("Time");
			 yCombo.setValue("Altitude");
		});		
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
		
		VBox.setMargin(a,new Insets(TOP,RIGHT,BOTTOM-2,LEFT));
		VBox.setMargin(b,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		VBox.setMargin(c,new Insets(TOP,RIGHT,BOTTOM-2,LEFT));
		VBox.setMargin(d,new Insets(TOP,RIGHT,BOTTOM,LEFT));
	}
	public void space(HBox t,Label a,Label b,Label c,Label d) {
		final int TOP = 20;
		final int RIGHT = 20;
		final int BOTTOM = 20;
		final int LEFT = 20;
		
		HBox.setMargin(a,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		HBox.setMargin(b,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		HBox.setMargin(c,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		HBox.setMargin(d,new Insets(TOP,RIGHT,BOTTOM,LEFT));
	}
	public void space(VBox t,TextField a,TextField b,TextField c,TextField d) {
		final int TOP = 20;
		final int RIGHT = 0;
		final int BOTTOM = 13;
		final int LEFT = 5;
		
		VBox.setMargin(a,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		VBox.setMargin(b,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		VBox.setMargin(c,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		VBox.setMargin(d,new Insets(TOP,RIGHT,BOTTOM-1,LEFT));
	}
	public void space(HBox t,TextField a,TextField b,TextField c,TextField d) {
		final int TOP = 20;
		final int RIGHT = 20;
		final int BOTTOM = 20;
		final int LEFT = 20;
		
		HBox.setMargin(a,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		HBox.setMargin(b,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		HBox.setMargin(c,new Insets(TOP,RIGHT,BOTTOM,LEFT));
		HBox.setMargin(d,new Insets(TOP,RIGHT,BOTTOM,LEFT));
	}
	
	/*
	 * Takes two Double ArrayLists and two Strings as arguments
	 * Returns a LineChart
	 * Used to create a LineChart based on the data sent to it
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private LineChart createChart(ArrayList<Double> xData, ArrayList<Double> yData,
			String xLabel, String yLabel) {
		
			//Initializing maxes & mins
			double yMax = yData.get(0);
			double yMin = yData.get(0);
			double xMin = xData.get(0);
			double xMax = xData.get(0);
			
			//Finding maxes & mins
			for (int count = 1; count < xData.size(); count++) {
				if (yMax < yData.get(count))
					yMax = yData.get(count);
				if (yMin > yData.get(count))
					yMin = yData.get(count);
				
				if (xMax < xData.get(count))
					xMax = xData.get(count);
				if (xMin > xData.get(count))
					xMin = xData.get(count);
			}
			
			//Generating increments using data & adjusting minimums, maximums
			double yIncrement = (int)((yMax - yMin) * (0.15));
			double xIncrement = (int) ((xMax - xMin) * (0.1));
			
			//0 Adjustment
			if (xMin < xMax * .2 && xMin > 0)
				xMin = 0;
			if (yMin < yMax * .2 && yMin > 0)
				yMin = 0;
			
			//Defining axis
			NumberAxis xAxis = new NumberAxis(xMin, xMax, xIncrement);
			NumberAxis yAxis = new NumberAxis(yMin, yMax, yIncrement);
			xAxis.setLabel(xLabel);
			yAxis.setLabel(yLabel);
			
			//Creating LineChart
			LineChart chart = new LineChart(xAxis, yAxis);
			XYChart.Series series = new XYChart.Series();
			for (int count = 0; count < xData.size(); count++) {
				series.getData().add(new XYChart.Data(xData.get(count), yData.get(count)));
			}
			chart.getData().add(series);	
			chart.setMinSize(465, 320);
			chart.setMaxSize(465, 320);
			chart.setTitle("Chart");
			
		return chart;
	}
}