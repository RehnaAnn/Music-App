package com.example.music.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.app.model.Track;
import com.example.music.app.repository.MusicAppRespository;
import com.example.music.app.service.MusicAppService;


@RestController
@RequestMapping("/api")
public class MusicAppController {

	@Autowired
	MusicAppService musicService;

	@RequestMapping(value="/tracks", method=RequestMethod.POST)
	public Track createTrack(@RequestBody Track track) {
		return musicService.createTrack(track);
	}
	@RequestMapping(value="/tracks", method=RequestMethod.GET)
	public List<Track> readTracks() {
		return musicService.getTracks();
	}
	@RequestMapping(value="/tracks/{trackId}", method=RequestMethod.GET)
	public Track readTrack(@PathVariable(value = "trackId") Long id) {
		return musicService.getTrack(id);
	}

	@RequestMapping(value="/tracks/{trackId}", method=RequestMethod.PUT)
	public Track readTrack(@PathVariable(value = "trackId") Long id, @RequestBody Track trackDetails) {
		return musicService.updateTrack(id, trackDetails);
	}

	@RequestMapping(value="/tracks/{id}/{artist}", method=RequestMethod.PATCH)
	public Track updateTrackArtist(@PathVariable Long id, @PathVariable String artist) {
			Track track = musicService.getTrack(id);
			track.setArtist(artist);
			return musicService.updateTrack(id, track);
	}
	
	@RequestMapping(value="/tracks/{trackId}", method=RequestMethod.DELETE)
	public void deleteTracks(@PathVariable(value = "trackId") Long id) {
		musicService.deleteTrack(id);
	}

}
