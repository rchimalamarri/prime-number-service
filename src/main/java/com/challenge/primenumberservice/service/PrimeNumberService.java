package com.challenge.primenumberservice.service;

import com.challenge.primenumberservice.exception.PrimeNumberException;
import com.challenge.primenumberservice.representation.PrimeNumberResponse;
import org.springframework.stereotype.Service;

/***********************************
 * This  Service  ,which will handle the service logic
 * to calculate and return a collection of all prime numbers
 * up to a specified upper limit in number
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 17-APR-2021
 ************************************/
@Service
public interface PrimeNumberService {

    PrimeNumberResponse getListOfPrimeNumbers(int upperLimit) throws PrimeNumberException;

}
