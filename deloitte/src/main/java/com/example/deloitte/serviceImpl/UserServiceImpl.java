package com.example.deloitte.serviceImpl;

import com.example.deloitte.entity.Registration;
import com.example.deloitte.repository.RegistrationRepository;
import com.example.deloitte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RegistrationRepository registrationRepository;

    @Override
    public String registerUser(Registration registration) {
        try {
            if (registration != null) {
                registrationRepository.save(registration);
                return "Saved";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
