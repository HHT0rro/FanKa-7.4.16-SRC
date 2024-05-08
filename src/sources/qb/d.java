package qb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SVGABitmapFileDecoder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends c<String> {

    /* renamed from: a, reason: collision with root package name */
    public static final d f53193a = new d();

    @Override // qb.c
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Bitmap b(@NotNull String data, @NotNull BitmapFactory.Options ops) {
        s.j(data, "data");
        s.j(ops, "ops");
        return BitmapFactory.decodeFile(data, ops);
    }
}
