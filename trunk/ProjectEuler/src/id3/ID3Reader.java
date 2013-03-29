package id3;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

public class ID3Reader {

	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		int res = jfc.showOpenDialog(null);
		switch (res) {
			case JFileChooser.APPROVE_OPTION: {
				try {
					File sourceFile = jfc.getSelectedFile();
					MP3File mp3file = new MP3File(sourceFile);
					System.out.println(mp3file.getID3v2Tag().getSongTitle());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (TagException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
