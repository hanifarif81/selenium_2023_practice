package testAuthentication;

import application.page_library.Homepage;
import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPurchasing extends Base {

    @Test
    public void testSearchItem() throws InterruptedException {


        Homepage homepage = new Homepage();
        homepage.doSearch("Halloween Costumes for Cats");

        Assert.assertEquals();


    }
}
