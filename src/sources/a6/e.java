package a6;

import java.util.Collections;
import java.util.List;

/* compiled from: HlsPlaylist.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e implements u5.d<e> {

    /* renamed from: a, reason: collision with root package name */
    public final String f711a;

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f712b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f713c;

    public e(String str, List<String> list, boolean z10) {
        this.f711a = str;
        this.f712b = Collections.unmodifiableList(list);
        this.f713c = z10;
    }
}
