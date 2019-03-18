/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 * @author edwin
 * @author gabriel
 */
public class ARP {
    private byte [] tipoH; //tipo de hardware
    private byte [] tipoP; //tipo de protocolo
    private byte longitudH; //longitud d ela direccion de hardware(MAC)
    private byte longitudP; //longitud de las direcciones utilizadas en el protocolo de capa superior, como es ipv4 seria 4
    private byte [] operacion;// codigo de operación, determina si se va a hacer un request o replay
    private byte [] macO;//direccion mac origen 
    private byte [] ipO;//direccion ip origen
    private byte [] macD;//direccion mac destino 
    private byte [] ipD;//direccion ip destino
    private byte tramaARP[];//trama Ethernet cuyo paylouder es una trama ARP

    public ARP(byte[] ipO,byte[] macO,byte[] ipD){
        tipoH = new byte[2];
        tipoH[0]=0;
        tipoH[1]=1;
        tipoP = new byte[2];
        tipoP[0]=8;
        tipoP[1]=0;
        longitudH=6;
        longitudP=4;
        operacion = new byte[2];
        operacion[0]=0;
        operacion[1]=1;
        this.macO = new byte[6];
        for(int i=0;i<6;i++){
            this.macO[i]=macO[i];
        }
        this.ipO = new byte[4];
        for(int i=0;i<4;i++){
            this.ipO[i]=ipO[i];
        }
        macD = new byte[6];
        for (int i=0;i<6;i++){
            macD[i]=(byte) 255;
        }
        this.ipD = new byte[4];
        for(int i=0;i<4;i++){
            this.ipD[i]=ipD[i];
        }
    }
    
    
    public byte[] creadorTrama(){
        int i=0;
        byte [] trama=new byte[60];
        
        for(byte b:macD){
            trama[i]=b;
            i++;
        }
        
        for(byte b:macO){
            trama[i]=b;
            i++;
        }
        
        trama[i]=8;
        i++;
        trama[i]=6;
        i++;
        
        for(byte b:tipoH){
            trama[i]=b;
            i++;
        }
        
        for(byte b:tipoP){
            trama[i]=b;
            i++;
        }
        
        trama[i]=longitudH;
        i++;
        trama[i]=longitudP;
        i++;
        
        for(byte b:operacion){
            trama[i]=b;
            i++;
        }
        
        for(byte b:macO){
            trama[i]=b;
            i++;
        }
        
        for(byte b:ipO){
            trama[i]=b;
            i++;
        }
        
        for(byte b:macD){
            trama[i]=b;
            i++;
        }
        
        for(byte b:ipD){
            trama[i]=b;
            i++;
        }
        /*
        for (i=0;i<6;i++){
            trama[i]=(byte) 255;
        }
        trama[6]=(byte)244;
        trama[7]=(byte) 142;
        trama[8]=(byte) 38;
        trama[9]=(byte) 243;
        trama[10]=(byte) 57;
        trama[11]=(byte) 16;
        
        trama[12]=8;
        trama[13]=6;
        
        trama[14]=0;
        trama[15]=1;
        
        trama[16]=8;
        trama[17]=0;
        
        trama[18]=6;
        trama[19]=4;
        
        trama[20]=0;
        trama[21]=1;
        
        trama[22]=(byte)244;
        trama[23]=(byte) 142;
        trama[24]=(byte) 38;
        trama[25]=(byte) 243;
        trama[26]=(byte) 57;
        trama[27]=(byte) 16;
        
        trama[28]=(byte) 192;
        trama[29]=(byte) 168;
        trama[30]=(byte) 1;
        trama[31]=(byte) 2;
        
        for (i=32;i<38;i++){
            trama[i]=(byte) 255;
        }  
        
        trama[38]=(byte) 192;
        trama[39]=(byte) 168;
        trama[40]=(byte) 1;
        trama[41]=(byte) 1;
        
        for (i=42;i<60;i++){
            trama[i]=(byte) 0;
        } 
        */
        return trama;
    }
    
}
