package Tigerek; /**
 * Created by E6420 on 2016-11-19.
 */
import Tigerek.GUI;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class KeybindingController {
//    GUI window = null;
//    private int leftThrottle = 0;
//    private int rightThrottle = 0;
//    private static final int SPEED_INCREMENT = 5;
//    private static char leftAccel = 113;
//    private static char leftDecel = 97;
//    private static char rightAccel = 101;
//    private static char rightDecel = 100;
//    private static char bothAccel = 119;
//    private static char bothDecel = 115;
//    Action accelerateLeft = new AbstractAction() {
//        public void actionPerformed(ActionEvent evt) {
//            KeybindingController.this.leftThrottle = KeybindingController.this.accelerate(KeybindingController.this.leftThrottle);
//            KeybindingController.this.updateLabels();
//        }
//    };
//    Action decelerateLeft = new AbstractAction() {
//        public void actionPerformed(ActionEvent evt) {
//            KeybindingController.this.leftThrottle = KeybindingController.this.decelerate(KeybindingController.this.leftThrottle);
//            KeybindingController.this.updateLabels();
//        }
//    };
//    Action accelerateRight = new AbstractAction() {
//        public void actionPerformed(ActionEvent evt) {
//            KeybindingController.this.rightThrottle = KeybindingController.this.accelerate(KeybindingController.this.rightThrottle);
//            KeybindingController.this.updateLabels();
//        }
//    };
//    Action decelerateRight = new AbstractAction() {
//        public void actionPerformed(ActionEvent evt) {
//            KeybindingController.this.rightThrottle = KeybindingController.this.decelerate(KeybindingController.this.rightThrottle);
//            KeybindingController.this.updateLabels();
//        }
//    };
//    Action accelerateBoth = new AbstractAction() {
//        public void actionPerformed(ActionEvent evt) {
//            KeybindingController.this.leftThrottle = KeybindingController.this.accelerate(KeybindingController.this.leftThrottle);
//            KeybindingController.this.rightThrottle = KeybindingController.this.accelerate(KeybindingController.this.rightThrottle);
//            KeybindingController.this.updateLabels();
//        }
//    };
//    Action decelerateBoth = new AbstractAction() {
//        public void actionPerformed(ActionEvent evt) {
//            KeybindingController.this.leftThrottle = KeybindingController.this.decelerate(KeybindingController.this.leftThrottle);
//            KeybindingController.this.rightThrottle = KeybindingController.this.decelerate(KeybindingController.this.rightThrottle);
//            KeybindingController.this.updateLabels();
//        }
//    };
//
////    public KeybindingController(GUI window) {
////        this.window = window;
////    }
//
//    public void bindKeys() {
//        this.window.btnLeftAccel.getInputMap(2).put(KeyStroke.getKeyStroke(leftAccel), "accelerateLeft");
//        this.window.btnLeftAccel.getInputMap(2).put(KeyStroke.getKeyStroke(Character.toUpperCase(leftAccel)), "accelerateLeft");
//        this.window.btnLeftAccel.getActionMap().put("accelerateLeft", this.accelerateLeft);
//        this.window.btnLeftDecel.getInputMap(2).put(KeyStroke.getKeyStroke(leftDecel), "decelerateLeft");
//        this.window.btnLeftDecel.getInputMap(2).put(KeyStroke.getKeyStroke(Character.toUpperCase(leftDecel)), "decelerateLeft");
//        this.window.btnLeftDecel.getActionMap().put("decelerateLeft", this.decelerateLeft);
//        this.window.btnRightAccel.getInputMap(2).put(KeyStroke.getKeyStroke(rightAccel), "accelerateRight");
//        this.window.btnRightAccel.getInputMap(2).put(KeyStroke.getKeyStroke(Character.toUpperCase(rightAccel)), "accelerateRight");
//        this.window.btnRightAccel.getActionMap().put("accelerateRight", this.accelerateRight);
//        this.window.btnRightDecel.getInputMap(2).put(KeyStroke.getKeyStroke(rightDecel), "decelerateRight");
//        this.window.btnRightDecel.getInputMap(2).put(KeyStroke.getKeyStroke(Character.toUpperCase(rightDecel)), "decelerateRight");
//        this.window.btnRightDecel.getActionMap().put("decelerateRight", this.decelerateRight);
//        this.window.btnLeftAccel.getInputMap(2).put(KeyStroke.getKeyStroke(bothAccel), "accelerateBoth");
//        this.window.btnLeftAccel.getInputMap(2).put(KeyStroke.getKeyStroke(Character.toUpperCase(bothAccel)), "accelerateBoth");
//        this.window.btnLeftAccel.getActionMap().put("accelerateBoth", this.accelerateBoth);
//        this.window.btnLeftDecel.getInputMap(2).put(KeyStroke.getKeyStroke(bothDecel), "decelerateBoth");
//        this.window.btnLeftDecel.getInputMap(2).put(KeyStroke.getKeyStroke(Character.toUpperCase(bothDecel)), "decelerateBoth");
//        this.window.btnLeftDecel.getActionMap().put("decelerateBoth", this.decelerateBoth);
//    }
//
//    public void toggleControls() {
//        if(this.window.communicator.getConnected()) {
//            this.window.btnLeftAccel.setEnabled(true);
//            this.window.btnLeftDecel.setEnabled(true);
//            this.window.btnRightAccel.setEnabled(true);
//            this.window.btnRightDecel.setEnabled(true);
//            this.window.btnDisconnect.setEnabled(true);
//            this.window.btnConnect.setEnabled(false);
//            this.window.cboxPorts.setEnabled(false);
//        } else {
//            this.window.btnLeftAccel.setEnabled(false);
//            this.window.btnLeftDecel.setEnabled(false);
//            this.window.btnRightAccel.setEnabled(false);
//            this.window.btnRightDecel.setEnabled(false);
//            this.window.btnDisconnect.setEnabled(false);
//            this.window.btnConnect.setEnabled(true);
//            this.window.cboxPorts.setEnabled(true);
//        }
//
//    }
//
//    public void updateLabels() {
//        this.window.lblLeft.setText(String.valueOf(this.leftThrottle));
//        this.window.lblRight.setText(String.valueOf(this.rightThrottle));
//        this.window.communicator.writeData(this.leftThrottle, this.rightThrottle);
//    }
//
//    public int accelerate(int throttle) {
//        if(throttle < 100) {
//            throttle += 5;
//        }
//
//        return throttle;
//    }
//
//    public int decelerate(int throttle) {
//        if(throttle > 0) {
//            throttle -= 5;
//        }
//
//        return throttle;
//    }
//
//    public final int getLeftThrottle() {
//        return this.leftThrottle;
//    }
//
//    public void setLeftThrottle(int value) {
//        this.leftThrottle = value;
//    }
//
//    public final int getRightThrottle() {
//        return this.rightThrottle;
//    }
//
//    public void setRightThrottle(int value) {
//        this.rightThrottle = value;
//    }
}