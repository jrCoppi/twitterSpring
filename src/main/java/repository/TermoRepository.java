package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Termo;

@Repository
public interface TermoRepository extends CrudRepository<Termo, Long> {

}
