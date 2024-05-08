package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.download.app.k;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {
    public C0341a V = new C0341a();
    public C0341a I = new C0341a();
    public C0341a Z = new C0341a();

    /* renamed from: com.huawei.openalliance.ad.views.a$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[k.values().length];
            Code = iArr;
            try {
                iArr[k.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[k.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[k.INSTALLING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[k.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[k.DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[k.INSTALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0341a {
        public Drawable Code;
        public int I = 12;
        public int V;
        public Typeface Z;

        public void Code(int i10) {
            this.V = i10;
        }

        public void Code(Typeface typeface) {
            this.Z = typeface;
        }

        public void Code(Drawable drawable) {
            this.Code = drawable;
        }

        public void V(int i10) {
            this.I = i10;
        }
    }

    public a(Context context) {
        this.V.Code = context.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal);
        this.V.V = context.getResources().getColor(R.color.hiad_down_normal_text);
        this.I.Code(Code(context, R.drawable.hiad_app_down_btn_processing));
        this.I.Code(context.getResources().getColor(R.color.hiad_app_down_processing_text));
        this.Z.Code(context.getResources().getDrawable(R.drawable.hiad_app_down_btn_installing));
        this.Z.Code(context.getResources().getColor(R.color.hiad_app_down_installing_text));
    }

    public Drawable Code(Context context, int i10) {
        Drawable drawable = context.getResources().getDrawable(i10);
        if (Build.VERSION.SDK_INT >= 23 && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            drawable.setLayoutDirection(1);
        }
        return drawable;
    }

    public C0341a Code() {
        return this.V;
    }

    public C0341a Code(Context context, k kVar) {
        int i10 = AnonymousClass1.Code[kVar.ordinal()];
        return (i10 == 1 || i10 == 2) ? this.I : i10 != 3 ? Code() : this.Z;
    }

    public C0341a V() {
        return this.I;
    }
}
