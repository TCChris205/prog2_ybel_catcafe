package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

    @Test
    public void testGetCatByName_cat_Exists(){
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Test1",1);
        cafe.addCat(cat);

        assertEquals(cat, cafe.getCatByName("Test1"));
    }

    @Test
    public void testGetCatByName_cat_does_not_Exists(){
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Test1",1);
        cafe.addCat(cat);

        assertNull(cafe.getCatByName("Test2"));
    }
    
    @Test
    public void testGetCatByWeight_Without_cats(){
        CatCafe cafe = new CatCafe();
        assertNull(cafe.getCatByWeight(0, 10));
    }
    

    @Test
    public void testGetCatByWeight_Cat_in_range(){
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Test1",1);
        cafe.addCat(cat);

        assertEquals(cat ,cafe.getCatByWeight(0, 10));
    }

    @Test
    public void testGetCatByWeight_Cat_not_in_range(){
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Test1",11);
        cafe.addCat(cat);

        assertNull(cafe.getCatByWeight(0, 10));
    }

    @Test
    public void testGetCatByWeight_two_Cats_in_range(){
        CatCafe cafe = new CatCafe();
        FelineOverLord cat1 = new FelineOverLord("Test1",1);
        FelineOverLord cat2 = new FelineOverLord("Test2",2);
        cafe.addCat(cat1);
        cafe.addCat(cat2);

        assertEquals(cat1 ,cafe.getCatByWeight(0, 10));
    }
}
