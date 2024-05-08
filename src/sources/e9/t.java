package e9;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.utils.PackageKit;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.internalapi.CoreApi;
import com.huawei.appgallery.agd.core.internalapi.OpenEventInfo;
import com.huawei.appgallery.agd.pageframe.api.CardEventInfo;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static DisplayMetrics f48986a;

    public static int a(Context context, float f10) {
        d(context);
        return (int) ((f10 / f48986a.density) + 0.5f);
    }

    public static String b(String str) {
        return str + "_" + UUID.randomUUID().toString();
    }

    public static void c(int i10, CardEventInfo cardEventInfo) {
        CoreApi.reportEvent(cardEventInfo.slotId, new OpenEventInfo(i10, cardEventInfo.layoutId, cardEventInfo.detailId));
    }

    public static void d(Context context) {
        Display defaultDisplay;
        if (f48986a == null) {
            DisplayMetrics displayMetrics = null;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
            }
            f48986a = displayMetrics;
        }
    }

    public static void e(CardEventInfo cardEventInfo, String str, String str2, String str3) {
        if (cardEventInfo != null && !TextUtils.isEmpty(str)) {
            MaintBi.report(new MaintData.Builder(str).setSlotId(cardEventInfo.slotId).setUniqueId(cardEventInfo.uniqueId).setInstallType(cardEventInfo.installType).setAdId(cardEventInfo.adId).setLayoutName(cardEventInfo.layoutId).setTaskPackageName(cardEventInfo.packageName).setReason(str2).setUri(str3).build());
        } else {
            e.f48945d.e("EventReporter", "CardEventInfo is null or eventId is null");
        }
    }

    public static boolean f(@NonNull Context context, String str, int i10, Integer num) {
        if (num == null) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int intValue = num.intValue();
        if (intValue != 1) {
            if (intValue != 2 && intValue == 3 && i10 != 3 && !PackageKit.checkApkInstall(context, str)) {
                return true;
            }
        } else if (PackageKit.checkApkInstall(context, str)) {
            return true;
        }
        return false;
    }

    public static void g(int i10, CardEventInfo cardEventInfo) {
        if (!TextUtils.isEmpty(cardEventInfo.slotId) && !TextUtils.isEmpty(cardEventInfo.detailId) && !TextUtils.isEmpty(cardEventInfo.layoutId)) {
            OpenEventInfo openEventInfo = new OpenEventInfo(i10, cardEventInfo.layoutId, cardEventInfo.detailId);
            if (i10 == 7 || i10 == 5) {
                long j10 = cardEventInfo.videoDuration;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("playDuration", j10);
                } catch (JSONException unused) {
                    e.f48945d.e("EventReporter", "Resolve PassTime Exception");
                }
                openEventInfo.setEventValue(jSONObject.toString());
            }
            CoreApi.reportEvent(cardEventInfo.slotId, openEventInfo);
            return;
        }
        e.f48945d.e("EventReporter", "reportVideoEvent slotId or detailId or layoutId is null");
    }
}
