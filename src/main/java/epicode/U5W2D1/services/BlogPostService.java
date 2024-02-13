package epicode.U5W2D1.services;

import epicode.U5W2D1.entities.Author;
import epicode.U5W2D1.entities.BlogPost;
import epicode.U5W2D1.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts = new ArrayList<>();




    public  List<BlogPost> getBlogPosts(){return this.blogPosts;}

    public BlogPost saveBlogPost(BlogPost newBlogPost){
        Random rndm = new Random();
        newBlogPost.setId(rndm.nextInt(1,1000));
        this.blogPosts.add(newBlogPost);
        return newBlogPost;
    }

    public BlogPost findById(int id){
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPosts){
            if (blogPost.getId() == id){
                found = blogPost;
            }
        }
        if (found == null) throw new NotFoundException();
        else return found;
    }



    public BlogPost findByIdAndUpdate(int id, BlogPost updatedBlogPost) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPosts) {
            if (blogPost.getId() == id) {
                found = blogPost;
                found.setTitle(updatedBlogPost.getCategory());
                found.setCategory(updatedBlogPost.getCategory());
                found.setCover(updatedBlogPost.getCover());
            }
        }
        if (found == null) throw new NotFoundException();
        else return found;
    }

    public void findByIdAndDelete(int id){
        Iterator<BlogPost> iterator = this.blogPosts.iterator();
        while (iterator.hasNext()){
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
