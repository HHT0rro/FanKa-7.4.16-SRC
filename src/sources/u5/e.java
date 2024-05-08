package u5;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import u5.d;

/* compiled from: FilteringManifestParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e<T extends d<T>> implements i.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final i.a<? extends T> f53827a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final List<StreamKey> f53828b;

    public e(i.a<? extends T> aVar, @Nullable List<StreamKey> list) {
        this.f53827a = aVar;
        this.f53828b = list;
    }

    @Override // com.google.android.exoplayer2.upstream.i.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(Uri uri, InputStream inputStream) throws IOException {
        T a10 = this.f53827a.a(uri, inputStream);
        List<StreamKey> list = this.f53828b;
        return (list == null || list.isEmpty()) ? a10 : (T) a10.a(this.f53828b);
    }
}
