package Model.Inventory;

/**
 * Created by GeoCodec on 9/26/2019.
 */
public class Hospital {

    int id;
    byte[] image;
    String name;
    String generic;
    String qty;
    String note;

    public Hospital(int id, byte[] image, String name, String generic, String qty, String note) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.generic = generic;
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

    public String getGeneric() {
        return this.generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    public String getQuantity() {
        return this.qty;
    }

    public void setQuantity(String quantity) {
        this.qty = quantity;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
