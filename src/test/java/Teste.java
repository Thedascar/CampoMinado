import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Teste {

    @Test
    void testarSeIgualADOis(){
        int a = 1+1;

        assertEquals(2,a);
    }

    @Test
    void testarSeIgualAtres(){
        int x = 2 + 10 - 9;

        assertEquals(3,x);
    }
}
