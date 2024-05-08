package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.build.ft;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import com.alibaba.security.realidentity.oss.model.OSSRequest;

/* compiled from: OSSCompletedCallback.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface bx<T1 extends OSSRequest, T2 extends ft> {
    void a(T1 t12, T2 t2);

    void a(T1 t12, ClientException clientException, ServiceException serviceException);
}
