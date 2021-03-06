package com.example.android.mareu.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Meeting implements Serializable {

    /** Identifier */
    private long id;

    /** Reunion subject */
    private String subject;

    /** Location */
    private MeetingRoom meetingRoom;

    /** Begin time */
    private Date startTime;

    /** End time */
    private Date endTime;

    /** Participant list */
    private List<MeetingParticipant> participants;


    /**
     * Constructor
     */
    public Meeting(long id, String subject, MeetingRoom meetingRoom, Date startTime, Date endTime, List<MeetingParticipant> participants) {
        this.id = id;
        this.subject = subject;
        this.meetingRoom = meetingRoom;
        this.startTime = startTime;
        this.endTime = endTime;
        this.participants = participants;
    }

    public Meeting(String subject, Date startTime, Date endTime) {
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MeetingRoom getLocation() {
        return meetingRoom;
    }

    public String getMeetingRoom() {
        return meetingRoom.getRoomName();
    }

    public void setLocation(MeetingRoom location) {
        this.meetingRoom = location;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date beginTime) {
        this.startTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<MeetingParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<MeetingParticipant> participants) {
        this.participants = participants;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
