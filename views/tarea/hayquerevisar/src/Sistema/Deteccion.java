
package Sistema;

public class Deteccion {

    String mensaje;
    
    public Deteccion() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    
    
    public void deteccion( Recurso claim[][], Recurso available[], Recurso alloc[][], Recurso request[], int Nrecursos, int Nprocesos){
        
        int claimS[][] = new int[1000][1000];
        int availS[] = new int[1000];
        int allocS[][] = new int[1000][1000];
        int simul[][] = new int[1000][1000];
        boolean possible = true;
        int cont1 = 0;
        int cont2 = 0;
        
        
        for (int i = 0; i < Nprocesos; i++) {
                for (int j = 0; j < Nrecursos; j++) {
                alloc[j][i].setMarcadetec(false);
                
                allocS[j][i] = alloc[j][i].getMax();
                claimS[j][i] = claim[j][i].getMax();
                availS[j] = available[j].getMax();
            }
        }
        
        for (int i = 0; i < Nprocesos; i++) {
            if(request[0].getId() == alloc[0][i].getId())
            for (int j = 0; j < Nrecursos; j++) {
                alloc[j][i].setMax(alloc[j][i].getMax()+request[j].getMax() );
                available[j].setMax(available[j].getMax()- request[j].getMax());
            }
            
        }
        
        int contR;
        for (int i = 0; i < Nprocesos; i++) {
            contR=0;
            if(request[0].getId() == alloc[0][i].getId()){
            for (int j = 0; j < 10; j++) {
                if(claimS[j][i] == allocS[j][i]){
                    contR++;
                }
                
              }
            if(contR == Nrecursos){
                System.out.println("finalizara proceso: "+ alloc[0][i].getId());
                for (int j = 0; j < Nrecursos; j++) {
                    
                    available[j].setMax(available[j].getMax()+ allocS[j][i]); 
                    claim[j][i].setMax(0);
                    alloc[j][i].setMax(0);
                    claim[j][i].setId("null");                    
                    alloc[j][i].setId("null");
                    allocS[j][i]= 0;
                    claimS[j][i]= 0;
                }
            }
            
            
            }
            
        }
        
        for (int i = 0; i < Nprocesos; i++) {
            for (int j = 0; j < Nrecursos; j++) {
                simul[j][i] = claimS[j][i] - allocS[j][i];
                System.out.println("colocando los valores de c-a: "+ simul[j][i]);
            }
        }
        
        
        int conta;
        for (int i = 0; i < Nprocesos; i++) {
            conta=0;
            
            
            for (int j = 0; j < Nrecursos; j++) {
                if(allocS[j][i]==0){
                conta++;
                }
            }
            
            if(conta == Nrecursos){
                for (int j = 0; j < Nrecursos; j++) {
                    alloc[j][i].setMarcadetec(true);
                }
            }
            else{
                for (int j = 0; j < Nrecursos; j++) {
                 alloc[j][i].setMarcadetec(false);
                }
            }
            
        }
        int w[] = new int [1000];
        for (int i = 0; i < Nrecursos; i++) {
            w[i] = available[i].getMax();
        }
                
        while(possible){
            
        int encontrar = 0 ;
        
            for (int i = 0; i < Nprocesos; i++) {
                cont1=0;
                
                for (int j = 0; j < Nrecursos; j++) {
                    if(w[j] >= simul[j][i] && alloc[j][i].isMarcadetec() == false){
                    cont1++;
                    }
                    
                    if(cont1 == Nrecursos){
                    encontrar++;
                        for (int k = 0; k < Nrecursos; k++) {
                        alloc[k][i].setMarcadetec(true);
                        available[k].setMax(available[k].getMax()+ allocS[k][i]); 
                        claim[k][i].setMax(0);
                        alloc[k][i].setMax(0);
                        claim[k][i].setId("null");                    
                        alloc[k][i].setId("null");
                        allocS[k][i]= 0;
                        claimS[k][i]= 0;
                       }
                    }
                
                    
                        
                }
                
            }
        if(encontrar==0){
            possible = false;
        
        }
        }
        
        
        
        for (int k = 0; k < Nprocesos; k++) {
            for (int l = 0; l < Nrecursos; l++) {
                
            if (alloc[l][k].isMarcadetec() == false) 
            {
              available[l].setMax(available[l].getMax() + alloc[l][k].getMax()); 
              claim[l][k].setMax(0); 
              alloc[l][k].setMax(0); 
              System.out.println(" se elimino el proceso: "+ alloc[l][k].getId());
            }
            else{
            
                System.out.println(" proceso : "+ alloc[l][k].getId()+ " continua en ejecucion");
            
            }
            
            }
        }
        
        /*
        
        
        
        
        
        
        
        
        
        
        
        
        
        System.out.println("nnumero de procesos en sistema: "+ Nprocesos);
        System.out.println("nnumero de recursos en sistema: "+ Nrecursos);
        
        // auxiliares de las 3 matrices
        
        
       
        int y = Nprocesos;
        int x = Nrecursos;
        int cont0;
        
        
        for (int i = 0; i < y; i++) {
        cont0=0;
        
            for (int j = 0; j < x; j++) {
                if(allocS[j][i] == 0){
                    cont0++;
                }
            }
            System.out.println("cont 0 :"+ cont0);
            System.out.println("Nrecursos:"+ Nrecursos );
            if(cont0 == Nrecursos && alloc[0][i].isFlag() == false){
                for (int j = 0; j < y-1; j++) {
                    alloc[j][i].setMarcadetec(true);
                    System.out.println(alloc[j][i].isMarcadetec());
                }
        
            }
        }
        
        
        
        int contP=0;
        
        for (int i = 0; i < y; i++) {
         
         if( alloc[0][i].isMarcadetec()== false){
             
             
             int cont = Nrecursos;
             
             for (int j = 0; j < x; j++) {
                 
                 System.out.println("valor de c-a en comprobacion: "+simul[j][i]);
                 System.out.println("valor disponible de recurso: "+w[j]);
              
                 if(simul[j][i]<= w[j]){
                 cont--;
                }
             }
             
             
             if(cont==0){
                 for (int j = 0; j < Nrecursos; j++) {
                     alloc[j][i].setMarcadetec(true);
                    
                     w[j] = w[j]+ allocS[j][i];
                     System.out.println("valor de currect available: "+w[j]);
                 }
             }
         }
            
         else if (alloc[0][i].isMarcadetec() == true){
         contP++;
             System.out.println(" proceso marcado: "+ contP);
             if(contP==Nprocesos){
                  break;
                              }
            }
        }
        
        
        for (int i = 0; i < y; i++) {
         
         if(alloc[0][i].isMarcadetec()==false ){
             
             this.setMensaje("El proceso "+alloc[0][i].getId()+ ",  termino por deteccion de interbloqueo."+"\n");   
             System.out.println("El proceso "+alloc[0][i].getId()+ ",  termino por deteccion de interbloqueo." );
             
             
             for (int j = 0; j < Nrecursos; j++) {
                     available[j].setMax( available[j].getMax()+ alloc[j][i].getMax());
                     System.out.println(" nuevo disponible depues de liberar: "+ available[j]);
                     alloc[j][i].setMax(0);
                     alloc[j][i].setId("null");
                     alloc[j][i].setFlag(true);
                     
                     claim[j][i].setId("null");
                     claim[j][i].setMax(0);
                     claim[j][i].setFlag(true);
                     
                 }
            
            }
         else {
             setMensaje("El proceso "+alloc[0][i].getId()+" no esta interbloqueado." +"\n");
             System.out.println("El proceso "+alloc[0][i].getId()+" no esta interbloqueado.");
         }
         
        }    */
}
    
   
    
}