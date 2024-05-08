package kb;

import android.graphics.BitmapFactory;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

/* compiled from: ImageDecodingInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f50755a;

    /* renamed from: b, reason: collision with root package name */
    public final String f50756b;

    /* renamed from: c, reason: collision with root package name */
    public final String f50757c;

    /* renamed from: d, reason: collision with root package name */
    public final jb.c f50758d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageScaleType f50759e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewScaleType f50760f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageDownloader f50761g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f50762h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f50763i;

    /* renamed from: j, reason: collision with root package name */
    public final BitmapFactory.Options f50764j;

    public c(String str, String str2, String str3, jb.c cVar, ViewScaleType viewScaleType, ImageDownloader imageDownloader, com.nostra13.universalimageloader.core.c cVar2) {
        this.f50755a = str;
        this.f50756b = str2;
        this.f50757c = str3;
        this.f50758d = cVar;
        this.f50759e = cVar2.C();
        this.f50760f = viewScaleType;
        this.f50761g = imageDownloader;
        this.f50762h = cVar2.x();
        this.f50763i = cVar2.H();
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f50764j = options;
        a(cVar2.u(), options);
    }

    public final void a(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        b(options, options2);
        c(options, options2);
    }

    public final void b(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    public final void c(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public BitmapFactory.Options d() {
        return this.f50764j;
    }

    public ImageDownloader e() {
        return this.f50761g;
    }

    public Object f() {
        return this.f50762h;
    }

    public String g() {
        return this.f50755a;
    }

    public ImageScaleType h() {
        return this.f50759e;
    }

    public String i() {
        return this.f50756b;
    }

    public jb.c j() {
        return this.f50758d;
    }

    public ViewScaleType k() {
        return this.f50760f;
    }

    public boolean l() {
        return this.f50763i;
    }
}
