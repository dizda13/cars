package com.example.test1.Users;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
