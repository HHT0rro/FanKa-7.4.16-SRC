package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.ar;

/* compiled from: ScaleRotateGestureDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class as extends ar {

    /* compiled from: ScaleRotateGestureDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class a implements ar.a {
        @Override // com.amap.api.col.3l.ar.a
        public final boolean a(ar arVar) {
            return a((as) arVar);
        }

        public abstract boolean a(as asVar);

        @Override // com.amap.api.col.3l.ar.a
        public final boolean b(ar arVar) {
            return b((as) arVar);
        }

        public abstract boolean b(as asVar);

        @Override // com.amap.api.col.3l.ar.a
        public final void c(ar arVar) {
            c((as) arVar);
        }

        public abstract void c(as asVar);
    }

    public as(Context context, a aVar) {
        super(context, aVar);
    }

    public final float j() {
        return (float) (((Math.atan2(g(), f()) - Math.atan2(e(), d())) * 180.0d) / 3.141592653589793d);
    }
}
