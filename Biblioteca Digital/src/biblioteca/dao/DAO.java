package biblioteca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T extends Object> {

    private String url = "";
    private String username = "";
    private String password = "";
    protected Connection con;

    protected void init() throws SQLException {
        this.con = DriverManager.getConnection(url, username, password);
    }

    public abstract T create(T obj);

    public abstract T busca(int numero);

    public abstract void delete(int numero);

    public abstract List<T> buscaTudo();

}
