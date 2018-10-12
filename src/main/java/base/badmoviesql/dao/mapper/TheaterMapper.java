package base.badmoviesql.dao.mapper;
import base.badmoviesql.model.Theater;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterMapper {
    Theater getTheater(int ID);
    int addTheater(int ID);
    void updateTheater(int ID);
    void deleteTheater (int ID);
}
