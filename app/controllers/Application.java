package controllers;

import play.*;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.*;

import java.util.*;

import models.*;
import play.data.validation.Required;

public class Application extends Controller {

    public static void index() {
        List <tareas> tarea=null;
        tarea=tareas.findAll();
        render(tarea);
    }
    public static void Cel() {
        render();
    }
     public static void verTareasCel() {
        List <tareas> tarea=null;
        tarea=tareas.findAll();
        render(tarea);
    }
    public static void verTareas() {
        List <tareas> tarea=null;
        tarea=tareas.findAll();
        render(tarea);
    }

    public static void addMateria(String materia) {
        //Aqui meto solo un dato seleccionado en una variable string o int segun el tipo del dato recibido
        //JPAQuery materiaabuscar= materias.find("select id_materia from materias order by id_materia desc limit 1", null);
        //int prueba=materiaabuscar.first(); 


        if (materia == null || materia.equals("")) {
            render();

        } else {
            //aqui estoy creando una query sql y la guardo en la variable query
            JPAQuery query = materias.find("select nombre_materia from materias");
            String mensaje = "";
            
            //Aqui ejecuto la query y guardo los datos en una lista
       List materiasencontradas = query.fetch();


            if (materiasencontradas.contains(materia)) {
                mensaje = "Lo siento pero esta materia ya existe";
                render(mensaje);
            } else {

                new materias(materia).save();
                mensaje = "Guardada correctamente";
                render(mensaje);
            }
        }
    }
   public static void update(String descripcion,String modificado) {
        //Aqui meto solo un dato seleccionado en una variable string o int segun el tipo del dato recibido
        //JPAQuery materiaabuscar= materias.find("select id_materia from materias order by id_materia desc limit 1", null);
        //int prueba=materiaabuscar.first(); 
 List <tareas> tarea=null;
        tarea=tareas.findAll();

        if (modificado == null || modificado.equals("")) {
           
            render(tarea);

        } else {
            
            tareas t = tareas.find("byDescripcion",descripcion).first();
            t.descripcion=modificado;
            t.save();
            String mensaje = "";
            
                mensaje = "Actualizadamente correctamente";
                render(mensaje,tarea);
            }
        
   }
     public static void addMateriaCel(String materia) {
        //Aqui meto solo un dato seleccionado en una variable string o int segun el tipo del dato recibido
        //JPAQuery materiaabuscar= materias.find("select id_materia from materias order by id_materia desc limit 1", null);
        //int prueba=materiaabuscar.first(); 


        if (materia == null || materia.equals("")) {
            render();

        } else {
            //aqui estoy creando una query sql y la guardo en la variable query
            JPAQuery query = materias.find("select nombre_materia from materias");
            String mensaje = "";
            
            //Aqui ejecuto la query y guardo los datos en una lista
       List materiasencontradas = query.fetch();


            if (materiasencontradas.contains(materia)) {
                mensaje = "Lo siento pero esta materia ya existe";
                render(mensaje);
            } else {

                new materias(materia).save();
                mensaje = "Guardada correctamente";
                render(mensaje);
            }
        }
    }
    
     public static void delete(String mensaje){
          List <tareas> tarea=null;
        tarea=tareas.findAll();
        render(tarea,mensaje);
     }
     
     public static void borrar(String TareaEliminar){
         String mensaje;
         tareas t=tareas.find("byDescripcion", TareaEliminar).first();
                 
                 t.delete();
                 tareas ta=tareas.find("byDescripcion", TareaEliminar).first();
                 if(ta==null || ta.equals("")){
                 mensaje="Eliminado correctamente";
                 }
                 else
                 {
                 mensaje="No se eliminó";
                 }
                 delete(mensaje);
                
  

                 
                 
             }
         
         
    
    public static void addTarea( String materia,String descripcion,String fecha){
        List<materias> listamaterias=null;        
        
        listamaterias=materias.findAll();
        
        if(materia==null || materia.equals("") || descripcion==null || descripcion.equals("") ){
        render(listamaterias);
        }
        else{
      
        
        
        new tareas(materia,descripcion,fecha).save();
        String mensaje="Se guardó correctamente la tarea de la materia " + materia;
        render(mensaje,listamaterias);
        }
        
        
    
    }
    
    
    public static void addTareaCel( String materia,String descripcion,String mes,String dia,String ano){
        List<materias> listamaterias=null;        
        
        listamaterias=materias.findAll();
        
        if(materia==null || materia.equals("") || descripcion==null || descripcion.equals("") ){
        render(listamaterias);
        }
        else{
      
        
        String fecha=dia+"/"+mes+"/"+ano;
        new tareas(materia,descripcion,fecha).save();
        String mensaje="Se guardó correctamente la tarea de la materia " + materia;
        render(mensaje,listamaterias);
        }
        
        
    }
}
