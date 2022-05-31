
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.mockito.Mockito.doReturn;



class TestDemoTest {
    
    private static TestDemo testDemo;
    @BeforeEach
    void setUp() throws Exception {
        
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("TestDemoTest#argumentsForAddPositive")
    
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected,
            boolean expectException) {
            
        
        if (!expectException) {
                // TestDemo testDemo;
                assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
            } else { assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
        
    }
    } 
   
    public static Stream<Arguments> argumentsForAddPositive() {
        
        return Stream.of(arguments(2,4,6, false),
                arguments(1,4,5, false));
        
    }
    
    @Test
        
    void assertThatNumberSquaredIsCorrect() {
        
        TestDemo mockDemo = spy(testDemo);
        
        doReturn(5).when(mockDemo).getRandomInt();
        
        int fivesquared = mockDemo.randomNumberSquared();
        
        assertThat(fivesquared).isEqualTo(25);
        
    }
    
   public static Stream<Arguments>argumentsForRandomNumberSquared(){
       
       return Stream.of(arguments(5,25));
       
   }
    
 }
    
    
        

    
    
        
     
    
    
    
        
    
    
    
    
   


