package i1;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.cupidapp.live.base.scrolltext.Direction;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: TextColumn.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final k f49690a;

    /* renamed from: b, reason: collision with root package name */
    public final int f49691b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Paint f49692c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public List<Character> f49693d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Direction f49694e;

    /* renamed from: f, reason: collision with root package name */
    public float f49695f;

    /* renamed from: g, reason: collision with root package name */
    public float f49696g;

    /* renamed from: h, reason: collision with root package name */
    public char f49697h;

    /* renamed from: i, reason: collision with root package name */
    public double f49698i;

    /* renamed from: j, reason: collision with root package name */
    public double f49699j;

    /* renamed from: k, reason: collision with root package name */
    public int f49700k;

    public j(@NotNull k manager, int i10, @NotNull Paint textPaint, @NotNull List<Character> changeCharList, @NotNull Direction direction) {
        char i11;
        s.i(manager, "manager");
        s.i(textPaint, "textPaint");
        s.i(changeCharList, "changeCharList");
        s.i(direction, "direction");
        this.f49690a = manager;
        this.f49691b = i10;
        this.f49692c = textPaint;
        this.f49693d = changeCharList;
        this.f49694e = direction;
        if (changeCharList.size() < 2) {
            i11 = j();
        } else {
            i11 = i();
        }
        this.f49697h = i11;
        k();
    }

    public static final void b(j jVar, Canvas canvas, int i10, float f10, float f11) {
        if (i10 < 0 || i10 >= jVar.f49693d.size() || jVar.f49693d.get(i10).charValue() == 0) {
            return;
        }
        canvas.drawText(c(jVar, i10), 0, 1, f10, f11, jVar.f49692c);
    }

    public static final char[] c(j jVar, int i10) {
        char[] cArr = new char[1];
        for (int i11 = 0; i11 < 1; i11++) {
            cArr[i11] = jVar.f49693d.get(i10).charValue();
        }
        return cArr;
    }

    public static /* synthetic */ void d(j jVar, Canvas canvas, int i10, float f10, float f11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            f10 = 0.0f;
        }
        if ((i11 & 16) != 0) {
            f11 = 0.0f;
        }
        b(jVar, canvas, i10, f10, f11);
    }

    public final void a(@NotNull Canvas canvas) {
        s.i(canvas, "canvas");
        if (this.f49694e.getOrientation() == 0) {
            d(this, canvas, this.f49700k + 1, ((float) this.f49699j) - (this.f49695f * this.f49694e.getValue()), 0.0f, 16, null);
            d(this, canvas, this.f49700k, (float) this.f49699j, 0.0f, 16, null);
            d(this, canvas, this.f49700k - 1, ((float) this.f49699j) + (this.f49695f * this.f49694e.getValue()), 0.0f, 16, null);
        } else {
            d(this, canvas, this.f49700k + 1, 0.0f, ((float) this.f49699j) - (this.f49690a.g() * this.f49694e.getValue()), 8, null);
            d(this, canvas, this.f49700k, 0.0f, (float) this.f49699j, 8, null);
            d(this, canvas, this.f49700k - 1, 0.0f, ((float) this.f49699j) + (this.f49690a.g() * this.f49694e.getValue()), 8, null);
        }
    }

    @NotNull
    public final List<Character> e() {
        return this.f49693d;
    }

    public final char f() {
        return this.f49697h;
    }

    public final float g() {
        return this.f49695f;
    }

    public final int h() {
        return this.f49700k;
    }

    public final char i() {
        if (this.f49693d.size() < 2) {
            return (char) 0;
        }
        return ((Character) CollectionsKt___CollectionsKt.T(this.f49693d)).charValue();
    }

    public final char j() {
        if (this.f49693d.isEmpty()) {
            return (char) 0;
        }
        return ((Character) CollectionsKt___CollectionsKt.e0(this.f49693d)).charValue();
    }

    public final void k() {
        float a10 = this.f49690a.a(this.f49697h, this.f49692c);
        this.f49695f = a10;
        this.f49696g = a10;
    }

    public final void l() {
        this.f49697h = j();
        this.f49699j = ShadowDrawableWrapper.COS_45;
        this.f49698i = ShadowDrawableWrapper.COS_45;
    }

    @NotNull
    public final e m(int i10, double d10, double d11) {
        double g3;
        int value;
        float a10;
        if (this.f49700k != i10) {
            this.f49696g = this.f49695f;
        }
        this.f49700k = i10;
        this.f49697h = this.f49693d.get(i10).charValue();
        double d12 = this.f49698i * (1.0d - d11);
        if (this.f49694e.getOrientation() == 0) {
            g3 = this.f49695f * d10;
            value = this.f49694e.getValue();
        } else {
            g3 = this.f49690a.g() * d10;
            value = this.f49694e.getValue();
        }
        this.f49699j = (g3 * value) + d12;
        if (d10 <= 0.5d) {
            a10 = this.f49690a.a(this.f49697h, this.f49692c);
        } else {
            List<Character> list = this.f49693d;
            a10 = this.f49690a.a(list.get(Math.min(i10 + 1, kotlin.collections.s.l(list))).charValue(), this.f49692c);
        }
        if (d10 > ShadowDrawableWrapper.COS_45) {
            a10 = (float) (((a10 - r0) * d10) + this.f49696g);
        }
        float f10 = a10;
        this.f49695f = f10;
        return new e(this.f49700k, d10, d11, this.f49697h, f10);
    }
}
