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

    @SerializedName("cat")
    public int cat;

    @SerializedName("dog")
    public int dog;

    @SerializedName("rat")
    public int rat;

    @SerializedName("bird")
    public int bird;

    @SerializedName("codomo_dragon")
    public int codomo_dragon;


}
