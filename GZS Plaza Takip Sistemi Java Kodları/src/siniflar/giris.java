
package siniflar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class giris 
{
    ResultSet rs; // Veritabanından dönen bilgileri tutar..
    PreparedStatement ps; // Veritabanına sorgu vs. göndermemizi sağlar..
    
    public boolean giris_yap(String kadi, String sifre) throws SQLException
    {
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan(1);
        
        String sorgu = "select sifre from admin where kadi=?";
        ps = vb.con.prepareStatement(sorgu);
        ps.setString(1, kadi);
        rs = ps.executeQuery();
        while(rs.next())
        {
            String pw = rs.getString("sifre");
            if(pw.equals(sifre))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
            return false;
    }
    
    public boolean giris_yap2(String kadi, String sifre) throws SQLException
    {
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan(1);
        
        String sorgu = "select sifre from uyeler where kadi=?";
        ps = vb.con.prepareStatement(sorgu);
        ps.setString(1, kadi);
        rs = ps.executeQuery();
        while(rs.next())
        {
            String pw = rs.getString("sifre");
            if(pw.equals(sifre))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
            return false;
    }
    
}
