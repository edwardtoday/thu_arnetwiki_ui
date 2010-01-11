/**
 * 
 */
package org.net9.arnetwiki.ui.um.xml;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.ociweb.xml.Version;
import com.ociweb.xml.WAX;

public class PersonBean extends Bean {
	
	public Collection<GenericBean> usernames = new ArrayList<GenericBean>();
	public Collection<GenericBean> nicknames = new ArrayList<GenericBean>();
	public Collection<GenericBean> emails = new ArrayList<GenericBean>();
	public Collection<GenericBean> genders = new ArrayList<GenericBean>();
	public Collection<GenericBean> birthdates = new ArrayList<GenericBean>();
	public Collection<GenericBean> organizations = new ArrayList<GenericBean>();
	public Collection<GenericBean> titles = new ArrayList<GenericBean>();
	public Collection<GenericBean> interests = new ArrayList<GenericBean>();
	
	public PersonBean(long id) {
		this.id = id;
	}
	
	public PersonBean(Element ele) {
		beanName = ele.getName();
		id = Long.decode(ele.attributeValue("id"));

		for (Object iter : ele.attributes()) {
			Attribute attr = (Attribute) iter;
			putAttribute(attr);
		}
		for (Object iter : ele.elements()) {
			Element elem = (Element) iter;
			if (elem.getName().equals("username"))
				usernames.add(new GenericBean(elem));
			else if (elem.getName().equals("nickname"))
				nicknames.add(new GenericBean(elem));
			else if (elem.getName().equals("email"))
				emails.add(new GenericBean(elem));
			else if (elem.getName().equals("gender"))
				genders.add(new GenericBean(elem));
			else if (elem.getName().equals("birthdate"))
				birthdates.add(new GenericBean(elem));
			else if (elem.getName().equals("organization"))
				organizations.add(new GenericBean(elem));
			else if (elem.getName().equals("title"))
				titles.add(new GenericBean(elem));
			else if (elem.getName().equals("interests"))
				interests.add(new GenericBean(elem));
			else if (elem.isTextOnly())
				putElement(elem);
		}

	}
	
	public void toXML(WAX wax) {
		wax.start("userprofile");
		wax.defaultNamespace("http://arnetpie.net9.org", "userprofile.xsd");
		wax.child("id", String.valueOf(id));
		for(GenericBean bean : usernames)
			wax.child("username", bean.beanName);
		for(GenericBean bean : nicknames)
			wax.child("nickname", bean.beanName);
		for(GenericBean bean : emails)
			wax.child("email", bean.beanName);
		for(GenericBean bean : genders)
			wax.child("gender", bean.beanName);
		for(GenericBean bean : birthdates)
			wax.child("birthdate", bean.beanName);
		for(GenericBean bean : organizations)
			wax.child("organization", bean.beanName);
		for(GenericBean bean : titles)
			wax.child("title", bean.beanName);
		for(GenericBean bean : interests)
			wax.child("interests", bean.beanName);
	}

//	public static void main(String []args) {
//		PersonBean updatebean = new PersonBean(5);
//		updatebean.usernames.add(new GenericBean("HH1"));
//		updatebean.nicknames.add(new GenericBean("HH2"));
//		updatebean.emails.add(new GenericBean("HH3"));
//		updatebean.genders.add(new GenericBean("HH4"));
//		updatebean.birthdates.add(new GenericBean("HH5"));
//		updatebean.organizations.add(new GenericBean("HH6"));
//		updatebean.titles.add(new GenericBean("HH7"));
//		updatebean.interests.add(new GenericBean("HH8"));
//		StringWriter writer = new StringWriter();
//		WAX wax = new WAX(writer, Version.V1_0);
//		updatebean.toXML(wax);
//		wax.close();
//		System.out.println(writer.toString());
//	}
}
