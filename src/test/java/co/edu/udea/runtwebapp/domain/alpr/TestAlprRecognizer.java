package co.edu.udea.runtwebapp.domain.alpr;

import com.openalpr.jni.AlprPlateResult;
import com.openalpr.jni.AlprResults;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAlprRecognizer {

	public TestAlprRecognizer() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recognizePlate method, of class AlprRecognizer.
     */
    @Test
    public void testRecognizePlate() throws Exception {
    	String licensePlate = "C:/Plate.jpg";
    	Path path = Paths.get(licensePlate);
		byte[] imageData = Files.readAllBytes(path);
        AlprRecognizer alprRecognizer= new AlprRecognizer();
        AlprResults alprResults=alprRecognizer.recognizePlate(imageData);
        List<AlprPlateResult> list= alprResults.getPlates();
        
        for (AlprPlateResult plate  : list) {
            if (plate.getBestPlate().getCharacters().equals("FAK579")) {
                assertEquals(plate.getBestPlate().getCharacters(), "FAK579");
                return;
            }
        }
    }
}
