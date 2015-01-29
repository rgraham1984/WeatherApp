package com.example.rgraham.weatherapp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.DecimalFormat;

/**
 * Created by rgraham on 1/19/15.
 */
public class ParseXML extends DefaultHandler {

    XMLDataCollected info = new XMLDataCollected();

    public String getInformation() {
        return info.dataToString();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (localName.equals("city")) {
            String city = attributes.getValue("name");
            info.setCity(city);
        } else if (localName.equals("temperature")) {
            String t = attributes.getValue("value");
            double temp2 = Double.parseDouble(t);
            double temp = (temp2 - 273.15) * 1.8000 + 32.00;
            DecimalFormat df = new DecimalFormat("#.##");
            double temp3 = Double.parseDouble(df.format(temp));
            info.setTemp(temp3);
        } else if (localName.equals("coord")) {
            String lon = attributes.getValue("lon");
            info.setLon(lon);
        }
        if (localName.equals("coord")) {
            String lat = attributes.getValue("lat");
            info.setLat(lat);
        } else if (localName.equals("sun")) {
            String rise = attributes.getValue("rise");
            info.setRise(rise);
        }
        if (localName.equals("sun")) {
            String set = attributes.getValue("set");
            info.setSunset(set);
        } else if (localName.equals("humidity")) {
            String hum = attributes.getValue("value");
            info.setHumidity(hum);
        }
        if (localName.equals("humidity")) {
            String humidityUnit = attributes.getValue("unit");
            info.setHumUnit(humidityUnit);
        } else if (localName.equals("pressure")) {
            String pressure = attributes.getValue("value");
            info.setPressure(pressure);
        }
        if (localName.equals("pressure")) {
            String pressureUnit = attributes.getValue("unit");
            info.setPressUnit(pressureUnit);
        } else if (localName.equals("speed")) {
            String windSpeed = attributes.getValue("value");
            info.setWindSpeed(windSpeed);
        }
        if (localName.equals("speed")) {
            String windName = attributes.getValue("name");
            info.setWindName(windName);
        } else if (localName.equals("direction")) {
            String windDirection = attributes.getValue("value");
            info.setWindDirection(windDirection);
        }
        if (localName.equals("direction")) {
            String windDirectionName = attributes.getValue("name");
            info.setWindDirectionName(windDirectionName);
        } else if (localName.equals("clouds")) {
            String clouds = attributes.getValue("name");
            info.setClouds(clouds);
        } else if (localName.equals("precipitation")) {
            String precip = attributes.getValue("mode");
            info.setPrecip(precip);
        } else if (localName.equals("weather")) {
            String skyDescription = attributes.getValue("value");
            info.setSkyDescription(skyDescription);
        } else if (localName.equals("weather")) {
            String weatherIcon = attributes.getValue("icon");
            info.setWeatherIcon(weatherIcon);
        }
    }

}
