package com.mobile.auth.gatewayauth.manager;

import android.content.Context;
import android.util.SparseArray;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.model.VendorConfig;
import com.nirvana.tools.requestqueue.Callback;
import com.nirvana.tools.requestqueue.RequestQueue;
import com.nirvana.tools.requestqueue.strategy.ThreadStrategy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private com.mobile.auth.r.a f37325a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, SparseArray<VendorConfig> sparseArray);
    }

    public e(com.mobile.auth.r.a aVar) {
        this.f37325a = aVar;
    }

    public static final e a(Context context, VendorSdkInfoManager vendorSdkInfoManager, b bVar, com.mobile.auth.q.a aVar) {
        try {
            return new e(new com.mobile.auth.r.b(context, vendorSdkInfoManager, bVar, aVar));
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public void a(final a aVar) {
        try {
            RequestQueue.getInstance().pushRequest(new com.mobile.auth.v.d(new Callback<com.mobile.auth.w.a>(ThreadStrategy.SAME_WITH_CALLABLE, 2000L) { // from class: com.mobile.auth.gatewayauth.manager.e.1
                public void a(com.mobile.auth.w.a aVar2) {
                    try {
                        if (aVar != null) {
                            if (aVar2.a()) {
                                aVar.a(aVar2.c(), aVar2.b(), aVar2.e());
                            } else {
                                aVar.a(aVar2.c(), aVar2.b());
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.nirvana.tools.requestqueue.Callback
                public /* synthetic */ void onResult(com.mobile.auth.w.a aVar2) {
                    try {
                        a(aVar2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            }, this.f37325a));
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
