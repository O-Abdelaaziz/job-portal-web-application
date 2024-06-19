package com.job.portal.web.application.service;

import com.job.portal.web.application.entity.JobSeekerProfile;
import com.job.portal.web.application.entity.RecruiterProfile;
import com.job.portal.web.application.entity.User;
import com.job.portal.web.application.repository.JobSeekerProfileRepository;
import com.job.portal.web.application.repository.RecruiterProfileRepository;
import com.job.portal.web.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Created 19/6/2024 - 10:12 AM on (Wednesday)
 * @Package com.job.portal.web.application.service
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RecruiterProfileRepository recruiterProfileRepository, JobSeekerProfileRepository jobSeekerProfileRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        user.setIsActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        long userType = savedUser.getUserType().getId();
        if (userType == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return savedUser;
    }
}
