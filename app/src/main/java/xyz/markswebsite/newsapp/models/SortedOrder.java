package xyz.markswebsite.newsapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mark on 20/08/2017.
 */

public enum SortedOrder {
    @SerializedName("top")
    TOP ("Top"),
    @SerializedName("latest")
    LATEST ("Latest"),
    @SerializedName("popular")
    POPULAR ("Popular");

    public final String printableName;

    SortedOrder(String printableName){
        this.printableName = printableName;
    }

}
