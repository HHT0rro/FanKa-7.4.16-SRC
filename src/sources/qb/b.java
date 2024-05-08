package qb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SVGABitmapByteArrayDecoder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends c<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    public static final b f53192a = new b();

    @Override // qb.c
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Bitmap b(@NotNull byte[] data, @NotNull BitmapFactory.Options ops) {
        s.j(data, "data");
        s.j(ops, "ops");
        return BitmapFactory.decodeByteArray(data, 0, data.length, ops);
    }
}
