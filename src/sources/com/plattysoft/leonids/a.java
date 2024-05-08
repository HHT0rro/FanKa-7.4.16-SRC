package com.plattysoft.leonids;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

/* compiled from: AnimatedParticle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends b {

    /* renamed from: v, reason: collision with root package name */
    public AnimationDrawable f38041v;

    /* renamed from: w, reason: collision with root package name */
    public int f38042w;

    public a(AnimationDrawable animationDrawable) {
        this.f38041v = animationDrawable;
        this.f38043a = ((BitmapDrawable) animationDrawable.getFrame(0)).getBitmap();
        this.f38042w = 0;
        for (int i10 = 0; i10 < this.f38041v.getNumberOfFrames(); i10++) {
            this.f38042w += this.f38041v.getDuration(i10);
        }
    }

    @Override // com.plattysoft.leonids.b
    public boolean e(long j10) {
        boolean e2 = super.e(j10);
        if (e2) {
            long j11 = 0;
            long j12 = j10 - this.f38060r;
            int i10 = 0;
            if (j12 > this.f38042w) {
                if (this.f38041v.isOneShot()) {
                    return false;
                }
                j12 %= this.f38042w;
            }
            while (true) {
                if (i10 >= this.f38041v.getNumberOfFrames()) {
                    break;
                }
                j11 += this.f38041v.getDuration(i10);
                if (j11 > j12) {
                    this.f38043a = ((BitmapDrawable) this.f38041v.getFrame(i10)).getBitmap();
                    break;
                }
                i10++;
            }
        }
        return e2;
    }
}
