package entidades;

import java.util.Date;

public class Professor extends Usuario {

    private Date dataAdmissao;
    
    public Professor(){
        this.dataAdmissao = new Date();
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
 
}