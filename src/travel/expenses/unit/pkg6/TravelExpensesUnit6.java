/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.expenses.unit.pkg6;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author manny
 */
public class TravelExpensesUnit6 extends Application {
    
    TextField text1;
    TextField text2;
    TextField text3;
    TextField text4;
    TextField text5;
    TextField text6;
    TextField text7;
    TextField text8;
    
     Label prompt1 = new Label();
     Label prompt2 = new Label();
     Label prompt3 = new Label();
     Label prompt4 = new Label();
     Label prompt5 = new Label();
     Label prompt6 = new Label();
     Label prompt7 = new Label();
     Label prompt8 = new Label();
     
     
     Label result1;
     Label result2;
     Label result3;
     Label result4;
     Label result5;
     Label result6;
     Label result7;
     
     double numDays;
     double userTotal;
    
    @Override
    public void start(Stage primaryStage) {
        
        //Ask a question with user input
        //Set user input as a value for question
        prompt1.setText("Number of days on the trip: ");
        
         text1 = new TextField("0");
         
        
        //prompt2
        prompt2.setText("Car rental fees: ");
       
         text2 = new TextField("0");
        
        //prompt3 
        prompt3.setText("Number of Miles Driven (if private vehicle was used): ");
        
         text3 = new TextField("0");
        
        //prompt4
        prompt4.setText("Parking fees (if any): ");
        
         text4 = new TextField("0");
        
        //prompt5
        prompt5.setText("Taxi charges: ");
        
         text5 = new TextField("0");
        
        //prompt6
        prompt6.setText("Conferences or Seminar registration(if any): ");
        
         text6 = new TextField("0");
        
        //prompt7
        prompt7.setText("Lodging Charges per night: ");
        
         text7 = new TextField("0");
         
         //prompt7
        prompt8.setText("Meals: ");
        
         text8 = new TextField("0");
        
        
        
         
        //Calculate button
        
        Button btn = new Button();
        btn.setText("Calculate Expenses");
        btn.setOnAction(new CalcButtonHandler());
        
        //Empty result label
        result1 = new Label();   
        result2 = new Label(); 
        result3 = new Label(); 
        result4 = new Label(); 
        result5 = new Label(); 
         
        
        
        
        //Scene Elements add all labels
        HBox hbox1 = new HBox(10, prompt1, text1);
        HBox hbox2 = new HBox(10, prompt2, text2);
        HBox hbox3 = new HBox(10, prompt3, text3);
        HBox hbox4 = new HBox(10, prompt4, text4);
        HBox hbox5 = new HBox(10, prompt5, text5);
        HBox hbox6 = new HBox(10, prompt6, text6);
        HBox hbox7 = new HBox(10, prompt7, text7);
        HBox hbox8 = new HBox(10, prompt8, text8);
        
        
        hbox1.setAlignment(Pos.CENTER_RIGHT);
        hbox2.setAlignment(Pos.CENTER_RIGHT);
        hbox3.setAlignment(Pos.CENTER_RIGHT);
        hbox4.setAlignment(Pos.CENTER_RIGHT);
        hbox5.setAlignment(Pos.CENTER_RIGHT);
        hbox6.setAlignment(Pos.CENTER_RIGHT);
        hbox7.setAlignment(Pos.CENTER_RIGHT);
        hbox8.setAlignment(Pos.CENTER_RIGHT);
        
        
//       hbox1.setAlignment(Pos.CENTER_LEFT);
//       hbox2.setAlignment(Pos.CENTER_LEFT);
       
        //TODO add labels to hbox
        
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(
                hbox1,
                hbox2, 
                hbox3,
                hbox4,
                hbox5,
                hbox6,
                hbox7,
                hbox8,
                btn, 
                result1,
                result2,
                result3
        );
        
        vbox.setAlignment(Pos.CENTER_RIGHT);
        vbox.setPadding(new Insets(10));
        
        Scene scene = new Scene(vbox, 550, 500);
        
        primaryStage.setTitle("Travel Expense Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class CalcButtonHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
       
        //calculations
        double days = Double.parseDouble(text1.getText());
        double carRental = Double.parseDouble(text2.getText());
        double numMiles = Double.parseDouble(text3.getText());
        double parkingFees = Double.parseDouble(text4.getText());
        double taxiFees = Double.parseDouble(text5.getText());
        double regFees = Double.parseDouble(text6.getText());
        double lodgingPerNight = Double.parseDouble(text7.getText());
        double meals = Double.parseDouble(text8.getText());
        
        //Company defined allowables
        double allowedMeals = 47;
        double allowedParking = 20;
        double allowedTaxi = 40;
        double allowedLodging = 195;
        double gasReimbursment = 0.42;
        
        //total values based on the number of days
        double totalLodging = days * lodgingPerNight;
        double totalGasReimbursment = numMiles * gasReimbursment;
        double userExpenses = carRental + totalGasReimbursment + parkingFees + taxiFees + regFees + totalLodging + meals;
        double allowedExpenses = (days * (allowedMeals + allowedParking + allowedTaxi + allowedLodging))+ totalGasReimbursment;
        double excess = userExpenses - allowedExpenses;
        double savings = allowedExpenses - userExpenses;
        
        
        
        //results to be displayed
        result1.setText("Total Expenses: " + userExpenses);
        result2.setText("Total Allowed:  " + allowedExpenses);
        
        //value dependent Statment excess vs savings
        if(userExpenses > allowedExpenses) {
        result3.setText("Excess Owed:    " + excess);
        } else {
            result3.setText("Savings:    " + savings);
                }
        
        
        
        
        
        
    }
    
}

    
}
