package repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.Pesquisa;


@Repository
public interface PesquisaRepository extends CrudRepository<Pesquisa, Long> {
    		
	//Return search by a company name
    @Query("SELECT po.ds_post FROM Pesquisa p "
    		+ "INNER JOIN PesquisaPost pp ON ( pp.id_pesquisa = p.id_pesquisa) "
    		+ "INNER JOIN Termo t ON (t.id_termo = p.id_termo)"
    		+ "INNER JOIN Post po ON ( pp.id_post = po.id_post) "
    		+ "WHERE t.ds_termo like %:ds_termo%")
    ArrayList<String> findByTerm(@Param("ds_termo") String ds_termo);
}
