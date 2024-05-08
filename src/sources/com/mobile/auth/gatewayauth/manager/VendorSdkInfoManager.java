package com.mobile.auth.gatewayauth.manager;

import android.text.TextUtils;
import android.util.SparseArray;
import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.manager.e;
import com.mobile.auth.gatewayauth.model.MonitorStruct;
import com.mobile.auth.gatewayauth.model.VendorConfig;
import com.nirvana.tools.core.ExecutorManager;
import com.nirvana.tools.jsoner.JsonType;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VendorSdkInfoManager {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<VendorConfig> f37228a = new com.mobile.auth.gatewayauth.manager.base.a(3);

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<VendorConfig> f37229b = new com.mobile.auth.gatewayauth.manager.base.a(3);

    /* renamed from: c, reason: collision with root package name */
    private String f37230c;

    /* renamed from: d, reason: collision with root package name */
    private String f37231d;

    /* renamed from: e, reason: collision with root package name */
    private d f37232e;

    /* renamed from: f, reason: collision with root package name */
    private SystemManager f37233f;

    /* renamed from: g, reason: collision with root package name */
    private com.mobile.auth.q.a f37234g;

    /* renamed from: com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass4 extends JsonType<VendorConfig> {
        public AnonymousClass4() {
        }
    }

    static {
        p.a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
    }

    public VendorSdkInfoManager(d dVar, SystemManager systemManager) {
        this.f37232e = dVar;
        this.f37234g = dVar.a();
        this.f37233f = systemManager;
    }

    public static /* synthetic */ SparseArray a(VendorSdkInfoManager vendorSdkInfoManager) {
        try {
            return vendorSdkInfoManager.f37229b;
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

    private MonitorStruct a(String str) {
        try {
            MonitorStruct monitorStruct = new MonitorStruct();
            monitorStruct.setStartTime(System.currentTimeMillis());
            monitorStruct.setSessionId(str);
            monitorStruct.setRequestId(this.f37232e.e());
            monitorStruct.setAction(Constant.ACTION_QUERY_VENDOR_LIST);
            return monitorStruct;
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

    public static /* synthetic */ void a(VendorSdkInfoManager vendorSdkInfoManager, MonitorStruct monitorStruct) {
        try {
            vendorSdkInfoManager.a(monitorStruct);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(VendorSdkInfoManager vendorSdkInfoManager, String str) {
        try {
            vendorSdkInfoManager.storeVendorConfigsBySceneCodeToDisk(str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void a(final MonitorStruct monitorStruct) {
        try {
            ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        VendorSdkInfoManager.d(VendorSdkInfoManager.this).a(VendorSdkInfoManager.c(VendorSdkInfoManager.this).a(monitorStruct), 2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void a(String[] strArr) {
        if (strArr == null) {
            return;
        }
        try {
            if (strArr.length >= 8) {
                String str = strArr[6];
                this.f37230c = str;
                this.f37232e.a(str);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void a(String[] strArr, SparseArray<VendorConfig> sparseArray) {
        if (strArr != null) {
            try {
                if (strArr.length >= 6 && sparseArray != null) {
                    for (int i10 = 0; i10 < 3; i10++) {
                        VendorConfig vendorConfig = new VendorConfig();
                        int i11 = i10 * 2;
                        vendorConfig.setVendorAccessId(strArr[i11]);
                        vendorConfig.setVendorAccessSecret(strArr[i11 + 1]);
                        if (i10 == 0) {
                            vendorConfig.setVendorKey(Constant.VENDOR_CMCC);
                            sparseArray.put(1, vendorConfig);
                        } else if (i10 == 1) {
                            vendorConfig.setVendorKey(Constant.VENDOR_CUCC);
                            sparseArray.put(2, vendorConfig);
                        } else if (i10 == 2) {
                            vendorConfig.setVendorKey(Constant.VENDOR_CTCC);
                            sparseArray.put(3, vendorConfig);
                        }
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
    }

    public static /* synthetic */ String b(VendorSdkInfoManager vendorSdkInfoManager) {
        try {
            return vendorSdkInfoManager.f37230c;
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

    private void b(String[] strArr) {
        if (strArr == null) {
            return;
        }
        try {
            if (strArr.length >= 10) {
                this.f37231d = strArr[9];
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ d c(VendorSdkInfoManager vendorSdkInfoManager) {
        try {
            return vendorSdkInfoManager.f37232e;
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

    public static /* synthetic */ com.mobile.auth.q.a d(VendorSdkInfoManager vendorSdkInfoManager) {
        try {
            return vendorSdkInfoManager.f37234g;
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

    @SafeProtector
    private native void loadVendorConfigsBySceneCodeFromDisk(String str);

    @SafeProtector
    private native void storeVendorConfigsBySceneCodeToDisk(String str);

    public VendorConfig a(int i10) {
        try {
            VendorConfig vendorConfig = this.f37229b.get(i10);
            return vendorConfig != null ? vendorConfig : this.f37228a.get(i10);
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

    public String a(boolean z10) {
        if (z10) {
            return "SceneCode";
        }
        try {
            String str = this.f37230c;
            return str == null ? UUID.randomUUID().toString() : str;
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

    public void a(String str, final RequestCallback<Void, String> requestCallback, e eVar) {
        if (requestCallback == null || eVar == null) {
            return;
        }
        try {
            final MonitorStruct a10 = a(str);
            eVar.a(new e.a() { // from class: com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager.2
                @Override // com.mobile.auth.gatewayauth.manager.e.a
                public void a(String str2, String str3) {
                    try {
                        a10.setEndTime(System.currentTimeMillis());
                        a10.setSuccess(false);
                        a10.setTopTraceId(str3);
                        a10.setFailRet(str2);
                        VendorSdkInfoManager.a(VendorSdkInfoManager.this, a10);
                        requestCallback.onError(str2);
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                @Override // com.mobile.auth.gatewayauth.manager.e.a
                public void a(String str2, String str3, SparseArray<VendorConfig> sparseArray) {
                    if (sparseArray != null) {
                        try {
                            if (sparseArray.size() > 0) {
                                synchronized (VendorSdkInfoManager.this) {
                                    for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                                        VendorSdkInfoManager.a(VendorSdkInfoManager.this).put(sparseArray.keyAt(i10), sparseArray.valueAt(i10));
                                    }
                                }
                                VendorSdkInfoManager vendorSdkInfoManager = VendorSdkInfoManager.this;
                                VendorSdkInfoManager.a(vendorSdkInfoManager, VendorSdkInfoManager.b(vendorSdkInfoManager));
                                a10.setEndTime(System.currentTimeMillis());
                                a10.setSuccess(true);
                                a10.setTopTraceId(str3);
                                VendorSdkInfoManager.a(VendorSdkInfoManager.this, a10);
                                requestCallback.onSuccess(null);
                                return;
                            }
                        } catch (Throwable th) {
                            try {
                                ExceptionProcessor.processException(th);
                                return;
                            } catch (Throwable th2) {
                                ExceptionProcessor.processException(th2);
                                return;
                            }
                        }
                    }
                    a(str2, str3);
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public boolean a() {
        try {
            return !TextUtils.isEmpty(this.f37230c);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public boolean a(final String str, final e eVar) {
        try {
            if (!b()) {
                try {
                    ExecutorManager.getInstance().scheduleFuture(new Runnable() { // from class: com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                final CountDownLatch countDownLatch = new CountDownLatch(1);
                                VendorSdkInfoManager.this.a(str, new RequestCallback<Void, String>() { // from class: com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager.1.1
                                    public void a(String str2) {
                                        try {
                                            countDownLatch.countDown();
                                        } catch (Throwable th) {
                                            try {
                                                ExceptionProcessor.processException(th);
                                            } catch (Throwable th2) {
                                                ExceptionProcessor.processException(th2);
                                            }
                                        }
                                    }

                                    public void a(Void r12) {
                                        try {
                                            countDownLatch.countDown();
                                        } catch (Throwable th) {
                                            try {
                                                ExceptionProcessor.processException(th);
                                            } catch (Throwable th2) {
                                                ExceptionProcessor.processException(th2);
                                            }
                                        }
                                    }

                                    @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                                    public /* synthetic */ void onError(String str2) {
                                        try {
                                            a(str2);
                                        } catch (Throwable th) {
                                            try {
                                                ExceptionProcessor.processException(th);
                                            } catch (Throwable th2) {
                                                ExceptionProcessor.processException(th2);
                                            }
                                        }
                                    }

                                    @Override // com.mobile.auth.gatewayauth.manager.RequestCallback
                                    public /* synthetic */ void onSuccess(Void r12) {
                                        try {
                                            a(r12);
                                        } catch (Throwable th) {
                                            try {
                                                ExceptionProcessor.processException(th);
                                            } catch (Throwable th2) {
                                                ExceptionProcessor.processException(th2);
                                            }
                                        }
                                    }
                                }, eVar);
                                try {
                                    countDownLatch.await(com.huawei.openalliance.ad.ipc.c.Code, TimeUnit.MILLISECONDS);
                                } catch (InterruptedException unused) {
                                }
                            } catch (Throwable th) {
                                try {
                                    ExceptionProcessor.processException(th);
                                } catch (Throwable th2) {
                                    ExceptionProcessor.processException(th2);
                                }
                            }
                        }
                    }).get(com.huawei.openalliance.ad.ipc.c.Code, TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                }
            }
            return b();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public boolean b() {
        try {
            if (this.f37229b.size() <= 0) {
                if (this.f37228a.size() <= 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public String c() {
        try {
            return this.f37230c;
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

    public boolean d() {
        return false;
    }

    @SafeProtector
    public native void setLocalVendorSdkInfo(String str);
}
