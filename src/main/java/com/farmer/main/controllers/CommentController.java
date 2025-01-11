package com.farmer.main.controllers;

import com.farmer.main.entities.Comment;
import com.farmer.main.entities.Post;
import com.farmer.main.entities.User;
import com.farmer.main.services.CommentService;
import com.farmer.main.services.PostService;
import com.farmer.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping("/{postId}")
    public Comment saveComment(@PathVariable Long postId, @RequestBody Comment comment) {
        // Fetch the Post to associate the Comment
        Post post = postService.getPostById(postId);

        // Set the Post in the Comment
        comment.setPost(post);

        // Save the Comment
        Comment savedComment = commentService.saveComment(comment);

        // Link the Comment to the User via the Post
        User user = post.getUser();
        if (user != null) {
            user.getComments().add(savedComment);
            userService.saveUser(user); // This will populate the user_comment table
        }

        return savedComment;
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
