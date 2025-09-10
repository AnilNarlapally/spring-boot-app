package com.example.demo.service;

import com.example.demo.qualifier.SmsMessageServiceQualifier;
import org.springframework.stereotype.Service;

@Service("smsService")
@SmsMessageServiceQualifier
public class SmsServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "SMS Service";
    }
}
