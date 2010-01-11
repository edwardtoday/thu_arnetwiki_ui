package org.net9.arnetwiki.ui.um;

import java.io.StringWriter;

import org.net9.arnetwiki.ui.um.exception.GenericException;
import org.net9.arnetwiki.ui.um.exception.LoginFailedException;
import org.net9.arnetwiki.ui.um.exception.NotFoundException;
import org.net9.arnetwiki.ui.um.xml.GenericBean;
import org.net9.arnetwiki.ui.um.xml.PersonBean;

import com.ociweb.xml.Version;
import com.ociweb.xml.WAX;

public class Test {
	public static void main(String []args) 
	throws GenericException, NotFoundException, LoginFailedException {
		Backend be = new Backend("deepsolo9", "testdeepsolo");
		be.auth();
		System.out.println("1:" + be.listGroups());
		
//		be.changePassword("testtest");
//		PersonBean updateBean = be.getProfile();
//		updateBean.nicknames.add(new GenericBean("1"));
//		updateBean.genders.add(new GenericBean("male"));
//		updateBean.birthdates.add(new GenericBean("1"));
//		updateBean.organizations.add(new GenericBean("1"));
//		updateBean.titles.add(new GenericBean(""));
//		updateBean.interests.add(new GenericBean(""));
//		be.updateProfile(updateBean);
//		PersonBean updateBean2 = be.getProfile();
//		StringWriter writer = new StringWriter();
//		WAX wax = new WAX(writer, Version.V1_0);
//		updateBean2.toXML(wax);
//		wax.close();
//		System.out.println(writer.toString());
	}
}
