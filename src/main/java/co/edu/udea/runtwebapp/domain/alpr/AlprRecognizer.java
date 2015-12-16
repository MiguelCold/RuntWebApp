package co.edu.udea.runtwebapp.domain.alpr;

import com.openalpr.jni.Alpr;
import com.openalpr.jni.AlprResults;
import java.io.IOException;


public class AlprRecognizer {

	String country, configfile, runtimeDataDir;
	Alpr alpr;

	public AlprRecognizer() {
		country = "co";
		configfile = "C:/openalpr.conf";
		runtimeDataDir = "C:/runtime_data";
		alpr = new Alpr(country, configfile, runtimeDataDir);
		alpr.setTopN(10);
		alpr.setDefaultRegion("base");
	}

	public AlprResults recognizePlate(byte[] imageData) throws IOException {
		// Read an image into a byte array and send it to OpenALPR
		AlprResults results = alpr.recognize(imageData);
		alpr.unload();
		return results;
	}
}
