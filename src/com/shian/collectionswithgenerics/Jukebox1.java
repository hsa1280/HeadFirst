package com.shian.collectionswithgenerics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox1 {

	ArrayList<Song> songList = new ArrayList<Song>();
	public static void main(String[] args) {
		
		Jukebox1 jukebox = new Jukebox1();
		jukebox.go();

	}
	
	public void go() {
		
		writeFile();
		readFile();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
	}
	
	public void writeFile() {
		
		try {
			FileWriter fileWriter = new FileWriter("song.txt");
			fileWriter.write("Pink Moon/Nick Drake/5/80 \n"
					+ "Somersault/Zero 7/4/84 \n"
					+ "Shiva Moon/Prem Joshua/6/120 \n"
					+ "Circles/BT/5/110 \n"
					+ "Deep Channel/Afro Celts/4/120 \n"
					+ "Passenger/Headmix/4/100 \n"
					+ "Listen/Tahiti 80/5/90 \n");
			fileWriter.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public void readFile() {
		
		try {
			FileReader fileReader = new FileReader("song.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while( (line = bufferedReader.readLine()) != null ) {
				addSong( line );
			}
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	private void addSong(String line) {
		
		String tokens[] = line.split("/");
		Song song = new Song( tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(song);
		
	}

}
