package p2;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: TimerRecord.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, List<Long>> f52851a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, Long> f52852b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f52853c;

    /* renamed from: d, reason: collision with root package name */
    public int f52854d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f52855e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f52856f;

    public b() {
        this(2000, false, true);
    }

    public void a(String str) {
        if (this.f52853c) {
            this.f52852b.put(str, Long.valueOf(System.nanoTime()));
        }
    }

    public abstract void b(String str, double d10, int i10);

    public abstract void c(String str, long j10);

    public void d(String str) {
        if (this.f52853c) {
            Long l10 = this.f52852b.get(str);
            if (l10 == null) {
                String.format("call record() with tag %s first", str);
                return;
            }
            long nanoTime = System.nanoTime() - l10.longValue();
            if (this.f52851a.get(str) == null) {
                this.f52851a.put(str, new ArrayList(this.f52854d));
            }
            ArrayList arrayList = (ArrayList) this.f52851a.get(str);
            arrayList.add(Long.valueOf(nanoTime));
            if (this.f52855e) {
                c(str, nanoTime);
            }
            if (arrayList.size() == this.f52854d) {
                if (this.f52856f) {
                    double d10 = ShadowDrawableWrapper.COS_45;
                    while (arrayList.iterator2().hasNext()) {
                        d10 += ((Long) r3.next()).longValue();
                    }
                    int i10 = this.f52854d;
                    b(str, d10 / i10, i10);
                }
                arrayList.clear();
            }
        }
    }

    public b(int i10, boolean z10, boolean z11) {
        this.f52851a = new HashMap<>();
        this.f52852b = new HashMap<>();
        this.f52853c = true;
        this.f52854d = i10;
        this.f52855e = z10;
        this.f52856f = z11;
    }
}
