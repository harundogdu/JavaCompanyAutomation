
package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gui.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.*;
import javax.swing.table.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import net.proteanit.sql.DbUtils;

public class Actions implements ActionListener, MouseListener {

    Login login = null;
    LogoGui logogui = null;
    DMainGui dmg;
    UserGui ug;
    AdminGui ag;

    public int FontBoy = 12;
    String FontAdi = "Verdana";

    String username;
    String password;
    String mail;

    public Actions(LogoGui a) {
        setLogogui(a);
        setLogin(a.getLogin());

    }

    public Actions(UserGui ug) {
        this.ug = ug;
        animationCreator2();
    }

    public Actions(AdminGui ag) {
        this.ag = ag;
        animationCreator();
    }

    public AdminGui getAg() {
        return ag;
    }

    public void setAg(AdminGui ag) {
        this.ag = ag;

    }

    public UserGui getUg() {
        return ug;
    }

    public void setUg(UserGui ug) {
        this.ug = ug;
    }

    public DMainGui getDmg() {
        if (dmg == null) {

            dmg = new DMainGui();
            //dmg.getJf().setVisible(false);

            //dmg.getJf().removeAll();
        }
        return dmg;
    }

    public void setDmg(DMainGui dmg) {
        this.dmg = dmg;
    }

    public Actions(Login login1) {
        setLogin(login1);
    }

    public Actions(DMainGui dmg) {
        this.dmg = dmg;

    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public LogoGui getLogogui() {
        return logogui;
    }

    public void setLogogui(LogoGui logogui) {
        this.logogui = logogui;

    }

    public String getPassword() {
        if (password == null) {
            password = new String();
            password = (String.valueOf(getLogin().getPass_text().getPassword()));
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        if (mail == null) {
            mail = new String();
            mail = getLogin().getEmail_text().getText();
        }
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public static void Playmp3(String filepath) {
        InputStream music;

        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public static void Stopmp3(String filepath) {
        InputStream music;

        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.stop(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public void AdminTableYukle() {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/elements_building";

        //Database kullanıcı adı ve şifresi
        String USER = "root";
        String PASS = "";
        Connection conn;
        Statement st;
        ResultSet rs;

        String load = "SELECT Id,AdSoyad,Mail,Departman,Maas,SGKNO FROM personel";

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            rs = st.executeQuery(load);
            ag.getAdmintable().setModel(DbUtils.resultSetToTableModel(rs));
//                        admintable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//            admintable.getColumnModel().getColumn(1).setPreferredWidth(20);
            ag.getAdmintable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            ag.getAdmintable().getColumnModel().getColumn(0).setPreferredWidth(1);
            ag.getAdmintable().getColumnModel().getColumn(1).setPreferredWidth(30);
            ag.getAdmintable().getColumnModel().getColumn(2).setPreferredWidth(100);
            ag.getAdmintable().getColumnModel().getColumn(3).setPreferredWidth(30);
            ag.getAdmintable().getColumnModel().getColumn(4).setPreferredWidth(5);
            ag.getAdmintable().getColumnModel().getColumn(5).setPreferredWidth(5);
        } catch (Exception errorException) {
            errorException.printStackTrace();
        }
    }

    public void MesajGonder() {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/elements_building";

        //Database kullanıcı adı ve şifresi
        String USER = "root";
        String PASS = "";
        Connection conn;
        Statement st;
        ResultSet rs;

        try {

        } catch (Exception e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (getLogin() != null) {
            if (e.getSource() == getLogin().getRegister()) {
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                String DB_URL = "jdbc:mysql://localhost/elements_building";

                //Database kullanıcı adı ve şifresi
                String USER = "root";
                String PASS = "";
                Connection conn;

                String login_words = "SELECT * FROM PERSONEL WHERE AdSoyad='" + getUsername() + "' AND " + "Sifre='" + getPassword() + "' AND Mail='" + getMail() + "'";
                ResultSet rs;

                try {
                    //JDBC Driverina kayıt başvuru
                    Class.forName(JDBC_DRIVER);
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    PreparedStatement ps;
                    ps = conn.prepareStatement(login_words);
                    rs = ps.executeQuery();

                    //stmt=conn.createStatement();
                    if (rs.next() && getLogin().getCheckinfo().isSelected()) {
                        login_animasyonu();
                        int yetki = rs.getInt("YoneticiMi");
                        JOptionPane.showMessageDialog(null, "Hoşgeldiniz Sayın " + username);
                        //getLogin().getJp().setBounds(1600, 0, 500, 800);
                        anaekrangelis_animasyonu();
                        System.out.println(yetki);
                        getLogin().getDmg().getJf().setVisible(false);

                        //getDmg().getJf().removeAll();
                        //AdminGui b = new AdminGui(login);
                        if (yetki == 0) {
                            login.getDmg().getJf().setVisible(false);
                            UserGui a = new UserGui(login);
                        } else if (yetki == 1) {
                            AdminGui b = new AdminGui(login);

                        } else {
                            JOptionPane.showMessageDialog(null, "SQL'den Gelen Sorgu Hatalı");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı Veya Şifre");
                        getLogin().getUser_text().setText(null);
                        getLogin().getPass_text().setText(null);
                        getLogin().getEmail_text().setText(null);

                        // System.exit(0);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }/*
        
            USERGUI MAİL EKRANI HAREKETLERİ BAŞLANGIÇ
        
         */ else if (getUg() != null) {

            if (e.getSource() == getUg().getAccordionLogout()) {
                int answer = JOptionPane.showConfirmDialog(null, "Çıkış Yapmak İstiyormusunuz ?", "Çıkış Uyarısı", 2, 2);
                if (answer == 0) {
                    ug.getUserFrame().setVisible(false);
                    System.out.println("Çıkış Yapılıyor...");
                    System.exit(0);

                }
            }
            if (e.getSource() == getUg().getBuyut()) {
                getUg().getTextUserMail().setText(getUg().getTextUserMail().getText().toUpperCase());
            } else if (e.getSource() == getUg().getKucult()) {
                getUg().getTextUserMail().setText(getUg().getTextUserMail().getText().toLowerCase());
            } else if (e.getSource() == getUg().getTemizle()) {
                int sure = JOptionPane.showConfirmDialog(null, "Emin Misiniz?", "Dikkat", JOptionPane.YES_NO_OPTION);
                if (sure == JOptionPane.YES_OPTION) {
                    getUg().getTextUserMail().setText("");
                }
            } else if (e.getSource() == getUg().getFontBuyut()) {
                FontBoy++;
            } else if (e.getSource() == getUg().getFontKucult()) {
                if (FontBoy > 9) {
                    FontBoy--;
                } else {
                    JOptionPane.showMessageDialog(null, "Font büyüklüğü  9'dan küçük olamaz");
                }

            } else if (e.getSource() == getUg().getGonder()) {

                int sure_ = JOptionPane.showConfirmDialog(null, "Emin Misiniz?", "Dikkat", JOptionPane.YES_NO_OPTION);
                if (sure_ == JOptionPane.YES_OPTION) {

                    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                    String DB_URL = "jdbc:mysql://localhost/elements_building";

                    //  Database credentials
                    String USER = "root";
                    String PASS = "";
                    Connection connection;
                    Statement statement, statement2;
                    ResultSet resultSet, resultSet2;
                    try {

                        Class.forName(JDBC_DRIVER);
                        connection = DriverManager.getConnection(DB_URL, USER, PASS);
                        statement = connection.createStatement();
                        statement2 = connection.createStatement();

                        String AliciString = "SELECT * FROM personel where AdSoyad='" + ug.getTextMail().getText() + "'";
                        String BizimString = "SELECT * FROM personel where AdSoyad='" + ug.getLbLUser().getText() + "'";
                        System.out.println(AliciString);
                        System.out.println(BizimString);
                        resultSet = statement.executeQuery(AliciString);
                        resultSet2 = statement2.executeQuery(BizimString);
                        Statement statement3 = connection.createStatement();

                        while (resultSet.next() && resultSet2.next()) {
                            int AliciId = resultSet.getInt("Id");
                            int BizimId = resultSet2.getInt("Id");

                            String mesajeklesql = "INSERT INTO mesaj (`Yazi`, `GondericiId`, `AliciId`) VALUES ('" + ug.getTextUserMail().getText() + "'," + BizimId + "," + AliciId + ")";
                            statement3.executeUpdate(mesajeklesql);
                            System.out.println(mesajeklesql);
                        }
                    } catch (Exception error) {
                        error.printStackTrace();
                    }

                    getUg().getTextUserMail().setText("");
                    JOptionPane.showMessageDialog(null, "Mesajınız Başarıyla Gönderildi..");
                }
            } else if (e.getSource() == getUg().getFontListeKutusu()) {
                FontAdi = getUg().getFontListeKutusu().getSelectedItem().toString();
                getUg().setFontAdi(FontAdi);

            }
            Font Fontumuz = new Font(FontAdi, Font.PLAIN, FontBoy);
            getUg().getTextUserMail().setFont(Fontumuz);

            if (e.getSource() == getUg().getUserControl()) {
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                String DB_URL = "jdbc:mysql://localhost/elements_building";

                //  Database credentials
                String USER = "root";
                String PASS = "";

                try {

                    Connection connection;
                    Statement statement, statement2, statement3, statement4;
                    ResultSet resultSet, resultSet2, resultSet3, resultSet4;
                    Class.forName(JDBC_DRIVER);
                    connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    statement = connection.createStatement();
                    statement2 = connection.createStatement();
                    statement3 = connection.createStatement();
                    statement4 = connection.createStatement();

                    String AliciString = "SELECT * FROM personel where AdSoyad='" + ug.getTextMail().getText() + "'";
                    String BizimString = "SELECT * FROM personel where AdSoyad='" + ug.getLbLUser().getText() + "'";

                    resultSet = statement.executeQuery(AliciString);
                    resultSet2 = statement2.executeQuery(BizimString);

                    while (resultSet.next() && resultSet2.next()) {
                        int AliciId = resultSet.getInt("Id");
                        int BizimId = resultSet2.getInt("Id");

                        String load = "SELECT * FROM mesaj where GondericiId='" + BizimId + "' AND AliciId='" + AliciId + "'";
                        String load2 = "SELECT * FROM mesaj where AliciId='" + AliciId + "' AND GondericiId='" + BizimId + "'";

                        resultSet3 = statement3.executeQuery(load);
                        resultSet4 = statement4.executeQuery(load2);

                        while (resultSet3.next() && resultSet4.next()) {
                            String mesaj1 = resultSet3.getString("Yazi");
                            String mesaj2 = resultSet4.getString("Yazi");

                            String icerik = ug.getLbLUser().getText() + " : " + mesaj1 + "   <>    " + ug.getTextMail().getText() + " : " + mesaj2;
                            ug.getTextMailto().setText(icerik);
                        }
                        String GelenKutusu = "SELECT * FROM mesaj JOIN personel on mesaj.AliciId=personel.Id where mesaj.AliciId=" + BizimId;
                        String kimden = "SELECT * FROM personel JOIN mesaj on mesaj.GondericiId=personel.Id where mesaj.AliciId=" + BizimId;
                        System.out.println(GelenKutusu);
                        Statement gelenStatement, kimdenStatement;

                        gelenStatement = connection.createStatement();
                        kimdenStatement = connection.createStatement();

                        ResultSet gelenResultSet, kimdenResultSet;
                        gelenResultSet = gelenStatement.executeQuery(GelenKutusu);
                        kimdenResultSet = kimdenStatement.executeQuery(kimden);

                        while (gelenResultSet.next() && kimdenResultSet.next()) {
                            String b = ug.getGelenkutusu().getText();
                            String userfrom = kimdenResultSet.getString("AdSoyad");
                            String yazi = gelenResultSet.getString("Yazi");
                            ug.getGelenkutusu().setText(b + "      " + userfrom + " : " + yazi);

                        }
                    }

                } catch (Exception error) {
                    error.printStackTrace();
                }

            }

        } /*
        
        USERGUI MAİL EKRANI HAREKETLERİ BİTİŞ
        
         */ /*
        
            ADMINGUI MAİL EKRANI HAREKETLERİ BAŞLANGIÇ
        
         */ else if (getAg() != null) {
            if (e.getSource() == getAg().getAccordionLogout()) {
                int answer = JOptionPane.showConfirmDialog(null, "Çıkış Yapmak İstiyormusunuz ?", "Çıkış Uyarısı", 2, 2);
                if (answer == 0) {
                    ag.getUserFrame().setVisible(false);
                    System.out.println("Çıkış Yapılıyor...");
                    System.exit(0);

                }
            }

            if (e.getSource() == getAg().getBuyut()) {
                getAg().getTextUserMail().setText(getAg().getTextUserMail().getText().toUpperCase());
            } else if (e.getSource() == getAg().getKucult()) {
                getAg().getTextUserMail().setText(getAg().getTextUserMail().getText().toLowerCase());
            } else if (e.getSource() == getAg().getTemizle()) {
                int sure = JOptionPane.showConfirmDialog(null, "Emin Misiniz?", "Dikkat", JOptionPane.YES_NO_OPTION);
                if (sure == JOptionPane.YES_OPTION) {
                    getAg().getTextUserMail().setText("");
                }
            } else if (e.getSource() == getAg().getFontBuyut()) {
                FontBoy++;
            } else if (e.getSource() == getAg().getFontKucult()) {
                if (FontBoy > 9) {
                    FontBoy--;
                } else {
                    JOptionPane.showMessageDialog(null, "Font büyüklüğü  9'dan küçük olamaz");
                }

            } else if (e.getSource() == getAg().getGonder()) {
                int sure_ = JOptionPane.showConfirmDialog(null, "Emin Misiniz?", "Dikkat", JOptionPane.YES_NO_OPTION);
                if (sure_ == JOptionPane.YES_OPTION) {

                    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                    String DB_URL = "jdbc:mysql://localhost/elements_building";

                    //  Database credentials
                    String USER = "root";
                    String PASS = "";
                    Connection connection;
                    Statement statement, statement2;
                    ResultSet resultSet, resultSet2, resultSet3;
                    try {

                        Class.forName(JDBC_DRIVER);
                        connection = DriverManager.getConnection(DB_URL, USER, PASS);
                        statement = connection.createStatement();
                        statement2 = connection.createStatement();

                        String AliciString = "SELECT * FROM personel where AdSoyad='" + ag.getTextMail().getText() + "'";
                        String BizimString = "SELECT * FROM personel where AdSoyad='" + ag.getLbLUser().getText() + "'";
                        System.out.println(AliciString);
                        System.out.println(BizimString);
                        resultSet = statement.executeQuery(AliciString);
                        resultSet2 = statement2.executeQuery(BizimString);
                        Statement statement3 = connection.createStatement();

                        while (resultSet.next() && resultSet2.next()) {
                            int AliciId = resultSet.getInt("Id");
                            int BizimId = resultSet2.getInt("Id");

                            String mesajeklesql = "INSERT INTO mesaj (`Yazi`, `GondericiId`, `AliciId`) VALUES ('" + ag.getTextUserMail().getText() + "'," + BizimId + "," + AliciId + ")";
                            statement3.executeUpdate(mesajeklesql);
                            System.out.println(mesajeklesql);
                        }
                    } catch (Exception error) {
                        error.printStackTrace();
                    }

                    getAg().getTextUserMail().setText("");
                    JOptionPane.showMessageDialog(null, "Mesajınız Başarıyla Gönderildi..");
                }
            } else if (e.getSource() == getAg().getFontListeKutusu()) {
                FontAdi = getAg().getFontListeKutusu().getSelectedItem().toString();
                getAg().setFontAdi(FontAdi);

            }
            Font Fontumuz = new Font(FontAdi, Font.PLAIN, FontBoy);
            getAg().getTextUserMail().setFont(Fontumuz);

            if (e.getSource() == getAg().getUserControl()) {
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                String DB_URL = "jdbc:mysql://localhost/elements_building";

                //  Database credentials
                String USER = "root";
                String PASS = "";

                try {

                    Connection connection;
                    Statement statement, statement2, statement3, statement4;
                    ResultSet resultSet, resultSet2, resultSet3, resultSet4;
                    Class.forName(JDBC_DRIVER);
                    connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    statement = connection.createStatement();
                    statement2 = connection.createStatement();
                    statement3 = connection.createStatement();
                    statement4 = connection.createStatement();

                    String AliciString = "SELECT * FROM personel where AdSoyad='" + ag.getTextMail().getText() + "'";
                    String BizimString = "SELECT * FROM personel where AdSoyad='" + ag.getLbLUser().getText() + "'";

                    resultSet = statement.executeQuery(AliciString);
                    resultSet2 = statement2.executeQuery(BizimString);

                    while (resultSet.next() && resultSet2.next()) {
                        int AliciId = resultSet.getInt("Id");
                        int BizimId = resultSet2.getInt("Id");

                        String load = "SELECT * FROM mesaj where GondericiId='" + BizimId + "' AND AliciId='" + AliciId + "'";
                        String load2 = "SELECT * FROM mesaj where AliciId='" + BizimId + "' AND GondericiId='" + AliciId + "'";

                        resultSet3 = statement3.executeQuery(load);
                        resultSet4 = statement4.executeQuery(load2);

                        while (resultSet3.next() && resultSet4.next()) {
                            String mesaj1 = resultSet3.getString("Yazi");
                            String mesaj2 = resultSet4.getString("Yazi");

                            String icerik = ag.getLbLUser().getText() + " : " + mesaj1 + "   <>    " + ag.getTextMail().getText() + " : " + mesaj2;
                            ag.getTextMailto().setText(icerik);
                        }
                        String GelenKutusu = "SELECT * FROM mesaj JOIN personel on mesaj.AliciId=personel.Id where mesaj.AliciId=" + BizimId;
                        String kimden = "SELECT * FROM personel JOIN mesaj on mesaj.GondericiId=personel.Id where mesaj.AliciId=" + BizimId;
                        System.out.println(GelenKutusu);
                        Statement gelenStatement, kimdenStatement;

                        gelenStatement = connection.createStatement();
                        kimdenStatement = connection.createStatement();

                        ResultSet gelenResultSet, kimdenResultSet;
                        gelenResultSet = gelenStatement.executeQuery(GelenKutusu);
                        kimdenResultSet = kimdenStatement.executeQuery(kimden);

                        while (gelenResultSet.next() && kimdenResultSet.next()) {
                            String b = ag.getGelenkutusu().getText();
                            String userfrom = kimdenResultSet.getString("AdSoyad");
                            String yazi = gelenResultSet.getString("Yazi");
                            ag.getGelenkutusu().setText(b + "      " + userfrom + " : " + yazi);

                        }

                    }

                } catch (Exception error) {
                    error.printStackTrace();
                }

            }
            if (e.getSource() == getAg().getShowTable()) {
                AdminTableYukle();
            }

        }
        /*
        
        ADMINGUI MAİL EKRANI HAREKETLERİ BİTİŞ
        
         */

    }

    public String getUsername() {
        if (username == null) {
            username = new String();
            username = getLogin().getUser_text().getText();
        }
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void anaekrangelis_animasyonu() {
        Thread thread = new Thread() {
            public void run() {
                try {
                    for (int i = 800; i < 1601; i++) {
                        Thread.sleep(2);
                        getLogin().getJp().setBounds(i, 0, 500, 800);

                    }
                } catch (Exception ex) {
                }
            }
        };
        thread.start();
    }

    public void login_animasyonu() {
        //LOGİN ANİMASYONU

        Thread th1 = new Thread() {
            public void run() {
                int geri_index = 100;
                try {
                    for (int i = 170; i > geri_index; i--) {
                        Thread.sleep(5);
                        getLogin().getRegister().setLocation(i, 500);
                    }
                    for (int i = geri_index; i < 500; i++) {
                        Thread.sleep(2);
                        getLogin().getRegister().setLocation(i, 500);

                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        th1.start();

    }

    boolean tek_acilis = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        CreateDatabase();

        if (tek_acilis == false) {
            tek_acilis = true;

            getLogogui().getLogin().getJp().setVisible(true);

            Thread th = new Thread() {//ACILIS ANİMASYONU
                public void run() {
                    try {
                        for (int i = 0; i < 800; i++) {
                            Thread.sleep(2);
                            getLogogui().getLogin().getJp().setLocation(i, 0);
                        }
                        for (int i = 800; i > 750; i--) {
                            Thread.sleep(5);
                            getLogogui().getLogin().getJp().setLocation(i, 0);
                        }
                        for (int i = 750; i < 800; i++) {
                            Thread.sleep(10);
                            getLogogui().getLogin().getJp().setLocation(i, 0);
                        }
                        /* for (int i = 0; i > -800; i--) {
                            Thread.sleep(5);
                            getLogogui().getLogo().setLocation(i, 0);
                        }*/
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }

            };
            th.start();
        }

    }

    public void CreateDatabase() {

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/";

        //Database kullanıcı adı ve şifresi
        String USER = "root";
        String PASS = "";

        Connection conn = null;

        try {
            //JDBC Driverina kayıt başvuru
            Class.forName(JDBC_DRIVER);
            System.out.println("Veri Tabanı Sorguları Gerçekleşiyor");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String control = "SHOW DATABASES LIKE" + "'ELEMENTS_BUILDING'";
            conn.createStatement().executeUpdate(control);

            if (conn.createStatement().executeUpdate(control) == -1) {
                System.out.println("Tekrar Hoşgeldiniz ☻"); // veri tabanı zaten oluşturulmuş tekrar sql cümlesi göndermiyoruz already exist hatası alabiliriz
                return;
            }
            String sql_createdatabase = "CREATE DATABASE " + "ELEMENTS_BUILDING";
            conn.createStatement().executeUpdate(sql_createdatabase);
            CreateTable();
            Initializer();

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "GIRIS YAPABILMEK ICIN MYSQL PORTUNU ACINIZ ☻");
            System.exit(0);
        } catch (ClassNotFoundException e) {
            //Handle errors for Class.forName

            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Sistem'e Giriş Başarılı ☻!");

    }

    public void CreateTable() {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/ELEMENTS_BUILDING";

        String USER = "root";
        String PASS = "";

        Connection conn = null;
        Statement st = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();

            String control_personel = "SHOW TABLES LIKE" + "'personel'";
            String control_mesaj = "SHOW TABLES LIKE" + "'mesaj'";

            if (conn.createStatement().executeUpdate(control_personel) == -1 || st.executeUpdate(control_mesaj) == -1) {
                System.out.println("Tekrar Hoşgeldiniz ☻"); // veri tabanı zaten oluşturulmuş tekrar sql cümlesi göndermiyoruz already exist hatası alabiliriz
                return;
            }

            String create_table_personel = "CREATE TABLE personel "
                    + " ( `Id` INT NOT NULL AUTO_INCREMENT, `AdSoyad` VARCHAR(20) NOT NULL  ,"
                    + " `SGKNO` INT(255) NOT NULL , `Maas` INT(255) NOT NULL ,"
                    + " `Departman` VARCHAR(30) NOT NULL , `Prim` VARCHAR(20) NOT NULL ,"
                    + " `Mail` VARCHAR(50) NOT NULL ,`YoneticiMi` TINYINT NOT NULL, `Sifre` VARCHAR(20) NOT NULL ,PRIMARY KEY(Id))";

            String create_table_mesaj = "CREATE TABLE mesaj ( `Id` INT NOT NULL AUTO_INCREMENT  ,"
                    + "`Yazi` VARCHAR(20) NULL,"
                    + " `GondericiId` INT  , `AliciId` INT ,"
                    + " `CCId` INT , `Saat` DATETIME,PRIMARY KEY(Id))";

            st.executeUpdate(create_table_personel);
            st.executeUpdate(create_table_mesaj);

        } catch (Exception error) {
            error.printStackTrace();
        }

        System.out.println("TABLOLAR OLUŞTURULDU");
    }

    public void Initializer() {

        // VERI TABANI YUKLENDIGINDE ICINE OTOMATIK OLARAK VERI EKLEYEN BIR YAPIDIR ♥
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/ELEMENTS_BUILDING";

        //Database kullanıcı adı ve şifresi
        String USER = "root";
        String PASS = "";

        Connection conn = null;
        Statement statements = null;

        try {
            //JDBC Driverina kayıt başvuru
            Class.forName(JDBC_DRIVER);
            System.out.println("Veri Tabanı Sorguları Gerçekleşiyor");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String[] PersonelGirdisi = new String[2];
            PersonelGirdisi[0] = "INSERT INTO personel (`AdSoyad`, `SGKNO`, `Maas`,"
                    + " `Departman`, `Prim`, `Mail`,`YoneticiMi`, `Sifre`) VALUES "
                    + "('MertCanDuldul',1001,5000,'Bilgi_Islem','',"
                    + "'mertcanduldul@building.com','1','123456')";
            PersonelGirdisi[1] = "INSERT INTO personel(`AdSoyad`, `SGKNO`, `Maas`,"
                    + " `Departman`, `Prim`, `Mail`,`YoneticiMi`, `Sifre`) VALUES "
                    + "('HarunDogdu',1002,5000,'Bilgi_Islem','',"
                    + "'harundogdu@building.com','0','123456')";
            statements = conn.createStatement();
            for (int i = 0; i < PersonelGirdisi.length; i++) {
                statements.executeUpdate(PersonelGirdisi[i]);
            }
            //DROP DATABASE elements_building
            System.out.println("PERSONEL BILGILERI YUKLENDI ");

            String[] HazirMesajlar = new String[2];
            HazirMesajlar[0] = "INSERT INTO `mesaj` "
                    + "(`Id`,`Yazi`, `GondericiId`, `AliciId`, `CCId`, `Saat`)"
                    + " VALUES ('1','MERHABA_DUNYA', '1', '2', '1', CURRENT_TIME())";
            HazirMesajlar[1] = "INSERT INTO `mesaj` "
                    + "(`Yazi`, `GondericiId`, `AliciId`, `CCId`, `Saat`)"
                    + " VALUES ('MERHABA_EVREN', '2', '1', '1', CURRENT_TIME())";

            for (int i = 0; i < HazirMesajlar.length; i++) {
                statements.executeUpdate(HazirMesajlar[i]);
            }
            System.out.println("SISTEM MESAJLARI EKLENDI");

        } catch (Exception error) {
            error.printStackTrace();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /*
        ACCORDION MENU EKRANI HAREKETLERİ BAŞLANCIG
        
     */
    public void animationCreator() {
        Thread th1 = new Thread() {
            public void run() {
                int index = 0;
                try {
                    while (true) {
                        for (int i = 1450; i > index; i--) {
                            Thread.sleep(3);
                            ag.getCreators().setLocation(10, (i + (-600)));
                            ag.getAdminMert().setLocation(10, (i + (-580)));
                            ag.getAdminMertinfo().setLocation(10, (i + (-330)));
                            ag.getAdminHarun().setLocation(10, (i + (-280)));
                            ag.getAdminHaruninfo().setLocation(10, (i + (-30)));

                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        th1.start();
    }

    /*
        ACCORDION MENU EKRANI HAREKETLERİ BITIS
        
     */
    public void animationCreator2() {
        Thread th1 = new Thread() {
            public void run() {
                int index = 0;
                try {
                    while (true) {
                        for (int i = 1450; i > index; i--) {
                            Thread.sleep(3);
                            ug.getCreators().setLocation(10, (i + (-600)));
                            ug.getAdminMert().setLocation(10, (i + (-580)));
                            ug.getAdminMertinfo().setLocation(10, (i + (-330)));
                            ug.getAdminHarun().setLocation(10, (i + (-280)));
                            ug.getAdminHaruninfo().setLocation(10, (i + (-30)));

                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        };
        th1.start();
    }

//    @Override
//    public void insertUpdate(DocumentEvent e) {
//
//        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        String DB_URL = "jdbc:mysql://localhost/elements_building";
//
//        //  Database credentials
//        String USER = "root";
//        String PASS = "";
//
//        try {
//
//            Connection connection;
//            Statement statement, statement2;
//            ResultSet resultSet, resultSet2;
//            Class.forName(JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, USER, PASS);
//            statement = connection.createStatement();
//            statement2 = connection.createStatement();
//
//            System.out.println("HANGI UI : " + hangiUiAcik);
//            if (hangiUiAcik == 1) {
//                String AliciIdOgrenme = "SELECT * FROM personel where AdSoyad='" + ag.getTextMail().getText() + "'";
//                String BizimIdSql = "SELECT * FROM personel where AdSoyad='" + ag.getLbLUser().getText() + "'";
//
//                resultSet = statement.executeQuery(AliciIdOgrenme);
//                resultSet2 = statement2.executeQuery(BizimIdSql);
//
//                while (resultSet.next() && resultSet2.next()) {
//                    int AliciId = resultSet.getInt("Id");
//                    int BizimId = resultSet2.getInt("Id");
//                    ResultSet resulSet3, resultSet4;
//                    Statement statement3 = connection.createStatement();
//                    Statement statement4 = connection.createStatement();
//
//                    String load = "SELECT * FROM mesaj where GondericiId=" + BizimId + " AND AliciId='" + AliciId + "'";
//                    String load2 = "SELECT * FROM mesaj where AliciId=" + BizimId + " AND GondericiId='" + AliciId + "'";
//                    resulSet3 = statement3.executeQuery(load);
//                    resultSet4 = statement4.executeQuery(load2);
//
//                    if (resulSet3.next() && resultSet4.next()) {
//                        String mesajlar = resulSet3.getString("Yazi");
//                        String mesajlar2 = resultSet4.getString("Yazi");
//                        String icerik = ag.getLbLUser().getText() + ":" + mesajlar + "     ||        " + ag.getTextMail().getText() + ": " + mesajlar2;
//                        ag.getTextMailto().setText(icerik);
//                    }
//                    String GelenKutusu = "SELECT * FROM mesaj JOIN personel on mesaj.AliciId=personel.Id where mesaj.AliciId=" + BizimId;
//                    Statement gelenStatement = connection.createStatement();
//                    ResultSet gelenResultSet = gelenStatement.executeQuery(GelenKutusu);
//                    while (gelenResultSet.next()) {
//                        String a = ag.getJShowAll().getToolTipText();
//                        String kimden = gelenResultSet.getString("AdSoyad");
//                        String yazi = gelenResultSet.getString("Yazi");
//
//                        JOptionPane.showMessageDialog(null, yazi + " ||" + kimden);
//                    }
//
//                }
//
//                return;
//            }
//            if (hangiUiAcik == 0) {
//                String AliciIdOgrenme = "SELECT * FROM personel where AdSoyad='" + ug.getTextMail().getText() + "'";
//                String BizimIdSql = "SELECT * FROM personel where AdSoyad='" + ug.getLbLUser().getText() + "'";
//
//                resultSet = statement.executeQuery(AliciIdOgrenme);
//                resultSet2 = statement2.executeQuery(BizimIdSql);
//
//                while (resultSet.next() && resultSet2.next()) {
//                    int AliciId = resultSet.getInt("Id");
//                    int BizimId = resultSet2.getInt("Id");
//                    ResultSet resulSet3, resultSet4;
//                    Statement statement3 = connection.createStatement();
//                    Statement statement4 = connection.createStatement();
//
//                    String load = "SELECT * FROM mesaj where GondericiId=" + BizimId + " AND AliciId='" + AliciId + "'";
//                    String load2 = "SELECT * FROM mesaj where AliciId=" + BizimId + " AND GondericiId='" + AliciId + "'";
//
//                    resulSet3 = statement3.executeQuery(load);
//                    resultSet4 = statement4.executeQuery(load2);
//
//                    if (resulSet3.next() && resultSet4.next()) {
//                        String mesajlar = resulSet3.getString("Yazi");
//                        String mesajlar2 = resultSet4.getString("Yazi");
//                        String icerik = ug.getLbLUser().getText() + ":" + mesajlar + "     ||        " + ug.getTextMail().getText() + ": " + mesajlar2;
//                        ug.getTextMailto().setText(icerik);
//                    }
//
//                }
//                return;
//            }
//
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//
//    }
}
