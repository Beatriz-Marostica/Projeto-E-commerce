package br.edu.utfpr.pb.pw44s.server.repository;

import br.edu.utfpr.pb.pw44s.server.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    //select * from tb_category where name like '%te%'
    List<Category> findByNameContaining (String name);

    //findyByStartingWith = pega o comeco 'te%'

   // @Query(value = "select * from tb_category where name LIKE :name",
   //         nativeQuery = true)

}
