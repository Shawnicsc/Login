package com.pojo;

import org.apache.ibatis.type.Alias;

@Alias("brand")
public class Brand {
    private Integer id;
    private String companyName;
    private String brandName;
    private String description;
    private Integer ordered;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public Integer getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", description='" + description + '\'' +
                ", ordered=" + ordered +
                ", status=" + status +
                '}';
    }
}
