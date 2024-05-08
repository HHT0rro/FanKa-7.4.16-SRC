package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.build.r;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.bucket.BucketParams;

/* compiled from: BusinessManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3962a = "BusinessManager";

    /* renamed from: b, reason: collision with root package name */
    private v f3963b;

    public o(Context context, String str, RPEventListener rPEventListener) {
        this(context, str, rPEventListener, false);
    }

    private void b() {
        a(null);
    }

    public final void a(BusinessHeadParams businessHeadParams) {
        v vVar = this.f3963b;
        if (vVar != null) {
            vVar.a(businessHeadParams);
        }
    }

    public o(Context context, String str, RPEventListener rPEventListener, boolean z10) {
        try {
            v vVar = new v(str);
            this.f3963b = vVar;
            if (z10) {
                vVar.a(new y(context), new a(rPEventListener, this.f3963b)).a(new ag(context)).a(new ai(context));
            } else {
                vVar.a(new ab(context), new a(rPEventListener, this.f3963b)).a(new y(context)).a(new ag(context)).a(new ai(context)).a(new ac(context));
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        v vVar = this.f3963b;
        if (vVar != null) {
            vVar.a();
        }
    }

    /* compiled from: BusinessManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements q {

        /* renamed from: a, reason: collision with root package name */
        private final RPEventListener f3964a;

        /* renamed from: b, reason: collision with root package name */
        private final v f3965b;

        public a(RPEventListener rPEventListener, v vVar) {
            this.f3964a = rPEventListener;
            this.f3965b = vVar;
        }

        @Override // com.alibaba.security.realidentity.build.q
        public final void a() {
            RPEventListener rPEventListener = this.f3964a;
            if (rPEventListener != null) {
                rPEventListener.onFinish(RPResult.AUDIT_PASS, "0", "");
            }
            v vVar = this.f3965b;
            if (vVar != null) {
                vVar.a();
            }
        }

        @Override // com.alibaba.security.realidentity.build.q
        public final void a(String str) {
            RPEventListener rPEventListener = this.f3964a;
            if (rPEventListener != null) {
                rPEventListener.onFinish(RPResult.AUDIT_EXCEPTION, "-10300", "Network Failure: ".concat(String.valueOf(str)));
            }
            v vVar = this.f3965b;
            if (vVar != null) {
                vVar.a();
            }
        }

        @Override // com.alibaba.security.realidentity.build.q
        public final void a(BusinessType businessType, r rVar) {
            BucketParams.ErrorCode errorCode;
            int i10 = r.AnonymousClass1.f3977a[businessType.ordinal()];
            if (i10 == 1) {
                errorCode = rVar.f3969c.getErrorCode();
            } else if (i10 == 2) {
                errorCode = rVar.f3973g.getErrorCode();
            } else if (i10 == 3) {
                errorCode = rVar.f3971e.getErrorCode();
            } else if (i10 != 4) {
                errorCode = i10 != 5 ? null : rVar.f3970d.getErrorCode();
            } else {
                errorCode = rVar.f3972f.getErrorCode();
            }
            RPEventListener rPEventListener = this.f3964a;
            if (rPEventListener != null) {
                rPEventListener.onFinish(errorCode.audit, errorCode.errorCode, errorCode.errorMsg);
            }
            v vVar = this.f3965b;
            if (vVar != null) {
                vVar.a();
            }
        }
    }
}
