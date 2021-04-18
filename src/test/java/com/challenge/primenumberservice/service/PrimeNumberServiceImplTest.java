package com.challenge.primenumberservice.service;

import com.challenge.primenumberservice.exception.PrimeNumberException;
import com.challenge.primenumberservice.representation.PrimeNumberResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 17-APR-2021
 ************************************/
@ExtendWith(MockitoExtension.class)
public class PrimeNumberServiceImplTest {

    @Mock
    PrimeNumberService primeNumberService;
    @Mock
    HttpServletResponse response;

    @Mock
    PrimeNumberResponse primeNumberResponse;

    @InjectMocks
    PrimeNumberServiceImpl primeNumberServiceImpl;

    @Test
    public void testGetPrimeNumbersListForValidData() throws PrimeNumberException {

        PrimeNumberResponse response = primeNumberServiceImpl.getListOfPrimeNumbers(4);
        assertEquals("2", response.getPrimeNumbersList().get(0).toString());
        assertEquals("3", response.getPrimeNumbersList().get(1).toString());


    }


    @Test
    public void testGetPrimeNumbersListForValidUpperLimit() throws PrimeNumberException {

        PrimeNumberResponse response = primeNumberServiceImpl.getListOfPrimeNumbers(40);
        assertEquals("2", response.getPrimeNumbersList().get(0).toString());
        assertEquals("3", response.getPrimeNumbersList().get(1).toString());


    }

    @Test
    public void testGetPrimeNumbersListForNegativeNumber() {
        Assertions.assertThrows(PrimeNumberException.class, () -> {
            primeNumberServiceImpl.getListOfPrimeNumbers(-1);
        });
    }

    @Test
    public void testGetPrimeNumbersListForZero() {
        Assertions.assertThrows(PrimeNumberException.class, () -> {
            primeNumberServiceImpl.getListOfPrimeNumbers(0);
        });
    }


    @Test
    public void testGetPrimeNumbersListForOne() {
        Assertions.assertThrows(PrimeNumberException.class, () -> {
            primeNumberServiceImpl.getListOfPrimeNumbers(1);
        });
    }

}
