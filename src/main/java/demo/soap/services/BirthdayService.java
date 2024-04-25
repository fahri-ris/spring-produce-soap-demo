package demo.soap.services;

import com.webservicesoap.AgeResponse;
import com.webservicesoap.BirthDateResponse;
import com.webservicesoap.BirthdayNameRequest;
import com.webservicesoap.BirthdayRequest;

import javax.xml.datatype.DatatypeConfigurationException;

public interface BirthdayService {
    public AgeResponse getAge(BirthdayRequest request);
    BirthDateResponse getBirthDate(BirthdayNameRequest birthdayNameRequest) throws DatatypeConfigurationException;
}
