package com.cupidapp.live.base.safe;

import com.cupidapp.live.AppApplication;
import com.cupidapp.live.profile.model.User;
import com.danlan.android.cognition.Cognition;
import com.danlan.android.cognition.collector.listener.DeviceIdCreateListener;
import com.danlan.android.cognition.collector.listener.DeviceInfoDependency;
import com.danlan.android.cognition.collector.listener.ExtraInfoFroAction;
import com.danlan.android.cognition.common.DeviceInfoConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: FingerprintHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f12183a = new c();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static String f12184b;

    /* compiled from: FingerprintHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements DeviceInfoDependency {
        @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
        @NotNull
        public Map<String, String> setApi() {
            HashMap hashMap = new HashMap();
            String API_UPLOAD = DeviceInfoConstant.API_UPLOAD;
            s.h(API_UPLOAD, "API_UPLOAD");
            hashMap.put(API_UPLOAD, "/passport/device");
            return hashMap;
        }

        @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
        @Nullable
        public Map<String, String> setHeaderData() {
            return null;
        }

        @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
        @NotNull
        public Map<String, String> setServerDomain() {
            HashMap hashMap = new HashMap();
            String SERVER_DOMAIN = DeviceInfoConstant.SERVER_DOMAIN;
            s.h(SERVER_DOMAIN, "SERVER_DOMAIN");
            hashMap.put(SERVER_DOMAIN, c.f12183a.e());
            return hashMap;
        }

        @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
        @Nullable
        public String setSpecialUserAgent() {
            return null;
        }

        @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
        @NotNull
        public Map<String, Object> setUserData() {
            String str;
            HashMap hashMap = new HashMap();
            String APP_NAME = DeviceInfoConstant.APP_NAME;
            s.h(APP_NAME, "APP_NAME");
            hashMap.put(APP_NAME, "finka");
            String CHANNEL = DeviceInfoConstant.CHANNEL;
            s.h(CHANNEL, "CHANNEL");
            com.cupidapp.live.base.network.a aVar = com.cupidapp.live.base.network.a.f11902a;
            hashMap.put(CHANNEL, aVar.r());
            String USERID = DeviceInfoConstant.USERID;
            s.h(USERID, "USERID");
            User X = g.f52734a.X();
            if (X == null || (str = X.userId()) == null) {
                str = "";
            }
            hashMap.put(USERID, str);
            String OAID = DeviceInfoConstant.OAID;
            s.h(OAID, "OAID");
            hashMap.put(OAID, aVar.o());
            String SMID = DeviceInfoConstant.SMID;
            s.h(SMID, "SMID");
            hashMap.put(SMID, e.f12185a.a());
            String DUID = DeviceInfoConstant.DUID;
            s.h(DUID, "DUID");
            hashMap.put(DUID, aVar.h());
            return hashMap;
        }
    }

    /* compiled from: FingerprintHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements DeviceIdCreateListener {
        @Override // com.danlan.android.cognition.collector.listener.DeviceIdCreateListener
        public void onInitializeDeviceId(int i10, int i11, @Nullable String str) {
            String str2 = c.f12184b;
            if ((str2 == null || str2.length() == 0) && i11 == 0) {
                if (str == null || str.length() == 0) {
                    return;
                }
                c cVar = c.f12183a;
                c.f12184b = str;
            }
        }

        @Override // com.danlan.android.cognition.collector.listener.DeviceIdCreateListener
        public /* synthetic */ void onInitializeDeviceId(int i10, int i11, String str, String str2) {
            f4.a.b(this, i10, i11, str, str2);
        }
    }

    public static final HashMap h() {
        String str;
        HashMap hashMap = new HashMap();
        String USERID = DeviceInfoConstant.USERID;
        s.h(USERID, "USERID");
        User X = g.f52734a.X();
        if (X == null || (str = X.userId()) == null) {
            str = "";
        }
        hashMap.put(USERID, str);
        String SMID = DeviceInfoConstant.SMID;
        s.h(SMID, "SMID");
        hashMap.put(SMID, e.f12185a.a());
        String DUID = DeviceInfoConstant.DUID;
        s.h(DUID, "DUID");
        hashMap.put(DUID, com.cupidapp.live.base.network.a.f11902a.h());
        return hashMap;
    }

    @NotNull
    public final String d() {
        String str = f12184b;
        if (str == null || str.length() == 0) {
            f12184b = Cognition.getDeviceID(AppApplication.f11612d.h().getApplicationContext());
        }
        String str2 = f12184b;
        return str2 == null ? "" : str2;
    }

    @NotNull
    public final String e() {
        s.d(g.f52734a.I1(), Boolean.TRUE);
        return "https://finka-device.finka.cn";
    }

    public final void f() {
        Cognition.setLogEnable(false);
        Cognition.init(AppApplication.f11612d.h().getApplicationContext(), new a(), new b());
    }

    public final void g(int i10) {
        Cognition.getInstance(AppApplication.f11612d.h().getApplicationContext()).uploadForAction(i10, new ExtraInfoFroAction() { // from class: com.cupidapp.live.base.safe.b
            @Override // com.danlan.android.cognition.collector.listener.ExtraInfoFroAction
            public final HashMap setExtraInfo() {
                HashMap h10;
                h10 = c.h();
                return h10;
            }
        });
    }
}
