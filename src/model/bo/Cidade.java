package model.bo;
public class Cidade {
    private int  idCidade;
    private String descricaoCidade;
    private String ufCidade;

    public Cidade() {
    }

    public Cidade(int idCidade, String descricaoCidade, String ufCidade) {
        this.idCidade = idCidade;
        this.descricaoCidade = descricaoCidade;
        this.ufCidade = ufCidade;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getDescricaoCidade() {
        return descricaoCidade;
    }

    public void setDescricaoCidade(String descricaoCidade) {
        this.descricaoCidade = descricaoCidade;
    }

    public String getUfCidade() {
        return ufCidade;
    }

    public void setUfCidade(String ufCidade) {
        this.ufCidade = ufCidade;
    }

    @Override
    public String toString() {
        return this.getIdCidade() + "," + this.getDescricaoCidade() + ","+this.getUfCidade();
    }    
}
