/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package model.bo;

public class Seller extends Model {
    private int id;
    private String name;
    private String cpf;
    private String email;
    private String phone1;
    private String phone2;
    private float salesCommissionPercentage;
    private float paymentCommissionPercentage;
    private String completeAddress;
    private int address_id;

    public Seller() {
        setTable("vendedor");
    }

    public Seller(int id, String name, String cpf, String email, String phone1, String phone2, float salesCommissionPercentage, float paymentCommissionPercentage, String completeAddress, int address_id) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.salesCommissionPercentage = salesCommissionPercentage;
        this.paymentCommissionPercentage = paymentCommissionPercentage;
        this.completeAddress = completeAddress;
        this.address_id = address_id;
        setTable("vendedor");
    }

    public int getId() {
        return id;
    }

    public Seller setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Seller setName(String name) {
        this.name = name;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Seller setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Seller setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone1() {
        return phone1;
    }

    public Seller setPhone1(String phone1) {
        this.phone1 = phone1;
        return this;
    }

    public String getPhone2() {
        return phone2;
    }

    public Seller setPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public float getSalesCommissionPercentage() {
        return salesCommissionPercentage;
    }

    public Seller setSalesCommissionPercentage(float salesCommissionPercentage) {
        this.salesCommissionPercentage = salesCommissionPercentage;
        return this;
    }

    public float getPaymentCommissionPercentage() {
        return paymentCommissionPercentage;
    }

    public Seller setPaymentCommissionPercentage(float paymentCommissionPercentage) {
        this.paymentCommissionPercentage = paymentCommissionPercentage;
        return this;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public Seller setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
        return this;
    }

    public int getAddress_id() {
        return address_id;
    }

    public Seller setAddress_id(int address_id) {
        this.address_id = address_id;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO vendedor (nomeVendedor, cpfVendedor, emailVendedor, foneVendedor, fone2Vendedor, percentComissaoVenda, percentComissaoRecebto, compleEnderecoVendedor, endereco_idcep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT idvendedor, nomeVendedor, cpfVendedor, emailVendedor, foneVendedor, fone2Vendedor, percentComissaoVenda, percentComissaoRecebto, compleEnderecoVendedor, endereco_idcep FROM vendedor";
    }

    @Override
    public String findById() {
        return "SELECT idvendedor, nomeVendedor, cpfVendedor, emailVendedor, foneVendedor, fone2Vendedor, percentComissaoVenda, percentComissaoRecebto, compleEnderecoVendedor, endereco_idcep FROM vendedor WHERE idvendedor = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idvendedor, nomeVendedor, cpfVendedor, emailVendedor, foneVendedor, fone2Vendedor, percentComissaoVenda, percentComissaoRecebto, compleEnderecoVendedor, endereco_idcep FROM vendedor WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE vendedor SET nomeVendedor = ?, cpfVendedor = ?, emailVendedor = ?, foneVendedor = ?, fone2Vendedor = ?, percentComissaoVenda = ?, percentComissaoRecebto = ?, compleEnderecoVendedor = ?, endereco_idcep = ? WHERE idvendedor = ? ";
    }

    @Override
    public String delete() {
        return null;
    }
}
