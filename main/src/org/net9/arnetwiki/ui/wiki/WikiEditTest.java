package org.net9.arnetwiki.ui.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*
 * @author zym
 * 
 */

public class WikiEditTest{
	private HttpServletRequest request;
	
	public WikiEditTest (HttpServletRequest request) {
		this.request = request;
	}
	public String test()
	{
		return "Test Success";
	}
	public String getID()
	{
		return request.getParameter("wiki-id");
	}
	public int getType()
	{
		return Integer.parseInt(request.getParameter("style"));
	}
	public String getEditPage()
	{
		switch(getType())
		{
			case 1:		//term
				return editTermPage();
			case 2:		//people
				return editPeoplePage();
			default:	//institution
				return editInstitutionPage();
		}
	}
	private String generateWikiEditItem(String header, String content){
		return
			"<div id = '" + header + "' class='groupItem'>" + 
				"<div class='itemHeader'>" +
					header +
					"<a href='#' class='closeEl'>[-]</a>" +
				"</div>" +
				"<div class='itemContent'>" + 
					"<textarea style = 'overflow-y:visible' name='" + header + "'>" +
						content + 
					"</textarea><br>" +
				"</div>" +
			"</div>";
	}
	private String generateEditListStarter(String header){
		return
			"<div id = '" + header + "' class='groupItem'>" + 
				"<div class='itemHeader'>" +
					header +
					"<a href='#' class='closeEl'>[-]</a>" +
				"</div>" +
				"<div class='itemContent'>" + 
					"<textarea style = 'overflow-y:visible' name='" + header + "'>";
	}
	private String generateEditListContent(String content){
		return			content + "\n";
	}
	private String generateEditListEnd(){
		return			"</textarea><br>" +
				"</div>" +
			"</div>";
	}
	//输出的wiki前后不能加其它信息，如“you are reading <ID> wiki”之类的，否则会影响拖拽
	public String editTermPage()
	{
		return 
			generateWikiEditItem("keyword", "Mechanism design") +
			generateWikiEditItem("definition", "is therefore considered to be successfully implemented and tested.") +
			generateWikiEditItem("conferences", "") +
			generateEditListStarter("papers") +
			generateEditListContent("Incremental Mechanism Design") +
			generateEditListContent("Automated Design of Multistage Mechanisms") +
			generateEditListContent("Computational Aspects of Mechanism Design") +
			generateEditListContent("Mechanism design with incomplete languages") +
			generateEditListContent("Automated mechanism design for a self-interested designer") +
			generateEditListContent("Mechanism Design with Partial Revelation") +
			generateEditListContent("Fault tolerant mechanism design") +
			generateEditListContent("Complexity of Mechanism Design") +
			generateEditListContent("Partial Revelation Automated Mechanism Design") +
			generateEditListContent("Mechanism Design for Single-Value Domains") +
			generateEditListContent("Mechanism design for policy routing") +
			generateEditListContent("Optimal mechanism design and money burning") +
			generateEditListContent("Algorithmic Mechanism Design (Extended Abstract)") +
			generateEditListContent("Computer-Aided Creative Mechanism Design") +
			generateEditListContent("Approximate mechanism design without money") +
			generateEditListContent("Complexity of Mechanism Design") +
			generateEditListContent("Mechanism design for policy routing") +
			generateEditListContent("Automated Online Mechanism Design and Prophet Inequalities") +
			generateEditListContent("Self-interested automated mechanism design and implications for optimal combinatorial auctions") +
			generateEditListEnd() +

			generateEditListStarter("people") +
			generateEditListContent("Robert D. Kleinberg") +
			generateEditListContent("Tuomas Sandholm") +
			generateEditListContent("Moshe Tennenholtz") +
			generateEditListContent("Ariel D. Procaccia") +
			generateEditListContent("Scott Shenker") +
			generateEditListContent("Moshe Babaioff") +
			generateEditListContent("Rahul Sami") +
			generateEditListContent("Craig Boutilier") +
			generateEditListContent("Mohammad Taghi Hajiaghayi") +
			generateEditListContent("Nathanael Hyafil") +
			generateEditListContent("Tim Roughgarden") +
			generateEditListContent("Elan Pavlov") +
			generateEditListContent("Amir Ronen") +
			generateEditListContent("Ryan Porter") +
			generateEditListContent("Kun Sun") +
			generateEditListContent("Noam Nisan") +
			generateEditListContent("Boi Faltings") +
			generateEditListContent("Yoav Shoham") +
			generateEditListContent("Ron Lavi") +
			generateEditListContent("Joan Feigenbaum") +
			generateEditListContent("Vincent Conitzer") +
			generateEditListContent("Jason D. Hartline") +
			generateEditListEnd() +
//			generateWikiEditItem("institutions", "test institutions") +
			generateWikiEditItem("dataset", "");
	}
	public String editPeoplePage()
	{	return 
			generateWikiEditItem("keyword", "Jorg Kienzle") +
			generateWikiEditItem("name", "Jorg Kienzle") +
			generateWikiEditItem("position", "test position") +
			generateWikiEditItem("affliation", "IBM TJ Watson Research center Language Technologies Institute Informedia / CareMedia project") +
			generateWikiEditItem("address", "Intelligent Information Management Dept. IBM TJ Watson Research Center 19 Skyline Dr., Hawthorne, NY, 10532") +
			generateWikiEditItem("email", "yanrong at CS dot CMU dot EDU") +
			generateWikiEditItem("home-page", "http://www.cs.cmu.edu/~yanrong/") +
			generateEditListStarter("papers") +
			generateEditListContent("Object-Oriented Stable Storage Based on Mirroring") +
			generateEditListContent("Software Fault Tolerance: An Overview") +
			generateEditListContent("Transaction Support for Ada") +
			generateEditListContent("On Persistent and Reliable Streaming in Ada") +
			generateEditListContent("Shared Recoverable Objects") +
			generateEditListContent("Secure Communication in Distributed Ada") +
			generateEditListContent("Concurrency Control in Transactional Drago") +
			generateEditListContent("Object-Oriented Programming and Protected Objects in Ada 95") +
			generateEditListContent("AO challenge - implementing the ACID properties for transactional objects") +
			generateEditListContent("Aspect-oriented multi-view modeling") +
			generateEditListContent("Addressing concurrency in object-oriented software development") +
			generateEditListContent("Porting OMTTs to CORBA"+"AOP: Does It Make Sense? The Case of Concurrency and Failures") +
			generateEditListContent("Action-Oriented Exception Handling in Cooperative and Competitive Concurrent Object-Oriented Systems") +
			generateEditListContent("Exception-Aware Requirements Elicitation with Use Cases") +
			generateEditListContent("Fault Tolerance - Concepts and Implementation Issues") +
			generateEditListContent("A Survey of Software Development Approaches Addressing Dependability") +
			generateEditListContent("Looking Ahead in Open Multithreaded Transactions") +
			generateEditListContent("9th International Workshop on Aspect-Oriented Modeling") +
			generateEditListContent("Model-Based Design of Computer-Controlled Game Character Behavior") +
			generateEditListContent("Model-Driven Assessment of Use Cases for Dependable Systems") +
			generateEditListContent("11th International Workshop on Aspect-Oriented Modeling") +
			generateEditListContent("Comparing interest management algorithms for massively multiplayer games") +
			generateEditListContent("Network Applications in Ada 95") +
			generateEditListContent("On exceptions and the software development life cycle") +
			generateEditListContent("Report of the 7th International Workshop on Aspect-Oriented Modeling") +
			generateEditListContent("Exceptional Use Cases") +
			generateEditListContent("5th International Workshop on Aspect-Oriented Modeling") +
			generateEditListContent("A Modelling and Simulation Based Approach to Dependable System Design") +
			generateEditListContent("Open Multithreaded Transactions: Keeping Threads and Exceptions under Control") +
			generateEditListContent("Auction System Design Using Open Multithreaded Transactions") +
			generateEditListContent("Framework based on design patterns for providing persistence in object-oriented programming languages") +
			generateEditListContent("On Atomicity and Software Development") +
			generateEditListContent("A modelling and simulation based process for dependable systems design") +
			generateEditListContent("Model-driven assessment of system dependability") +
			generateEditListContent("Integrating object-oriented programming and protected objects in Ada 95") +
			generateEditListContent("DREP: A Requirements Engineering Process for Dependable Reactive Systems") +
			generateEditListContent("Aspect Model Unweaving"+"Mammoth: a massively multiplayer game research framework") +
			generateEditListContent("AspectOptima: A Case Study on Aspect Dependencies and Interactions") +
			generateEditListEnd();
	}
	public String editInstitutionPage()
	{
		return 
			generateWikiEditItem("keyword", "SIGMOD'07") +
			generateWikiEditItem("location", "Beijing") +
			generateEditListStarter("people") +
			generateEditListContent("Craig S. Freedman") +
			generateEditListContent("Philip A. Bernstein") +
			generateEditListContent("Clark D. French") +
			generateEditListContent("Jayant R. Haritsa") +
			generateEditListContent("Alon Y. Halevy") +
			generateEditListContent("Zwilling") +
			generateEditListContent("Hansjorg Fromm") +
			generateEditListContent("Maya Ramanath") +
			generateEditListContent("Juliana Freire") +
			generateEditListContent("Claude Frasson") +
			generateEditListContent("M. Er-radi") +
			generateEditListContent("Arvind Rajendran") +
			generateEditListContent("Irini Fundulaki") +
			generateEditListContent("Johann Christoph Freytag") +
			generateEditListContent("Phillip M. Fernandez") +
			generateEditListContent("Leonidas Fegaras") +
			generateEditListContent("Nathan Goodman") +
			generateEditListContent("Gerhard Weikum") +
			generateEditListContent("Chandrasekhar Srinivasan") +
			generateEditListContent("Anastassia Ailamaki") +
			generateEditListContent("John R. Friedrich") +
			generateEditListContent("Michael J. Carey") +
			generateEditListContent("Stanley B. Zdonik") +
			generateEditListContent("Michael Freeston") +
			generateEditListContent("Jerome Simeon") +
			generateEditListContent("Jennifer Widom") +
			generateEditListContent("Prasan Roy") +
			generateEditListContent("Michael J. Franklin") +
			generateEditListContent("Mary F. Fernandez") +
			generateEditListContent("Arnaud Sahuguet") +
			generateEditListEnd() +

			generateEditListStarter("papers") +
			generateEditListContent("Database Services in the German Bildschirmtext System (Btx)") +
			generateEditListContent("Meta-data version and configuration management in multi-vendor environments") +
			generateEditListContent("Rule-Based Translation of Relational Queries into Iterative Programs") +
			generateEditListContent("A Rule-Based View of Query Optimization") +
			generateEditListContent("``One Size Fits All'' Database Architectures Do Not Work for DDS") +
			generateEditListContent("StatiX: making XML count"+"A General Solution of the n-dimensional B-tree Problem") +
			generateEditListContent("The BANG File: A New Kind of Grid File"+"Efficient Evaluation of XML Middle-ware Queries") +
			generateEditListContent("Share your data, Keep your secrets"+"Red Brick Warehouse: A Read-Mostly RDBMS for Open SMP Platforms") +
			generateEditListContent("Principles of an Icons-Based Command Language") +
			generateEditListContent("Crash Recovery in Client-Server EXODUS") +
			generateEditListContent("lambda-DB: An ODMG-Based Object-Oriented DBMS") +
			generateEditListContent("Data In Your Face': Push Technology in Perspective") +
			generateEditListContent("Towards an Effective Calculus for Object Query Languages") +
			generateEditListContent("Rethinking the Conference Reviewing Process - Panel") +
			generateEditListContent("Query Unnesting in Object-Oriented Databases") +
			generateEditListContent("The SPIFFI Scalable Video-on-Demand System") +
			generateEditListContent("Database Evaluation Using Multiple Regression Techniques") +
			generateEditListEnd() +
			generateWikiEditItem("homepage", "http://sigmod07.riit.tsinghua.edu.cn/");			
	}

	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}