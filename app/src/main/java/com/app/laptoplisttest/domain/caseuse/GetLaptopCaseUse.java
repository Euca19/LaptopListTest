package com.app.laptoplisttest.domain.caseuse;

import com.app.laptoplisttest.data.repository.mapper.LaptopRepository;
import com.app.laptoplisttest.domain.model.LaptopList;
import com.jappy.jappy_core.domian.usecase.UseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by eucaris on 2/27/18.
 */

public class GetLaptopCaseUse extends UseCase<List<LaptopList>> {

    private final LaptopRepository laptopRepository;

    @Inject public GetLaptopCaseUse(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    protected Observable<List<LaptopList>> createObservableUseCase() {
        return laptopRepository.getLaptopList();
    }
}
