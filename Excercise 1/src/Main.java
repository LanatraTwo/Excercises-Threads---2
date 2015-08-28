

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
		GetImage t1 = new GetImage("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
		GetImage t2 = new GetImage("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
		GetImage t3 = new GetImage("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");

		// Parallel Execution
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		long end = System.currentTimeMillis();
		System.out.println("Time Parallel (ms): "+(end-start));

		System.out.println(t3.getImgSizes());

		// Sequential Execution
		start = System.currentTimeMillis();
		t1.run();
		t2.run();
		t3.run();
		end = System.currentTimeMillis();
		System.out.println("Time Sequential (ms): "+(end-start));

		// Sequential is faster in this example, probably because it takes some time to do the initial starting of a thread

	}

	
}