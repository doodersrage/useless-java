package com.java24hours.ws;

import javax.jws.*;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.*;

@WebService

@SOAPBinding(style = Style.RPC)

public interface SquareRootServer {
    // get the square root of a number
    @WebMethod double getSquareRoot(double input);

    // get the current time and date as a string
    @WebMethod String getTime();

}