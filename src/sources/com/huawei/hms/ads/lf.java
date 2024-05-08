package com.huawei.hms.ads;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.huawei.appgallery.agd.common.utils.StringUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class lf {
    public static int Code(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static com.huawei.openalliance.ad.inter.data.m Code(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (view instanceof ImageView) {
            int[] Code = Code(view);
            if (Code == null) {
                return null;
            }
            int i10 = Code[0];
            x10 -= (width - i10) / 2;
            y10 -= (height - r6) / 2;
            height = Code[1];
            width = i10;
        }
        sb2.append(width);
        sb2.append(StringUtils.NO_PRINT_CODE);
        sb2.append(height);
        return new com.huawei.openalliance.ad.inter.data.m(Integer.valueOf((int) x10), Integer.valueOf((int) y10), sb2.toString());
    }

    private static int[] Code(View view) {
        if (!(view instanceof ImageView)) {
            return null;
        }
        ImageView imageView = (ImageView) view;
        if (imageView.getDrawable() == null) {
            return null;
        }
        int width = imageView.getDrawable().getBounds().width();
        int height = imageView.getDrawable().getBounds().height();
        float[] fArr = new float[10];
        imageView.getImageMatrix().getValues(fArr);
        return new int[]{(int) (width * fArr[0]), (int) (height * fArr[4])};
    }

    public static boolean V(View view, MotionEvent motionEvent) {
        int[] Code;
        if (view == null || motionEvent == null) {
            return true;
        }
        if ((view instanceof ImageView) && (Code = Code(view)) != null) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int width = view.getWidth();
            int height = view.getHeight();
            int i10 = Code[0];
            int i11 = Code[1];
            float abs = Math.abs((width / 2) - x10) - (i10 / 2);
            float abs2 = Math.abs((height / 2) - y10) - (i11 / 2);
            if (abs > 0.0f || abs2 > 0.0f) {
                return true;
            }
        }
        return false;
    }
}
