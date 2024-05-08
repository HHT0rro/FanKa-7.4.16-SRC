package com.wangmai.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.wangmai.common.runnable.HasReturnRunnable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CacheInfoUtil {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class HelperEntity {
        public long expirationTime;
        public String info;

        public HelperEntity(String str, long j10) {
            this.info = str;
            this.expirationTime = j10;
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public String getInfo() {
            return this.info;
        }

        public void setExpirationTime(long j10) {
            this.expirationTime = j10;
        }

        public void setInfo(String str) {
            this.info = str;
        }

        public String toString() {
            return "{\"info\":\"" + this.info + "\",\"expirationTime\":" + this.expirationTime + '}';
        }
    }

    public static String getInfo(Context context, String str, String str2, long j10, HasReturnRunnable<String> hasReturnRunnable) {
        if (j10 == 0) {
            return "";
        }
        try {
            if (j10 < 0) {
                return hasReturnRunnable.run();
            }
            long j11 = j10 * 60 * 1000;
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(str2);
            if (TextUtils.isEmpty(preferencesString)) {
                String run = hasReturnRunnable.run();
                if (TextUtils.isEmpty(run)) {
                    run = "";
                }
                SharedPreferencesHelper.getInstance(context).savePreferencesString(str2, GsonUtils.getInstance().toJson(new HelperEntity(run, System.currentTimeMillis() + j11)));
                return run;
            }
            HelperEntity helperEntity = (HelperEntity) GsonUtils.getInstance().fromJson(preferencesString, HelperEntity.class);
            if (helperEntity.getExpirationTime() > System.currentTimeMillis()) {
                return helperEntity.getInfo();
            }
            String run2 = hasReturnRunnable.run();
            if (TextUtils.isEmpty(run2)) {
                return "";
            }
            SharedPreferencesHelper.getInstance(context).savePreferencesString(str2, GsonUtils.getInstance().toJson(new HelperEntity(run2, System.currentTimeMillis() + j11)));
            return run2;
        } catch (Throwable th) {
            DebugLog.W(str, "getCacheInfo error:" + th.toString());
            return "";
        }
    }
}
