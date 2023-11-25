package lld.facebook.v1.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@NoArgsConstructor
@Getter
@Setter
public class Post {
    private int id;
    private User user;
    private String description;
    private Date date;
    private ArrayList<Comment> comments;

    //ids of users who liked the posts;
    private HashSet<Integer> likes;
    private HashSet<Integer> unlikes;
    public Post(int id, User user, String description){
        this.id = id;
        this.user = user;
        this.description = description;
    }
}
