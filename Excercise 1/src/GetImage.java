import java.util.concurrent.atomic.AtomicInteger;
import java.net.URL;
import java.io.*;

public class GetImage extends Thread {

	private String imgUrl;


	public static AtomicInteger imgSizes = new AtomicInteger();

	public int getImgSizes() {
	    return imgSizes.get();
	}

	public GetImage(String url) {
		imgUrl = url;
	}


	public static byte[] getBytesFromUrl(String url) {
		ByteArrayOutputStream bis = new ByteArrayOutputStream();
		try {
			InputStream is = new URL(url).openStream();
			byte[] bytebuff = new byte[4096];
			int read;
			while ((read = is.read(bytebuff)) > 0) {
				bis.write(bytebuff, 0, read);
			}
		} catch (IOException ex) {System.out.println(ex);}
		return bis.toByteArray();
	}

	public void run() {
		int temp = sumOfByteArray(getBytesFromUrl(imgUrl));
		imgSizes.set(imgSizes.get() + temp);
	}

	public static int sumOfByteArray(byte[] a) {
		int c = 0;
		for (int i = 0; i < a.length ; i++) {
			c += a[i];
		}
		return c;
	}

}