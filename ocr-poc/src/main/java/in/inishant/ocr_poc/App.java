package in.inishant.ocr_poc;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * Hello world!
 *
 */
public class App 
{
	
	 
    public static void main( String[] args )
    {
    	File imageFile = new File("./src/main/resources/sample_img.jpg");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        //path to tessdata folder
        instance.setDatapath("./src/main/resources");
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        try {
            String result = instance.doOCR(imageFile);
            String[] strArr=getStrArr(result);
            List<String> strList = Arrays.asList(strArr);
            System.out.println(strList.size());
            for (String string : strList) {
            	if(!string.isEmpty() && string.matches("\\w.+"))
            		System.out.println(string);
			}
//            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
	private static String[] getStrArr(String result) {
		return result.split("\n");
	}
}
