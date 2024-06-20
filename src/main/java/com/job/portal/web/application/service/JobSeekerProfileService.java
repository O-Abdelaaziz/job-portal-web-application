package com.job.portal.web.application.service;

import com.job.portal.web.application.entity.JobSeekerProfile;
import com.job.portal.web.application.repository.JobSeekerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Created 20/6/2024 - 11:30 AM on (Thursday)
 * @Package com.job.portal.web.application.service
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Service
public class JobSeekerProfileService {

    private final JobSeekerProfileRepository jobSeekerProfileRepository;

    public JobSeekerProfileService(JobSeekerProfileRepository jobSeekerProfileRepository) {
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
    }

    public Optional<JobSeekerProfile> getOne(Long id) {
        return jobSeekerProfileRepository.findById(id);
    }

    public JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile) {
        return jobSeekerProfileRepository.save(jobSeekerProfile);
    }
}
