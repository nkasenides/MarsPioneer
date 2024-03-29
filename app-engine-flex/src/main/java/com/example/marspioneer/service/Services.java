/* --------------------------------------------------------------------------------
  This file was automatically generated by the Athlos Project Editor.
  Athlos Project Editor, v1.0 BETA
-------------------------------------------------------------------------------- */

package com.example.marspioneer.service;

import com.example.marspioneer.proto.*;
import com.google.protobuf.InvalidProtocolBufferException;
import com.nkasenides.athlos.exception.ServiceNotFoundException;

public class Services {

//    public static ListTeamsResponse listTeams(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {
//        try {
//            ListTeamsRequest request = ListTeamsRequest.parseFrom(data);
//            return new ListTeams().serve(request, optionalParams);
//        } catch (InvalidProtocolBufferException e) {
//            throw new ServiceNotFoundException("Your request data did not match the expected service request type (ListTeamsRequest).", e);
//        }
//    }
    
    public static UpdatePlayerResponse updatePlayer(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            UpdatePlayerRequest request = UpdatePlayerRequest.parseFrom(data);            
            return new UpdatePlayer().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (UpdatePlayerRequest).", e);            
        }        
    }    
    
    public static GetWorldResponse getWorld(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            GetWorldRequest request = GetWorldRequest.parseFrom(data);            
            return new GetWorld().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (GetWorldRequest).", e);            
        }        
    }    
    
    public static UpdateTeamResponse updateTeam(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            UpdateTeamRequest request = UpdateTeamRequest.parseFrom(data);            
            return new UpdateTeam().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (UpdateTeamRequest).", e);            
        }        
    }    
    
    public static SubscribeResponse subscribe(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            SubscribeRequest request = SubscribeRequest.parseFrom(data);            
            return new Subscribe().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (SubscribeRequest).", e);            
        }        
    }    
    
    public static ListPlayersResponse listPlayers(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {
        try {
            ListPlayersRequest request = ListPlayersRequest.parseFrom(data);
            return new ListPlayers().serve(request, optionalParams);
        } catch (InvalidProtocolBufferException e) {
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (ListPlayersRequest).", e);
        }
    }
    
    public static GetTeamResponse getTeam(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            GetTeamRequest request = GetTeamRequest.parseFrom(data);            
            return new GetTeam().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (GetTeamRequest).", e);            
        }        
    }    
    
    public static RemovePlayerFromTeamResponse removePlayerFromTeam(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            RemovePlayerFromTeamRequest request = RemovePlayerFromTeamRequest.parseFrom(data);            
            return new RemovePlayerFromTeam().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (RemovePlayerFromTeamRequest).", e);            
        }        
    }    
    
//    public static GetBuildingTypeResponse getBuildingType(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {
//        try {
//            GetBuildingTypeRequest request = GetBuildingTypeRequest.parseFrom(data);
//            return new GetBuildingType().serve(request, optionalParams);
//        } catch (InvalidProtocolBufferException e) {
//            throw new ServiceNotFoundException("Your request data did not match the expected service request type (GetBuildingTypeRequest).", e);
//        }
//    }
    
    public static AuthenticateResponse authenticate(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            AuthenticateRequest request = AuthenticateRequest.parseFrom(data);            
            return new Authenticate().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (AuthenticateRequest).", e);            
        }        
    }    
    
//    public static UpdateBuildingTypeResponse updateBuildingType(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {
//        try {
//            UpdateBuildingTypeRequest request = UpdateBuildingTypeRequest.parseFrom(data);
//            return new UpdateBuildingType().serve(request, optionalParams);
//        } catch (InvalidProtocolBufferException e) {
//            throw new ServiceNotFoundException("Your request data did not match the expected service request type (UpdateBuildingTypeRequest).", e);
//        }
//    }
    
    public static UnsubscribeResponse unsubscribe(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            UnsubscribeRequest request = UnsubscribeRequest.parseFrom(data);            
            return new Unsubscribe().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (UnsubscribeRequest).", e);            
        }        
    }    
    
    public static CreateWorldResponse createWorld(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            CreateWorldRequest request = CreateWorldRequest.parseFrom(data);            
            return new CreateWorld().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (CreateWorldRequest).", e);            
        }        
    }    
    
    public static DeleteWorldResponse deleteWorld(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            DeleteWorldRequest request = DeleteWorldRequest.parseFrom(data);            
            return new DeleteWorld().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (DeleteWorldRequest).", e);            
        }        
    }    
    
    public static ListWorldsResponse listWorlds(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            ListWorldsRequest request = ListWorldsRequest.parseFrom(data);            
            return new ListWorlds().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (ListWorldsRequest).", e);            
        }        
    }    
    
    public static UpdateWorldResponse updateWorld(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            UpdateWorldRequest request = UpdateWorldRequest.parseFrom(data);            
            return new UpdateWorld().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (UpdateWorldRequest).", e);            
        }        
    }    
    
    public static ListTeamPlayersResponse listTeamPlayers(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            ListTeamPlayersRequest request = ListTeamPlayersRequest.parseFrom(data);            
            return new ListTeamPlayers().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (ListTeamPlayersRequest).", e);            
        }        
    }    
    
    public static CreatePlayerResponse createPlayer(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            CreatePlayerRequest request = CreatePlayerRequest.parseFrom(data);            
            return new CreatePlayer().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (CreatePlayerRequest).", e);            
        }        
    }    
    
    public static JoinWorldResponse joinWorld(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            JoinWorldRequest request = JoinWorldRequest.parseFrom(data);            
            return new JoinWorld().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (JoinWorldRequest).", e);            
        }        
    }    
    
    public static DeAuthenticateResponse deAuthenticate(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            DeAuthenticateRequest request = DeAuthenticateRequest.parseFrom(data);            
            return new DeAuthenticate().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (DeAuthenticateRequest).", e);            
        }        
    }    
    
    public static DeletePlayerResponse deletePlayer(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            DeletePlayerRequest request = DeletePlayerRequest.parseFrom(data);            
            return new DeletePlayer().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (DeletePlayerRequest).", e);            
        }        
    }    
    
    public static LeaveWorldResponse leaveWorld(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            LeaveWorldRequest request = LeaveWorldRequest.parseFrom(data);            
            return new LeaveWorld().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (LeaveWorldRequest).", e);            
        }        
    }    
    
    public static GetPlayerResponse getPlayer(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            GetPlayerRequest request = GetPlayerRequest.parseFrom(data);            
            return new GetPlayer().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (GetPlayerRequest).", e);            
        }        
    }    
    
    public static AddPlayerToTeamResponse addPlayerToTeam(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            AddPlayerToTeamRequest request = AddPlayerToTeamRequest.parseFrom(data);            
            return new AddPlayerToTeam().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (AddPlayerToTeamRequest).", e);            
        }        
    }    
    
//    public static DeleteBuildingTypeResponse deleteBuildingType(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {
//        try {
//            DeleteBuildingTypeRequest request = DeleteBuildingTypeRequest.parseFrom(data);
//            return new DeleteBuildingType().serve(request, optionalParams);
//        } catch (InvalidProtocolBufferException e) {
//            throw new ServiceNotFoundException("Your request data did not match the expected service request type (DeleteBuildingTypeRequest).", e);
//        }
//    }
    
//    public static ListBuildingTypesResponse listBuildingTypes(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {
//        try {
//            ListBuildingTypesRequest request = ListBuildingTypesRequest.parseFrom(data);
//            return new ListBuildingTypes().serve(request, optionalParams);
//        } catch (InvalidProtocolBufferException e) {
//            throw new ServiceNotFoundException("Your request data did not match the expected service request type (ListBuildingTypesRequest).", e);
//        }
//    }
    
    public static CreateTeamResponse createTeam(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            CreateTeamRequest request = CreateTeamRequest.parseFrom(data);            
            return new CreateTeam().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (CreateTeamRequest).", e);            
        }        
    }    
    
    public static DeleteTeamResponse deleteTeam(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {        
            DeleteTeamRequest request = DeleteTeamRequest.parseFrom(data);            
            return new DeleteTeam().serve(request, optionalParams);            
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (DeleteTeamRequest).", e);            
        }        
    }    
    
    public static GetStateResponse getState(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {    
        try {
            long t = System.currentTimeMillis();
            GetStateRequest request = GetStateRequest.parseFrom(data);
            System.out.println("~~ REQUEST DESERIALIZATION: " + (System.currentTimeMillis() - t));
            return new GetState().serve(request, optionalParams);
        } catch (InvalidProtocolBufferException e) {        
            throw new ServiceNotFoundException("Your request data did not match the expected service request type (GetStateRequest).", e);            
        }        
    }    
    
//    public static CreateBuildingTypeResponse createBuildingType(byte[] data, Object[] optionalParams) throws ServiceNotFoundException {
//        try {
//            CreateBuildingTypeRequest request = CreateBuildingTypeRequest.parseFrom(data);
//            return new CreateBuildingType().serve(request, optionalParams);
//        } catch (InvalidProtocolBufferException e) {
//            throw new ServiceNotFoundException("Your request data did not match the expected service request type (CreateBuildingTypeRequest).", e);
//        }
//    }
    

}
