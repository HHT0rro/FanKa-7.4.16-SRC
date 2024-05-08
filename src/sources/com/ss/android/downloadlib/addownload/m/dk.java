package com.ss.android.downloadlib.addownload.m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.c;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk {
    public void dk(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        c.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.dk.m> m(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.dk.m> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = c.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.addownload.dk.m m10 = com.ss.android.downloadlib.addownload.dk.m.m(jSONObject.optJSONObject(keys.next()));
                    if (m10 != null) {
                        copyOnWriteArrayList.add(m10);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    public void m(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.dk.m> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<com.ss.android.downloadlib.addownload.dk.m> iterator2 = copyOnWriteArrayList.iterator2();
            while (iterator2.hasNext()) {
                com.ss.android.downloadlib.addownload.dk.m next = iterator2.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.dk), next.m());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
