package com.gjevass.pixels.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import com.gjevass.pixels.app.model.EvenViewModel;
import com.gjevass.pixels.app.model.OddViewModel;
import com.gjevass.pixels.app.ui.Adapter;
import com.gjevass.pixels.app.util.DisplayUtil;
import com.gjevass.pixels.app.util.ImageUtil;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView imageViewBackground = (ImageView) findViewById(R.id.imageview_background);
        ListView listView = (ListView) findViewById(R.id.listview);
        ImageView imageViewTop = (ImageView) findViewById(R.id.imageview_top);

        DisplayUtil displayUtil = new DisplayUtil(this);
        Bitmap bitmapBackground = BitmapFactory.decodeResource(getResources(), R.drawable.news);
        Bitmap bitmapBackgroundScalled = Bitmap.createScaledBitmap(bitmapBackground, displayUtil.getWidth(), displayUtil.getHeight(), true);
        imageViewBackground.setImageBitmap(bitmapBackgroundScalled);

        Bitmap bitmapTop = BitmapFactory.decodeResource(getResources(), R.drawable.news_best);
        ImageUtil imageUtil = new ImageUtil(bitmapTop, this);
        Bitmap bitmapTopScalled = Bitmap.createScaledBitmap(bitmapTop, Math.round(imageUtil.getRealWidth() * 0.75f), Math.round( imageUtil.getRealHeight() * 0.75f), true);
        imageViewTop.setImageBitmap(bitmapTopScalled);

        ArrayList<Object> objects = new ArrayList<Object>();

        EvenViewModel evenViewModel = new EvenViewModel(0,0,0,0,0, R.drawable.news_poster_sprt_0);
        OddViewModel oddViewModel = new OddViewModel(0,0,0,0,0, R.drawable.news_poster_sprt_1);

        EvenViewModel evenViewModel1 = new EvenViewModel(0,0,0,0,0, R.drawable.news_poster_sprt_0);
        OddViewModel oddViewModel2 = new OddViewModel(0,0,0,0,0, R.drawable.news_poster_sprt_1);

        objects.add(evenViewModel);
        objects.add(oddViewModel);
        objects.add(evenViewModel1);
        objects.add(oddViewModel2);

        listView.setAdapter(new Adapter(getApplicationContext(), 0, objects));
    }
}
