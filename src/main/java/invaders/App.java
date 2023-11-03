package invaders;

import invaders.mode_contex.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import invaders.engine.GameEngine;
import invaders.engine.GameWindow;
import invaders.mode_contex.*;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void modeChooseFrame(Stage primaryStage)
    {
        List<ModeStrategy> modeStrategies = new ArrayList<>();
        modeStrategies.add(new EasyModeStrategy());
        modeStrategies.add(new MediumModeStrategy());
        modeStrategies.add(new HardModeStrategy());

        ModeContex contex = new ModeContex(modeStrategies);

        VBox vbox = new VBox(10);
        vbox.getChildren().add(new Button("Easy"));
        vbox.getChildren().add(new Button("Medium"));
        vbox.getChildren().add(new Button("Hard"));

        for(int i=0;i<vbox.getChildren().size();i++)
        {
            Button button = (Button) vbox.getChildren().get(i);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button b = (Button) event.getSource();
                    String txt = b.getText();
                    String path = contex.getModePath(txt);
                    GameEngine model = new GameEngine(path);
                    GameWindow window = new GameWindow(model);
                    window.run();
                    primaryStage.setScene(window.getScene());
                }
            });
        }

        Scene scene1 = new Scene(vbox, 100, 100);

        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    @Override
    public void start(Stage primaryStage) {

        modeChooseFrame(primaryStage);

//        GameEngine model = new GameEngine("src/main/resources/config_easy.json");
//        GameWindow window = new GameWindow(model);
//        window.run();
//
//        primaryStage.setTitle("Space Invaders");
//        primaryStage.setScene(window.getScene());
//        primaryStage.show();
//
//        window.run();
    }
}


/*

--module-pathAVAFX PATH"--add-modules=javafx.controls
C:\Program Files\Eclipse Adoptium\jdk-17.0.4.101-hotspot\lib


 */

