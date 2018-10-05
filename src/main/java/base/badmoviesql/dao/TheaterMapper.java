package base.badmoviesql.dao;
import base.badmoviesql.model.Theater;

public interface TheaterMapper {
    Theater getTheater(int ID);
    Theater addTheater(int ID);
    Theater updateTheater(int ID);
    Theater deleteTheater (int ID);
}
