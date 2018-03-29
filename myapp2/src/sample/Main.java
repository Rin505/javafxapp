package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.NumberFormat;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            primaryStage.setTitle("Создание расчетного приложения");

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(10, 10, 10, 10));

            Scene scene = new Scene(grid, 400, 600);
            primaryStage.setScene(scene);

            Text scenetitle = new Text("Расчет элементарных действий");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
            grid.add(scenetitle, 0, 0, 2, 1);

            Label argNad1 = new Label("Введите первое число:");
            grid.add(argNad1, 0, 1);
            Label argNad2 = new Label("Введите второе число:");
            grid.add(argNad2, 0, 2);

            TextField arg1 = new TextField();
            grid.add(arg1, 1, 1);
            TextField arg2 = new TextField();
            grid.add(arg2, 1, 2);

            Button btnSum = new Button("Сумма");
            HBox hbBtn1 = new HBox(10);
            hbBtn1.setAlignment(Pos.BOTTOM_CENTER);
            hbBtn1.getChildren().add(btnSum);
            grid.add(hbBtn1, 0, 4);

            Button btnRaz = new Button("Разность");
            HBox hbBtn2 = new HBox(10);
            hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
            hbBtn2.getChildren().add(btnRaz);
            grid.add(hbBtn2, 1, 4);

            Button btnDiv = new Button("Частное");
            HBox hbBtn3 = new HBox(10);
            hbBtn3.setAlignment(Pos.BOTTOM_CENTER);
            hbBtn3.getChildren().add(btnDiv);
            grid.add(hbBtn3, 0, 5);

            Button btnMulty = new Button("Произведение");
            HBox hbBtn4 = new HBox(10);
            hbBtn4.setAlignment(Pos.BOTTOM_CENTER);
            hbBtn4.getChildren().add(btnMulty);
            grid.add(hbBtn4, 1, 5);

            Label lbRezultatNad = new Label("Результат:");
            grid.add(lbRezultatNad, 0, 6);
            Label lbRezultat = new Label("Вычисление не проводилось");
            grid.add(lbRezultat, 1, 6);

            // button events

            btnSum.setOnAction(event -> {
                String a1 = arg1.getText();
                String a2 = arg2.getText();


                if( CheckString(a1, a2) == "false") {
                    Long la1 = Long.valueOf(a1);
                    Long la2 = Long.valueOf(a2);
                    Long result = la1 + la2;
                    String sresult = result.toString();
                    lbRezultat.setText(sresult);
                } else {
                    lbRezultat.setText(CheckString(a1, a2));
                }
            });

            btnRaz.setOnAction(event -> {
                String a1 = arg1.getText();
                String a2 = arg2.getText();


                if( CheckString(a1, a2) == "false") {
                    Long la1 = Long.valueOf(a1);
                    Long la2 = Long.valueOf(a2);
                    Long result = la1 - la2;
                    String sresult = result.toString();
                    lbRezultat.setText(sresult);
                } else {
                    lbRezultat.setText(CheckString(a1, a2));
                }

            });

            btnDiv.setOnAction(event -> {
                String a1 = arg1.getText();
                String a2 = arg2.getText();


                if( CheckString(a1, a2) == "false") {
                    Long la1 = Long.valueOf(a1);
                    Long la2 = Long.valueOf(a2);
                    Long result = la1 / la2;
                    String sresult = result.toString();
                    lbRezultat.setText(sresult);
                } else {
                    lbRezultat.setText(CheckString(a1, a2));
                }

            });

            btnMulty.setOnAction(event -> {
                String a1 = arg1.getText();
                String a2 = arg2.getText();


                    if( CheckString(a1, a2) == "false") {
                        Long la1 = Long.valueOf(a1);
                        Long la2 = Long.valueOf(a2);
                        Long result = la1 * la2;
                        String sresult = result.toString();
                        lbRezultat.setText(sresult);
                    } else {
                        lbRezultat.setText(CheckString(a1, a2));
                    }


            });
            //end button events

            //author info
            Label author = new Label("Author: Москалёв В.А.");
            grid.add(author, 1, 10);

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Long.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String CheckString(String a, String b) {


        if (isDigit(a) && !isDigit(b)) {
            return "Второе число введено неверно";

        } else if (!isDigit(a) && isDigit(b)) {
            return "Первое число введено неверно";

        } else if (!isDigit(a) && !isDigit(b)) {
            return "Оба числа введены неверно";
        }
        else return "false";

    }

}
