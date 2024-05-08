package com.irisdt;

import android.content.Context;
import com.irisdt.biz.Abtest;
import com.irisdt.biz.Apm;
import com.irisdt.biz.Client;
import com.irisdt.biz.Common;
import com.irisdt.biz.Dau;
import com.irisdt.biz.Event;
import com.irisdt.biz.Page;
import com.irisdt.db.DBManager;
import com.irisdt.grpc.ConnectManager;
import com.irisdt.grpc.connect.PerfManager;
import com.irisdt.util.ThreadManager;
import com.irisdt.util.UploadTaskHandler;
import com.irisdt.util.Utils;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Irisdt {
    private static final AtomicBoolean inited = new AtomicBoolean(false);

    private Irisdt() {
    }

    public static void destroy() {
        StatConfig.setEnable(false);
        Utils.removeAllUIRunnable();
        UploadTaskHandler.getInstance().stop();
    }

    public static Abtest getAbtest() {
        if (isInited()) {
            return Abtest.getInstance();
        }
        return null;
    }

    public static Apm getApm() {
        if (isInited()) {
            return Apm.getInstance();
        }
        return null;
    }

    public static Client getClient() {
        if (isInited()) {
            return Client.getInstance();
        }
        return null;
    }

    public static Common getCommon() {
        if (isInited()) {
            return Common.getInstance();
        }
        return null;
    }

    public static Dau getDau() {
        if (isInited()) {
            return Dau.getInstance();
        }
        return null;
    }

    public static Event getEvent() {
        if (isInited()) {
            return Event.getInstance();
        }
        return null;
    }

    public static Page getPage() {
        if (isInited()) {
            return Page.getInstance();
        }
        return null;
    }

    public static synchronized void init(Context context, String str, int i10, OnHostNameResolver onHostNameResolver) {
        synchronized (Irisdt.class) {
            AtomicBoolean atomicBoolean = inited;
            if (atomicBoolean.get()) {
                return;
            }
            if (context == null) {
                return;
            }
            StatConfig.setEnable(true);
            StatConfig.setAppContext(context.getApplicationContext());
            ThreadManager.createThreadPool();
            ConnectManager.createChannel(str, i10, onHostNameResolver);
            DBManager.getInstance().init(context);
            atomicBoolean.set(true);
        }
    }

    public static boolean isInited() {
        return inited.get();
    }

    public static void setEnable(boolean z10) {
        StatConfig.setEnable(z10);
    }

    public static void setLogEnable(boolean z10) {
        StatConfig.setLogEnable(z10);
    }

    public static void setPerfEnable(boolean z10) {
        PerfManager.getInstance().setEnable(z10);
    }
}
