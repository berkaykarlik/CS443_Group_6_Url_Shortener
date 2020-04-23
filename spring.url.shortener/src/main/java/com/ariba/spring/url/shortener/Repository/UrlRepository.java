package com.ariba.spring.url.shortener.Repository;


        import com.ariba.spring.url.shortener.model.Url;
        import org.springframework.data.mongodb.repository.MongoRepository;


public interface UrlRepository extends MongoRepository<Url,String> {

}
