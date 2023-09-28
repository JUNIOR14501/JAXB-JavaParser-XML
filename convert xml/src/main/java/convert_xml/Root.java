package convert_xml;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement(name = "item")
    List<Item> items = new LinkedList<>();
    
}
