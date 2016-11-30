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
public class Sistema {
    private Recurso recDisponibles[] = new Recurso[1000];
    private Recurso recDisponiblesD[] = new Recurso[1000];
    
    private Recurso recTotal[] = new Recurso[1000];
    int numProcesos =0;
    int numProcesosD =0;
    
    private Prediccion p1 = new Prediccion();
    private Deteccion d1 = new Deteccion();
    
    
    
    private Recurso recNecesarios [][] = new Recurso [1000][1000];
    private Recurso recAsignados [][] = new Recurso [1000][1000];
    
    private Recurso recNecesariosD [][] = new Recurso [1000][1000];
    private Recurso recAsignadosD [][] = new Recurso [1000][1000];
    
    
    
    private ArrayList<Recurso[]> solicitudesRechazadas = new ArrayList();
    private ArrayList<Recurso[]> solicitudes = new ArrayList();
    private ArrayList<Recurso[]> solicitudesD = new ArrayList();
   
    private int apuntSolicitudes = 0;
    private int apuntSolicitudesD = 0;
    
    private int apuntSolicitudesb = -1;
    
    
    //numero de recursos maximos

    public int getApuntSolicitudesb() {
        return apuntSolicitudesb;
    }

    public void setApuntSolicitudesb(int apuntSolicitudesb) {
        this.apuntSolicitudesb = apuntSolicitudesb;
    }
    
    
    private int xrecTotal = 0;
    
    
    private int xrecNecesarios = 0;
    private int yrecNecesarios = 0;
    
    private int xrecNecesariosD = 0;
    private int yrecNecesariosD = 0;

    public ArrayList<Recurso[]> getSolicitudesRechazadas() {
        return solicitudesRechazadas;
    }

    public void setSolicitudesRechazadas(ArrayList<Recurso[]> solicitudesRechazadas) {
        this.solicitudesRechazadas = solicitudesRechazadas;
    }
    
    
    
        public String getmensajed()
    {
         return d1.getMensaje();
    }
        
    public String getmensajep()
    {
         return p1.getMensaje();
    }
     

    public Recurso[] getRecDisponiblesD() {
        return recDisponiblesD;
    }

    public void setRecDisponiblesD(Recurso[] recDisponiblesD) {
        this.recDisponiblesD = recDisponiblesD;
    }

    public int getNumProcesosD() {
        return numProcesosD;
    }

    public void setNumProcesosD(int numProcesosD) {
        this.numProcesosD = numProcesosD;
    }

    public Recurso[][] getRecNecesariosD() {
        return recNecesariosD;
    }

    public void setRecNecesariosD(Recurso[][] recNecesariosD) {
        this.recNecesariosD = recNecesariosD;
    }

    public Recurso[][] getRecAsignadosD() {
        return recAsignadosD;
    }

    public void setRecAsignadosD(Recurso[][] recAsignadosD) {
        this.recAsignadosD = recAsignadosD;
    }

    public ArrayList<Recurso[]> getSolicitudesD() {
        return solicitudesD;
    }

    public void setSolicitudesD(ArrayList<Recurso[]> solicitudesD) {
        this.solicitudesD = solicitudesD;
    }

    public int getApuntSolicitudesD() {
        return apuntSolicitudesD;
    }

    public void setApuntSolicitudesD(int apuntSolicitudesD) {
        this.apuntSolicitudesD = apuntSolicitudesD;
    }

    public int getXrecNecesariosD() {
        return xrecNecesariosD;
    }

    public void setXrecNecesariosD(int xrecNecesariosD) {
        this.xrecNecesariosD = xrecNecesariosD;
    }

    public int getYrecNecesariosD() {
        return yrecNecesariosD;
    }

    public void setYrecNecesariosD(int yrecNecesariosD) {
        this.yrecNecesariosD = yrecNecesariosD;
    }

    public int getNumProcesos() {
        return numProcesos;
    }

    public void setNumProcesos(int numProcesos) {
        this.numProcesos = numProcesos;
    }

    
    public Recurso[] getRecDisponibles() {
        return recDisponibles;
    }

    public void setRecDisponibles(Recurso[] recDisponibles) {
        this.recDisponibles = recDisponibles;
    }
    
    
    public ArrayList<Recurso[]> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Recurso[]> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public int getApuntSolicitudes() {
        return apuntSolicitudes;
    }

    public Prediccion getP1() {
        return p1;
    }

    public void setP1(Prediccion p1) {
        this.p1 = p1;
    }
    

    public void setApuntSolicitudes(int apuntSolicitudes) {
        this.apuntSolicitudes = apuntSolicitudes;
    }

       
    public int getXrecNecesarios() {
        return xrecNecesarios;
    }

    public void setXrecNecesarios(int xrecNecesarios) {
        this.xrecNecesarios = xrecNecesarios;
    }

    public int getYrecNecesarios() {
        return yrecNecesarios;
    }

    public void setYrecNecesarios(int yrecNecesarios) {
        this.yrecNecesarios = yrecNecesarios;
    }
    

    public int getXrecTotal() {
        return xrecTotal;
    }

    public void setXrecTotal(int xrecTotal) {
        this.xrecTotal = xrecTotal;
    }

    public Recurso[] getRecTotal() {
        return recTotal;
    }

    public void setRecTotal(Recurso[] recTotal) {
        this.recTotal = recTotal;
    }

    public Recurso[][] getRecNecesarios() {
        return recNecesarios;
    }

    public void setRecNecesarios(Recurso[][] recNecesarios) {
        this.recNecesarios = recNecesarios;
    }

    public Recurso[][] getRecAsignados() {
        return recAsignados;
    }

    public void setRecAsignados(Recurso[][] recAsignados) {
        this.recAsignados = recAsignados;
    }
    
    
    
    
    
    public void llenarRecTotal (Recurso r, int x){
        recTotal[x] = r;         
    }
    
    
    
    public void llenarMatriz (String idP){
        
        for (int i = 0; i < xrecTotal; i++) {
            
            Recurso r = new Recurso(recTotal[i].getNombre(), 0, i, yrecNecesarios, idP);
            Recurso r2 = new Recurso(recTotal[i].getNombre(), 0, i, yrecNecesarios, idP);
            
            Recurso rD = new Recurso(recTotal[i].getNombre(), 0, i, yrecNecesariosD, idP,false);
            Recurso r2D = new Recurso(recTotal[i].getNombre(), 0, i, yrecNecesariosD, idP,false);
            
            
            recNecesarios[i][yrecNecesarios] = r;
            recAsignados[i][yrecNecesarios] = r2;
            
            
            recNecesariosD[i][yrecNecesarios] = rD;
            recAsignadosD[i][yrecNecesarios] = r2D;
            
        }
        
    }
    
    public void vecRequest (String idP){
    
        Recurso aux[] = new Recurso[1000];
        Recurso auxD[] = new Recurso[1000];
        
    for (int i = 0; i < xrecTotal; i++) {
            System.out.println(" nombre del proceso que creo la solicitud: "+ idP+ " ////////////////////////// ");
            Recurso r = new Recurso(recTotal[i].getNombre(),idP, 0, i);
            Recurso rD = new Recurso(recTotal[i].getNombre(),idP, 0, i);
            
            r.setApuntSolicitud(apuntSolicitudes);
            rD.setApuntSolicitud(apuntSolicitudesD);
            aux[i] = r;
            auxD[i] = rD;
            
        }
    
        this.solicitudes.add(aux);
        System.out.println(" apuntador de las solicitudes al crear el vecrequest :  "+apuntSolicitudes );
        this.solicitudesD.add(auxD);
    
    }
    
    public void llenarRequest (String r, int x, int y){
        
        
        
        Recurso aux[] = this.solicitudes.get(this.apuntSolicitudes);
        System.out.println("apuntador para la detecciona al crear recursos: -------------------"+ apuntSolicitudes);
        
        
        for (int i = 0; i < xrecTotal; i++) {
            
            if (r == aux[i].getNombre()){
                aux[i].setMax(x);
                
            }

        }
        
        for (int i = 0; i < xrecTotal; i++) {
             if(r == aux[i].getNombre()){
                aux[i].setMax(x);
                for (int j = 0; j < this.yrecNecesarios; j++) {
                        
                    if (this.recAsignados[0][j].getId() == aux[0].getId()) {
                        System.out.println("Y al llenar la solicitud: "+recAsignados[0][j].getY());
                        System.out.println("blabla valor de y:   "+y);
                        for (int k = 0; k < xrecTotal; k++) {
                        aux[k].setY(y);
                            System.out.println(" posicion y del nodo de request: "+ aux[k].getY());
                        }
                    }
                    
                }
                
            }
        }
    }
    
    
    public void llenarRecNecesarios (String r, int x) {
        
        for (int i = 0; i < xrecTotal; i++) {
            
            if (r == recNecesarios[i][yrecNecesarios].getNombre()){
                
                recNecesarios[i][yrecNecesarios].setMax(x);
                
                System.out.println(" valor de alloc "+recAsignados[i][yrecNecesarios].getMax());
            }

            if (r == recNecesariosD[i][yrecNecesariosD].getNombre()){
                
                recNecesariosD[i][yrecNecesariosD].setMax(x);
                
                System.out.println(" valor de alloc "+recAsignadosD[i][yrecNecesariosD].getMax());
            }


            
        }
        
        
    }
    
    
    
    public void imprimirvectotal (){
        
        for (int i = 0; i < xrecTotal ; i++) {
            System.out.print(recTotal[i].getNombre());
            System.out.println("--"+recTotal[i].getX());
        }
        
    }
    
     public void imprimirmatriz (){
        
        for (int i = 0; i < xrecTotal ; i++) {
            
            for (int j = 0; j < yrecNecesarios; j++) {
                    System.out.print(recNecesarios[i][j].getNombre());
                    System.out.print("--");
                    System.out.print(recNecesarios[i][j].getMax());
                    System.out.print("--");
                    System.out.print(recNecesarios[i][j].getId());
                    System.out.println("  ");

            }
             System.out.println(" ");
            
        }
    }
         
     public void Predecir(Recurso request[]){
         
         for (int i = 0; i < this.yrecNecesarios; i++) {
             
            
             if(this.recAsignados[0][i].getId() ==  request[0].getId()){
                 
                 if(this.recAsignados[0][i].isFlag() == false){
                     
                      for (int j = 0; j < xrecTotal; j++) {
                        System.out.println(" diponible: "+ this.recDisponibles[j].getMax());
                     }
                     
                     for (int j = 0; j < this.yrecNecesarios; j++) {
                         
                         for (int k = 0; k < xrecTotal ; k++) {
                             System.out.println(" allocation: "+ this.recAsignados[k][j].getMax() );
                         }
                         System.out.println(" ");
                     }
                     
                     for (int j = 0; j < this.yrecNecesarios; j++) {
                         
                         for (int k = 0; k < xrecTotal ; k++) {
                             System.out.println(" claim: "+ this.recNecesarios[k][j].getMax() );
                         }
                         System.out.println(" ");
                     }
        
                     p1.Verificar(recTotal, recDisponibles, recNecesarios, recAsignados, request, numProcesos, this.xrecTotal, 
                             this.solicitudesRechazadas, this.solicitudes, this.apuntSolicitudes, this.apuntSolicitudesb);
                     
                     setApuntSolicitudes(p1.getApuntSol()); 
                     setApuntSolicitudesb(p1.getApuntBlock());
                     System.out.println(" ---- valor del apuntador a solicitud dentro de p1 = "+ p1.getApuntSol() );
                     System.out.println(" ---- valor del apuntador de solicitud bloqueada = "+ p1.getApuntBlock());
                 }
                 
                 else {
                     System.out.println("Proceso bloqueado");
                 }
                 
             }
             
         }
         
     }
     
     public void detectar(Recurso request[]){
     
       /* System.out.println("numero de la solicitud:"+ request[0].getId());
         System.out.println("numero de y de solicitud : "+ request[0].getY());
         
         for (int i = 0; i < this.xrecTotal; i++) {
             recAsignadosD[i][request[0].getY()].setMax( recAsignadosD[i][request[0].getY()].getMax()+request[i].getMax() );
             this.recDisponiblesD[i].setMax(recDisponiblesD[i].getMax()-request[i].getMax());
         }
    */
         
     d1.deteccion(recNecesariosD, recDisponiblesD, recAsignadosD, request, xrecTotal, numProcesosD);
     
     }
     
     
     
     
     
     
    
    
    
    
}
