package XI.CA.XI;

import android.database.ContentObserver;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class kM extends ContentObserver {
    public int K0;

    /* renamed from: XI, reason: collision with root package name */
    public String f641XI;
    public K0 kM;

    public kM(K0 k02, int i10, String str) {
        super(null);
        this.kM = k02;
        this.K0 = i10;
        this.f641XI = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        K0 k02 = this.kM;
        if (k02 != null) {
            k02.K0(this.K0, this.f641XI);
        }
    }
}
