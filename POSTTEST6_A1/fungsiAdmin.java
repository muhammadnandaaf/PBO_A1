import java.io.IOException;

public interface fungsiAdmin {
    void menu() throws IOException;
    void create() throws IOException;
    void read() throws IOException;
    void update() throws IOException;
    void delete() throws IOException;
}
