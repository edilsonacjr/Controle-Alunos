/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author edilson
 */
public class AlunoMateria {
    private int id;
    private Aluno aluno;
    private Materia materia;
            
    public AlunoMateria(){
        this.aluno = new Aluno();
        this.materia = new Materia();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    
    
}
