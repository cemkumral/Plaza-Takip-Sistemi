
package siniflar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class veritabani_baglanti 
{
    public Connection con;
    private String url = "jdbc:mysql://localhost:3306/";
    private String driver = "com.mysql.jdbc.Driver";
    private String dbname = "plazatakip";
    private String username = "root";
    private String password = "1234";
    
    public void baglan(int sayac)
    {
        if(sayac % 2 == 0)
        {
        try
        {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url+dbname,username,password);
            JOptionPane.showMessageDialog(null, "VERİTABANI BAĞLANTISI BAŞARILI..");
        }
        catch(Exception ex)
        {
            Logger.getLogger(veritabani_baglanti.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "HATA : "+ex);
        }
        }
        else
        {
            try
        {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url+dbname,username,password);
            //JOptionPane.showMessageDialog(null, "Baglanti Basarili..");
        }
        catch(Exception ex)
        {
            Logger.getLogger(veritabani_baglanti.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "HATA : "+ex);
        }
        }
    }
}
