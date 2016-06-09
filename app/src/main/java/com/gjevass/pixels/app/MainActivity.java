package com.gjevass.pixels.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import com.gjevass.pixels.app.model.EvenViewModel;
import com.gjevass.pixels.app.model.FrameModel;
import com.gjevass.pixels.app.model.SprtModel;
import com.gjevass.pixels.app.ui.NewsAdapter;
import com.gjevass.pixels.app.util.DisplayUtil;
import com.gjevass.pixels.app.util.ImageUtil;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private float scaleFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ScaleFactorCalc scaleFactorCalc = new ScaleFactorCalc(R.drawable.news, this);
        scaleFactor = scaleFactorCalc.getScaleFactor();

        ImageView imageViewBackground = (ImageView) findViewById(R.id.imageview_background);
        ListView listView = (ListView) findViewById(R.id.listview);
        ImageView imageViewTop = (ImageView) findViewById(R.id.imageview_top);


        DisplayUtil displayUtil = new DisplayUtil(this);
        Bitmap bitmapBackground = BitmapFactory.decodeResource(getResources(), R.drawable.news);
        System.out.println("display width " + displayUtil.getWidth());
        System.out.println("display height " + displayUtil.getHeight());
        Bitmap bitmapBackgroundScalled = Bitmap.createScaledBitmap(bitmapBackground, displayUtil.getWidth(), displayUtil.getHeight(), true);
        imageViewBackground.setImageBitmap(bitmapBackgroundScalled);

        Bitmap bitmapTop = BitmapFactory.decodeResource(getResources(), R.drawable.news_best);
        ImageUtil imageUtil = new ImageUtil(bitmapTop, this);
        Bitmap bitmapTopScalled = Bitmap.createScaledBitmap(bitmapTop, Math.round(imageUtil.getRealWidth() * scaleFactor), Math.round( imageUtil.getRealHeight() * scaleFactor), true);
        imageViewTop.setImageBitmap(bitmapTopScalled);

        ArrayList<Object> objects = new ArrayList<Object>();

        System.out.println("scaleFactor " + scaleFactor);
        SprtModel sprtEven = new SprtModel(scaleFactor, R.drawable.news_poster_sprt_0, this);
        SprtModel sprtOdd = new SprtModel(scaleFactor, R.drawable.news_poster_sprt_1, this);

        FrameModel frameEven = new FrameModel(6, 40, 1, scaleFactor, R.drawable.news_poster_frame, this);
        FrameModel frameOdd = new FrameModel(6, 40, -0.7f, scaleFactor, R.drawable.news_poster_frame, this);

        EvenViewModel evenViewModel = new EvenViewModel(sprtEven, frameEven);
        EvenViewModel evenViewModel1 = new EvenViewModel(sprtOdd, frameOdd);


        objects.add(evenViewModel);
        objects.add(evenViewModel1);


        listView.setAdapter(new NewsAdapter(getApplicationContext(), 0, objects));

        FrameLayout.LayoutParams listViewLayoutParams = new FrameLayout.LayoutParams(listView.getLayoutParams());
        listViewLayoutParams.setMargins(Math.round(112 * scaleFactor), 0, 0, 0);
        listView.setLayoutParams(listViewLayoutParams);

    }
}
