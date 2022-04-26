package com.example.music.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.music.app.model.Track;
import com.example.music.app.repository.MusicAppRespository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MusicAppApplicationTests {
	
	@Autowired
	MusicAppRespository musicRepository;
	
	@Test
	@Order(1)
	public void testCreateTrack() {
		Track track = new Track();
		track.setName("Rolling in the Deep");
		track.setGenre("Pop");
		track.setArtist("Adele");
		track.setDurationInSeconds(220);
		track = musicRepository.save(track);
		assertNotNull(musicRepository.findById(track.getId()).get());
		
	}
	
	@Test
	@Order(2)
	public void testReadTracks() {
		List<Track> trackList = musicRepository.findAll();
		assertNotEquals(0 ,trackList.size());		
	}
	
	@Test
	@Order(3)
	public void testSingleTrack() {
		Track track = musicRepository.findById(1L).get();
		assertEquals("Adele", track.getArtist());
	}
	
	@Test
	@Order(4)
	public void testTrackUpdate() {
		Track track = musicRepository.findById(1L).get();
		track.setArtist("Dua Lipa");
		musicRepository.save(track);
		assertNotEquals("Adele", musicRepository.findById(1L).get().getArtist());
	}	
	
	@Test
	@Order(5)
	public void testDeleteTrack() {
		musicRepository.deleteById(1L);
		assertFalse(musicRepository.existsById(1L));
	}
		
}
