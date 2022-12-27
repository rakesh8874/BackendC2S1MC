package com.niit.backendc2s1mc.service;

import com.niit.backendc2s1mc.domain.Track;
import com.niit.backendc2s1mc.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track save(Track track) {
        if(trackRepository.findById(track.getTrackId()).isEmpty()){
            return trackRepository.save(track);
        }
        return null;
    }

    @Override
    public List<Track> fetchAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track fetchATrackByTractId(int id) {
        return this.trackRepository.findById(id).get();
    }

    @Override
    public String deleteATrack(int id) {
        if(trackRepository.findById(id).isEmpty()){
            return "Track Doesn't Exist";
        }
        trackRepository.deleteById(id);
        return "Track Deleted Successfully";
    }

    @Override
    public List<Track> fetchTrackByTrackArtist(String artist) {
        return trackRepository.findBytrackArtist(artist);
    }

    @Override
    public Track updateTrackDetails(Track track) {
        if(trackRepository.findById(track.getTrackId()).isEmpty()){
            return null;
        }
        Track tempTrack = trackRepository.findById(track.getTrackId()).get();
        tempTrack.setTrackId(track.getTrackId());
        tempTrack.setTrackName(track.getTrackName());
        tempTrack.setTrackComments(track.getTrackComments());
        tempTrack.setTrackArtist(track.getTrackArtist());
        tempTrack.setTrackRating(track.getTrackRating());
        return trackRepository.save(tempTrack);
    }
}
