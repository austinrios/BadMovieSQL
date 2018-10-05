package base.badmoviesql.model;

import java.sql.Timestamp;

public class Showtime {
    int id;
    int movie_id;
    Timestamp show_time;
    int theater_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public Timestamp getShow_time() {
        return show_time;
    }

    public void setShow_time(Timestamp show_time) {
        this.show_time = show_time;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", show_time=" + show_time +
                ", theater_id=" + theater_id +
                '}';
    }
}
