package com.nirvana.tools.logger.storage;

import android.content.Context;
import android.text.TextUtils;
import com.nirvana.tools.core.AppUtils;
import com.nirvana.tools.core.CryptUtil;
import com.nirvana.tools.logger.utils.UTSharedPreferencesHelper;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LoggerIdManager {
    public static final String AUTH_APP_INFO = "AUTH_APP_INFO";
    private static final String KEY_UNIQUE_ID = "uniqueId";
    private Context mContext;

    public LoggerIdManager(Context context) {
        this.mContext = context;
    }

    private String generateUniqueId(Context context) {
        try {
            return CryptUtil.md5Hex(UUID.randomUUID().toString() + AppUtils.getPackageName(context) + AppUtils.getSign(context) + System.currentTimeMillis());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUniqueId() {
        String str = (String) UTSharedPreferencesHelper.get(this.mContext, "AUTH_APP_INFO", "uniqueId", "");
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String generateUniqueId = generateUniqueId(this.mContext);
        UTSharedPreferencesHelper.put(this.mContext, "AUTH_APP_INFO", "uniqueId", generateUniqueId);
        return generateUniqueId;
    }
}
