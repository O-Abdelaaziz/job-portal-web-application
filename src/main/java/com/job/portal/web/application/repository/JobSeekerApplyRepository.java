package com.job.portal.web.application.repository;

import com.job.portal.web.application.entity.JobPostActivity;
import com.job.portal.web.application.entity.JobSeekerApply;
import com.job.portal.web.application.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created 20/6/2024 - 2:37 PM on (Thursday)
 * @Package com.job.portal.web.application.repository
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Long> {
    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);
}
