package phromphong.testloginfacebookbyputpictureandname.PutPictureAndName;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import phromphong.testloginfacebookbyputpictureandname.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PieChart extends AppCompatActivity {
    private OPPMSService service;
    private com.github.mikephil.charting.charts.PieChart mypiechart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        mypiechart = (com.github.mikephil.charting.charts.PieChart)findViewById(R.id.chart);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dekdee.buu.ac.th/~56160140/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);
        service.getOPPMSData().enqueue(new Callback<OPPMSDAO>() {
            @Override
            public void onResponse(Call<OPPMSDAO> call, Response<OPPMSDAO> response) {


                if(response.isSuccessful()) {


                    Log.d("RESPONSE", String.valueOf(response.body().cat));
                    Log.d("RESPONSE Dog", String.valueOf(response.body().dog));
                    String arr[] = {String.valueOf(response.body().cat),String.valueOf(response.body().dog),String.valueOf(response.body().rat),String.valueOf(response.body().bird),String.valueOf(response.body().codomo_dragon)};
                     //Log.d("RESPONSE", response.body().details.creator);
                    ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
                    for (int i = 0; i < arr.length; i++) {
                        Float mystring = Float.valueOf(arr[i]);

                        entries.add(new PieEntry(mystring));

                    }





                    PieDataSet pieDataSet = new PieDataSet(entries,"####");
                    pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                    PieData pieData = new PieData(pieDataSet);
                    mypiechart.setData(pieData);
                }else{
                    Log.d("RESPONSE", "service error");
                }

            }

            @Override
            public void onFailure(Call<OPPMSDAO> call, Throwable t) {
                Log.d("RESPONSE", t.getMessage());
            }
        });
    }
}
