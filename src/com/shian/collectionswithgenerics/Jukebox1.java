package com.shian.collectionswithgenerics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox1 {

	ArrayList<String> songList = new ArrayList<String>();
	public static void main(String[] args) {
		
		Jukebox1 jukebox = new Jukebox1();
		jukebox.go();

	}
	
	public void go() {
		
		//writeFile();
		readFile();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
	}
	
	public void writeFile() {
		
		try {
			FileWriter fileWriter = new FileWriter("song.txt");
			fileWriter.write("Pink Moon/Nick Drake \nSomersault/Zero 7 \nShiva Moon/Prem Joshua \nCircles/BT \nDeep Channel/Afro Celts \nPassenger/Headmix \nListen/Tahiti 80 \n");
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
		songList.add(tokens[0]);
		
	}

}
