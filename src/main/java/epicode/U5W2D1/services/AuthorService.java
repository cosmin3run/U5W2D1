package epicode.U5W2D1.services;

import epicode.U5W2D1.entities.Author;
import epicode.U5W2D1.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();



    public List<Author> getAuthors() {return this.authors;}

    public Author saveAuthor(Author newAuthor) {
        Random rndm = new Random();
        newAuthor.setId(rndm.nextInt(1,1000));
        this.authors.add(newAuthor);
        return newAuthor;
    }

    public Author findById(int id) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
            }
        }
        if (found == null) throw new NotFoundException();
        else return found;
    }

    public Author findByIdAndUpdate(int id, Author updatedBlogpost){
        Author found = null;
        for (Author author : this.authors){
            if (author.getId() == id){
                found = author;
                found.setName(updatedBlogpost.getName());
                found.setSurname(updatedBlogpost.getSurname());
                found.setEmail(updatedBlogpost.getEmail());
                found.setDateBirth(updatedBlogpost.getDateBirth());
                found.setAvatar(updatedBlogpost.getAvatar());
            }
        }
        if (found == null) throw new NotFoundException();
        else return found;
    }

    public void findByIdAndDelete(int id) {
        Iterator<Author> iterator = this.authors.iterator();
        while (iterator.hasNext()){
            Author current = iterator.next();
            if (current.getId() == id){
                iterator.remove();
            }
        }
    }

}
