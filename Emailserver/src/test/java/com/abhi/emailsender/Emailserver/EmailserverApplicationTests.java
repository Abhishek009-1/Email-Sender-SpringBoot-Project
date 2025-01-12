package com.abhi.emailsender.Emailserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import services.EmailService;
import services.impl.EmailServiceImpl;

import javax.xml.validation.Schema;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class EmailserverApplicationTests {

	@Autowired
	private EmailService emailService;

	@Test
	void emailSendTest() {
		System.out.println("Email send Test");
		emailService.sendEmail("@gmail.com","Hi, wassup","Hi Boss");
	}

	@Test
	void sendHtmlInEmail() {
		String html = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				"<style>\n" +
				"  body { font-family: Arial, sans-serif; background-color: #f0f0f0; }\n" +
				"  h1 { color: #333; }\n" +
				"  p { color: #666; font-size: 14px; }\n" +
				"</style>\n" +
				"<title>Styled HTML Page</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"  <h1>Welcome to My Styled HTML Page</h1>\n" +
				"  <p>This is a sample paragraph with some basic styling.</p>\n" +
				"</body>\n" +
				"</html>";

		emailService.sendEmailWithHtml("@gmail.com","Hi, wassup",html);
	}

	@Test
	void sendEmailWithFile(){
		emailService.sendEmailWithFile("@gmail.com", "Email with file", "Hi sending you email with file",new File("C:\\Users\\hp\\OneDrive\\Desktop\\Email Project\\Emailserver\\src\\main\\resources\\static\\TestFile\\GeeksforGeeks.png"));
	}

	@Test
	void sendEmailwithStream(){
		File file= new File("C:\\Users\\hp\\OneDrive\\Desktop\\Email Project\\Emailserver\\src\\main\\resources\\static\\TestFile\\GeeksforGeeks.png");
        try {
            InputStream inputStream = new FileInputStream(file);
			emailService.sendEmailWithFile("@gmail.com", "Email with stream file","Sending same but with stream", inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
