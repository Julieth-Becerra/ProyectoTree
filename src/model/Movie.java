package model;

import java.util.Comparator;

public class Movie {

    private String id, name, duracion, director;
    private static final Comparator<Movie> compId = (((Id1, Id2) -> (Id1.getId().compareTo(Id2.getId()))) );

    public Movie (){}

    public Movie (String id, String name, String duracion, String director){
        this.id = id;
        this.name = name;
        this.duracion = duracion;
        this.director =director;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

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
