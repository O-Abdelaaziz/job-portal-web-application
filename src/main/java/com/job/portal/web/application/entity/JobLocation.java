package com.job.portal.web.application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Created 19/6/2024 - 9:26 PM on (Wednesday)
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
@Table(name = "job_locations")
public class JobLocation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "jobLocation")
    @ToString.Exclude
    private List<JobPostActivity> jobPostActivities;
}
