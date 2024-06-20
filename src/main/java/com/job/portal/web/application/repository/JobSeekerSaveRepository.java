package com.job.portal.web.application.repository;

import com.job.portal.web.application.entity.JobPostActivity;
import com.job.portal.web.application.entity.JobSeekerProfile;
import com.job.portal.web.application.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created 20/6/2024 - 2:39 PM on (Thursday)
 * @Package com.job.portal.web.application.repository
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Service
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Long> {
    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);
}
