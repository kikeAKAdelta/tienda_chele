/*
 **        **   ****   ****  **     **
 ** **  ** **  **  **   **   ** **  **
 **   **   **  ******   **   **   ****
 **        **  **  **  ****  **     **
 */
package facadeshop;

import formularios.frmHome;
import formularios.frmLogin;

/**
 *
 * @author Ricky
 * 
 */
public class Diseño {

    public static String user; // USUARIO A GUARDAR
    public static double Apertura=0;
    public static double Cierre=0;
        
    public static void main(String[] args) {
        frmLogin home = new frmLogin();
        home.setVisible(true);
    }
    
}
