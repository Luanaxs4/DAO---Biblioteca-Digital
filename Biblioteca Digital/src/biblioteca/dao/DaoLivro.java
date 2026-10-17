package biblioteca.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import biblioteca.model.Livro;

public class DaoLivro extends DAO<Livro> {
    
    @Override 
    public Livro create(Livro livro) {
        Livro aux = null;
        try{
            init();
            String sql = "INSERT INTO LIVRO VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setLong(1, livro.getIdLivro());
            pstmt.setString(2, livro.getTitulo());
            pstmt.setString(3, livro.getAutor());
            pstmt.executeUpdate();
            aux = new Livro();
            aux.setIdLivro(livro.getIdLivro());
            aux.setTitulo(livro.getTitulo());
            aux.setAutor(livro.getAutor());

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
    public Livro busca(int numero) {
        Livro retorno = new Livro();
        try {
            init();
            String sql = "SELECT * FROM LIVRO WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, numero);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                retorno.setIdLivro(rs.getInt("id"));
                retorno.setTitulo(rs.getString("titulo"));
                retorno.setAutor(rs.getString("autor"));
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
        return retorno;
    }


    @Override
    public void delete(int numero) {
        try {
            init();
            String sqlDeleteEmprestimos = "DELETE FROM EMPRESTIMO WHERE livro_id = ?";
            PreparedStatement pstmtEmp = con.prepareStatement(sqlDeleteEmprestimos);
            pstmtEmp.setLong(1, numero);
            pstmtEmp.executeUpdate();
            
            String sql = "DELETE FROM LIVRO WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, numero);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<Livro> buscaTudo() {
        List<Livro> livros = new ArrayList<>();
        try {
            init();
            String sql = "SELECT * FROM LIVRO";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livros.add(livro);
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
        return livros;
    }

}