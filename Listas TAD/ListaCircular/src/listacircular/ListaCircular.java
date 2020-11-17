 
package listacircular;
import java.io.*;
class nodo {
    int dato;
    nodo sig;

    nodo(int pnum) {
        this.dato=pnum;
    }
    nodo(int pnum, nodo L) {
        this.dato = pnum;
        this.sig = L;
    }
}

class lista{
    nodo L;
    nodo aux;
    
   void agregar(int pnum) {       
       if (L==null){
           L=new nodo(pnum);
           L.sig=L;
       }else{
           aux=L;
           while(aux.sig!=L)
               aux=aux.sig;
           aux.sig=new nodo(pnum, L);
       }
   }
    void mostrar (){
        aux=L;
        String dat="";
        while (aux.sig!=L){
            dat=dat+aux.dato+",";
            aux=aux.sig;
        }
        dat=dat+aux.dato+", ";
        System.out.print("L-->"+dat);
}
}
public class ListaCircular {

    
    public static void main(String[] args) throws IOException{
        InputStreamReader sr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(sr);
        lista ls=new lista();
        char op='s';
        while (op!='n'){
            System.out.print("numero a listar");
            ls.agregar(Integer.parseInt(br.readLine()));
            System.out.print("¿Otro número (s/n): ");
            op=br.readLine().charAt(0);
            
            
        }
        ls.mostrar();
        System.out.println();
    }
}
