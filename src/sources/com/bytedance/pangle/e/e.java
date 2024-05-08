package com.bytedance.pangle.e;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e implements f.a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile IBinder f10706a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Object f10707b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class b extends ResultReceiver {

        /* renamed from: a, reason: collision with root package name */
        private a f10708a;

        public b() {
            super(null);
            this.f10708a = null;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i10, Bundle bundle) {
            super.onReceiveResult(i10, bundle);
        }
    }

    private static void a(String[] strArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeFileDescriptor(FileDescriptor.in);
        obtain.writeFileDescriptor(FileDescriptor.out);
        obtain.writeFileDescriptor(FileDescriptor.err);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(null);
        new b().writeToParcel(obtain, 0);
        try {
            f10706a.transact(1598246212, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
        obtain.recycle();
        obtain2.recycle();
    }

    private static Object a(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object a(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i10) {
        boolean z10;
        IBinder asBinder;
        if (f10706a == null) {
            PackageManager packageManager = Zeus.getAppApplication().getPackageManager();
            Field field = packageManager == null ? null : FieldUtils.getField(packageManager.getClass(), "mPM");
            if (field != null) {
                Object a10 = a(field, packageManager);
                f10707b = a10;
                if ((a10 instanceof IInterface) && (asBinder = ((IInterface) f10707b).asBinder()) != null) {
                    f10706a = asBinder;
                }
            }
        }
        if (str != null) {
            String b4 = com.bytedance.pangle.d.c.b(str, i10);
            String e2 = com.bytedance.pangle.d.c.e(str, i10);
            try {
                com.bytedance.pangle.util.h.a(b4, e2);
            } catch (Exception unused) {
            }
            String packageName = Zeus.getAppApplication().getPackageName();
            String a11 = com.bytedance.pangle.e.b.a();
            int i11 = Build.VERSION.SDK_INT;
            if (i11 == 30) {
                if (f10707b != null && packageName != null && e2 != null && a11 != null) {
                    a(f10707b, "notifyDexLoad", new Object[]{packageName, Collections.singletonMap(e2, "PCL[]"), a11}, new Class[]{String.class, Map.class, String.class});
                }
            } else if (i11 == 29 && f10707b != null && packageName != null && e2 != null && a11 != null) {
                a(f10707b, "notifyDexLoad", new Object[]{packageName, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(e2), a11}, new Class[]{String.class, List.class, List.class, String.class});
            }
        }
        String e10 = com.bytedance.pangle.d.c.e(str, i10);
        String str2 = com.bytedance.pangle.d.c.h(str, i10) + File.separator + com.bytedance.pangle.e.b.a(e10);
        int i12 = 1;
        while (true) {
            if (i12 > 3) {
                z10 = false;
                break;
            }
            a(new String[]{"compile", "-m", "speed", "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName()});
            if (com.bytedance.pangle.e.b.a(str2)) {
                z10 = true;
                break;
            }
            i12++;
        }
        if (str != null) {
            try {
                com.bytedance.pangle.util.g.a(com.bytedance.pangle.d.c.g(str, i10), com.bytedance.pangle.d.c.f(str, i10));
            } catch (Exception unused2) {
            }
            try {
                File file = new File(com.bytedance.pangle.d.c.e(str, i10));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused3) {
            }
            a(new String[]{"reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName()});
        }
        return z10;
    }
}
