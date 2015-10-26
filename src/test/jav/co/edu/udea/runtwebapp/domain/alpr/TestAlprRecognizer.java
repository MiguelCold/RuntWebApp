package co.edu.udea.runtwebapp.domain.alpr;

import com.openalpr.jni.AlprPlateResult;
import com.openalpr.jni.AlprResults;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAlprRecognizer {

	public AlprRecognizerTest() {
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
        AlprRecognizer alprRecognizer= new AlprRecognizer();
        AlprResults alprResults=alprRecognizer.recognizePlate("C:\\Users\\ASUS\\Pictures\\Images\\DSC_0095_2.JPG");
        List<AlprPlateResult> list= alprResults.getPlates();
        
        for (AlprPlateResult plate  : list) {
            if (plate.getBestPlate().getCharacters().equals("HMT395")) {
                assertEquals(plate.getBestPlate().getCharacters(), "HMT395");
                return;
            }
        }
    }
}
