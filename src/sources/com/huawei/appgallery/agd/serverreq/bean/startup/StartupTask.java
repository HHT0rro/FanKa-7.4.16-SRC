package com.huawei.appgallery.agd.serverreq.bean.startup;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.common.utils.DeviceSession;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.appgallery.agd.serverreq.ServerAgent;
import com.huawei.appgallery.agd.serverreq.ServerReqLog;
import com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean;
import com.huawei.appgallery.agd.serverreq.bean.RequestBean;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallBack;
import com.huawei.appgallery.agd.serverreq.listener.IServerCallbackEx;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class StartupTask implements IServerCallBack {

    /* renamed from: a, reason: collision with root package name */
    public final BaseRequestBean f27521a;

    /* renamed from: b, reason: collision with root package name */
    public final IServerCallbackEx f27522b;

    public StartupTask(@NonNull BaseRequestBean baseRequestBean, @NonNull IServerCallbackEx iServerCallbackEx) {
        this.f27521a = baseRequestBean;
        this.f27522b = iServerCallbackEx;
    }

    public final Pair<Integer, String> a(int i10, int i11) {
        if (i10 == 3) {
            return Pair.create(4, "StartupResponse network abnormal");
        }
        if (i10 == 0 && i11 == 0) {
            return null;
        }
        return Pair.create(2, "StartupResponse failed, rtnCode: " + i11 + ", responseCode:" + i10);
    }

    public final Pair<Integer, String> b(@NonNull StartupRequest startupRequest) {
        int i10;
        String str;
        String serviceZone = DeviceSession.getSession().getServiceZone();
        ServerReqLog serverReqLog = ServerReqLog.LOG;
        serverReqLog.i("StartupTask", "StartupCallback, getHomeCountry(): " + serviceZone);
        startupRequest.setAccountZone_(serviceZone);
        startupRequest.setNeedServiceZone_(0);
        ResponseBean invokeServer = ServerAgent.invokeServer(startupRequest);
        serverReqLog.i("StartupTask", "recall front2 prePostResult " + invokeServer.getRtnCode_());
        if (invokeServer instanceof StartupResponse) {
            StartupResponse startupResponse = (StartupResponse) invokeServer;
            Pair<Integer, String> a10 = a(startupResponse.getResponseCode(), startupResponse.getRtnCode_());
            if (a10 != null) {
                return a10;
            }
            if (1 == startupResponse.getmLogin_() || 1 != startupResponse.getIsServiceZone_()) {
                HomeCountryUtils.setIsHaveCalibrationCountry(false);
                i10 = 1;
                str = "after country calibrated, recall front2 response success, but country is unsupported";
            } else {
                startupResponse.saveParams(startupRequest);
                i10 = 0;
                str = startupResponse.getSign_();
            }
        } else {
            i10 = 100;
            str = "recall start up request";
        }
        return Pair.create(i10, str);
    }

    public final Pair<Integer, String> c(@NonNull StartupRequest startupRequest, @NonNull StartupResponse startupResponse) {
        if (startupResponse.getServiceZone_() == null || startupResponse.getResponseType() == 0 || startupRequest.getNeedServiceZone_() != 1) {
            startupResponse.saveParams(startupRequest);
            return Pair.create(0, "");
        }
        HomeCountryUtils.setIsHaveCalibrationCountry(true);
        return h(startupRequest, startupResponse);
    }

    public final Pair<Integer, String> d(StartupRequest startupRequest, @NonNull StartupResponse startupResponse, boolean z10) {
        int i10;
        String str;
        if (z10) {
            return b(startupRequest);
        }
        if (1 == startupResponse.getmLogin_() || 1 != startupResponse.getIsServiceZone_()) {
            i10 = 1;
            str = "country is corrected, already unsupported";
        } else {
            startupResponse.saveParams(startupRequest);
            i10 = 0;
            str = startupResponse.getSign_();
        }
        return Pair.create(i10, str);
    }

    public final void e(Pair<Integer, String> pair, StartupResponse startupResponse) {
        if (((Integer) pair.first).intValue() != 0) {
            this.f27522b.onFail(((Integer) pair.first).intValue(), (String) pair.second);
        } else {
            this.f27521a.setSign(startupResponse.getSign_());
            this.f27522b.onResponse(ServerAgent.invokeServer(this.f27521a));
        }
    }

    public final Pair<Integer, String> f(@NonNull StartupRequest startupRequest, @NonNull StartupResponse startupResponse) {
        if (!StringUtils.equals(startupRequest.getAccountZone_(), HomeCountryUtils.getHomeCountryOfMedia()) || (1 != startupResponse.getmLogin_() && 1 == startupResponse.getIsServiceZone_())) {
            return c(startupRequest, startupResponse);
        }
        ServerReqLog.LOG.i("StartupTask", "Media's Country is unsupported");
        HomeCountryUtils.setHomeCountryOfMedia(null);
        HomeCountryUtils.setIsHaveCalibrationCountry(false);
        return b(StartupRequest.newInstance());
    }

    public final Pair<Integer, String> g(@NonNull StartupRequest startupRequest, @NonNull StartupResponse startupResponse) {
        Pair<Integer, String> a10 = a(startupResponse.getResponseCode(), startupResponse.getRtnCode_());
        return a10 != null ? a10 : f(startupRequest, startupResponse);
    }

    public final Pair<Integer, String> h(StartupRequest startupRequest, @NonNull StartupResponse startupResponse) {
        boolean z10;
        String serviceZone_ = startupResponse.getServiceZone_();
        if (TextUtils.isEmpty(serviceZone_)) {
            z10 = false;
        } else {
            z10 = !HomeCountryUtils.getHomeCountry().equals(serviceZone_);
            DeviceSession.getSession().setServiceZone(serviceZone_);
        }
        ServerReqLog.LOG.i("StartupTask", "handleServiceZoneChange ServiceZone: " + serviceZone_ + ", isHomeCountryChange: " + z10);
        return d(startupRequest, startupResponse, z10);
    }

    @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallBack
    public void notifyResult(RequestBean requestBean, ResponseBean responseBean) {
    }

    @Override // com.huawei.appgallery.agd.serverreq.listener.IServerCallBack
    public void prePostResult(RequestBean requestBean, ResponseBean responseBean) {
        if (!(requestBean instanceof StartupRequest) || !(responseBean instanceof StartupResponse)) {
            this.f27522b.onFail(100, "");
            return;
        }
        StartupResponse startupResponse = (StartupResponse) responseBean;
        Pair<Integer, String> g3 = g((StartupRequest) requestBean, startupResponse);
        ServerReqLog serverReqLog = ServerReqLog.LOG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleResponse result ");
        sb2.append(g3.first);
        sb2.append(", ");
        sb2.append(TextUtils.isEmpty((CharSequence) g3.second) ? "sign is empty" : "sign is not empty");
        serverReqLog.i("StartupTask", sb2.toString());
        e(g3, startupResponse);
    }
}
