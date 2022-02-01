/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodeestudio;
import java.util.Scanner;

/**
 *
 * @author xabier.barreiroalber
 */
public class Vista {

    public int mostrarMenu() {
        Scanner t = new Scanner(System.in);
        System.out.println("selecciona una opcion:");
        System.out.println("1- Alumnos");
        System.out.println("2- Profesores");
        System.out.println("3- Asignaturas");
        System.out.println("4- Clases");
        System.out.println("5- Buscar alumnos por DNI");
        System.out.println("6- Buscar profesores por DNI");
        System.out.println("7- Buscar asignaturas por Código de Asignatura");
        System.out.println("8- Buscar clase por Número de Clase");
        System.out.println("9- Introducir alumnos");
        System.out.println("10- Introducir profesores");
        System.out.println("11- Introducir asignaturas");
        int opcion = t.nextInt();
        return opcion;
    }

    public boolean showMessage(String message) {
        System.out.println(message);
        return true;
    }
    //GET DNI
    public String getDNI(){
        Scanner t = new Scanner(System.in);
        System.out.println("INTRODUCE EL DNI:");
        String DNIsearch = t.nextLine();
        return DNIsearch;
    }
    //GET COD PARA BUSQUEDA DE ASIGNATURA
    public int getCODsearch(){
        Scanner t = new Scanner(System.in);
        System.out.println("INTRODUCE EL CÓDIGO DE LA ASIGNATURA");
        int CODsearch = t.nextInt();
        
        return CODsearch;
    }
    //GET NÚMERO DE CLASE
    public int getNCLASESearch(){
        Scanner t = new Scanner(System.in);
        System.out.println("INTRODUCE EL NÚMERO DE LA CLASE");
        int NCLASESearch = t.nextInt();
        
        return NCLASESearch;
    }
    //GET NOMBRE PARA INSERT
    public String getNAMEInsert(){
        Scanner t = new Scanner(System.in);
        System.out.println("INTRODUCE EL NOMBRE:");
        String NAME = t.nextLine();
        return NAME;
    }
    //GET APELLIDO PARA INSERT
    public String getAPELInsert(){
        Scanner t = new Scanner(System.in);
        System.out.println("INTRODUCE LOS EL APELLIDO:");
        String APEL = t.nextLine();
        return APEL;
    }
    //GET TELÉFONO PARA INSERT
    public int getTELFInsert(){
        Scanner t = new Scanner(System.in);
        System.out.println("INTRODUCE EL TELÉFONO:");
        int TELF = t.nextInt();
        return TELF;
    }
    //GET DEPARTAMENTO PARA INSERT
    public String getDEPInsert(){
        Scanner t = new Scanner(System.in);
        System.out.println("INTRODUCE EL DEPARTAMENTO:");
        String DEP = t.nextLine();
        return DEP;
    }
}
