package com.atosorigin.integrale.xmlcompare.io.xml;

import com.thoughtworks.xstream.XStream;

public class XMLPrintOut implements XMLOutInterface {
	
	static XStream xstream = new XStream();

	public void createXML(Object object) {
		String xml = xstream.toXML(object);
		System.out.println(xml);
	}

}
