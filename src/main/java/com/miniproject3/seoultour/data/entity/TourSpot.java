package com.miniproject3.seoultour.data.entity;

import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
@Table(name = "tourspot")
public class TourSpot {

    @Id
    private Long id;
    private String placename;
    private String addr;
    private Double mapx;
    private Double mapy;
    private String overview;
    private String detail;
    private String tourtype;

}