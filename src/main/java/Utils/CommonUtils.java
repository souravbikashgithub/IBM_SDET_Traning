package Utils;

public class CommonUtils {
	
	public void SleepinSeconds(int Seconds) throws InterruptedException {
		
		int val=Seconds*1000;
		
		Thread.sleep(val);
		
		
	}

}
