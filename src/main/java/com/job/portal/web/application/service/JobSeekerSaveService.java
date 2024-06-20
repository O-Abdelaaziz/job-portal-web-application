package com.job.portal.web.application.service;

import com.job.portal.web.application.entity.JobPostActivity;
import com.job.portal.web.application.entity.JobSeekerProfile;
import com.job.portal.web.application.entity.JobSeekerSave;
import com.job.portal.web.application.repository.JobSeekerSaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created 20/6/2024 - 2:40 PM on (Thursday)
 * @Package com.job.portal.web.application.service
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Service
public class JobSeekerSaveService {

    private final JobSeekerSaveRepository jobSeekerSaveRepository;

    public JobSeekerSaveService(JobSeekerSaveRepository jobSeekerSaveRepository) {
        this.jobSeekerSaveRepository = jobSeekerSaveRepository;
    }

    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId) {
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerSave> getJobCandidates(JobPostActivity job) {
        return jobSeekerSaveRepository.findByJob(job);
    }

    public void addNew(JobSeekerSave jobSeekerSave) {
        jobSeekerSaveRepository.save(jobSeekerSave);
    }
}
