package n6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;

/* compiled from: TrackSelector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public a f52144a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public o6.e f52145b;

    /* compiled from: TrackSelector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a();
    }

    public final o6.e a() {
        return (o6.e) com.google.android.exoplayer2.util.a.e(this.f52145b);
    }

    public final void b(a aVar, o6.e eVar) {
        this.f52144a = aVar;
        this.f52145b = eVar;
    }

    public final void c() {
        a aVar = this.f52144a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public abstract void d(@Nullable Object obj);

    public abstract TrackSelectorResult e(n1[] n1VarArr, TrackGroupArray trackGroupArray, s.a aVar, Timeline timeline) throws ExoPlaybackException;
}
