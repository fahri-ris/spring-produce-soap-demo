package demo.soap.services;

import com.webservicesoap.AgeResponse;
import com.webservicesoap.BirthdayRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class BirthdayServiceImpl implements BirthdayService {
    public AgeResponse getAge(BirthdayRequest request){
        AgeResponse getAgeResponse = new AgeResponse();
        if(validateDay(request) && validateMonth(request) && validateYear(request)) {
            getAgeResponse.setAge(getAge(request.getDay(), request.getMonth(), request.getYear()));
        }  return getAgeResponse;

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
