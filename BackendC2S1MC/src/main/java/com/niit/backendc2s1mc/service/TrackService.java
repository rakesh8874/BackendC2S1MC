package com.niit.backendc2s1mc.service;

import com.niit.backendc2s1mc.domain.Track;

import java.util.List;

public interface TrackService {

    Track save(Track track);
    List<Track> fetchAllTracks();
    Track fetchATrackByTractId(int id);
    String deleteATrack(int id);
    List<Track> fetchTrackByTrackArtist(String artist);
    Track updateTrackDetails(Track track);
}
