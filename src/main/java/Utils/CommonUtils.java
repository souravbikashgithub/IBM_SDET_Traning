package Utils;

public class CommonUtils {
	
	public static void SleepinSeconds(int Seconds) throws InterruptedException {
		
		int val=Seconds*1000;
		
		Thread.sleep(val);
		
		
	}

}
