package cn.shuzilm.core;

import android.content.Context;
import cn.shuzilm.core.IDUService;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class v extends IDUService.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DUService f1796a;

    public v(DUService dUService) {
        this.f1796a = dUService;
    }

    @Override // cn.shuzilm.core.IDUService
    public void getOpenAnmsIDAsyn(DUListener dUListener) {
        Context context;
        try {
            context = this.f1796a.f1704a;
            DUHelper.ZVTFJRAAsyn(context, dUListener);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.shuzilm.core.IDUService
    public String getQueryID(String str, String str2) {
        Context context;
        try {
            context = this.f1796a.f1704a;
            return DUHelper.getQueryID(context, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // cn.shuzilm.core.IDUService
    public Map getQueryIDAsyn(String str, String str2, DUListener dUListener) {
        Context context;
        HashMap hashMap = new HashMap();
        try {
            context = this.f1796a.f1704a;
            return DUHelper.getQueryIDDUCallback(context, str, str2, 1, dUListener);
        } catch (Exception e2) {
            e2.printStackTrace();
            return hashMap;
        }
    }

    @Override // cn.shuzilm.core.IDUService
    public void go(String str, String str2) {
        Context context;
        try {
            context = this.f1796a.f1704a;
            DUHelper.go(context, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.shuzilm.core.IDUService
    public Map onEvent(String str, String str2, String str3) {
        Context context;
        HashMap hashMap = new HashMap();
        try {
            context = this.f1796a.f1704a;
            return DUHelper.onEventDUCallback(context, str, str2, str3, 0, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return hashMap;
        }
    }

    @Override // cn.shuzilm.core.IDUService
    public Map onEventAsyn(String str, String str2, String str3, DUListener dUListener) {
        Context context;
        HashMap hashMap = new HashMap();
        try {
            context = this.f1796a.f1704a;
            return DUHelper.onEventDUCallback(context, str, str2, str3, 1, dUListener);
        } catch (Exception e2) {
            e2.printStackTrace();
            return hashMap;
        }
    }

    @Override // cn.shuzilm.core.IDUService
    public void report(String str, String str2) {
        Context context;
        try {
            context = this.f1796a.f1704a;
            DUHelper.report(context, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.shuzilm.core.IDUService
    public int setConfig(String str, String str2) {
        try {
            return DUHelper.setConfig(str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // cn.shuzilm.core.IDUService
    public int setData(String str, String str2) {
        try {
            return DUHelper.setData(str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
