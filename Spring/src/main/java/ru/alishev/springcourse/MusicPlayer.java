package main.java.ru.alishev.springcourse;

import java.util.ArrayList;

/**
 * @author Neil Alishev
 */
public class MusicPlayer {
	private int volume;
	private String name;
	private Music music;
	private ArrayList<Music> musicList;
	public void setMusicList(ArrayList<Music> musicList) {
		this.musicList = musicList;
	}


	public Music getMusic() {
		return music;
	}
	public int getVolume() {
		return volume;
	}

	public String getName() {
		return name;
	}


	public MusicPlayer(Music music) {
		this.music = music;
	}
	public MusicPlayer(){

	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	public void playMusic() {

		System.out.println("Playing: " + music.getSong());
	}
	public void playMusicList() {
		for (Music r :musicList) {
			System.out.println("Playing: " + r.getSong());
		}
	}
}
