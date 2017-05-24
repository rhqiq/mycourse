package com.rhqiq.nine;


import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DOMDVDReader {
    public NodeList readNode(String filepath) {
        DocumentBuilderFactory dbf  = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);

        DocumentBuilder db = null;
        try {
            db =  dbf.newDocumentBuilder();
            db.setErrorHandler(new  ErrorHandler() {
                public void error(SAXParseException spe) {
                    System.err.println(spe);
                }
                public void fatalError(SAXParseException spe){
                    System.err.println(spe);
                }
                public void warning(SAXParseException spe) {
                    System.out.println(spe);
                }
            });
        } catch (ParserConfigurationException pce) {
            System.err.println(pce);
            System.exit(1);
        }

        Document doc = null;
        try {
            doc = db.parse(new File(filepath));
        }  catch (SAXException  se) {
            System.err.println(se);
        }  catch (IOException  ioe) {
            System.err.println(ioe);
        }
         return doc.getDocumentElement().getChildNodes();
    }

    public void  echoNodes(NodeList nodeList) {
        if (nodeList == null)  return;
        for (int i = 0; i <  nodeList.getLength(); i++) {
            Node child_node = nodeList.item(i);
            if  (child_node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element)child_node;
                System.out.println("Tag Name:" +  el.getTagName());
                NamedNodeMap attributes =  child_node.getAttributes();
                Node attribute = attributes.getNamedItem("id");
                if (attribute != null) System.out.println("Attr:  " + attribute.getNodeName() + " = " + attribute.getNodeValue());
            } else if  (child_node.getNodeType() == Node.TEXT_NODE) {
                Text tn = (Text)child_node;
                String text = tn.getWholeText().trim();
                if (text.length() > 0) System.out.println("Text:  " + text);
            }
            echoNodes(child_node.getChildNodes());
        }
    }

    public void echoCountDecade(NodeList nodeList) {
        if (nodeList == null)  return;
        HashMap<String, Integer> decadeMap = new HashMap<>();
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String releaseYear = eElement.getElementsByTagName("release_year")
                        .item(0).getTextContent().substring(0,3) + '0';
                if (decadeMap.containsKey(releaseYear)){
                    decadeMap.put(releaseYear, decadeMap.get(releaseYear) + 1);
                }else{
                    decadeMap.put(releaseYear, 1);
                }
            }
        }

        String resHead = "<DVD>\n" +
                "  <summary>\n";
        String resFoot = "  </summary>\n" +
                "</DVD>";

        StringBuilder resBody = new StringBuilder("");

        Set set = decadeMap.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            resBody.append("    <count decade=\" " + me.getKey()+ "\">" + me.getValue() + "</count>\n");
        }

        System.out.println(resHead + resBody.toString() + resFoot);
    }


    public static void  main(String[] args) {
        DOMDVDReader domDVDReader  = new DOMDVDReader();

        NodeList nodeList = domDVDReader.readNode("src/com/rhqiq/nine/dvd.xml");
        domDVDReader.echoCountDecade(nodeList);

    }
}