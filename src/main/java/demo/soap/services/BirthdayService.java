package demo.soap.services;

import com.webservicesoap.AgeResponse;
import com.webservicesoap.BirthdayRequest;

public interface BirthdayService {
    public AgeResponse getAge(BirthdayRequest request);
}
