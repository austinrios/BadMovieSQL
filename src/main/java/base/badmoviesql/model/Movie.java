package base.badmoviesql.model;

import sun.util.calendar.LocalGregorianCalendar;

public class Movie {
    int id;
    String title;
    int director_id;
    int run_time;
    LocalGregorianCalendar.Date release_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public int getRun_time() {
        return run_time;
    }

    public void setRun_time(int run_time) {
        this.run_time = run_time;
    }

    public LocalGregorianCalendar.Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalGregorianCalendar.Date release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director_id=" + director_id +
                ", run_time=" + run_time +
                ", release_date=" + release_date +
                '}';
    }
}
