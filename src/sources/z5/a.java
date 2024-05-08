package z5;

import java.util.Collections;
import java.util.List;

/* compiled from: AdaptationSet.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f54879a;

    /* renamed from: b, reason: collision with root package name */
    public final int f54880b;

    /* renamed from: c, reason: collision with root package name */
    public final List<j> f54881c;

    /* renamed from: d, reason: collision with root package name */
    public final List<e> f54882d;

    /* renamed from: e, reason: collision with root package name */
    public final List<e> f54883e;

    /* renamed from: f, reason: collision with root package name */
    public final List<e> f54884f;

    public a(int i10, int i11, List<j> list, List<e> list2, List<e> list3, List<e> list4) {
        this.f54879a = i10;
        this.f54880b = i11;
        this.f54881c = Collections.unmodifiableList(list);
        this.f54882d = Collections.unmodifiableList(list2);
        this.f54883e = Collections.unmodifiableList(list3);
        this.f54884f = Collections.unmodifiableList(list4);
    }
}
