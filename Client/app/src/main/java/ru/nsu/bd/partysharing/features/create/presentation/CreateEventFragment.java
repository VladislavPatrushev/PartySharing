package ru.nsu.bd.partysharing.features.create.presentation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import ru.nsu.bd.partysharing.R;
import ru.nsu.bd.partysharing.util.Converter;
import ru.nsu.bd.partysharing.util.IdSaver;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

public class CreateEventFragment extends Fragment {
    private TextView aboutEvent;
    private EditText title;
    private EditText city;
    private EditText description;
    private ImageButton image;
    private Button chooseDate;
    private Button createEvent;
    private TextView date;
    private EditText address;
    private String dateFormated;

    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    CreateEventActivity activity;
    CreatePresenter presenter;

    @Override
        public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_event_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        aboutEvent = view.findViewById(R.id.eventTextView);
        date = view.findViewById(R.id.event_date);
        title = view.findViewById(R.id.event_tittle);
        city = view.findViewById(R.id.event_city);
        description = view.findViewById(R.id.event_desc);
        image = view.findViewById(R.id.imageButton);
        chooseDate = view.findViewById(R.id.pick_date_button);
        createEvent = view.findViewById(R.id.create_button);
        address = view.findViewById(R.id.event_address);
        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year  = calendar.get(Calendar.YEAR);
                datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        date.setText(day + "/" + (month + 1) + "/" +year);
                        dateFormated = "2018-12-12T00:00:00";
                    }
                }, day, month, year);
                datePickerDialog.show();
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setEventInfo(title.getText().toString(),
                        city.getText().toString(), address.getText().toString(), dateFormated,
                        description.getText().toString());
                presenter.create(IdSaver.getId(getActivity()));
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (CreateEventActivity)getActivity();
        presenter = activity.accessPresenter();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (data == null) {
                return;
            }
            try {
                InputStream inputStream = activity.getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                image.setImageBitmap(bitmap);
                presenter.setImage(Converter.bitmapToBase64(bitmap));
            } catch (FileNotFoundException e) {
                //pass
            }
        }
    }

}
