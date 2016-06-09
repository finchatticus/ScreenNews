package com.gjevass.pixels.app.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.gjevass.pixels.app.R;
import com.gjevass.pixels.app.model.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<ViewModel> imageList = new ArrayList<ViewModel>();
    private List<Bitmap> posters = null;

    public NewsAdapter(Context context, List<ViewModel> imageList) {
        this.imageList = imageList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public ViewModel getItem(int i) {
        return imageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        }
        ViewModel viewModel = getItem(i);

        ImageView imageViewBackground = (ImageView) view.findViewById(R.id.image_view_item_background);
        ImageView imageViewNws = (ImageView) view.findViewById(R.id.image_view_nws);
        ImageView imageViewFrame = (ImageView) view.findViewById(R.id.image_view_frame);

        imageViewBackground.setImageBitmap(viewModel.getBitmapSprt());

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(imageViewFrame.getLayoutParams());
        lp.setMargins(viewModel.getFrameModel().getMarginLeft(), viewModel.getFrameModel().getMarginTop(), 0, 0);
        imageViewFrame.setLayoutParams(lp);
        imageViewFrame.setRotation(viewModel.getFrameModel().getRotate());
        imageViewFrame.setImageBitmap(viewModel.getBitmapFrame());

        if (posters != null) {
                //poster
            FrameLayout.LayoutParams lp0 = new FrameLayout.LayoutParams(imageViewNws.getLayoutParams());
            lp0.setMargins(130, 617, 0, 0);
            imageViewNws.setLayoutParams(lp0);
            imageViewNws.setRotation(3);
            imageViewNws.setImageBitmap(posters.get(0));
        }
        return view;
    }

    public void setPosters(List<Bitmap> posters) {
        this.posters = posters;
    }

    /*private final int VIEW_TYPE_EVEN = 0;
    private final int VIEW_TYPE_ODD = 1;

    private ArrayList<Object> list = new ArrayList<Object>();
    private LayoutInflater layoutInflater;

    public NewsAdapter(Context context, int resource, ArrayList<Object> objects) {
        super(context, resource, objects);

        list = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return null == list ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof OddViewModel) {
            return VIEW_TYPE_ODD;
        } else {
            return VIEW_TYPE_EVEN;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder.EvenViewHolder evenViewHolder = null;
        ViewHolder.OddViewHolder oddViewHolder = null;

        int type = getItemViewType(position);

        if(type == VIEW_TYPE_EVEN) {
            view = layoutInflater.inflate(R.layout.item_even, parent, false);
            evenViewHolder = new ViewHolder().new EvenViewHolder();
            evenViewHolder.imageViewBackground = (ImageView) view.findViewById(R.id.image_view_even_background);
            evenViewHolder.imageViewNws = (ImageView) view.findViewById(R.id.image_view_even_nws);
            evenViewHolder.imageViewFrame = (ImageView) view.findViewById(R.id.image_view_even_frame);
            System.out.println("evenViewHolder " + evenViewHolder);

            EvenViewModel evenViewModel = (EvenViewModel) list.get(position);
            evenViewHolder.imageViewBackground.setImageBitmap(evenViewModel.getBitmapSprt());

            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(evenViewHolder.imageViewFrame.getLayoutParams());
            lp.setMargins(evenViewModel.getFrameModel().getMarginLeft(), evenViewModel.getFrameModel().getMarginTop(), 0, 0);
            evenViewHolder.imageViewFrame.setLayoutParams(lp);
            evenViewHolder.imageViewFrame.setRotation(evenViewModel.getFrameModel().getRotate());
            evenViewHolder.imageViewFrame.setImageBitmap(evenViewModel.getBitmapFrame());



        } else if(type == VIEW_TYPE_ODD) {
            view = layoutInflater.inflate(R.layout.item_odd, parent, false);
            oddViewHolder = new ViewHolder().new OddViewHolder();
            oddViewHolder.imageViewBackground = (ImageView) view.findViewById(R.id.image_view_odd_background);
            oddViewHolder.imageViewNws = (ImageView) view.findViewById(R.id.image_view_odd_nws);
            oddViewHolder.imageViewFrame = (ImageView) view.findViewById(R.id.image_view_odd_frame);

            OddViewModel oddViewModel = (OddViewModel) list.get(position);
            oddViewHolder.imageViewBackground.setImageBitmap( oddViewModel.getBitmap());
        }


        return view;
    }
*/

}
