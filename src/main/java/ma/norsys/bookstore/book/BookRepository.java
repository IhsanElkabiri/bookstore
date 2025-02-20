package ma.norsys.bookstore.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Query("SELECT b FROM Book b where UPPER(b.name) LIKE UPPER(concat('%',:name,'%'))")
    List<Book> searchByCriteria(@Param("name") String name);
}
