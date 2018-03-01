package com.app.laptoplisttest.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.app.laptoplisttest.R;
import com.app.laptoplisttest.databinding.ItemLaptopBinding;
import com.app.laptoplisttest.domain.model.LaptopList;
import com.app.laptoplisttest.utlis.CircleTransform;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.jappy.jappy_core.presentation.OnItemClickListener;
import com.jappy.jappy_core.presentation.adapter.BaseListAdapter;
import com.jappy.jappy_core.presentation.adapter.BaseViewHolder;
import java.util.List;


/**
 * Created by eucaris on 2/27/18.
 */

public class LaptopAdapter extends BaseListAdapter<Object,LaptopAdapter.LaptopViewHolder> {

    private OnItemClickListener<LaptopList> listener;
    int lastPosition = -1;


    @Override
    protected RecyclerView.ViewHolder createViewHolder(int viewType, View v) {
        return new LaptopViewHolder(v);
    }

    public void setOnAddToListListener(OnItemClickListener<LaptopList> listener) {
        this.listener=listener;
    }


    public void initializeList(List<LaptopList> laptopElements ) {
        list.clear();
        list.addAll(laptopElements);
        notifyDataSetChanged();
    }

    @Override
    protected int getLayoutIdByType(int viewType) {
        return R.layout.item_laptop;
    }

    public class LaptopViewHolder extends BaseViewHolder<Object,ItemLaptopBinding> {
        View view;
        LaptopViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }

        @Override
        public void bind(int position, Object item) {
            LaptopList laptopElement = (LaptopList) item;
            binder.TvTitle.setText(laptopElement.title);
            binder.Tvdescription.setText(laptopElement.description);

            Glide.with(itemView.getContext())
                    .load(laptopElement.image)
                    .placeholder(R.drawable.ic_placeholde)
                    .transform(new CircleTransform(getContext()))
                    .error(R.drawable.ic_placeholde)
                    .priority(Priority.HIGH)
                    .into(binder.imageView);

            binder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition(), (LaptopList) getItem(getAdapterPosition()));

                }
            });

            if(position >lastPosition) {
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.up_from_bottom);
                itemView.startAnimation(animation);
                lastPosition = position;
            }else {
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.up_from_bottom);
                itemView.startAnimation(animation);
                lastPosition = position;

            }




        }
    }
}
