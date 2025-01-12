package controllers;

import entities.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  entities.EmailRequest;
import org.springframework.web.multipart.MultipartFile;
import services.EmailService;

import java.io.IOException;

@RestController
@RequestMapping("/email")
public class EmailController {

    private EmailService emailService;
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    //send email
    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody  EmailRequest request) {
        emailService.sendEmailWithHtml(request.getTo(),request.getSubject(),request.getMessage());
        return ResponseEntity.ok(CustomResponse.builder().message("Email sent successfully").httpStatus(HttpStatus.OK).success(true).build());
    }
    //send with file
    @PostMapping("/send-with-file")
    public ResponseEntity<CustomResponse> sendEmailWithFile(@RequestPart  EmailRequest request, @RequestPart MultipartFile file) throws IOException {
        emailService.sendEmailWithFile(request.getTo(),request.getSubject(), request.getMessage(), file.getInputStream());
        return ResponseEntity.ok(CustomResponse.builder().message("Email sent successfully").httpStatus(HttpStatus.OK).success(true).build());

    }


}
