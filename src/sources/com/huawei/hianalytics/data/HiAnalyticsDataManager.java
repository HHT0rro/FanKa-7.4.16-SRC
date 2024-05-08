package com.huawei.hianalytics.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.c;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.h0;
import com.huawei.hianalytics.i0;
import com.huawei.hianalytics.j0;
import com.huawei.hianalytics.l;
import com.huawei.hianalytics.l0;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.m;
import com.huawei.hianalytics.o;
import com.huawei.hianalytics.process.impl.HAImpl;
import com.huawei.hianalytics.util.DeviceUtil;
import com.huawei.hianalytics.y;
import com.huawei.hianalytics.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HiAnalyticsDataManager {
    public Context mContext;
    public static final String TAG = LogTag.get(HiAnalyticsDataManager.class, new Class[0]);
    public static final String[] BLACK_TAGS = {"ABTesting", "_default_config_tag"};
    public static HiAnalyticsDataManager managerImpl = null;
    public static final Object OBJECT_LOCK = new Object();
    public static final Object REFRESH_LOCK = new Object();
    public ConcurrentHashMap<String, HAImpl> instanceMap = new ConcurrentHashMap<>();
    public y instanceEx = null;

    public static HiAnalyticsDataManager getInstance() {
        if (managerImpl == null) {
            syncInit();
        }
        return managerImpl;
    }

    public static synchronized void syncInit() {
        synchronized (HiAnalyticsDataManager.class) {
            if (managerImpl == null) {
                managerImpl = new HiAnalyticsDataManager();
            }
        }
    }

    public void clearCachedData() {
        String str = TAG;
        HiLog.i(str, "clearCachedData() is execute.");
        if (this.mContext == null) {
            HiLog.sw(str, "clearCachedData() sdk is not init");
            return;
        }
        if (l0.ijk.lmn()) {
            HiLog.i(str, "HiAnalyticsDataManager.clearCachedData() All Tags is execute.");
            if (getInstanceSize() > 0) {
                Iterator<HAImpl> iterator2 = this.instanceMap.values().iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().getFrameworkInstance().clearCacheDataByTag();
                }
            }
        }
    }

    public void clearDataByTag(String str) {
        if (this.mContext == null) {
            HiLog.sw(TAG, "clearDataByTag() sdk is not init.TAG: " + str);
            return;
        }
        HiLog.i(TAG, "HiAnalyticsDataManager.clearDataByTag is execute.TAG: " + str);
        getInstanceByTag(str).getFrameworkInstance().clearCacheDataByTag();
    }

    public String createUUID(Context context) {
        if (context == null) {
            HiLog.sw(TAG, "createUUID context is null");
            return "";
        }
        return l.ghi(context);
    }

    public List<String> getAllTags() {
        return new ArrayList(this.instanceMap.h());
    }

    public boolean getInitFlag(String str) {
        if (str == null) {
            HiLog.sw(TAG, "getInitFlag() tag Can't be null.");
            return false;
        }
        HiLog.i(TAG, "HiAnalyticsDataManager.getInitFlag(String tag) is execute.TAG: " + str);
        if ("_instance_ex_tag".equals(str)) {
            return this.instanceEx != null;
        }
        return this.instanceMap.containsKey(str);
    }

    public HAImpl getInstanceByTag(String str) {
        if (str == null) {
            HiLog.sw(TAG, "getInstanceByTag() tag Can't be null.");
            return null;
        }
        if (this.instanceMap.containsKey(str)) {
            HiLog.d(TAG, "getInstanceByTag(): TAG: " + str + " found.TAG: " + str);
            return this.instanceMap.get(str);
        }
        HiLog.sw(TAG, "getInstanceByTag(): TAG: " + str + " not found.TAG: " + str);
        return null;
    }

    public y getInstanceEx() {
        return this.instanceEx;
    }

    public int getInstanceSize() {
        return this.instanceMap.size();
    }

    public int getPresetInstanceSize() {
        int i10 = 0;
        for (String str : BLACK_TAGS) {
            if (this.instanceMap.containsKey(str)) {
                i10++;
            }
        }
        return i10;
    }

    public void init(Context context) {
        synchronized (OBJECT_LOCK) {
            if (this.mContext != null) {
                HiLog.i(TAG, "SDK has been initialized,But an instance can be registered!");
                return;
            }
            this.mContext = context;
            c.klm().lmn.f28748e = context;
            c.klm().lmn.ghi = context.getPackageName();
            c.klm().lmn.lmn = DeviceUtil.getEmuiVersion();
            m lmn = m.lmn();
            if (lmn.lmn == null) {
                lmn.lmn = context;
            }
            c.klm().lmn.f28751h = h0.lmn(context);
            String appVer = DeviceUtil.getAppVer(context);
            c.klm().lmn.def = appVer;
            if (l0.ijk.lmn()) {
                String lmn2 = j0.lmn("global_v2", "app_ver", "");
                j0.klm("global_v2", "app_ver", appVer);
                c.klm().lmn.cde = lmn2;
                if (appVer.equals(lmn2)) {
                    return;
                }
                c.klm().lmn.f28750g = System.currentTimeMillis();
                return;
            }
            HiLog.i(TAG, "userManager.isUserUnlocked() == false");
        }
    }

    public boolean isBlackTag(String str) {
        for (String str2 : BLACK_TAGS) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public HAImpl registerInstance(String str, HAImpl hAImpl) {
        HAImpl putIfAbsent = this.instanceMap.putIfAbsent(str, hAImpl);
        c klm = c.klm();
        HAImpl hAImpl2 = this.instanceMap.get(str);
        Objects.requireNonNull(hAImpl2);
        z zVar = hAImpl2.instData;
        Objects.requireNonNull(klm);
        c.klm.put(str, zVar);
        return putIfAbsent;
    }

    public void registerInstanceEx(y yVar) {
        this.instanceEx = yVar;
        this.instanceMap.put("_instance_ex_tag", yVar);
        c klm = c.klm();
        z zVar = yVar.instData;
        Objects.requireNonNull(klm);
        c.klm.put("_instance_ex_tag", zVar);
    }

    public void setAppid(String str) {
        String str2 = TAG;
        HiLog.i(str2, "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.mContext;
        if (context == null) {
            HiLog.sw(str2, "sdk is not init");
        } else {
            c.klm().lmn.fgh = i0.lmn("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName());
        }
    }

    public void setCustomPkgName(String str) {
        if (this.mContext != null) {
            HiLog.sw(TAG, "sdk is init,Must before init");
        } else if (!TextUtils.isEmpty(str) && str.length() <= 256) {
            o.lmn(str);
        } else {
            HiLog.w(TAG, "customPkgName check failed");
        }
    }

    public void setSPCacheSize(int i10) {
        String str = TAG;
        HiLog.i(str, "HiAnalyticsDataManager.setSPCacheSize is execute.");
        if (this.mContext == null) {
            HiLog.sw(str, "sdk is not init");
        } else {
            o.lmn(i0.lmn(i10, 10, 5));
        }
    }

    public void setUnusualDataIgnored(boolean z10) {
        HiLog.i(TAG, "HiAnalyticsDataManager.setHandlerAbnormalData is execute.");
        o.lmn(z10);
    }
}
