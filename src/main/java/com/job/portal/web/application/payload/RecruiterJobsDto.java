package com.job.portal.web.application.payload;

import com.job.portal.web.application.entity.JobCompany;
import com.job.portal.web.application.entity.JobLocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Created 20/6/2024 - 8:57 AM on (Thursday)
 * @Package com.job.portal.web.application.payload
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecruiterJobsDto {
    private Long totalCandidates;
    private Long id;
    private String jobTitle;
    private JobLocation jobLocation;
    private JobCompany jobCompany;
}
