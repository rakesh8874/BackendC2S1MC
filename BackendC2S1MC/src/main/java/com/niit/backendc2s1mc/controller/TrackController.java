package com.niit.backendc2s1mc.controller;

import com.niit.backendc2s1mc.domain.Track;
import com.niit.backendc2s1mc.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class TrackController {

    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/track")
    ResponseEntity<?> addTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackService.save(track), HttpStatus.CREATED);
    }

    @GetMapping("/tracks")
    ResponseEntity<?> findAllTracks(){
        return new ResponseEntity<>(trackService.fetchAllTracks(), HttpStatus.OK);
    }
      //http://localhost:8082/api/v1/tracks/trackId
    @GetMapping("/tracks/{trackId}")
    ResponseEntity<?> getProductByID(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.fetchATrackByTractId(trackId), HttpStatus.FOUND);
    }
    //http://localhost:8082/api/v1/track/artistName
    @GetMapping("/track/{artistName}")
    ResponseEntity<?> findTrackByArtistName(@PathVariable String artistName){
        return new ResponseEntity<>(trackService.fetchTrackByTrackArtist(artistName), HttpStatus.FOUND);
    }
    @DeleteMapping("/track/{id}")
    ResponseEntity<?> deleteTrack(@PathVariable int id){
        return new ResponseEntity<>(trackService.deleteATrack(id), HttpStatus.OK);
    }

    @PutMapping("/track")
    ResponseEntity<?> updateTrackDetails(@RequestBody Track track){
        return new ResponseEntity<>(trackService.updateTrackDetails(track), HttpStatus.OK);
    }
}
