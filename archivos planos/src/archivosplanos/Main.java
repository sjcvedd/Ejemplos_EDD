package archivosplanos;
import java.io.*;

class estudiante
{
    String cedula;
    String nombre;
    String asignatura;
    double nota=0;
    void registrar() throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("cedula: ");
        this.cedula=br.readLine();
        System.out.print("nombre: ");
        this.nombre=br.readLine();
        System.out.print("asignatura: ");
        this.asignatura=br.readLine();
        System.out.print("nota: ");
        this.nota=Double.parseDouble(br.readLine());
        guardar();

    }
    void guardar() throws IOException
  {
        String datos;
        datos=cedula+"/"+nombre+"/"+asignatura+"/"+nota;
        archivo arch=new archivo();
        arch.crear("estudiante.txt", datos);

    }
}
class archivo
{
    PrintWriter pf;
    FileReader fr;
    void crear(String pNombre,String pDatos) throws IOException
    {
        pf=new PrintWriter(new FileWriter(pNombre,true));
        pf.println(pDatos);
        pf.close();
        System.out.println("Generacion OK...");
    }
    void leer(String pnombre) throws IOException
    {
        fr=new FileReader(pnombre);
        BufferedReader br=new BufferedReader(fr);
        String linea;
        int contador = 0;
        while((linea=br.readLine())!=null)
        {
            contador++;
            String[] datos=new String[4];
            datos=linea.split("/");
            System.out.println("Estudiante #"+contador);
            System.out.println("Cedula: "+datos[0]);
            System.out.println("Nombre: "+datos[1]);
            System.out.println("Asignatura: "+datos[2]);
            System.out.println("Nota Final: "+datos[3]);
        }
    }
}


public class Main
{



    public static void main(String[] args) throws IOException
    {
        estudiante estu=new estudiante();
        estu.registrar();
        archivo ar=new archivo();
        ar.leer("estudiante.txt");

    }

}
