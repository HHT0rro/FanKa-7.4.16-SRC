package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.col.p0003l.ab;
import com.amap.api.col.p0003l.dk;
import com.amap.api.col.p0003l.dx;
import com.amap.api.col.p0003l.dy;
import com.amap.api.col.p0003l.dz;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static final String ICON_ID_PREFIX = "com.amap.api.icon_";

    public static BitmapDescriptor defaultMarker() {
        try {
            return fromAsset(dk.a.marker_default.name() + ".png");
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(dx.a(context, str));
            }
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/".concat(String.valueOf(str)));
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Throwable th) {
            dx.a(th);
            dz.b(dy.f5400f, "read bitmap from assets failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new BitmapDescriptor(bitmap, ICON_ID_PREFIX + dx.b());
        } catch (Throwable th) {
            dx.a(th);
            dz.b(dy.f5400f, "read bitmap from bitmap failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FileInputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            dx.a(decodeStream);
            return fromBitmap;
        } catch (Throwable th) {
            dx.a(th);
            dz.b(dy.f5400f, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Throwable th) {
            dx.a(th);
            dz.b(dy.f5400f, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i10) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i10)));
            }
            return null;
        } catch (Throwable th) {
            dx.a(th);
            dz.b(dy.f5400f, "read bitmap from res failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(view);
            frameLayout.setDrawingCacheEnabled(true);
            return fromBitmap(dx.a(frameLayout));
        } catch (Throwable th) {
            dx.a(th);
            dz.b(dy.f5400f, "read bitmap from view failed " + th.getMessage());
            return null;
        }
    }

    public static Context getContext() {
        return ab.f4885a;
    }

    public static BitmapDescriptor defaultMarker(float f10) {
        try {
            float f11 = (((int) (f10 + 15.0f)) / 30) * 30;
            if (f11 > 330.0f) {
                f11 = 330.0f;
            } else if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            String str = "";
            if (f11 == 0.0f) {
                str = "RED";
            } else if (f11 == 30.0f) {
                str = "ORANGE";
            } else if (f11 == 60.0f) {
                str = "YELLOW";
            } else if (f11 == 120.0f) {
                str = "GREEN";
            } else if (f11 == 180.0f) {
                str = "CYAN";
            } else if (f11 == 210.0f) {
                str = "AZURE";
            } else if (f11 == 240.0f) {
                str = "BLUE";
            } else if (f11 == 270.0f) {
                str = "VIOLET";
            } else if (f11 == 300.0f) {
                str = "MAGENTA";
            } else if (f11 == 330.0f) {
                str = "ROSE";
            }
            return fromAsset(str + ".png");
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }
}
