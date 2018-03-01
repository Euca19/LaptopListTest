package com.app.laptoplisttest.data.repository.mapper;

import com.app.laptoplisttest.data.entity.LaptopElementEntity;
import com.app.laptoplisttest.domain.model.LaptopElement;
import com.jappy.jappy_core.data.repository.Mapper;
import javax.inject.Inject;

/**
 * Created by eucaris on 2/27/18.
 */

public class LaptopElementToDomainMapper extends Mapper<LaptopElementEntity, LaptopElement>{

    @Inject public LaptopElementToDomainMapper() {}

    @Override
    public LaptopElement map(LaptopElementEntity value) {
        LaptopElement result = new LaptopElement();
        result.title        = value.title;
        result.description  = value.description;
        result.image        = value.image;
        return result;
    }

    @Override
    public LaptopElementEntity reverseMap(LaptopElement value) {
         throw new UnsupportedOperationException();
    }
}
