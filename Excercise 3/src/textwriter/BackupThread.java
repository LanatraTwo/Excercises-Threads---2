package textwriter;

import java.io.PrintWriter;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import java.util.List;

public class BackupThread extends Thread {

	List<String> lines;

	public BackupThread(List l) {
		lines = l;
	}

	public void run() {
		String userDir = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
		System.out.println("userdir: " + userDir);
		while(true) {
			try {
				FileWriter writer = new FileWriter(userDir + "\\backup.txt", false);
				PrintWriter out = new PrintWriter(writer);
				for (String line : lines) {
					out.println(line);
				}
				out.close(); 
				Thread.sleep(15000);
			} catch(Exception e){}
		}
	}

}