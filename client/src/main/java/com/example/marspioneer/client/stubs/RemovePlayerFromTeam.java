/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.client.stubs;


import com.example.marspioneer.proto.*;
import com.nkasenides.athlos.client.stubs.OnRequestSuccessListener;
import com.raylabz.javahttp.BinaryHTTPRequest;
import com.raylabz.javahttp.OnFailureListener;
public class RemovePlayerFromTeam {

    private final String url = Stubs.BASE_URL + "/api/team/removePlayer";

    public void sendAndWait(RemovePlayerFromTeamRequest request, OnRequestSuccessListener<RemovePlayerFromTeamResponse> successListener, OnFailureListener failureListener) {
        BinaryHTTPRequest.create(url)
                .onSuccess(response -> {
                    final byte[] content = response.getContent();
                    final RemovePlayerFromTeamResponse protoResponse = RemovePlayerFromTeamResponse.parseFrom(content);
                    successListener.onSuccess(protoResponse);
                })
                .onFailure(failureListener)
                .putBytes(request.toByteArray())
                .build()
                .sendAndWait();
    }

    public void send(RemovePlayerFromTeamRequest request, OnRequestSuccessListener<RemovePlayerFromTeamResponse> successListener, OnFailureListener failureListener) {
        BinaryHTTPRequest.create(url)
                .onSuccess(response -> {
                    final byte[] content = response.getContent();
                    final RemovePlayerFromTeamResponse protoResponse = RemovePlayerFromTeamResponse.parseFrom(content);
                    successListener.onSuccess(protoResponse);
                })
                .onFailure(failureListener)
                .putBytes(request.toByteArray())
                .build()
                .send();
    }

    public void sendAndWait(RemovePlayerFromTeamRequest request, OnRequestSuccessListener<RemovePlayerFromTeamResponse> successListener) {
        BinaryHTTPRequest.create(url)
                .onSuccess(response -> {
                    final byte[] content = response.getContent();
                    final RemovePlayerFromTeamResponse protoResponse = RemovePlayerFromTeamResponse.parseFrom(content);
                    successListener.onSuccess(protoResponse);
                })
                .putBytes(request.toByteArray())
                .build()
                .sendAndWait();
    }

    public void send(RemovePlayerFromTeamRequest request, OnRequestSuccessListener<RemovePlayerFromTeamResponse> successListener) {
        BinaryHTTPRequest.create(url)
                .onSuccess(response -> {
                    final byte[] content = response.getContent();
                    final RemovePlayerFromTeamResponse protoResponse = RemovePlayerFromTeamResponse.parseFrom(content);
                    successListener.onSuccess(protoResponse);
                })
                .putBytes(request.toByteArray())
                .build()
                .send();
    }
}

