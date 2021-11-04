package Model.Inventory;

/**
 * Created by GeoCodec on 9/26/2019.
 */
public class Physics {


    int id;
    byte[] image;
    String name;
    String qty;
    String note;

    public Physics(int id, byte[] image, String name, String qty, String note) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.qty = qty;
        this.note = note;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return this.qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
