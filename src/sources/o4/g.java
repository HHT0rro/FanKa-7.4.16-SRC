package o4;

import android.content.Context;
import javax.inject.Inject;

/* compiled from: CreationContextFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52274a;

    /* renamed from: b, reason: collision with root package name */
    public final u4.a f52275b;

    /* renamed from: c, reason: collision with root package name */
    public final u4.a f52276c;

    @Inject
    public g(Context context, u4.a aVar, u4.a aVar2) {
        this.f52274a = context;
        this.f52275b = aVar;
        this.f52276c = aVar2;
    }

    public f a(String str) {
        return f.a(this.f52274a, this.f52275b, this.f52276c, str);
    }
}
