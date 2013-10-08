//package luolastotest;
//
//import luolasto.LuolastoGeneraattori;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Jerry
// */
//public class LuolastoGeneraattoriTest {
//    
//    LuolastoGeneraattori lg;
//    
//    public LuolastoGeneraattoriTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//        this.lg = new LuolastoGeneraattori();
//    }
//    
//    @After
//    public void tearDown() {
//    }
//    
//    @Test
//    public void luoSopivanTaulukonVisualCheck() {
//        lg.generoiLuolasto(20);
//        lg.tulostaLuolasto();
//    }
//    
//    @Test
//    public void luolastollaOnMaaliruutu() {
//        lg.generoiLuolasto(150);
//        assertEquals(lg.getLuolasto()[lg.getLuolasto().length-1][lg.getLuolasto()[0].length-1], 1);
//    }
//    
//    @Test
//    public void luolastollaOnLahtoruutu() {
//        lg.generoiLuolasto(150);
//        assertEquals(lg.getLuolasto()[0][0], 1);
//    }
//}
