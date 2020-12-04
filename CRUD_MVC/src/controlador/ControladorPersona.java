
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.ConsultasPersonas;
import modelo.Persona;
import vista.VistaPersona;

public class ControladorPersona implements ActionListener{
    private VistaPersona vista;
    private Persona persona;
    private ConsultasPersonas modelo;

    public ControladorPersona(VistaPersona vista, Persona persona, ConsultasPersonas modelo) {
        this.vista = vista;
        this.persona = persona;
        this.modelo = modelo;
        vista.botonInsertar.addActionListener(this);
        vista.botonLimpiar.addActionListener(this);
        vista.botonBuscar.addActionListener(this);
        vista.botonModificar.addActionListener(this);
        vista.botonEliminar.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("CRUD MVC");
        vista.setLocationRelativeTo(null);
        vista.cajaID.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.botonInsertar){
            persona.setClave(vista.cajaClave.getText());           
            persona.setNombre(vista.cajaNombre.getText());
            persona.setDomicilio(vista.cajaDomicilio.getText());
            persona.setCelular(vista.cajaCelular.getText());
            persona.setCorreo_electronico(vista.cajaCorreoElectronico.getText());
            persona.setFecha_nacimiento(Date.valueOf(vista.cajaFechaNacimiento.getText()));
            persona.setGenero(vista.comboGenero.getSelectedItem().toString());
            
            if(modelo.insertar(persona)){
                JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al ionsertar el registro");
                limpiarCajas();
            }         
         }
            if(ae.getSource() == vista.botonLimpiar){
                limpiarCajas();
        }
            if(ae.getSource() == vista.botonBuscar){
                persona.setClave(vista.cajaBuscar.getText());
                
                if(modelo.buscar(persona)){
                    vista.cajaID.setText(String.valueOf(persona.getIdPersona()));
                    vista.cajaClave.setText(persona.getClave());
                    vista.cajaNombre.setText(persona.getNombre());
                    vista.cajaDomicilio.setText(persona.getDomicilio());
                    vista.cajaCelular.setText(persona.getCelular());
                    vista.cajaCorreoElectronico.setText(persona.getCorreo_electronico());
                    vista.cajaFechaNacimiento.setText(String.valueOf(persona.getFecha_nacimiento()));
                    vista.comboGenero.setSelectedItem(persona.getGenero());
                                        
                }
                else{
                    JOptionPane.showMessageDialog(null, "No existe una persona con esa clave");
                    limpiarCajas();
                }                
            }
            if(ae.getSource() == vista.botonModificar){
                persona.setIdPersona(Integer.parseInt(vista.cajaID.getText()));
                persona.setClave(vista.cajaClave.getText());           
                persona.setNombre(vista.cajaNombre.getText());
                persona.setDomicilio(vista.cajaDomicilio.getText());
                persona.setCelular(vista.cajaCelular.getText());
                persona.setCorreo_electronico(vista.cajaCorreoElectronico.getText());
                persona.setFecha_nacimiento(Date.valueOf(vista.cajaFechaNacimiento.getText()));
                persona.setGenero(vista.comboGenero.getSelectedItem().toString());
                
                if(modelo.modificar(persona)){
                    JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                    limpiarCajas();
                }
                else{
                    JOptionPane.showMessageDialog(null, "RNo se pudo modificar el registro");
                    limpiarCajas();
                }
            }
            if(ae.getSource() == vista.botonEliminar){
                persona.setIdPersona(Integer.parseInt(vista.cajaID.getText()));
                
                if(modelo.eliminar(persona)){
                    JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
                    limpiarCajas();
                }
                else{
                    JOptionPane.showMessageDialog(null, "RNo se pudo eliminar el registro");
                    limpiarCajas();
                }
            }
    }
    
    public void limpiarCajas(){
         vista.cajaID.setText(null);
        vista.cajaBuscar.setText(null);
        vista.cajaClave.setText(null);
        vista.cajaNombre.setText(null);
        vista.cajaDomicilio.setText(null);
        vista.cajaCelular.setText(null);
        vista.cajaCorreoElectronico.setText(null);
        vista.cajaFechaNacimiento.setText(null);
        vista.comboGenero.setSelectedIndex(0);     
        
        
    }
    
}
