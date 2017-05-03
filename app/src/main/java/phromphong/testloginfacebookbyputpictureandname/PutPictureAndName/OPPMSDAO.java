package phromphong.testloginfacebookbyputpictureandname.PutPictureAndName;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by phrompongkhagtes on 5/1/2017 AD.
 */

public class OPPMSDAO {
    @SerializedName("details")
    public Details detail;

    @SerializedName("graphData")
    public ArrayList<GraphData> graphData;

    @SerializedName("detail_BarChart")
    public ArrayList<Details> detail_BarChart;


}
