package gabrielebelluco.u5d1w2.controllers;

import gabrielebelluco.u5d1w2.entities.Blog;
import gabrielebelluco.u5d1w2.payload.NewBlogPayload;
import gabrielebelluco.u5d1w2.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogsController {
    private final BlogService blogService;

    @Autowired
    public BlogsController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> findAll() {
        return this.blogService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Blog createBlog(@RequestBody NewBlogPayload payload) {
        return this.blogService.saveBlog(payload);
    }

    @GetMapping("/{blogId}")
    public Blog getBlogById(@PathVariable long blogId) {
        return this.blogService.findById(blogId);
    }

    @PutMapping("/{blogId}")
    public Blog getBlogByIdAndUpdate(@PathVariable long blogId, @RequestBody NewBlogPayload payload) {
        return this.blogService.findByIdAndUpdate(blogId, payload);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void getBlogByIdAndDelete(@PathVariable long blogId) {
        this.blogService.findByIdAndDelete(blogId);
    }
}
