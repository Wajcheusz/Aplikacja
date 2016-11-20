package Tigerek;

/**
 * Created by E6420 on 2016-11-19.
 */
import Tigerek.GUI;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class Communicator implements SerialPortEventListener {
    public static String x="10";
    GUI window = null;
    private Enumeration ports = null;
    private HashMap portMap = new HashMap();
    private CommPortIdentifier selectedPortIdentifier = null;
    private SerialPort serialPort = null;
    private InputStream input = null;
    private OutputStream output = null;
    private boolean bConnected = false;
    static final int TIMEOUT = 2000;
    static final int SPACE_ASCII = 32;
    static final int DASH_ASCII = 45;
    static final int NEW_LINE_ASCII = 10;
    public static String logText = "";


//    public Communicator(GUI window) {
//        this.window = window;
//    }

//    public void searchForPorts() {
//        this.ports = CommPortIdentifier.getPortIdentifiers();
//        //System.out.println();
//        while(this.ports.hasMoreElements()) {
//            CommPortIdentifier curPort = (CommPortIdentifier)this.ports.nextElement();
//            //if(curPort.getPortType() == 1) {
//                //this.window.cboxPorts.addItem(curPort.getName());
//                //this.portMap.put(curPort.getName(), curPort);
//            //}
//        }
//
//    }

    public void connect() {
        CommPortIdentifier serialPortId = null;
        Enumeration enumComm;
        List<CommPortIdentifier> x = new ArrayList<CommPortIdentifier>();


        enumComm = CommPortIdentifier.getPortIdentifiers();
        while (enumComm.hasMoreElements()) {
            serialPortId = (CommPortIdentifier) enumComm.nextElement();
            if (serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                x.add(serialPortId);
                System.out.println(serialPortId.getName());
            }
        }
        
        String selectedPort = "COM11";//(String)serialPortId.getName();//"COM11";//(String)this.window.cboxPorts.getSelectedItem();
        this.selectedPortIdentifier = (CommPortIdentifier)this.portMap.get(selectedPort);
        CommPort commPort = null;

        try {
            //commPort = this.selectedPortIdentifier.open("TigerControlPanel", 2000);
            //commPort = serialPortId.open("TigerControlPanel", 2000);
            commPort = x.get(4).open("TigerControlPanel", 1000);
            this.serialPort = (SerialPort)commPort;
            this.setConnected(true);
            this.logText = selectedPort + " opened successfully.";
            //this.window.txtLog.setForeground(Color.black);
            //this.window.txtLog.append(this.logText + "\n");
            System.out.println(this.logText);
            //System.out.println(this.logText + "\n");
            //this.window.keybindingController.toggleControls();
        } catch (PortInUseException var4) {
            this.logText = selectedPort + " is in use. (" + var4.toString() + ")";
            System.out.println(this.logText + "\n");
            //this.window.txtLog.setForeground(Color.RED);
            //this.window.txtLog.append(this.logText + "\n");
        } catch (Exception var5) {
            this.logText = "Failed to open " + selectedPort + "(" + var5.toString() + ")";
            System.out.println(this.logText + "\n");
            //this.window.txtLog.append(this.logText + "\n");
            //this.window.txtLog.setForeground(Color.RED);
        }

    }

    public boolean initIOStream() {
        boolean successful = false;

        try {
            this.input = this.serialPort.getInputStream();
            this.output = this.serialPort.getOutputStream();
            this.writeData(0, 0);
            successful = true;
            return successful;
        } catch (IOException var3) {
            this.logText = "I/O Streams failed to open. (" + var3.toString() + ")";
            //this.window.txtLog.setForeground(Color.red);
            //this.window.txtLog.append(this.logText + "\n");
            //System.out.println(this.logText + "\n");
            System.out.println(this.logText + "\n");
            return successful;
        }
    }

    public void initListener() {
        try {
            this.serialPort.addEventListener(this);
            this.serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException var2) {
            this.logText = "Too many listeners. (" + var2.toString() + ")";
            //this.window.txtLog.setForeground(Color.red);
            //this.window.txtLog.append(this.logText + "\n");
            System.out.println(this.logText + "\n");
        }

    }

    public void disconnect() {
        try {
            this.writeData(0, 0);
            this.serialPort.removeEventListener();
            this.serialPort.close();
            this.input.close();
            this.output.close();
            this.setConnected(false);
            //this.window.keybindingController.toggleControls();
            this.logText = "Disconnected.";
            System.out.println(this.logText + "\n");
            //this.window.txtLog.setForeground(Color.red);
            //this.window.txtLog.append(this.logText + "\n");
        } catch (Exception var2) {
            this.logText = "Failed to close " + this.serialPort.getName() + "(" + var2.toString() + ")";
            System.out.println(this.logText + "\n");
            //this.window.txtLog.setForeground(Color.red);
            //this.window.txtLog.append(this.logText + "\n");
        }

    }

    public final boolean getConnected() {
        return this.bConnected;
    }

    public void setConnected(boolean bConnected) {
        this.bConnected = bConnected;
    }

//    public void serialEvent(SerialPortEvent evt) {
//        if(evt.getEventType() == 1) {
//            try {
//                byte e = (byte)this.input.read();
//
//                if(e != 10) {
//                    //x = new String(new byte[]{e});
//                    this.logText = new String(new byte[]{e});
//                    x=logText;
//                    //System.out.println(this.logText + "\n");
//                    System.out.println(this.logText);
//                    //this.window.txtLog.append(this.logText);
//                } else {
//                    //this.window.txtLog.append("\n");
//                    System.out.println("rowne 10");
//                }
//            } catch (Exception var3) {
//                this.logText = "Failed to read data. (" + var3.toString() + ")";
//                System.out.println(this.logText + "\n");
////                this.window.txtLog.setForeground(Color.red);
////                this.window.txtLog.append(this.logText + "\n");
//            }
//        }
//
//    }

    static StringBuffer z = new StringBuffer();
    public void serialEvent(SerialPortEvent evt) {

        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE)
        {
            try
            {
                byte singleData = (byte)input.read();

                if (singleData != NEW_LINE_ASCII)
                {
                    //if(logText.equals(" ")) {return;}
                    logText = new String(new byte[] {singleData});
                    x=logText;
                    x=x.trim();
                    //System.out.print(logText);
                    System.out.print(x);
                    //window.txtLog.append(logText);
                }
                else
                {
                    //z.trimToSize();
//                    String temp=null;
//                    z.deleteCharAt(0);
//                    z.deleteCharAt(0);
//                    temp=z.toString();
//                    if (temp.contains(" ")){
//                        z.substring(0, z.indexOf(" "));
//                    }
//                    x=z.toString();
                    //z.substring(0,3);
                    System.out.print("\n");
                }
            }
            catch (Exception e)
            {
                logText = "Failed to read data. (" + e.toString() + ")";
                //window.txtLog.setForeground(Color.red);
                //window.txtLog.append(logText + "\n");
            }
        }
    }



    public void writeData(int leftThrottle, int rightThrottle) {
        try {
            this.output.write(leftThrottle);
            this.output.flush();
            this.output.write(45);
            this.output.flush();
            this.output.write(rightThrottle);
            this.output.flush();
            this.output.write(32);
            this.output.flush();
        } catch (Exception var4) {
            this.logText = "Failed to write data. (" + var4.toString() + ")";
            System.out.println(this.logText + "\n");
//            this.window.txtLog.setForeground(Color.red);
//            this.window.txtLog.append(this.logText + "\n");
        }

    }
}
