package houwing.top.cake_site.entity;

import java.util.Date;

public class Cart {
    private  int id;
    private  int userId;
    private  int cakeId;
    private  int quantity;
    private Date create_time;
    private Date update_time;
    private Cake cake;

    public Cart(int userId, int cakeId,int quantity) {
        this.userId = userId;
        this.cakeId = cakeId;
        this.quantity=quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", cakeId=" + cakeId +
                ", quantity=" + quantity +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", cake=" + cake +
                '}';
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCakeId() {
        return cakeId;
    }

    public void setCakeId(int cakeId) {
        this.cakeId = cakeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
