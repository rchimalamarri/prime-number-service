package com.challenge.primenumberservice.service;

import com.challenge.primenumberservice.exception.PrimeNumberException;
import com.challenge.primenumberservice.representation.PrimeNumberResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***********************************
 * This  Service implementation  ,which will handle the service logic  for
 *  Get Primer numbers list for the specified limit
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 17-APR-2021
 ************************************/
@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

    private static final Logger logger = LoggerFactory.getLogger(PrimeNumberServiceImpl.class);

    /*************************
     * This method will handle the service logic for
     * calculate and return a collection of all prime numbers
     *  it's called Sieve Of Eratosthenes. Its time efficiency is O(n logn).
     * @param upperLimit upperLimit
     * @return PrimeNumberResponse
     * @throws PrimeNumberException primeNumberException
     *******************************/
    @Override
    public PrimeNumberResponse getListOfPrimeNumbers(int upperLimit) throws PrimeNumberException {
        if (upperLimit <= 1) {
            throw new PrimeNumberException("upperLimit ShouldBe grater than 1");
        }
        PrimeNumberResponse primeNumberResponse = calculateAllPrimeNumbers(upperLimit);
        primeNumberResponse.setPrimeNumbersList(primeNumberResponse.getPrimeNumbersList());

        return primeNumberResponse;
    }

    private PrimeNumberResponse calculateAllPrimeNumbers(int upperLimit) {

        boolean[] prime = new boolean[upperLimit + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= upperLimit; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= upperLimit; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= upperLimit; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        PrimeNumberResponse primeNumberResponse = new PrimeNumberResponse();
        primeNumberResponse.setPrimeNumbersList(primeNumbers);
        return primeNumberResponse;
    }

    //Java 8 Approach for reference -- this is Brute Force Approach
     /*   public static List<Integer> primeNumbersTill(int upperLimit) {
            return IntStream.rangeClosed(2, n)
                    .filter(x -> isPrime(x)).boxed()
                    .collect(Collectors.toList());
        }
        private static boolean isPrime(int number) {
            return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                    .allMatch(n -> x % n != 0);
        }*/
}
