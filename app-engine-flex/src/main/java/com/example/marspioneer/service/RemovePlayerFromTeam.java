/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.service;
import com.example.marspioneer.model.MPPlayer;
import com.example.marspioneer.model.MPTeam;
import com.example.marspioneer.persistence.DBManager;
import com.example.marspioneer.proto.ListWorldsResponse;
import com.nkasenides.athlos.backend.AthlosService;
import com.example.marspioneer.proto.RemovePlayerFromTeamRequest;
import com.example.marspioneer.auth.*;
import com.example.marspioneer.proto.RemovePlayerFromTeamResponse;

public class RemovePlayerFromTeam implements AthlosService<RemovePlayerFromTeamRequest, RemovePlayerFromTeamResponse> {

    @Override    
    public RemovePlayerFromTeamResponse serve(RemovePlayerFromTeamRequest request, Object... additionalParams) {

        //Verify game session:
        final MPPlayer callingPlayer = Auth.verifyGameSessionID(request.getGameSessionID());
        if (callingPlayer == null) {
            return RemovePlayerFromTeamResponse.newBuilder()
                    .setStatus(RemovePlayerFromTeamResponse.Status.NOT_AUTHORIZED)
                    .setMessage("NOT_AUTHORIZED")
                    .build();
        }

        //Get the team:
        final MPTeam team = DBManager.team.get(request.getTeamID());
        if (team == null) {
            return RemovePlayerFromTeamResponse.newBuilder()
                    .setStatus(RemovePlayerFromTeamResponse.Status.NO_SUCH_TEAM)
                    .setMessage("NO_SUCH_TEAM")
                    .build();
        }

        //Get the player:
        final MPPlayer player = DBManager.player.get(request.getPlayerID());
        if (player == null) {
            return RemovePlayerFromTeamResponse.newBuilder()
                    .setStatus(RemovePlayerFromTeamResponse.Status.NO_SUCH_PLAYER)
                    .setMessage("NO_SUCH_PLAYER")
                    .build();
        }

        //Remove the player's teamID:
        player.setTeamID(null);

        //Remove the player's ID from the team:
        team.getPlayerIDs().remove(player.getId());

        return RemovePlayerFromTeamResponse.newBuilder()
                .setStatus(RemovePlayerFromTeamResponse.Status.OK)
                .setMessage("OK")
                .build();

    }    
    
}

