package com.neo.test.repository;

import com.neo.test.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonRepository extends Neo4jRepository<Person,Long> {
    Person findByName(@Param("name") String name);
    @Query("MATCH (t:Person) WHERE t.name =~('(?i).*'+{name}+'.*') RETURN t")
    Collection<Person> findByPersonName(@Param("name") String name);
}
