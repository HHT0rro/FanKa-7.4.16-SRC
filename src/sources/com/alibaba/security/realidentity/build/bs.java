package com.alibaba.security.realidentity.build;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.model.CommonTrackResult;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.LocalBroadcastManagerUtils;
import com.alibaba.security.realidentity.activity.RPTakePhotoActivity;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.utils.ImageData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TakePhotoApi.java */
@aw(a = "takePhoto,rpTakePhoto")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bs extends aq {
    private static final String ao = "bs";
    private static final String ap = "LOW_MEMORY";

    /* compiled from: TakePhotoApi.java */
    /* renamed from: com.alibaba.security.realidentity.build.bs$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3201a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LocalBroadcastManagerUtils f3202b;

        public AnonymousClass1(String str, LocalBroadcastManagerUtils localBroadcastManagerUtils) {
            this.f3201a = str;
            this.f3202b = localBroadcastManagerUtils;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (this.f3201a.equals(intent.getAction())) {
                bs.a(bs.this, intent);
                this.f3202b.unregisterReceiver(this);
            }
        }
    }

    private void b(Intent intent) {
        if (intent.getIntExtra("ret", -1) != -1) {
            aq.a(this.ak, "takePhoto activity result is not ok");
            aq.b("takePhoto activity result is not ok");
            j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto activity result is not ok"), false));
            return;
        }
        Object stringExtra = intent.getStringExtra("errorMsg");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(aq.H);
        int[] intArrayExtra = intent.getIntArrayExtra(aq.f3130z);
        if (intent.getBooleanExtra(aq.Z, false)) {
            aq.a(this.ak, "takePhoto imageList is null by user cancel");
            return;
        }
        if (parcelableArrayListExtra == null) {
            aq.a(this.ak, "takePhoto imageList is null");
            aq.b("takePhoto imageList is null");
            j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto imageList is null"), false));
            return;
        }
        bf bfVar = new bf();
        RPWebViewMediaCacheManager rPWebViewMediaCacheManager = RPWebViewMediaCacheManager.getInstance();
        for (int i10 = 0; i10 < parcelableArrayListExtra.size(); i10++) {
            ImageData imageData = (ImageData) parcelableArrayListExtra.get(i10);
            Pair<String, String> putIdCardImage = rPWebViewMediaCacheManager.putIdCardImage(this.al, imageData.f4052a);
            String str = imageData.f4054c;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(aq.K, String.valueOf(imageData.f4053b));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(aq.T, str);
                }
                if (putIdCardImage != null && !"0".equals(putIdCardImage.first)) {
                    jSONObject.put(aq.f3119o, putIdCardImage.first);
                    jSONObject.put(aq.V, putIdCardImage.second);
                    jSONObject.put(aq.W, imageData.f4055d);
                    bfVar.a(aq.U + imageData.f4053b, jSONObject);
                    j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(), true));
                } else {
                    jSONObject.put("errorMsg", ap);
                    bfVar.a(aq.U + imageData.f4053b, jSONObject);
                    this.ak.a(bfVar);
                    j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, ap), false));
                    return;
                }
            } catch (JSONException e2) {
                aq.a("TakePhotoApi onActivityResult data assemble  error", e2);
                aq.a(this.ak, "TakePhotoApi onActivityResult data assemble error");
                j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "TakePhotoApi onActivityResult data assemble error"), false));
                return;
            }
        }
        if (intArrayExtra.length != parcelableArrayListExtra.size()) {
            int i11 = 0;
            while (true) {
                if (i11 >= intArrayExtra.length) {
                    break;
                }
                if (intArrayExtra[i11] >= 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(aq.f3126v, intArrayExtra[i11]);
                        jSONObject2.put("errorMsg", stringExtra);
                    } catch (JSONException e10) {
                        RPLogging.e(ao, e10);
                    }
                    bfVar.a(aq.U + intArrayExtra[i11], jSONObject2);
                    break;
                }
                i11++;
            }
        }
        if (intArrayExtra.length == parcelableArrayListExtra.size()) {
            bfVar.f3165a = 1;
            this.ak.b(bfVar);
            a(bfVar, true);
        } else {
            this.ak.a(bfVar);
            a(bfVar, false);
        }
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://")) {
            return str;
        }
        if (str.startsWith("//")) {
            return "http:".concat(str);
        }
        return "http://".concat(str);
    }

    private String d() {
        return toString();
    }

    private void e() {
        LocalBroadcastManagerUtils localBroadcastManagerUtils = LocalBroadcastManagerUtils.getInstance(this.al);
        String obj = toString();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(obj);
        localBroadcastManagerUtils.registerReceiver(new AnonymousClass1(obj, localBroadcastManagerUtils), intentFilter);
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "takePhoto";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        if (RPLogging.isEnable()) {
            RPLogging.d(ao, "TakePhotoApi execute params: ".concat(String.valueOf(str)));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray(aq.f3126v);
            JSONArray jSONArray2 = jSONObject.getJSONArray(aq.f3127w);
            String optString = jSONObject.optString(aq.f3128x, "0");
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                iArr[i10] = jSONArray.getInt(i10);
            }
            String[] strArr = new String[jSONArray2.length()];
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                String string = jSONArray2.getString(i11);
                if (!TextUtils.isEmpty(string) && !string.startsWith("http://")) {
                    string = string.startsWith("//") ? "http:".concat(string) : "http://".concat(string);
                }
                strArr[i11] = string;
            }
            j.a.f3944a.a(TrackLog.createTakePhotoStartLog());
            if (length <= 0) {
                return false;
            }
            Intent intent = new Intent();
            intent.setClass(this.al, RPTakePhotoActivity.class);
            intent.putExtra(aq.f3128x, TextUtils.equals(optString, "1"));
            intent.putExtra(aq.f3129y, strArr);
            intent.putExtra(aq.f3130z, iArr);
            intent.putExtra(aq.G, toString());
            intent.setFlags(268435456);
            this.al.startActivity(intent);
            LocalBroadcastManagerUtils localBroadcastManagerUtils = LocalBroadcastManagerUtils.getInstance(this.al);
            String obj = toString();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(obj);
            localBroadcastManagerUtils.registerReceiver(new AnonymousClass1(obj, localBroadcastManagerUtils), intentFilter);
            return true;
        } catch (JSONException e2) {
            if (RPLogging.isEnable()) {
                RPLogging.e(ao, "TakePhotoApi parse params error", e2);
            }
            aq.a("TakePhotoApi parse params error", e2);
            aq.a(ayVar);
            return false;
        }
    }

    private void a(Intent intent) {
        intent.putExtra(aq.G, toString());
        intent.setFlags(268435456);
        this.al.startActivity(intent);
        LocalBroadcastManagerUtils localBroadcastManagerUtils = LocalBroadcastManagerUtils.getInstance(this.al);
        String obj = toString();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(obj);
        localBroadcastManagerUtils.registerReceiver(new AnonymousClass1(obj, localBroadcastManagerUtils), intentFilter);
    }

    public static /* synthetic */ void a(bs bsVar, Intent intent) {
        if (intent.getIntExtra("ret", -1) != -1) {
            aq.a(bsVar.ak, "takePhoto activity result is not ok");
            aq.b("takePhoto activity result is not ok");
            j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto activity result is not ok"), false));
            return;
        }
        Object stringExtra = intent.getStringExtra("errorMsg");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(aq.H);
        int[] intArrayExtra = intent.getIntArrayExtra(aq.f3130z);
        if (intent.getBooleanExtra(aq.Z, false)) {
            aq.a(bsVar.ak, "takePhoto imageList is null by user cancel");
            return;
        }
        if (parcelableArrayListExtra == null) {
            aq.a(bsVar.ak, "takePhoto imageList is null");
            aq.b("takePhoto imageList is null");
            j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto imageList is null"), false));
            return;
        }
        bf bfVar = new bf();
        RPWebViewMediaCacheManager rPWebViewMediaCacheManager = RPWebViewMediaCacheManager.getInstance();
        for (int i10 = 0; i10 < parcelableArrayListExtra.size(); i10++) {
            ImageData imageData = (ImageData) parcelableArrayListExtra.get(i10);
            Pair<String, String> putIdCardImage = rPWebViewMediaCacheManager.putIdCardImage(bsVar.al, imageData.f4052a);
            String str = imageData.f4054c;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(aq.K, String.valueOf(imageData.f4053b));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(aq.T, str);
                }
                if (putIdCardImage != null && !"0".equals(putIdCardImage.first)) {
                    jSONObject.put(aq.f3119o, putIdCardImage.first);
                    jSONObject.put(aq.V, putIdCardImage.second);
                    jSONObject.put(aq.W, imageData.f4055d);
                    bfVar.a(aq.U + imageData.f4053b, jSONObject);
                    j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(), true));
                } else {
                    jSONObject.put("errorMsg", ap);
                    bfVar.a(aq.U + imageData.f4053b, jSONObject);
                    bsVar.ak.a(bfVar);
                    j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, ap), false));
                    return;
                }
            } catch (JSONException e2) {
                aq.a("TakePhotoApi onActivityResult data assemble  error", e2);
                aq.a(bsVar.ak, "TakePhotoApi onActivityResult data assemble error");
                j.a.f3944a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "TakePhotoApi onActivityResult data assemble error"), false));
                return;
            }
        }
        if (intArrayExtra.length != parcelableArrayListExtra.size()) {
            int i11 = 0;
            while (true) {
                if (i11 >= intArrayExtra.length) {
                    break;
                }
                if (intArrayExtra[i11] >= 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(aq.f3126v, intArrayExtra[i11]);
                        jSONObject2.put("errorMsg", stringExtra);
                    } catch (JSONException e10) {
                        RPLogging.e(ao, e10);
                    }
                    bfVar.a(aq.U + intArrayExtra[i11], jSONObject2);
                    break;
                }
                i11++;
            }
        }
        if (intArrayExtra.length == parcelableArrayListExtra.size()) {
            bfVar.f3165a = 1;
            bsVar.ak.b(bfVar);
            bsVar.a(bfVar, true);
        } else {
            bsVar.ak.a(bfVar);
            bsVar.a(bfVar, false);
        }
    }
}
