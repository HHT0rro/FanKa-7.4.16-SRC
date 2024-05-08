package com.alimm.tanx.core.ut.core;

import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.request.C;
import com.alimm.tanx.core.ut.bean.UtBean;
import com.alimm.tanx.core.ut.bean.UtResponse;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UtRequest {
    public static final String TAG = "UtRequest";
    public static volatile UtRequest instance;
    public volatile ConcurrentHashMap<Integer, UtBean> ingConcurrentHashMap = new ConcurrentHashMap<>();
    public AtomicLong atomicLong = new AtomicLong(0);

    public static UtRequest getInstance() {
        if (instance == null) {
            synchronized (UtRequest.class) {
                if (instance == null) {
                    instance = new UtRequest();
                }
            }
        }
        return instance;
    }

    private void removeIngMap(UtBean utBean) {
        try {
            if (utBean != null) {
                UtBean utBean2 = this.ingConcurrentHashMap.get(Integer.valueOf(utBean.hashCode()));
                LogUtils.d(TAG, "UserReport :ingListLinkedHashMap -remove前 ->size():" + this.ingConcurrentHashMap.size() + "->ingConcurrentHashMap.get()->" + (utBean2 != null ? utBean2.toString() : ""));
                this.ingConcurrentHashMap.remove(Integer.valueOf(utBean.hashCode()));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("UserReport :ingListLinkedHashMap-remove后->size():");
                sb2.append(this.ingConcurrentHashMap.size());
                LogUtils.d(TAG, sb2.toString());
                return;
            }
            LogUtils.d(TAG, "UserReport :ingListLinkedHashMap-remove 过程为空");
        } catch (Exception e2) {
            LogUtils.e(IUserReport.TAG, e2);
        }
    }

    private boolean request(UtBean utBean, boolean z10) {
        if (!z10) {
            this.ingConcurrentHashMap.put(Integer.valueOf(utBean.hashCode()), utBean);
            LogUtils.d(TAG, "request ->ingListLinkedHashMap->size():" + this.ingConcurrentHashMap.size());
        }
        RequestBean build = new RequestBean().setUrl(C.getUtUrl()).build();
        build.setOverrideError(true);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        build.setHeads(hashMap);
        LogUtils.d(TAG, utBean.toString());
        build.setJson(JSON.toJSONString(utBean));
        LogUtils.d("ut-request-count:", "isCacheRequest:" + z10);
        UtResponse utResponse = (UtResponse) NetWorkManager.getInstance().sendSyncHttpPost2Gzip(build, UtResponse.class);
        if (utResponse != null) {
            boolean z11 = utResponse.status == 0;
            if (z11) {
                LogUtils.d(TAG, "UserReport :succ");
                if (!z10) {
                    removeIngMap(utBean);
                }
                LogUtils.d(TAG, "UserReport :succ ->上报成功->:" + this.atomicLong.incrementAndGet());
            } else {
                if (!z10) {
                    LogUtils.d(TAG, "UserReport :error ");
                    removeIngMap(utBean);
                    CacheUserReportManager.getInstance().saveFile(build.getJson());
                }
                LogUtils.d(TAG, "UserReport :error ->上报失败->:" + this.atomicLong.incrementAndGet() + " 服务器错误信息：" + utResponse.msg);
            }
            return z11;
        }
        LogUtils.e(TAG, "UserReport :error ->上报失败->:服务器返回空UtResponse reqId:" + utBean.reqId);
        if (!z10) {
            removeIngMap(utBean);
            CacheUserReportManager.getInstance().saveFile(build.getJson());
        }
        return false;
    }

    public void destroy() {
        try {
            for (Map.Entry<Integer, UtBean> entry : this.ingConcurrentHashMap.entrySet()) {
                LogUtils.d(TAG, "UserReport :取出catchFileLinkedHashMap元素，启动上报");
                CacheUserReportManager.getInstance().saveFile(entry.getValue());
            }
            this.ingConcurrentHashMap.clear();
        } catch (Exception e2) {
            LogUtils.e(IUserReport.TAG, e2);
        }
    }

    public boolean requestCache(File file) {
        try {
            return request((UtBean) JSON.parseObject(FileUtils.getStrFromFile(file), UtBean.class), true);
        } catch (Exception e2) {
            LogUtils.e(IUserReport.TAG, e2);
            return false;
        }
    }

    public boolean requestRealTime(UtBean utBean) {
        return request(utBean, false);
    }

    public boolean requestCache(UtBean utBean) {
        try {
            return request(utBean, true);
        } catch (Exception e2) {
            LogUtils.e(IUserReport.TAG, e2);
            return false;
        }
    }
}
