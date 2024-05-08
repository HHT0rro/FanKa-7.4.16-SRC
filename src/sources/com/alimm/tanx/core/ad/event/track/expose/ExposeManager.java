package com.alimm.tanx.core.ad.event.track.expose;

import android.content.Context;
import android.os.Looper;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxExposerUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import rc.a;
import rc.e;
import rc.f;
import vc.c;
import vc.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ExposeManager {
    public final IExposer tanxc_do;
    public final List<String> tanxc_if;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface UtArgsNames {
        public static final String creativeId = "creative_id";
        public static final String interactType = "interact_type";
        public static final String nameSpace = "tanx";
        public static final String pid = "pid";
        public static final String reqId = "req_id";
        public static final String sessionId = "session_id";
        public static final String templateId = "template_id";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class tanxc_do {
        public static volatile ExposeManager tanxc_do = new ExposeManager(0);
    }

    public /* synthetic */ ExposeManager(byte b4) {
        this();
    }

    public static boolean tanxc_if() {
        OrangeUtBean orangeUtBean;
        Boolean bool;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null || (orangeUtBean = orangeBean.ut) == null || (bool = orangeUtBean.utTanxExposerSwitch) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public ExposeManager() {
        this.tanxc_do = new com.alimm.tanx.core.ad.event.track.expose.tanxc_do();
        this.tanxc_if = new ArrayList();
    }

    public static ExposeManager tanxc_do() {
        return tanxc_do.tanxc_do;
    }

    public void tanxc_do(Context context) {
        e.a.f53381a.a(context, new a.C0814a(new vc.a() { // from class: u.b
            @Override // vc.a
            public final void a(d dVar, c cVar) {
                ExposeManager.this.tanxc_do(dVar, cVar);
            }
        }, new uc.a() { // from class: u.a
            @Override // uc.a
            public final void a(String str, int i10, Object obj, Object obj2, Object obj3, Map map) {
                ExposeManager.tanxc_do(str, i10, obj, obj2, obj3, map);
            }
        }).a(2001).h(true).c(true).b(rc.d.g(context), rc.d.b(context)).f(TanxCoreSdk.getConfig().isDebugMode()).d());
        e.a.f53381a.d(new sc.a() { // from class: com.alimm.tanx.core.ad.event.track.expose.ExposeManager.2
            @Override // sc.a
            public Looper tanxc_do() {
                return Looper.getMainLooper();
            }

            @Override // sc.a
            public void tanxc_if(int i10, String str, String str2, AdMonitorType adMonitorType, f fVar) {
                if (fVar != null) {
                    LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + fVar.toString() + ";msg=" + str + ";code=" + i10);
                    TanxExposerUt.sendMonitorFail(adMonitorType, str2, i10, str, fVar.a());
                }
            }

            @Override // sc.a
            public void tanxc_do(String str, AdMonitorType adMonitorType, f fVar) {
                if (fVar != null) {
                    LogUtils.d("ExposeManager", "onExposeSuccess:url=" + str + ";exposeParams=" + fVar.toString());
                    TanxExposerUt.sendMonitorSuc(adMonitorType, str, fVar.a());
                }
            }

            @Override // sc.a
            public void tanxc_do(int i10, String str, String str2, AdMonitorType adMonitorType, f fVar) {
                if (fVar != null) {
                    LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + fVar.toString() + ";msg=" + str + ";code=" + i10);
                    TanxExposerUt.sendMonitorFail(adMonitorType, str2, i10, str, fVar.a());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tanxc_do(d dVar, final c cVar) {
        if (dVar == null) {
            LogUtils.d("ExposeManager", "requestOptions is null");
            return;
        }
        RequestBean build = new RequestBean().setUrl(dVar.a()).build();
        build.setOverrideError(true);
        build.setTryAgainCount(dVar.b());
        NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() { // from class: com.alimm.tanx.core.ad.event.track.expose.ExposeManager.1
            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                LogUtils.d("ExposeManager", str2);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a(i10, str2);
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void succ(Object obj) {
                LogUtils.d("ExposeManager", JSON.toJSONString(obj));
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.tanxc_do();
                }
            }
        });
    }

    public static /* synthetic */ void tanxc_do(String str, int i10, Object obj, Object obj2, Object obj3, Map map) {
        LogUtils.d("ExposeManager", "userTracker:page=" + str + ";eventId=" + i10 + ";arg1=" + obj + ";args" + rc.d.e(map));
        if (tanxc_if()) {
            TanxBaseUt.track(str, null, null, i10, 0, (String) obj, (String) obj2, (String) obj3, map, null);
        } else {
            LogUtils.d("ExposeManager", "埋点开关关闭，终止上报");
        }
    }

    public void tanxc_do(BidInfo bidInfo, String str, String str2, AdMonitorType adMonitorType, List<tanxc_if> list, ExposeCallback exposeCallback) {
        if (OrangeManager.getInstance().getCommonSwitch("useNewExposerSwitch")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UtArgsNames.pid, str2);
                jSONObject.put(UtArgsNames.reqId, str);
                jSONObject.put(UtArgsNames.sessionId, bidInfo.getSessionId());
                jSONObject.put(UtArgsNames.templateId, bidInfo.getTemplateId());
                jSONObject.put(UtArgsNames.creativeId, bidInfo.getCreativeId());
                jSONObject.put(UtArgsNames.interactType, bidInfo.getInteractType2Int());
                f d10 = new f.a().b("tanx").f(str2).c(jSONObject).d();
                if (adMonitorType == AdMonitorType.EXPOSE) {
                    e.a.f53381a.b(bidInfo.getImpTrackUrl(), d10);
                } else if (adMonitorType == AdMonitorType.CLICK) {
                    e.a.f53381a.e(bidInfo.getClickTrackUrl(), d10);
                }
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        tanxc_do(bidInfo, list, exposeCallback);
    }

    public void tanxc_do(IBidInfo iBidInfo, List<tanxc_if> list, final ExposeCallback exposeCallback) {
        if (iBidInfo != null && list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                final tanxc_if tanxc_ifVar = list.get(i10);
                if (tanxc_ifVar != null) {
                    String tanxc_do2 = tanxc_ifVar.tanxc_do();
                    if (tanxc_ifVar.tanxc_int()) {
                        if (!tanxc_ifVar.tanxc_for() && !tanxc_ifVar.tanxc_try() && !this.tanxc_if.contains(tanxc_do2)) {
                            this.tanxc_if.add(tanxc_do2);
                        }
                    }
                    this.tanxc_do.onExpose(tanxc_ifVar.tanxc_if(), tanxc_do2, new ExposeCallback() { // from class: com.alimm.tanx.core.ad.event.track.expose.ExposeManager.3
                        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
                        public void onFail(int i11, String str, String str2) {
                            ExposeManager.this.tanxc_if.remove(str2);
                            tanxc_ifVar.tanxc_new();
                            ExposeCallback exposeCallback2 = exposeCallback;
                            if (exposeCallback2 != null) {
                                exposeCallback2.onFail(i11, str, str2);
                            }
                        }

                        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
                        public void onSucceed(int i11, String str) {
                            tanxc_ifVar.tanxc_do(true);
                            ExposeManager.this.tanxc_if.remove(str);
                            ExposeCallback exposeCallback2 = exposeCallback;
                            if (exposeCallback2 != null) {
                                exposeCallback2.onSucceed(i11, str);
                            }
                        }

                        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
                        public void send(String str) {
                            ExposeCallback exposeCallback2 = exposeCallback;
                            if (exposeCallback2 != null) {
                                exposeCallback2.send(str);
                            }
                        }
                    });
                }
            }
            return;
        }
        String str = "";
        String str2 = iBidInfo == null ? " bidInfo == null" : "";
        if (list == null) {
            str2 = str2 + " monitorInfoList == null";
        } else if (list.size() <= 0) {
            str2 = str2 + " monitorInfoList size <= 0";
        } else {
            str = list.toString();
        }
        if (exposeCallback != null) {
            exposeCallback.onFail(UtErrorCode.IMP_URL_ERROR.getIntCode(), str2, str);
        }
    }
}
