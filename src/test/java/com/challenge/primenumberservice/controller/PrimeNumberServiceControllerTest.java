package com.challenge.primenumberservice.controller;

import com.challenge.primenumberservice.exception.PrimeNumberException;
import com.challenge.primenumberservice.representation.PrimeNumberResponse;
import com.challenge.primenumberservice.service.PrimeNumberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import java.text.ParseException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 17-APR-2021
 ************************************/
@ExtendWith(MockitoExtension.class)
class PrimeNumberServiceControllerTest {


    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private PrimeNumberService primeNumberService;
    @Mock
    PrimeNumberResponse primeNumberResponse;
    @InjectMocks
    private PrimeNumberController primeNumberController;


    @Test
    public void getPrimeNumberListForValidLimit() throws PrimeNumberException {
        when(primeNumberService.getListOfPrimeNumbers(anyInt())).thenReturn(primeNumberResponse);
        Response response = primeNumberController.getGuestInfo(30);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void getPrimeNumberListForInvalidNegativeLimit() throws PrimeNumberException, ParseException {
        doThrow(PrimeNumberException.class).when(primeNumberService).getListOfPrimeNumbers(-1);
        Response response = primeNumberController.getGuestInfo(-1);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    public void getPrimeNumberListForZeroLimit() throws PrimeNumberException {
        doThrow(PrimeNumberException.class).when(primeNumberService).getListOfPrimeNumbers(0);
        Response response = primeNumberController.getGuestInfo(0);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

}
