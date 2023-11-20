import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import java.io.*;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;


public class airplaneGUI extends Application
{
   public void start(Stage primaryStage) 
   { 
      Label label = new Label("Enter Your Name: ");
      
      TextField fieldText = new TextField ();
      TextField fieldText2 = new TextField ();
      fieldText2.setVisible(false);
      TilePane t = new TilePane(); 
      
      Label label2 = new Label("");
      Label label3 = new Label("");
      Label label4 = new Label("");
      Label label5 = new Label("");
      Label label6 = new Label("");
      Label label7 = new Label("");
      Label label8 = new Label("");
      Label label9 = new Label("");
      Label label10 = new Label("");
        
      Button button_1 = new Button("Yes");
      button_1.setVisible(false);
      Button button_2 = new Button("No");
      button_2.setVisible(false);
                 
      Image img = new Image("airplane.jpeg");
      ImageView imgView = new ImageView(img);
      imgView.setTranslateX(200);
      imgView.setFitWidth(130);
      imgView.setPreserveRatio(true);
      
      StackPane pane = new StackPane(imgView);
      pane.setVisible(false);
      pane.setTranslateX(-100);

      EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

         public void handle(ActionEvent e)
         {
            label2.setText("Welcome ");
            label3.setText(fieldText.getText());
            label4.setText(",  here are the airlines we have available:\n"+
                           "\nUS Air -- From: Boston, To: Los Angeles\n"+
                           "Delta -- From: Philadelphia, To: London\n"+
                           "Continental -- From: Atlanta, To: Chicago");
            label5.setText("\nDo you want to change your Destination?"); 
            button_1.setVisible(true);
            button_2.setVisible(true);
            pane.setVisible(true);
             
         }                 
      };
    
      fieldText.setOnAction(event);

      t.getChildren().add(fieldText);
      t.getChildren().add(label2);
      t.getChildren().add(label3);
      t.getChildren().add(label4);
      t.getChildren().add(label5);  
      
      EventHandler<ActionEvent> buttonsyes = new EventHandler<ActionEvent>() {
        
         public void handle(ActionEvent e) {
            
            label6.setText("Enter the city destination you wish to travel to: ");
            fieldText2.setVisible(true);
            label10.setVisible(false);
            label6.setVisible(true);
            fieldText2.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(true);
            label9.setVisible(true);
         }
      };

      
      button_1.setOnAction(buttonsyes);
      t.getChildren().add(label6);
      
     EventHandler<ActionEvent> change = new EventHandler<ActionEvent>() {

         public void handle(ActionEvent e)
         {
            label7.setText(fieldText.getText());
            label8.setText(", you will now be traveling from Atlanta to ");
            label9.setText(fieldText2.getText());
         }                 
      };
      
      fieldText2.setOnAction(change);
      
      t.getChildren().add(label7);
      t.getChildren().add(label8);
      t.getChildren().add(label9);
      
      EventHandler<ActionEvent> buttonsno = new EventHandler<ActionEvent>() {
        
         public void handle(ActionEvent e) {
            
            label10.setText("Your flight has been confirmed!");
            label10.setVisible(true);
            label6.setVisible(false);
            fieldText2.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            
         }
      };
      
      
      button_2.setOnAction(buttonsno);
      t.getChildren().add(label10);

      
      HBox hbox = new HBox(label, fieldText);
      hbox.setSpacing(10);
      
      HBox hbox1 = new HBox(label2, label3, label4, pane);
      
      HBox hbox2 = new HBox(button_1, button_2);
      hbox2.setSpacing(15);
      hbox2.setAlignment(Pos.CENTER);

      HBox hbox3 = new HBox(label6, fieldText2);  
      
      HBox hbox4 = new HBox(label7, label8, label9);
      
      VBox box = new VBox(hbox, hbox1, label5, hbox2, hbox3, hbox4, label10);
      box.setSpacing(5);
      
      Scene scene = new Scene(box, 600,300);
      
      BackgroundFill background_fill = new BackgroundFill(Color.LIGHTBLUE, 
                                          CornerRadii.EMPTY, Insets.EMPTY);
  
  
      Background background = new Background(background_fill);
      box.setBackground(background);

      primaryStage.setTitle("Lorena's Airline Service");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}


