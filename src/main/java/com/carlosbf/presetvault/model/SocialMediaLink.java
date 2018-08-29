package com.carlosbf.presetvault.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class SocialMediaLink{
    public enum SocialMediaType{
        FACEBOOK, TWITTER, DISCORD, SOUNDCLOUD, YOUTUBE, INSTAGRAM
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String url;
    public SocialMediaType type;

    public SocialMediaLink(Long id, String url, SocialMediaType type) {
        this.id = id;
        this.url = url;
        this.type = type;
    }

    public SocialMediaLink(String url, SocialMediaType type) {
        this.url = url;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SocialMediaType getType() {
        return type;
    }

    public void setType(SocialMediaType type) {
        this.type = type;
    }
}


