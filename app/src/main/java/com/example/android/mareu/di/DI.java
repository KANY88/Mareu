package com.example.android.mareu.di;

import com.example.android.mareu.service.DummyMeetingApiService;
import com.example.android.mareu.service.MeetingApiService;

public class DI {

    private static final MeetingApiService service = new DummyMeetingApiService();

    /**
     * Get an instance on @{@link MeetingApiService}
     * @return service
     */
    public static MeetingApiService getMeetingApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link MeetingApiService}. Useful for tests, so we ensure the context is clean.
     * @return new DummyMeetingApiService
     */
    public static MeetingApiService getNewInstanceApiService() {
        return new DummyMeetingApiService();
    }
}
