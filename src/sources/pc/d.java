package pc;

import android.os.Build;
import com.android.internal.content.NativeLibraryHelper;
import pc.b;

/* compiled from: SystemLibraryLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d implements b.InterfaceC0807b {
    @Override // pc.b.InterfaceC0807b
    public void a(String str) {
        System.loadLibrary(str);
    }

    @Override // pc.b.InterfaceC0807b
    public String b(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // pc.b.InterfaceC0807b
    public void c(String str) {
        System.load(str);
    }

    @Override // pc.b.InterfaceC0807b
    public String d(String str) {
        return (str.startsWith(NativeLibraryHelper.LIB_DIR_NAME) && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // pc.b.InterfaceC0807b
    public String[] a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !e.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }
}
