/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodeestudio;

import centrodeestudio.Vista;
import dao.AlumnoDAO;
import dao.AsignaturaDAO;
import dao.ProfesorDAO;
import dao.ClaseDAO;
import factory.DAOFactory;
import java.util.ArrayList;
import java.util.List;
import vo.Alumno;
import vo.Asignatura;
import vo.Clase;
import vo.Profesor;

/**
 *
 * @author xabier.barreiroalber
 */
public class Controller {

    static List<Alumno> alumnos;
    static List<Alumno> alumnoDNI;

    static List<Profesor> profesores;
    static List<Profesor> profesoresDNI;

    static List<Asignatura> asignaturas;
    static List<Asignatura> asignaturasCOD;

    static List<Clase> clases;
    static List<Clase> claseID;
    

    public static void main(String[] args) throws Exception {
        alumnoDNI = new ArrayList<Alumno>();
        String output = new String();

//Create factory
        DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
//Create dAO
        AlumnoDAO alumDAO = (AlumnoDAO) mySQLFactory.getAlumnoDAO();
        ProfesorDAO profDAO = (ProfesorDAO) mySQLFactory.getProfesorDAO();
        AsignaturaDAO asigDAO = (AsignaturaDAO) mySQLFactory.getAsignaturaDAO();
        ClaseDAO clasDAO = (ClaseDAO) mySQLFactory.getClaseDAO();


//Inicializar todo
//...
//Vista
        Vista v = new Vista();
        int opcion = v.mostrarMenu();
        switch (opcion) {

            
            case 1:
            //GET ALL ALUMNOS
            try {
                alumnos = alumDAO.getAll(mySQLFactory.getConnection());
            } catch (Exception e) {
                System.out.println("ERROR EJECUTANDO LA OPTENCIÓN DE TODOS LOS ALUMNOS PARA MOSTRARLAS EN LA VISTA: "+"\n");
                e.printStackTrace();
            }
            
            //MOSTRAR ALUMNOS
            
            for (int i = 0; i < alumnos.size(); i++) {
                output += " DNI -> " + alumnos.get(i).getDNI() + " | NOMBRE -> " + alumnos.get(i).getANAME() + " | APELLIDOS -> " + alumnos.get(i).getAAPEL() + " | TELEFONO -> " + alumnos.get(i).getTELF() + "\n";
            }
            v.showMessage(output);
            break;

            case 2:
                //GET ALL PROFESORES
                try {
                    profesores = profDAO.getAll(mySQLFactory.getConnection());
                } catch (Exception e) {
                    System.out.println("ERROR EJECUTANDO LA OPTENCIÓN DE TODOS LOS PROFESORES PARA MOSTRARLAS EN LA VISTA: "+"\n");
                    e.printStackTrace();
                }
                
                //MOSTRAR PROFESORES

                
                for (int i = 0; i < profesores.size(); i++) {
                    output += " DNI -> " + profesores.get(i).getDNI() + " | NOMBRE -> " + profesores.get(i).getPNAME() + " | APELLIDOS -> " + profesores.get(i).getPAPEL() + " | DEPARTAMENTO -> " + profesores.get(i).getDEP() + "\n";
                }
                v.showMessage(output);
                break;
                
               
            case 3:
                //GET ALL ASIGNATURAS
                try {
                    asignaturas = asigDAO.getAll(mySQLFactory.getConnection());
                } catch (Exception e) {
                    System.out.println("ERROR EJECUTANDO LA OPTENCIÓN DE TODAS LAS ASIGNATURAS PARA MOSTRARLAS EN LA VISTA: "+"\n");
                    e.printStackTrace();
                }
                
                //MOSTRAR ASIGNATURAS 

                for (int i = 0; i < asignaturas.size(); i++) {
                    output += " CÓDIGO DE ASIGNATURA -> " + asignaturas.get(i).getCOD_ASIG() + " | NOMBRE -> " + asignaturas.get(i).getANAME() + "\n";
                }
                v.showMessage(output);
                break;

              
            case 4:
                //GET ALL CLASES
                try {
                    clases = clasDAO.getAll(mySQLFactory.getConnection());
                } catch (Exception e) {
                    System.out.println("ERROR EJECUTANDO LA OPTENCIÓN DE TODAS LAS CLASES PARA MOSTRARLAS EN LA VISTA: "+"\n");
                    e.printStackTrace();
                }
                
                //MOSTRAR CLASES  

                for (int i = 0; i < clases.size(); i++) {
                    output += "NÚMERO DE CLASE -> " + clases.get(i).getNCLASE() + " | PROFESOR -> " + clases.get(i).getPROF() + " | ALUMNO -> " + clases.get(i).getALUM() + " | ASIGNATURA -> " + clases.get(i).getASIG() + "\n";
                }
                v.showMessage(output);
                break;

          
            case 5:
                
                //GET ALUMNOS POR DNI    
                try {
                    String DNIsearch = v.getDNI();
                    alumnoDNI = alumDAO.getByDNI(mySQLFactory.getConnection(), DNIsearch);
                } catch (Exception e) {
                    System.out.println("ERROR EJECUTANDO LA OPTENCIÓN DE ALUMNOS POR DNI PARA MOSTRARLAS EN LA VISTA: "+"\n");
                    e.printStackTrace();
                }

                //MOSTRAR ALUMNOS POR DNI
                for (int i = 0; i < alumnoDNI.size(); i++) {
                    output += " DNI -> " + alumnoDNI.get(i).getDNI() + " | NOMBRE -> " + alumnoDNI.get(i).getANAME() + " | APELLIDOS -> " + alumnoDNI.get(i).getAAPEL() + " | TELEFONO -> " + alumnoDNI.get(i).getTELF() + "\n";
                }
                v.showMessage(output);
                break;
                
            case 6:
                //GET PROFESORES POR DNI
                try {
                    String DNIsearch = v.getDNI();
                    profesoresDNI = profDAO.getByDNI(mySQLFactory.getConnection(), DNIsearch);
                    System.out.println(profDAO.get(0).getDNI());
                } catch (Exception e) {
                    System.out.println("ERROR EJECUTANDO LA OPTENCIÓN DE PROFESORES POR DNI PARA MOSTRARLAS EN LA VISTA: "+"\n");
                    e.printStackTrace();
                }

                //MOSTRAR PROFESORES POR DNI
                for (int i = 0; i < profesoresDNI.size(); i++) {
                    output += " DNI -> " + profDAO.get(i).getDNI() + " | NOMBRE -> " + profDAO.get(i).getPNAME() + " | APELLIDOS -> " + profDAO.get(i).getPAPEL() + " | DEPARTAMENTO -> " + profDAO.get(i).getDEP() + "\n";
                }
                v.showMessage(output);
                break;
             

            case 7:
                //GET ASIGNATURAS PRO COD_ASIG
                try {
                    int CODsearch = v.getCODsearch();
                    asignaturasCOD = asigDAO.getByCOD_ASIG(mySQLFactory.getConnection(), CODsearch);
                } catch (Exception e) {
                    System.out.println("ERROR EJECUTANDO LA OPTENCIÓN DE LAS ASIGNATURAS POR CÓDIGO PARA MOSTRARLAS EN LA VISTA: "+"\n");
                    e.printStackTrace();
                }
                
                
                //MOSTRAR ASIGNATURAS POR COD_ASIG

                for (int i = 0; i < asignaturasCOD.size(); i++) {
                    output += " CÓDIGO DE ASIGNATURA -> " + asignaturasCOD.get(i).getCOD_ASIG() + " | NOMBRE -> " + asignaturasCOD.get(i).getANAME() + "\n";
                }
                v.showMessage(output);
                break;
                
            
            case 8:
                //GET CLASE POR NCLASE
                try {
                    int NClase = v.getNCLASESearch();
                    claseID = clasDAO.getByDNI(mySQLFactory.getConnection(), NClase);
                } catch (Exception e) {
                    System.out.println("ERROR EJECUTANDO LA OPTENCIÓN DE CLASE POR NÚMERO DE CLASE PARA MOSTRARLAS EN LA VISTA: "+"\n");
                    e.printStackTrace();
                }

                //MOSTRAR CLASE POR NCLASE
                for (int i = 0; i < claseID.size(); i++) {
                    output += " NCLASE -> " + claseID.get(i).getNCLASE()+ " | ALUMNO -> " + claseID.get(i).getALUM() + " | PROFESOR -> " + claseID.get(i).getPROF() + " | ASIGNATURA -> " + claseID.get(i).getASIG() + "\n";
                }
                v.showMessage(output);
                break;

            case 9:
                //INSERT ALMUNOS   
                    String DNI = v.getDNI();
                    String ANAME = v.getNAMEInsert();
                    String AAPEL = v.getAPELInsert();
                    int TELF = v.getTELFInsert();
                try {
                    alumDAO.setAlumnoInsert(mySQLFactory.getConnection(), DNI, ANAME, AAPEL, TELF);
  
                } catch (Exception e) {
                    System.out.println("ERROR INTRODUCIENDO ALUMNOS");
                    e.printStackTrace();
                    
                }
                break;
            
            case 10:
                //INSERT PROFESOR   
                    DNI = v.getDNI();
                    String PNAME = v.getNAMEInsert();
                    String PAPEL = v.getAPELInsert();
                    String DEP = v.getDEPInsert();
                try {
                    profDAO.setProfesorInsert(mySQLFactory.getConnection(), DNI, PNAME, PAPEL, DEP);
  
                } catch (Exception e) {
                    System.out.println("ERROR INTRODUCIENDO PROFESORES");
                    e.printStackTrace();
                    
                }
               
            case 11:
                //INSERT ASIGNATURAS   
                    ANAME = v.getNAMEInsert();
                try {
                    asigDAO.setAsignaturaInsert(mySQLFactory.getConnection(), ANAME);
  
                } catch (Exception e) {
                    System.out.println("ERROR INTRODUCIENDO ASIGNATURAS");
                    e.printStackTrace();
                    
                }
                break;
                
                

        }
                

                
                

        }  
    }


