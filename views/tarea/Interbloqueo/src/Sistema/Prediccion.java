/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.util.ArrayList;

/**
 *
 * @author RAFA
 */
public class Prediccion {
    String mensaje;
    int apuntsol;
    int apuntblock;
    int block = 0;
    int finalizado = 0;
    long tiempoA;
    long tiempoB;
    long tiempoTot;
    int procesos;

    public int getProcesos() {
        return procesos;
    }

    public void setProcesos(int procesos) {
        this.procesos = procesos;
    }
    
    
    public int getApuntsol() {
        return apuntsol;
    }

    public void setApuntsol(int apuntsol) {
        this.apuntsol = apuntsol;
    }

    public int getApuntblock() {
        return apuntblock;
    }

    public void setApuntblock(int apuntblock) {
        this.apuntblock = apuntblock;
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

    public void setTiempoTot(long tiempoTot) {
        this.tiempoTot = tiempoTot;
    }
    
    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }
    
    
    public void tiempo()
    {
        this.setTiempoB(System.currentTimeMillis());
        tiempoA = tiempoA - tiempoB - 1;
        tiempoTot = tiempoTot + tiempoTot;
    }
    
    public Prediccion() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public int getApuntSol() {
        return apuntsol;
    }

    public void setApuntSol(int apuntsol) {
        this.apuntsol = apuntsol;
    }
    
    public int getApuntBlock() {
        return apuntsol;
    }

    public void setApuntBlock(int apuntblock) {
        this.apuntblock = apuntblock;
    }
    
    
    public void Verificar ( Recurso resource[],  Recurso available[] , Recurso claim [][], Recurso alloc [][],  Recurso request[], int numProceso, int numrecurso,
    ArrayList<Recurso[]> bloqueado, ArrayList<Recurso[]> disp, int apuntsoli, int apuntbloq) {
        
        
        apuntblock= apuntbloq;
        apuntsol = apuntsoli;
        
        
        String proceso = request[0].getId();
        
        System.out.println(" Nombre del proceso guardado en variable proces: "+proceso);
        
        int flag = 0;
        
        
        
       
        for (int i = 0; i < numProceso; i++) {
            
            for (int j = 0; j < numrecurso; j++) {
                
                if(alloc[j][i].getId() == request[j].getId()){
                
                    if (alloc[j][i].getMax() + request[j].getMax() > claim [j][i].getMax()){
                flag=1;
                }
                
                }
            }
            if(flag==1){
            setMensaje("Error en cantidad de recursos.");
            System.out.println("error");
            break;    
            }
            
            
            
        }
        
        
        for (int i = 0; i < numrecurso; i++) {
            
            System.out.println(" primer if para suspender valor de la solicitud: "+ request[i].getMax());
            System.out.println(" valor de lo disponible: "+ available[i].getMax());
            
            if (request[i].getMax() > available[i].getMax()){
                flag=2;
            }
            if(flag==2){
                
                for (int j = 0; j < numrecurso; j++) {
                    request[j].setFlag(true);
                }
               
                for (int j = 0; j < numProceso; j++) {
                    
                    //Bloquear proceso
                    if(claim[0][j].getId() == request[0].getId()){
                    
                        for (int k = 0; k < numrecurso; k++) {
                            claim[k][j].setFlag(true);
                            alloc[k][j].setFlag(true);
                            
                        }
                    }
                    
                }
                
                disp.remove(apuntsol);
                apuntsol--;
                System.out.println(" valor despueste del set de apuntador a solicitud   "+ apuntsol);
                bloqueado.add(request);
                block++;
                apuntblock = apuntblock++;
                
                System.out.println(" apuntador a la lista de solicitudes: "+ apuntsol +" ----------------- ");
                System.out.println(" apuntador a la lista de bloqueados: "+ apuntblock +" ----------------- ");


                setMensaje("Proceso bloqueado, recursos insuficientes.");
                System.out.println("suspendido");
                break;
            }
        }
           
            
             if(flag==0){
                
                 
                 
                 //SE LLAMA AL ALGORTMO DE PREDICCION  
                tiempo();
                boolean aux = Prediccion(available, alloc, numProceso, numrecurso, claim);     
                
                
                
                //ESTA SAVE
                if(aux == true){
                int cont2 = 0;    
                
 
                 for (int j = 0; j < numProceso; j++) {
                     
                     for (int i = 0; i < numrecurso; i++) {
                         
                         System.out.println(" id del request: "+request[0].getId() );    
                         System.out.println("id del alloc: "+ alloc[i][j].getId() );
                         
                     if(request[0].getId() == alloc[i][j].getId()){
                     
                     alloc[i][j].setMax(alloc[i][j].getMax() + request[i].getMax());
                     available[i].setMax(available[i].getMax() - request[i].getMax());
                         
                         
                         System.out.println(" claim de comprobacion ---- : "+ claim[i][j].getMax());
                         System.out.println(" alloc de comprobacion ---- : "+ alloc[i][j].getMax());
                     
                     if(alloc[i][j].getMax() == claim[i][j].getMax()){
                          cont2++;
                            
                       }
    
                     }
                 }
                     setMensaje("Solicitud exitosa."); 
                     
                 
                    System.out.println(" Numero de recursos para salir: "+ cont2 +" ////////////////////////////////");                    
                    System.out.println(" Numero de recursos: "+ numrecurso +" ////////////////////////////////");

                    
                  //El proceso cumple con el maximo de recursos demandados.   

                 if( cont2 == numrecurso ){
                     setMensaje("Proceso finalizado");
                     finalizado++;
                     procesos--;
                     for (int i = 0; i < numProceso; i++) {
                         for (int k = 0; k < numrecurso; k++) {
                             
                             if(alloc[k][i].getId() == request[k].getId()){
                                 System.out.println(" valor del disponible antes de liberar: "+available[k].getMax() );
                                 System.out.println(" claim antes de liberar : "+ alloc[k][i].getMax() );

                             available[k].setMax( available[k].getMax() + alloc[k][i].getMax());
                             
                             System.out.println(" valor nuevo de disponible al liberar recursos: "+ available[k].getMax());
                             alloc[k][i].setMax(0);
                             alloc[k][i].setFlag(true);
                             claim[k][i].setMax(0);
                             claim[k][i].setFlag(true);
                             
                                     }
                             
                         }
                     }
                     
                     
                    for (int i = 0; i < bloqueado.size(); i++) {
                        
                        Recurso recaux[] = bloqueado.get(i);
                        int cont = 0;
                        
                        for (int k = 0; k < numrecurso; k++) {
                            if (recaux[k].getMax() <= available[k].getMax()){
                                cont++;
                            }    
                        }
                        
                        System.out.println(" Numero de recursos que cumplem solicitud: "+cont+ " ------- numero de recursos -------"+ numrecurso);
                        
                        if(cont == numrecurso){
                            
                            
                              
                            for (int k = 0; k < numProceso; k++) {
                    
                                
                                  for (int z = 0; z < numrecurso; z++) {
                                       if(claim[0][k].getId() == recaux[0].getId()){ 
                                        claim[z][k].setFlag(false);
                                        alloc[z][k].setFlag(false);
                                        
                                        } 
                                    }
                              }
                                    setMensaje("Se desbloqueo proceso "+recaux[0].getId());
                                    System.out.println("Se desbloqueo proceso "+recaux[0].getId());
                                    
                                    
                                     System.out.println(" apuntador a la lista de bloqueados: "+ this.apuntblock +" ------------------  ");
                                     apuntblock = apuntblock - 1;
                                     System.out.println(" apuntador a la lista de bloqueados: "+ this.apuntblock +" ------------------  ");
                                     bloqueado.remove(apuntblock);
                                     block--;
                                     apuntsol = apuntsol + 1;
                                     System.out.println(" valor en el caso safe del apuntador a solicitud   "+ apuntsol);
                                     disp.add(recaux);
                    
                   }
                        
            }
        }
                 
                 
                  }
                 
                 System.out.println("safe");
                
                
                }
                else{
                    tiempo();
                    for (int i = 0; i < numrecurso; i++) {
                        
                        System.out.println("  --- "+available[i].getMax());
                        
                    }
                    
                    System.out.println(" ");
                     System.out.println("unsafe");
              
               
               System.out.println(" valor inicial del apuntador a solicitud   "+ apuntsol);
               
               disp.remove(apuntsol);
               apuntsol = apuntsol - 1; 
               System.out.println(" valor despues de set al apuntador a solicitud   "+ apuntsol);
              
                bloqueado.add(request);
                block++;
                apuntblock = apuntblock + 1;
                
                System.out.println(" apuntador a la lista de solicitudes: "+ apuntsol +" ----------------- ");
                System.out.println(" apuntador a la lista de bloqueados: "+ apuntblock +" ----------------- ");

                
                for (int j = 0; j < numProceso; j++) {
                    
                    if(claim[0][j].getId() == request[0].getId()){
                    
                        for (int k = 0; k < numrecurso; k++) {
                            claim[k][j].setFlag(true);
                            alloc[k][j].setFlag(true);
                            
                        }
                    }
                }
                
                setMensaje("Proceso bloqueado");
                 System.out.println("bloqueado");
                
                 
                    for (int j = 0; j < numProceso; j++) {
                     
                     for (int i = 0; i < numrecurso; i++) {
                         
                     if(request[0].getId() == alloc[i][j].getId()){
                     
                     alloc[i][j].setMax(alloc[i][j].getMax() - request[i].getMax());
                     available[i].setMax(available[i].getMax() + request[i].getMax());
                         
                      
                         }
                     }
                      
                 }
                    
                    for (int i = 0; i < numrecurso; i++) {
                        
                        System.out.println("  --- al finalizar el unsafe disponible : "+available[i].getMax() +" recurso: "+ i);
                        
                    }
                    
                    for (int j = 0; j < numProceso; j++) {
                         
                         for (int k = 0; k < numrecurso ; k++) {
                             System.out.println(" allocation: "+ alloc[k][j].getMax() );
                         }
                         System.out.println(" ");
                     }
                 
                    
                
                }
            }
                             
    }
    
    public boolean Prediccion(Recurso available[], Recurso alloc[][], int numProceso, int numRecurso, Recurso claim[][] ){
        
        int auxalloc[][] = new int[1000][1000];
        int currentavail[] = new int[1000];
        int claimsimul[][] = new int [1000][1000]; 
        
        boolean safe = false;
         // CREACION DE MATRICES Y VECTORES AUXILIARES PARA SIMULACION
         
        for (int i = 0; i < numRecurso-1; i++) {
            currentavail[i] = available[i].getMax();
        }
        
        for (int i = 0; i < numProceso; i++) {               
            
            
                
            for (int j = 0; j < numRecurso-1; j++) {
                
                 auxalloc[j][i] = alloc[j][i].getMax();
                    
            }
            
        }
        
        for (int i = 0; i < numProceso; i++) {               
                
            for (int j = 0; j < numRecurso-1; j++) {
                
                 auxalloc[j][i] = claim[j][i].getMax();
                    
            }
            
        }
        
        
        
        int simulacion[][] = new int [1000][1000];
        // calculo de c - a
            for (int j = 0; j < numProceso; j++) {
                
                
                 System.out.println(" fila "+j+" :  ");
                 for (int i = 0; i < numRecurso; i++) {
               
                simulacion[i][j] = claimsimul[i][j] - auxalloc[i][j];
                System.out.print(" valor de C-A en la simulacion :    "+simulacion[i][j]);
                
                
            }
            }
            
        boolean possible = true;
        int concero = 0;
        int contsimul = 0;
        int multi=0;
        while(possible==true){
         /*rest=0;*/
         
         int compr= 0;
         
            for (int i = 0; i < numProceso; i++) {
                for (int j = 0; j < numRecurso; j++) {
                    for (int k = 0; k < numRecurso; k++) {
                        
                        if(simulacion[k][i] != 0) concero=1;
                    }
                    
                    if(concero == 1){
                    
                        if(simulacion[j][i] <= currentavail[j] ){
                        contsimul++;
                        }
                        if(contsimul == numRecurso){
                        compr++;
                            for (int k = 0; k < numRecurso; k++) {
                             simulacion[k][i]=0;
                             currentavail[k] = currentavail[k]+auxalloc[k][i]; 
                            }
                        }
                    }
                    
                    
                    
                    
                }
                contsimul = 0;
                concero=0;
            }
         
         if(compr == 0){
         possible = false; }
         }
        
        
         multi = numProceso* numRecurso; 
         int contC = 0;
            for (int i = 0; i < numProceso; i++) {
                for (int j = 0; j < numRecurso; j++) {
                    
                    if(simulacion[j][i] == 0 ){
                    contC++;
                    }
                    
                    
                }
            }
         
            
         if(contC== multi){
         
             safe=true;
         }    
                  
                
        return safe;
        
        
     
    }
    
    
    
        
    
}
