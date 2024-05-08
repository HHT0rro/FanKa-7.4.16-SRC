package com.google.android.exoplayer2.upstream;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.e;
import o6.v;

/* compiled from: DefaultDataSourceFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements a.InterfaceC0208a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22857a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final v f22858b;

    /* renamed from: c, reason: collision with root package name */
    public final a.InterfaceC0208a f22859c;

    public d(Context context) {
        this(context, (String) null, (v) null);
    }

    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0208a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a() {
        c cVar = new c(this.f22857a, this.f22859c.a());
        v vVar = this.f22858b;
        if (vVar != null) {
            cVar.d(vVar);
        }
        return cVar;
    }

    public d(Context context, @Nullable String str, @Nullable v vVar) {
        this(context, vVar, new e.b().e(str));
    }

    public d(Context context, @Nullable v vVar, a.InterfaceC0208a interfaceC0208a) {
        this.f22857a = context.getApplicationContext();
        this.f22858b = vVar;
        this.f22859c = interfaceC0208a;
    }
}
