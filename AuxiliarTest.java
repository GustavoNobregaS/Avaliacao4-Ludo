

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Direitos Autorais, PUCRS/Escola Politécnica
// Início: 2021-06-22
// https://github.com/GustavoPucRS/Avaliacao4-Ludo

/**
 * A classe Auxiliar possue um subprograma que 
 * permite calcular a soma da linha com o dado.
 * 
 * @author Gustavo da Nóbrega Silva (21100654-9)
 * @version 1.0 (22/06/2021)
 */
public class AuxiliarTest
{
    /**
     * Construtor default para a classe de teste AuxiliarTest
     */
    public AuxiliarTest()
    {
    }

    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void rodada10igual11()
    {
        assertEquals(11, Auxiliar.round(10));
    }

    @Test
    public void rodada40igual41()
    {
        assertEquals(41, Auxiliar.round(40));
    }
    
    @Test
    public void rodada6igual7()
    {
        assertEquals(7, Auxiliar.round(6));
    }
    
    @Test
    public void rodada21igua22()
    {
        assertEquals(22, Auxiliar.round(21));
    }
}



