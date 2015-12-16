package co.edu.udea.runtwebapp.domain.alpr;

import com.openalpr.jni.AlprPlateResult;
import com.openalpr.jni.AlprResults;

import java.util.List;

public class ControllerRecognizer {

	public ControllerRecognizer() {
    }
    
    public String recognizePlate(byte[] imageData) throws Exception {
    	
        AlprRecognizer alprRecognizer= new AlprRecognizer();
        AlprResults alprResults=alprRecognizer.recognizePlate(imageData);
        List<AlprPlateResult> list= alprResults.getPlates();
        
        for (AlprPlateResult plate  : list) {
            if (plate.getBestPlate().getCharacters().equals("MIV792")) {
                return plate.getBestPlate().getCharacters();
            }
        }
        return "";
    }
}
