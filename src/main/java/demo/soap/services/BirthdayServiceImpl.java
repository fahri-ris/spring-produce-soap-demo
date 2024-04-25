package demo.soap.services;

import com.webservicesoap.AgeResponse;
import com.webservicesoap.BirthDateResponse;
import com.webservicesoap.BirthdayNameRequest;
import com.webservicesoap.BirthdayRequest;
import demo.soap.models.Birthday;
import demo.soap.repositories.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class BirthdayServiceImpl implements BirthdayService {
    BirthdayRepository birthdayRepository;

    @Autowired
    public BirthdayServiceImpl(BirthdayRepository birthdayRepository) {
        this.birthdayRepository = birthdayRepository;
    }

    @Override
    public AgeResponse getAge(BirthdayRequest request){
        AgeResponse getAgeResponse = new AgeResponse();
        if(validateDay(request) && validateMonth(request) && validateYear(request)) {
            getAgeResponse.setAge(getAge(request.getDay(), request.getMonth(), request.getYear()));
        }

        return getAgeResponse;
    }

    @Override
    public BirthDateResponse getBirthDate(BirthdayNameRequest birthdayNameRequest) {
        try{
            Birthday birthday = birthdayRepository.findByFullNameIgnoreCase(birthdayNameRequest.getFullName());
            if(birthday == null){
                throw new EntityNotFoundException("Name " + birthdayNameRequest.getFullName() + " not found");
            }

            BirthDateResponse birthDateResponse = new BirthDateResponse();
            birthDateResponse.setId(birthday.getId());
            birthDateResponse.setFullName(birthday.getFullName());
            birthDateResponse.setBirthDate(birthday.getBirthDate());

            return birthDateResponse;
        } catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public boolean validateDay(BirthdayRequest request) {
        return request.getDay() > 0 && request.getDay() <= 31;
    }

    public boolean validateMonth(BirthdayRequest request) {
        return request.getMonth() > 0 && request.getMonth() <= 12;
    }

    public boolean validateYear(BirthdayRequest request) {
        return request.getYear() >= 1920 && request.getYear() <= LocalDate.now().getYear();
    }

    public int getAge(int day, int month, int year) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);

        Period period = Period.between(birthday, today);
        return period.getYears();
    }
}
