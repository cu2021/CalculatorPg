package Calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    Label resultLabel;
    Button numbersButtons, equalButtons,
            additionButton, subtractionButton, multiplyButton, divisionButton, clearButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        resultLabel = new Label("");

        VBox vBox = new VBox(resultLabel);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: darkslategrey;");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        int number = 9;
        MyEventHandler click = new MyEventHandler();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {

                numbersButtons = new Button("" + number);
                gridPane.add(numbersButtons, j, i);
                numbersButtons.setId("" + number--);
                numbersButtons.setOnAction(click);
                numbersButtons.setPadding(new Insets(30));
                if (i == 3) {
                    break;
                }
            }
        }
        MyEventHandler click2 = new MyEventHandler();
        additionButton = new Button("+");
        gridPane.add(additionButton, 3, 0);
        additionButton.setOnAction(click2);
        additionButton.setId("plus");
        additionButton.setPadding(new Insets(30, 26, 30, 26.5));

        subtractionButton = new Button("-");
        gridPane.add(subtractionButton, 3, 1);
        subtractionButton.setOnAction(click2);
        subtractionButton.setId("minus");
        subtractionButton.setPadding(new Insets(30));

        multiplyButton = new Button("*");
        gridPane.add(multiplyButton, 3, 2);
        multiplyButton.setOnAction(click2);
        multiplyButton.setId("multy");
        multiplyButton.setPadding(new Insets(30));

        divisionButton = new Button("/");
        gridPane.add(divisionButton, 3, 3);
        divisionButton.setOnAction(click2);
        divisionButton.setId("div");
        divisionButton.setPadding(new Insets(30));

        equalButtons = new Button("=");
        gridPane.add(equalButtons, 2, 3);
        equalButtons.setOnAction(click2);
        equalButtons.setId("equal");
        equalButtons.setPadding(new Insets(30, 28, 30, 28));

        clearButton = new Button("CL");
        gridPane.add(clearButton, 1, 3);
        clearButton.setOnAction(click2);
        clearButton.setId("clear");
        clearButton.setPadding(new Insets(30, 23.5, 30, 23.5));

        VBox box = new VBox(20, vBox, gridPane);
        box.setAlignment(Pos.CENTER);
        box.heightProperty();
        Scene scene = new Scene(box, 350, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    private class MyEventHandler implements EventHandler<ActionEvent> {

        double fristOp;
        double secOp;
        char operator;

        @Override
        public void handle(ActionEvent event) {
            if (((Button) (event.getSource())).getId().equalsIgnoreCase("9")) {
                resultLabel.setText(resultLabel.getText() + "9");
            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("8")) {
                resultLabel.setText(resultLabel.getText() + "8");

            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("7")) {
                resultLabel.setText(resultLabel.getText() + "7");

            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("6")) {
                resultLabel.setText(resultLabel.getText() + "6");

            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("5")) {
                resultLabel.setText(resultLabel.getText() + "5");

            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("4")) {
                resultLabel.setText(resultLabel.getText() + "4");

            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("3")) {
                resultLabel.setText(resultLabel.getText() + "3");

            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("2")) {
                resultLabel.setText(resultLabel.getText() + "2");

            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("1")) {
                resultLabel.setText(resultLabel.getText() + "1");

            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("0")) {
                resultLabel.setText(resultLabel.getText() + "0");

            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("clear")) {
                resultLabel.setText("");
                fristOp = 0.0;
                secOp = 0.0;
                operator = ' ';
            } else if (((Button) (event.getSource())).getId().equalsIgnoreCase("equal")) {

                if (resultLabel.getText() == null || resultLabel.getText().equals("")) {

                } else {
                    secOp = Double.parseDouble(resultLabel.getText());
                    equalation();
                }
            } else {
                if (resultLabel.getText() == null || resultLabel.getText().equals("")) {
                } else {
                    fristOp = Double.parseDouble(resultLabel.getText());
                    switch (((Button) (event.getSource())).getId()) {
                        case "plus":
                            operator = '+';
                            break;
                        case "minus":
                            operator = '-';
                            break;
                        case "multy":
                            operator = '*';
                            break;
                        case "div":
                            operator = '/';
                            break;
                    }
                    resultLabel.setText("");

                }
            }

        }

        void equalation() {
            switch (operator) {
                case '+':
                    resultLabel.setText("" + ((double) (fristOp) + secOp));
                    break;
                case '-':
                    resultLabel.setText("" + ((fristOp * 1d) - secOp));
                    break;
                case '*':
                    resultLabel.setText("" + ((fristOp * 1d) * secOp));
                    break;
                case '/':
                    resultLabel.setText("" + ((fristOp * 1d) / secOp));
                    break;
                default:
            }
        }
    }
}
