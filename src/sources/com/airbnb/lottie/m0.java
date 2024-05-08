package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1954a = false;

    /* renamed from: b, reason: collision with root package name */
    public final Set<b> f1955b = new ArraySet();

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, n.f> f1956c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Comparator<Pair<String, Float>> f1957d = new a();

    /* compiled from: PerformanceTracker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements Comparator<Pair<String, Float>> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    }

    /* compiled from: PerformanceTracker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface b {
        void a(float f10);
    }

    public void a(String str, float f10) {
        if (this.f1954a) {
            n.f fVar = this.f1956c.get(str);
            if (fVar == null) {
                fVar = new n.f();
                this.f1956c.put(str, fVar);
            }
            fVar.a(f10);
            if (str.equals("__container")) {
                Iterator<b> iterator2 = this.f1955b.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().a(f10);
                }
            }
        }
    }

    public void b(boolean z10) {
        this.f1954a = z10;
    }
}
