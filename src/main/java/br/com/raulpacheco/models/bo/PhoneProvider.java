package br.com.raulpacheco.models.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fonefornecedor")
public class PhoneProvider  {
    @Id
    @Column(name = "foneFornecedor")
    private String phone;
    private int provider;

    public PhoneProvider() {
    }

    public PhoneProvider(String phone, int provider) {
        this.phone = phone;
        this.provider = provider;
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
}


