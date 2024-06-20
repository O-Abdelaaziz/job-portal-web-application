package com.job.portal.web.application.repository;

import com.job.portal.web.application.entity.JobPostActivity;
import com.job.portal.web.application.payload.IRecruiterJobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @Query(value = "SELECT COUNT(s.user_id) as totalCandidates, j.id, j.job_title,l.id as locationId,l.city,l.state,l.country,c.id as companyId,c.name  FROM job_post_activities j\n" +
            "INNER JOIN job_locations l ON j.job_location_id=l.id\n" +
            "INNER JOIN job_companies c ON j.job_company_id=c.id\n" +
            "LEFT JOIN job_seeker_apply s ON s.job_post_activity_id=j.id\n" +
            "WHERE j.user_id=:recruiter GROUP BY j.id" ,nativeQuery = true)
    List<IRecruiterJobs> getRecruiterJobs(@Param("recruiter") long recruiter);

    @Query(value = "SELECT COUNT(s.user_id) as totalCandidates,j.id, j.job_title, j.description_of_job,j.job_type,j.posted_date,j.remote,j.salary,j.job_company_id,j.job_location_id,j.user_id,l.city,l.country,l.state FROM job_post_activities j INNER JOIN job_locations l ON j.job_location_id=l.id " +
            " left join job_seeker_apply s " +
            " on s.job_post_activity_id = j.id " +
            "WHERE j" +
            ".job_title LIKE %:job%"
            + " AND (l.city LIKE %:location%"
            + " OR l.country LIKE %:location%"
            + " OR l.state LIKE %:location%) " +
            " AND (j.job_type IN(:type)) " +
            " AND (j.remote IN(:remote)) ", nativeQuery = true)
    List<JobPostActivity> searchWithoutDate(@Param("job") String job,
                                            @Param("location") String location,
                                            @Param("remote") List<String> remote,
                                            @Param("type") List<String> type);

    @Query(value = "SELECT COUNT(s.user_id) as totalCandidates,j.id, j.job_title, j.description_of_job,j.job_type,j.posted_date,j.remote,j.salary,j.job_company_id,j.job_location_id,j.user_id,l.city,l.country,l.state FROM job_post_activities j INNER JOIN job_locations l ON j.job_location_id=l.id " +
            " left join job_seeker_apply s " +
            " on s.job_post_activity_id = j.id " +
            "WHERE j" +
            ".job_title LIKE %:job%"
            + " AND (l.city LIKE %:location%"
            + " OR l.country LIKE %:location%"
            + " OR l.state LIKE %:location%) " +
            " AND (j.job_type IN(:type)) " +
            " AND (j.remote IN(:remote)) " +
            " AND (j.posted_date >= :date)", nativeQuery = true)
    List<JobPostActivity> search(@Param("job") String job,
                                 @Param("location") String location,
                                 @Param("remote") List<String> remote,
                                 @Param("type") List<String> type,
                                 @Param("date") LocalDate searchDate);
}
