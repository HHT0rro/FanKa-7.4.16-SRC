package com.tencent.liteav.videobase.utils;

import java.util.LinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<Runnable> f43489a = new LinkedList<>();

    public final void a(Runnable runnable) {
        synchronized (this.f43489a) {
            this.f43489a.add(runnable);
        }
    }

    public final void a() {
        LinkedList linkedList;
        synchronized (this.f43489a) {
            if (this.f43489a.isEmpty()) {
                linkedList = null;
            } else {
                linkedList = new LinkedList(this.f43489a);
                this.f43489a.clear();
            }
        }
        while (linkedList != null && !linkedList.isEmpty()) {
            ((Runnable) linkedList.removeFirst()).run();
        }
    }
}
