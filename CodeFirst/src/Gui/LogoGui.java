
package Gui;

import Logic.Actions;
import java.awt.Font;
import javafx.scene.paint.Color;
import javax.swing.*;

public class LogoGui {

    JPanel jp = null;
    JLabel logo = null;
    Actions mouse_listener = new Actions(this);
    Login login = null;
    JLabel infotext = null;

    public LogoGui(Login login) {
        getJp().add(getInfotext());
        getJp().add(getLogo());
        
        getJp().setVisible(true);
        
        this.login = login;
    }

    public JLabel getInfotext() {
        if (infotext == null) {
            infotext = new JLabel();
            infotext.setBounds(250, 480, 500, 200);
            infotext.setBackground(java.awt.Color.LIGHT_GRAY);
            infotext.setForeground(new java.awt.Color(11,30,37));
            infotext.setFont(new Font("Myriad Pro Cond",Font.BOLD,28));
            infotext.setText("GİRİS YAPMAK ICIN TIKLAYINIZ");
        }
        return infotext;
    }

    public void setInfotext(JLabel infotext) {
        this.infotext = infotext;
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

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setBounds(0, 0, 800, 800);
            jp.setLayout(null);

        }
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public JLabel getLogo() {
        if (logo == null) {
            logo = new JLabel();
            logo.setBounds(0, 0, 800, 800);
            Icon logoicon = new ImageIcon("src/Images/building_element.jpg");
            logo.setIcon(logoicon);
            logo.addMouseListener(mouse_listener);
        }
        return logo;
    }

    public void setLogo(JLabel logo) {
        this.logo = logo;
    }
}
