package com.example.lightfuture.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lightfuture.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.Console;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            for (ModelListItem i:TipaDatabase.ItsDataList){
                LatLng mark = new LatLng(i.coordinate1, i.coordinate2);
                googleMap.addMarker(new MarkerOptions().position(mark)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_problem_map_2)));

                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        for(ModelListItem j:TipaDatabase.ItsDataList){
                            System.out.println();
                            if(j.coordinate1==marker.getPosition().latitude && j.coordinate2==marker.getPosition().longitude) {
                                startBottomSheetDialog(j);
                                break;
                            }
                        }
                        return false;
                    }
                });
            }
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(54.70278797742691, 20.508356268103572),10));
        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    public void startBottomSheetDialog(ModelListItem item){
        BottomSheetDialog dialog = new BottomSheetDialog(getContext());
        View view = getLayoutInflater().inflate(R.layout.item_map_dialog_bottom_sheet_fragment, null);
        TextView NameTextView, LocationTextView;
        NameTextView = view.findViewById(R.id.nambet_bottom_sheet);
        LocationTextView = view.findViewById(R.id.location_bottom_sheet);
        NameTextView.setText(item.number);
        LocationTextView.setText(item.location);
        dialog.setContentView(view);
        dialog.show();


    }
}