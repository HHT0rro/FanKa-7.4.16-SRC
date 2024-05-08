package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ITTDownloadVisitor {
    public static final int TYPE_TT_DOWNLOAD_VISITOR = 1;

    void checkAutoControl(JSONObject jSONObject, String str);

    void clearAllData(String str);

    void execute(int i10, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback);

    void executeLogUpload(TTDownloadEventModel tTDownloadEventModel, boolean z10);

    boolean getAppIsBackground();

    JSONObject getDownloadSettings();

    TTDownloadEventLogger getTTDownloadEventLogger();

    boolean hasPermission(Context context, String str);

    String initPath(boolean z10);

    boolean isOpenSdkEvent(String str);

    void postBody(String str, byte[] bArr, String str2, ITTHttpCallback iTTHttpCallback);

    void requestPermission(Activity activity, String[] strArr, ITTPermissionCallback iTTPermissionCallback);

    void showDialogByDelegate(WeakReference<Context> weakReference, boolean z10, DialogBuilder dialogBuilder);

    AlertDialog showDialogBySelf(Activity activity, boolean z10, DialogBuilder dialogBuilder);
}
