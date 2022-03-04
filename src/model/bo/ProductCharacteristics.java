package model.bo;

public class ProductCharacteristics extends Model {
    private int id;
    private int idProduct;
    private int idColor;
    private String size;
    private String barCode;
    private float stock;

    public ProductCharacteristics() {
        setTable("caracteristicaproduto");
    }

    public ProductCharacteristics(int id, int idProduct, int idColor, String size, String barCode, float stock) {
        this.id = id;
        this.idProduct = idProduct;
        this.idColor = idColor;
        this.size = size;
        this.barCode = barCode;
        this.stock = stock;
        setTable("caracteristicaproduto");
    }

    public int getId() {
        return id;
    }

    public ProductCharacteristics setId(int id) {
        this.id = id;
        return this;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public ProductCharacteristics setIdProduct(int idProduct) {
        this.idProduct = idProduct;
        return this;
    }

    public int getIdColor() {
        return idColor;
    }

    public ProductCharacteristics setIdColor(int idColor) {
        this.idColor = idColor;
        return this;
    }

    public String getSize() {
        return size;
    }

    public ProductCharacteristics setSize(String size) {
        this.size = size;
        return this;
    }

    public String getBarCode() {
        return barCode;
    }

    public ProductCharacteristics setBarCode(String barCode) {
        this.barCode = barCode;
        return this;
    }

    public float getStock() {
        return stock;
    }

    public ProductCharacteristics setStock(float stock) {
        this.stock = stock;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO caracteristicaproduto (produto_idproduto, cor_idcor, tamanhoProduto, barraProduto, qtdEstoqueProduto) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT idCaracterisitcaProduto, produto_idproduto, cor_idcor, tamanhoProduto, barraProduto, qtdEstoqueProduto FROM caracteristicaproduto";
    }

    @Override
    public String findById() {
        return "SELECT idCaracterisitcaProduto, produto_idproduto, cor_idcor, tamanhoProduto, barraProduto, qtdEstoqueProduto FROM caracteristicaproduto WHERE idCaracterisitcaProduto = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idCaracterisitcaProduto, produto_idproduto, cor_idcor, tamanhoProduto, barraProduto, qtdEstoqueProduto FROM caracteristicaproduto WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE caracteristicaproduto SET cor_idcor = ?, tamanhoProduto = ?, barraProduto = ?, qtdEstoqueProduto = ? WHERE idCaracterisitcaProduto = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
