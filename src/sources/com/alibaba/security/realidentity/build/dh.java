package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import com.alibaba.security.realidentity.oss.internal.OSSRetryType;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: OSSRetryHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dh {

    /* renamed from: a, reason: collision with root package name */
    public int f3459a;

    /* compiled from: OSSRetryHandler.java */
    /* renamed from: com.alibaba.security.realidentity.build.dh$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3460a;

        static {
            int[] iArr = new int[OSSRetryType.values().length];
            f3460a = iArr;
            try {
                iArr[OSSRetryType.OSSRetryTypeShouldRetry.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public dh(int i10) {
        this.f3459a = i10;
    }

    private void a(int i10) {
        this.f3459a = i10;
    }

    private OSSRetryType a(Exception exc, int i10) {
        if (i10 >= this.f3459a) {
            return OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
        if (exc instanceof ClientException) {
            if (((ClientException) exc).isCanceledException().booleanValue()) {
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            Exception exc2 = (Exception) exc.getCause();
            if ((exc2 instanceof InterruptedIOException) && !(exc2 instanceof SocketTimeoutException)) {
                cd.d("[shouldRetry] - is interrupted!");
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            if (exc2 instanceof IllegalArgumentException) {
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            cd.b("shouldRetry - " + exc.toString());
            exc.getCause().printStackTrace();
            return OSSRetryType.OSSRetryTypeShouldRetry;
        }
        if (exc instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) exc;
            if (serviceException.getErrorCode() != null && serviceException.getErrorCode().equalsIgnoreCase("RequestTimeTooSkewed")) {
                return OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry;
            }
            if (serviceException.getStatusCode() >= 500) {
                return OSSRetryType.OSSRetryTypeShouldRetry;
            }
            return OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
        return OSSRetryType.OSSRetryTypeShouldNotRetry;
    }

    private static long a(int i10, OSSRetryType oSSRetryType) {
        if (AnonymousClass1.f3460a[oSSRetryType.ordinal()] != 1) {
            return 0L;
        }
        return ((long) Math.pow(2.0d, i10)) * 200;
    }
}
