package com.carlosbf.presetvault.api;

import com.carlosbf.presetvault.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel ="users", path = "/users")
public interface UserRestResource extends CrudRepository<User, Long> {
}
