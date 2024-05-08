package ib;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: FuzzyKeyMemoryCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements hb.a {

    /* renamed from: a, reason: collision with root package name */
    public final hb.a f49868a;

    /* renamed from: b, reason: collision with root package name */
    public final Comparator<String> f49869b;

    public a(hb.a aVar, Comparator<String> comparator) {
        this.f49868a = aVar;
        this.f49869b = comparator;
    }

    @Override // hb.a
    public boolean a(String str, Bitmap bitmap) {
        synchronized (this.f49868a) {
            String str2 = null;
            Iterator<String> iterator2 = this.f49868a.keys().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                String next = iterator2.next();
                if (this.f49869b.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.f49868a.remove(str2);
            }
        }
        return this.f49868a.a(str, bitmap);
    }

    @Override // hb.a
    public Bitmap get(String str) {
        return this.f49868a.get(str);
    }

    @Override // hb.a
    public Collection<String> keys() {
        return this.f49868a.keys();
    }

    @Override // hb.a
    public Bitmap remove(String str) {
        return this.f49868a.remove(str);
    }
}
