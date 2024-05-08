package com.plattysoft.leonids;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class ParticleField extends View {

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<b> f38040b;

    public ParticleField(Context context) {
        super(context);
    }

    public void a(ArrayList<b> arrayList) {
        this.f38040b = arrayList;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.f38040b) {
            for (int i10 = 0; i10 < this.f38040b.size(); i10++) {
                this.f38040b.get(i10).c(canvas);
            }
        }
    }
}
