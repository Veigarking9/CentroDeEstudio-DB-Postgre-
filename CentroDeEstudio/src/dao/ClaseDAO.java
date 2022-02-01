/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import vo.Clase;


/**
 *
 * @author xabier.barreiroalber
 */
public class ClaseDAO implements Dao<Clase> {

    @Override
    public Clase get(long id) {
        return new Clase();
    }

    @Override
    public List<Clase> getAll(Connection conn) {
        List<Clase> listaClase = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT * FROM CLASE;");

            int totalRows = 0;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            listaClase = new ArrayList<Clase>(totalRows);
            while (rs.next()) {
                int NCLASE = rs.getInt(1);
                String ALUM = rs.getString(2);
                String PROF = rs.getString(3);
                String ASIG = rs.getString(4);

                
                listaClase.add(new Clase(NCLASE, ASIG, ALUM, PROF));
            }
        } catch (SQLException e) {
            System.out.println("ERROR MOSTRANDO TODOS LAS CLASES: "+"\n");
            e.printStackTrace();
        }
// TODO Auto-generated method stub
        return listaClase;
    }  
    public List<Clase> getByDNI(Connection conn, int NClase){
        
        List<Clase> listaClaseID = new ArrayList<Clase>();
        
        try{
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CLASE WHERE NCLASE = ?;");
            ps.setInt(1,NClase);
            ResultSet rs = ps.executeQuery();
            listaClaseID = new ArrayList<Clase>();
            while (rs.next()) {
                int NCLASE = rs.getInt(1);
                String ALUM = rs.getString(2);        
                String PROF = rs.getString(3);
                String ASIG = rs.getString(4);  
                
                listaClaseID.add(new Clase(NCLASE, ALUM, PROF, ASIG));
            }  
        }catch(SQLException e){
            System.out.println("ERROR BUSCANDO POR ID: "+"\n");
            e.printStackTrace();
            
        }
     return listaClaseID;
    }
    
    
}