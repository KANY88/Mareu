package com.example.android.mareu;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.android.mareu.ui.MeetingListActivity;
import com.example.android.mareu.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.example.android.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Test Class for List of Meetings
 */

@RunWith(AndroidJUnit4.class)
public class MeetingListTests {

    //This is fixed
    private static final int ITEMS_COUNT = 6;
    private int POSITION_ITEM = 0;

    @Rule
    public final ActivityTestRule<MeetingListActivity> mActivityTestRule =
            new ActivityTestRule<>(MeetingListActivity.class);

    @Before
    public void setUp() {
        MeetingListActivity activity = mActivityTestRule.getActivity();
        assertThat(activity,notNullValue());
    }

    /**
     *  We ensure that our recyclerview is displaying at least one item
     */
    @Test
    public void MeetingList_shouldNotBeEmpty() {
        onView(withId(R.id.list_meetings)).check(matches(hasMinimumChildCount(1)));
        onView(ViewMatchers.hasMinimumChildCount(1));
    }
    @Test
    public void CreateMeeting_withSuccess_shouldAddTheNewMeetingInTheList() {
        // Given : We create meeting with success
        onView(withId(R.id.create_meeting_button)).perform(click());
        // When : filling the form
        onView(allOf(withId(R.id.create_meeting_subject))).perform(typeText("Subject"));
        onView(withId(R.id.create_meeting_autocomplete_search_participant)).perform(scrollTo(), typeText("l"));
        onData(equalTo("Luc@lamzone.com")).inRoot(RootMatchers.isPlatformPopup()).perform(click());
        onView(withId(R.id.create_meeting_scrollview)).perform(swipeUp());
        onView(withId(R.id.create_meeting_validate_button)).perform(click());
        // Then : The meeting list size should be 6
        onView(withId(R.id.list_meetings)).check(withItemCount(6));
    }
    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void MeetingList_deleteAction_shouldRemoveItem() {
        // Given : Remove element 1
        onView(withId(R.id.list_meetings)).check(withItemCount(ITEMS_COUNT));
        // When performing a click on the delete button
        onView(withId(R.id.list_meetings)).perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));
        // Then the number of items must be 4
        onView(withId(R.id.list_meetings)).check(withItemCount(ITEMS_COUNT-1));
    }

}