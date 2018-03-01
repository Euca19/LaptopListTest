package com.app.laptoplisttest.presentation.fragment;


import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.app.laptoplisttest.R;
import com.app.laptoplisttest.databinding.FragmentLaptopBinding;
import com.app.laptoplisttest.di.component.DaggerLaptopComponent;
import com.app.laptoplisttest.domain.model.LaptopList;
import com.app.laptoplisttest.presentation.adapter.LaptopAdapter;
import com.app.laptoplisttest.presentation.contract.LaptopContract;
import com.jappy.jappy_core.presentation.BaseStackFragment;
import com.jappy.jappy_core.presentation.OnItemClickListener;

import java.util.List;
import javax.inject.Inject;

/**
 * Created by eucaris on 2/27/18.
 */

public class LaptopFragment  extends BaseStackFragment<FragmentLaptopBinding> implements LaptopContract.View {
    @Inject LaptopContract.Presenter presenter;
    @Inject LaptopAdapter laptopAdapter;

    @Override
    protected int getLayoutId() {return R.layout.fragment_laptop;}

    @Override
    protected int getNavigationContainer() {return R.id.stackContainer;}

    @Override
    protected void initView() {
        presenter.initialize(this);
        binder.includedToolbar.tvTitlle.setText(getString(R.string.app_title));

    }

    @Override
    protected void injectDependencies() {
        DaggerLaptopComponent.builder().build().inject(this);

    }

    @Override
    public void showLaptop(List<LaptopList> laptopLists) {
        laptopAdapter.initializeList(laptopLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        binder.rvLaptop.setLayoutManager(mLayoutManager);
        binder.rvLaptop.setItemAnimator(new DefaultItemAnimator());

        laptopAdapter.setOnAddToListListener(new OnItemClickListener<LaptopList>() {
            @Override
            public void onItemClick(int adapterPosition, LaptopList item) {
                if(item!=null){
                    getBaseStackFragment().addFragmentToStack(LaptopDetailFragment.newInstance(item));
                }

            }
        });
        binder.rvLaptop.setAdapter(laptopAdapter);
    }


    @Override
    public void showError(boolean show) {
        binder.errorView.setVisibility(show? View.VISIBLE:View.GONE);
    }

    @Override
    public void showProgress(boolean show) {
        binder.progressView.setVisibility(show? View.VISIBLE:View.GONE);
    }


    @Override
    public void showMessage(String message) {}

    @Override
    public void initToolbar(String tvTitle) {
        binder.includedToolbar.ivBack.setVisibility(View.GONE);
        binder.includedToolbar.tvTitlle.setText(tvTitle);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.cancelObservable();
    }


}
