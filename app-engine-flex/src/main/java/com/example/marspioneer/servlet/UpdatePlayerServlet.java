/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.servlet;

import com.example.marspioneer.service.Services;
import com.nkasenides.athlos.exception.ServiceNotFoundException;
import com.nkasenides.athlos.serverless.servlet.AthlosServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

@WebServlet(name = "UpdatePlayerServlet", urlPatterns = {"/api/player/update"})
public class UpdatePlayerServlet extends AthlosServlet {

    @Override
    protected byte[] callProcessMethod(HttpServletRequest servletRequest, HttpServletResponse servletResponse, DataInputStream inputStream) throws ServiceNotFoundException, IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        final Object[] additionalParameters = {
              servletRequest.getRemoteAddr(),
        };
        return Services.updatePlayer(buffer.toByteArray(), additionalParameters).toByteArray();
    }

}
