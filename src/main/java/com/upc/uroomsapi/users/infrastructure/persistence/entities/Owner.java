package com.upc.uroomsapi.users.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.upc.uroomsapi.publications.infrastructure.persistence.entities.Post;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner extends User {
    private long dni;

    //UN "arrendador" puede tener MUCHOS "posts"
    @JsonBackReference
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts = new HashSet<>();

    public Owner() {}

    public long getDni() {
        return dni;
    }
    public void setDni(long dni) {
        this.dni = dni;
    }

    public Set<Post> getPosts() {
        return posts;
    }
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
