/*
    Clase para la lectura de datos, tanto enteros como reales y ahora confirmaciones de lectura
*/

import java.io.*;
import java.lang.Character.*;

public class Leer{
    
    private int inputE;
    private double inputD;
    private char inputC;
    private String inputCad;
    private boolean error;
    
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
    //Se usa el IOException porque BufferedReader readLine() lanza o throws IOException
    
    //lectura de datos enteros
    public int DatosE() {
        do{
            try{
                error=false;
                inputE = Integer.parseInt(br.readLine());
                if((inputE < 0)){
                    System.out.println("Introduzca un dato valido");
                    error = true;
                }
            }  catch(IOException e){
                System.out.println(e);
                error = true;
            } catch(NumberFormatException er){
                System.out.println("Conversion erronea de datos, pruebe con valores numericos entero");
                error = true;
            }
        }while (error);
        
        return inputE;
    }
    //Lectura de Datos double
    public double DatosD(){
        do{
            try{
                error = false;
                inputD = Double.parseDouble(br.readLine());
               if(inputD < 0){
                    System.out.println("Introduzca un dato valido");
                    error = true;
                }
            }  catch(IOException e){
                System.out.println(e);
                error = true;
            } catch(NumberFormatException er){
                System.out.println("Conversion erronea de datos, pruebe con valores numericos entero");
            }
        }while (error);
        
        return inputD;
    }
    //Lectura de datos tipo cadena segun su funcion
    public String DatosCad(){
        do{
            try{
                error = false;
                System.out.println("Nombre del estudiante:");
                inputCad = br.readLine();
                for(int i=0; i < inputCad.length(); i++){
                    if(Character.isDigit(inputCad.toCharArray()[i])){
                        System.out.println("No puede ingresar un numero");
                        error = true;
                        break;
                    }
                }
            }
            catch(IOException e ){
                System.out.println(e);
                error = true;
            }
        }while (error);
        return inputCad;
    }
    public String DatosCadCedula(){
            //Separar segun '-' y limtar las entradas... Investtigar mas
       // boolean comprob = true, validar;
        
        do{
            try{
                error = false;
                System.out.println("Cedula del estudiante:");
                inputCad = br.readLine();
                
                /*for(int i=0; i < inputCad.length(); i++){
                    if((Character.isDigit(inputCad.toCharArray()[i]))&&(inputCad.toCharArray()[i]!='-')){
                        System.out.println("No puede ingresar letras ");
                        error = true;
                        break;
                    }
                }*/
            }
            catch(IOException e ){
                System.out.println(e);
                error = true;
            }
        }while(error);
        //separado = inputCad.split("-",3);
        return inputCad;
    }
    
}