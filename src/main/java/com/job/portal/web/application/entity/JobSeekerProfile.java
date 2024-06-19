package com.job.portal.web.application.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Created 19/6/2024 - 10:32 AM on (Wednesday)
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
@Table(name = "job_seeker_profile")
public class JobSeekerProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "work_authorization")
    private String workAuthorization;

    @Column(name = "employment_type")
    private String employmentType;

    @Column(name = "resume")
    private String resume;

    @Column(name = "photo")
    private String photo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "jobSeekerProfile", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Skill> skills;

    public JobSeekerProfile(User user) {
        this.user = user;
    }
}
