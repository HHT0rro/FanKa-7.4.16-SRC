package b1;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NinePatchChunk.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final C0020a f1235e = new C0020a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Rect f1236a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public int[] f1237b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f1238c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f1239d;

    /* compiled from: NinePatchChunk.kt */
    @d
    /* renamed from: b1.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0020a {
        public C0020a() {
        }

        public /* synthetic */ C0020a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i10) {
            if (i10 == 0 || (i10 & 1) != 0) {
                throw new RuntimeException("invalid nine-patch:" + i10);
            }
        }

        @Nullable
        public final a b(@NotNull byte[] data) {
            s.i(data, "data");
            ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.nativeOrder());
            int[] iArr = null;
            if (byteBuffer.get() == 0) {
                return null;
            }
            a aVar = new a();
            aVar.f1237b = new int[byteBuffer.get()];
            aVar.f1238c = new int[byteBuffer.get()];
            aVar.f1239d = new int[byteBuffer.get()];
            int[] iArr2 = aVar.f1237b;
            if (iArr2 == null) {
                s.A("mDivX");
                iArr2 = null;
            }
            a(iArr2.length);
            int[] iArr3 = aVar.f1238c;
            if (iArr3 == null) {
                s.A("mDivY");
                iArr3 = null;
            }
            a(iArr3.length);
            byteBuffer.getInt();
            byteBuffer.getInt();
            aVar.g().left = byteBuffer.getInt();
            aVar.g().right = byteBuffer.getInt();
            aVar.g().top = byteBuffer.getInt();
            aVar.g().bottom = byteBuffer.getInt();
            byteBuffer.getInt();
            int[] iArr4 = aVar.f1237b;
            if (iArr4 == null) {
                s.A("mDivX");
                iArr4 = null;
            }
            s.h(byteBuffer, "byteBuffer");
            c(iArr4, byteBuffer);
            int[] iArr5 = aVar.f1238c;
            if (iArr5 == null) {
                s.A("mDivY");
                iArr5 = null;
            }
            c(iArr5, byteBuffer);
            int[] iArr6 = aVar.f1239d;
            if (iArr6 == null) {
                s.A("mColor");
            } else {
                iArr = iArr6;
            }
            c(iArr, byteBuffer);
            return aVar;
        }

        public final void c(int[] iArr, ByteBuffer byteBuffer) {
            int length = iArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = byteBuffer.getInt();
            }
        }
    }

    @NotNull
    public final Rect g() {
        return this.f1236a;
    }
}
