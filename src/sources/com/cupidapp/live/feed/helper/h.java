package com.cupidapp.live.feed.helper;

import android.os.Handler;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.mediapicker.newmediapicker.util.thread.ThreadManager;
import com.huawei.quickcard.base.Attributes;
import com.irisdt.util.LoopQueue;
import java.io.IOException;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FeedExposureReportHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f14329a = new h();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final LoopQueue f14330b = new LoopQueue(40);

    /* renamed from: c, reason: collision with root package name */
    public static long f14331c;

    /* renamed from: d, reason: collision with root package name */
    public static int f14332d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static Runnable f14333e;

    /* compiled from: FeedExposureReportHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends com.cupidapp.live.mediapicker.newmediapicker.util.thread.a {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final String f14334c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String str) {
            super("finka-upload-feed-action");
            s.i(str, "str");
            this.f14334c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                NetworkClient.f11868a.l().V(this.f14334c).execute();
            } catch (IOException e2) {
                com.cupidapp.live.base.utils.j.f12332a.c("FeedExposureReportHelper", "feedAction api IOException:" + ((Object) e2));
            } catch (RuntimeException e10) {
                com.cupidapp.live.base.utils.j.f12332a.c("FeedExposureReportHelper", "feedAction api RuntimeException:" + ((Object) e10));
            }
        }
    }

    public static final void g() {
        f14329a.h(false);
    }

    public final void b() {
        if (f14333e != null) {
            Handler j10 = AppApplication.f11612d.h().j();
            Runnable runnable = f14333e;
            s.f(runnable);
            j10.removeCallbacks(runnable);
            f14333e = null;
        }
        i();
    }

    public final int c() {
        Integer feedActionUploadSizeRule;
        if (f14332d == 0) {
            ConstantsResult q10 = p1.g.f52734a.q();
            f14332d = (q10 == null || (feedActionUploadSizeRule = q10.getFeedActionUploadSizeRule()) == null) ? 0 : feedActionUploadSizeRule.intValue();
        }
        int i10 = f14332d;
        if (i10 > 0) {
            return i10;
        }
        return 15;
    }

    public final long d() {
        Integer feedActionUploadTimeSecondRule;
        if (f14331c == 0) {
            ConstantsResult q10 = p1.g.f52734a.q();
            f14331c = ((q10 == null || (feedActionUploadTimeSecondRule = q10.getFeedActionUploadTimeSecondRule()) == null) ? 0 : feedActionUploadTimeSecondRule.intValue()) * 1000;
        }
        long j10 = f14331c;
        if (j10 > 0) {
            return j10;
        }
        return 10000L;
    }

    public final void e(@NotNull String postId, @Nullable Integer num, @NotNull UserActionType actionType, @NotNull SensorPosition position, @Nullable SensorPosition sensorPosition, @Nullable Integer num2, @Nullable String str) {
        s.i(postId, "postId");
        s.i(actionType, "actionType");
        s.i(position, "position");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", "1.1");
            jSONObject.put("postId", postId);
            jSONObject.put("actionType", actionType.getValue());
            jSONObject.put("position", position.getValue());
            if (num != null) {
                jSONObject.put("tagId", num.intValue());
            }
            if (sensorPosition != null) {
                jSONObject.put("source", sensorPosition.getValue());
            }
            if (str != null) {
                jSONObject.put("callback", str);
            }
            if (num2 != null && num2.intValue() != -1) {
                jSONObject.put(Attributes.Style.INDEX, num2.intValue());
            }
            LoopQueue loopQueue = f14330b;
            loopQueue.push(jSONObject);
            if (f14333e == null) {
                f14333e = new Runnable() { // from class: com.cupidapp.live.feed.helper.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.g();
                    }
                };
                Handler j10 = AppApplication.f11612d.h().j();
                Runnable runnable = f14333e;
                s.f(runnable);
                j10.postDelayed(runnable, d());
            }
            if (loopQueue.size() >= c()) {
                h(true);
            }
            j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
            String name = h.class.getName();
            String jSONObject2 = jSONObject.toString();
            s.h(jSONObject2, "jsonObject.toString()");
            aVar.a(name, jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void h(boolean z10) {
        Runnable runnable = f14333e;
        if (runnable != null) {
            if (z10) {
                AppApplication.f11612d.h().j().removeCallbacks(runnable);
            }
            AppApplication.f11612d.h().j().postDelayed(runnable, f14329a.d());
        }
        i();
    }

    public final void i() {
        Object[] arrays = f14330b.pop(c());
        boolean z10 = true;
        if (arrays != null) {
            if (!(arrays.length == 0)) {
                z10 = false;
            }
        }
        if (z10) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        s.h(arrays, "arrays");
        for (Object obj : arrays) {
            jSONArray.put(obj);
        }
        ThreadManager a10 = ThreadManager.f17352d.a();
        String jSONArray2 = jSONArray.toString();
        s.h(jSONArray2, "jsonArray.toString()");
        a10.d(new a(jSONArray2));
    }
}
