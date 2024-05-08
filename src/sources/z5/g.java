package z5;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: Period.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f54922a;

    /* renamed from: b, reason: collision with root package name */
    public final long f54923b;

    /* renamed from: c, reason: collision with root package name */
    public final List<a> f54924c;

    /* renamed from: d, reason: collision with root package name */
    public final List<f> f54925d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final e f54926e;

    public g(@Nullable String str, long j10, List<a> list, List<f> list2) {
        this(str, j10, list, list2, null);
    }

    public int a(int i10) {
        int size = this.f54924c.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f54924c.get(i11).f54880b == i10) {
                return i11;
            }
        }
        return -1;
    }

    public g(@Nullable String str, long j10, List<a> list, List<f> list2, @Nullable e eVar) {
        this.f54922a = str;
        this.f54923b = j10;
        this.f54924c = Collections.unmodifiableList(list);
        this.f54925d = Collections.unmodifiableList(list2);
        this.f54926e = eVar;
    }
}
