package com.rrgps.routeoptimizer;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by rafid on 2/6/2017.
 */





public class FetchURL extends AsyncTask<String, Void, String> {


        private int color;
        private GoogleMap mMap;

        FetchURL(int color, GoogleMap mMap) {
            this.color = color;
            this.mMap = mMap;
        }

        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                URLMethods urlMethods = new URLMethods();
                data = urlMethods.downloadUrl(url[0]);
                Log.d("Background Task data", data.toString());
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask(color, mMap);

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
}
