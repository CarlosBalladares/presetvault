package com.carlosbf.presetvault.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    @OneToMany
    private List<SocialMediaLink> socialMediaLinks;
    @OneToMany
    private List<Pack> presetPacks;
    @ManyToMany
    private List<User> followers;
    @ManyToMany
    private List<User> following;


    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.socialMediaLinks = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.presetPacks = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<SocialMediaLink> getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(List<SocialMediaLink> socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public List<Pack> getPresetPacks() {
        return presetPacks;
    }

    public void setPresetPacks(List<Pack> presetPacks) {
        this.presetPacks = presetPacks;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void follow(User user){
        if(!user.equals(this)){
            user.followers.add(this);
            this.following.add(user);
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", socialMediaLinks=" + socialMediaLinks +
                ", presetPacks=" + presetPacks +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }
}
