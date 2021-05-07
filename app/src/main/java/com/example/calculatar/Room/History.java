package com.example.calculatar.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.security.Key;

@Entity
public class History {
    @PrimaryKey(autoGenerate = true)
    private int resultId;
    private String result;
    private String resultFinal;
    private String numDetails;

    public History() {
    }

    public History(int resultId, String result, String resultFinal, String numDetails) {
        this.resultId = resultId;
        this.result = result;
        this.resultFinal = resultFinal;
        this.numDetails = numDetails;
    }

    public History(String result, String numDetails, String resultFinal) {
        this.result = result;
        this.numDetails = numDetails;
        this.resultFinal = resultFinal;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNumDetails() {
        return numDetails;
    }

    public void setNumDetails(String numDetails) {
        this.numDetails = numDetails;
    }

    public String getResultFinal() {
        return resultFinal;
    }

    public void setResultFinal(String resultFinal) {
        this.resultFinal = resultFinal;
    }
}
