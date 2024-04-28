package com.zipcodewilmington.bakery.repositories;

import com.zipcodewilmington.bakery.models.Muffin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Responsible for interacting with the database to collect and store User objects
public interface MuffinRepository extends CrudRepository<Muffin, Long> {
}
