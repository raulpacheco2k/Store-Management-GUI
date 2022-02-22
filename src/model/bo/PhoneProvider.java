package model.bo;

public class PhoneProvider {
    private int id;
    private String phone;

    public PhoneProvider() {
    }

    public PhoneProvider(int id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public PhoneProvider setId(int id) {
        this.id = id;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PhoneProvider setPhone(String phone) {
        this.phone = phone;
        return this;
    }


}
