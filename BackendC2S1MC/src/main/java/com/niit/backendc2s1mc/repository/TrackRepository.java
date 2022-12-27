package com.niit.backendc2s1mc.repository;

import com.niit.backendc2s1mc.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<Track> findBytrackArtist(String artistName);
}
