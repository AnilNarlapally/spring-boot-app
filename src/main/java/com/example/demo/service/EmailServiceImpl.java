package com.example.demo.service;

import com.example.demo.qualifier.EmailMessageServiceQualifier;
import org.springframework.stereotype.Service;

@Service("emailService")
@EmailMessageServiceQualifier
public class EmailServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "email service";
    }
}
