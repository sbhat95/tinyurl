package com.shorturl.changer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shorturl.changer.model.URL;

@Repository
public interface URLRepository extends JpaRepository<URL, String> {

}
