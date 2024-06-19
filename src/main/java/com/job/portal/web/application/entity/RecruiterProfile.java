package com.job.portal.web.application.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * @Created 19/6/2024 - 10:23 AM on (Wednesday)
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
@Table(name = "recruiter_profile")
public class RecruiterProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "photo", length = 64)
    private String photo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    @ToString.Exclude
    private User user;

    public RecruiterProfile(User user) {
        this.user = user;
    }

    @Transient
    public String getPhotosImagePath() {
        if (photo == null) return null;
        return "/photos/recruiter/" + id + "/" + photo;
    }
}
