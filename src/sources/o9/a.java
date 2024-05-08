package o9;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.base.api.AppMarketApi;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.common.support.storage.BaseSharedPreference;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.appgallery.agd.serverreq.utils.device.TelphoneInformationManager;
import org.json.JSONException;
import org.json.JSONObject;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile BaseSharedPreference f52390a;

    public static String a(@NonNull Context context) {
        return b(context, "ag_device_udid");
    }

    public static String b(@NonNull Context context, String str) {
        if (f52390a == null) {
            ApplicationWrapper.init(context);
            f52390a = new BaseSharedPreference(context);
        }
        if ("ag_device_udid".equals(str)) {
            return h(context);
        }
        return "signInfo".equals(str) ? j(context) : "";
    }

    public static String c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("country", HomeCountryUtils.getHomeCountry());
            jSONObject.put(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, TelphoneInformationManager.getTelephoneLanguage());
            jSONObject.put("ag_sign", str);
            jSONObject.put("ag_sign_cache_time", System.currentTimeMillis());
        } catch (JSONException unused) {
            n9.a.f52175d.e("DeviceIdUtil", "assembleSignInfoJson#put json key&value ex");
        }
        return jSONObject.toString();
    }

    public static boolean d(long j10) {
        long currentTimeMillis = (System.currentTimeMillis() - j10) / 86400000;
        n9.a aVar = n9.a.f52175d;
        aVar.i("DeviceIdUtil", "DeviceIdUtil#isValid cacheStartTime:" + j10 + ",diffTime:" + currentTimeMillis);
        if (j10 > 0 && currentTimeMillis >= 0) {
            return currentTimeMillis > 3;
        }
        aVar.w("DeviceIdUtil", "DeviceIdUtil#isValid time ex");
        return true;
    }

    public static boolean e(String str, String str2) {
        String homeCountry = HomeCountryUtils.getHomeCountry();
        String telephoneLanguage = TelphoneInformationManager.getTelephoneLanguage();
        n9.a.f52175d.d("DeviceIdUtil", "country=" + homeCountry + ", language=" + telephoneLanguage);
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && StringUtils.equals(homeCountry, str) && StringUtils.equals(telephoneLanguage, str2);
    }

    public static String f(Context context) {
        return b(context, "signInfo");
    }

    public static String g(String str) {
        try {
            return new JSONObject(str).optString("ag_sign");
        } catch (JSONException unused) {
            n9.a.f52175d.e("DeviceIdUtil", "DeviceIdUtil#getCacheSign get cache json sign ex");
            return "";
        }
    }

    public static String h(@NonNull Context context) {
        if (f52390a == null) {
            n9.a.f52175d.e("DeviceIdUtil", "DeviceIdUtil#getDeviceId sp is null");
            return null;
        }
        String string = f52390a.getString("ag_device_udid", "");
        if (!TextUtils.isEmpty(string)) {
            n9.a.f52175d.i("DeviceIdUtil", "DeviceIdUtil#getDeviceId from sp");
            return string;
        }
        String udId = AppMarketApi.getUdId(context);
        if (!TextUtils.isEmpty(udId)) {
            n9.a.f52175d.i("DeviceIdUtil", "DeviceIdUtil#getDeviceId from ag success");
            f52390a.putString("ag_device_udid", udId);
        } else {
            n9.a.f52175d.i("DeviceIdUtil", "DeviceIdUtil#getDeviceId from ag fail");
        }
        return udId;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            n9.a.f52175d.e("DeviceIdUtil", "isAgSignExpired#signInfoJson is empty");
            return true;
        }
        try {
            n9.a.f52175d.d("DeviceIdUtil", "isAgSignExpired#parse signInfo json");
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ag_sign");
            String optString2 = jSONObject.optString("country");
            String optString3 = jSONObject.optString(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
            long optLong = jSONObject.optLong("ag_sign_cache_time");
            if (!e(optString2, optString3) || d(optLong)) {
                return true;
            }
            return TextUtils.isEmpty(optString);
        } catch (JSONException unused) {
            n9.a.f52175d.e("DeviceIdUtil", "isAgSignExpired#parse signInfo json ex");
            return true;
        }
    }

    public static String j(@NonNull Context context) {
        if (f52390a == null) {
            n9.a.f52175d.e("DeviceIdUtil", "DeviceIdUtil#getSign sp is null");
            return null;
        }
        String string = f52390a.getString("signInfo", "");
        if (k(string)) {
            n9.a.f52175d.i("DeviceIdUtil", "DeviceIdUtil#getSign cache sign is not empty");
            return g(string);
        }
        String signature = AppMarketApi.getSignature(context);
        if (!TextUtils.isEmpty(signature)) {
            f52390a.putString("signInfo", c(signature));
            n9.a.f52175d.i("DeviceIdUtil", "DeviceIdUtil#getSign save AG sign to sp");
            return signature;
        }
        if (!TextUtils.isEmpty(string)) {
            f52390a.putString("signInfo", "");
            n9.a.f52175d.i("DeviceIdUtil", "DeviceIdUtil#getSign unable to get AG provider signature,cache will be cleared");
        }
        return "";
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !i(str);
    }
}
