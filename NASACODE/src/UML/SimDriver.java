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
		primaryStage.setTitle("NASA Simulator");
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
		//Labels
		Label drop = new Label("Drop height");
		Label spin = new Label("Spin speed");
		Label initialYVel = new Label("Initial Y velocity");
		Label initialXVel = new Label("Initial x velocity");
		
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
		
		// CSS
		String cssLayout = "-fx-border-color: black;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 3;\n"
				+ "-fx-border-style: solid;\n";

		// Panes

		// add the name of the variables into left inner
		VBox leftInner = new VBox();
		leftInner.getChildren().addAll(drop,spin,initialYVel,initialXVel);
		leftInner.setMinWidth(130);
		leftInner.setMaxWidth(130);

		// add the text fields into the inner Middle
		VBox innerMiddle = new VBox();
		innerMiddle.getChildren().addAll(dropHeight,spinSpeed,InitialY,InitialX);
		innerMiddle.setMinWidth(130);
		innerMiddle.setMaxWidth(130);
		
		// contains the m/s etc.
		VBox rightInner = new VBox();
		rightInner.setStyle(cssLayout);
		rightInner.setMinWidth(20);
		rightInner.setMaxWidth(20);
		
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

		// top right report box
		HBox topRight = new HBox();
		topRight.getChildren().addAll(report);
		topRight.setStyle(cssLayout);
		topRight.setMaxHeight(260);
		topRight.setMinHeight(260);

		// bottom right chart box
		HBox bottomRight = new HBox();
		bottomRight.getChildren().addAll(chart);
		bottomRight.setStyle(cssLayout);
		bottomRight.setMaxHeight(250);
		bottomRight.setMinHeight(250);

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
}
