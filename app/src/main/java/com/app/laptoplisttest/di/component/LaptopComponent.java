package com.app.laptoplisttest.di.component;

import com.app.laptoplisttest.di.module.LaptopModule;
import com.app.laptoplisttest.presentation.fragment.LaptopFragment;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by eucaris on 2/27/18.
 */

@Singleton
@Component (modules = {LaptopModule.class})
public interface LaptopComponent extends FragmentComponent<LaptopFragment> {
}
