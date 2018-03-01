package com.app.laptoplisttest.di.module;

import com.app.laptoplisttest.data.remote.ApiServiceFactory;
import com.app.laptoplisttest.data.remote.LaptopApi;
import com.app.laptoplisttest.data.repository.mapper.LaptopListToDomainMapper;
import com.app.laptoplisttest.data.repository.mapper.LaptopRepository;
import com.app.laptoplisttest.data.repository.mapper.LaptopRepositoryImp;
import com.app.laptoplisttest.domain.caseuse.GetLaptopCaseUse;
import com.app.laptoplisttest.presentation.adapter.LaptopAdapter;
import com.app.laptoplisttest.presentation.contract.LaptopContract;
import com.app.laptoplisttest.presentation.presenter.LaptopPresenter;
import com.app.laptoplisttest.utlis.Constant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by eucaris on 2/27/18.
 */

@Module
public class LaptopModule {
    @Provides
    OkHttpClient provideOkHttpClient(){return new OkHttpClient();}

    @Provides
    LaptopRepository provideRepository(LaptopApi apiService, LaptopListToDomainMapper laptopListToDomainMapper ) {
        return new LaptopRepositoryImp(apiService,laptopListToDomainMapper) {
        };
    }

    @Provides
    LaptopContract.Presenter providePresenter(GetLaptopCaseUse getLaptopCaseUse) {
        return new LaptopPresenter(getLaptopCaseUse);


    }

    @Provides
    @Singleton
    public LaptopAdapter provideAdapter() {
        return new LaptopAdapter();
    }


    @Provides @Singleton
    LaptopApi provideApiService(OkHttpClient okHttpClient) {
        return ApiServiceFactory.build(okHttpClient, LaptopApi.class, Constant.BASE_URL);
    }


}
