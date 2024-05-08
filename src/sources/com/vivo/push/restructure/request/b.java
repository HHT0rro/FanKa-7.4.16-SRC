package com.vivo.push.restructure.request;

import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.u;

/* compiled from: CommandRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {

    /* renamed from: a, reason: collision with root package name */
    private a<I, O> f46349a;

    /* renamed from: b, reason: collision with root package name */
    private c<O> f46350b;

    /* renamed from: c, reason: collision with root package name */
    private long f46351c;

    private b(a<I, O> aVar) {
        this.f46351c = 5000L;
        this.f46349a = aVar;
        if (aVar == null) {
            u.a(JosStatusCodes.RTN_CODE_PARAMS_ERROR, "Command object is null, please construct command first");
        }
    }

    public final a a() {
        return this.f46349a;
    }

    public final c b() {
        return this.f46350b;
    }

    public final long c() {
        return this.f46351c;
    }

    private b(a<I, O> aVar, c<O> cVar) {
        this(aVar);
        this.f46350b = cVar;
    }

    public b(a<I, O> aVar, c<O> cVar, byte b4) {
        this(aVar, cVar);
        this.f46351c = 20000L;
    }
}
