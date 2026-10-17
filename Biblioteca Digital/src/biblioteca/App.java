package biblioteca;
import biblioteca.dao.*;
import biblioteca.model.*;
import java.sql.Date;

public class App {
    public static void main(String[] args) throws Exception {
        DAO daoLivro = new DaoLivro();
        DAO daoEmprestimo = new DaoEmprestimo();
        Livro l1 = new Livro();
        Livro l2 = new Livro();
        Livro l3 = new Livro();
        
        
        l1.setIdLivro(1);
        l1.setTitulo("Como eu era antes de você");
        l1.setAutor("Jojo Moyes");
        
        l2.setIdLivro(2);
        l2.setTitulo("O diário de um banana");
        l2.setAutor("Jeff Kinney");
        
        l3.setIdLivro(3);
        l3.setTitulo("A culpa é das estrelas");
        l3.setAutor("John Green");

        daoLivro.create(l1);
        daoLivro.create(l2);
        daoLivro.create(l3);

        Emprestimo e1 = new Emprestimo();
        Emprestimo e2 = new Emprestimo();
        Emprestimo e3 = new Emprestimo();
        
        e1.setIdEmprestimo(1);
        e1.setLivro_id(1);
        e1.setData_retirada(Date.valueOf("2026-09-15"));
        
        e2.setIdEmprestimo(2);
        e2.setLivro_id(2);
        e2.setData_retirada(Date.valueOf("2026-09-09"));
        
        e3.setIdEmprestimo(3);
        e3.setLivro_id(1);
        e3.setData_retirada(Date.valueOf("2026-09-20"));

        daoEmprestimo.create(e1);
        daoEmprestimo.create(e2);
        daoEmprestimo.create(e3);
    

        System.out.println("Listando livros:");
        System.out.println(daoLivro.buscaTudo());

        System.out.println("Buscando Livro de id 2");
        System.out.println(daoLivro.busca(2));
        
        System.out.println("Buscando Emprestimo de id 3");
        System.out.println(daoEmprestimo.busca(3));

        System.out.println("Deletando Emprestimo de id 2");
        daoEmprestimo.delete(2);

        System.out.println("Deletando Livro de id 1");
        daoLivro.delete(1);

        System.out.println("Listando livros:");
        System.out.println(daoLivro.buscaTudo());

    }
}
