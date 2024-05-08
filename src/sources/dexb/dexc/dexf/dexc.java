package dexb.dexc.dexf;

import android.app.Fragment;
import android.util.SparseArray;
import dd.a;
import dd.c;
import dd.d;
import java.util.ArrayList;

/* compiled from: PermissionFragment.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class dexc extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<c> f48702b = new SparseArray<>();

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        c cVar = this.f48702b.get(i10);
        if (cVar == null) {
            return;
        }
        this.f48702b.remove(i10);
        if (strArr.length == 0) {
            cVar.f48692a.b(new a(new ArrayList(), new ArrayList()));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            if (iArr[i11] != 0) {
                arrayList.add(strArr[i11]);
            }
        }
        if (arrayList.isEmpty()) {
            cVar.f48692a.a();
        } else {
            cVar.f48692a.b(new a(arrayList, d.a(getActivity(), d.b(arrayList))));
        }
    }
}
