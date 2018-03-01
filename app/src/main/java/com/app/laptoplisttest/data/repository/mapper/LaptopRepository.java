package com.app.laptoplisttest.data.repository.mapper;

import com.app.laptoplisttest.domain.model.LaptopList;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by eucaris on 2/27/18.
 */

public interface LaptopRepository {
    Observable<List<LaptopList>> getLaptopList();

}
