package com.neo.test.repository;

import com.neo.test.domain.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor,Long> {
    Actor findByName(@Param("name") String name);
    @Query("MATCH (m:Movie) WHERE m.name =~ ('(?i).*'+{name}+'.*') RETURN m")
    Page<Actor> findByName(@Param("name") String name, Pageable pageable);
}
