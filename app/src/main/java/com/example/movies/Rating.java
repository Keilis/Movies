package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Rating implements Serializable {
    @SerializedName("kp")
    private double kp;

    public Rating(double kp) {
        this.kp = kp;
    }

    public double getKp() {
        DecimalFormat decimalFormat = new DecimalFormat( "#.0" );
        double result = Double.parseDouble(decimalFormat.format(kp));
        return result;
    }

    @Override
    public String toString() {
        return "Raiting{" +
                "kp='" + kp + '\'' +
                '}';
    }
}
