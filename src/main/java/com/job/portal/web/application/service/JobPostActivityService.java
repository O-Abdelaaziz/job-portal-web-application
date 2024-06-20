package com.job.portal.web.application.service;

import com.job.portal.web.application.entity.JobCompany;
import com.job.portal.web.application.entity.JobLocation;
import com.job.portal.web.application.entity.JobPostActivity;
import com.job.portal.web.application.payload.IRecruiterJobs;
import com.job.portal.web.application.payload.RecruiterJobsDto;
import com.job.portal.web.application.repository.JobPostActivityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<RecruiterJobsDto> getRecruiterJobs(long recruiter) {

        List<IRecruiterJobs> recruiterJobsDtos = jobPostActivityRepository.getRecruiterJobs(recruiter);

        List<RecruiterJobsDto> recruiterJobsDtoList = new ArrayList<>();

        for (IRecruiterJobs rec : recruiterJobsDtos) {
            JobLocation loc = new JobLocation(rec.getLocationId(), rec.getCity(), rec.getState(), rec.getCountry());
            JobCompany comp = new JobCompany(rec.getCompanyId(), rec.getName(), "");
            recruiterJobsDtoList.add(new RecruiterJobsDto(rec.getTotalCandidates(), rec.getJob_post_id(), rec.getJob_title(), loc, comp));
        }
        return recruiterJobsDtoList;
    }

    public JobPostActivity getJobPostActivityById(long id) {
        return jobPostActivityRepository.findById(id).orElseThrow(() -> new RuntimeException("JobPostActivity not found"));
    }
}
