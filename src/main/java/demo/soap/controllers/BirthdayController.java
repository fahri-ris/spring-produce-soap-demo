package demo.soap.controllers;

import com.webservicesoap.AgeResponse;
import com.webservicesoap.BirthDateResponse;
import com.webservicesoap.BirthdayNameRequest;
import com.webservicesoap.BirthdayRequest;
import demo.soap.services.BirthdayService;
import demo.soap.services.BirthdayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;

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

    @PayloadRoot(localPart = "birthdayNameRequest", namespace = NAMESPACE)
    @ResponsePayload
    public BirthDateResponse getBirthDate(@RequestPayload BirthdayNameRequest request) throws DatatypeConfigurationException {
        return birthdayService.getBirthDate(request);
    }
}
