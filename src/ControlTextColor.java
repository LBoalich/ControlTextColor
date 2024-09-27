/*
 * Name: Control Text Color
 * Author: Leah Boalich
 * Date: September 26, 2024
 * Assignment: Chapter 16 Excercise 17
 * Description: This program allows the user to change the color and opacity of the displayed text by moving sliders.
 */

// Imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

// Change the color and opacity of the displayed text
public class ControlTextColor extends Application {
    // Create text that will change colors
    Text text = new Text(20, 20, "Show Colors");

    // Create scroll bars
    ScrollBar sbRed = new ScrollBar();
    ScrollBar sbGreen = new ScrollBar();
    ScrollBar sbBlue = new ScrollBar();
    ScrollBar sbOpacity = new ScrollBar();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
       
        // Create hBox to hold text
        HBox hBox = new HBox();
        // Add text to hBox
        hBox.getChildren().add(text);
        // Center alight text
        hBox.setAlignment(Pos.CENTER);

        // Create array to hold scroll bars
        ScrollBar[] scrollBars = {sbRed, sbGreen, sbBlue};

        // Set color scroll bars max value
        for (ScrollBar scrollBar: scrollBars) {
            scrollBar.setMax(1.0);
            scrollBar.setUnitIncrement(.1);
        }

        // Set opacity scroll bar max and increment
        sbOpacity.setMax(1.0);
        sbOpacity.setUnitIncrement(.1);
        sbOpacity.setValue(1.0);

        // Create labels for scroll bars 
        Label lbRed = new Label("Red        ", sbRed);
        Label lbGreen = new Label("Green    ", sbGreen);
        Label lbBlue = new Label("Blue       ", sbBlue);
        Label lbOpacity = new Label("Opacity", sbOpacity);

        // Create array to hold labels
        Label[] labels = {lbRed, lbGreen, lbBlue, lbOpacity};

        // Create VBox to hold sliders
        VBox vBox = new VBox(15);
        // Add the scrool bars to the vBox
        for (Label label: labels) {
            label.setContentDisplay(ContentDisplay.RIGHT);
            label.setGraphicTextGap(20);
            vBox.getChildren().add(label);
          
        }
        // Center allign vBox
        vBox.setAlignment(Pos.CENTER);

        // Create vBox to hold text and sliders
        VBox vBoxMain = new VBox(30);
        // Add text and sliders
        vBoxMain.getChildren().addAll(hBox, vBox);
        // Center alight the main vBox
        vBoxMain.setAlignment(Pos.CENTER);
        // Add padding
        vBoxMain.setPadding(new Insets(20, 15, 20, 15));
       
        // Create a scene and place it in the stage
        Scene scene = new Scene(vBoxMain);
        // Set the stage title
        primaryStage.setTitle("Control Text Color"); 
        // Set min size of stage
        primaryStage.setMinHeight(250);
        primaryStage.setMinWidth(275);
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Display the stage
        primaryStage.show();

        // Listener for red scroll bar value change
        sbRed.valueProperty().addListener(ov -> changeColor());
        // Listener for green scroll bar value change
        sbGreen.valueProperty().addListener(ov -> changeColor());
        // Listener for blue scroll bar value change
        sbBlue.valueProperty().addListener(ov -> changeColor());
        // Listener for opacity scroll bar value change
        sbOpacity.valueProperty().addListener(ov -> changeColor());
    }

    // Method that changes text color
    private void changeColor() {
        text.setFill(new Color(sbRed.getValue(), sbGreen.getValue(), sbBlue.getValue(), sbOpacity.getValue()));
    }

    /**
    * The main method is only needed for the IDE with limited JavaFX support. Not needed running from the command line.
    */
    public static void main(String[] args) {
          Application.launch(args);
    }
}
