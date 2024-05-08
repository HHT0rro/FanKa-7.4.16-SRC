package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.http.ok.Headers;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.realidentity.build.ft;
import com.alibaba.security.realidentity.oss.common.HttpMethod;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: OSSRequestTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gt<T extends ft> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    private dl<T> f3764a;

    /* renamed from: b, reason: collision with root package name */
    private dj f3765b;

    /* renamed from: c, reason: collision with root package name */
    private gr f3766c;

    /* renamed from: d, reason: collision with root package name */
    private RPHttpClient f3767d;

    /* renamed from: e, reason: collision with root package name */
    private dh f3768e;

    /* renamed from: f, reason: collision with root package name */
    private int f3769f = 0;

    /* compiled from: OSSRequestTask.java */
    /* renamed from: com.alibaba.security.realidentity.build.gt$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3770a;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            f3770a = iArr;
            try {
                iArr[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3770a[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3770a[HttpMethod.GET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3770a[HttpMethod.HEAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3770a[HttpMethod.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public gt(dj djVar, dl dlVar, gr grVar, int i10) {
        this.f3764a = dlVar;
        this.f3765b = djVar;
        this.f3766c = grVar;
        this.f3767d = grVar.f3757b;
        this.f3768e = new dh(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x012d A[Catch: Exception -> 0x026b, TryCatch #4 {Exception -> 0x026b, blocks: (B:4:0x0008, B:6:0x000e, B:7:0x0015, B:9:0x0030, B:11:0x0039, B:12:0x0046, B:13:0x0058, B:15:0x005e, B:17:0x0075, B:28:0x0191, B:145:0x00b6, B:146:0x00bc, B:147:0x00c2, B:150:0x00cd, B:152:0x00d8, B:156:0x012d, B:158:0x0133, B:159:0x0140, B:162:0x0164, B:163:0x017f, B:164:0x00ea, B:166:0x00ee, B:170:0x0107, B:171:0x010e, B:172:0x010f, B:174:0x0115, B:175:0x0122, B:177:0x0040, B:179:0x0263, B:180:0x026a), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x03a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x037b A[SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public T call() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.gt.call():com.alibaba.security.realidentity.build.ft");
    }

    private static dk a(dj djVar, Response response) {
        dk dkVar = new dk();
        dkVar.f3478b = djVar;
        dkVar.f3477a = response;
        HashMap hashMap = new HashMap();
        Headers headers = response.headers();
        for (int i10 = 0; i10 < headers.size(); i10++) {
            hashMap.put(headers.name(i10), headers.value(i10));
        }
        dkVar.a(hashMap);
        dkVar.f3479c = response.code();
        dkVar.a(response.body().contentLength());
        dkVar.a(response.body().byteStream());
        return dkVar;
    }
}
