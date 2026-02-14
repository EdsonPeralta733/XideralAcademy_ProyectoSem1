package org.xideral.academy.restspringmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xideral.academy.restspringmysql.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> { }