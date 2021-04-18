package com.challenge.primenumberservice.controller;

import com.challenge.primenumberservice.exception.PrimeNumberException;
import com.challenge.primenumberservice.representation.PrimeNumberResponse;
import com.challenge.primenumberservice.service.PrimeNumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/***********************************
 * This is micro service controller ,which will handle the request for
 *  end point to get the prime numbersList
 *
 * @author Raghu Vamsi Chimalamarri (rchimalamarri@gmail.com)
 * @version 1.0
 * @since 17-APR-2021
 ************************************/
@Named
@Controller
@Path("prime")
public class PrimeNumberController {
    private static final Logger logger = LoggerFactory.getLogger(PrimeNumberController.class);

    private final PrimeNumberService primeNumberService;


    @Autowired
    public PrimeNumberController(PrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
    }


    @GET
    @Path("/numberList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGuestInfo(
            @HeaderParam("UpperLimit") int limit) {
        try {
            PrimeNumberResponse primeNumbersList = primeNumberService.getListOfPrimeNumbers(limit);
            return Response.status(Response.Status.OK).entity(primeNumbersList).build();
        } catch (PrimeNumberException e) {
            logger.info("Error occurred in Due to the bad data");
            return badRequest();
        } catch (Exception e) {
            logger.info("Some thing went wrong in while calculating the prime number");
            return internalServerError();
        }
    }

    private Response badRequest() {
        return Response.status(Response.Status.BAD_REQUEST).entity("UpperLimit Should be grater Than 1").build();

    }

    private Response internalServerError() {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
