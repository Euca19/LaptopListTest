package com.app.laptoplisttest.data.repository.mapper;

import com.app.laptoplisttest.data.entity.LaptopElementEntity;
import com.app.laptoplisttest.data.remote.response.LaptopResponse;
import com.app.laptoplisttest.domain.model.LaptopList;
import com.jappy.jappy_core.data.repository.Mapper;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by eucaris on 2/27/18.
 */

public class LaptopListToDomainMapper extends Mapper<LaptopElementEntity, LaptopList> {

    private final LaptopElementToDomainMapper mapper;

    @Inject public LaptopListToDomainMapper(LaptopElementToDomainMapper mapper) {this.mapper = mapper;}

    @Override
    public LaptopList map(LaptopElementEntity value) {
        LaptopList result = new LaptopList();
        result.title = value.title;
        result.description= value.description;
        result.image = value.image;

       /* if (result.laptops != null)
            result.laptops=mapper.map(value.laptops);*/
       // else result.laptops= new ArrayList<>();
        return result;
    }

    @Override
    public LaptopElementEntity reverseMap(LaptopList value) {
        throw new UnsupportedOperationException();
    }
}
