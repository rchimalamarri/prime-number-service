package com.challenge.primenumberservice.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***********************************
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 17-APR-2021
 ************************************/
public class PrimeNumberResponse {
    @JsonProperty("PrimeNumbersList")
    List<Integer> primeNumbersList = new ArrayList<>();

    public List<Integer> getPrimeNumbersList() {
        return primeNumbersList;
    }

    public void setPrimeNumbersList(List<Integer> primeNumbersList) {
        this.primeNumbersList = primeNumbersList;
    }

    @Override
    public String toString() {
        return "PrimeNumberResponse{" +
                "primeNumbersList=" + primeNumbersList +
                '}';
    }
}
