package lld.facebook.v1.services;

import lld.facebook.v1.models.Post;
import lld.facebook.v1.models.User;

import java.util.ArrayList;

public class PostService {
    private ArrayList<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
    }

    public Post createPost(User user, String description){
        Post post = new Post(posts.size(), user, description);
        posts.add(post);
        return post;
    }

    //this assumes postId is not out of bounds on either extremes
    // need to consider whether posts can be deleted;
    //if posts are allowed to be deleted what to store in place of old post - null? or optional?
    public Post getPost(int postId){
        return posts.get(postId);
    }

}
