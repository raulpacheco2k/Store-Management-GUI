package br.com.raulpacheco.models.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Seller  {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
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
}
