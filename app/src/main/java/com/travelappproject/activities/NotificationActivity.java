package com.travelappproject.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.travelappproject.R;
import com.travelappproject.adapter.NotificationAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView rcvNotifications;
    NotificationAdapter notificationAdapter;
    List<Date> dateList = new ArrayList<>();
    FirebaseFirestore db;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        db = FirebaseFirestore.getInstance();
        toolbar = findViewById(R.id.toolbar);
        rcvNotifications = findViewById(R.id.rcvNotifications);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        notificationAdapter = new NotificationAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvNotifications.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcvNotifications.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        rcvNotifications.addItemDecoration(dividerItemDecoration);

        if(mAuth.getCurrentUser() != null){
            uid = mAuth.getUid();
        }

        db.collection("users/" + uid + "/notifications")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w("Notification Activity", "listen:error", e);
                            return;
                        }

                        for (DocumentChange dc : snapshots.getDocumentChanges()) {
                            DocumentSnapshot doc = dc.getDocument();

                            Timestamp timestamp = (Timestamp) doc.get("timestamp");
                            Date date = timestamp.toDate();

                            switch (dc.getType()) {
                                case ADDED:
                                    dateList.add(date);
                                    break;
                            }
                        }
                        notificationAdapter.notifyDataSetChanged();
                        notificationAdapter.setDate(dateList);
                        rcvNotifications.setAdapter(notificationAdapter);
                    }
                });

    }
}