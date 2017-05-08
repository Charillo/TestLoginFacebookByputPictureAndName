package phromphong.testloginfacebookbyputpictureandname.PutPictureAndName;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by phrompongkhagtes on 5/1/2017 AD.
 */

public interface OPPMSService {


    @POST("final_service/graph_cycle.php")
    Call<OPPMSDAO> getOPPMSData();


    @POST("application/views/inventory/borrow/Andriod_SMEs/Final_BarChart.php")
    Call<OPPMSDAO> getBarChart(); //รับข้อมูล


}