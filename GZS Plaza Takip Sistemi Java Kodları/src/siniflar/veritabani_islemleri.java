

package siniflar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class veritabani_islemleri {
    
    PreparedStatement ps;
    ResultSet rs;
    
    private String veri_no;
    private String sicaklik_degeri;
    private String hava_kalitesi;
    private String hareket_durumu;
    private String kayit_tarihi;
    private String m_no;
    private String m_ad;
    private String m_soyad;
    private String m_kadi;
    private String m_sifre;
    
    
    public List<veritabani_islemleri> hareketListele()
    {
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan(1);
        
        int sayac = 0, i = 0;
        List<veritabani_islemleri> liste = new ArrayList<>();
        veritabani_islemleri [] hareket;
        
        try
        {
          String sorgu1 = "SELECT verino, kayittarihi FROM sensor_verileri where hareketdegeri = \"1\" ";
          ps = vb.con.prepareStatement(sorgu1);
          rs = ps.executeQuery();
          while(rs.next())
          {
              sayac++;
          }
          
          hareket = new veritabani_islemleri[sayac];
          String sorgu2 = "SELECT verino, kayittarihi FROM sensor_verileri where hareketdegeri = \"1\" ";
          ps = vb.con.prepareStatement(sorgu2);
          rs = ps.executeQuery();
          while(rs.next())
          {
              hareket[i] = new veritabani_islemleri();
              hareket[i].setVeri_no(rs.getString(1));
              hareket[i].setKayit_tarihi(rs.getString(2));
              liste.add(hareket[i]);
              i++;
              
          }
        }
        catch(Exception ex)
        {
            
        }
        return liste;
    }
    
    public List<veritabani_islemleri> isiticiListele()
    {
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan(1);
        
        int sayac = 0, i = 0;
        List<veritabani_islemleri> liste = new ArrayList<>();
        veritabani_islemleri [] isitici;
        
        try
        {
          String sorgu1 = "SELECT verino, sicaklik, kayittarihi FROM sensor_verileri where STRCMP(sicaklik, \"31\") = -1 ";
          ps = vb.con.prepareStatement(sorgu1);
          rs = ps.executeQuery();
          while(rs.next())
          {
              sayac++;
          }
          
          isitici = new veritabani_islemleri[sayac];
          String sorgu2 = "SELECT verino, sicaklik, kayittarihi FROM sensor_verileri where STRCMP(sicaklik, \"31\") = -1 ";
          ps = vb.con.prepareStatement(sorgu2);
          rs = ps.executeQuery();
          while(rs.next())
          {
              isitici[i] = new veritabani_islemleri();
              isitici[i].setVeri_no(rs.getString(1));
              isitici[i].setSicaklik_degeri(rs.getString(2));
              isitici[i].setKayit_tarihi(rs.getString(3));
              liste.add(isitici[i]);
              i++;
              
          }
        }
        catch(Exception ex)
        {
            
        }
        return liste;
    }
    
    public List<veritabani_islemleri> sogutucuListele()
    {
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan(1);
        
        int sayac = 0, i = 0;
        List<veritabani_islemleri> liste = new ArrayList<>();
        veritabani_islemleri [] sogutucu;
        
        try
        {
          String sorgu1 = "SELECT verino, sicaklik, kayittarihi FROM sensor_verileri where STRCMP(sicaklik, \"34\") = 1 ";
          ps = vb.con.prepareStatement(sorgu1);
          rs = ps.executeQuery();
          while(rs.next())
          {
              sayac++;
          }
          
          sogutucu = new veritabani_islemleri[sayac];
          String sorgu2 = "SELECT verino, sicaklik, kayittarihi FROM sensor_verileri where STRCMP(sicaklik, \"34\") = 1 ";
          ps = vb.con.prepareStatement(sorgu2);
          rs = ps.executeQuery();
          while(rs.next())
          {
              sogutucu[i] = new veritabani_islemleri();
              sogutucu[i].setVeri_no(rs.getString(1));
              sogutucu[i].setSicaklik_degeri(rs.getString(2));
              sogutucu[i].setKayit_tarihi(rs.getString(3));
              liste.add(sogutucu[i]);
              i++;
              
          }
        }
        catch(Exception ex)
        {
            
        }
        return liste;
    }
    
    public List<veritabani_islemleri> alarmListele()
    {
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan(1);
        
        int sayac = 0, i = 0;
        List<veritabani_islemleri> liste = new ArrayList<>();
        veritabani_islemleri [] alarm;
        
        try
        {
          String sorgu1 = "SELECT verino, havakalitesi, kayittarihi FROM sensor_verileri where STRCMP(havakalitesi, \"380\") = 1 ";
          ps = vb.con.prepareStatement(sorgu1);
          rs = ps.executeQuery();
          while(rs.next())
          {
              sayac++;
          }
          
          alarm = new veritabani_islemleri[sayac];
          String sorgu2 = "SELECT verino, havakalitesi, kayittarihi FROM sensor_verileri where STRCMP(havakalitesi, \"380\") = 1 ";
          ps = vb.con.prepareStatement(sorgu2);
          rs = ps.executeQuery();
          while(rs.next())
          {
              alarm[i] = new veritabani_islemleri();
              alarm[i].setVeri_no(rs.getString(1));
              alarm[i].setHava_kalitesi(rs.getString(2));
              alarm[i].setKayit_tarihi(rs.getString(3));
              liste.add(alarm[i]);
              i++;
              
          }
        }
        catch(Exception ex)
        {
            
        }
        return liste;
    }
    
    public boolean uyeOl(veritabani_islemleri uye_ol)
    {
        try
        {
            veritabani_baglanti vb = new veritabani_baglanti();
            vb.baglan(1);
            
            String sorgu = "insert into uyeler (ad,soyad,kadi,sifre) values (?,?,?,?)";
            ps = vb.con.prepareStatement(sorgu);
            ps.setString(1, uye_ol.getM_ad());
            ps.setString(2, uye_ol.getM_soyad());
            ps.setString(3, uye_ol.getM_kadi());
            ps.setString(4, uye_ol.getM_sifre());
            
            ps.execute();
            return true;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Hata = " + ex);
            return false;
            
        }        
    }
    
    public List<veritabani_islemleri> veriListele()
    {
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan(1);
        
        int sayac = 0, i = 0;
        List<veritabani_islemleri> liste = new ArrayList<>();
        veritabani_islemleri [] veri;
        
        try
        {
          String sorgu1 = "select * from sensor_verileri";
          ps = vb.con.prepareStatement(sorgu1);
          rs = ps.executeQuery();
          while(rs.next())
          {
              sayac++;
          }
          
          veri = new veritabani_islemleri[sayac];
          String sorgu2 = "select * from sensor_verileri";
          ps = vb.con.prepareStatement(sorgu2);
          rs = ps.executeQuery();
          while(rs.next())
          {
              veri[i] = new veritabani_islemleri();
              veri[i].setVeri_no(rs.getString(1));
              veri[i].setSicaklik_degeri(rs.getString(2));
              veri[i].setHava_kalitesi(rs.getString(3));
              veri[i].setHareket_durumu(rs.getString(4));
              veri[i].setKayit_tarihi(rs.getString(5));
              liste.add(veri[i]);
              i++;
              
          }
        }
        catch(Exception ex)
        {
            
        }
        return liste;
    }
    
    public List<veritabani_islemleri> uyeListele()
    {
        veritabani_baglanti vb = new veritabani_baglanti();
        vb.baglan(1);
        
        int sayac = 0, i = 0;
        List<veritabani_islemleri> liste = new ArrayList<>();
        veritabani_islemleri [] uye;
        
        try
        {
          String sorgu1 = "select * from uyeler";
          ps = vb.con.prepareStatement(sorgu1);
          rs = ps.executeQuery();
          while(rs.next())
          {
              sayac++;
          }
          
          uye = new veritabani_islemleri[sayac];
          String sorgu2 = "select * from uyeler";
          ps = vb.con.prepareStatement(sorgu2);
          rs = ps.executeQuery();
          while(rs.next())
          {
              uye[i] = new veritabani_islemleri();
              uye[i].setM_no(rs.getString(1));
              uye[i].setM_ad(rs.getString(2));
              uye[i].setM_soyad(rs.getString(3));
              uye[i].setM_kadi(rs.getString(4));
              uye[i].setM_sifre(rs.getString(5));
              liste.add(uye[i]);
              i++;
              
          }
        }
        catch(Exception ex)
        {
            
        }
        return liste;
    }
    
    
    
    public void veriEkle(String dizi[])throws SQLException{
        try
        {
            veritabani_baglanti vb = new veritabani_baglanti();
            vb.baglan(1);
            
            String sorgu = "insert into sensor_verileri (sicaklik,havakalitesi,hareketdegeri,kayittarihi) values (?,?,?,NOW());";
            
            PreparedStatement ps = vb.con.prepareStatement(sorgu);
            
            ps.setString(1, dizi[0]);
            ps.setString(2, dizi[1]);
            ps.setString(3, dizi[2]);
            
            ps.execute();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);   
        }
    }

    public String getVeri_no() {
        return veri_no;
    }

    public void setVeri_no(String veri_no) {
        this.veri_no = veri_no;
    }

    public String getM_no() {
        return m_no;
    }

    public void setM_no(String m_no) {
        this.m_no = m_no;
    }

    public String getM_ad() {
        return m_ad;
    }

    public void setM_ad(String m_ad) {
        this.m_ad = m_ad;
    }

    public String getM_soyad() {
        return m_soyad;
    }

    public void setM_soyad(String m_soyad) {
        this.m_soyad = m_soyad;
    }

    public String getM_kadi() {
        return m_kadi;
    }

    public void setM_kadi(String m_kadi) {
        this.m_kadi = m_kadi;
    }

    public String getM_sifre() {
        return m_sifre;
    }

    public void setM_sifre(String m_sifre) {
        this.m_sifre = m_sifre;
    }

    public String getSicaklik_degeri() {
        return sicaklik_degeri;
    }

    public void setSicaklik_degeri(String sicaklik_degeri) {
        this.sicaklik_degeri = sicaklik_degeri;
    }

    public String getHava_kalitesi() {
        return hava_kalitesi;
    }

    public void setHava_kalitesi(String hava_kalitesi) {
        this.hava_kalitesi = hava_kalitesi;
    }

    public String getHareket_durumu() {
        return hareket_durumu;
    }

    public void setHareket_durumu(String hareket_durumu) {
        this.hareket_durumu = hareket_durumu;
    }

    public String getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(String kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }
    
    
    
    
    
    
}
