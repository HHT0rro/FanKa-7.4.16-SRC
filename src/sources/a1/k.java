package a1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: BlurTransformation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f694a = new a(null);

    /* compiled from: BlurTransformation.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final android.graphics.Bitmap a(@org.jetbrains.annotations.NotNull android.content.Context r6, @org.jetbrains.annotations.NotNull android.graphics.Bitmap r7, float r8) {
            /*
                r5 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.s.i(r6, r0)
                java.lang.String r0 = "bitmap"
                kotlin.jvm.internal.s.i(r7, r0)
                r0 = 0
                android.renderscript.RenderScript r6 = android.renderscript.RenderScript.create(r6)     // Catch: java.lang.Throwable -> L55
                android.renderscript.RenderScript$RSMessageHandler r1 = new android.renderscript.RenderScript$RSMessageHandler     // Catch: java.lang.Throwable -> L4f
                r1.<init>()     // Catch: java.lang.Throwable -> L4f
                r6.setMessageHandler(r1)     // Catch: java.lang.Throwable -> L4f
                android.renderscript.Allocation$MipmapControl r1 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch: java.lang.Throwable -> L4f
                r2 = 1
                android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r6, r7, r1, r2)     // Catch: java.lang.Throwable -> L4f
                android.renderscript.Type r2 = r1.getType()     // Catch: java.lang.Throwable -> L4c
                android.renderscript.Allocation r2 = android.renderscript.Allocation.createTyped(r6, r2)     // Catch: java.lang.Throwable -> L4c
                android.renderscript.Element r3 = android.renderscript.Element.U8_4(r6)     // Catch: java.lang.Throwable -> L47
                android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r6, r3)     // Catch: java.lang.Throwable -> L47
                r0.setInput(r1)     // Catch: java.lang.Throwable -> L47
                r0.setRadius(r8)     // Catch: java.lang.Throwable -> L47
                r0.forEach(r2)     // Catch: java.lang.Throwable -> L47
                r2.copyTo(r7)     // Catch: java.lang.Throwable -> L47
                r6.destroy()
                r1.destroy()
                r2.destroy()
                r0.destroy()
                return r7
            L47:
                r7 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto L59
            L4c:
                r7 = move-exception
                r2 = r0
                goto L52
            L4f:
                r7 = move-exception
                r1 = r0
                r2 = r1
            L52:
                r0 = r6
                r6 = r2
                goto L59
            L55:
                r7 = move-exception
                r6 = r0
                r1 = r6
                r2 = r1
            L59:
                if (r0 == 0) goto L5e
                r0.destroy()
            L5e:
                if (r1 == 0) goto L63
                r1.destroy()
            L63:
                if (r2 == 0) goto L68
                r2.destroy()
            L68:
                if (r6 == 0) goto L6d
                r6.destroy()
            L6d:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: a1.k.a.a(android.content.Context, android.graphics.Bitmap, float):android.graphics.Bitmap");
        }
    }
}
