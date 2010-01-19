package org.net9.arnetwiki.ui.wiki;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*
 * @author zym
 * 
 */

public class WikiPageTest {
	private HttpServletRequest request;
	
	public WikiPageTest (HttpServletRequest request) {
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
	public String showPage()
	{
		switch(getType())
		{
			case 1:		//term
				return getTermPage();
			case 2:		//people
				return getPeoplePage();
			default:	//institution
				return getInstitutionPage();
		}
	}
	private String generateWikiItem(String header, String content){
		return
			"<div id = '" + header + "' class='groupItem'>" + 
				"<div class='itemHeader'>" +
					header +
					"<a href='#' class='closeEl'>[-]</a>" +
				"</div>" +
				"<div class='itemContent'>" + 
					content +
				"</div>" +
			"</div>";
	}
	private String generateListStarter(String header){
		return
			"<div id = '" + header + "' class='groupItem'>" + 
				"<div class='itemHeader'>" +
					header +
					"<a href='#' class='closeEl'>[-]</a>" +
				"</div>" +
				"<div class='itemContent'>";
	}
	private String generateListContent(String content){
		return			"<a rel='external' href='result-list.jsp?querytext=" + content + "'>" +
					content + "</a><br>";
	}
	private String generatePaperContent(String content){
		return			"<a rel='external' href='pdf-comment.jsp?papername=" + content + "'>" +
					content + "</a><br>";
	}
	private String generateListEnd(){
		return		"</div>" +
			"</div>";
	}


	//输出的wiki前后不能加其它信息，如“you are reading <ID> wiki”之类的，否则会影响拖拽
	public String getTermPage()
	{
		return 
			generateWikiItem("keyword", "Mechanism design") +
			generateWikiItem("definition", "is therefore considered to be successfully implemented and tested.") +
			generateWikiItem("conferences", "") +
			generateListStarter("papers") +
			generatePaperContent("Incremental Mechanism Design") +
			generatePaperContent("Automated Design of Multistage Mechanisms") +
			generatePaperContent("Computational Aspects of Mechanism Design") +
			generatePaperContent("Mechanism design with incomplete languages") +
			generatePaperContent("Automated mechanism design for a self-interested designer") +
			generatePaperContent("Mechanism Design with Partial Revelation") +
			generatePaperContent("Fault tolerant mechanism design") +
			generatePaperContent("Complexity of Mechanism Design") +
			generatePaperContent("Partial Revelation Automated Mechanism Design") +
			generatePaperContent("Mechanism Design for Single-Value Domains") +
			generatePaperContent("Mechanism design for policy routing") +
			generatePaperContent("Optimal mechanism design and money burning") +
			generatePaperContent("Algorithmic Mechanism Design (Extended Abstract)") +
			generatePaperContent("Computer-Aided Creative Mechanism Design") +
			generatePaperContent("Approximate mechanism design without money") +
			generatePaperContent("Complexity of Mechanism Design") +
			generatePaperContent("Mechanism design for policy routing") +
			generatePaperContent("Automated Online Mechanism Design and Prophet Inequalities") +
			generatePaperContent("Self-interested automated mechanism design and implications for optimal combinatorial auctions") +
			generateListEnd() +

			generateListStarter("people") +
			generateListContent("Robert D. Kleinberg") +
			generateListContent("Tuomas Sandholm") +
			generateListContent("Moshe Tennenholtz") +
			generateListContent("Ariel D. Procaccia") +
			generateListContent("Scott Shenker") +
			generateListContent("Moshe Babaioff") +
			generateListContent("Rahul Sami") +
			generateListContent("Craig Boutilier") +
			generateListContent("Mohammad Taghi Hajiaghayi") +
			generateListContent("Nathanael Hyafil") +
			generateListContent("Tim Roughgarden") +
			generateListContent("Elan Pavlov") +
			generateListContent("Amir Ronen") +
			generateListContent("Ryan Porter") +
			generateListContent("Kun Sun") +
			generateListContent("Noam Nisan") +
			generateListContent("Boi Faltings") +
			generateListContent("Yoav Shoham") +
			generateListContent("Ron Lavi") +
			generateListContent("Joan Feigenbaum") +
			generateListContent("Vincent Conitzer") +
			generateListContent("Jason D. Hartline") +
			generateListEnd() +
//			generateWikiItem("institutions", "test institutions") +
			generateWikiItem("dataset", "");
	}
	public String getPeoplePage()
	{
		return 
			generateWikiItem("keyword", "Jorg Kienzle") +
			generateWikiItem("name", "Jorg Kienzle") +
			generateWikiItem("position", "test position") +
			generateWikiItem("affliation", "IBM TJ Watson Research center Language Technologies Institute Informedia / CareMedia project") +
			generateWikiItem("address", "Intelligent Information Management Dept. IBM TJ Watson Research Center 19 Skyline Dr., Hawthorne, NY, 10532") +
			generateWikiItem("email", "yanrong at CS dot CMU dot EDU") +
			generateWikiItem("home-page", "http://www.cs.cmu.edu/~yanrong/") +
			generateListStarter("papers") +
			generatePaperContent("Object-Oriented Stable Storage Based on Mirroring") +
			generatePaperContent("Software Fault Tolerance: An Overview") +
			generatePaperContent("Transaction Support for Ada") +
			generatePaperContent("On Persistent and Reliable Streaming in Ada") +
			generatePaperContent("Shared Recoverable Objects") +
			generatePaperContent("Secure Communication in Distributed Ada") +
			generatePaperContent("Concurrency Control in Transactional Drago") +
			generatePaperContent("Object-Oriented Programming and Protected Objects in Ada 95") +
			generatePaperContent("AO challenge - implementing the ACID properties for transactional objects") +
			generatePaperContent("Aspect-oriented multi-view modeling") +
			generatePaperContent("Addressing concurrency in object-oriented software development") +
			generatePaperContent("Porting OMTTs to CORBA"+"AOP: Does It Make Sense? The Case of Concurrency and Failures") +
			generatePaperContent("Action-Oriented Exception Handling in Cooperative and Competitive Concurrent Object-Oriented Systems") +
			generatePaperContent("Exception-Aware Requirements Elicitation with Use Cases") +
			generatePaperContent("Fault Tolerance - Concepts and Implementation Issues") +
			generatePaperContent("A Survey of Software Development Approaches Addressing Dependability") +
			generatePaperContent("Looking Ahead in Open Multithreaded Transactions") +
			generatePaperContent("9th International Workshop on Aspect-Oriented Modeling") +
			generatePaperContent("Model-Based Design of Computer-Controlled Game Character Behavior") +
			generatePaperContent("Model-Driven Assessment of Use Cases for Dependable Systems") +
			generatePaperContent("11th International Workshop on Aspect-Oriented Modeling") +
			generatePaperContent("Comparing interest management algorithms for massively multiplayer games") +
			generatePaperContent("Network Applications in Ada 95") +
			generatePaperContent("On exceptions and the software development life cycle") +
			generatePaperContent("Report of the 7th International Workshop on Aspect-Oriented Modeling") +
			generatePaperContent("Exceptional Use Cases") +
			generatePaperContent("5th International Workshop on Aspect-Oriented Modeling") +
			generatePaperContent("A Modelling and Simulation Based Approach to Dependable System Design") +
			generatePaperContent("Open Multithreaded Transactions: Keeping Threads and Exceptions under Control") +
			generatePaperContent("Auction System Design Using Open Multithreaded Transactions") +
			generatePaperContent("Framework based on design patterns for providing persistence in object-oriented programming languages") +
			generatePaperContent("On Atomicity and Software Development") +
			generatePaperContent("A modelling and simulation based process for dependable systems design") +
			generatePaperContent("Model-driven assessment of system dependability") +
			generatePaperContent("Integrating object-oriented programming and protected objects in Ada 95") +
			generatePaperContent("DREP: A Requirements Engineering Process for Dependable Reactive Systems") +
			generatePaperContent("Aspect Model Unweaving"+"Mammoth: a massively multiplayer game research framework") +
			generatePaperContent("AspectOptima: A Case Study on Aspect Dependencies and Interactions") +
			generateListEnd();
	}
	public String getInstitutionPage()
	{
		return 
			generateWikiItem("keyword", "SIGMOD'07") +
			generateWikiItem("location", "Beijing") +
			generateListStarter("people") +
			generateListContent("Craig S. Freedman") +
			generateListContent("Philip A. Bernstein") +
			generateListContent("Clark D. French") +
			generateListContent("Jayant R. Haritsa") +
			generateListContent("Alon Y. Halevy") +
			generateListContent("Zwilling") +
			generateListContent("Hansjorg Fromm") +
			generateListContent("Maya Ramanath") +
			generateListContent("Juliana Freire") +
			generateListContent("Claude Frasson") +
			generateListContent("M. Er-radi") +
			generateListContent("Arvind Rajendran") +
			generateListContent("Irini Fundulaki") +
			generateListContent("Johann Christoph Freytag") +
			generateListContent("Phillip M. Fernandez") +
			generateListContent("Leonidas Fegaras") +
			generateListContent("Nathan Goodman") +
			generateListContent("Gerhard Weikum") +
			generateListContent("Chandrasekhar Srinivasan") +
			generateListContent("Anastassia Ailamaki") +
			generateListContent("John R. Friedrich") +
			generateListContent("Michael J. Carey") +
			generateListContent("Stanley B. Zdonik") +
			generateListContent("Michael Freeston") +
			generateListContent("Jerome Simeon") +
			generateListContent("Jennifer Widom") +
			generateListContent("Prasan Roy") +
			generateListContent("Michael J. Franklin") +
			generateListContent("Mary F. Fernandez") +
			generateListContent("Arnaud Sahuguet") +
			generateListEnd() +

			generateListStarter("papers") +
			generatePaperContent("Database Services in the German Bildschirmtext System (Btx)") +
			generatePaperContent("Meta-data version and configuration management in multi-vendor environments") +
			generatePaperContent("Rule-Based Translation of Relational Queries into Iterative Programs") +
			generatePaperContent("A Rule-Based View of Query Optimization") +
			generatePaperContent("``One Size Fits All'' Database Architectures Do Not Work for DDS") +
			generatePaperContent("StatiX: making XML count"+"A General Solution of the n-dimensional B-tree Problem") +
			generatePaperContent("The BANG File: A New Kind of Grid File"+"Efficient Evaluation of XML Middle-ware Queries") +
			generatePaperContent("Share your data, Keep your secrets"+"Red Brick Warehouse: A Read-Mostly RDBMS for Open SMP Platforms") +
			generatePaperContent("Principles of an Icons-Based Command Language") +
			generatePaperContent("Crash Recovery in Client-Server EXODUS") +
			generatePaperContent("lambda-DB: An ODMG-Based Object-Oriented DBMS") +
			generatePaperContent("Data In Your Face': Push Technology in Perspective") +
			generatePaperContent("Towards an Effective Calculus for Object Query Languages") +
			generatePaperContent("Rethinking the Conference Reviewing Process - Panel") +
			generatePaperContent("Query Unnesting in Object-Oriented Databases") +
			generatePaperContent("The SPIFFI Scalable Video-on-Demand System") +
			generatePaperContent("Database Evaluation Using Multiple Regression Techniques") +
			generateListEnd() +
			generateWikiItem("homepage", "http://sigmod07.riit.tsinghua.edu.cn/");			
	}


	private HttpSession getHttpSession() {
		return request.getSession();
	}
	private static final String SESSION_KEY = "ArnetWiki Session";
}