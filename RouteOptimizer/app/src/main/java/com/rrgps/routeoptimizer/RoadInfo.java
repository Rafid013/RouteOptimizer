package com.rrgps.routeoptimizer;

/**
 * Created by Toufik on 6/2/2017.
 */

import com.google.android.gms.maps.model.LatLng;


public class RoadInfo {
    //LatLng start;
    //LatLng end;
    double startLatitude;
    double startLongitude;
    double endLatitude;
    double endLongitude;

    int weight;
    RoadInfo() {
        startLatitude = startLongitude = endLatitude = endLongitude = -1;
    }
    RoadInfo(double lat1, double lng1, double lat2, double lng2,int weight)
    {
        //start = new LatLng(lat1,lng1);
        //end = new LatLng(lat2,lng2);
        startLatitude = lat1;
        startLongitude = lng1;
        endLatitude = lat2;
        endLongitude = lng2;
        this.weight = weight;
    }
    RoadInfo(LatLng start,LatLng end,int weight)
    {
        startLatitude = start.latitude;
        startLongitude = start.longitude;
        endLatitude = end.latitude;
        endLongitude = end.longitude;
        this.weight=weight;
    }
    LatLng getStart()
    {
        return new LatLng(startLatitude, startLongitude);
    }
    LatLng getEnd()
    {
        return new LatLng(endLatitude, endLongitude);
    }
    public int getWeight()
    {
        return weight;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }
}
