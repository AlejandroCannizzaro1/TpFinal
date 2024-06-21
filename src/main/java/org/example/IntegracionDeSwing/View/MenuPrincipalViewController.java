package org.example.IntegracionDeSwing.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalViewController {
    private MenuPrincipalView menuPrincipalView;

    public MenuPrincipalViewController(MenuPrincipalView menuPrincipalView) {
        this.menuPrincipalView = menuPrincipalView;

        this.menuPrincipalView.addGestionClientesListener(new GestionClientesListener());
        this.menuPrincipalView.addGestionPeliculasListener(new GestionPeliculasListener());
        this.menuPrincipalView.addGestionReservasListener(new GestionReservasListener());
    }

    class GestionClientesListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GestionClientesView gestionClientesView = new GestionClientesView();
            gestionClientesView.setVisible(true);
        }
    }

    class GestionPeliculasListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GestionPeliculasView gestionPeliculasView = new GestionPeliculasView();
            gestionPeliculasView.setVisible(true);
        }
    }



    class GestionReservasListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GestionReservasView gestionReservasView = new GestionReservasView();
            gestionReservasView.setVisible(true);
        }
    }
}
