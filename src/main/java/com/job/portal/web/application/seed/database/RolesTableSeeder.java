package com.job.portal.web.application.seed.database;

import com.job.portal.web.application.entity.UserType;
import com.job.portal.web.application.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Created 27/6/2024 - 12:10 PM on (Thursday)
 * @Package com.job.portal.web.application.seed.database
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/


@Component
public class RolesTableSeeder {
    private final UserTypeRepository userTypeRepository;

    @Autowired
    public RolesTableSeeder(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public void seedRolesTable() {
        long roles = userTypeRepository.count();
        if (roles <= 0) {
            UserType userTypeRecruiter = new UserType("Recruiter");
            UserType userTypeJobSeeker = new UserType("Job Seeker");
            userTypeRepository.saveAll(Arrays.asList(userTypeRecruiter, userTypeJobSeeker));
        }
    }
}
