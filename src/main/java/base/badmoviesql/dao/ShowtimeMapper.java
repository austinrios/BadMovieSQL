package base.badmoviesql.dao;
import base.badmoviesql.model.Showtime;

public interface ShowtimeMapper {
    Showtime getShowtime(int ID);
    Showtime addShowtime(int ID);
    Showtime updateShowtime(int ID);
    Showtime deleteShowtime (int ID);
}
