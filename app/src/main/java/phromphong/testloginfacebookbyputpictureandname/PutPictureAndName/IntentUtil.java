package phromphong.testloginfacebookbyputpictureandname.PutPictureAndName;

import android.app.Activity;
import android.content.Intent;

import com.github.mikephil.charting.charts.*;

import phromphong.testloginfacebookbyputpictureandname.PutPictureAndName.AccessTokenActivity;

/**
 * Created by phrompongkhagtes on 5/1/2017 AD.
 */

public class IntentUtil {

    private Activity activity;

    // constructor
    public IntentUtil(Activity activity) {
        this.activity = activity;
    }

    public void showAccessToken() {
        Intent i = new Intent(activity, AccessTokenActivity.class);
        activity.startActivity(i);
    }
    public void showPieChart(){
        Intent i = new Intent(activity,PieChart.class);
        activity.startActivity(i);
    }
    public void showBarChart(){
        Intent i = new Intent(activity,BarChart.class);
        activity.startActivity(i);
    }
}
