package com.tencent.open.im;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.TDialog;
import com.tencent.open.utils.l;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class IM extends BaseApi {
    public static final String CHAT_TYPE_AIO = "thirdparty2c";
    public static final String CHAT_TYPE_AUDIO_CHAT = "audio_chat";
    public static final String CHAT_TYPE_VIDEO_CHAT = "video_chat";
    public static final int IM_LENGTH_SHORT = -3;
    public static final int IM_SHOULD_DOWNLOAD = -2;
    public static final int IM_SUCCESS = 0;
    public static final int IM_UIN_EMPTY = -1;
    public static final int IM_UIN_NOT_DIGIT = -4;
    public static final int IM_UNKNOWN_TYPE = -5;

    public IM(Context context, c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        if (str == null) {
            return -5;
        }
        if (!str.equals(CHAT_TYPE_AIO) && !str.equals(CHAT_TYPE_AUDIO_CHAT) && !str.equals(CHAT_TYPE_VIDEO_CHAT)) {
            return -5;
        }
        if (!str.equals(CHAT_TYPE_AUDIO_CHAT)) {
            str.equals(CHAT_TYPE_VIDEO_CHAT);
        }
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        if (str2.length() < 5) {
            return -3;
        }
        for (int i10 = 0; i10 < str2.length(); i10++) {
            if (!Character.isDigit(str2.charAt(i10))) {
                return -4;
            }
        }
        if (l.d(activity)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format("mqqapi://im/chat?chat_type=%1$s&uin=%2$s&version=1&src_type=app&open_id=%3$s&app_id=%4$s&app_pkg_name=%5$s", str, str2, l.l(this.f42565c.getOpenId()), l.l(this.f42565c.getAppId()), l.l(str3))));
            intent.putExtra(MonitorConstants.PKG_NAME, str3);
            activity.startActivity(intent);
            return 0;
        }
        try {
            new TDialog(activity, "", a(""), null, this.f42565c).show();
            return -2;
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            return -2;
        }
    }

    public IM(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public IM(QQToken qQToken) {
        super(qQToken);
    }
}
