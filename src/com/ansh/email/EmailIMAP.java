package com.ansh.email;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class EmailIMAP {
	public static String taskName = "";
	public static String last_date = "";
	public static String issued_date = "";
	public static String description = "";
	public static char status='n';
	public void GmailFetch() throws Exception {
		
		
		    Session session = Session.getDefaultInstance(new Properties( ));
		    Store store = session.getStore("imaps");
		    store.connect("imap.googlemail.com", 993, "rainaansh13@gmail.com", "livelifelikeaqueen123");
		    Folder inbox = store.getFolder( "INBOX" );
		    inbox.open(Folder.READ_ONLY);

		    // Fetch unseen messages from inbox folder
		    Message[] messages = inbox.search(
		        new FlagTerm(new Flags(Flags.Flag.SEEN), false));

		    // Sort messages from recent to oldest
		    Arrays.sort( messages, ( m1, m2 ) -> {
		      try {
		        return m2.getSentDate().compareTo( m1.getSentDate() );
		      } catch ( MessagingException e ) {
		        throw new RuntimeException( e );
		      }
		    });
		    	
		
		    for ( Message message : messages ) {
		    	
		    	writePart(message, message);
		    	  break;		
		    	 }
		    System.out.println("Fetched name " + taskName);
       	 System.out.println("Fetched issued date " + issued_date);
       	 System.out.println("Fetched last date " + last_date);
       	 System.out.println("Fetched description " + description);	
       	 
       	 
       	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3301/test", "root", "root");
			Date utilDate_issued = new SimpleDateFormat("yyyy-MM-dd").parse(issued_date);
			Date utilDate_last = new SimpleDateFormat("yyyy-MM-dd").parse(last_date);
			java.sql.Date issuedDate = new java.sql.Date(utilDate_issued.getTime());
			java.sql.Date lastDate = new java.sql.Date(utilDate_last.getTime());
			String sql = "insert into tasks(name,issued_date,last_date, description,status)values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,taskName);
			stmt.setDate(2, issuedDate);
			stmt.setDate(3,lastDate);
			stmt.setString(4, description);
			stmt.setString(5, String.valueOf(status));
			int res = stmt.executeUpdate();
			if(res == 1) {
				System.out.println("Data inserted");
			}else {
				System.out.println("Data not inserted");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 		
}
	
	
		

		public static void writePart(Part p, Message message) throws Exception{
			System.out.println("---------------------------------");
			
	       
	         //System.out.println(p.getContentType());
	         if(p.isMimeType("text/plain")) {
	        	// System.out.println("This is plain text");
	        	 
	        	 System.out.println(message.getSubject());
	        	 System.out.println(message.getSentDate());
	        	 //System.out.println((String) p.getContent());
	        	 String body = (String) p.getContent();
	        	 String lines[] = body.split("\\r?\\n");
	        	 
	        	 taskName = lines[0].substring(11);
	        	 issued_date = lines[1].substring(13);
	        	 last_date = lines[2].substring(11);
	        	 //skip line 3 which is the description title
	        	 for(int i=4;i<lines.length;i++) {
	        		description += lines[i];
 
	        	 }
	        	 /*System.out.println("Fetched name " + taskName);
	        	 System.out.println("Fetched issued date " + issued_date);
	        	 System.out.println("Fetched last date " + last_date);
	        	 System.out.println("Fetched description " + description);*/
	        	 
	         }
	         if(p.isMimeType("multipart/*")) {
	        	// System.out.println("This is Multipart");
	        	 Multipart mp = (Multipart) p.getContent();
	        	 int count = mp.getCount();
	        	 
	        	 System.out.println("count "+ count);
	             for (int k = 0; k < count-1; k++)
	                writePart(mp.getBodyPart(k), message);
	             
	             System.out.println(" in for loop");
	        	 
	         }
	       
	         System.out.println("end");
	         
  }
}

