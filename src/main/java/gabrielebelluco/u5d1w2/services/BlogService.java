package gabrielebelluco.u5d1w2.services;

import gabrielebelluco.u5d1w2.entities.Blog;
import gabrielebelluco.u5d1w2.exception.NotFoundException;
import gabrielebelluco.u5d1w2.payload.NewBlogPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BlogService {
    private List<Blog> blogDB = new ArrayList<>();

    public List<Blog> findAll() {
        return this.blogDB;
    }


    public Blog saveBlog(NewBlogPayload payload) {
        Blog newBlog = new Blog(payload.getCategoria(), payload.getTitolo(), payload.getTempoDiLettura(), payload.getContenuto(), payload.getCover());
        this.blogDB.add(newBlog);
        log.info("L'utente " + newBlog.getId() + " è stato aggiunto correttamente");
        return newBlog;
    }

    public Blog findById(long blogId) {
        Blog found = null;
        for (Blog blog : this.blogDB) {
            if (blog.getId() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    public Blog findByIdAndUpdate(long blogId, NewBlogPayload payload) {
        Blog found = null;
        for (Blog blog : this.blogDB) {
            if (blog.getId() == blogId) {
                found = blog;
                found.setCategoria(payload.getCategoria());
                found.setTitolo(payload.getTitolo());
                found.setTempoDiLettura(payload.getTempoDiLettura());
                found.setContenuto(payload.getContenuto());
                found.setCover(payload.getCover());

            }
        }
        if (found == null) throw new NotFoundException(blogId);
        return found;
    }

    public void findByIdAndDelete(long blogId) {
        Blog found = null;
        for (Blog blog : this.blogDB) {
            if (blog.getId() == blogId) found = blog;
        }
        if (found == null) throw new NotFoundException(blogId);
        this.blogDB.remove(found);
    }
}
