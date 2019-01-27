package test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.*;
import test.repository.UserRepository;
import test.security.UserPrincipal;


import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(PollService.class);

    public List<User> getAllUsers(UserPrincipal currentUser){

        List<User> userList = userRepository.findAll();

        return userList;
    }

}
