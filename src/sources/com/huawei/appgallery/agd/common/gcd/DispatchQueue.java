package com.huawei.appgallery.agd.common.gcd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class DispatchQueue {
    public static final DispatchMainQueue MAIN = new DispatchMainQueue();
    public static final DispatchWorkQueue GLOBAL = new DispatchWorkQueue("GlobalQueue");
}
