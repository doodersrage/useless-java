package com.java24hours.ws;

import java.util.*;
import javax.jws.*;

@WebService(endpointInterface = "com.java24hours.ws.SquareRootServer")

public class SquareRootServerImpl implements SquareRootServer {

    public double getSquareRoot(double input) {
        return Math.sqrt(input);
    }

    public String getTime() {
        Date now = new Date();
        return now.toString();
    }
}