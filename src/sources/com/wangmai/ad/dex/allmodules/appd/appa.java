package com.wangmai.ad.dex.allmodules.appd;

import android.text.TextUtils;
import appa.appa.appf.appd;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.ad.dex.allmodules.bean.RequestBean;
import com.wangmai.common.utils.ConstantInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AdCacheManage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa {

    /* renamed from: appa, reason: collision with root package name */
    private static appa f46776appa;
    public static volatile Map<String, List<DemandEntityHandle>> appb = new ConcurrentHashMap();

    private appa() {
    }

    public static appa appa() {
        if (f46776appa == null) {
            synchronized (appa.class) {
                if (f46776appa == null) {
                    f46776appa = new appa();
                }
            }
        }
        return f46776appa;
    }

    private List<DemandEntityHandle> appb(String str, String str2, String str3) {
        synchronized (appa.class) {
            try {
                List<DemandEntityHandle> list = appb.get(str);
                ArrayList arrayList = new ArrayList();
                appd.appa("AdCacheManage", "[" + str3 + "] 查询当前代码位[" + str + "] 下所有需求方缓存集：" + ((Object) list));
                if (TextUtils.isEmpty(str2) || list == null) {
                    return list;
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (list.get(size).getDemandClassType().equals(str2)) {
                        arrayList.add(list.get(size));
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                appd.appe("AdCacheManage", "queryAllCache exception:" + th.toString());
                return null;
            }
        }
    }

    public List<DemandEntityHandle> appa(String str, String str2) {
        List<DemandEntityHandle> appb2;
        synchronized (appa.class) {
            try {
                appb(str, str2);
                appb2 = appb(str, null, str2);
            } catch (Throwable th) {
                appd.appe("AdCacheManage", "queryAllValidCache exception:" + th.toString());
                return null;
            }
        }
        return appb2;
    }

    public RequestBean.DataBean.SdkBean appa(String str, String str2, String str3) {
        RequestBean.DataBean.SdkBean sdkBean;
        System.currentTimeMillis();
        synchronized (appa.class) {
            sdkBean = new RequestBean.DataBean.SdkBean();
            sdkBean.setPersonal_recommend(ConstantInfo.isEnablePersonalized() ? 0 : 1);
            try {
                appb(str, str3);
                List<DemandEntityHandle> list = appb.get(str);
                appd.appa("AdCacheManage", "[" + str3 + "] 查询当前代码位[" + str + "] 下所有需求方缓存集：" + ((Object) list));
                if (!TextUtils.isEmpty(str2) && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (DemandEntityHandle demandEntityHandle : list) {
                        if (demandEntityHandle.getDemandClassType().equals(str2)) {
                            RequestBean.DataBean.SdkBean.AdCache adCache = new RequestBean.DataBean.SdkBean.AdCache();
                            adCache.setCrid(demandEntityHandle.getCrid());
                            adCache.setThirdSlotIdKey(demandEntityHandle.getDemandSlotIdKey());
                            adCache.setCacheTime((int) ((demandEntityHandle.getCacheTime() / 1000) / 60));
                            adCache.setExpireTime(demandEntityHandle.getExpireTime());
                            arrayList.add(adCache);
                        }
                    }
                    sdkBean.setAdCacheList(arrayList);
                }
            } catch (Throwable th) {
                appd.appe("AdCacheManage", "queryAllValidAdFromCache error:" + th.toString());
            }
        }
        return sdkBean;
    }

    public void appb(String str, String str2) {
        synchronized (appa.class) {
            try {
                List<DemandEntityHandle> list = appb.get(str);
                if (list != null && list.size() > 0) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        if (list.get(size).isExpired()) {
                            appd.appa("AdCacheManage", "[" + str2 + "] 移除过期缓存=" + str + "\t" + list.get(size).getDemandProcesserKey());
                            list.get(size).onDestroy();
                            list.remove(size);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public void appa(String str, int i10) {
        synchronized (appa.class) {
            try {
                List<DemandEntityHandle> list = appb.get(str);
                if (list != null && list.size() > 0) {
                    Iterator<DemandEntityHandle> iterator2 = list.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        DemandEntityHandle next = iterator2.next();
                        if (next.getDemandProcesserKey() == i10) {
                            appd.appa("AdCacheManage", "已曝光，移除缓存(onDestroy中销毁)，demandProcesserKey=" + i10);
                            list.remove(next);
                            break;
                        }
                    }
                    appd.appa("AdCacheManage", "当前剩余可用缓存大小", Integer.valueOf(list.size()), list);
                }
            } finally {
            }
        }
    }

    public void appa(String str, List<DemandEntityHandle> list, String str2) {
        synchronized (appa.class) {
            try {
            } catch (Throwable th) {
                appd.appe("AdCacheManage", "replaceAllCache exception:" + th.toString());
            }
            if (list == null) {
                appd.appa("AdCacheManage", "无效的缓存集");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<DemandEntityHandle> arrayList = new ArrayList(list);
            for (DemandEntityHandle demandEntityHandle : arrayList) {
                if (demandEntityHandle.getCacheNum() <= 0) {
                    demandEntityHandle.setCreateTime(currentTimeMillis);
                }
                demandEntityHandle.setCacheNum(demandEntityHandle.getCacheNum() + 1);
            }
            appb.put(str, arrayList);
        }
    }
}
