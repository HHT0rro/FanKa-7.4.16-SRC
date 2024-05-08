package com.huawei.jmessage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.vivo.push.PushClientConstants;

/* compiled from: IntentWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Intent f32025a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f32026b;

    public e(@NonNull String str) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            this.f32025a = new Intent(str);
            this.f32026b = false;
            return;
        }
        throw new Exception("The action field must not be empty.");
    }

    public static void c(Intent intent, @NonNull FLMap fLMap) {
        FLArray optArray = fLMap.optArray("flags");
        if (optArray == null || optArray.size() <= 0) {
            return;
        }
        int size = optArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            intent.addFlags(optArray.optInt(i10));
        }
    }

    public static void d(Intent intent, @NonNull FLMap fLMap) {
        FLArray optArray = fLMap.optArray(PushClientConstants.TAG_CLASS_NAME);
        if (optArray == null || optArray.size() != 2) {
            return;
        }
        Object obj = optArray.get(0);
        String optString = optArray.optString(1);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        if (obj instanceof String) {
            intent.setClassName((String) obj, optString);
        } else if (obj instanceof Context) {
            intent.setClassName((Context) obj, optString);
        }
    }

    public static void e(Intent intent, @NonNull FLMap fLMap) {
        String optString = fLMap.optString("data");
        String optString2 = fLMap.optString("type");
        if (!TextUtils.isEmpty(optString)) {
            if (!TextUtils.isEmpty(optString2)) {
                intent.setDataAndTypeAndNormalize(Uri.parse(optString), optString2);
                return;
            } else {
                intent.setDataAndNormalize(Uri.parse(optString));
                return;
            }
        }
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        intent.setTypeAndNormalize(optString2);
    }

    public static void f(Intent intent, @NonNull FLMap fLMap) {
        String optString = fLMap.optString("package");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        intent.setPackage(optString);
    }

    @NonNull
    public Intent a() {
        return this.f32025a;
    }

    public boolean b() {
        return this.f32026b;
    }

    public static void a(Intent intent, @NonNull FLMap fLMap) {
        FLArray optArray = fLMap.optArray("categories");
        if (optArray == null || optArray.size() <= 0) {
            return;
        }
        int size = optArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            String optString = optArray.optString(i10);
            if (!TextUtils.isEmpty(optString)) {
                intent.addCategory(optString);
            }
        }
    }

    public static void b(Intent intent, @NonNull FLMap fLMap) {
        FLMap optMap = fLMap.optMap("extra");
        if (optMap != null) {
            for (String str : optMap.keys()) {
                a(intent, str, optMap.get(str));
            }
        }
    }

    public e(@NonNull Intent intent) {
        this.f32025a = intent;
        this.f32026b = false;
    }

    public static void a(Intent intent, String str, Object obj) {
        if (obj instanceof String) {
            intent.putExtra(str, (String) obj);
            return;
        }
        if (obj instanceof Double) {
            intent.putExtra(str, (Double) obj);
            return;
        }
        if (obj instanceof Float) {
            intent.putExtra(str, (Float) obj);
            return;
        }
        if (obj instanceof Long) {
            intent.putExtra(str, (Long) obj);
            return;
        }
        if (obj instanceof Integer) {
            intent.putExtra(str, (Integer) obj);
            return;
        }
        if (obj instanceof Short) {
            intent.putExtra(str, (Short) obj);
        } else if (obj instanceof Byte) {
            intent.putExtra(str, (Byte) obj);
        } else if (obj instanceof Boolean) {
            intent.putExtra(str, (Boolean) obj);
        }
    }

    public e(@NonNull FLMap fLMap) throws Exception {
        String optString = fLMap.optString("action");
        if (!TextUtils.isEmpty(optString)) {
            Intent intent = new Intent(optString);
            this.f32025a = intent;
            d(intent, fLMap);
            f(intent, fLMap);
            c(intent, fLMap);
            a(intent, fLMap);
            e(intent, fLMap);
            b(intent, fLMap);
            this.f32026b = fLMap.optBoolean("system", false);
            return;
        }
        throw new Exception("The action field must not be empty.");
    }
}
