package com.app.laptoplisttest.presentation.activity;

import com.app.laptoplisttest.R;
import com.app.laptoplisttest.databinding.ActivityLaptopBinding;
import com.app.laptoplisttest.presentation.fragment.LaptopFragment;
import com.jappy.jappy_core.presentation.BaseFragmentActivity;

/**
 * Created by eucaris on 2/27/18.
 */

public class LaptopActivity extends BaseFragmentActivity<ActivityLaptopBinding> {
    @Override
    protected int getFragmentContainerId() {
        return R.id.tabContainer;
    }

    @Override
    protected void initView() {
        addFragment(new LaptopFragment(),true);

    }

    @Override
    protected void injectDependencies() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_laptop;
    }
}
