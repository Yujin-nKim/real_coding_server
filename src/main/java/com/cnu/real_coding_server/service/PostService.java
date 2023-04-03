package com.cnu.real_coding_server.service;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(PostRequest postRequest) {
        //model이여서 저장되는 값은 아니고 entity를 저장할꺼임
        return postRepository.save(postRequest.toEntity());
    }
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
    public Optional<Post> getPost(Integer postId) {
        return postRepository.findById(postId);
    }
    public Optional<Post> updatePost(Integer postId, PostRequest postRequest) {
        return postRepository.findById(postId)
                .map(post -> {
                    post.setTitle(postRequest.getTitle());
                    post.setContents(postRequest.getContents());
                    post.setTag(postRequest.getTag());
                    return postRepository.save(post);
                });
    }
    public void deletePost(Integer postId) {
        postRepository.findById(postId)
//                        .ifPresent(post -> postRepository.delete(post));
                .ifPresent(postRepository::delete);

    }
}
