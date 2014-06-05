/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author claudemir
 */
public class MateriaNotaFalta {
    
    private Aluno aluno;
    private Materia materia;
    private Nota nota;
    private Falta falta;
    
    public MateriaNotaFalta(){
        aluno = new Aluno();
        materia = new Materia();
        nota = new Nota();
        falta = new Falta();
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

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Falta getFalta() {
        return falta;
    }

    public void setFalta(Falta falta) {
        this.falta = falta;
    }
    
}
