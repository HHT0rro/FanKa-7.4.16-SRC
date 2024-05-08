package com.github.penfeizhou.animation.webp.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import java.io.IOException;

/* compiled from: AnimationFrame.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class d extends com.github.penfeizhou.animation.decode.a<j4.a, j4.b> {

    /* renamed from: n, reason: collision with root package name */
    public static final PorterDuffXfermode f19275n = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);

    /* renamed from: o, reason: collision with root package name */
    public static final PorterDuffXfermode f19276o = new PorterDuffXfermode(PorterDuff.Mode.SRC);

    /* renamed from: i, reason: collision with root package name */
    public final int f19277i;

    /* renamed from: j, reason: collision with root package name */
    public final int f19278j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f19279k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f19280l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f19281m;

    public d(j4.a aVar, c cVar) {
        super(aVar);
        this.f19254b = cVar.f19268f;
        this.f19255c = cVar.f19269g;
        this.f19256d = cVar.f19266d;
        this.f19257e = cVar.f19267e;
        int i10 = cVar.f19270h;
        this.f19258f = i10;
        if (i10 == 0) {
            this.f19258f = 100;
        }
        this.f19279k = cVar.d();
        this.f19280l = cVar.e();
        this.f19277i = cVar.f19284c + 8 + 16;
        int i11 = cVar.f19283b;
        this.f19278j = (i11 - 16) + (i11 & 1);
        this.f19281m = cVar.f19272j != null;
    }

    @Override // com.github.penfeizhou.animation.decode.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap a(Canvas canvas, Paint paint, int i10, Bitmap bitmap, j4.b bVar) {
        Bitmap decodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i10;
        options.inMutable = true;
        options.inBitmap = bitmap;
        int c4 = c(bVar);
        byte[] e2 = bVar.e();
        try {
            decodeByteArray = BitmapFactory.decodeByteArray(e2, 0, c4, options);
        } catch (IllegalArgumentException unused) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = false;
            options2.inSampleSize = i10;
            options2.inMutable = true;
            decodeByteArray = BitmapFactory.decodeByteArray(e2, 0, c4, options2);
        }
        if (decodeByteArray == null) {
            return bitmap;
        }
        if (this.f19279k) {
            paint.setXfermode(f19276o);
        } else {
            paint.setXfermode(f19275n);
        }
        Rect rect = this.f19259g;
        rect.left = 0;
        rect.top = 0;
        rect.right = decodeByteArray.getWidth();
        this.f19259g.bottom = decodeByteArray.getHeight();
        Rect rect2 = this.f19260h;
        int i11 = this.f19256d;
        float f10 = i10;
        rect2.left = (int) ((i11 * 2.0f) / f10);
        rect2.top = (int) ((this.f19257e * 2.0f) / f10);
        rect2.right = (int) (((i11 * 2.0f) / f10) + decodeByteArray.getWidth());
        this.f19260h.bottom = (int) (((this.f19257e * 2.0f) / f10) + decodeByteArray.getHeight());
        canvas.drawBitmap(decodeByteArray, this.f19259g, this.f19260h, paint);
        return decodeByteArray;
    }

    public final int c(j4.b bVar) {
        int i10 = 30 + this.f19278j;
        bVar.c(i10);
        bVar.g("RIFF");
        bVar.i(i10);
        bVar.g("WEBP");
        bVar.i(k.f19289g);
        bVar.i(10);
        bVar.b((byte) (this.f19281m ? 16 : 0));
        bVar.h(0);
        bVar.f(this.f19254b);
        bVar.f(this.f19255c);
        try {
            ((j4.a) this.f19253a).reset();
            ((j4.a) this.f19253a).skip(this.f19277i);
            ((j4.a) this.f19253a).read(bVar.e(), bVar.a(), this.f19278j);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return i10;
    }
}
