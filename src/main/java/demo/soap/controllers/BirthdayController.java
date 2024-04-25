package demo.soap.controllers;

import com.webservicesoap.AgeResponse;
import com.webservicesoap.BirthdayRequest;
import demo.soap.services.BirthdayService;
import demo.soap.services.BirthdayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BirthdayController {
    private BirthdayService birthdayService;
    private static final String NAMESPACE = "http://www.webservicesoap.com";

    @Autowired
    public BirthdayController(BirthdayService birthdayService) {
        this.birthdayService = birthdayService;
    }

    @PayloadRoot(localPart = "birthdayRequest", namespace = NAMESPACE)
    @ResponsePayload
    public AgeResponse getBirthday(@RequestPayload BirthdayRequest request) {
        return birthdayService.getAge(request);
    }
}
