package base.badmoviesql.dao.mapper;
import base.badmoviesql.model.Showtime;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeMapper {
    Showtime getShowtime(int ID);
    int addShowtime(int ID);
    void updateShowtime(int ID);
    void deleteShowtime (int ID);
}
