package Tigerek;

import Tigerek.Communicator;
import Tigerek.KeybindingController;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI extends JFrame {
//    Communicator communicator = null;
//    KeybindingController keybindingController = null;
//    public JButton btnConnect;
//    public JButton btnDisconnect;
//    public JButton btnLeftAccel;
//    public JButton btnLeftDecel;
//    public JButton btnRightAccel;
//    public JButton btnRightDecel;
//    public JComboBox cboxPorts;
//    private JLabel jLabel1;
//    private JLabel jLabel10;
//    private JLabel jLabel11;
//    private JLabel jLabel12;
//    private JLabel jLabel13;
//    private JLabel jLabel2;
//    private JLabel jLabel3;
//    private JLabel jLabel4;
//    private JLabel jLabel5;
//    private JLabel jLabel6;
//    private JLabel jLabel7;
//    private JLabel jLabel8;
//    private JLabel jLabel9;
//    private JScrollPane jScrollPane1;
//    private JScrollPane jScrollPane2;
//    private JTextArea jTextArea1;
//    public JLabel lblLeft;
//    public JLabel lblRight;
//    public JTextArea txtLog;
//
//    public GUI() {
//        this.initComponents();
//        this.createObjects();
//        this.communicator.searchForPorts();
//        this.keybindingController.toggleControls();
//        this.keybindingController.bindKeys();
//    }
//
//    private void createObjects() {
//        this.communicator = new Communicator(this);
//        this.keybindingController = new KeybindingController(this);
//    }
//
//    private void initComponents() {
//        this.jScrollPane1 = new JScrollPane();
//        this.jTextArea1 = new JTextArea();
//        this.jLabel1 = new JLabel();
//        this.jLabel2 = new JLabel();
//        this.jLabel3 = new JLabel();
//        this.jLabel4 = new JLabel();
//        this.lblLeft = new JLabel();
//        this.btnLeftAccel = new JButton();
//        this.btnLeftDecel = new JButton();
//        this.btnRightAccel = new JButton();
//        this.lblRight = new JLabel();
//        this.btnRightDecel = new JButton();
//        this.cboxPorts = new JComboBox();
//        this.jLabel5 = new JLabel();
//        this.btnConnect = new JButton();
//        this.btnDisconnect = new JButton();
//        this.jLabel6 = new JLabel();
//        this.jLabel7 = new JLabel();
//        this.jLabel8 = new JLabel();
//        this.jLabel9 = new JLabel();
//        this.jLabel10 = new JLabel();
//        this.jLabel11 = new JLabel();
//        this.jLabel12 = new JLabel();
//        this.jLabel13 = new JLabel();
//        this.jScrollPane2 = new JScrollPane();
//        this.txtLog = new JTextArea();
//        this.jTextArea1.setColumns(20);
//        this.jTextArea1.setRows(5);
//        this.jScrollPane1.setViewportView(this.jTextArea1);
//        this.setDefaultCloseOperation(3);
//        this.setTitle("Tiger Tank Control Panel");
//        this.jLabel1.setFont(new Font("Tahoma", 1, 14));
//        this.jLabel1.setText("Tiger Tank Control Panel");
//        this.jLabel2.setFont(new Font("Tahoma", 1, 11));
//        this.jLabel2.setText("Throttle");
//        this.jLabel3.setHorizontalAlignment(0);
//        this.jLabel3.setText("Left");
//        this.jLabel4.setHorizontalAlignment(0);
//        this.jLabel4.setText("Right");
//        this.lblLeft.setFont(new Font("Tahoma", 1, 18));
//        this.lblLeft.setHorizontalAlignment(0);
//        this.lblLeft.setText("0");
//        this.btnLeftAccel.setText("/\\");
//        this.btnLeftAccel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                GUI.this.btnLeftAccelActionPerformed(evt);
//            }
//        });
//        this.btnLeftDecel.setText("\\/");
//        this.btnLeftDecel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                GUI.this.btnLeftDecelActionPerformed(evt);
//            }
//        });
//        this.btnRightAccel.setText("/\\");
//        this.btnRightAccel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                GUI.this.btnRightAccelActionPerformed(evt);
//            }
//        });
//        this.lblRight.setFont(new Font("Tahoma", 1, 18));
//        this.lblRight.setHorizontalAlignment(0);
//        this.lblRight.setText("0");
//        this.btnRightDecel.setText("\\/");
//        this.btnRightDecel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                GUI.this.btnRightDecelActionPerformed(evt);
//            }
//        });
//        this.jLabel5.setFont(new Font("Tahoma", 1, 11));
//        this.jLabel5.setText("Select the XBee COM Port");
//        this.btnConnect.setText("Connect");
//        this.btnConnect.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                GUI.this.btnConnectActionPerformed(evt);
//            }
//        });
//        this.btnDisconnect.setText("Disconnect");
//        this.btnDisconnect.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                GUI.this.btnDisconnectActionPerformed(evt);
//            }
//        });
//        this.jLabel6.setFont(new Font("Tahoma", 1, 11));
//        this.jLabel6.setText("Controls");
//        this.jLabel7.setText("Q - Accelerate Left");
//        this.jLabel8.setText("A - Decelerate Left");
//        this.jLabel9.setText("W - Accelerate Both");
//        this.jLabel10.setText("S - Decelerate Both");
//        this.jLabel11.setText("D - Decelerate Right");
//        this.jLabel12.setText("E - Accelerate Right");
//        this.jLabel13.setFont(new Font("Tahoma", 1, 11));
//        this.jLabel13.setText("Log");
//        this.txtLog.setColumns(20);
//        this.txtLog.setEditable(false);
//        this.txtLog.setLineWrap(true);
//        this.txtLog.setRows(5);
//        this.txtLog.setFocusable(false);
//        this.jScrollPane2.setViewportView(this.txtLog);
//        GroupLayout layout = new GroupLayout(this.getContentPane());
//        this.getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.cboxPorts, -2, 69, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.btnConnect).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.btnDisconnect)).addComponent(this.jLabel5).addComponent(this.jLabel2).addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addGroup(Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel3, -2, 37, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel4, -1, -1, 32767)).addGroup(Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.btnLeftDecel).addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.lblLeft, Alignment.LEADING, -1, -1, 32767).addComponent(this.btnLeftAccel, Alignment.LEADING))).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.btnRightDecel).addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.lblRight, Alignment.LEADING, -1, -1, 32767).addComponent(this.btnRightAccel, Alignment.LEADING))))).addComponent(this.jLabel6).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.jLabel7)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel10).addComponent(this.jLabel9)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel11).addComponent(this.jLabel12)))).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel13).addComponent(this.jScrollPane2, -2, 333, -2)))).addContainerGap()));
//        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jLabel13)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.jScrollPane2, Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.cboxPorts, -2, -1, -2).addComponent(this.btnConnect).addComponent(this.btnDisconnect)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel4)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.btnLeftAccel).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.lblLeft).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.btnLeftDecel)).addGroup(layout.createSequentialGroup().addComponent(this.btnRightAccel).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.lblRight).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.btnRightDecel))).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel6).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel12).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel11)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel8)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel9).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel10))))).addContainerGap(-1, 32767)));
//        this.pack();
//    }
//
//    private void btnLeftAccelActionPerformed(ActionEvent evt) {
//        double z = Double.parseDouble(Communicator.x);
//        z++;
//        Communicator.x= String.valueOf(z);
//        this.keybindingController.setLeftThrottle(this.keybindingController.accelerate(this.keybindingController.getLeftThrottle()));
//        this.keybindingController.updateLabels();
//    }
//
//    private void btnLeftDecelActionPerformed(ActionEvent evt) {
//        double z = Double.parseDouble(Communicator.x);
//        z++;
//        Communicator.x= String.valueOf(z);
//        this.keybindingController.setLeftThrottle(this.keybindingController.decelerate(this.keybindingController.getLeftThrottle()));
//        this.keybindingController.updateLabels();
//    }
//
//    private void btnRightAccelActionPerformed(ActionEvent evt) {
//        this.keybindingController.setRightThrottle(this.keybindingController.accelerate(this.keybindingController.getRightThrottle()));
//        this.keybindingController.updateLabels();
//    }
//
//    private void btnRightDecelActionPerformed(ActionEvent evt) {
//        this.keybindingController.setRightThrottle(this.keybindingController.decelerate(this.keybindingController.getRightThrottle()));
//        this.keybindingController.updateLabels();
//    }
//
//    private void btnConnectActionPerformed(ActionEvent evt) {
//        this.communicator.connect();
//        if(this.communicator.getConnected() && this.communicator.initIOStream()) {
//            this.communicator.initListener();
//        }
//
//    }
//
//    private void btnDisconnectActionPerformed(ActionEvent evt) {
//        this.communicator.disconnect();
//    }
//
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                (new GUI()).setVisible(true);
//            }
//        });
//    }
}