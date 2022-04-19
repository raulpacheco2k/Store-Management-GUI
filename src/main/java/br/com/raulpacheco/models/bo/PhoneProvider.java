package br.com.raulpacheco.models.bo;

public class PhoneProvider extends Model {
    private String phone;
    private int provider;

    public PhoneProvider() {
        setTable("foneFornecedor");
    }

    public PhoneProvider(String phone, int provider) {
        this.phone = phone;
        this.provider = provider;
        setTable("foneFornecedor");
    }

    public String getPhone() {
        return phone;
    }

    public PhoneProvider setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public int getProvider() {
        return provider;
    }

    public PhoneProvider setProvider(int provider) {
        this.provider = provider;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO " + this.getTable() + " (foneFornecedor, fornecedor_idfornecedor) VALUES (?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT foneFornecedor, fornecedor_idfornecedor FROM " + this.getTable();
    }

    @Override
    public String findById() {
        return "SELECT foneFornecedor, fornecedor_idfornecedor FROM " + this.getTable() + " WHERE foneFornecedor = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT foneFornecedor, fornecedor_idfornecedor FROM " + this.getTable() + " WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + this.getTable() + " SET foneFornecedor = ? WHERE foneFornecedor = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
