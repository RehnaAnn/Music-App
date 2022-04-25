package com.example.music.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.music.app.model.*;


@Repository
public interface MusicAppRespository extends JpaRepository<Track, Long> {

}