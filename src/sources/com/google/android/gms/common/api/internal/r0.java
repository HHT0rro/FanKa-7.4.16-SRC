package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r0 implements PendingResult.StatusListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f23485a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f23486b;

    public r0(s0 s0Var, BasePendingResult basePendingResult) {
        this.f23486b = s0Var;
        this.f23485a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        Map map;
        map = this.f23486b.f23487a;
        map.remove(this.f23485a);
    }
}
