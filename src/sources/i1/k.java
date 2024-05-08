package i1;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.cupidapp.live.base.scrolltext.Direction;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: TextManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class k {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f49701i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Paint f49702a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final i1.a f49703b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Map<Character, Float> f49704c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<j> f49705d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public List<? extends List<Character>> f49706e;

    /* renamed from: f, reason: collision with root package name */
    public int f49707f;

    /* renamed from: g, reason: collision with root package name */
    public float f49708g;

    /* renamed from: h, reason: collision with root package name */
    public float f49709h;

    /* compiled from: TextManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k(@NotNull Paint textPaint, @NotNull i1.a charOrderManager) {
        s.i(textPaint, "textPaint");
        s.i(charOrderManager, "charOrderManager");
        this.f49702a = textPaint;
        this.f49703b = charOrderManager;
        this.f49704c = new LinkedHashMap(36);
        this.f49705d = new ArrayList();
        List<? extends List<Character>> emptyList = Collections.emptyList();
        s.h(emptyList, "emptyList()");
        this.f49706e = emptyList;
        l();
    }

    public final float a(char c4, @NotNull Paint textPaint) {
        s.i(textPaint, "textPaint");
        if (c4 == 0) {
            return 0.0f;
        }
        Float f10 = this.f49704c.get(Character.valueOf(c4));
        if (f10 != null) {
            return f10.floatValue();
        }
        float measureText = textPaint.measureText(String.valueOf(c4));
        this.f49704c.put(Character.valueOf(c4), Float.valueOf(measureText));
        return measureText;
    }

    public final void b(@NotNull Canvas canvas) {
        s.i(canvas, "canvas");
        for (j jVar : this.f49705d) {
            jVar.a(canvas);
            canvas.translate(jVar.g() + this.f49707f, 0.0f);
        }
    }

    @NotNull
    public final char[] c() {
        int size = this.f49705d.size();
        char[] cArr = new char[size];
        for (int i10 = 0; i10 < size; i10++) {
            cArr[i10] = this.f49705d.get(i10).f();
        }
        return cArr;
    }

    public final float d() {
        int max = this.f49707f * Math.max(0, this.f49705d.size() - 1);
        List<j> list = this.f49705d;
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<j> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(Float.valueOf(iterator2.next().g()));
        }
        float f10 = 0.0f;
        Iterator<E> iterator22 = arrayList.iterator2();
        while (iterator22.hasNext()) {
            f10 += ((Number) iterator22.next()).floatValue();
        }
        return f10 + max;
    }

    public final int e() {
        return this.f49707f;
    }

    public final float f() {
        return this.f49709h;
    }

    public final float g() {
        return this.f49708g;
    }

    public final void h() {
        Iterator<j> iterator2 = this.f49705d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().l();
        }
        this.f49703b.b();
    }

    public final void i(int i10) {
        this.f49707f = i10;
    }

    public final void j(@NotNull CharSequence targetText) {
        s.i(targetText, "targetText");
        String str = new String(c());
        int max = Math.max(str.length(), targetText.length());
        this.f49703b.c(str, targetText);
        this.f49705d.clear();
        for (int i10 = 0; i10 < max; i10++) {
            Pair<List<Character>, Direction> d10 = this.f49703b.d(str, targetText, i10);
            int i11 = i10;
            this.f49705d.add(new j(this, i11, this.f49702a, d10.component1(), d10.component2()));
        }
        List<j> list = this.f49705d;
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<j> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().e());
        }
        this.f49706e = arrayList;
    }

    public final void k(float f10) {
        e eVar = new e(0, ShadowDrawableWrapper.COS_45, f10, (char) 0, 0.0f, 24, null);
        List<j> list = this.f49705d;
        if (list.isEmpty()) {
            return;
        }
        ListIterator<j> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            int previousIndex = listIterator.previousIndex();
            j previous = listIterator.previous();
            c f11 = this.f49703b.f(eVar, previousIndex, this.f49706e, previous.h());
            eVar = previous.m(f11.a(), f11.b(), f11.c());
        }
    }

    public final void l() {
        this.f49704c.clear();
        Paint.FontMetrics fontMetrics = this.f49702a.getFontMetrics();
        float f10 = fontMetrics.bottom;
        float f11 = fontMetrics.top;
        this.f49708g = f10 - f11;
        this.f49709h = -f11;
        Iterator<j> iterator2 = this.f49705d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().k();
        }
    }
}
