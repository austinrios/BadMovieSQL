package base.badmoviesql.model;

public class Theater {
    int id;
    String location;
    int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", number=" + number +
                ", group='" + group + '\'' +
                '}';
    }

    String group;
}
