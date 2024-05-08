package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final c f10886a;

    /* renamed from: com.bytedance.pangle.receiver.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class C0123b extends e {
        private C0123b() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            return false;
        }

        public /* synthetic */ C0123b(byte b4) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface c {
        boolean a(Context context);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class d extends a {
        private d() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            Object a10 = a.a(context, "mWhiteList");
            if (!(a10 instanceof List)) {
                return false;
            }
            ((List) a10).add(context.getPackageName());
            return true;
        }

        public /* synthetic */ d(byte b4) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class e extends a {
        private e() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object a10 = a.a(context, "mWhiteListMap");
            if (!(a10 instanceof Map)) {
                return false;
            }
            Map map = (Map) a10;
            List list = (List) map.get(0);
            if (list == null) {
                list = new ArrayList();
                map.put(0, list);
            }
            list.add(context.getPackageName());
            return true;
        }

        public /* synthetic */ e(byte b4) {
            this();
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        byte b4 = 0;
        if (i10 < 24) {
            f10886a = new a(b4);
            return;
        }
        if (i10 < 26) {
            f10886a = new d(b4);
        } else if (i10 < 28) {
            f10886a = new e(b4);
        } else {
            f10886a = new C0123b(b4);
        }
    }

    public static void a(Application application) {
        if (application != null) {
            try {
                if (TextUtils.equals(Build.BRAND.toLowerCase(), "huawei")) {
                    f10886a.a(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a implements c {
        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }

        private static Object b(Context context) {
            Field field;
            Object readField;
            try {
                Field field2 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field2 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (readField = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field2, readField);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object b4 = b(context);
            Object a10 = a(b4, "mWhiteList");
            if (!(a10 instanceof String[])) {
                if (b4 == null) {
                    return false;
                }
                FieldUtils.writeField(b4, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) a10);
            FieldUtils.writeField(b4, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        public static Object a(Context context, String str) {
            return a(b(context), str);
        }

        private static Object a(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
