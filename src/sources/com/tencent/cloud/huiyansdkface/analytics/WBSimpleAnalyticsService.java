package com.tencent.cloud.huiyansdkface.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Properties;
import org.apache.commons.lang3.CharUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WBSimpleAnalyticsService {

    /* renamed from: a, reason: collision with root package name */
    private d f40451a = new d();

    public void init(String str, String str2) {
        this.f40451a.f40475b.setAppId(str);
        this.f40451a.f40477i = str2;
    }

    public boolean startStatService(Context context, WBSimpleStartParam wBSimpleStartParam) {
        return this.f40451a.a(context, wBSimpleStartParam);
    }

    public void trackCustomKVEvent(Context context, String str, String str2, Properties properties) {
        this.f40451a.a(context, str, str2, properties, false);
    }

    public void trackIMSWarnVEvent(Context context, String str, String str2, Properties properties) {
        this.f40451a.a(context, str, str2, properties, true);
    }

    @Deprecated
    public void trackIMSWarnVEvent(Context context, String str, Properties properties) {
        this.f40451a.a(context, "IMSWarn", str, properties, true);
    }

    public void updateEcifNo(String str) {
        d dVar = this.f40451a;
        dVar.f40475b.setEcifNo(str);
        Context context = d.f40472g;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(dVar.f40475b.getAppId(), 0).edit();
            edit.putString(d.f40468c, str);
            edit.commit();
        }
    }

    public void updateEnableWBAService(boolean z10) {
        this.f40451a.f40476h = z10;
    }

    public boolean updateFieldValue(String str, String str2) {
        d dVar = this.f40451a;
        if (TextUtils.isEmpty(str) || !str.startsWith("field_y_")) {
            return false;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case 576982986:
                if (str.equals("field_y_10")) {
                    c4 = 0;
                    break;
                }
                break;
            case 576982987:
                if (str.equals("field_y_11")) {
                    c4 = 1;
                    break;
                }
                break;
            case 576982988:
                if (str.equals("field_y_12")) {
                    c4 = 2;
                    break;
                }
                break;
            case 576982989:
                if (str.equals("field_y_13")) {
                    c4 = 3;
                    break;
                }
                break;
            case 576982990:
                if (str.equals("field_y_14")) {
                    c4 = 4;
                    break;
                }
                break;
            case 576982991:
                if (str.equals("field_y_15")) {
                    c4 = 5;
                    break;
                }
                break;
            case 576982992:
                if (str.equals("field_y_16")) {
                    c4 = 6;
                    break;
                }
                break;
            case 576982993:
                if (str.equals("field_y_17")) {
                    c4 = 7;
                    break;
                }
                break;
            case 576982994:
                if (str.equals("field_y_18")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 576982995:
                if (str.equals("field_y_19")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1265538341:
                if (str.equals("field_y_0")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1265538342:
                if (str.equals("field_y_1")) {
                    c4 = 11;
                    break;
                }
                break;
            case 1265538343:
                if (str.equals("field_y_2")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 1265538344:
                if (str.equals("field_y_3")) {
                    c4 = CharUtils.CR;
                    break;
                }
                break;
            case 1265538345:
                if (str.equals("field_y_4")) {
                    c4 = 14;
                    break;
                }
                break;
            case 1265538346:
                if (str.equals("field_y_5")) {
                    c4 = 15;
                    break;
                }
                break;
            case 1265538347:
                if (str.equals("field_y_6")) {
                    c4 = 16;
                    break;
                }
                break;
            case 1265538348:
                if (str.equals("field_y_7")) {
                    c4 = 17;
                    break;
                }
                break;
            case 1265538349:
                if (str.equals("field_y_8")) {
                    c4 = 18;
                    break;
                }
                break;
            case 1265538350:
                if (str.equals("field_y_9")) {
                    c4 = 19;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                dVar.f40475b.setField_y_10(str2);
                return true;
            case 1:
                dVar.f40475b.setField_y_11(str2);
                return true;
            case 2:
                dVar.f40475b.setField_y_12(str2);
                return true;
            case 3:
                dVar.f40475b.setField_y_13(str2);
                return true;
            case 4:
                dVar.f40475b.setField_y_14(str2);
                return true;
            case 5:
                dVar.f40475b.setField_y_15(str2);
                return true;
            case 6:
                dVar.f40475b.setField_y_16(str2);
                return true;
            case 7:
                dVar.f40475b.setField_y_17(str2);
                return true;
            case '\b':
                dVar.f40475b.setField_y_18(str2);
                return true;
            case '\t':
                dVar.f40475b.setField_y_19(str2);
                return true;
            case '\n':
                String str3 = d.f40467a;
                "fieldKey=".concat(str);
                "fieldValue=".concat(String.valueOf(str2));
                dVar.f40475b.setField_y_0(str2);
                Context context = d.f40472g;
                if (context != null) {
                    SharedPreferences.Editor edit = context.getSharedPreferences(dVar.f40475b.getAppId(), 0).edit();
                    edit.putString(d.f40471f, str2);
                    edit.commit();
                }
                return true;
            case 11:
                dVar.f40475b.setField_y_1(str2);
                return true;
            case '\f':
                dVar.f40475b.setField_y_2(str2);
                return true;
            case '\r':
                dVar.f40475b.setField_y_3(str2);
                return true;
            case 14:
                dVar.f40475b.setField_y_4(str2);
                return true;
            case 15:
                dVar.f40475b.setField_y_5(str2);
                return true;
            case 16:
                dVar.f40475b.setField_y_6(str2);
                return true;
            case 17:
                dVar.f40475b.setField_y_7(str2);
                return true;
            case 18:
                dVar.f40475b.setField_y_8(str2);
                return true;
            case 19:
                dVar.f40475b.setField_y_9(str2);
                return true;
            default:
                return false;
        }
    }

    public void updateOpenId(String str) {
        d dVar = this.f40451a;
        dVar.f40475b.setOpenId(str);
        Context context = d.f40472g;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(dVar.f40475b.getAppId(), 0).edit();
            edit.putString(d.f40470e, str);
            edit.commit();
        }
    }

    public void updateUnionId(String str) {
        d dVar = this.f40451a;
        dVar.f40475b.setUnionId(str);
        Context context = d.f40472g;
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(dVar.f40475b.getAppId(), 0).edit();
            edit.putString(d.f40469d, str);
            edit.commit();
        }
    }
}
