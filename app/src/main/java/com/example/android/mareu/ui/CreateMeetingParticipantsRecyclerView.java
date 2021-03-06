package com.example.android.mareu.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.mareu.R;

import java.util.List;

/**
 *
 *
 */
public class CreateMeetingParticipantsRecyclerView extends RecyclerView.Adapter<CreateMeetingParticipantsRecyclerView.ViewHolder> {

    private final List<String> mParticipantsList;
    private final CreateMeetingParticipantsRecyclerInterface mCreateMeetingParticipantsRecyclerInterface;
    CreateMeetingParticipantsRecyclerView(List<String> items, CreateMeetingParticipantsRecyclerInterface pCreateMeetingParticipantsRecyclerInterface) {
        mParticipantsList = items;
        mCreateMeetingParticipantsRecyclerInterface = pCreateMeetingParticipantsRecyclerInterface;
    }


    @NonNull
    @Override
    public CreateMeetingParticipantsRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.participants_items_added, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreateMeetingParticipantsRecyclerView.ViewHolder holder, int position) {
        final String participant = mParticipantsList.get(position);
        holder.mItemParticipantName.setText(holder.itemView.getContext().getString(R.string.create_meeting_participant_added_name, participant));
        holder.mItemDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCreateMeetingParticipantsRecyclerInterface.deleteParticipantFromList(participant);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mParticipantsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //ImageView mItemParticipantAvatar;
        final TextView mItemParticipantName;
        final ImageButton mItemDeleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //mItemParticipantAvatar = itemView.findViewById(R.id.item_participant_added_avatar);
            mItemParticipantName = itemView.findViewById(R.id.item_participant_added_name);
            mItemDeleteButton = itemView.findViewById(R.id.item_participant_added_delete_button);
        }
    }
}
