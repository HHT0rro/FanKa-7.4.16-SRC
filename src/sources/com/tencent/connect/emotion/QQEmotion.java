package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class QQEmotion extends BaseApi {

    /* renamed from: a, reason: collision with root package name */
    private IUiListener f42574a;

    public QQEmotion(QQToken qQToken) {
        super(qQToken);
    }

    private boolean a(Context context, ArrayList<Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            SLog.i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j10 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String a10 = l.a(context, arrayList.get(i10));
            long j11 = l.j(a10);
            if (j11 > 1048576) {
                SLog.i("QQEMOTION", "isLegality -->illegal, fileSize: " + j11 + "， path =" + a10);
                return false;
            }
            j10 += j11;
        }
        if (j10 > 3145728) {
            SLog.i("QQEMOTION", "isLegality -->illegal, totalSize: " + j10);
            return false;
        }
        SLog.i("QQEMOTION", "isLegality -->legal, totalSize: " + j10);
        return true;
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        IUiListener iUiListener2 = this.f42574a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f42574a = iUiListener;
        if (!i.b(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (i.c(activity, "8.0.0") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
            return;
        }
        if (!a(activity.getApplicationContext(), arrayList)) {
            Toast.makeText(activity.getApplicationContext(), "图片不符合要求，不支持设置表情功能。", 1).show();
            return;
        }
        String a10 = l.a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
        if (!TextUtils.isEmpty(a10)) {
            if (a10.length() > 20) {
                a10 = a10.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(a10), 2));
        }
        String appId = this.f42565c.getAppId();
        String openId = this.f42565c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(openId), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(l.i(Constants.SDK_VERSION), 2));
        String a11 = a(arrayList);
        if (!TextUtils.isEmpty(a11)) {
            stringBuffer.append("&set_uri_list=" + a11);
        }
        SLog.v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        if (a(intent)) {
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_EMOTION, iUiListener);
            a(activity, Constants.REQUEST_EDIT_EMOTION, intent, false);
        }
    }

    private String a(ArrayList<Uri> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            sb2.append((Object) arrayList.get(i10));
            sb2.append(";");
        }
        String sb3 = sb2.toString();
        SLog.i("QQEMOTION", "-->getFilePathListJson listStr : " + sb3);
        return Base64.encodeToString(l.i(sb3), 2);
    }
}
