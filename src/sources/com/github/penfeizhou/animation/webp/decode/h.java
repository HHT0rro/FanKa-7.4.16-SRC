package com.github.penfeizhou.animation.webp.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* compiled from: StillFrame.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class h extends com.github.penfeizhou.animation.decode.a<j4.a, j4.b> {
    public h(j4.a aVar, int i10, int i11) {
        super(aVar);
        this.f19254b = i10;
        this.f19255c = i11;
    }

    @Override // com.github.penfeizhou.animation.decode.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap a(Canvas canvas, Paint paint, int i10, Bitmap bitmap, j4.b bVar) {
        Bitmap decodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i10;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            try {
                decodeStream = BitmapFactory.decodeStream(((j4.a) this.f19253a).a(), null, options);
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return bitmap2;
            }
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = false;
            options2.inSampleSize = i10;
            options2.inMutable = true;
            decodeStream = BitmapFactory.decodeStream(((j4.a) this.f19253a).a(), null, options2);
        }
        try {
            paint.setXfermode(null);
            canvas.drawBitmap(decodeStream, 0.0f, 0.0f, paint);
            return decodeStream;
        } catch (IOException e11) {
            e = e11;
            bitmap2 = decodeStream;
            e.printStackTrace();
            return bitmap2;
        }
    }
}
