package com.job.portal.web.application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Created 20/6/2024 - 9:31 AM on (Thursday)
 * @Package com.job.portal.web.application.entity
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "job_seeker_apply" ,uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "job_post_activity_id"})})
public class JobSeekerApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date applyDate;

    private String coverLetter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private JobSeekerProfile userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_post_activity_id", referencedColumnName = "id")
    private JobPostActivity job;
}
