package volumeState;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.sound.sampled.*;

import interfaceSnakeGame.VolumeState;
import panel.PanelNavigationGameFrame;

public class OnVolume implements VolumeState{
	private static OnVolume instance = new OnVolume();
	
	private OnVolume() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doAction(PanelNavigationGameFrame panelNavigationGameFrame) {
		// TODO Auto-generated method stub
		panelNavigationGameFrame.setVolumeState(this);
		return true;
	}

	public static OnVolume getInstance() {
		return instance;
	}
	
	public Clip clipSound(String fileSoundName) {
	     File file = new File(fileSoundName).getAbsoluteFile();
		 Clip clip = null;
	     try {
				clip = AudioSystem.getClip();
			     AudioInputStream Audio = AudioSystem.getAudioInputStream(file);
			     clip.open(Audio);
			     
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Can't play");
				e.printStackTrace();
			}
		return clip;
	}
	
	public void sound(String fileSoundName) {
		
		try {
			File file = new File(fileSoundName).getAbsoluteFile();
		     Clip clip = AudioSystem.getClip();
		     AudioInputStream Audio = AudioSystem.getAudioInputStream(file);
		     clip.open(Audio);
		     
		     clip.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Can't play");
			e.printStackTrace();
		}
	    
	}
	
	
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
				new File("Breeze - Telecasted.wav"));
		
//		Clip clip = AudioSystem.getClip();
//		clip.open(audioInputStream);
//		clip.start();
		System.out.println("ho ho");
	
		File file = new File("D:\\git\\SnakeGame_ver2\\src\\data\\sound.wav");
	     Clip clip = AudioSystem.getClip();
	     AudioInputStream Audio = AudioSystem.getAudioInputStream(file);
	     clip.open(Audio);
	     
//	     clip.loop(Clip.LOOP_CONTINUOUSLY);
		Scanner input = new Scanner(System.in);
		char volume = 'b';
		while(volume != 'q') {
			
		
			System.out.println("Enter a : on, s: off");
		
		String booleanVolume = input.nextLine();
		volume = booleanVolume.charAt(0);
		
		
		boolean onOff = true;
	
		switch (volume) {
		case 'a':
			clip.start();
			
			break;
		case 's':
			clip.stop();
			
			break;
		case 'q':
			volume = 'q';
			
			break;

		default:
			break;
		}
//	     Thread.sleep(4000);
		}
	}

}
