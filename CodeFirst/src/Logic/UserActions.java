package Logic;

import Gui.AdminGui;

import Gui.UserGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserActions implements ActionListener, MouseListener {

    UserGui userGui;
    AdminGui adminGui;
    Actions actions;
    int value = 0;
    int value_ = 0;

    final double openAccordionPanelX = 1085;
    final double closeAccordionPanelX = 1300;

    public UserActions(UserGui userGui) {
        this.userGui = userGui;
    }

    public UserActions(AdminGui adminGui) {
        this.adminGui = adminGui;
    }

    public UserActions(Actions actions) {
        this.actions = actions;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (userGui != null) {
            if (e.getSource() == userGui.getAccordionButton() && userGui.getAccordionButton().isVisible()) {
                userGui.getAccordionButton().setVisible(false);
                accordionPanelAnimation();
                value_++;
                if (value_ == 1) {
                    Actions.Playmp3("src\\Music\\MissBelalım.wav");
                    value_++;
                }

            }
        } else if (adminGui != null) {
            if (e.getSource() == adminGui.getAccordionButton() && adminGui.getAccordionButton().isVisible()) {
                adminGui.getAccordionButton().setVisible(false);
                accordionPanelAnimation();
                value_++;
                if (value_ == 1) {
                    Actions.Playmp3("src\\Music\\MissBelalım.wav");
                    value_++;
                }

            }
        }

    }

    public void accordionPanelAnimation() {
        if (userGui != null) {

            Thread scrollAccordionPanel = new Thread() {
                @Override
                public void run() {

                    if (userGui.getAccordionPanel().getLocation().getX() >= closeAccordionPanelX) {
                        while (userGui.getAccordionPanel().getLocation().getX() >= openAccordionPanelX) {//1300
                            try {
                                Thread.sleep(10);
                                userGui.getAccordionPanel().setLocation((int) (userGui.getAccordionPanel().getLocation().getX() - 10), (int) userGui.getAccordionPanel().getLocation().getY());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(UserActions.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {

                        while (userGui.getAccordionPanel().getLocation().getX() <= closeAccordionPanelX) {
                            try {
                                Thread.sleep(10);
                                userGui.getAccordionPanel().setLocation((int) (userGui.getAccordionPanel().getLocation().getX() + 10), (int) userGui.getAccordionPanel().getLocation().getY());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(UserActions.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    }

                }

            };
            scrollAccordionPanel.start();
        } else if (adminGui != null) {

            Thread scrollAccordionPanel = new Thread() {
                @Override
                public void run() {

                    if (adminGui.getAccordionPanel().getLocation().getX() >= closeAccordionPanelX) {
                        while (adminGui.getAccordionPanel().getLocation().getX() >= openAccordionPanelX) {//1300
                            try {
                                Thread.sleep(10);
                                adminGui.getAccordionPanel().setLocation((int) (adminGui.getAccordionPanel().getLocation().getX() - 10), (int) adminGui.getAccordionPanel().getLocation().getY());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(UserActions.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {

                        while (adminGui.getAccordionPanel().getLocation().getX() <= closeAccordionPanelX) {
                            try {
                                Thread.sleep(10);
                                adminGui.getAccordionPanel().setLocation((int) (adminGui.getAccordionPanel().getLocation().getX() + 10), (int) adminGui.getAccordionPanel().getLocation().getY());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(UserActions.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    }

                }

            };
            scrollAccordionPanel.start();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse click");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("  mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("  mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (adminGui != null) {
            System.out.println("adminGui.getAccordionButton().isVisible()   :" + adminGui.getAccordionButton().isVisible());

            if (e.getSource() == adminGui.getAccordionPanel() && !adminGui.getAccordionButton().isVisible()) {
                accordionPanelAnimation();
                System.out.println("adminGui.getAccordionButton().isVisible()   :" + adminGui.getAccordionButton().isVisible());
                adminGui.getAccordionButton().setVisible(true);
            }
        } else if (userGui != null) {
            System.out.println("userGui.getAccordionButton().isVisible()   :" + userGui.getAccordionButton().isVisible());

            if (e.getSource() == userGui.getAccordionPanel() && !userGui.getAccordionButton().isVisible()) {
                accordionPanelAnimation();
                System.out.println("userGui.getAccordionButton().isVisible()   :" + userGui.getAccordionButton().isVisible());
                userGui.getAccordionButton().setVisible(true);
            }
        }

    }

}
