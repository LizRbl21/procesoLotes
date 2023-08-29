/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulaciondelotes;


/**
 *
 * @author roble
 */
public class GeneradorLote { 
    
    
    public void generarProceso(int numProcesos, int NumLote){
        
        for(int i=0;i<numProcesos; i++){
            Programador newProgramador = new Programador();
            newProgramador.generarProgramador();
            listaProgramadores.agregar(newProgramador);
        }
        dividirLotes(NumLote);
        //listaProgramadores.showLista();
    }
    
    public void dividirLotes(int NumLote){
        
        numLote = NumLote;
        for(int i=0; i<listaProgramadores.getTamanio();i++){
            if(i==0 || i%5==0){
                numLote++;
                System.out.println("Lote " + numLote);
                System.out.println("*****************************"); 
                cantLote++;
             }
            //System.out.println("mua");
            Programador tempProgramador = (Programador) listaProgramadores.getObjeto(i);
            tempProgramador.showProgramador();
            realizarOperacion(tempProgramador);
        }
        
    }
    
    public void realizarOperacion(Programador tempProgramador){
        
        double Resultado=0;
        Operacion tempOperacion = tempProgramador.getOperacion();
        String operadorTemp = tempOperacion.getOperacion();
        double num1Temp = tempOperacion.getNum1();
        double num2Temp = tempOperacion.getNum2();
        switch(operadorTemp){
            case "+" -> Resultado = num1Temp + num2Temp;
            case "-" -> Resultado = num1Temp - num2Temp;
            case "*" -> Resultado = num1Temp * num2Temp;
            case "/" -> Resultado = num1Temp / num2Temp;
         }
        tempOperacion.setResultado(Resultado);
        System.out.println("Resultado = "+ Resultado);
        System.out.println("_________________________");
         
    }

    
    public int getNumLote(){
        return this.numLote;
    }
    
    public int getTamanioList(){
        return listaProgramadores.getTamanio();
    }
    
    public Lista getLista(){
        return this.listaProgramadores;
    }
    
    public int getCantLote(){
        return this.cantLote;
    }
    
    private int cantLote=0;
    private int numLote;
    private Lista listaProgramadores = new Lista();
 
}
