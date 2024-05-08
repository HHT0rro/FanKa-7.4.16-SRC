package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.openalliance.ad.utils.c;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AdSize {

    @GlobalApi
    public static final AdSize AD_SIZE_SMART = new AdSize(-1, -2);
    public static final int B = -5;
    public static final int Code = -1;
    private static final int D = -1;
    public static final int I = -4;
    private static final float L = 10.0f;
    public static final int V = -3;
    public static final int Z = -2;
    public final int C;
    public int F = 0;
    public final int S;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        public static final int Code = 0;
        public static final int V = 1;
    }

    @GlobalApi
    public AdSize(int i10, int i11) {
        if (Code(i10) && V(i11)) {
            this.C = i10;
            this.S = i11;
        } else {
            this.C = 0;
            this.S = 0;
        }
    }

    public static boolean Code(int i10) {
        return i10 > 0 || i10 == -1 || i10 == -3;
    }

    private boolean I(Context context) {
        if (this.F == 1) {
            int widthPx = getWidthPx(context);
            int heightPx = getHeightPx(context);
            if (heightPx != 0 && widthPx / heightPx > L) {
                return true;
            }
        }
        return false;
    }

    public static boolean V(int i10) {
        return i10 > 0 || i10 == -2 || i10 == -4 || i10 == -5;
    }

    public int Code(Context context) {
        return !I(context) ? getHeightPx(context) : c.Code(context, getWidthPx(context));
    }

    public int V(Context context) {
        return !I(context) ? getWidthPx(context) : c.V(context, getWidthPx(context));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.C == adSize.C && this.S == adSize.S && this.F == adSize.F;
    }

    @GlobalApi
    public int getHeight() {
        return this.S;
    }

    public int getHeightPx(Context context) {
        if (!V(this.S)) {
            return -1;
        }
        int i10 = this.S;
        return i10 == -2 ? c.S(context) : i10 == -5 ? c.F(context) : c.I(context, i10);
    }

    @GlobalApi
    public int getWidth() {
        return this.C;
    }

    public int getWidthPx(Context context) {
        if (!Code(this.C)) {
            return -1;
        }
        int i10 = this.C;
        return i10 == -1 ? c.V(context) : c.I(context, i10);
    }
}
