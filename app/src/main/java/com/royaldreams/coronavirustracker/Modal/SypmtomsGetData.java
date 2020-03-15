package com.royaldreams.coronavirustracker.Modal;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SypmtomsGetData {

    @SerializedName("warning")
    @Expose
    private String warning;
    @SerializedName("symptom_array")
    @Expose
    private List<SymptomArray> symptomArray = null;

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public List<SymptomArray> getSymptomArray() {
        return symptomArray;
    }

    public void setSymptomArray(List<SymptomArray> symptomArray) {
        this.symptomArray = symptomArray;
    }
}

