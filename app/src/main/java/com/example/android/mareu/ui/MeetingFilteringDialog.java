package com.example.android.mareu.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.android.mareu.R;

import java.util.Calendar;
import java.util.Date;


public class MeetingFilteringDialog extends DialogFragment {

    Spinner mRoomSpinner;
    DatePicker mDatePicker;
    CheckBox mRoomFilterCheckBox, mDateFilterCheckBox;
    private Button mValidateButton, mCancelButton;
    private OnValidateFilterListener mOnValidateFilterListener;

    public static MeetingFilteringDialog newInstance(String title) {
        MeetingFilteringDialog frag = new MeetingFilteringDialog();
        Bundle args = new Bundle();
        args.putString("Filtrer", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.meeting_filtering, container, false);
        // Set transparent background and no title
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRoomFilterCheckBox = view.findViewById(R.id.filter_by_room_checkbox);
        mDateFilterCheckBox = view.findViewById(R.id.filter_by_date_checkbox);
        mRoomSpinner = view.findViewById(R.id.filter_meeting_room_spinner);
        mDatePicker = view.findViewById(R.id.filter_date_datepicker);
        mCancelButton = view.findViewById(R.id.cancel_filter_button);
        mValidateButton = view.findViewById(R.id.validate_filter_button);
        getActivity();
        addRoomsInSpinner();
        addListenerOnCheckBox();
        addListenerOnButton();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            this.mOnValidateFilterListener = (OnValidateFilterListener)context;
        } catch (final ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnValidateFilterListener");
        }
    }

    public interface OnValidateFilterListener {
        void onValidateFilter(boolean pRoomFilterChecked, String pRoomFilteredName, boolean pDateFilterChecked, Date pDateFiltered);
    }

    public void addRoomsInSpinner() {

        mRoomSpinner = mRoomSpinner.findViewById(R.id.filter_meeting_room_spinner);
        //Cr??ation d'une liste d'??l??ment ?? mettre dans le Spinner(pour l'exemple)
        String[] roomList = new String[]{
                "Mario", "Luigi", "Toad", "Peach", "Daisy", "Yoshi", "Wario", "Waluigi", "Koopa", "Bowser"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, roomList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mRoomSpinner.setAdapter(adapter);

    }

    //get the selected dropdown list value
    public void addListenerOnButton() {
        mRoomSpinner = mRoomSpinner.findViewById(R.id.filter_meeting_room_spinner);
        mDatePicker = mDatePicker.findViewById(R.id.filter_date_datepicker);
        final OnValidateFilterListener vOnValidateFilterListener = this.mOnValidateFilterListener;
        mCancelButton = mCancelButton.findViewById(R.id.cancel_filter_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mValidateButton = mValidateButton.findViewById(R.id.validate_filter_button);
        mValidateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String vRoomToSendToFilter = mRoomSpinner.getSelectedItem().toString();
                final Date vDateToSendToFilter = getDateFromDatePicker(mDatePicker);
                vOnValidateFilterListener.onValidateFilter(mRoomFilterCheckBox.isChecked(), vRoomToSendToFilter, mDateFilterCheckBox.isChecked(), vDateToSendToFilter);
                dismiss();
            }
        });
    }

    /**
     *
     * @param datePicker get date from date picker for filter
     * @return a java.util.Date
     */
    public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    public void addListenerOnCheckBox() {
        mRoomSpinner.setVisibility(View.GONE);
        mDatePicker.setVisibility(View.GONE);
        mRoomFilterCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    mRoomSpinner.setVisibility(View.VISIBLE);
                } else {
                    mRoomSpinner.setVisibility(View.GONE);
                }
            }
        });
        mDateFilterCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    mDatePicker.setVisibility(View.VISIBLE);
                } else {
                    mDatePicker.setVisibility(View.GONE);
                }
            }
        });

    }

}