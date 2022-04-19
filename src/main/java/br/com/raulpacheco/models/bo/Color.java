package br.com.raulpacheco.models.bo;

public class Color extends Model {
    private int id;
    private String description;

    public Color() {
        setTable("cor");
    }

    public Color(int id, String description) {
        this.id = id;
        this.description = description;
        setTable("cor");
    }

    public int getId() {
        return id;
    }

    public Color setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Color setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO " + this.getTable() + " (descricaoCor) VALUES (?)";
    }

    @Override
    public String findAll() {
        return "SELECT idcor, descricaoCor FROM " + this.getTable();
    }

    @Override
    public String findById() {
        return "SELECT idcor, descricaoCor FROM " + this.getTable() + " WHERE idcor = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idcor, descricaoCor FROM " + this.getTable() + " WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + this.getTable() + " SET descricaoCor = ? WHERE idcor = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
