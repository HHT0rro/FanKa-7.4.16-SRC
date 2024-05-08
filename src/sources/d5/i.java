package d5;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import java.util.List;
import java.util.Map;

/* compiled from: ExtractorsFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f48635a = new i() { // from class: d5.g
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            return h.b();
        }
    };

    Extractor[] a(Uri uri, Map<String, List<String>> map);

    Extractor[] b();
}
