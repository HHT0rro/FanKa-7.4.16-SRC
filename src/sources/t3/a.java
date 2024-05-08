package t3;

import android.graphics.PointF;
import android.view.View;
import s3.e;

/* compiled from: SimpleBoundaryDecider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public PointF f53763a;

    /* renamed from: b, reason: collision with root package name */
    public e f53764b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f53765c = true;

    @Override // s3.e
    public boolean a(View view) {
        e eVar = this.f53764b;
        if (eVar != null) {
            return eVar.a(view);
        }
        return u3.b.a(view, this.f53763a);
    }
}
