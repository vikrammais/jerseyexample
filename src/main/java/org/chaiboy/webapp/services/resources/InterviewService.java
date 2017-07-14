package org.chaiboy.webapp.services.resources;

import org.chaiboy.webapp.core.controllers.InterviewController;
import org.chaiboy.webapp.entity.response.CustomerInfoResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by laxman.muttineni on 10/07/17.
 */

@Path("/interview")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InterviewService {

    private InterviewController interviewController;

    @Inject
    public InterviewService(InterviewController interviewController) {
        this.interviewController = interviewController;
    }

    @POST
    @Path("/")
    public Customer() throws Exception {
        return customerController.getCustomerDetails();
    }

}
