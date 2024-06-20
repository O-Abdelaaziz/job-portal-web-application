package com.job.portal.web.application.repository;

import com.job.portal.web.application.entity.JobPostActivity;
import com.job.portal.web.application.payload.IRecruiterJobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created 19/6/2024 - 9:38 PM on (Wednesday)
 * @Package com.job.portal.web.application.repository
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Long> {

    @Query(value = "SELECT j.id as job_post_id, j.job_title,l.id as locationId,l.city,l.state,l.country,c.id as companyId,c.name  FROM job_post_activities j\n" +
            "INNER JOIN job_locations l ON j.job_location_id=l.id\n" +
            "INNER JOIN job_companies c ON j.job_company_id=c.id\n" +
            "LEFT JOIN job_seeker_apply s ON s.job_post_activity_id=j.id\n" +
            "WHERE j.user_id=:recruiter GROUP BY j.id" ,nativeQuery = true)
    List<IRecruiterJobs> getRecruiterJobs(@Param("recruiter") long recruiter);
}
