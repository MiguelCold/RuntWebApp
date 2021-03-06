package co.edu.udea.runtwebapp.domain.alpr;

import com.openalpr.jni.AlprPlateResult;
import com.openalpr.jni.AlprResults;

import java.util.List;

public class ControllerRecognizer {

	public ControllerRecognizer() {
    }
    
    public List<AlprPlateResult> recognizePlate(byte[] imageData) throws Exception {
    	
        AlprRecognizer alprRecognizer= new AlprRecognizer();
        AlprResults alprResults=alprRecognizer.recognizePlate(imageData);
        List<AlprPlateResult> list= alprResults.getPlates();
        return list;
    }
}
