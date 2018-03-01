package com.app.laptoplisttest.data.repository.mapper;
import android.util.Log;

import com.app.laptoplisttest.data.entity.LaptopElementEntity;
import com.app.laptoplisttest.data.remote.LaptopApi;
import com.app.laptoplisttest.domain.model.LaptopList;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by eucaris on 2/27/18.
 */

public class LaptopRepositoryImp implements LaptopRepository {

    LaptopApi apiService;
    LaptopListToDomainMapper mapper;

    @Inject public LaptopRepositoryImp(LaptopApi apiService, LaptopListToDomainMapper mapper) {
        this.apiService = apiService;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<LaptopList>> getLaptopList() {

        return apiService.getLaptopLis().map(new Function<List<LaptopElementEntity>, List<LaptopList>>() {
            @Override
            public List<LaptopList> apply(List<LaptopElementEntity> laptopElementEntities) throws Exception {
                Gson a =new  Gson ();
                Log.e("LOG",a.toJson(laptopElementEntities));
                return mapper.map(laptopElementEntities);
            }
        });



    }


}
