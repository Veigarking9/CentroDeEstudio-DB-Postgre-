/*

 */
package vo;

import java.util.Date;

public class Clase {
    
    private int NCLASE;
    private String ASIG;
    private String ALUM;
    private String PROF;

      

    

    public Clase(int NCLASE, String ASIG, String ALUM, String PROF) {
          this.NCLASE = NCLASE;
          this.ASIG = ASIG;
          this.ALUM = ALUM;
          this.PROF = PROF;

          
           
}

    public Clase() {
    }
    
    public int getNCLASE() {
        return NCLASE;
    }

    public void setNCLASE(int NCLASE) {
        this.NCLASE = NCLASE;
    }

    public String getASIG() {
        return ASIG;
    }

    public void setASIG(String ASIG) {
        this.ASIG = ASIG;
    }
    

    public String getALUM() {
        return ALUM;
    }

    public void setALUM(String ALUM) {
        this.ALUM = ALUM;
    }

    public String getPROF() {
        return PROF;
    }

    public void setPROF(String PROF) {
        this.PROF = PROF;
    }


    
    
}
