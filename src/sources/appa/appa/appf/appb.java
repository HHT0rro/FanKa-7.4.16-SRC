package appa.appa.appf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: CommonFilter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appb {
    public static final int appa(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return (networkInfo2 == null || !networkInfo2.isAvailable()) ? -1 : 0;
        }
        return 1;
    }

    public static void appb(View view) {
        if (view != null) {
            try {
                if (view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) view.getParent()).removeView(view);
            } catch (Throwable th) {
                appd.appe("CommonFilter", "removeViewFromParent exception:" + th.toString());
            }
        }
    }

    public static void appa(View view) {
        if (view != null) {
            try {
                if (view instanceof ViewGroup) {
                    ((ViewGroup) view).removeAllViews();
                }
            } catch (Throwable th) {
                appd.appe("CommonFilter", "removeAllView exception:" + th.toString());
            }
        }
    }

    public static void appa(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static void appa(ImageView imageView) {
        if (imageView != null) {
            appa((BitmapDrawable) imageView.getDrawable());
        }
    }

    private static void appa(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable != null) {
            Bitmap bitmap = bitmapDrawable.getBitmap();
            appa(bitmap);
            appd.appe("CommonFilter", "rceycleBitmapDrawable", bitmap);
        }
    }
}
