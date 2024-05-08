package sb;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SVGAAudioEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f53688a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53689b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53690c;

    /* renamed from: d, reason: collision with root package name */
    public final int f53691d;

    /* renamed from: e, reason: collision with root package name */
    public final int f53692e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Integer f53693f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Integer f53694g;

    public a(@NotNull AudioEntity audioItem) {
        s.j(audioItem, "audioItem");
        this.f53688a = audioItem.audioKey;
        Integer num = audioItem.startFrame;
        this.f53689b = num != null ? num.intValue() : 0;
        Integer num2 = audioItem.endFrame;
        this.f53690c = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioItem.startTime;
        this.f53691d = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioItem.totalTime;
        this.f53692e = num4 != null ? num4.intValue() : 0;
    }

    public final int a() {
        return this.f53690c;
    }

    @Nullable
    public final Integer b() {
        return this.f53694g;
    }

    @Nullable
    public final Integer c() {
        return this.f53693f;
    }

    public final int d() {
        return this.f53689b;
    }

    public final void e(@Nullable Integer num) {
        this.f53694g = num;
    }

    public final void f(@Nullable Integer num) {
        this.f53693f = num;
    }
}
