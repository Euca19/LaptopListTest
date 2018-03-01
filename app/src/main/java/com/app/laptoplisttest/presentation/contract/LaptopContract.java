package com.app.laptoplisttest.presentation.contract;

import com.app.laptoplisttest.domain.model.LaptopList;
import com.jappy.jappy_core.presentation.IProgressView;
import com.jappy.jappy_core.presentation.presenter.BaseViewPresenter;

import java.util.List;

/**
 * Created by eucaris on 2/27/18.
 */

public class LaptopContract {
    public interface View extends IProgressView {
        void showLaptop(List<LaptopList> laptopLists);
        void showProgress(boolean show);
        void showError(boolean show);
        void initToolbar(String tvTitle);


    }
    public interface Presenter extends BaseViewPresenter<View> {
        void initialize(View view);
        void cancelObservable();



    }
}
