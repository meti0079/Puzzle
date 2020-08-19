package Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;


import java.util.Set;

public class ConfigLoader {
    private static ConfigLoader loader;
    private String addressName;
    private HashMap<String, Configs> addressess;
    private static String defaultAddress = "src/resorce/graphicconfig";
 
    private HashMap<String, Configs> frameConfigs;
    private HashMap<String, Configs> panelConfigs;
    private HashMap<String, Configs> properties;
    private HashMap<String, Configs> constants;
    private HashMap<String, Configs> constants1;
    private HashMap<String, Configs> constants2;
    private HashMap<String, Configs> constants3;
    private HashMap<String, Configs> constants4;
    private HashMap<String, Configs> constants5;
    private HashMap<String, Configs> constants6;

    private ConfigLoader(String address) {
        initialize(address);
    }

    public static ConfigLoader getInstance() {
        return getInstance("default");
    }

    private void initialize(String address) {
        FileReader reader;
        addressName = "RESOURCE_URL";
        constants = new HashMap<>();
        constants1 = new HashMap<>();
        constants2 = new HashMap<>();
        constants3 = new HashMap<>();
        constants4 = new HashMap<>();
        constants5 = new HashMap<>();
        constants6 = new HashMap<>();
        frameConfigs = new HashMap<>();
        panelConfigs = new HashMap<>();
        addressess = new HashMap<>();
        try {
            Configs addresses = new Configs();
            reader = new FileReader(address);
            addresses.load(reader);
            this.addressess.put(addressName, addresses);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            System.out.println("main config file doesn't exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadProperties();
    }

    private void loadProperties() {
        Set<Entry<Object, Object>> entries = addressess.get("RESOURCE_URL").entrySet();
        for (Entry entry : entries) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Entry<Object, Object> entry : entries) {
            String adrs = (String) entry.getValue();
            String key = (String) entry.getKey();
            String lowerCase = key.toLowerCase();
            if (!lowerCase.contains("url")) {
                Configs property = new Configs();
                try {
                    File test = new File(adrs);
//                    System.out.println(test.getAbsolutePath());
                    FileReader reader = new FileReader(test);
                    property.load(reader);

                } catch (FileNotFoundException e) {
//                    System.out.println(entry.getKey() + " file doesn't exist");
                    e.printStackTrace();
                } catch (IOException e) {
//                    System.out.println(entry.getKey() + " load failed");
                    e.printStackTrace();
                }

                if (lowerCase.contains("frame")) {
//                    System.out.println("frame added : " + key);
                    frameConfigs.put(key, property);
                } else if (lowerCase.contains("panel")) {
//                    System.out.println("panels added : " + key);
                    panelConfigs.put(key, property);
                }else if (lowerCase.equalsIgnoreCase("constants")) {
//                    System.out.println("constants added : " + key);
                    constants.put(key, property);
//                    System.out.println(3);

                }else if (lowerCase.equals("constants1")) {
//                    System.out.println("constants1 added : " + key);
                    constants1.put(key, property);
                }else if (lowerCase.equals("constants2")) {
//                    System.out.println("constants2 added : " + key);
                    constants2.put(key, property);

                }else if (lowerCase.equals("constants3")) {
//                    System.out.println("constants2 added : " + key);
                    constants3.put(key, property);

                }else if (lowerCase.equals("constants4")) {
//                    System.out.println("constants2 added : " + key);
                    constants4.put(key, property);

                }else if (lowerCase.equals("constants5")) {
//                    System.out.println("constants2 added : " + key);
                    constants5.put(key, property);

                }else if (lowerCase.equals("constants6")) {
//                    System.out.println("constants2 added : " + key);
                    constants6.put(key, property);

                }  else 
                    properties.put(key, property);

            }
        }
        System.out.println("loading finished! ");
    }

    public static ConfigLoader getInstance(String address) {
        if (loader == null) {
            if (address.equals("default")) {
                address = defaultAddress;
            }
            loader = new ConfigLoader(address);
        }
        return loader;
    }
    public String getAddress(String type, String resource_url) {
        return addressess.get(type).getProperty(resource_url);
    }

    public String getAddress(String resource_url) {
        return getAddress(addressName, resource_url);
    }

    protected Configs getFrameProperties(String name) {
        return frameConfigs.get(name);
    }

    protected Configs getPanelProperties(String name) {
        return panelConfigs.get(name);
    }
    public Configs getProperties(String name) {
//        System.out.println("in get properties with name : " + name);
        return constants.get(name);
    }
    public Configs getProperties1(String name) {
//    	System.out.println("in get properties with name : " + name);
    	return constants1.get(name);
    }
    public Configs getProperties3(String name) {
//    	System.out.println("in get properties with name : " + name);
    	return constants3.get(name);
    }
    public Configs getProperties4(String name) {
//    	System.out.println("in get properties with name : " + name);
    	return constants4.get(name);
    }
    public Configs getProperties5(String name) {
//    	System.out.println("in get properties with name : " + name);
    	return constants5.get(name);
    }
    public Configs getProperties6(String name) {
//    	System.out.println("in get properties with name : " + name);
    	return constants6.get(name);
    }
    public Configs getProperties2(String name) {
//    	System.out.println("in get properties with name : " + name);
    	return constants2.get(name);
    }
}

