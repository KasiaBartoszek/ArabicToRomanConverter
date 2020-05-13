package test.pl.polsl.bartoszek.katarzyna.arabictoromanconverter.service; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.model.ConversionHistory;
import pl.polsl.bartoszek.katarzyna.arabictoromanconverter.service.ConversionHistoryService;

import java.util.List;

/** 
* ConversionHistoryService Tester. 
* 
* @author <Authors name> 
* @since <pre>sty 9, 2020</pre> 
* @version 1.0 
*/ 
public class ConversionHistoryServiceTest { 

    private ConversionHistoryService conversionHistoryService;
@Before
public void before() throws Exception {
    conversionHistoryService = new ConversionHistoryService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: save(ConversionHistory conversionHistory) 
* 
*/ 
@Test
public void testSave() throws Exception {
    ConversionHistory conversionHistory = new ConversionHistory();
    conversionHistory.setValue("34");
    conversionHistory.setConvertedValue("III");
    conversionHistory.setStatus("SUCCESS");
    conversionHistoryService.save(conversionHistory);
} 

/** 
* 
* Method: getHistory() 
* 
*/ 
@Test
public void testGetHistory() throws Exception {
    List<ConversionHistory> history = conversionHistoryService.getHistory();
    int breakpointParking = 2;
} 


} 
