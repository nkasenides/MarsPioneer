/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.servlet;

import com.example.marspioneer.service.Services;
import com.nkasenides.athlos.exception.ServiceNotFoundException;
import com.nkasenides.athlos.serverless.servlet.AthlosServlet;
import com.raylabz.objectis.Objectis;
import redis.clients.jedis.JedisPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

@WebServlet(name = "CleanCacheServlet", urlPatterns = {"/cleanCache"})
public class CleanCacheServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Objectis.init((JedisPool) req.getServletContext().getAttribute("jedisPool"));
            Objectis.flush();
            resp.getWriter().println("FLUSH OK");
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
