package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BindResolveClients {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f29701b = new Object();

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ResolveClientBean> f29702a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final BindResolveClients f29703a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return b.f29703a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (f29701b) {
            contains = this.f29702a.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (f29701b) {
            ListIterator<ResolveClientBean> listIterator = this.f29702a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f29702a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f29701b) {
            if (!this.f29702a.contains(resolveClientBean)) {
                this.f29702a.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f29701b) {
            if (this.f29702a.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.f29702a.listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    } else if (resolveClientBean.equals(listIterator.next())) {
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (f29701b) {
            this.f29702a.clear();
        }
    }

    private BindResolveClients() {
        this.f29702a = new ArrayList<>();
    }
}
