package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Picture.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PictureKt {
    @NotNull
    public static final Picture record(@NotNull Picture picture, int i10, int i11, @NotNull Function1<? super Canvas, p> block) {
        s.i(picture, "<this>");
        s.i(block, "block");
        Canvas beginRecording = picture.beginRecording(i10, i11);
        s.h(beginRecording, "beginRecording(width, height)");
        try {
            block.invoke(beginRecording);
            return picture;
        } finally {
            r.b(1);
            picture.endRecording();
            r.a(1);
        }
    }
}
