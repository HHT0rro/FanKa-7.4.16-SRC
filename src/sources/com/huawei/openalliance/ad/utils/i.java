package com.huawei.openalliance.ad.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.openalliance.ad.views.PPSSplashView;
import com.huawei.openalliance.ad.views.SplashLinkedVideoView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i {
    public static com.huawei.openalliance.ad.inter.data.m Code(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        if (Code(view)) {
            return V(view, motionEvent);
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        sb2.append(width);
        sb2.append(StringUtils.NO_PRINT_CODE);
        sb2.append(height);
        return new com.huawei.openalliance.ad.inter.data.m(Integer.valueOf((int) x10), Integer.valueOf((int) y10), sb2.toString());
    }

    private static boolean Code(View view) {
        ViewParent parent = view.getParent();
        for (int i10 = 0; i10 < 5 && parent != null; i10++) {
            if ((parent instanceof SplashLinkedVideoView) || (parent instanceof PPSSplashView)) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    private static com.huawei.openalliance.ad.inter.data.m V(View view, MotionEvent motionEvent) {
        float left = view.getLeft() + motionEvent.getX();
        float top = view.getTop() + motionEvent.getY();
        StringBuilder sb2 = new StringBuilder();
        ViewParent parent = view.getParent();
        for (int i10 = 0; i10 < 5 && parent != null; i10++) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                left += viewGroup.getLeft();
                top += viewGroup.getTop();
            }
            if ((parent instanceof SplashLinkedVideoView) || (parent instanceof PPSSplashView)) {
                ViewGroup viewGroup2 = (ViewGroup) parent;
                int width = viewGroup2.getWidth();
                int height = viewGroup2.getHeight();
                sb2.append(width);
                sb2.append(StringUtils.NO_PRINT_CODE);
                sb2.append(height);
                return new com.huawei.openalliance.ad.inter.data.m(Integer.valueOf((int) left), Integer.valueOf((int) top), sb2.toString());
            }
            parent = parent.getParent();
        }
        return null;
    }
}
