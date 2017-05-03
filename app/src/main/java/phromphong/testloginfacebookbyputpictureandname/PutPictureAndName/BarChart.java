package phromphong.testloginfacebookbyputpictureandname.PutPictureAndName;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;



import java.util.ArrayList;

import phromphong.testloginfacebookbyputpictureandname.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BarChart extends AppCompatActivity {

    private OPPMSService service;
    private com.github.mikephil.charting.charts.PieChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        final com.github.mikephil.charting.charts.BarChart chart = (com.github.mikephil.charting.charts.BarChart)findViewById(R.id.bar_chart);

        final ArrayList<Student> listStudent = Student.getSampleStudentData(12);
        final ArrayList<BarEntry> entries = new ArrayList<>();
        final float[] index = {0};

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/SMEs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);

        service.getBarChart().enqueue(new Callback<OPPMSDAO>() {
            @Override
            public void onResponse(Call<OPPMSDAO> call, Response<OPPMSDAO> response) {
                if(response.isSuccessful()) {
                    //Log.d("RESPONSE", response.body().details.creator);

                    for (int i=0 ; i < response.body().detail_BarChart.size();i++) {

                      /*  TextView tvName = (TextView)findViewById(R.id.tvBarchart);
                        tvName.setText(response.body().details.get(i).January);*/

                        entries.add(new BarEntry(index[0],response.body().detail_BarChart.get(i).January));
                        index[0]++;

                        BarDataSet dataset = new BarDataSet(entries,"สวัสดีชาวโลก");
                        dataset.setValueTextSize(0);
                        dataset.setColors(ColorTemplate.COLORFUL_COLORS);//x

                        final ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
                        dataSets.add(dataset);//x

                        BarData data = new BarData(dataSets);
                        chart.setData(data);


                        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
                        chart.getXAxis().setLabelRotationAngle(90);

                        final XAxis xAxis = chart.getXAxis();
                        xAxis.setTextSize(12);
                        xAxis.setCenterAxisLabels(true);
                        xAxis.setValueFormatter(new DefaultAxisValueFormatter(1) {
                            @Override
                            public String getFormattedValue(float value, AxisBase axis) {
                                Log.d("benznest", "value = " + value);
                                if (value < 0 || value >= listStudent.size()) {
                                    return "";
                                }
                                return listStudent.get((int) value).getName();
                            }

                            @Override
                            public int getDecimalDigits() {
                                return 0;
                            }
                        });



                    }





                }
            }

            @Override
            public void onFailure(Call<OPPMSDAO> call, Throwable t) {

            }
        });











    }


    }


