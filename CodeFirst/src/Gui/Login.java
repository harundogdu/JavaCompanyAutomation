/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Logic.Actions;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author MERT
 */
public class Login extends JComponent {

    JPanel jp = null;
    JLabel username, password, email, info;
    JCheckBox checkinfo;
    JButton register, login_panel_btn, register_panel_btn;
    JTextField user_text, email_text;
    JPasswordField pass_text;
    JSeparator sep1, sep2, sep3;
    Actions action = new Actions(this);
    LogoGui lg = null;
    UserGui ug;
    AdminGui ag;
    DMainGui dmg;

    public Login() {
        getJp().add(getUsername());
        getJp().add(getPassword());
        getJp().add(getEmail());
        getJp().add(getCheckinfo());
        getJp().add(getInfo());
        getJp().add(getUser_text());
        getJp().add(getPass_text());
        getJp().add(getEmail_text());
        getJp().add(getRegister());
        //getJp().add(getLogin_panel_btn());
        // getJp().add(getRegister_panel_btn());
        getJp().add(getSep1());
        getJp().add(getSep2());
        getJp().add(getSep3());
        getJp().setVisible(false);

    }

    public Login(UserGui ug) {

    }

    public Login(AdminGui ag) {

    }

    public LogoGui getLg() {
        if (lg == null) {
            lg = new LogoGui(this);
        }
        return lg;
    }

    public void setLg(LogoGui lg) {
        this.lg = lg;
    }

    public JPanel getJp() {
        if (jp == null) {
            jp = new JPanel();
            jp.setBounds(0, 0, 500, 800);
            jp.setBackground(new Color(19, 20, 24));
            jp.setLayout(null);
        }
        return jp;
    }

    public void setJp(JPanel jp) {
        this.jp = jp;
    }

    public JLabel getUsername() {
        if (username == null) {
            username = new JLabel();
            username.setText("Username");
            username.setForeground(Color.WHITE);
            username.setBounds(30, 150, 200, 50);
            username.setFont(new Font("", 0, 28));
            username.setLayout(null);
        }
        return username;
    }

    public void setUsername(JLabel username) {
        this.username = username;
    }

    public JLabel getPassword() {
        if (password == null) {
            password = new JLabel();
            password.setText("Password");
            password.setForeground(Color.WHITE);
            password.setBounds(30, 250, 200, 50);
            password.setFont(new Font("", 0, 28));
        }
        return password;
    }

    public void setPassword(JLabel password) {
        this.password = password;
    }

    public JLabel getEmail() {
        if (email == null) {
            email = new JLabel();
            email.setText("Email");
            email.setBounds(30, 350, 200, 50);
            email.setFont(new Font("", 0, 25));
            email.setForeground(Color.WHITE);

        }
        return email;
    }

    public void setEmail(JLabel email) {
        this.email = email;
    }

    public JLabel getInfo() {
        if (info == null) {
            info = new JLabel();
            info.setText("<html><u>Terms and Conditions</u></html>");
            info.setBounds(110, 450, 300, 30);
            info.setFont(new Font("", 0, 20));
            info.setForeground(Color.getHSBColor(0.56f, 0.5f, 0.9f));
        }
        return info;
    }

    public void setInfo(JLabel info) {
        this.info = info;
    }

    public JCheckBox getCheckinfo() {
        if (checkinfo == null) {
            checkinfo = new JCheckBox();
            checkinfo.setText("Agree");
            checkinfo.setFont(new Font("", 0, 20));
            checkinfo.setBackground(getJp().getBackground());
            checkinfo.setForeground(Color.WHITE);
            checkinfo.setFocusable(false);
            checkinfo.setBounds(30, 450, 80, 30);

        }
        return checkinfo;
    }

    public void setCheckinfo(JCheckBox checkinfo) {
        this.checkinfo = checkinfo;
    }

    public JButton getRegister() {
        if (register == null) {
            register = new JButton();
            Icon reg = new ImageIcon("src/Images/register.png");
            register.setIcon(reg);
            register.setBounds(170, 500, 100, 90);
            register.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            register.setBackground(null);
            register.setContentAreaFilled(false);
            register.setOpaque(false);
            register.setBorderPainted(false);
            register.addActionListener(action);

        }
        return register;
    }

    public void setRegister(JButton register) {
        this.register = register;
    }

    public JButton getLogin_panel_btn() {
        if (login_panel_btn == null) {
            login_panel_btn = new JButton();
            login_panel_btn.setBounds(90, 10, 208, 70);
            Icon logico = new ImageIcon("src/Images/register.png");
            login_panel_btn.setIcon(logico);
            login_panel_btn.setBackground(null);
            login_panel_btn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            login_panel_btn.setOpaque(false);
            login_panel_btn.setContentAreaFilled(false);
            login_panel_btn.setBorderPainted(false);
            login_panel_btn.setToolTipText("asfasfasdfsafasfd");
            login_panel_btn.setFocusable(false);

        }
        return login_panel_btn;
    }

    public void setLogin_panel_btn(JButton login_panel_btn) {
        this.login_panel_btn = login_panel_btn;
    }

    public JButton getRegister_panel_btn() {
        if (register_panel_btn == null) {
            register_panel_btn = new JButton();
            register_panel_btn.setBounds(215, 10, 207, 70);
            Icon regico = new ImageIcon("src/Images/singin_top.png");
            register_panel_btn.setIcon(regico);
            register_panel_btn.setBackground(null);
            register_panel_btn.setForeground(null);
            register_panel_btn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            register_panel_btn.setOpaque(false);
            register_panel_btn.setContentAreaFilled(false);
            register_panel_btn.setBorderPainted(false);

        }
        return register_panel_btn;
    }

    public void setRegister_panel_btn(JButton register_panel_btn) {
        this.register_panel_btn = register_panel_btn;
    }

    public JTextField getUser_text() {
        if (user_text == null) {
            user_text = new JTextField();
            user_text.setBounds(30, 200, 300, 30);
            user_text.setText("");
            user_text.setBackground(getJp().getBackground());
            user_text.setForeground(Color.LIGHT_GRAY);
            user_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());// textfield çerçevesini kaldırır
            user_text.setFont(new Font("Tahoma", 0, 20));

        }
        return user_text;
    }

    public void setUser_text(JTextField user_text) {
        this.user_text = user_text;
    }

    public JPasswordField getPass_text() {
        if (pass_text == null) {
            pass_text = new JPasswordField();
            pass_text.setText("");
            pass_text.setBounds(30, 300, 300, 30);
            pass_text.setBackground(getJp().getBackground());
            pass_text.setForeground(Color.LIGHT_GRAY);
            pass_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());// textfield çerçevesini kaldırır
            pass_text.setFont(new Font("Tahoma", 0, 20));

        }
        return pass_text;
    }

    public void setPass_text(JPasswordField pass_text) {
        this.pass_text = pass_text;
    }

    public JTextField getEmail_text() {
        if (email_text == null) {
            email_text = new JTextField();
            email_text.setText("");
            email_text.setBounds(30, 400, 300, 30);
            email_text.setBackground(getJp().getBackground());
            email_text.setForeground(Color.LIGHT_GRAY);
            email_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            email_text.setFont(new Font("Tahoma", 0, 20));

        }
        return email_text;
    }

    public void setEmail_text(JTextField email_text) {
        this.email_text = email_text;
    }

    public JSeparator getSep1() {
        if (sep1 == null) {
            sep1 = new JSeparator();
            sep1.setBounds(30, 230, 350, 10);
        }
        return sep1;
    }

    public void setSep1(JSeparator sep1) {
        this.sep1 = sep1;
    }

    public JSeparator getSep2() {
        if (sep2 == null) {
            sep2 = new JSeparator();
            sep2.setBounds(30, 330, 350, 10);
        }
        return sep2;
    }

    public void setSep2(JSeparator sep2) {
        this.sep2 = sep2;
    }

    public JSeparator getSep3() {
        if (sep3 == null) {
            sep3 = new JSeparator();
            sep3.setBounds(30, 430, 350, 10);
        }
        return sep3;
    }

    public void setSep3(JSeparator sep3) {
        this.sep3 = sep3;
    }

    public DMainGui getDmg() {
        if (dmg == null) {
            dmg = new DMainGui();
        }
        return dmg;
    }

    public void setDmg(DMainGui dmg) {
        this.dmg = dmg;
    }

}
