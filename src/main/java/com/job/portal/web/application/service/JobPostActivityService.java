package com.job.portal.web.application.service;

import com.job.portal.web.application.entity.JobPostActivity;
import com.job.portal.web.application.repository.JobPostActivityRepository;
import org.springframework.stereotype.Service;

/**
 * @Created 19/6/2024 - 9:38 PM on (Wednesday)
 * @Package com.job.portal.web.application.service
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Service
public class JobPostActivityService {

    private final JobPostActivityRepository jobPostActivityRepository;

    public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
    }

    public JobPostActivity addNew(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity);
    }
}
