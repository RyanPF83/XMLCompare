package com.atosorigin.integrale.xmlcompare.io.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;

import com.thoughtworks.xstream.XStream;

public class XMLFileOut implements XMLOutInterface {
	
	static XStream xstream = new XStream();
	String path = "C:\\XML\\XParse";
	String uid;
	Instant inst;

	public void createXML(Object object) {
		String xml = xstream.toXML(object);
		inst = Instant.now();
		
		uid = "_" + object.getClass().getSimpleName().toString() + "_" + inst.toString().substring(0, inst.toString().length()-4).replace(":", "").replace(".", "").replace("-", "").replace("T", "_").concat("Z");
		
		FileOutputStream fos = null;
	    try{            
	        fos = new FileOutputStream(path + uid + ".xml");
	        fos.write("<?xml version=\"1.0\"?>\n".getBytes("UTF-8"));
	        byte[] bytes = xml.getBytes("UTF-8");
	        fos.write(bytes);
	    }catch (IOException ioe){
	        System.err.println("Error in XML Write: " + ioe.getMessage());
	    }
	    finally{
	        if(fos != null){
	            try{
	                fos.close();
	            }catch (IOException ioe) {
	                ioe.printStackTrace();
	            }
	        }
	    }

	}

}
