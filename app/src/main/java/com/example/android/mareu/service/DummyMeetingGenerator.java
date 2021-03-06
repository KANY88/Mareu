package com.example.android.mareu.service;

import com.example.android.mareu.model.Meeting;
import com.example.android.mareu.model.MeetingParticipant;
import com.example.android.mareu.model.MeetingRoom;
import com.example.android.mareu.model.MeetingRoomColor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public abstract class DummyMeetingGenerator {

    // Generate meeting participants list
    public static final List<MeetingParticipant> DUMMY_PARTICIPANTS = Arrays.asList(
            new MeetingParticipant(0, "Paul", "paul@lamzone.com"),
            new MeetingParticipant(1, "Maxime", "maxime@lamzone.com"),
            new MeetingParticipant(2, "Amandine", "amandine@lamzone.com"),
            new MeetingParticipant(3, "Aurélie", "aurelie@lamzone.com"),
            new MeetingParticipant(4, "Vivianne", "vivianne@lamzone.com"),
            new MeetingParticipant(5, "Fady", "fady@lamzone.com"),
            new MeetingParticipant(6, "Jean", "jean@lamzone.com"),
            new MeetingParticipant(7, "aymeric", "aymerice@lamzone.com"),
            new MeetingParticipant(8, "Caroline", "caroline@lamzone.com"),
            new MeetingParticipant(9, "Stéphane", "stéphane@lamzone.com"),
            new MeetingParticipant(10, "Céline", "celine@lamzone.com"),
            new MeetingParticipant(11, "Michel", "michel@lamzone.com")
    );

    // Generate meeting rooms list
    public static final List<MeetingRoom> DUMMY_MEETINGROOMS = Arrays.asList(
            new MeetingRoom(0, "Mario", MeetingRoomColor.RED),
            new MeetingRoom(1, "Luigi", MeetingRoomColor.GREEN),
            new MeetingRoom(2, "Toad", MeetingRoomColor.BLUE),
            new MeetingRoom(3, "Peach", MeetingRoomColor.PEACH),
            new MeetingRoom(4, "Daisy", MeetingRoomColor.LIGHT_BLUE),
            new MeetingRoom(5, "Yoshi", MeetingRoomColor.PINK),
            new MeetingRoom(6, "Wario", MeetingRoomColor.DARK_RED),
            new MeetingRoom(7, "Waluigi", MeetingRoomColor.PURPLE),
            new MeetingRoom(8, "Koopa", MeetingRoomColor.YELLOW),
            new MeetingRoom(9, "Bowser", MeetingRoomColor.ORANGE)
    );

    // Generate meetings list
    public static final List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(0, "Treasury", DUMMY_MEETINGROOMS.get(3), setStartTime("15/02/21 14:00"),
                    setEndTime("15/02/21 15:00"), getReunionParticipantsById(1, 3, 5, 7, 9, 11)),
            new Meeting(1, "Information", DUMMY_MEETINGROOMS.get(0), setStartTime("15/02/21 16:00"),
                    setEndTime("15/02/21 17:30"), getReunionParticipantsById(0, 2, 4, 6, 8, 10)),
            new Meeting(2, "New Product", DUMMY_MEETINGROOMS.get(1), setStartTime("16/02/21 19:00"),
                    setEndTime("16/02/21 21:00"), getReunionParticipantsById(0, 1, 3, 4, 5, 7, 9, 10, 11)),
            new Meeting(3, "Recruitment", DUMMY_MEETINGROOMS.get(5), setStartTime("19/02/21 9:00"),
                    setEndTime("19/02/21 09:30"), getReunionParticipantsById(2, 3, 5, 8, 9, 10)),
            new Meeting(4, "Evolution", DUMMY_MEETINGROOMS.get(9), setStartTime("20/02/21 10:00"),
                    setEndTime("20/02/21 11:30"), getReunionParticipantsById(0, 1, 2, 3, 5, 6, 7, 9, 11))
    );

    // Set Start and End time for Dummy meetings
    private static Date setStartTime(String date){
        Date startTime = new Date();
        try {
            startTime = new SimpleDateFormat("dd/MM/yy HH:mm", Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startTime;
    }

    private static Date setEndTime(String date){
        Date endTime = new Date();
        try {
            endTime = new SimpleDateFormat("dd/MM/yy HH:mm", Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endTime;
    }

    // Get participants in the dummy list
    private static List<MeetingParticipant> getReunionParticipantsById(int ...id){
        List<MeetingParticipant> meetingParticipants = new ArrayList<>();
        for(int x : id) meetingParticipants.add(DUMMY_PARTICIPANTS.get(x));
        return meetingParticipants;
    }

    // Returns dummy lists
    static ArrayList<Meeting> generateMeetings (){
        return new ArrayList<>(DUMMY_MEETINGS);
    }

    static List<MeetingRoom> generateMeetingRooms(){
        return new ArrayList<>(DUMMY_MEETINGROOMS);
    }

    static List<MeetingParticipant> generateMeetingParticipants (){
        return new ArrayList<>(DUMMY_PARTICIPANTS);
    }
}
