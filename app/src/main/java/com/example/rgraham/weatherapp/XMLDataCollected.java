package com.example.rgraham.weatherapp;

/**
 * Created by rgraham on 1/19/15.
 */
public class XMLDataCollected {

    double temp = 0;
    String city = null;
    String lon = null;
    String lat = null;
    String rise = null;
    String sunSet = null;
    String humidity = null;
    String humidityUnit = null;
    String pressure = null;
    String pressureUnit = null;
    String windSpeed = null;
    String windName = null;
    String windDirection = null;
    String windDirectionName = null;
    String cloud = null;
    String precipitation = null;
    String sky = null;
    String icon = null;


    public void setCity(String c) {
        city = c;
    }

    public void setTemp(double t) {
        temp = t;
    }

    public void setLon(String ln) {
        lon = ln;
    }

    public void setLat(String lnt) {
        lat = lnt;
    }

    public void setRise(String sr) {
        rise = sr;
    }

    public void setSunset(String ss) {
        sunSet = ss;
    }

    public void setHumidity(String h) {
        humidity = h;
    }

    public void setHumUnit(String hunit) {
        humidityUnit = hunit;
    }

    public void setPressure(String p) {
        pressure = p;
    }

    public void setPressUnit(String punit) {
        pressureUnit = punit;
    }

    public void setWindSpeed(String ws) {
        windSpeed = ws;
    }

    public void setWindName(String wn) {
        windName = wn;
    }

    public void setWindDirection(String wd) {
        windDirection = wd;
    }

    public void setWindDirectionName(String wdn) {
        windDirectionName = wdn;
    }

    public void setClouds(String c) {
        cloud = c;
    }

    public void setPrecip(String precip) {
        precipitation = precip;
    }

    public void setSkyDescription(String sd) {
        sky = sd;
    }

    public void setWeatherIcon(String ic) {
        icon = ic;
    }

    public String dataToString() {
        return //"City: " + city + "\n" +
                "Temperature: " + temp + "F \n" +
                        "Humidity: " + humidity + humidityUnit + "\n" +
                        "Pressure: " + pressure + " " + pressureUnit + "\n" +
                        "Wind Speed: " + windDirectionName + "\n" +
                        "Clouds: " + cloud + "\n" +
                        "Precipitation: " + precipitation + "\n" +
                        "Sky: " + sky + "\n" +
                        //"Longitude: "+ lon + "\n" +
                        //"Latitude: " + lat + "\n" +
                        "Sunrise: " + rise + "\n" +
                        "Sunset: " + sunSet + "\n";
        //icon;
    }


}
