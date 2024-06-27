package com.job.portal.web.application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Created 19/6/2024 - 9:03 PM on (Wednesday)
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
@Table(name = "job_post_activities")
public class JobPostActivity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "description_of_job", columnDefinition = "TEXT")
//    @Length(max = 10000)
    private String descriptionOfJob;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "salary")
    private String salary;

    @Column(name = "remote")
    private String remote;

    @Column(name = "posted_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postedDate;

    @Transient
    private Boolean isActive;

    @Transient
    private Boolean isSaved;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User postedBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_location_id", referencedColumnName = "id")
    private JobLocation jobLocation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_company_id", referencedColumnName = "id")
    private JobCompany jobCompany;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<JobSeekerApply> jobSeekerApplies = new ArrayList<>();

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<JobSeekerSave> jobSeekerSaves = new ArrayList<>();
}

