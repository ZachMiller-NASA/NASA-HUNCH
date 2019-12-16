package mtCleverest;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
import javafx.scene.text.FontWeight;
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
		Label temp = new Label("Max Temp(�C)");
		temp.setPadding(reportPadding);
		Label force = new Label("Max Force(N)");
		force.setPadding(reportPadding);
		Label time = new Label("Time(sec)");
		time.setPadding(reportPadding);
		Label survival = new Label("Pod Survival");
		survival.setPadding(reportPadding);
		
		Label impact = new Label("Angle of Impact");
		impact.setPadding(reportPadding);
		Label distance = new Label("Distance Travelled(m)");
		distance.setPadding(reportPadding);
		
		Font buttonsFont = Font.font("Comic Sans MS", FontWeight.EXTRA_BOLD ,20);
		
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
		TextField tempBox = new TextField();
		tempBox.setDisable(true);
		
		TextField forceBox = new TextField();
		forceBox.setDisable(true);
		
		TextField timeBox = new TextField();
		timeBox.setDisable(true);
		
		TextField survivalBox = new TextField();
		survivalBox.setDisable(true);
		
		TextField impactBox = new TextField();
		impactBox.setDisable(true);
		
		TextField distanceBox = new TextField();
		distanceBox.setDisable(true);
		
		
		// CSS
		String cssLayout = "-fx-border-color: black;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 3;\n"
				+ "-fx-border-style: solid;\n";
		String cssLayout2 = "-fx-border-color: transparent;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 3;\n"
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
		topROne.getChildren().addAll(temp,force,time,survival);
		topROne.setStyle(cssLayout2);
		
		VBox topRTwo =new VBox();
		topRTwo.getChildren().addAll(tempBox,forceBox,timeBox,survivalBox);
		topRTwo.setStyle(cssLayout2);
		VBox.setMargin(tempBox, reportTxtBoxPadding);
		VBox.setMargin(timeBox, reportTxtBoxPadding);
		VBox.setMargin(impactBox, reportTxtBoxPadding);
		
		VBox topRThree =new VBox(); 
		topRThree.getChildren().addAll(impact,distance);
		topRThree.setStyle(cssLayout2);
		
		VBox topRFour =new VBox();
		
		topRFour.getChildren().addAll(impactBox,distanceBox);
		
		topRFour.getChildren().addAll();
		topRFour.setStyle(cssLayout2);
		
		VBox.setMargin(impactBox, reportTxtBoxPadding);
		
		HBox holdTopRight = new HBox(topROne,topRTwo,topRThree,topRFour);
		
		// top right report box holds four v boxes
		VBox topRight = new VBox(reportTitle,holdTopRight);
		topRight.getChildren().addAll();
		topRight.setStyle(cssLayout);
		topRight.setMaxHeight(210);
		topRight.setMinHeight(210);
		
		//************************************************************************************\\
		
		//Chart title label
		Label chartTitle = new Label("Chart");
		chartTitle.setFont(Font.font("Rockwell", 20));
		chartTitle.setTranslateX(230);
		
		
		//Bottom Right Right
		VBox bottomRightRight = new VBox();
		Label chartSubstitute = new Label("Please enter data\nto see a graph");
		chartSubstitute.setPadding(new Insets(50,0,100,100));
		chartSubstitute.setFont(Font.font("Rockwell", 40));
		bottomRightRight.getChildren().addAll(chartTitle, chartSubstitute);
		
		//Combo box graph updating code
		xCombo.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				LineChart chartUpdate = createChart(Data.retrieve(xCombo.getValue()),
						Data.retrieve(yCombo.getValue()),
						t1, (String) yCombo.getValue());
				if (t1 == (String) yCombo.getValue()) { //if both boxes are on same option
					bottomRightRight.getChildren().remove(1);
					chartSubstitute.setText("Please select\ndiffering axes");
					bottomRightRight.getChildren().add(chartSubstitute);
				}
				else {
					bottomRightRight.getChildren().remove(1);
					bottomRightRight.getChildren().add(chartUpdate);
				}
			}
		});
		
		yCombo.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				LineChart chartUpdate = createChart(Data.retrieve(xCombo.getValue()),
						Data.retrieve(yCombo.getValue()),
						(String) xCombo.getValue(), t1);
				if (t1 == (String) xCombo.getValue()) { //if both boxes are on same option
					bottomRightRight.getChildren().remove(1);
					chartSubstitute.setText("Please select\ndiffering axes");
					bottomRightRight.getChildren().add(chartSubstitute);
				}
				else {
					bottomRightRight.getChildren().remove(1);
					bottomRightRight.getChildren().add(chartUpdate);
				}
			}
		});

		//Combo labels
		Label xComboTxt = new Label("x-axis");
		Label yComboTxt = new Label("y-axis");
		
		//Spacing region
		Region space = new Region();
		space.setPadding(new Insets(10, 0, 10, 0));
		
		//Bottom Right Left Bottom
		VBox brlb = new VBox(yComboTxt, yCombo, space, xComboTxt, xCombo);
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
		
		//WHEN THE START BUTTON IS PRESSED IT WILL CHECK THE VALUES AND THEN START OR
		//ASK FOR VALUES IF THEY HAVEN'T ENTERED THEM OR THEY'RE INVALID
		startBtn.setOnAction(e ->{ 
			checkToCalc(dropHeight, spinSpeed, InitialY, InitialX);
			LineChart chartUpdate = createChart(Data.retrieve(xCombo.getValue()),
					Data.retrieve(yCombo.getValue()),
					(String) xCombo.getValue(), (String) yCombo.getValue());
			bottomRightRight.getChildren().remove(1);
			bottomRightRight.getChildren().add(chartUpdate);
			
			distanceBox.setText(String.format("%.2f",
					Data.distanceTraveled.get(Data.distanceTraveled.size()-1)));
			timeBox.setText(String.format("%.2f", Data.currentTime.get(Data.currentTime.size()-1)));
			impactBox.setText(String.format("%.2f", Data.angleOfFall.get(Data.angleOfFall.size()-1)));
		});
		
		resetBtn.setOnAction(btnPress -> {// Sets the boxes equal to null and resets the graph
		
			// clears the new boxes for a new set of data
			tempBox.clear();
			forceBox.clear();
			timeBox.clear();
			survivalBox.clear();
			//clears data entry boxes
			dropHeight.clear();
			spinSpeed.clear();
			InitialX.clear();
			InitialY.clear();
			
			//Resetting combo boxes to default
			xCombo.setValue("Time");
			yCombo.setValue("Altitude");
			
			//Resetting chart to text
			bottomRightRight.getChildren().remove(1);
			chartSubstitute.setText("Please enter data\nto see a graph");
			bottomRightRight.getChildren().add(chartSubstitute);
			
			//clearing ArrayLists
			Data.currentTime.clear();
			Data.angleOfFall.clear();
			Data.height.clear();
			Data.distanceTraveled.clear();
			Data.xVelocity.clear();
			Data.yVelocity.clear();
		});		
	}

	private void checkToCalc(TextField dropHeight, TextField spinSpeed, TextField yVelocityText,
			TextField xVelocityText) {
		try {
			double initialHeight = Double.parseDouble(dropHeight.getText());
			double initialSpin = Double.parseDouble(spinSpeed.getText());
			double yVel = Double.parseDouble(yVelocityText.getText());
			double xVel = Double.parseDouble(xVelocityText.getText());
			if(initialHeight < yVel)
				System.out.println("Y velocity can\'t be equal to or greater than height.");
			else
				calcProjectileMotion(initialHeight, initialSpin, yVel, xVel);
		} catch(InputMismatchException mismatch) {
			System.out.println("Must be a number");
		} catch(NumberFormatException numForm) {
			System.out.println("Must be a number");
		}
		
	}

	private void calcProjectileMotion(double altitude, double spin, double yVel, double xVel) {
		final double MOON_GRAVITY = -1.62;

		ProjectileMotion motion = new ProjectileMotion();

		int index = 0;
		int timeIndex = 0;
		boolean closeToZero = false;

		
		Data.xVelocity.add(xVel);
		Data.yVelocity.add(-yVel);

		Data.height.add(altitude);
		Data.distanceTraveled.add(0.0);
		Data.angleOfFall.add(motion.calcAngle(Data.xVelocity, Data.yVelocity, index));
		Data.currentTime.add((double) index);

		index++;
		while (!closeToZero) {

			Data.currentTime.add((double) index);

			motion.allCalcs(MOON_GRAVITY, Data.xVelocity, Data.yVelocity, Data.angleOfFall, Data.distanceTraveled, Data.height, Data.currentTime, index);

			closeToZero = (Data.height.get(index) < 0) ? true : false;

			index++;
		}
		index--;

		if (Data.height.get(index) != 0) {
			Data.yVelocity.remove(index);
			Data.xVelocity.remove(index);
			Data.angleOfFall.remove(index);
			Data.height.remove(index);
			Data.distanceTraveled.remove(index);
			Data.currentTime.remove(index);

			index--;

			Data.currentTime.add(motion.calcTimeAtZeroHeight(Data.yVelocity, Data.currentTime, index, MOON_GRAVITY));

			timeIndex = index + 1;

			motion.allCalcs(MOON_GRAVITY, Data.xVelocity, Data.yVelocity, Data.angleOfFall, Data.distanceTraveled, Data.height, Data.currentTime, index,
					timeIndex);
		}

		System.out.printf("%5s%10s%12s%19s%19s%17s%n", "Time", "Height", "Distance", "X Velocity(m/s)",
				"Y Velocity(m/s)", "Angle of Fall");

		// Distance of fall now at 0
		for (int x = 0; x < Data.currentTime.size() - 1; x++) {
			System.out.printf("%5.2f%10.2f%12.2f%19.2f%19.2f%17.2f%n", Data.currentTime.get(x), Data.height.get(x),
					Data.distanceTraveled.get(x), Data.xVelocity.get(x), Data.yVelocity.get(x), Data.angleOfFall.get(x));
		}

		// how far will it roll
		System.out.printf("%5.2f%10.2f%12.2f%19.2f%19.2f%17.2f%n", Data.currentTime.get(Data.currentTime.size() - 1), 0.0,
				Data.distanceTraveled.get(Data.currentTime.size() - 1), Data.xVelocity.get(Data.currentTime.size() - 1), 0.0, 0.0);
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
			double yIncrement = (int)((yMax - yMin) * (0.2));
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
			
			chart.setTranslateY(-17);
			chart.getData().add(series);	
			chart.setMinSize(465, 320);
			chart.setMaxSize(465, 320);
			
			
			
			
		return chart;
	}
}