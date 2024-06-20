package com.job.portal.web.application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Created 19/6/2024 - 9:28 PM on (Wednesday)
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
@Table(name = "job_companies")
public class JobCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "industry")
    private String industry;

    @Column(name = "website")
    private String website;

    @Column(name = "logo")
    private String logo;

    @OneToMany(mappedBy = "jobCompany")
    @ToString.Exclude
    private List<JobPostActivity> jobPostActivities;

    public JobCompany(Long id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }
}
