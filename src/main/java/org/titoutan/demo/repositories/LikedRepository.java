package org.titoutan.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import org.titoutan.demo.models.Liked;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface LikedRepository extends CrudRepository<Liked, Integer> {

}