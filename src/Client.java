/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amrzo
 */

import java.io.*;
import java.net.*;
public class Client implements Runnable{
    
    
    Socket socket;
    DataOutputStream dOut;
    DataInputStream dIn;
    BufferedReader bf;
    
    //these will hold the input coming from the user (sender/server), and the input recieved
    String inputToBeSent;
    String inputRecieved;
    
    //create a new thread
    Thread th;
    
    Ciphering convo;
    
    public Client() throws Exception{
        
        socket = new Socket("127.0.01", 3000);
        dOut = new DataOutputStream(socket.getOutputStream());
        dIn = new DataInputStream(socket.getInputStream());
        bf = new BufferedReader(new InputStreamReader(System.in));
       
        //when this line is read and executed, then an extra thread is going to start and will go to the run method blow, the program will then continue with the next line (the current thread).
        th = new Thread(this);
        th.start();
        
        convo = new Ciphering();
        //if there is any data coming from the server at any point, then print it 
        while (true) {
            
            inputRecieved = dIn.readUTF();
            
            System.out.println("Recieved: " + inputRecieved + "\nPlain text: " + convo.Decrypt(inputRecieved) + "\n" );
        }
        
    }
    
    public void run(){
        
        //if there is any data coming from the client (user/sender) at any time, then enrypt it and send it
        while (true){
            
            try {
            inputToBeSent = bf.readLine();
            dOut.writeUTF(convo.Encrypt(inputToBeSent));
            }
            catch (Exception e){
                System.out.println("Error with sending data from the client");
            }
        
        }
        
    }
    
    public static void main(String[] args){
        try {
        new Client();
        }
        catch (Exception e){
            System.out.println("Error with creating the client's side");
        }
    }
    
    
}
