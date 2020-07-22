import com.company.Calc;
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
     * ----------------------------------------
     * Позитивное
     * Негативное
     * Тестирование на считывание знака операции
     * ----------------------------------------
     */
    @DataProvider
    Object[][] calculationArgumentsProvider(){
        return new Object[][]{
                {"1","2",'+',"3"},
                {"1","2",'-',"-1"},
                {"1","2",'/',"0.5"},
                {"1111111111111","2",'*',"2"}
        };
    }
    @Test (dataProvider = "calculationArgumentsProvider")
    void setOperationsPositiveTest(String arg1,String arg2, char operation,String result){
        Assert.assertTrue(Calc.validateOperation(operation));
    }

    @DataProvider
    Object[][] calculationArgumentsProviderNeg(){
        return new Object[][]{
                {"1","2",'%',"3"},
                {"1","2",'$',"-1"},
                {"1","2",'&',"0.5"},
                {"1111111111111","2",'#',"2"}
        };
    }
    @Test (dataProvider = "calculationArgumentsProviderNeg")
    void setOperationsNegativeTest(String arg1,String arg2, char operation,String result){
        Assert.assertFalse(Calc.validateOperation(operation));
    }

    /**
     * ----------------------------------------
     * Позитивное
     * Негативное
     * Тестирование на считывание символов
     * с клавиатуры
     * ----------------------------------------
     */
    @DataProvider
    Object[][] validateArgsPos(){
        return new Object[][]{
                {"10","2",'+',"12"},
                {"10","2",'-',"8"},
                {"1","2",'/',"0.5"},
                {"1.0","2.0",'*',"2"},
        };
    }
    @Test (dataProvider = "validateArgsPos")
    void validateArgs(String arg1,String arg2, char operation, String result){
        Assert.assertTrue(Calc.validate(arg1));
        Assert.assertTrue(Calc.validate(arg2));
    }

    @DataProvider
    Object[][] validateArgsNeg(){
        return new Object[][]{
                {"1o","two",'+',"12"},
                {"десять","попугаев",'-',"8"},
                {"sdf","vasd",'/',"0.5"},
                {"1,0","2,0",'*',"2"},
        };
    }
    @Test (dataProvider = "validateArgsNeg")
    void validateArgsNeg(String arg1,String arg2, char operation, String result){
        Assert.assertFalse(Calc.validate(arg1));
        Assert.assertFalse(Calc.validate(arg2));
    }

    /**
     * ----------------------------------------
     * Тестирование граничных значений
     * вводимых с клавиатуры
     * ----------------------------------------
     */
    @DataProvider
    Object [][] borderIn(){
        return new Object[][]{
                {"-2147483649","2147483647",'+',"-2"},
                {"2147483648","-2147483648",'+',"0"},
        };
    }
    @Test (dataProvider = "borderIn")
    void testIntegerArgument(String arg1,String arg2, char operation, String result){
        Assert.assertFalse(Calc.validate(arg1));
        Assert.assertTrue(Calc.validate(arg2));
    }

    /**
     * ----------------------------------------
     * Позитивное
     * Негативное
     * Тестирование операции "Сложение"
     * ----------------------------------------
     */
    @DataProvider
    Object [][] positiveSum(){
        return new Object[][]{
                {"1","1",'+',"2"},
                {"0","0",'+',"0"},
                {"-1","0.5",'+',"-0.5"}
        };
    }
    @Test (dataProvider = "positiveSum")
    void testPSum(String arg1,String arg2, char operation, String result){
        Assert.assertEquals(Calc.start(arg1,arg2,operation),result);
    }

    @DataProvider
    Object [][] negativeSum(){
        return new Object[][]{
                {"1","1",'+',"5"},
                {"0","0",'+',"100"},
                {"-1","0.5",'+',"-500"}
        };
    }
    @Test (dataProvider = "negativeSum")
    void testNSum(String arg1,String arg2, char operation, String result){
        Assert.assertNotEquals(Calc.start(arg1,arg2,operation),result);
    }

    /**
     * ----------------------------------------
     * Позитивное
     * Негативное
     * Тестирование операции "Вычитание"
     * ----------------------------------------
     */
    @DataProvider
    Object [][] positiveSub(){
        return new Object[][]{
                {"1","1",'-',"0"},
                {"0","0",'-',"0"},
                {"-1","0.5",'-',"-1.5"},
                {"5","-0.5",'-',"5.5"},
        };
    }
    @Test (dataProvider = "positiveSub")
    void testPSub(String arg1,String arg2, char operation, String result){
        Assert.assertEquals(Calc.start(arg1,arg2,operation),result);
    }

    @DataProvider
    Object [][] negativeSub(){
        return new Object[][]{
                {"1","1",'-',"5"},
                {"0","0",'-',"100"},
                {"-1","0.5",'-',"-500"}
        };
    }
    @Test (dataProvider = "negativeSub")
    void testNSub(String arg1,String arg2, char operation, String result){
        Assert.assertNotEquals(Calc.start(arg1,arg2,operation),result);
    }

    /**
     * ----------------------------------------
     * Позитивное
     * Негативное
     * Тестирование операции "Умножение"
     * ----------------------------------------
     */
    @DataProvider
    Object [][] positiveMul(){
        return new Object[][]{
                {"1","1",'*',"1"},
                {"0","0",'*',"0"},
                {"-1","0.5",'*',"-0.5"},
                {"5","0",'*',"0"},
                {"5","5",'*',"25"},
        };
    }
    @Test (dataProvider = "positiveMul")
    void testPMul(String arg1,String arg2, char operation, String result){
        Assert.assertEquals(Calc.start(arg1,arg2,operation),result);
    }

    @DataProvider
    Object [][] negativeMul(){
        return new Object[][]{
                {"1","1",'*',"10"},
                {"0","0",'*',"100"},
                {"-1","0.5",'*',"0.5"},
                {"5","0",'*',"5"},
                {"5","5",'*',"30"},
        };
    }
    @Test (dataProvider = "negativeMul")
    void testNMul(String arg1,String arg2, char operation, String result){
        Assert.assertNotEquals(Calc.start(arg1,arg2,operation),result);
    }

    /**
     * ----------------------------------------
     * Позитивное
     * Негативное
     * Тестирование операции "Деление"
     * Тестирование деления на "ноль"
     * ----------------------------------------
     */
    @DataProvider
    Object [][] positiveDiv(){
        return new Object[][]{
                {"1","1",'/',"1.0"},
                {"0","5",'/',"0.0"},
                {"-1","0.5",'/',"-2.0"},
                {"5","13",'/',"0.38461538461538464"},
        };
    }
    @Test (dataProvider = "positiveDiv")
    void testPDiv(String arg1,String arg2, char operation, String result){
        Assert.assertEquals(Calc.start(arg1,arg2,operation),result);
    }

    @DataProvider
    Object [][] negativeDiv(){
        return new Object[][]{
                {"1","1",'/',"10"},
                {"0","5",'/',"5"},
                {"-1","0.5",'/',"2"},
                {"5","13",'/',"0.384"},
        };
    }
    @Test (dataProvider = "negativeDiv")
    void testNDiv(String arg1,String arg2, char operation, String result){
        Assert.assertNotEquals(Calc.start(arg1,arg2,operation),result);
    }

    @DataProvider
    Object [][] nullDiv(){
        return new Object[][]{
                {"10","0",'/',"Error"},
        };
    }
    @Test (dataProvider = "nullDiv", expectedExceptions = NumberFormatException.class)
    void testNullDiv(String arg1,String arg2, char operation, String result){
        Assert.assertEquals(Calc.start(arg1,arg2,operation),result);
    }
}