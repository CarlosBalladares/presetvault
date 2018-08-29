package com.carlosbf.presetvault.repositories;

import com.carlosbf.presetvault.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
}
