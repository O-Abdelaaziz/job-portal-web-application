package com.job.portal.web.application.repository;

import com.job.portal.web.application.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Created 19/6/2024 - 10:50 AM on (Wednesday)
 * @Package com.job.portal.web.application.repository
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Long> {
}
