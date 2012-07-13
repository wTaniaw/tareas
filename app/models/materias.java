//Desarrollado por Tania Torres

package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class materias extends Model{
  
    public String nombre_materia;

    
    public materias(String nombre_materia) {
  
        this.nombre_materia = nombre_materia;
    }
    
    
    
    
}
