package com.kwad.sdk.core.d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    private static volatile a avh;
    public static ThreadLocal<SimpleDateFormat> avi = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.d.a.1
        @Nullable
        private static SimpleDateFormat DK() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override // java.lang.ThreadLocal
        @Nullable
        public final /* synthetic */ SimpleDateFormat initialValue() {
            return DK();
        }
    };

    public static a DF() {
        if (avh == null) {
            synchronized (a.class) {
                if (avh == null) {
                    avh = new a();
                }
            }
        }
        return avh;
    }

    public static boolean DG() {
        List<f> de2 = de(15);
        if (de2.size() == 0) {
            return true;
        }
        long j10 = -1;
        int i10 = 0;
        for (f fVar : de2) {
            i10 += fVar.count;
            long j11 = fVar.azP;
            if (j11 > j10) {
                j10 = j11;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i10 + ", lastShowTime: " + j10);
        if (i10 > DI()) {
            return false;
        }
        return j10 + (DJ() * 1000) <= System.currentTimeMillis();
    }

    public static List<f> DH() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static int DI() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long DJ() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    private static void Q(String str, String str2) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    private static boolean a(@NonNull f fVar) {
        long j10 = fVar.azP;
        if (j10 <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = avi.get();
        return simpleDateFormat.format(new Date(j10)).equals(simpleDateFormat.format(new Date()));
    }

    public static void bU(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            bV(adTemplate);
        }
    }

    private static void bV(AdTemplate adTemplate) {
        int dY = e.dY(adTemplate);
        int dK = e.dK(adTemplate);
        List DH = DH();
        if (DH != null && DH.size() != 0) {
            boolean z10 = false;
            Iterator iterator2 = DH.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                f fVar = (f) iterator2.next();
                if (fVar.adStyle == dK && fVar.taskType == dY) {
                    fVar.count++;
                    if (!a(fVar)) {
                        fVar.count = 1;
                        fVar.ar(System.currentTimeMillis());
                    }
                    z10 = true;
                }
            }
            if (!z10) {
                DH.add(new f(dK, dY, 1, System.currentTimeMillis()));
            }
        } else {
            DH = new ArrayList();
            DH.add(new f(dK, dY, 1, System.currentTimeMillis()));
        }
        Q("ksadsdk_local_ad_task_info_adstyle_data", t.O(DH).toString());
        adTemplate.watched = true;
    }

    @NonNull
    private static List<f> de(int i10) {
        ArrayList arrayList = new ArrayList();
        List<f> DH = DH();
        if (DH != null && DH.size() != 0) {
            for (f fVar : DH) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void e(int i10, long j10) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i10).putLong("reward_aggregation_min_interval", j10).apply();
    }

    private static String getString(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }
}
