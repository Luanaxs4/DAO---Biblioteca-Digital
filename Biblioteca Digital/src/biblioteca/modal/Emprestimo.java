package biblioteca.model;

import java.sql.Date;

public class Emprestimo {
    private int idEmprestimo;
    private int livro_id;
    private Date data_retirada;
    public int getIdEmprestimo() {
        return idEmprestimo;
    }
    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
    public int getLivro_id() {
        return livro_id;
    }
    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }
    public Date getData_retirada() {
        return data_retirada;
    }
    public void setData_retirada(Date data_retirada) {
        this.data_retirada = data_retirada;
    }
    @Override
    public String toString() {
        return "[idEmprestimo=" + idEmprestimo + ", livro_id=" + livro_id + ", data_retirada="
                + data_retirada + "]";
    }    
}
