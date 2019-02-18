package Clases;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JOptionPane;

public class Persona {
    
    private String NyA;
    private String Prof;
    private String Tel;
    
    String barra = File.separator;
    String ubicacion = System.getProperty("user.dir")+barra+"Funcionarios"+barra;  
    
    public Persona (String NyA, String Prof, String Tel)
    {
        this.NyA = NyA;
        this.Prof = Prof;
        this.Tel = Tel;
    }
    
    public void Guardar()
    {
        String ArchCli = NyA+".txt";        
        File crear_ubica = new File(ubicacion);
        File crear_archivo = new File(ubicacion+ArchCli);
        try 
        {
            if(crear_archivo.exists())
                {
                JOptionPane.showMessageDialog(null,"Ya existe!!!");
                }else
                {
                    crear_ubica.mkdirs();
                    try (Formatter crea = new Formatter(ubicacion+ArchCli)) 
                    {
                        crea.format("%s\r\n%s\r\n%s\r\n","NombreyAp="+NyA,"Profesion="+
                                Prof,"Telefono="+Tel);
                    }
                    JOptionPane.showMessageDialog(null,"Agregado con éxito.");
                }                  
        }
        catch (HeadlessException | FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null,"No se pudo guardar. "+e);
            }   
    }
    
    public String getNyA() {
        return NyA;
    }

    public void setNyA(String NyA) {
        this.NyA = NyA;
    }

    public String getProf() {
        return Prof;
    }

    public void setProf(String Prof) {
        this.Prof = Prof;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }
}
