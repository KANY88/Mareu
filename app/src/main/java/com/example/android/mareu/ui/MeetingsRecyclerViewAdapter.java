package com.example.android.mareu.ui;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.mareu.R;
import com.example.android.mareu.model.Meeting;
import com.example.android.mareu.model.MeetingParticipant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MeetingsRecyclerViewAdapter extends RecyclerView.Adapter<MeetingsRecyclerViewAdapter.ViewHolder> {

    public final List<Meeting> mMeetingList;

    private final MeetingRecyclerInterface mMeetingRecyclerInterface;

    MeetingsRecyclerViewAdapter(List<Meeting> items, MeetingRecyclerInterface pMeetingRecyclerInterface) {
        mMeetingList = items;
        mMeetingRecyclerInterface = pMeetingRecyclerInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meeting_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

         Meeting mMeeting = mMeetingList.get(position);
        Log.d("List of meetings", "onBindViewHolder: " + mMeetingList.toString());
        Date startTime = mMeeting.getStartTime();
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm");
        String strStartTime = dateFormat.format(startTime);
        holder.mItemMeetingInfo.setText(holder.itemView.getContext().getString(R.string.item_meeting_infos, mMeeting.getSubject(), strStartTime, mMeeting.getLocation().getRoomName()));
        holder.mItemListParticipants.setText(getMeetingParticipantsListToString(mMeeting.getParticipants()));
        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMeetingRecyclerInterface.deleteMeeting(mMeetingList.get(position));
                Log.d("Meeting to Delete", "onClick: " + position);
            }
        });
        switch (mMeeting.getLocation().getAvatarColor()) {
            case RED:
                holder.mItemMeetingAvatar.setColorFilter(0xFFED2939);
                break;
            case GREEN:
                holder.mItemMeetingAvatar.setColorFilter(0xFF3CB043);
                break;
            case BLUE:
                holder.mItemMeetingAvatar.setColorFilter(0xFF0066CC);
                break;
            case PINK:
                holder.mItemMeetingAvatar.setColorFilter(0xFFFFD1DC);
                break;
            case PEACH:
                holder.mItemMeetingAvatar.setColorFilter(0xFFFFCBA4);
                break;
            case YELLOW:
                holder.mItemMeetingAvatar.setColorFilter(0xFFEFFD5F);
                break;
            case ORANGE:
                holder.mItemMeetingAvatar.setColorFilter(0xFFFF9D5C);
                break;
            case PURPLE:
                holder.mItemMeetingAvatar.setColorFilter(0xFFB200ED);
                break;
            case LIGHT_BLUE:
                holder.mItemMeetingAvatar.setColorFilter(0xFF7AD7F0);
                break;
            case DARK_RED:
                holder.mItemMeetingAvatar.setColorFilter(0xFF8B0000);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mMeeting.getLocation().getAvatarColor());
        }
    }

    static String getMeetingParticipantsListToString (List<MeetingParticipant> meetingParticipants) {
        StringBuilder meetingParticipantsList = new StringBuilder();
        for (int i = 0; i < meetingParticipants.size(); i++) {
            meetingParticipantsList.append(meetingParticipants.get(i).getParticipantEmail());
            if (i < meetingParticipants.size()-1) meetingParticipantsList.append(", ");
        }
        meetingParticipantsList.append(".");
        return meetingParticipantsList.toString();
    }

    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView mItemMeetingAvatar;
        final TextView mItemMeetingInfo;
        final TextView mItemListParticipants;
        final ImageButton mDeleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemMeetingAvatar = itemView.findViewById(R.id.item_meeting_avatar);
            mItemMeetingInfo = itemView.findViewById(R.id.item_meeting_info);
            mItemListParticipants = itemView.findViewById(R.id.item_list_participants);
            mDeleteButton = itemView.findViewById(R.id.item_list_delete_button);

        }
    }
}