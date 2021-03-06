package Tigerek;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * A chart that fills in the area between a line of data points and the axes.
 * Good for comparing accumulated totals over time.
 *
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.Axis
 * @see javafx.scene.chart.NumberAxis
 * @related charts/line/LineChart
 * @related charts/scatter/ScatterChart
 */
public class Chart extends Application {
    Communicator communicator = null;
    KeybindingController keybindingController = null;
    private static final int MAX_DATA_POINTS = 50;

    private XYChart.Series series;
    private int xSeriesData = 0;
    private ConcurrentLinkedQueue<Number> dataQ = new ConcurrentLinkedQueue<Number>();
    private ExecutorService executor;
    private AddToQueue addToQueue;
    private Timeline timeline2;
    private NumberAxis xAxis;


    public Chart() {
        //this.initComponents();
        this.createObjects();
        //this.communicator.searchForPorts();
        //this.keybindingController.toggleControls();
        //this.keybindingController.bindKeys();
    }

    private void createObjects() {
        this.communicator = new Communicator();
//        this.keybindingController = new KeybindingController();
    }

    private void init(Stage primaryStage) {
        HBox topMenu = new HBox();
        Button button1 = new Button("File");
        Button button2 = new Button("Edit");
        Button button3 = new Button("View");
        button1.setOnAction(event ->{
        this.communicator.connect();
            if(this.communicator.getConnected() && this.communicator.initIOStream()) {
            this.communicator.initListener();
            }
        });
        topMenu.getChildren().addAll(button1, button2, button3);

        VBox leftMenu = new VBox();
        Button button4 = new Button("D");
        Button button5 = new Button("E");
        Button button6 = new Button("F");
        leftMenu.getChildren().addAll(button4, button5, button6);

        BorderPane  borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        xAxis = new NumberAxis(0,MAX_DATA_POINTS,MAX_DATA_POINTS/10);
        xAxis.setForceZeroInRange(false);
        xAxis.setAutoRanging(false);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setAutoRanging(true);

        //-- Chart
        final AreaChart<Number, Number> sc = new AreaChart<Number, Number>(xAxis, yAxis) {
            // Override to remove symbols on each data point
            @Override protected void dataItemAdded(Series<Number, Number> series, int itemIndex, Data<Number, Number> item) {}
        };
        sc.setAnimated(false);
        sc.setId("liveAreaChart");
        sc.setTitle("Animated Area Chart");

        //-- Chart Series
        series = new AreaChart.Series<Number, Number>();
        series.setName("Area Chart Series");
        sc.getData().add(series);

        borderPane.setRight(sc);
        primaryStage.setScene(new Scene((borderPane)));
        //primaryStage.setScene(new Scene(sc));
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();

        //-- Prepare Executor Services
        executor = Executors.newCachedThreadPool();
        addToQueue = new AddToQueue();
        executor.execute(addToQueue);
        //-- Prepare Timeline
        prepareTimeline();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class AddToQueue implements Runnable {
        public void run() {
            try {
                // add a item of random data to queue
                //dataQ.add(Math.random());
                try {
                    System.out.println(Communicator.x);
                    dataQ.add(Double.parseDouble(Communicator.x));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                Thread.sleep(2500);
                executor.execute(this);
            } catch (InterruptedException ex) {
                //Logger.getLogger(AreaChartSample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //-- Timeline gets called in the JavaFX Main thread
    private void prepareTimeline() {
        // Every frame to take any data from queue and add to chart
        new AnimationTimer() {
            @Override public void handle(long now) {
                addDataToSeries();
            }
        }.start();
    }

    private void addDataToSeries() {
        for (int i = 0; i < 20; i++) { //-- add 20 numbers to the plot+
            if (dataQ.isEmpty()) break;
            series.getData().add(new AreaChart.Data(xSeriesData++, dataQ.remove()));
        }
        // remove points to keep us at no more than MAX_DATA_POINTS
        if (series.getData().size() > MAX_DATA_POINTS) {
            series.getData().remove(0, series.getData().size() - MAX_DATA_POINTS);
        }
        // update
        xAxis.setLowerBound(xSeriesData-MAX_DATA_POINTS);
        xAxis.setUpperBound(xSeriesData-1);
    }
}