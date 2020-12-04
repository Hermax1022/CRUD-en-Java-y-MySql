
package crud_mvc;

import controlador.ControladorPersona;
import modelo.ConsultasPersonas;
import modelo.Persona;
import vista.VistaPersona;

public class CRUD_MVC {

    public static void main(String[] args) {
        VistaPersona vista = new VistaPersona();
        Persona persona = new Persona();
        ConsultasPersonas modelo = new ConsultasPersonas();
        ControladorPersona controlador = new ControladorPersona(vista, persona, modelo);
        
        controlador.iniciar();
        vista.setVisible(true);
        
    }
    
}
