
package Sistema;

public class Deteccion {

    String mensaje;
    int eliminado = 0;
    int block = 0;
    int procesos = 0;
    long tiempoA;
    long tiempoB;
    long tiempoTot;
    int solicitudes = 0;

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    
    public long getTiempoA() {
        return tiempoA;
    }

    public void setTiempoA(long tiempoA) {
        this.tiempoA = tiempoA;
    }

    public long getTiempoB() {
        return tiempoB;
    }

    public void setTiempoB(long tiempoB) {
        this.tiempoB = tiempoB;
    }

    public long getTiempoTot() {
        return tiempoTot;
    }

    public void tiempo()
    {
        this.setTiempoB(System.currentTimeMillis());
        tiempoA = tiempoA - tiempoB - 1;
        tiempoTot = tiempoTot + tiempoTot;
    }
    
    public void setTiempoTot(long tiempoTot) {
        this.tiempoTot = tiempoTot;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

    public int getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(int solicitudes) {
        this.solicitudes = solicitudes;
    }



    public int getProcesos() {
        return procesos;
    }

    public void setProcesos(int procesos) {
        this.procesos = procesos;
    } 
    
    
    public Deteccion() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public void deteccion( Recurso claim[][], Recurso available[], Recurso alloc[][], int Nrecursos, int Nprocesos){
    
       // , int x , int y, int cantRec
        
        
        System.out.println("nnumero de procesos en sistema: "+ Nprocesos);
        System.out.println("nnumero de recursos en sistema: "+ Nrecursos);

        
        for (int i = 0; i < Nprocesos; i++) {
                for (int j = 0; j < Nrecursos; j++) {
                alloc[j][i].setMarcadetec(false);
                    System.out.println("proceso numero"+ i + "esta en: "+ alloc[j][i].isMarcadetec());
                
            }
        }
        
         int y = Nprocesos;
         int x = Nrecursos;
        int cont0;
        Recurso aux[][] = new Recurso[1000][1000];
        Recurso req[][] = new Recurso[1000][1000];
        int auxreq[][] = new int[1000][1000];
        
        
        int w[] = new int[1000];
        aux = alloc;
       /*
        req = request;        
       */
        for (int i = 0; i < Nrecursos; i++) {
             w[i] = available[i].getMax();
        }
        
        
        for (int i = 0; i < Nprocesos; i++) {
            
            for (int j = 0; j < Nrecursos-1; j++) {
                if(aux[j][i].isFlag() == false){
                auxreq[j][i] = req[j][i].getMax()-aux[j][i].getMax();
                System.out.println("");
                System.out.println("colocando los valores de c-a: "+ auxreq[j][i]);
                
                }
            }
            
        }
        
       
        
        for (int i = 0; i < y; i++) {
        cont0=0;
        
            for (int j = 0; j < x; j++) {
                if(aux[j][i].getMax() == 0){
                    cont0++;
                }
            }
            
            System.out.println("cont 0 :"+ cont0);
            System.out.println("Nrecursos:"+ Nrecursos );
            if(cont0 == Nrecursos && aux[0][i].isFlag() == false){
                for (int j = 0; j < y-1; j++) {
                    aux[j][i].setMarcadetec(true);
                    System.out.println(aux[j][i].isMarcadetec());
                }
        
            }
       
        }
        
        
        
        int contP=0;
        
        for (int i = 0; i < y; i++) {
         
            
         if( aux[0][i].isMarcadetec()== false && aux[0][i].isFlag() == false ){
             int cont = Nrecursos;
             
             for (int j = 0; j < Nrecursos; j++) {
                 
                 System.out.println("valor de c-a en comprobacion: "+auxreq[j][i]);
                 System.out.println("valor disponible de recurso: "+w[j]);
              
                 if(auxreq[j][i]<= w[j]){
              cont--;
              }
             }
             
             
             if(cont==0){
                 for (int j = 0; j < Nrecursos; j++) {
                     aux[j][i].setMarcadetec(true);
                    
                     w[j] = w[j]+ aux[j][i].getMax();
                     System.out.println("valor de currect available: "+w[j]);
                 }
             }
             
         }
            
         else if (aux[0][i].isMarcadetec() == true && aux[0][i].isFlag() == false){
         contP++;
             System.out.println(" proceso marcado: "+ contP);
         if(contP==Nprocesos){
                  break;
                              }
         }
         
        }
        
    tiempo();    
        for (int i = 0; i < y; i++) {
         
         if(aux[0][i].isMarcadetec()==false && aux[0][i].isFlag() == false){
             
                this.setMensaje("El proceso "+aux[0][i].getId()+ ",  termino por deteccion de interbloqueo."+"\n");
                procesos--;
                eliminado++;
             System.out.println("El proceso "+aux[0][i].getId()+ ",  termino por deteccion de interbloqueo." );
             for (int j = 0; j < Nrecursos; j++) {
                     available[j].setMax(available[j].getMax()+ aux[j][i].getMax());
                     aux[j][i].setMax(0);
                     aux[j][i].setId("null");
                     aux[j][i].setFlag(true);
                     
                     req[j][i].setId("null");
                     req[j][i].setMax(0);
                     req[j][i].setFlag(true);
                     
                 }
            
            }
         else if( aux[0][i].isFlag()== false && aux[0][i].isMarcadetec() == true ){
             setMensaje("El proceso  no esta interbloqueado." +"\n");
             System.out.println("El proceso no esta interbloqueado.");
         }
         
        }   
}
    
    
    
}