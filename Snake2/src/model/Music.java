package model;

import java.io.File;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Music {
	public Clip clip_jojo;
	public Clip clip_yes;
	public Clip clip_oh_no;
	
	public Music() {
		File sound = new File(new File("C:\\").getAbsolutePath() + "\\jojo.wav");
		File sound1 = new File(new File("C:\\").getAbsolutePath() + "\\yes_yes_yes.wav");
		File sound2 = new File(new File("C:\\").getAbsolutePath() + "\\Oh_My_God.wav");
		try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
            clip_jojo = AudioSystem.getClip();
            clip_jojo.open(ais);
            AudioInputStream ais1 = AudioSystem.getAudioInputStream(sound1);
            clip_yes = AudioSystem.getClip();
            clip_yes.open(ais1);
            AudioInputStream ais2 = AudioSystem.getAudioInputStream(sound2);
            clip_oh_no = AudioSystem.getClip();
            clip_oh_no.open(ais2);
		} catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	}
	public void initialise() {
		File sound = new File(new File("C:\\").getAbsolutePath() + "\\yes_yes_yes.wav");
		try {
		AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
        clip_yes = AudioSystem.getClip();
        clip_yes.open(ais);
		}
		catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	public void Snake_music() {
		clip_jojo.start();
		clip_jojo.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void apple_music() {
		clip_yes.start();
		initialise();
	}

	public void game_over_music() {
		clip_jojo.stop();
		clip_jojo.close();
		clip_yes.close();
		clip_oh_no.start();
	}

}
