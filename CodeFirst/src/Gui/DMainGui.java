package Gui;

import Logic.Actions;
import java.awt.Color;
import javax.swing.*;

public class DMainGui {

    JFrame jf = null;
    JPanel jp = null;
    LogoGui lg = null;
    Login login = null;
    UserGui ug;
    AdminGui ag;
    Actions a = new Actions(this);

    public DMainGui() {

        // getJp().setBackground(Color.ORANGE);
        getJp().add(getLg().getJp());
        getJp().add(getLogin().getJp());
        getJf().add(getJp());
        // Actions.Playmp3("src\\Music\\MissBelalım.wav");
        //Actions.Playmp3("src\\Music\\Rumba.wav");
        getJf().setVisible(true);

    }

    public LogoGui getLg() {
        if (lg == null) {
            lg = new LogoGui(getLogin());
        }
        return lg;
    }

    public void setLg(LogoGui lg) {
        this.lg = lg;
    }

    public JFrame getJf() {
        if (jf == null) {
            jf = new JFrame("MERT || HARUN");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLocation(250, 170);
            jf.setSize(1315, 800);
            jf.setUndecorated(true);

        }
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setBounds(0, 0, 1600, 800);
            jp.setLayout(null);
        }
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public Login getLogin() {
        if (login == null) {
            login = new Login();
            login.setDmg(this);

        }
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
