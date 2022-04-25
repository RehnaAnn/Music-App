package com.example.music.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "track")
public class Track {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="track_id")
            private Long id;
        
        @Column(name="track_name")
        private String name;
        
        @Column(name="genre")
        private String genre;
        
        @Column(name="artist")
        private String artist;
        
        @Column(name="durationInSeconds")
        private int durationInSeconds;

		public Track() {
			super();
		}

		public Track(Long id, String name, String genre, String artist, int durationInSeconds) {
			super();
			this.id = id;
			this.name = name;
			this.genre = genre;
			this.artist = artist;
			this.durationInSeconds = durationInSeconds;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getArtist() {
			return artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		public int getDurationInSeconds() {
			return durationInSeconds;
		}

		public void setDurationInSeconds(int durationInSeconds) {
			this.durationInSeconds = durationInSeconds;
		}

		@Override
		public String toString() {
			
			return "MusicApp [id=" + id + ", name=" + name + ", genre=" + genre + ", artist=" + artist
					+ ", durationInSeconds=" + durationInSeconds + ", getId()=" + getId() + ", getName()=" + getName()
					+ ", getGenre()=" + getGenre() + ", getArtist()=" + getArtist() + ", getDurationInSeconds()="
					+ getDurationInSeconds() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
		
}
