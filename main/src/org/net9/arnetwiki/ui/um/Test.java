package org.net9.arnetwiki.ui.um;

import java.util.ArrayList;
import java.util.Map;

import org.net9.arnetwiki.ui.um.exception.GenericException;
import org.net9.arnetwiki.ui.um.exception.LoginFailedException;
import org.net9.arnetwiki.ui.um.exception.NotFoundException;
import org.net9.arnetwiki.ui.um.xml.PersonBean;

public class Test {
	public static void main(String []args) 
	throws GenericException, NotFoundException, LoginFailedException {
		Backend be = new Backend("deepsolo9", "testdeepsolo");
		be.auth();
		be.createGroup("Ts1");
//		be.quitGroup("1");
//		System.out.println(be.createGroup("Test1"));
//		be.joinGroup(groupid);
//		be.addPdfFavorite("1");
//		be.addPdfFavorite("2");
//		Map<String, ArrayList<String>> result = be.getFavorites();
//		ArrayList<String> pdfs = result.get("pdf");
//		for (String str : pdfs) {
//			System.out.println(str);
//		}
//		System.out.println("1:" + be.listGroups());
		
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
