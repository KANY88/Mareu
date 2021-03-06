package com.example.android.mareu.model;

import java.io.Serializable;
import java.util.Objects;

public class MeetingParticipant implements Serializable {

    /** Identifier */
    private long id;

    /** Full name */
    private String participantName;

    /** eMail */
    private String participantEmail;

    /**
     * Constructor
     * @param id type long unique id
     * @param participantName String
     * @param participantEmail String
     */
    public MeetingParticipant(long id, String participantName, String participantEmail) {
        this.id = id;
        this.participantName = participantName;
        this.participantEmail = participantEmail;
    }

    public MeetingParticipant(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String name) {
        this.participantName = name;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingParticipant meetingParticipant = (MeetingParticipant) o;
        return Objects.equals(id, meetingParticipant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

