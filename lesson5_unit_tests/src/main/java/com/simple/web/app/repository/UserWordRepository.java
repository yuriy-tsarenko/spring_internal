package com.simple.web.app.repository;

import com.simple.web.app.entity.UserWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWordRepository extends JpaRepository<UserWord, Long> {

}
