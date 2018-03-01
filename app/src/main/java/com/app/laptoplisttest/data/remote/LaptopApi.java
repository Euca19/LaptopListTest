package com.app.laptoplisttest.data.remote;


import com.app.laptoplisttest.data.entity.LaptopElementEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by eucaris on 2/27/18.
 */

public interface LaptopApi {
    @GET("list")
    Observable<List<LaptopElementEntity>> getLaptopLis();

}
