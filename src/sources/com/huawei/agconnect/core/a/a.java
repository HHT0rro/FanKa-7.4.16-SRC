package com.huawei.agconnect.core.a;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import z8.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a extends z8.a {

    /* renamed from: b, reason: collision with root package name */
    public static final List<a.InterfaceC0846a> f27207b = new CopyOnWriteArrayList();

    public static void a() {
        Iterator<a.InterfaceC0846a> it = f27207b.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }
}
