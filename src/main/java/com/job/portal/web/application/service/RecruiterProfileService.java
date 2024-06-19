package com.job.portal.web.application.service;

import com.job.portal.web.application.entity.RecruiterProfile;
import com.job.portal.web.application.repository.RecruiterProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Created 19/6/2024 - 7:32 PM on (Wednesday)
 * @Package com.job.portal.web.application.service
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Service
public class RecruiterProfileService {

    private final RecruiterProfileRepository recruiterProfileRepository;

    @Autowired
    public RecruiterProfileService(RecruiterProfileRepository recruiterProfileRepository) {
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Optional<RecruiterProfile> getOne(Long id) {
        return recruiterProfileRepository.findById(id);
    }
}
