/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myproj;

import javax.swing.JTextField;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author user
 */
     class PortReader implements SerialPortEventListener {

         
                static SerialPort serialPort;
JTextField jtextfield;
    public PortReader(SerialPort serialPort,JTextField jtextfield) {
        this.serialPort=serialPort;
    }
                
                
        @Override
        public void serialEvent(SerialPortEvent event) {
            if(event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    // получение ответа от порта
                  
                    String receivedData = serialPort.readString(event.getEventValue());
                   
                    System.out.println("Received response from port: " + receivedData);
           if(receivedData!=null)
           {
               jtextfield.setText(receivedData);
           }
               
                
     
                    
                    
                }
                       catch (SerialPortException ex) {
                    System.out.println("Error in receiving response from port: " + ex);
                }
            }
        }
    }
