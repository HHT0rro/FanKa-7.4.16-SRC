package i4;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: AssetStreamLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f49719a;

    /* renamed from: b, reason: collision with root package name */
    public final String f49720b;

    public a(Context context, String str) {
        this.f49719a = context.getApplicationContext();
        this.f49720b = str;
    }

    @Override // i4.d
    public InputStream a() throws IOException {
        return this.f49719a.getAssets().open(this.f49720b);
    }
}
