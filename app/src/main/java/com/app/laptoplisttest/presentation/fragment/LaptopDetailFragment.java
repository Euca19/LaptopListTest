package com.app.laptoplisttest.presentation.fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import com.app.laptoplisttest.R;
import com.app.laptoplisttest.databinding.FragmentDetailLaptopBinding;
import com.app.laptoplisttest.domain.model.LaptopList;
import com.app.laptoplisttest.utlis.CircleTransform;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.jappy.jappy_core.presentation.BaseFragment;

/**
 * Created by eucaris on 2/27/18.
 */

public class LaptopDetailFragment extends BaseFragment<FragmentDetailLaptopBinding> {

    LaptopList laptop;

    public static LaptopDetailFragment newInstance(LaptopList laptop) {
        LaptopDetailFragment fragment = new LaptopDetailFragment();
        fragment.laptop = laptop;
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail_laptop;
    }


    @Override
    protected void initView() {
        iniToolbar();

        Glide.with(getContext())
                .load(laptop.image)
                .placeholder(R.drawable.ic_placeholde)
                .transform(new CircleTransform(getContext()))
                .error(R.drawable.ic_placeholde)
                .priority(Priority.HIGH)
                .into(binder.ivLaptop);


        binder.includedToolbar.tvTitlle.setText(laptop.title);
        binder.tvTitle.setText(laptop.title);
        binder.tvDescription.setText(laptop.description);
        binder.tvDescription.setMovementMethod(new ScrollingMovementMethod());

    }

    private void iniToolbar() {
        binder.includedToolbar.ivBack.setVisibility(View.VISIBLE);
        binder.includedToolbar.tvTitlle.setVisibility(View.VISIBLE);
        binder.includedToolbar.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popBackStack();
            }
        });
    }

    @Override
    protected void injectDependencies() {}


}