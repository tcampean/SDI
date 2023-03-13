package core.repository;

import core.domain.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface ArtistRepository extends CatalogRepository<Artist, Long> {
    


}
