package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository  extends PagingAndSortingRepository<User,Long> {
}
