package epicode.U5W2D1.controllers;

import epicode.U5W2D1.entities.BlogPost;
import epicode.U5W2D1.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPost")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    //Get All BlogPosts
    @GetMapping
    public List<BlogPost> getAllBlogposts() { return this.blogPostService.getBlogPosts();}

    //Get BlogPost By ID
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable int id) {
        return this.blogPostService.findById(id);
    }

    //Save BlogPost
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPost newBlogPost) {return this.blogPostService.saveBlogPost(newBlogPost);}

    @PutMapping("/{id}")
    public BlogPost findByAndUpdate(@PathVariable int id, @RequestBody BlogPost updatedBlogPost){
        return this.blogPostService.findByIdAndUpdate(id, updatedBlogPost);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id) {this.blogPostService.findByIdAndDelete(id);}
}

