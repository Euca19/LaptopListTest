package com.app.laptoplisttest.di.component;

import android.support.v4.app.Fragment;

/**
 * Created by eucaris on 2/27/18.
 */

public interface FragmentComponent <T extends Fragment>{
    /**
     * Indica que T requiere inyección desde este componente
     * @param target T
     */
    void inject(T target);
}
