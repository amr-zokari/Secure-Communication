/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amrzo
 */
public class Ciphering {
    
    //this metho will take in a string, encrypt it and then return back an encrypted string
    public String Encrypt(String text){
        
        
        char[] cArray = text.toCharArray();
        int tempNumber;
        char temp;
        String encryptedString = "";
        int shiftNum = 1;
        
        for (int i = 0; i < cArray.length; i++){
            
           // if (cArray[i] == ' ' || cArray[i] == '?' || cArray[i] == '.' || cArray[i] == ',' || cArray[i] == '!' || cArray[i] == '\'' || cArray[i] == '$' || cArray[i] == '%' || cArray[i] == '@') {
            if ((int) cArray[i] >= 32 && (int) cArray[i] <= 64){   
                encryptedString += cArray[i];
            }
            else {
                tempNumber = (int) cArray[i];
                
                if ((tempNumber + shiftNum) < 123){
                    temp = (char) (tempNumber + shiftNum);
                    //encryptedString += temp;
                }
                
                else {
                    tempNumber = tempNumber + shiftNum - 122; 
                    tempNumber = tempNumber + 96;
                    
                    temp = (char) tempNumber;
                    //encryptedString += temp;
                }
            encryptedString += temp;    
            }
        }

      return encryptedString;  
    }
    
    
    
    //this method will take in an encrypted string, decrypt it and then return the plain text.
    public String Decrypt(String text){
        
        char[] cArray = text.toCharArray();
        int tempNumber;
        char temp;
        String decryptedString = "";
        int shiftNum = 1;
        
        for (int i = 0; i < cArray.length; i++){
            
            //if (cArray[i] == ' ' || cArray[i] == '?' || cArray[i] == '.' || cArray[i] == ',' || cArray[i] == '!' || cArray[i] == '\'' || cArray[i] == '$' || cArray[i] == '%' || cArray[i] == '@') {
            if ((int) cArray[i] >= 32 && (int) cArray[i] <= 64){    
                decryptedString += cArray[i];
            }
            else {
                tempNumber = (int) cArray[i];
                
                if ((tempNumber - shiftNum) > 96){
                    temp = (char) (tempNumber - shiftNum);
                    //decryptedString += temp;
                }
                
                else {
                    tempNumber = tempNumber - shiftNum + 122; 
                    tempNumber = tempNumber - 96;
                    
                    temp = (char) tempNumber;
                    //decryptedString += temp;
                }
                decryptedString += temp;
            }
        }
      return decryptedString;  
    }
    
}
