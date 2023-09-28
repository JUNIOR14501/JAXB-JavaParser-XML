package convert_xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.xml.bind.*;

public class App{
    public static void main( String[] args ) throws Exception{
        Scanner in = new Scanner(System.in, "UTF-8");
        while (true){
            System.out.print("Enter the path to the xml file or enter the \"Exit\" command to exit: ");
            String path = in.nextLine().toString();
            //String path = "C:/Users/vladi/Downloads/address.xml";
            
            if (path == "Exit") {
                in.close();
                System.exit(0);
            }

            Map<String, Integer> adressHashMap = new HashMap<String,Integer>();
            Map<String, Integer> countHouses = new HashMap<String,Integer>();
            
            long time = System.currentTimeMillis();
            Root root = FillClass(path);
            System.out.println("Файл обработался за: " + ((System.currentTimeMillis() - time)/1000.0) + "сек");
            
            CountDublicate(root, adressHashMap);
            CountHouses(root, countHouses);
        }
    }
    private static void CountDublicate(Root root, Map<String, Integer> adressHashMap) {
        for (Item item : root.items) {
            Integer count = adressHashMap.get(item.toString());
            adressHashMap.put(item.toString(), (count == null) ? 1 : count + 1);
        }

        printMap(adressHashMap, true);
    }
    private static void CountHouses(Root root, Map<String, Integer> countHouses) {
        for (Item item : root.items) {
            String key = (item.GetCity()+", этаж: " + item.GetFloor());
            Integer count = countHouses.get(key);
            countHouses.put(key, (count == null) ? 1 : count + 1);
        }
        printMap(countHouses, false);
    }

    public static void printMap(Map<String, Integer> map, boolean flag){
        if (flag){
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() !=1){
                    System.out.println("Строка: " + entry.getKey() + 
                    ", Повторений: " + entry.getValue());
                }
            }
        } else{
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    System.out.println("Город: " + entry.getKey() + 
                    ", кол-во домов: " + entry.getValue());
            }
        }
        System.err.println("\n");
    }
    public static Root FillClass(String file) throws Exception{
        try {
            InputStreamReader filereader = new InputStreamReader( new FileInputStream(file), "UTF-8");
            JAXBContext context = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Root) unmarshaller.unmarshal(filereader);
        }
        catch (FileNotFoundException e) {
            throw new Exception("Файл не был найден, проверьте путь");
        }
        
    }
}
