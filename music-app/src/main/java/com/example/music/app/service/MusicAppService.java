package com.example.music.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.app.model.Track;
import com.example.music.app.repository.MusicAppRespository;
import java.util.List;



@Service
public class MusicAppService {
	@Autowired
	MusicAppRespository musicRepository;
	
	// CREATE 
	public Track createTrack(Track track) {
	    return musicRepository.save(track);
	}

	// READ
	public List<Track> getTracks() {
	    return musicRepository.findAll();
	}
	// READ
		public Track getTrack(Long trackId) {
		    return  musicRepository.findById(trackId).get();
		}

	// DELETE
	public void deleteTrack(Long trackId) {
		musicRepository.deleteById(trackId);
	}
	// UPDATE
	public Track updateTrack(Long trackId, Track trackDetails) {
		Track track = musicRepository.findById(trackId).get();
		track.setName(trackDetails.getName());
		track.setGenre(trackDetails.getGenre());
		track.setArtist(trackDetails.getArtist());
		track.setDurationInSeconds(trackDetails.getDurationInSeconds());
	        
	        return musicRepository.save(track);                                
	}
	

}
