package com.atosorigin.integrale.xmlcompare.io.xml;

import java.io.File;

import com.thoughtworks.xstream.XStream;

public class XMLFileIn implements XMLInInterface {

	static XStream xstream = new XStream();
	
	public Object parseXML(String filePath) {
		File xmlfile = new File(filePath);
		Object object = xstream.fromXML(xmlfile);
		return object;
	}

}
