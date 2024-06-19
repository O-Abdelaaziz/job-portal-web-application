package com.job.portal.web.application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Created 18/6/2024 - 6:17 PM on (Tuesday)
 * @Package com.job.portal.web.application.entity
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private Boolean isActive;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    private UserType userType;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private JobSeekerProfile jobSeekerProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private RecruiterProfile recruiterProfile;

    public User setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        if (jobSeekerProfile == null) {
            if (this.jobSeekerProfile != null) {
                this.jobSeekerProfile.setUser(null);
            }
        } else {
            jobSeekerProfile.setUser(this);
        }
        this.jobSeekerProfile = jobSeekerProfile;
        return this;
    }

    public User setRecruiterProfile(RecruiterProfile recruiterProfile) {
        if (recruiterProfile == null) {
            if (this.recruiterProfile != null) {
                this.recruiterProfile.setUser(null);
            }
        } else {
            recruiterProfile.setUser(this);
        }
        this.recruiterProfile = recruiterProfile;
        return this;
    }

}
