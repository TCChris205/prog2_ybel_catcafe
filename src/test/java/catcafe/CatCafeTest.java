package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CatCafeTest {

    @Test
    public void testCatCount() {
        
        CatCafe cafe = new CatCafe();
        FelineOverLord cat1 = new FelineOverLord("Test1",1);
        FelineOverLord cat2 = new FelineOverLord("Test2",2);

        assertEquals(0,cafe.getCatCount());

        cafe.addCat(cat1);
        cafe.addCat(cat2);
        assertEquals(2,cafe.getCatCount());
    }
    
    @Test
    public void testAddCat_Null_Case(){
        CatCafe cafe = new CatCafe();
        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }
    
}
