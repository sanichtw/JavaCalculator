package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    public TextField textField;
    public StringBuilder formattedInput = new StringBuilder();
    public Button one;
    public char[] defaultOperations = {'+', '-', '/', '*'};
    public String operation;


    public void btnClicked(ActionEvent actionEvent) {
        getClickedBtn((Button) actionEvent.getSource());
    }

    public void getClickedBtn(Button btn) {
        formattedInput.append(btn.getText());
        textField.setText(formattedInput.toString());
    }

    public void backspace(ActionEvent actionEvent) {
        formattedInput.delete(formattedInput.length() - 1, formattedInput.length());
        textField.setText(formattedInput.toString());
    }

    public void reset() {
        formattedInput.delete(0, formattedInput.length());
        textField.setText(formattedInput.toString());
    }

    public void dotClicked() {
        if (!(formattedInput.charAt(formattedInput.length() - 1) == '.')) {
            formattedInput.append(".");
            textField.setText(formattedInput.toString());
        }
    }

    public void arithmeticOperation(ActionEvent actionEvent) {
        for (char symbol: defaultOperations) {
            if ((formattedInput.charAt(formattedInput.length() - 1) == symbol)) {
                return;
            }
        }
        Button btn = (Button) actionEvent.getSource();
        operation = btn.getText();

        formattedInput.append(operation);
        textField.setText(formattedInput.toString());
    }

    public void equals() {
        String[] operands = formattedInput
                .toString()
                .split(operation.equals("*") ? "\\*" :
                        operation.equals("+") ? "\\+" :
                                operation.equals("-") ? "\\-" :
                                        operation.equals("/") ? "\\/" : operation);
        double result;

        switch (operation) {
            case "/" :
                result = Double.parseDouble(operands[0]) / Double.parseDouble(operands[1]);

                formattedInput.replace(0, formattedInput.length(), String.valueOf(result));
                textField.setText(formattedInput.toString());
                break;

            case "*" :
                result = Double.parseDouble(operands[0]) * Double.parseDouble(operands[1]);

                formattedInput.replace(0, formattedInput.length(), String.valueOf(result));
                textField.setText(formattedInput.toString());
                break;

            case "-" :
                result = Double.parseDouble(operands[0]) - Double.parseDouble(operands[1]);

                formattedInput.replace(0, formattedInput.length(), String.valueOf(result));
                textField.setText(formattedInput.toString());
                break;

            case "+" :
                result = Double.parseDouble(operands[0]) + Double.parseDouble(operands[1]);

                formattedInput.replace(0, formattedInput.length(), String.valueOf(result));
                textField.setText(formattedInput.toString());
                break;
        }
    }

}