package com.huawei.hms.support.api.safetydetect;

import android.text.TextUtils;
import com.huawei.hms.common.api.CommonStatusCodes;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.lang.reflect.Field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafetyDetectStatusCodes extends CommonStatusCodes {
    public static final int ANTI_FRAUD_INIT_FAIL = 19820;
    public static final int ANTI_FRAUD_INIT_PARAM_INVALID = 19821;
    public static final int APPS_CHECK_INTERNAL_ERROR = 19401;
    public static final int CHECK_WITHOUT_INIT = 19601;
    public static final int DETECT_FAIL = 19800;
    public static final int INVALID_APPID = 19004;
    public static final int NETWORK_ERROR = 19002;
    public static final int PARAM_ERROR_EMPTY = 19150;
    public static final int PARAM_ERROR_INVALID = 19151;
    public static final int RISK_TOKEN_GET_FAIL = 19830;
    public static final int RISK_TOKEN_INNER_ERROR = 19831;
    public static final int SDK_INTERNAL_ERROR = 19001;
    public static final int UNSUPPORTED_AREA = 19003;
    public static final int UNSUPPORTED_EMUI_VERSION = 19202;
    public static final int URL_CHECK_INNER_ERROR = 19600;
    public static final int URL_CHECK_REQUEST_APPID_INVALID = 19604;
    public static final int URL_CHECK_REQUEST_PARAM_INVALID = 19603;
    public static final int URL_CHECK_THREAT_TYPE_INVALID = 19602;
    public static final int USER_DETECT_INVALID_APPID = 19802;
    public static final int USER_DETECT_TIMEOUT = 19801;
    public static final int VERIFY_APPS_VIRUS_NUMBER_EXCEEDED = 19402;

    public static String getFrameworkStatusCodeString(int i10) {
        String statusCodeStringFromClasses = getStatusCodeStringFromClasses(i10, CommonCode.class, CommonCode.StatusCode.class, CommonCode.ErrorCode.class, AuthCode.StatusCode.class, AuthCode.ErrorCode.class);
        if (TextUtils.isEmpty(statusCodeStringFromClasses)) {
            statusCodeStringFromClasses = CommonStatusCodes.getStatusCodeString(i10);
        }
        return statusCodeStringFromClasses.contains(String.valueOf(i10)) ? "FRAMEWORK_INNER_ERROR" : statusCodeStringFromClasses;
    }

    public static String getStatusCodeString(int i10) {
        String statusCodeStringFromClasses = getStatusCodeStringFromClasses(i10, SafetyDetectStatusCodes.class);
        return TextUtils.isEmpty(statusCodeStringFromClasses) ? getFrameworkStatusCodeString(i10) : statusCodeStringFromClasses;
    }

    public static String getStatusCodeStringFromClasses(int i10, Class... clsArr) {
        if (clsArr == null) {
            return "";
        }
        for (Class cls : clsArr) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    String name = field.getName();
                    if (i10 == ((Integer) cls.getField(name).get(null)).intValue()) {
                        return name;
                    }
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
        return "";
    }
}
