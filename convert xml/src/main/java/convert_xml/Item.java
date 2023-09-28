package convert_xml;

import javax.xml.bind.annotation.XmlAttribute;

public class Item {
    @XmlAttribute(name = "city")
    private String city;

    @XmlAttribute(name = "street")
    private String street;

    @XmlAttribute(name = "house")
    private int house;

    @XmlAttribute(name = "floor")
    private int floor;

    public String GetCity(){
        return city;
    }

    public int GetFloor(){
        return floor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(city);
        sb.append(" ");
        sb.append(street);
        sb.append(" ");
        sb.append(house);
        sb.append(" ");
        sb.append(floor);
        return sb.toString();
    }
}
