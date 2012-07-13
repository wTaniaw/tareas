//Desarrollado por Tania Torres     
package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import play.db.jpa.Model;

@Entity
public class tareas extends Model{
    
   // @ManyToOne
   
    
    public String materia,descripcion,fecha;

    public tareas(String materia, String descripcion, String fecha) {
  
        this.materia = materia;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    
    
}
