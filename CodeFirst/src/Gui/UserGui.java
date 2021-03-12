package Gui;

import Logic.Actions;
import Logic.UserActions;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;

public class UserGui {

    JFrame UserFrame;
    JPanel UserPanel;
    JPanel jProfil;
    JPanel JMail;
    JPanel JMessageBox;
    JPanel JShowAll;
    JLabel LbLUser;
    JLabel LblIcon;
    JLabel labeluserName;
    JLabel labelEMail;
    JLabel labelPassword;
    JLabel labelSgkNo;
    JLabel labelChapter;
    JLabel labelPrice;
    JLabel lblMessageMail;
    JLabel labelUser;
    JLabel systemDate;
    JLabel systemTime;
    JLabel adminMert;
    JLabel adminHarun;
    JLabel adminMertinfo;
    JLabel adminHaruninfo;
    JLabel creators;
    JLabel gelenkutusu;
    JTabbedPane jtp;
    JButton accordionButton;
    JButton btnSendMail;
    JButton Buyut;
    JButton Kucult;
    JButton Temizle;
    JButton FontBuyut;
    JButton FontKucult;
    JButton Gonder;
    JButton accordionLogout;
    JButton UserControl;
    JTextField textMail;
    JTextField textMailto;
    JTextArea MetinAlani = new JTextArea();
    Font FontJPofile = new Font("Verdana", Font.ITALIC, 16);
    JTextArea textUserMail;
    JScrollPane Kaydirac;
    GraphicsEnvironment GrafikNesneleri = GraphicsEnvironment.getLocalGraphicsEnvironment();
    JComboBox FontListeKutusu;
    JPanel accordionPanel;
    UserActions userAction = new UserActions(this);
    Actions actions = new Actions(this);
    Login login;

    Cursor cursorPointer = new Cursor(12);

    //
    private int FontBoy = 12;
    private String FontAdi = "Verdana";
    //

    public UserGui(Login login) {
        this.login = login;

        getUserFrame().add(getUserPanel());
        getUserPanel().add(getLbLUser());
        getUserPanel().add(getLblIcon());
        getUserPanel().add(getJtp());
        getUserPanel().add(getAccordionButton());
        getUserPanel().add(getAccordionPanel()); //ACCORDION
        getUserPanel().add(getSystemDate());
        getUserPanel().add(getSystemTime());
        getUserPanel().add(getAccordionLogout());

        getjProfil().add(getLabeluserName());
        getjProfil().add(getLabelPassword());
        getjProfil().add(getLabelEMail());
        getjProfil().add(getLabelChapter());
        getjProfil().add(getLabelPrice());
        getjProfil().add(getLabelSgkNo());
        /*  getJMail().add(getLblMessageMail());
        
        getJMail().add(getBtnSendMail());
         */
        getJMail().add(getBuyut());
        //getJMail().add(getMetinAlani());
        //getMetinAlani().add(getKaydirac());
        getJMail().add(getKucult());
        getJMail().add(getFontBuyut());
        getJMail().add(getFontKucult());
        getJMail().add(getFontListeKutusu());
        getJMail().add(getTemizle());
        getJMail().add(getTextUserMail());
        getJMail().add(getGonder());
        getJMail().add(getLabelUser());
        getJMail().add(getTextMail());
        getJMail().add(getTextMailto());
        getJMail().add(getUserControl());

        getAccordionPanel().add(getAdminMert());
        getAccordionPanel().add(getAdminHarun());
        getAccordionPanel().add(getAdminMertinfo());
        getAccordionPanel().add(getAdminHaruninfo());
        getAccordionPanel().add(getCreators());

        //getTextUserMail().add(getKaydirac()); güzel olmadı gibi ha ?
        getJMessageBox().add(getGelenkutusu());
        getUserFrame().setVisible(true);

    }

    public JFrame getUserFrame() {
        if (UserFrame == null) {
            UserFrame = new JFrame();
            UserFrame.setBounds(250, 170, 1315, 800);
            UserFrame.setUndecorated(true);

        }
        return UserFrame;
    }

    public void setUserFrame(JFrame UserFrame) {
        this.UserFrame = UserFrame;
    }

    public JPanel getUserPanel() {
        if (UserPanel == null) {
            UserPanel = new JPanel();
            UserPanel.setBounds(getUserFrame().getBounds());

            UserPanel.setBackground(new Color(74, 20, 140));
            //.setBackground(new Color(0,0,0,200));

            UserPanel.setLayout(null);
        }
        return UserPanel;
    }

    public void setUserPanel(JPanel UserPanel) {
        this.UserPanel = UserPanel;
    }

    public Login getLogin() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public JLabel getLbLUser() {
        if (LbLUser == null) {
            LbLUser = new JLabel();
            LbLUser.setFont(new Font("Verdana", Font.BOLD, 20));
            LbLUser.setForeground(Color.WHITE);
            LbLUser.setBounds(150, 100, 350, 80);
            Icon iconOnliner = new ImageIcon("src/Images/online16px.png");
            LbLUser.setIcon(iconOnliner);
            LbLUser.setText(getLogin().getUser_text().getText());

        }
        return LbLUser;
    }

    public void setLbLUser(JLabel LbLUser) {
        this.LbLUser = LbLUser;
    }

    public JLabel getLblIcon() {
        if (LblIcon == null) {
            LblIcon = new JLabel();

            LblIcon.setBackground(Color.yellow);
            Icon iconUser = new ImageIcon("src/Images/user128px2.png");
            LblIcon.setIcon(iconUser);
            LblIcon.setBounds(10, 10, 256, 256);

        }
        return LblIcon;
    }

    public void setLblIcon(JLabel LblIcon) {
        this.LblIcon = LblIcon;
    }

    public JPanel getjProfil() {
        if (jProfil == null) {
            jProfil = new JPanel();

            jProfil.setForeground(Color.WHITE);
            jProfil.setBackground(new Color(0, 150, 136));
            jProfil.setBorder(BorderFactory.createLineBorder(Color.yellow, 0));
            jProfil.setLayout(null);

        }
        return jProfil;
    }

    public void setjProfil(JPanel jProfil) {
        this.jProfil = jProfil;
    }

    public JPanel getJMail() {
        if (JMail == null) {
            JMail = new JPanel();

            JMail.setForeground(Color.WHITE);
            JMail.setBackground(new Color(0, 150, 136));
            JMail.setBorder(BorderFactory.createLineBorder(Color.yellow, 0));

            JMail.setLayout(null);
        }
        return JMail;
    }

    public void setJMail(JPanel JMail) {
        this.JMail = JMail;
    }

    public JPanel getJMessageBox() {
        if (JMessageBox == null) {
            JMessageBox = new JPanel();

            JMessageBox.setForeground(Color.WHITE);
            JMessageBox.setBackground(new Color(0, 150, 136));
            JMessageBox.setBorder(BorderFactory.createLineBorder(Color.yellow, 0));
            JMessageBox.setLayout(null);

        }
        return JMessageBox;
    }

    public void setJMessageBox(JPanel JMessageBox) {
        this.JMessageBox = JMessageBox;
    }

    public JTabbedPane getJtp() {
        if (jtp == null) {
            jtp = new JTabbedPane();
            jtp.setBounds(270, 180, 800, 500);
            Icon iconProfile = new ImageIcon("src/Images/profile24px.png");
            jtp.addTab("PROFIL", iconProfile, getjProfil(), "Profil Menüsü İşlemleri");
            Icon iconMail = new ImageIcon("src/Images/email24px.png");
            jtp.addTab("MAIL", iconMail, getJMail(), "Mail Menüsü işlemleri");
            Icon iconMeeting = new ImageIcon("src/Images/meeting24px.png");
            jtp.addTab("GELEN KUTUSU", iconMeeting, getJMessageBox(), "Gelen Kutusu Menüsü İşlemleri");
            jtp.setFont(new Font("verdana", Font.BOLD, 24));
            jtp.setBorder(BorderFactory.createLineBorder(Color.yellow, 0));
            jtp.setForeground(new Color(0, 165, 245));

        }
        return jtp;
    }

    public void setJtp(JTabbedPane jtp) {
        this.jtp = jtp;
    }

    public JButton getAccordionButton() {
        if (accordionButton == null) {
            accordionButton = new JButton();
            accordionButton.setBounds(1231, 72, 64, 64);
            accordionButton.setIcon(new ImageIcon("src/Images/menu64px.png"));
            accordionButton.setBackground(new Color(74, 20, 140));
            //.setBackground(new Color(18, 203, 196));
            accordionButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 0));
            accordionButton.addActionListener(userAction);
            accordionButton.setCursor(new Cursor(12));
        }
        return accordionButton;
    }

    public void setAccordionButton(JButton accordionButton) {
        this.accordionButton = accordionButton;
    }

    public JLabel getLabeluserName() {
        if (labeluserName == null) {
            labeluserName = new JLabel();

            labeluserName.setText("Kullanıcı Adı            : " + getLogin().getUser_text().getText());
            labeluserName.setBounds(35, 45, 400, 20);
            labeluserName.setFont(FontJPofile);
            labeluserName.setForeground(Color.WHITE);

        }
        return labeluserName;
    }

    public void setLabeluserName(JLabel labeluserName) {
        this.labeluserName = labeluserName;
    }

    public JLabel getLabelEMail() {
        if (labelEMail == null) {
            labelEMail = new JLabel();

            labelEMail.setText("Kullanıcı EMail         : " + getLogin().getEmail_text().getText());
            labelEMail.setBounds(35, 90, 600, 20);
            labelEMail.setFont(FontJPofile);
            labelEMail.setForeground(Color.WHITE);
        }
        return labelEMail;
    }

    public void setLabelEMail(JLabel labelEMail) {
        this.labelEMail = labelEMail;
    }

    public JLabel getLabelPassword() {
        if (labelPassword == null) {
            labelPassword = new JLabel();

            labelPassword.setText("Kullanıcı Şifre          : " + "' " + (String.valueOf(getLogin().getPass_text().getPassword())) + " '");
            labelPassword.setBounds(35, 135, 400, 20);
            labelPassword.setFont(FontJPofile);
            labelPassword.setForeground(Color.WHITE);

        }
        return labelPassword;
    }

    public void setLabelPassword(JLabel labelPassword) {
        this.labelPassword = labelPassword;
    }

    public JLabel getLabelSgkNo() {
        if (labelSgkNo == null) {
            labelSgkNo = new JLabel();
            labelSgkNo.setBounds(35, 180, 400, 20);
            labelSgkNo.setFont(FontJPofile);
            labelSgkNo.setForeground(Color.WHITE);

            ////////////////////YÜKLEME FONKSİYONLARI ////////////////
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost/elements_building";

            //Database kullanıcı adı ve şifresi
            String USER = "root";
            String PASS = "";
            Connection conn;
            ResultSet rs;
            String login_words = "SELECT * FROM PERSONEL WHERE AdSoyad='" + getLogin().getUser_text().getText() + "' AND " + "Sifre='" + String.valueOf(getLogin().getPass_text().getPassword()) + "' AND Mail='" + getLogin().getEmail_text().getText() + "'";

            try {
                //JDBC Driverina kayıt başvuru
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement ps;
                ps = conn.prepareStatement(login_words);
                rs = ps.executeQuery();
                while (rs.next()) {

                    // VERI CEKME KISMI //
                    int SGKNO = rs.getInt("SGKNO");
                    String DEPARTMAN = rs.getString("Departman");
                    int MAAS = rs.getInt("Maas");
                    //ATAMALARIN YAPILDIGI KISIM //
                    // DIGER KOMPONENTELERE ERISIM KISMI//
                    labelSgkNo.setText("Kullanıcı SGKNO      :" + SGKNO);
                    labelChapter.setText("Kullanıcı Bölüm       :" + DEPARTMAN);
                    labelPrice.setText("Kullanıcı Maaş        :" + MAAS);
                }

            } catch (Exception ex) {
                ex.printStackTrace();

            }
/////////////////////////////////// FONKSIYON BITIS ///////////////////////////////////////

        }
        return labelSgkNo;
    }

    public void setLabelSgkNo(JLabel labelSgkNo) {
        this.labelSgkNo = labelSgkNo;
    }

    public JLabel getGelenkutusu() {
        if (gelenkutusu == null) {
            gelenkutusu = new JLabel();
            gelenkutusu.setBackground(Color.red);
            gelenkutusu.setBounds(10, 10, 777, 200);
            gelenkutusu.setText("");
            gelenkutusu.setForeground(Color.WHITE);
        }
        return gelenkutusu;
    }

    public void setGelenkutusu(JLabel gelenkutusu) {
        this.gelenkutusu = gelenkutusu;
    }

    public JLabel getLabelChapter() {
        if (labelChapter == null) {
            labelChapter = new JLabel();

            labelChapter.setBounds(35, 225, 400, 20);
            labelChapter.setFont(FontJPofile);
            labelChapter.setForeground(Color.WHITE);

        }
        return labelChapter;
    }

    public void setLabelChapter(JLabel labelChapter) {
        this.labelChapter = labelChapter;
    }

    public JLabel getLabelPrice() {
        if (labelPrice == null) {
            labelPrice = new JLabel();

            labelPrice.setBounds(35, 270, 400, 20);
            labelPrice.setFont(FontJPofile);
            labelPrice.setForeground(Color.WHITE);

        }
        return labelPrice;
    }

    public void setLabelPrice(JLabel labelPrice) {

        this.labelPrice = labelPrice;
    }

    public JLabel getLblMessageMail() {
        if (lblMessageMail == null) {
            lblMessageMail = new JLabel();
            lblMessageMail.setBounds(15, 15, 150, 30);
            lblMessageMail.setText("E Mail Gönderimi");
            lblMessageMail.setFont(FontJPofile);
            lblMessageMail.setForeground(Color.WHITE);

        }
        return lblMessageMail;
    }

    public void setLblMessageMail(JLabel lblMessageMail) {
        this.lblMessageMail = lblMessageMail;
    }

    public JButton getBtnSendMail() {
        if (btnSendMail == null) {
            btnSendMail = new JButton();

        }
        return btnSendMail;
    }

    public void setBtnSendMail(JButton btnSendMail) {
        this.btnSendMail = btnSendMail;
    }

    public JTextArea getTextUserMail() {
        if (textUserMail == null) {
            textUserMail = new JTextArea();

            textUserMail.setBounds(15, 235, 735, 180);
            textUserMail.setBackground(Color.WHITE);
            textUserMail.setWrapStyleWord(true); //kelimeden sonra satir sonu yapmasi icin
            textUserMail.setLineWrap(true); //satir sonu bir alta almak icin
            textUserMail.setBorder(BorderFactory.createLineBorder(null, 0));
            textUserMail.setBorder(BorderFactory.createEmptyBorder(getFontBoy(), getFontBoy(), getFontBoy(), getFontBoy()));
            textUserMail.setToolTipText("Mesajınızı Giriniz...");

        }
        return textUserMail;
    }

    public void setTextUserMail(JTextArea textUserMail) {
        this.textUserMail = textUserMail;
    }

    public JButton getBuyut() {
        if (Buyut == null) {
            Buyut = new JButton("Büyük Harfler");

            Buyut.setLocation(600, 70);
            Buyut.setSize(150, 20);
            //Dugme uzerindeki metinin boyutunu ayarlar
            Buyut.setFont(new Font("Verdana", Font.PLAIN, 9));
            Buyut.setFocusable(false);
            Buyut.addActionListener(actions);

        }
        return Buyut;
    }

    public void setBuyut(JButton Buyut) {
        this.Buyut = Buyut;
    }

    public JButton getKucult() {
        if (Kucult == null) {
            Kucult = new JButton("Küçük Harfler");

            Kucult.setLocation(600, 40);
            Kucult.setSize(150, 20);
            //Dugme uzerindeki metinin boyutunu ayarlar
            Kucult.setFont(new Font("Verdana", Font.PLAIN, 9));
            Kucult.setFocusable(false);
            Kucult.addActionListener(actions);

        }
        return Kucult;
    }

    public void setKucult(JButton Kucult) {
        this.Kucult = Kucult;
    }

    public JButton getTemizle() {
        if (Temizle == null) {
            Temizle = new JButton("Temizle");

            Temizle.setLocation(600, 160);
            Temizle.setSize(150, 20);
            Temizle.setFont(new Font("Verdana", Font.PLAIN, 9));
            Temizle.setFocusable(false);
            Temizle.addActionListener(actions);

        }
        return Temizle;
    }

    public void setTemizle(JButton Temizle) {
        this.Temizle = Temizle;
    }

    public JButton getFontBuyut() {
        if (FontBuyut == null) {
            FontBuyut = new JButton("Font Büyüt");

            FontBuyut.setLocation(600, 130);
            FontBuyut.setSize(150, 20);
            //Dugme uzerindeki metinin boyutunu ayarlar
            FontBuyut.setFont(new Font("Verdana", Font.PLAIN, 9));
            FontBuyut.setFocusable(false);
            FontBuyut.addActionListener(actions);

        }
        return FontBuyut;
    }

    public void setFontBuyut(JButton FontBuyut) {
        this.FontBuyut = FontBuyut;
    }

    public JButton getFontKucult() {
        if (FontKucult == null) {
            FontKucult = new JButton("Font Küçült");

            FontKucult.setLocation(600, 100);
            FontKucult.setSize(150, 20);
            //Dugme uzerindeki metinin boyutunu ayarlar
            FontKucult.setFont(new Font("Verdana", Font.PLAIN, 9));
            FontKucult.setFocusable(false);
            FontKucult.addActionListener(actions);

        }
        return FontKucult;
    }

    public void setFontKucult(JButton FontKucult) {
        this.FontKucult = FontKucult;
    }

    public JComboBox getFontListeKutusu() {
        if (FontListeKutusu == null) {
            String FontListesi[] = GrafikNesneleri.getAvailableFontFamilyNames();
            FontListeKutusu = new JComboBox(FontListesi);

            FontListeKutusu.setLocation(600, 10);
            FontListeKutusu.setSize(150, 20);
            FontListeKutusu.addActionListener(actions);

        }
        return FontListeKutusu;
    }

    public void setFontListeKutusu(JComboBox FontListeKutusu) {
        this.FontListeKutusu = FontListeKutusu;
    }

    public JButton getGonder() {
        if (Gonder == null) {
            Gonder = new JButton("Gönder");

            Gonder.setLocation(600, 190);
            Gonder.setSize(150, 20);
            Gonder.setFocusable(false);
            Gonder.addActionListener(actions);
        }
        return Gonder;
    }

    public void setGonder(JButton Gonder) {
        this.Gonder = Gonder;
    }

    public int getFontBoy() {
        return FontBoy;
    }

    public void setFontBoy(int FontBoy) {
        this.FontBoy = FontBoy;
    }

    public String getFontAdi() {
        return FontAdi;
    }

    public void setFontAdi(String FontAdi) {
        this.FontAdi = FontAdi;
    }

    public JPanel getAccordionPanel() {
        if (accordionPanel == null) {
            accordionPanel = new JPanel();
            accordionPanel.setBounds(1300, 0, 225, 800);
            //            UserFrame.setBounds(0, 0, 1315, 800);
            accordionPanel.setBackground(new Color(236, 64, 122));
            accordionPanel.setLayout(null);
            accordionPanel.addMouseListener(userAction);

        }
        return accordionPanel;
    }

    public void setAccordionPanel(JPanel accordionPanel) {
        this.accordionPanel = accordionPanel;
    }

    public JLabel getLabelUser() {
        if (labelUser == null) {
            labelUser = new JLabel();

            labelUser.setBounds(10, 10, 100, 30);
            labelUser.setText("Kime : ");
            labelUser.setFont(FontJPofile);
            labelUser.setForeground(Color.WHITE);

            labelUser.setLayout(null);
        }
        return labelUser;
    }

    public void setLabelUser(JLabel labelUser) {
        this.labelUser = labelUser;
    }

    public JTextField getTextMail() {
        if (textMail == null) {
            textMail = new JTextField();

            textMail.setBounds(80, 10, 350, 40);
            textMail.setText("");
            textMail.setFont(FontJPofile);
            textMail.setBorder(BorderFactory.createLineBorder(Color.yellow, 0));
            textMail.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            //textMail.getDocument().addDocumentListener((DocumentListener) actions);
            //textMail.setFocusable(true);

        }
        return textMail;
    }

    public JButton getUserControl() {
        if (UserControl == null) {
            UserControl = new JButton();
            UserControl.setBounds(460, 10, 40, 40);
            UserControl.setBackground(new Color(getJMail().getBackground().getRGB()));
            Icon usercontrolicon = new ImageIcon("src/Images/checkbox.png");
            UserControl.setIcon(usercontrolicon);
            UserControl.addActionListener(actions);
            UserControl.setContentAreaFilled(false);

        }
        return UserControl;
    }

    public void setUserControl(JButton UserControl) {
        this.UserControl = UserControl;
    }

    public void setTextMail(JTextField textMail) {
        this.textMail = textMail;
    }

    public JTextField getTextMailto() {
        if (textMailto == null) {
            textMailto = new JTextField();

            textMailto.setBounds(15, 70, 555, 150);
            textMailto.setText("");
            textMailto.setFont(FontJPofile);
            textMailto.setBorder(BorderFactory.createLineBorder(Color.yellow, 0));
            textMailto.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            textMailto.setFocusable(false);
            textMailto.setCursor(new Cursor(13));

        }
        return textMailto;
    }

    public void setTextMailto(JTextField textMailto) {
        this.textMailto = textMailto;
    }

    public JLabel getSystemDate() {
        if (systemDate == null) {
            systemDate = new JLabel();

            systemDate.setBounds(10, 250, 250, 30);

            LocalDate localDate = LocalDate.now();

            systemDate.setText("Tarih : " + localDate);
            // systemDate.setText("Saat :" + timePoint.getHour() + ":" + timePoint.getMinute()+"");
            systemDate.setFont(FontJPofile);
            systemDate.setForeground(Color.white);

        }
        return systemDate;
    }

    public void setSystemDate(JLabel systemDate) {
        this.systemDate = systemDate;
    }

    public JLabel getSystemTime() {
        if (systemTime == null) {
            systemTime = new JLabel();
            LocalTime localTime = LocalTime.now();

            int localtimeHour = (localTime.getHour());
            int localtimeMinute = localTime.getMinute();

            systemTime.setBounds(10, 280, 250, 30);
            systemTime.setText("Saat : " + localtimeHour / 10 + "" + localtimeHour % 10 + ":" + localtimeMinute / 10 + "" + localtimeMinute % 10);
            systemTime.setFont(FontJPofile);
            systemTime.setForeground(Color.white);

        }
        return systemTime;
    }

    public void setSystemTime(JLabel systemTime) {
        this.systemTime = systemTime;
    }

    public JButton getAccordionLogout() {
        if (accordionLogout == null) {
            accordionLogout = new JButton();

            Icon iconAccordionLogout = new ImageIcon("src/Images/exit128.png");
            accordionLogout.setIcon(iconAccordionLogout);
            accordionLogout.setBackground(new Color(74, 20, 140));
            accordionLogout.setBounds(10, 500, 128, 128);
            accordionLogout.setCursor(cursorPointer);
            accordionLogout.addActionListener(actions);

        }
        return accordionLogout;
    }

    public void setAccordionLogout(JButton accordionLogout) {
        this.accordionLogout = accordionLogout;
    }

    public JLabel getAdminMert() {
        if (adminMert == null) {
            adminMert = new JLabel();

            adminMert.setSize(160, 260);
            // adminMert.setLocation(10, 60);
            Icon iconMert = new ImageIcon("src/Images/mertlogo.png");
            adminMert.setIcon(iconMert);
        }
        return adminMert;
    }

    public void setAdminMert(JLabel adminMert) {
        this.adminMert = adminMert;
    }

    public JLabel getAdminHarun() {
        if (adminHarun == null) {
            adminHarun = new JLabel();

            adminHarun.setSize(160, 260);
            // adminHarun.setLocation(10, 360);
            Icon iconHarun = new ImageIcon("src/Images/harunlogo.png");
            adminHarun.setIcon(iconHarun);
        }
        return adminHarun;
    }

    public void setAdminHarun(JLabel adminHarun) {
        this.adminHarun = adminHarun;
    }

    public JLabel getAdminMertinfo() {
        if (adminMertinfo == null) {
            adminMertinfo = new JLabel();

            adminMertinfo.setSize(200, 50);
            // adminMertinfo.setLocation(10, 310);
            adminMertinfo.setText("Mert Can Düldül 369556");
            adminMertinfo.setFont(FontJPofile);
            adminMertinfo.setForeground(Color.BLACK);

        }
        return adminMertinfo;
    }

    public void setAdminMertinfo(JLabel adminMertinfo) {
        this.adminMertinfo = adminMertinfo;
    }

    public JLabel getAdminHaruninfo() {
        if (adminHaruninfo == null) {
            adminHaruninfo = new JLabel();

            adminHaruninfo.setSize(200, 50);
            // adminHaruninfo.setLocation(10, 610);
            adminHaruninfo.setText("Harun Doğdu 369566");
            adminHaruninfo.setFont(FontJPofile);
            adminHaruninfo.setForeground(Color.BLACK);

        }
        return adminHaruninfo;
    }

    public void setAdminHaruninfo(JLabel adminHaruninfo) {
        this.adminHaruninfo = adminHaruninfo;
    }

    public JLabel getCreators() {
        if (creators == null) {
            creators = new JLabel();

            creators.setSize(200, 40);
            //creators.setLocation(10, 40);
            creators.setText("Yapımcılar...");
            creators.setFont(FontJPofile);
            creators.setForeground(Color.BLACK);

        }
        return creators;
    }

    public void setCreators(JLabel creators) {
        this.creators = creators;
    }

}
