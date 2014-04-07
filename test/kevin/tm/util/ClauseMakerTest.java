/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevin.tm.util;

import kevin.tm.dao.model.Scheduleinfo;
import kevin.tm.dao.model.Ticketinfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Diluka
 */
public class ClauseMakerTest {

    public ClauseMakerTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void goScheduleinfo() {
        String clause = "   abc 123 测试   test  ";
        String result = ClauseMaker.makeClause(new Scheduleinfo(), clause);
        System.out.println(result);
    }

    @Test
    public void goTicketinfo() {
        System.out.println(ClauseMaker.makeClause(new Ticketinfo(), "1 2 3 4 5 "));
        System.out.println(ClauseMaker.makeClause(Ticketinfo.class, "sss 2 asd 4 5 "));
        System.out.println(ClauseMaker.makeClause(Ticketinfo.class, " "));
    }
}
