/**
 * Paquete modelo
 */
package model;

import java.util.Comparator;

/**
 * Clase Movie
 */
public class Movie {

    /**
     * Atributos de la clase
     * id de la pelicula
     * Nombre de la pelicula
     * Duracion de la pelicula
     * Director de la pelicula
     */
    private String id, name, duracion, director;

    /**
     * Comparator de la clase
     */
    private static final Comparator<Movie> compId = (((Id1, Id2) -> (Id1.getId().compareTo(Id2.getId()))));

    /**
     * Constructor vacio de la clase
     */
    public Movie (){}

    public Movie (String id){
        this.id = id;
    }

    /**
     * Constructor de la clase donde se inicializan los atributos
     * @param id Id de la pelicula
     * @param name Nombre de la pelicula
     * @param duracion Duracion de la pelicula
     * @param director Director de la pelicula
     */
    public Movie (String id, String name, String duracion, String director){
        this.id = id;
        this.name = name;
        this.duracion = duracion;
        this.director =director;
    }

    /**
     * Metodo para obtener el id de la pelicula
     * @return Id de la pelicula
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo para modificar el id de la pelicula
     * @param id id a modificar
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el nombre de la pelicula
     * @return nombre de la pelicula
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo para modificar el nombre de la pelicula
     * @param name nombre a modificar
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo para obtener la duracion de la pelicula
     * @return duracion de la pelicula
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Metodo para modificar la duracion de la pelicula
     * @param duracion duracion a modificar
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Metodo para obtener el director de la pelicula
     * @return director de la pelicula
     */
    public String getDirector() {
        return director;
    }

    /**
     * Metodo para modificar el director de la pelicula
     * @param director director a modificar
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * toString de la clase
     * @return Informacion que contienen los atributos de la clase
     */
    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duracion='" + duracion + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
