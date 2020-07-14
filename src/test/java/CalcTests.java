import com.company.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



/**
 * Класс CalcTests
 * Выполняет тестирование операций из класса Main: Сложение, Вычитание, Умножение, Деление
 * @author Badikov Dmitriy
 */
public class CalcTests {
    private static final Logger log = LogManager.getLogger();
    @BeforeClass
    public void beforeClass() {
        log.info("Тестирование");
    }

    @AfterClass
    public void afterClass() {
        log.info("Подчищаем после теста");
    }

    /**
     * Позитивное и негативное тестирование операции "Сумма"
     */
    @DataProvider
    public Object [][] positiveSum() {
        return new Object[][] {
                {0,-1,1},
                {-2,1,-3},
                {-5,-3,-2},
                {10,4,6}
        };
    }
    @Test(dataProvider = "positiveSum")
    public void testPSum(int one, int two, int three) {
        Assert.assertEquals(one, Main.calc(two, three, '+'), "Суммы верны" );
    }

    @DataProvider
    public Object [][] negativeSum() {
        return new Object[][] {
                {0,-1,-1},
                {-2,1,3},
                {-5,3,-2},
                {10,7,6}
        };
    }
    @Test(dataProvider = "negativeSum")
    public void testNSum(int one, int two, int three) {
        Assert.assertNotEquals(one, Main.calc(two, three, '+'), "Суммы не верны" );
    }

    /**
     * Позитивное и негативное тестирование операции "Вычитание"
     *
     */
    @DataProvider
    public Object [][] positiveSub() {
        return new Object[][] {
                {0,1,1},
                {-2,-3,-1},
                {-5,3,8},
                {2,5,3}
        };
    }
    @Test(dataProvider = "positiveSub")
    public void testPSub(int one, int two, int three) {
        Assert.assertEquals(one, Main.calc(two, three, '-'), "Вычитание прошло успешно" );
    }
    @DataProvider
    public Object [][] negativeSub() {
        return new Object[][] {
                {0,1,-1},
                {-2,3,-1},
                {5,3,8},
                {2,-5,3}
        };
    }
    @Test(dataProvider = "negativeSub")
    public void testNSub(int one, int two, int three) {
        Assert.assertNotEquals(one, Main.calc(two, three, '-'), "Вычитание произошло с ошибкой");
    }

    /**
     * Позитивное и негативное тестирование операции "Умножение"
     */

    @DataProvider
    public Object [][] positiveMul() {
        return new Object[][] {
                {0,1,0},
                {-6,-3,2},
                {9,-3,-3},
                {4,2,2}
        };
    }
    @Test(dataProvider = "positiveMul")
    public void testPMul(int one, int two, int three) {
        Assert.assertEquals(one, Main.calc(two, three, '*'), "Умножение прошло успешно" );
    }

    @DataProvider
    public Object [][] negativeMul() {
        return new Object[][] {
                {0,1,-1},
                {-2,-3,1},
                {-5,3,4},
                {2,5,3}
        };
    }
    @Test(dataProvider = "negativeMul")
    public void testNMul(int one, int two, int three) {
        Assert.assertNotEquals(one, Main.calc(two, three, '*'), "Умножение прошло с ошибкой" );
    }

    /**
     * Позитивное и негативное тестирование операции "Деление"
     * Деление на ноль
     * Деление с остатком
     */

    @DataProvider
    public Object [][] positiveDiv() {
        return new Object[][] {
                {3,6,2},
                {-2,-4,2},
                {5,-20,-4},
                {-5,15,-3},
                {0,0,5}
        };
    }
    @Test(dataProvider = "positiveDiv")
    public void testPDiv(int one, int two, int three) {
        Assert.assertEquals(one, Main.calc(two, three, '/'), "Деление прошло успешно" );
    }

    @DataProvider
    public Object [][] negativeDiv() {
        return new Object[][] {
                {0,1,1},
                {-5,3,8},
                {2,5,3}
        };
    }
    @Test(dataProvider = "negativeDiv")
    public void testNDiv(int one, int two, int three) {
        Assert.assertNotEquals(one, Main.calc(two, three, '/'), "Деление прошло с ошибкой" );
    }

    @DataProvider
    public Object [][] SCDiv() {
        return new Object[][] {
                {0,10,0},
        };
    }
    @Test(dataProvider = "SCDiv", expectedExceptions = ArithmeticException.class)
    public void testSpecialCasesDiv(int one, int two, int three) {
        Assert.assertEquals(one, Main.calc(two, three, '/'), "Деление на ноль прошло успешно");
    }

    @DataProvider
    public Object [][] withoutRemainderDiv() {
        return new Object[][] {
                {3,15,4},
                {2,18,7}
        };
    }
    @Test(dataProvider = "withoutRemainderDiv")
    public void testWithoutRemainderDiv(int one, int two, int three) {
        Assert.assertEquals(one, Main.calc(two, three, '/'), "Деление c остатком прошло успешно");
    }
}
