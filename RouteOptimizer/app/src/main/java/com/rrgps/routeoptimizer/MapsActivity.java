package com.rrgps.routeoptimizer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.google.android.gms.common.ConnectionResult.NETWORK_ERROR;
import static com.rrgps.routeoptimizer.R.id.map;
import static com.rrgps.routeoptimizer.R.id.navigation_header_container;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener, GoogleMap.OnMapLoadedCallback {

    public DatabaseReference roads;
    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    LatLngBounds currentScreen;
    private int color;
    ArrayList<RoadInfo> roadList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        roads = StartScreenActivity.roads;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Initializing
        roadList = new ArrayList<>();
        /*LatLng pA= new LatLng(23.727461,90.389597);
        LatLng pB = new LatLng(23.721086,90.389157);
        LatLng pC = new LatLng(23.724613,90.395476);
        LatLng pD = new LatLng(23.727736,90.395369);
        LatLng pE = new LatLng(23.732401,90.387076);
        LatLng pF = new LatLng(23.726872,90.386314);
        LatLng bA = new LatLng(23.764822,90.388210);
        LatLng bB = new LatLng(23.765600,90.383633);
        LatLng bC = new LatLng(23.765181,90.383407);
        LatLng bD = new LatLng(23.764546,90.388668);
        /*LatLng bE = new LatLng(23.764299,90.370797);
        LatLng bF = new LatLng(23.765085,90.383156);
        LatLng bG = new LatLng(23.758957,90.383843);
        LatLng bH = new LatLng(23.759124,90.389684);
        *//*LatLng sA = new LatLng(23.738961,90.383233);
        LatLng sB = new LatLng(23.737870,90.381045);
        LatLng sC = new LatLng(23.741623,90.382686);
        LatLng sD = new LatLng(23.741613,90.382847);
        LatLng sE = new LatLng(23.739001,90.383534);
        LatLng sF = new LatLng(23.739178,90.388737);
        LatLng sG = new LatLng(23.738991,90.388415);
        LatLng sH = new LatLng(23.738765,90.383630);
        LatLng sI = new LatLng(23.734600,90.384551);
        LatLng sJ = new LatLng(23.734570,90.384391);
        /*LatLng cA = new LatLng(23.723951,90.400357);
        LatLng cB = new LatLng(23.724619,90.395508);
        LatLng cC = new LatLng(23.727644,90.400389);
        LatLng cD = new LatLng(23.723293,90.405464);
        LatLng cE = new LatLng(23.720258,90.398383);
        */
        /*roadList.add(new RoadInfo(pA,pB,100));
        roadList.add(new RoadInfo(pA,pC,1200));
        roadList.add(new RoadInfo(pA,pD,700));
        roadList.add(new RoadInfo(pA,pE,400));
        roadList.add(new RoadInfo(pA,pF,500));
        roadList.add(new RoadInfo(bA,bB,1500));
        roadList.add(new RoadInfo(bC,bD,300));*/

        /*roadList.add(new RoadInfo(bE,bF,700));
        roadList.add(new RoadInfo(bF,bG,1200));
        roadList.add(new RoadInfo(bG,bH,400));
        */
        /*roadList.add(new RoadInfo(sA,sB, 550));
        roadList.add(new RoadInfo(sA,sC, 1280));
        roadList.add(new RoadInfo(sD,sE, 900));
        roadList.add(new RoadInfo(sE,sF, 120));
        roadList.add(new RoadInfo(sG,sH, 480));
        roadList.add(new RoadInfo(sH,sI, 300));
        roadList.add(new RoadInfo(sJ,sA, 730));*/
        /*roadList.add(new RoadInfo(cA,cB, 120));
        roadList.add(new RoadInfo(cA,cC, 230));
        roadList.add(new RoadInfo(cA,cC, 560));
        roadList.add(new RoadInfo(cA,cD, 1200));
        roadList.add(new RoadInfo(cA,cE, 700));
        roadList.add(new RoadInfo(cC,cA, 1500));
        roadList.add(new RoadInfo(cD,cA, 300));*/


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onStart() {
        super.onStart();
        roads.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                roadList.clear();
                for (DataSnapshot roads : dataSnapshot.getChildren()) {
                    roadList.add(roads.getValue(RoadInfo.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
        colorRoads(getRoadList());
        googleMap.setOnMapLoadedCallback(this);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener(){
            @Override
            public boolean onMyLocationButtonClick()
            {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.title("You are here");
                markerOptions.position(mCurrLocationMarker.getPosition());
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
                mCurrLocationMarker = mMap.addMarker(markerOptions);
                currentScreen = mMap.getProjection().getVisibleRegion().latLngBounds;
                colorRoads(getRoadList());
                return false;
            }
        });
        mMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                currentScreen = mMap.getProjection().getVisibleRegion().latLngBounds;
                colorRoads(getRoadList());
            }
        });
    }

    //getCurrentLocation
    //getUpperLeft
    //getLowerRight

    //RoadsBetweenThesePoints
    public ArrayList<RoadInfo> getRoadList() {
        //should return those that current screen contains
        return roadList;
    }

    //Color the Roads
    public void colorRoads(ArrayList<RoadInfo> roadList) {
        for(int i = 0; i < roadList.size(); i++)
        {
            LatLng origin = roadList.get(i).getStart() ;
            LatLng dest = roadList.get(i).getEnd();
            if (roadList.get(i).getWeight() < 500) {
                    color = 1; //green

                } else if (roadList.get(i).getWeight() < 1000) {
                    color = 2; //yellow

                } else {
                    color = 3; //red
                }

                // Getting URL to the Google Directions API
                URLMethods urlMethods = new URLMethods();
                String url = urlMethods.getUrl(origin, dest);
                Log.d("onMapClick", url);
                FetchURL fetchUrl = new FetchURL(color, mMap);

                // Start downloading json data from Google Directions API
                fetchUrl.execute(url);
        }
    }

    
    //searches user provided location
    public void Search(View view)
    {
        EditText loc = (EditText)findViewById(R.id.Text);
        String location = loc.getText().toString();
        List<Address> addressList = null;
        if(!location.equals(""))
        {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location,1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(addressList!=null) {
            Address add = addressList.get(0);
            LatLng latLng = new LatLng(add.getLatitude(), add.getLongitude());
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(latLng).title("You searched for " + location));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
            currentScreen = mMap.getProjection().getVisibleRegion().latLngBounds;
            colorRoads(getRoadList());
        }
    }


    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    @Override
    public void onConnectionSuspended(int i) {

    }



    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("You are here");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        currentScreen = mMap.getProjection().getVisibleRegion().latLngBounds;
        colorRoads(getRoadList());

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }



    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    @Override
    public void onMapLoaded() {
        currentScreen = mMap.getProjection().getVisibleRegion().latLngBounds;
        colorRoads(roadList);
    }
}