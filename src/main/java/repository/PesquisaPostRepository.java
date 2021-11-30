package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.PesquisaPost;


@Repository
public interface PesquisaPostRepository extends CrudRepository<PesquisaPost, Long> {

}
