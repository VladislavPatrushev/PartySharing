package ru.nsu.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.nsu.server.Constants;
import ru.nsu.server.mappers.MyMapper;
import ru.nsu.server.model.Event;
import ru.nsu.server.model.Invite;
import ru.nsu.server.model.Participant;
import ru.nsu.server.model.Profile;
import ru.nsu.server.model.Request;
import ru.nsu.server.model.exchange.AcceptRequest;
import ru.nsu.server.model.exchange.AddEventRequest;
import ru.nsu.server.model.exchange.AddEventResponse;
import ru.nsu.server.model.exchange.ConfirmRequest;
import ru.nsu.server.model.exchange.EventPreview;
import ru.nsu.server.model.exchange.FeedResponse;
import ru.nsu.server.model.exchange.GetAllEventsResponse;
import ru.nsu.server.model.exchange.GetEventRequest;
import ru.nsu.server.model.exchange.GetEventResponse;
import ru.nsu.server.model.exchange.GetEventsRequest;
import ru.nsu.server.model.exchange.GetEventsResponse;
import ru.nsu.server.model.exchange.GetProfileRequest;
import ru.nsu.server.model.exchange.GetProfileResponse;
import ru.nsu.server.model.exchange.GetProfilesRequest;
import ru.nsu.server.model.exchange.GetProfilesResponse;
import ru.nsu.server.model.exchange.InviteRequest;
import ru.nsu.server.model.exchange.PartRequest;
import ru.nsu.server.model.exchange.RegisterRequest;
import ru.nsu.server.model.exchange.RegisterResponse;
import ru.nsu.server.model.types.InterestType;
import ru.nsu.server.mappers.*;
import ru.nsu.server.service.EventService;
import ru.nsu.server.service.ProfileService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@Slf4j
public class HttpController {

    private ProfileService profileService;
    private MyMapper myMapper;

    private EventService eventService;

    @Autowired
    public HttpController(ProfileService profileService, MyMapper myMapper,
                          EventService eventService) {
        this.profileService = profileService;
        this.myMapper = myMapper;
        this.eventService = eventService;
    }


    @GetMapping("/")
    @ResponseBody
    public String test() {
        return "Уровень знания GIT - master";
    }

    /**
     * Регистрация
     *
     */
    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        Profile newProfile = profileService.saveProfile(myMapper.registerRequestToProfile(registerRequest));
        return ResponseEntity.ok(new RegisterResponse(newProfile.getProfileId()));
    }

    //TODO: выдавать эвеенты только из города пользователя
    @GetMapping(value = "/feed")
    public ResponseEntity<FeedResponse> feed(@RequestHeader("Authorization") Long profileId) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        return ResponseEntity.ok(createFeedResponse(profile));
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<GetProfileResponse> getProfile(@RequestHeader("Authorization") Long profileId,
                                                         @RequestBody GetProfileRequest getProfileRequest) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        Profile responseProfile = profileService.getProfileById(getProfileRequest.getId());
        GetProfileResponse response = profileToGetProfileResponse(responseProfile);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/profiles")
    public ResponseEntity<GetProfilesResponse> getProfiles(@RequestHeader("Authorization") Long profileId,
                                                           @RequestBody GetProfilesRequest getProfilesRequest) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        List<Profile> profiles = profileService.getProfilesByIds(getProfilesRequest.getIds());
        GetProfilesResponse response = new GetProfilesResponse();
        response.setCount(profiles.size());
        response.setProfiles(profilesToGetProfilesResponse(profiles));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/event")
    public ResponseEntity<AddEventResponse> addEvent(@RequestHeader("Authorization") Long profileId,
                                                     @RequestBody AddEventRequest addEventRequest) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        Event newEvent = myMapper.addEventRequestToEvent(addEventRequest, profile.getProfileId());
        Event event = eventService.saveEvent(newEvent);
        return ResponseEntity.ok(new AddEventResponse(event.getEventId()));
    }

    @GetMapping(value = "/event")
    public ResponseEntity<GetEventResponse> getEvent(@RequestHeader("Authorization") Long profileId,
                                                     @RequestBody GetEventRequest getEventRequest) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        Event event = eventService.getEventById(getEventRequest.getId());
        List<Long> attend = eventService.getAttendProfileIds(event.getEventId());
        GetEventResponse response = myMapper.eventToGetEventResponse(event, attend);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/events")
    public ResponseEntity<GetAllEventsResponse> getAllEvents(@RequestHeader("Authorization") Long profileId) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        List<Event> allEvents = eventService.getAllEvents();
        GetAllEventsResponse response = new GetAllEventsResponse();
        response.setCount(allEvents.size());
        response.setEvents(eventsToPreviews(allEvents));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/eventsByIds")
    public ResponseEntity<GetEventsResponse> getAllEventsByIds(@RequestHeader("Authorization") Long profileId,
                                                               @RequestBody GetEventsRequest getEventsRequest) {
        List<Event> events = eventService.getEventsByIds(getEventsRequest.getIds());
        List<EventPreview> eventPreviews = eventsToPreviews(events);
        GetEventsResponse getEventsResponse = new GetEventsResponse();
        getEventsResponse.setCount(eventPreviews.size());
        getEventsResponse.setEvents(eventPreviews);
        return ResponseEntity.ok(getEventsResponse);
    }

    @PostMapping(value = "/request")
    public ResponseEntity<String> requestParticipate(@RequestHeader("Authorization") Long profileId,
                                                     @RequestBody PartRequest partRequest) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        Event event = eventService.getEventById(partRequest.getEventId());
        if (event == null) {
            return ResponseEntity.badRequest().build();
        }
        Request request = new Request();
        request.setProfileId(profile.getProfileId());
        request.setEventId(partRequest.getEventId());
        eventService.saveRequest(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/invite")
    public ResponseEntity<String> invite(@RequestHeader("Authorization") Long profileId,
                                         @RequestBody InviteRequest inviteRequest) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        if (checkProfileAndEventIsBad(inviteRequest.getUserId(), inviteRequest.getEventId())) {
            return ResponseEntity.badRequest().build();
        }
        Invite newInvite = new Invite();
        newInvite.setProfileId(inviteRequest.getUserId());
        newInvite.setEventId(inviteRequest.getEventId());
        eventService.saveInvite(newInvite);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/accept")
    public ResponseEntity<String> accept(@RequestHeader("Authorization") Long profileId,
                                         @RequestBody AcceptRequest acceptRequest) {
        if (profileService.getProfileById(profileId) == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        if (checkProfileAndEventIsBad(acceptRequest.getUserId(), acceptRequest.getEventId())) {
            return ResponseEntity.badRequest().build();
        }
        Participant newParticipant = new Participant();
        newParticipant.setEventId(acceptRequest.getEventId());
        newParticipant.setProfileId(acceptRequest.getUserId());
        eventService.deleteRequestByUserAndEventId(newParticipant.getProfileId(), newParticipant.getEventId());
        eventService.saveParticipant(newParticipant);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/confirm")
    public ResponseEntity<String> confirm(@RequestHeader("Authorization") Long profileId,
                                          @RequestBody ConfirmRequest confirmRequest) {
        if (profileService.getProfileById(profileId) == null) {
            return ResponseEntity.status(Constants.FORBIDDEN).build();
        }
        if (eventService.getEventById(confirmRequest.getEventId()) == null) {
            return ResponseEntity.badRequest().build();
        }
        Participant newParticipant = new Participant();
        newParticipant.setEventId(confirmRequest.getEventId());
        newParticipant.setProfileId(profileId);
        eventService.deleteInviteByUserAndEventId(profileId, confirmRequest.getEventId());
        eventService.saveParticipant(newParticipant);
        return ResponseEntity.ok().build();
    }

    private boolean checkProfileAndEventIsBad(Long profileId, Long eventId) {
        Profile user = profileService.getProfileById(profileId);
        if (user == null) {
            return true;
        }
        Event event = eventService.getEventById(eventId);
        return event == null;
    }

    private FeedResponse createFeedResponse(Profile profile) {
        List<InterestType> interests = interestStrToList(profile.getInterests());
        List<Event> feedEvents = eventService.getEventsByCategories(interests);
        List<Event> pendingEvents = eventService.getPendingEvents(profile.getProfileId());
        List<EventPreview> feedData = eventsToPreviews(feedEvents);
        List<EventPreview> pendingData = eventsToPreviews(pendingEvents);
        FeedResponse response = new FeedResponse();
        FeedResponse.Feed feed = new FeedResponse.Feed();
        FeedResponse.Pending pending = new FeedResponse.Pending();
        feed.setCount(feedData.size());
        feed.setData(feedData);
        pending.setCount(pendingData.size());
        pending.setData(pendingData);
        response.setFeed(feed);
        response.setPending(pending);
        return response;
    }

    private List<GetProfileResponse> profilesToGetProfilesResponse(List<Profile> profiles) {
        return profiles.stream()
                .map(this::profileToGetProfileResponse)
                .collect(Collectors.toList());
    }

    private GetProfileResponse profileToGetProfileResponse(Profile profile) {
        List<Long> attend = eventService.getAttendEventsIds(profile.getProfileId());
        List<Long> manage = eventService.findEventIdsByCreatorId(profile.getProfileId());
        return myMapper.profileToGetProfileResponse(profile, attend, manage);
    }

    private List<EventPreview> eventsToPreviews(List<Event> events) {
        return events.stream()
                .map(event -> myMapper.eventToEventPreview(event))
                .collect(Collectors.toList());
    }

    private List<InterestType> interestStrToList(String interests) {
        return Arrays.stream(interests.split(Constants.INTEREST_SEPARATOR))
                .map(InterestType::valueOf)
                .collect(Collectors.toList());
    }

}

