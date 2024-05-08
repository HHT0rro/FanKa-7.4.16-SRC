package com.tencent.cloud.huiyansdkface.facelight.c;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f40677a;

    /* renamed from: b, reason: collision with root package name */
    private static SharedPreferences.Editor f40678b;

    public g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("wb_face_config", 0);
        f40677a = sharedPreferences;
        f40678b = sharedPreferences.edit();
    }

    public void a(String str, Object obj) {
        SharedPreferences.Editor editor;
        String obj2;
        if (!(obj instanceof String)) {
            if (obj instanceof Integer) {
                f40678b.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                f40678b.putBoolean(str, ((Boolean) obj).booleanValue());
            } else {
                editor = f40678b;
                obj2 = obj.toString();
            }
            f40678b.commit();
        }
        editor = f40678b;
        obj2 = (String) obj;
        editor.putString(str, obj2);
        f40678b.commit();
    }

    public Object b(String str, Object obj) {
        return obj instanceof String ? f40677a.getString(str, (String) obj) : obj instanceof Integer ? Integer.valueOf(f40677a.getInt(str, ((Integer) obj).intValue())) : obj instanceof Boolean ? Boolean.valueOf(f40677a.getBoolean(str, ((Boolean) obj).booleanValue())) : f40677a.getString(str, null);
    }
}
