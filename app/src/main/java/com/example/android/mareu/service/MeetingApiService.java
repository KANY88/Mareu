package com.example.android.mareu.service;

import com.example.android.mareu.model.Meeting;
import com.example.android.mareu.model.MeetingParticipant;
import com.example.android.mareu.model.MeetingRoom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *
 */
public interface MeetingApiService {

    /**
     * Get Meetings
     * @return {@link ArrayList}
     */
    ArrayList<Meeting> getMeetings();

    /**
     * Create a Meeting
     */
    void createMeeting(Meeting meeting);

    /**
     * Delete a Meeting
     */
    void deleteMeeting(Meeting meeting);

    /**
     * Get Meeting Rooms
     * @return {@link List}
     */
    List<MeetingRoom> getMeetingRooms();

    /**
     * Get  Meeting Participants
     * @return {@link List}
     */
    List<MeetingParticipant> getMeetingParticipants();

    /**
     * Get filtered Meetings
     * @return {@link ArrayList}
     */
    ArrayList<Meeting> getFilteredMeetings(boolean isFilteredByRoom, String roomFiltered, boolean isFilteredByDate, Date DateFiltered);

}
