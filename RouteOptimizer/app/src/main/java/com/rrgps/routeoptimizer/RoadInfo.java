package com.rrgps.routeoptimizer;

/**
 * Created by Toufik on 6/2/2017.
 */

import com.google.android.gms.maps.model.LatLng;


public class RoadInfo {
    LatLng start;
    LatLng end;
    int weight;
    /*RoadInfo(double lat1, double lng1, double lat2, double lng2,int weight)
    {
        start = new LatLng(lat1,lng1);
        end = new LatLng(lat2,lng2);
        this.weight = weight;
    }*/
    RoadInfo(LatLng start,LatLng end,int weight)
    {
        this.start = start;
        this.end=end;
        this.weight=weight;
    }
    LatLng getStart()
    {
        return start;
    }
    LatLng getEnd()
    {
        return end;
    }
    int getWeight()
    {
        return weight;
    }
}
