package biblioteca.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import biblioteca.model.Emprestimo;

public class DaoEmprestimo extends DAO<Emprestimo> {

    @Override
    public Emprestimo create(Emprestimo emprestimo) {
            Emprestimo aux = null;
            try {
                init();
                String sql = "INSERT INTO EMPRESTIMO VALUES (?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql);

                pstmt.setLong(1, emprestimo.getIdEmprestimo());
                pstmt.setLong(2, emprestimo.getLivro_id());
                pstmt.setDate(3, emprestimo.getData_retirada());
                pstmt.executeUpdate();
                
                aux = new Emprestimo();
                aux.setIdEmprestimo(emprestimo.getIdEmprestimo());
                aux.setLivro_id(emprestimo.getLivro_id());
                aux.setData_retirada(emprestimo.getData_retirada());

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    this.con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return aux;
        }

    @Override
    public Emprestimo busca(int numero) {
        Emprestimo aux = null;
        try {
            init();
            String sql = "SELECT * FROM EMPRESTIMO WHERE id= ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, numero);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                aux = new Emprestimo();
                aux.setIdEmprestimo(rs.getInt("id"));
                aux.setLivro_id(rs.getInt("livro_id"));
                aux.setData_retirada(rs.getDate("data_retirada"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                this.con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return aux;
    }

    @Override
    public void delete(int numero) {
        try {
            init();
            String sql = "DELETE FROM EMPRESTIMO WHERE id= ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, numero);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                this.con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Emprestimo> buscaTudo() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        try {
            init();
            String sql = "SELECT * FROM EMPRESTIMO";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(rs.getInt("id"));
                emprestimo.setLivro_id(rs.getInt("livro_id"));
                emprestimo.setData_retirada(rs.getDate("data_retirada"));
                emprestimos.add(emprestimo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                this.con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return emprestimos;
    }
    
}
