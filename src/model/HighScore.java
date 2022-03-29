package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class HighScore {
	private int highScore = 0;
	private File file = new File("D:\\git\\SnakeGame_ver2\\src\\data\\HighScore.txt");

	public HighScore(int highScore) {
		super();
		this.highScore = highScore;
	}
	
	public HighScore() {
		
	}
	
	public void updateHightScore(int hightScore) throws IOException {
		
		FileWriter fileWrire = new FileWriter(this.file);
		BufferedWriter bwfile = new BufferedWriter(fileWrire);
		bwfile.write(hightScore);
		bwfile.close();
		
	}
	
	public int readHightScore() throws IOException, ClassNotFoundException {
		int highScore = 0;
		int data;
		
		FileReader fileRead = new FileReader(this.file);
		BufferedReader brfile = new BufferedReader(fileRead);
		
		while((data = brfile.read()) != -1) {
			if (data > highScore ) {
				highScore = data;
			}
		}
		
		brfile.close();
		
		return highScore;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	public static void main(String[] args) throws IOException {
//		FileWriter fileWrire = new FileWriter("D:\\git\\SnakeGame_ver2\\src\\data\\HighScore.txt");
//		BufferedWriter bwfile = new BufferedWriter(fileWrire);
//		bwfile.write(0);
//		bwfile.close();
//		
//		System.out.println("success");
//			
			
//		int highScore;
//		
//		FileReader fileRead = new FileReader("D:\\git\\SnakeGame_ver2\\src\\data\\HighScore.txt");
//		BufferedReader brfile = new BufferedReader(fileRead);
//		
//		while((highScore = brfile.read()) != -1) {
//			System.out.println(highScore);
//		}
//		
//		brfile.close();
		
//		try {
//			FileWriter writeFile = new FileWriter("D:\\git\\SnakeGame_ver2\\src\\data\\HighScore.txt");
//			int hightScore = 10;
//			writeFile.write(hightScore);
//			writeFile.close();
//			System.out.println("su");
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		int hightScore = 0;
//		try {
//			FileReader readFile = new FileReader("D:\\git\\SnakeGame_ver2\\src\\data\\HighScore.txt");
//			int data = readFile.read();
//			
//			while (data != -1) {
//				data = readFile.read();
//				System.out.println((char)data);
//				hightScore = data;
//				
//			}
//			readFile.close();
//			System.out.println(hightScore);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}
	
}
