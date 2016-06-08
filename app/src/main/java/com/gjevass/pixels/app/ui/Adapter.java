package com.gjevass.pixels.app.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.gjevass.pixels.app.R;
import com.gjevass.pixels.app.model.EvenViewModel;
import com.gjevass.pixels.app.model.OddViewModel;
import com.gjevass.pixels.app.viewholder.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<Object> {
    private final int VIEW_TYPE_EVEN = 0;
    private final int VIEW_TYPE_ODD = 1;

    private ArrayList<Object> list = new ArrayList<Object>();
    private LayoutInflater layoutInflater;

    public Adapter(Context context, int resource, ArrayList<Object> objects) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder.EvenViewHolder evenViewHolder = null;
        ViewHolder.OddViewHolder oddViewHolder = null;

        int type = getItemViewType(position);

        if(type == VIEW_TYPE_EVEN) {
            System.out.println("VIEW_TYPE_EVEN " +position);
            //if(convertView == null) {
                System.out.println("convertView == null");
                convertView = layoutInflater.inflate(R.layout.item_even, parent, false);
                evenViewHolder = new ViewHolder().new EvenViewHolder();
                evenViewHolder.imageViewBackground = (ImageView) convertView.findViewById(R.id.image_view_even_background);
                evenViewHolder.imageViewNws = (ImageView) convertView.findViewById(R.id.image_view_even_nws);
                evenViewHolder.imageViewFrame = (ImageView) convertView.findViewById(R.id.image_view_even_frame);
                System.out.println("evenViewHolder " + evenViewHolder);

                oddViewHolder = null;
/*            }
            else {
                System.out.println("else");
                evenViewHolder = (ViewHolder.EvenViewHolder) convertView.getTag();
                oddViewHolder= null;
                System.out.println("evenViewHolder "+evenViewHolder);
            }*/

            EvenViewModel evenViewModel = (EvenViewModel) list.get(position);
            System.out.println("resourciD " + evenViewModel.getResourceId());
            System.out.println("evenViewHolder "+ evenViewHolder);;
            evenViewHolder.imageViewBackground.setImageResource(evenViewModel.getResourceId());

        } else if(type == VIEW_TYPE_ODD) {
           // if(convertView == null) {
                System.out.println("VIEW_TYPE_ODD " + position);
                convertView = layoutInflater.inflate(R.layout.item_odd, parent, false);
                oddViewHolder = new ViewHolder().new OddViewHolder();
                oddViewHolder.imageViewBackground = (ImageView) convertView.findViewById(R.id.image_view_odd_background);
                oddViewHolder.imageViewNws = (ImageView) convertView.findViewById(R.id.image_view_odd_nws);
                oddViewHolder.imageViewFrame = (ImageView) convertView.findViewById(R.id.image_view_odd_frame);

                evenViewHolder = null;
          //  }
 /*           else {
                oddViewHolder = (ViewHolder.OddViewHolder) convertView.getTag();
                evenViewHolder= null;
            }*/
            OddViewModel oddViewModel = (OddViewModel) list.get(position);
            oddViewHolder.imageViewBackground.setImageResource( oddViewModel.getResourceId());
        }


        return convertView;
    }


}
