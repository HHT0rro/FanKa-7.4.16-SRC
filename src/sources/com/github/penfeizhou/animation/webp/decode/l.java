package com.github.penfeizhou.animation.webp.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import java.io.IOException;

/* compiled from: WebPDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class l extends FrameSeqDecoder<j4.a, j4.b> {
    public boolean A;
    public int B;
    public j4.b C;

    /* renamed from: v, reason: collision with root package name */
    public final Paint f19293v;

    /* renamed from: w, reason: collision with root package name */
    public Paint f19294w;

    /* renamed from: x, reason: collision with root package name */
    public int f19295x;

    /* renamed from: y, reason: collision with root package name */
    public int f19296y;

    /* renamed from: z, reason: collision with root package name */
    public int f19297z;

    public l(i4.c cVar, FrameSeqDecoder.j jVar) {
        super(cVar, jVar);
        Paint paint = new Paint();
        this.f19293v = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public void I() {
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public void K(com.github.penfeizhou.animation.decode.a<j4.a, j4.b> aVar) {
        Bitmap E;
        int i10;
        if (aVar == null || this.f19234p == null || this.f19234p.width() <= 0 || this.f19234p.height() <= 0 || (E = E(this.f19234p.width() / this.f19229k, this.f19234p.height() / this.f19229k)) == null) {
            return;
        }
        Canvas canvas = this.f19232n.get(E);
        if (canvas == null) {
            canvas = new Canvas(E);
            this.f19232n.put(E, canvas);
        }
        this.f19233o.rewind();
        E.copyPixelsFromBuffer(this.f19233o);
        int i11 = this.f19223e;
        if (i11 == 0) {
            if (this.A) {
                canvas.drawColor(0, PorterDuff.Mode.SRC);
            } else {
                canvas.drawColor(this.B, PorterDuff.Mode.SRC);
            }
        } else {
            com.github.penfeizhou.animation.decode.a aVar2 = (com.github.penfeizhou.animation.decode.a) this.f19222d.get(i11 - 1);
            if ((aVar2 instanceof d) && ((d) aVar2).f19280l) {
                int i12 = aVar2.f19256d;
                int i13 = this.f19229k;
                canvas.drawRect((i12 * 2.0f) / i13, (aVar2.f19257e * 2.0f) / i13, ((i12 * 2) + aVar2.f19254b) / i13, ((r7 * 2) + aVar2.f19255c) / i13, this.f19293v);
            }
        }
        Bitmap bitmap = null;
        int i14 = aVar.f19254b;
        if (i14 > 0 && (i10 = aVar.f19255c) > 0) {
            int i15 = this.f19229k;
            bitmap = E(i14 / i15, i10 / i15);
        }
        H(aVar.a(canvas, this.f19294w, this.f19229k, bitmap, z()));
        H(bitmap);
        this.f19233o.rewind();
        E.copyPixelsToBuffer(this.f19233o);
        H(E);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public j4.a x(h4.d dVar) {
        return new j4.a(dVar);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public j4.b z() {
        if (this.C == null) {
            this.C = new j4.b();
        }
        return this.C;
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public Rect G(j4.a aVar) throws IOException {
        boolean z10 = false;
        boolean z11 = false;
        for (e eVar : WebPParser.a(aVar)) {
            if (eVar instanceof k) {
                k kVar = (k) eVar;
                this.f19296y = kVar.f19291e;
                this.f19297z = kVar.f19292f;
                this.A = kVar.d();
                z11 = true;
            } else if (eVar instanceof b) {
                b bVar = (b) eVar;
                this.B = bVar.f19263d;
                this.f19295x = bVar.f19264e;
                z10 = true;
            } else if (eVar instanceof c) {
                this.f19222d.add(new d(aVar, (c) eVar));
            }
        }
        if (!z10) {
            if (!z11) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(aVar.a(), null, options);
                this.f19296y = options.outWidth;
                this.f19297z = options.outHeight;
            }
            this.f19222d.add(new h(aVar, this.f19296y, this.f19297z));
            this.f19295x = 1;
        }
        Paint paint = new Paint();
        this.f19294w = paint;
        paint.setAntiAlias(true);
        if (!this.A) {
            this.f19293v.setColor(this.B);
        }
        return new Rect(0, 0, this.f19296y, this.f19297z);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public int v() {
        return this.f19295x;
    }
}
