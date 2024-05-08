package com.alibaba.minilibc.android;

import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class MtopMethodJniBridge {
    private static final boolean DEBUG = false;
    private static final String TAG = "MtopMethodJniBridge";
    private static Class gEnvModeEnumClass = null;
    private static Class gMethodEnumClass = null;
    private static volatile int gMtopAvaiableCache = 0;
    private static volatile int gMtopAvaiableCacheChecked = 0;
    private static Method gMtopBuildMethod = null;
    private static Class gMtopBuilderClass = null;
    private static Method gMtopBuilderHeadersMethod = null;
    private static Method gMtopBuilderReqMethodMethod = null;
    private static Method gMtopBuilderSetConnectionTimeoutMilliSecondMethod = null;
    private static Method gMtopBuilderSetCustomDomainMethod = null;
    private static Method gMtopBuilderSetSocketTimeoutMilliSecondMethod = null;
    private static Method gMtopBuilderSyncRequestMethod = null;
    private static Method gMtopBusinessBuildMethod = null;
    private static Class gMtopClass = null;
    private static Method gMtopInstanceMethod = null;
    private static Class gMtopRequestClass = null;
    private static Method gMtopRequestSetApiNameMethod = null;
    private static Method gMtopRequestSetApiVersionMethod = null;
    private static Method gMtopRequestSetDataMethod = null;
    private static Class gMtopResponseClass = null;
    private static Method gMtopResponseGetDataJsonObjectMethod = null;
    private static Method gMtopResponseGetRetCodeMethod = null;
    private static Method gMtopResponseGetRetMsgMethod = null;
    private static Method gMtopResponseIsApiSuccessMethod = null;
    private static Class gReflectUtilClass = null;
    private static Method gReflectUtilConvertMapToDataStrMethod = null;
    private static boolean hasMtopBusiness = true;

    public static int mtopAvaiable() {
        if (gMtopAvaiableCacheChecked == 0) {
            synchronized (MtopMethodJniBridge.class) {
                if (gMtopAvaiableCacheChecked == 0) {
                    try {
                        gMtopBuilderClass = Class.forName("com.taobao.tao.remotebusiness.MtopBusiness");
                    } catch (ClassNotFoundException unused) {
                        hasMtopBusiness = false;
                    }
                    try {
                        gMtopClass = Class.forName("mtopsdk.mtop.intf.Mtop");
                        gMethodEnumClass = Class.forName("mtopsdk.mtop.domain.MethodEnum");
                        gEnvModeEnumClass = Class.forName("mtopsdk.mtop.domain.EnvModeEnum");
                        gMtopRequestClass = Class.forName("mtopsdk.mtop.domain.MtopRequest");
                        gMtopResponseClass = Class.forName("mtopsdk.mtop.domain.MtopResponse");
                        if (!hasMtopBusiness) {
                            gMtopBuilderClass = Class.forName("mtopsdk.mtop.intf.MtopBuilder");
                        }
                        gReflectUtilClass = Class.forName("mtopsdk.mtop.util.ReflectUtil");
                        gMtopRequestSetApiNameMethod = gMtopRequestClass.getMethod("setApiName", String.class);
                        gMtopRequestSetApiVersionMethod = gMtopRequestClass.getMethod("setVersion", String.class);
                        gMtopRequestSetDataMethod = gMtopRequestClass.getMethod("setData", String.class);
                        gMtopInstanceMethod = gMtopClass.getMethod("instance", Context.class);
                        gMtopBuildMethod = gMtopClass.getMethod("build", gMtopRequestClass, String.class);
                        gMtopBuilderReqMethodMethod = gMtopBuilderClass.getMethod("reqMethod", gMethodEnumClass);
                        gMtopBuilderSyncRequestMethod = gMtopBuilderClass.getMethod("syncRequest", new Class[0]);
                        gMtopBuilderSetCustomDomainMethod = gMtopBuilderClass.getMethod("setCustomDomain", String.class);
                        gMtopBuilderHeadersMethod = gMtopBuilderClass.getMethod(TTDownloadField.TT_HEADERS, Map.class);
                        if (hasMtopBusiness) {
                            gMtopBusinessBuildMethod = gMtopBuilderClass.getMethod("build", gMtopClass, gMtopRequestClass, String.class);
                        }
                        gMtopBuilderSetConnectionTimeoutMilliSecondMethod = gMtopBuilderClass.getMethod("setConnectionTimeoutMilliSecond", Integer.TYPE);
                        gMtopBuilderSetSocketTimeoutMilliSecondMethod = gMtopBuilderClass.getMethod("setSocketTimeoutMilliSecond", Integer.TYPE);
                        gMtopResponseIsApiSuccessMethod = gMtopResponseClass.getMethod("isApiSuccess", new Class[0]);
                        gMtopResponseGetDataJsonObjectMethod = gMtopResponseClass.getMethod("getDataJsonObject", new Class[0]);
                        gMtopResponseGetRetCodeMethod = gMtopResponseClass.getMethod("getRetCode", new Class[0]);
                        gMtopResponseGetRetMsgMethod = gMtopResponseClass.getMethod("getRetMsg", new Class[0]);
                        gReflectUtilConvertMapToDataStrMethod = gReflectUtilClass.getMethod("convertMapToDataStr", Map.class);
                        gMtopAvaiableCache = 1;
                    } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                    }
                    gMtopAvaiableCacheChecked = 1;
                }
            }
        }
        return gMtopAvaiableCache;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008a A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:4:0x0009, B:6:0x0025, B:7:0x002a, B:10:0x0034, B:13:0x003d, B:14:0x0044, B:15:0x0050, B:17:0x008a, B:19:0x00a8, B:21:0x00ae, B:22:0x00b7, B:24:0x00ce, B:25:0x00d7, B:30:0x00fe, B:33:0x0124, B:35:0x0138, B:37:0x0144, B:39:0x015c, B:41:0x009a, B:42:0x0048), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ce A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:4:0x0009, B:6:0x0025, B:7:0x002a, B:10:0x0034, B:13:0x003d, B:14:0x0044, B:15:0x0050, B:17:0x008a, B:19:0x00a8, B:21:0x00ae, B:22:0x00b7, B:24:0x00ce, B:25:0x00d7, B:30:0x00fe, B:33:0x0124, B:35:0x0138, B:37:0x0144, B:39:0x015c, B:41:0x009a, B:42:0x0048), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fe A[Catch: Exception -> 0x0170, TRY_LEAVE, TryCatch #0 {Exception -> 0x0170, blocks: (B:4:0x0009, B:6:0x0025, B:7:0x002a, B:10:0x0034, B:13:0x003d, B:14:0x0044, B:15:0x0050, B:17:0x008a, B:19:0x00a8, B:21:0x00ae, B:22:0x00b7, B:24:0x00ce, B:25:0x00d7, B:30:0x00fe, B:33:0x0124, B:35:0x0138, B:37:0x0144, B:39:0x015c, B:41:0x009a, B:42:0x0048), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a A[Catch: Exception -> 0x0170, TryCatch #0 {Exception -> 0x0170, blocks: (B:4:0x0009, B:6:0x0025, B:7:0x002a, B:10:0x0034, B:13:0x003d, B:14:0x0044, B:15:0x0050, B:17:0x008a, B:19:0x00a8, B:21:0x00ae, B:22:0x00b7, B:24:0x00ce, B:25:0x00d7, B:30:0x00fe, B:33:0x0124, B:35:0x0138, B:37:0x0144, B:39:0x015c, B:41:0x009a, B:42:0x0048), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String postRequest(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, java.util.Map<java.lang.String, java.lang.String> r11, byte[] r12) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.minilibc.android.MtopMethodJniBridge.postRequest(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.Map, byte[]):java.lang.String");
    }
}
