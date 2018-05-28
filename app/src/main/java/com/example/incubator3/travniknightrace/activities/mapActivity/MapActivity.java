package com.example.incubator3.travniknightrace.activities.mapActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.incubator3.travniknightrace.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final LatLng POINT_A = new LatLng(44.226428, 17.669983);

    private static final LatLng POINT_B = new LatLng(44.2282611, 17.6394513);

    private List<LatLng> bangaloreRoute;

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        createRoute();
    }


    private void createRoute() {
        if (bangaloreRoute == null) {
            bangaloreRoute = new ArrayList<>();
        } else {
            bangaloreRoute.clear();
        }

        bangaloreRoute.add(new LatLng(44.226080, 17.665832));
        bangaloreRoute.add(new LatLng(44.226088, 17.666873));
        bangaloreRoute.add(new LatLng(44.226109, 17.668010));
        bangaloreRoute.add(new LatLng(44.226152, 17.668670));
        bangaloreRoute.add(new LatLng(44.226217, 17.669115));
        bangaloreRoute.add(new LatLng(44.226882, 17.669024));
        bangaloreRoute.add(new LatLng(44.227067, 17.668268));
        bangaloreRoute.add(new LatLng(44.227244, 17.667506));
        bangaloreRoute.add(new LatLng(44.227256, 17.666519));
        bangaloreRoute.add(new LatLng(44.227178, 17.665515));
        bangaloreRoute.add(new LatLng(44.227040, 17.664174));
        bangaloreRoute.add(new LatLng(44.227041, 17.663209));
        bangaloreRoute.add(new LatLng(44.227063, 17.662903));
        bangaloreRoute.add(new LatLng(44.227292, 17.661864));

        bangaloreRoute.add(new LatLng(44.227766, 17.660312));
        bangaloreRoute.add(new LatLng(44.227831, 17.659454));
        bangaloreRoute.add(new LatLng(44.227760, 17.658480));
        bangaloreRoute.add(new LatLng(44.228114, 17.656932));
        bangaloreRoute.add(new LatLng(44.228114, 17.656932));
        bangaloreRoute.add(new LatLng(44.228114, 17.656932));
//        bangaloreRoute.add(new LatLng(44.228114, 17.656932));
        bangaloreRoute.add(new LatLng(44.227384, 17.656548));
        bangaloreRoute.add(new LatLng(44.227107, 17.656425));
        bangaloreRoute.add(new LatLng(44.226961, 17.656307));
        bangaloreRoute.add(new LatLng(44.226673, 17.655572));
        bangaloreRoute.add(new LatLng(44.226327, 17.654150));
        bangaloreRoute.add(new LatLng(44.226385, 17.653619));
        bangaloreRoute.add(new LatLng(44.226370, 17.651892));
        bangaloreRoute.add(new LatLng(44.226252, 17.649600));
        bangaloreRoute.add(new LatLng(44.226190, 17.647996));
        bangaloreRoute.add(new LatLng(44.226605, 17.646596));
        bangaloreRoute.add(new LatLng(44.226805, 17.646151));
        bangaloreRoute.add(new LatLng(44.226913, 17.646022));
        bangaloreRoute.add(new LatLng(44.226909, 17.645791));
        bangaloreRoute.add(new LatLng(44.226794, 17.645721));
        bangaloreRoute.add(new LatLng(44.226540, 17.645388));
        bangaloreRoute.add(new LatLng(44.226452, 17.645238));
        bangaloreRoute.add(new LatLng(44.226452, 17.645238));
        bangaloreRoute.add(new LatLng(44.226452, 17.645238));
        bangaloreRoute.add(new LatLng(44.226813, 17.644525));
        bangaloreRoute.add(new LatLng(44.227466, 17.643189));
        bangaloreRoute.add(new LatLng(44.227873, 17.642341));
        bangaloreRoute.add(new LatLng(44.227969, 17.641880));
        bangaloreRoute.add(new LatLng(44.228004, 17.6412584));
        bangaloreRoute.add(new LatLng(44.228104, 17.640689));
        bangaloreRoute.add(new LatLng(44.228140, 17.640633));
        bangaloreRoute.add(new LatLng(44.228127, 17.640571));
        bangaloreRoute.add(new LatLng(44.228083, 17.640625));
        bangaloreRoute.add(new LatLng(44.227989, 17.641089));
        bangaloreRoute.add(new LatLng(44.227956, 17.641261));
        bangaloreRoute.add(new LatLng(44.227933, 17.641822));
        bangaloreRoute.add(new LatLng(44.227927, 17.641978));
        bangaloreRoute.add(new LatLng(44.227894, 17.642155));
        bangaloreRoute.add(new LatLng(44.227852, 17.642300));
        bangaloreRoute.add(new LatLng(44.227650, 17.642694));
        bangaloreRoute.add(new LatLng(44.227433, 17.643155));
        bangaloreRoute.add(new LatLng(44.227154, 17.643716));
        bangaloreRoute.add(new LatLng(44.226791, 17.644478));
        bangaloreRoute.add(new LatLng(44.226409, 17.645229));
        bangaloreRoute.add(new LatLng(44.226409, 17.645229));
        bangaloreRoute.add(new LatLng(44.226759, 17.645728));
        bangaloreRoute.add(new LatLng(44.226717, 17.645886));
        bangaloreRoute.add(new LatLng(44.226727, 17.646068));
        bangaloreRoute.add(new LatLng(44.226421, 17.646883));
        bangaloreRoute.add(new LatLng(44.226219, 17.647409));
        bangaloreRoute.add(new LatLng(44.226146, 17.647726));
        bangaloreRoute.add(new LatLng(44.226140, 17.648362));
        bangaloreRoute.add(new LatLng(44.226180, 17.649499));
        bangaloreRoute.add(new LatLng(44.226263, 17.651100));
        bangaloreRoute.add(new LatLng(44.226332, 17.652224));
        bangaloreRoute.add(new LatLng(44.226334, 17.653080));
        bangaloreRoute.add(new LatLng(44.226344, 17.653549));
        bangaloreRoute.add(new LatLng(44.226263, 17.653823));
        bangaloreRoute.add(new LatLng(44.226048, 17.654258));
        bangaloreRoute.add(new LatLng(44.225833, 17.655103));
        bangaloreRoute.add(new LatLng(44.225789, 17.655583));
        bangaloreRoute.add(new LatLng(44.225929, 17.656170));
        bangaloreRoute.add(new LatLng(44.226163, 17.656953));
        bangaloreRoute.add(new LatLng(44.226221, 17.657259));
        bangaloreRoute.add(new LatLng(44.226231, 17.657616));
        bangaloreRoute.add(new LatLng(44.226089, 17.658077));
        bangaloreRoute.add(new LatLng(44.226049, 17.658613));
        bangaloreRoute.add(new LatLng(44.226168, 17.659144));
        bangaloreRoute.add(new LatLng(44.226381, 17.659807));
        bangaloreRoute.add(new LatLng(44.226512, 17.660290));
        bangaloreRoute.add(new LatLng(44.226554, 17.660805));
        bangaloreRoute.add(new LatLng(44.226560, 17.661328));
        bangaloreRoute.add(new LatLng(44.226564, 17.661771));
        bangaloreRoute.add(new LatLng(44.226566, 17.662525));
        bangaloreRoute.add(new LatLng(44.226473, 17.663053));
        bangaloreRoute.add(new LatLng(44.226356, 17.663455));
        bangaloreRoute.add(new LatLng(44.226250, 17.664152));
        bangaloreRoute.add(new LatLng(44.226129, 17.664782));
        bangaloreRoute.add(new LatLng(44.226080, 17.665832));




//        bangaloreRoute.add(new LatLng(12.92990737159723, 77.6218843460083));
//        bangaloreRoute.add(new LatLng(12.9337554448302, 77.62342929840088));
//        bangaloreRoute.add(new LatLng(12.9346338010532, 77.62390136718749));
//        bangaloreRoute.add(new LatLng(12.935177543831987, 77.62437343597412));
//        bangaloreRoute.add(new LatLng(12.934487408564122, 77.62561798095703));
//        bangaloreRoute.add(new LatLng(12.934320102757125, 77.62589693069457));
//        bangaloreRoute.add(new LatLng(12.933860011209374, 77.62572526931763));
//        bangaloreRoute.add(new LatLng(12.934550148212828, 77.62460947036743));
//        bangaloreRoute.add(new LatLng(12.933379005502244, 77.62398719787598));
//        bangaloreRoute.add(new LatLng(12.933065305628435, 77.62390136718749));
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(POINT_A);
                builder.include(POINT_B);
                LatLngBounds bounds = builder.build();
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 200);

                mMap.moveCamera(cu);
                mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);

                startAnim();
            }
        });
    }

    private void startAnim(){
        if(mMap != null) {
            MapAnimator.getInstance().animateRoute(mMap, bangaloreRoute);
        } else {
            Toast.makeText(getApplicationContext(), "Map not ready", Toast.LENGTH_LONG).show();
        }
    }

    public void resetAnimation(View view){
        startAnim();
    }

}
