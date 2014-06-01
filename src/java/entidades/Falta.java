package entidades;

import java.util.Date;

public class Falta {

    private int id;
    private AlunoMateria alunoMateria;

    public AlunoMateria getAlunoMateria() {
        return alunoMateria;
    }

    public void setAlunoMateria(AlunoMateria alunoMateria) {
        this.alunoMateria = alunoMateria;
    }
    
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
