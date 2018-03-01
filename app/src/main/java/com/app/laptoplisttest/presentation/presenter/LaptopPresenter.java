package com.app.laptoplisttest.presentation.presenter;


import com.app.laptoplisttest.domain.caseuse.GetLaptopCaseUse;
import com.app.laptoplisttest.domain.model.LaptopList;
import com.app.laptoplisttest.presentation.contract.LaptopContract;
import com.jappy.jappy_core.domian.usecase.UseCaseObserver;

import java.util.List;
import javax.inject.Inject;

/**
 * Created by eucaris on 2/27/18.
 */

public class LaptopPresenter  implements LaptopContract.Presenter{
    private GetLaptopCaseUse getLaptopCaseUse;
    private LaptopContract.View view;


    @Inject public LaptopPresenter(GetLaptopCaseUse getLaptopCaseUse) {this.getLaptopCaseUse = getLaptopCaseUse;}

    @Override
    public void initialize(LaptopContract.View view) {
        this.view = view;
        view.initToolbar("Laptop");
        view.showProgress(true);
        requestLaptop();
    }

    @Override
    public void cancelObservable() {
        getLaptopCaseUse.dispose();
    }



    private void requestLaptop() {
        view.showProgress(true);
            getLaptopCaseUse.execute(new UseCaseObserver<List<LaptopList>>() {
                @Override
                public void onNext(List<LaptopList> value) {
                    view.showLaptop(value);
                    view.showProgress(false);
                    super.onNext(value);
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    view.showProgress(false);
                    view.showError(true);
                }
            });

        }

}
