package Classes;

public class Property {
    private int PropertyId;
    private String PropertyCategory;
    private float PropertySize;
    private String Description;
    private float Price;
    private String PropertyType;
    private String Address;
    private String City;

    public Property() {
    }

    public Property(int PropertyId, String PropertyCategory, float PropertySize, String Description, float Price, String PropertyType, String Address, String City) {
        this.PropertyId = PropertyId;
        this.PropertyCategory = PropertyCategory;
        this.PropertySize = PropertySize;
        this.Description = Description;
        this.Price = Price;
        this.PropertyType = PropertyType;
        this.Address = Address;
        this.City = City;
    }

    public int getPropertyId() {
        return PropertyId;
    }

    public void setPropertyId(int PropertyId) {
        this.PropertyId = PropertyId;
    }

    public String getPropertyCategory() {
        return PropertyCategory;
    }

    public void setPropertyCategory(String PropertyCategory) {
        this.PropertyCategory = PropertyCategory;
    }

    public float getPropertySize() {
        return PropertySize;
    }

    public void setPropertySize(float PropertySize) {
        this.PropertySize = PropertySize;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getPropertyType() {
        return PropertyType;
    }

    public void setPropertyType(String PropertyType) {
        this.PropertyType = PropertyType;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }



    
    
        
}