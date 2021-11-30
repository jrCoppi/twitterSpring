package repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}