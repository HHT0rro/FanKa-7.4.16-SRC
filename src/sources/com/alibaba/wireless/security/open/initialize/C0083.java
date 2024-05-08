package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.ApmMonitorAdapter;
import com.alibaba.wireless.security.framework.C0059;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.framework.SGApmMonitorManager;
import com.alibaba.wireless.security.framework.utils.C0049;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.alibaba.wireless.security.open.initialize.б, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0083 {

    /* renamed from: а, reason: contains not printable characters */
    private Set<IInitializeComponent.IInitFinishListener> f184;

    /* renamed from: б, reason: contains not printable characters */
    private Object f185;

    /* renamed from: в, reason: contains not printable characters */
    private String f186;

    /* renamed from: г, reason: contains not printable characters */
    private ISGPluginManager f187;

    /* renamed from: д, reason: contains not printable characters */
    public boolean f188;

    /* renamed from: com.alibaba.wireless.security.open.initialize.б$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0084 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ Context f189;

        /* renamed from: б, reason: contains not printable characters */
        public final /* synthetic */ String f190;

        /* renamed from: в, reason: contains not printable characters */
        public final /* synthetic */ boolean f191;

        /* renamed from: г, reason: contains not printable characters */
        public final /* synthetic */ boolean f192;

        public RunnableC0084(Context context, String str, boolean z10, boolean z11) {
            this.f189 = context;
            this.f190 = str;
            this.f191 = z10;
            this.f192 = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C0083.this.m1951(this.f189, this.f190, this.f191, this.f192);
            } catch (SecException e2) {
                e2.printStackTrace();
                C0083.this.m1945();
            }
        }
    }

    public C0083() {
        this.f184 = new HashSet();
        this.f185 = new Object();
        this.f186 = null;
        this.f187 = null;
        this.f188 = false;
    }

    public C0083(String str) {
        this.f184 = new HashSet();
        this.f185 = new Object();
        this.f187 = null;
        this.f188 = false;
        this.f186 = str;
    }

    /* renamed from: а, reason: contains not printable characters */
    private void m1944(boolean z10) {
        for (IInitializeComponent.IInitFinishListener iInitFinishListener : this.f184) {
            if (z10) {
                iInitFinishListener.onSuccess();
            } else {
                iInitFinishListener.onError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: б, reason: contains not printable characters */
    public void m1945() {
        synchronized (this.f185) {
            Iterator<IInitializeComponent.IInitFinishListener> iterator2 = this.f184.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onError();
            }
        }
    }

    /* renamed from: в, reason: contains not printable characters */
    private void m1946() {
        for (IInitializeComponent.IInitFinishListener iInitFinishListener : this.f184) {
            if (iInitFinishListener instanceof IInitializeComponent.IInitFinishListenerV2) {
                ((IInitializeComponent.IInitFinishListenerV2) iInitFinishListener).onStart();
            }
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public ISGPluginManager m1947() {
        return this.f187;
    }

    /* renamed from: а, reason: contains not printable characters */
    public void m1948(Context context, String str, boolean z10, boolean z11) throws SecException {
        if (context == null) {
            throw new SecException(101);
        }
        new Thread(new RunnableC0084(context, str, z10, z11), "SGloadLibraryAsync").start();
    }

    /* renamed from: а, reason: contains not printable characters */
    public void m1949(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        if (iInitFinishListener != null) {
            synchronized (this.f185) {
                this.f184.add(iInitFinishListener);
            }
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public boolean m1950(Context context) throws SecException {
        return true;
    }

    /* renamed from: б, reason: contains not printable characters */
    public int m1951(Context context, String str, boolean z10, boolean z11) throws SecException {
        int i10;
        synchronized (this.f185) {
            if (!this.f188) {
                m1946();
                if (context == null) {
                    throw new SecException(101);
                }
                SGApmMonitorManager.getInstance().init(context);
                SGApmMonitorManager.getInstance().monitorStart("plugin");
                SGApmMonitorManager.getInstance().monitorStart("getInstance");
                SGApmMonitorManager.getInstance().monitorStartWithTimeout("firstBizRequest", 10000);
                long m1823 = C0049.m1823();
                ApmMonitorAdapter.jstageStart("main", "1");
                C0059 c0059 = new C0059();
                c0059.m1913(context, this.f186, str, z10, new Object[0]);
                SGApmMonitorManager.getInstance().setSGPluginManager(c0059);
                ApmMonitorAdapter.jstageEnd("main", "1");
                C0049.m1821("main", "pluginMgr.init", "", m1823);
                c0059.getPluginInfo(c0059.getMainPluginName());
                C0049.m1821("main", "getInstance", "", m1823);
                SGApmMonitorManager.getInstance().monitorEnd("getInstance");
                this.f187 = c0059;
                this.f188 = true;
                m1944(true);
            }
            i10 = !this.f188 ? 1 : 0;
        }
        return i10;
    }

    /* renamed from: б, reason: contains not printable characters */
    public void m1952(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        if (iInitFinishListener != null) {
            synchronized (this.f185) {
                this.f184.remove(iInitFinishListener);
            }
        }
    }
}
