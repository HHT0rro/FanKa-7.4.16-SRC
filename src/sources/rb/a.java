package rb;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sb.g;
import tb.f;

/* compiled from: SGVADrawer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final f f53328a;

    /* renamed from: b, reason: collision with root package name */
    public final tb.a<C0812a> f53329b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final SVGAVideoEntity f53330c;

    /* compiled from: SGVADrawer.kt */
    @d
    /* renamed from: rb.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class C0812a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public String f53331a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public String f53332b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public g f53333c;

        public C0812a(@Nullable String str, @Nullable String str2, @Nullable g gVar) {
            this.f53331a = str;
            this.f53332b = str2;
            this.f53333c = gVar;
        }

        @NotNull
        public final g a() {
            g gVar = this.f53333c;
            if (gVar == null) {
                s.u();
            }
            return gVar;
        }

        @Nullable
        public final String b() {
            return this.f53332b;
        }

        @Nullable
        public final String c() {
            return this.f53331a;
        }

        public final void d(@Nullable g gVar) {
            this.f53333c = gVar;
        }

        public final void e(@Nullable String str) {
            this.f53332b = str;
        }

        public final void f(@Nullable String str) {
            this.f53331a = str;
        }

        public /* synthetic */ C0812a(a aVar, String str, String str2, g gVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : gVar);
        }
    }

    public a(@NotNull SVGAVideoEntity videoItem) {
        s.j(videoItem, "videoItem");
        this.f53330c = videoItem;
        this.f53328a = new f();
        this.f53329b = new tb.a<>(Math.max(1, videoItem.q().size()));
    }

    public void a(@NotNull Canvas canvas, int i10, @NotNull ImageView.ScaleType scaleType) {
        s.j(canvas, "canvas");
        s.j(scaleType, "scaleType");
        this.f53328a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f53330c.r().b(), (float) this.f53330c.r().a(), scaleType);
    }

    @NotNull
    public final f b() {
        return this.f53328a;
    }

    @NotNull
    public final SVGAVideoEntity c() {
        return this.f53330c;
    }

    public final void d(@NotNull List<C0812a> sprites) {
        s.j(sprites, "sprites");
        Iterator<C0812a> iterator2 = sprites.iterator2();
        while (iterator2.hasNext()) {
            this.f53329b.c(iterator2.next());
        }
    }

    @NotNull
    public final List<C0812a> e(int i10) {
        String b4;
        List<sb.f> q10 = this.f53330c.q();
        ArrayList arrayList = new ArrayList();
        for (sb.f fVar : q10) {
            C0812a c0812a = null;
            if (i10 >= 0 && i10 < fVar.a().size() && (b4 = fVar.b()) != null && (p.q(b4, ".matte", false, 2, null) || fVar.a().get(i10).a() > ShadowDrawableWrapper.COS_45)) {
                c0812a = this.f53329b.a();
                if (c0812a == null) {
                    c0812a = new C0812a(this, null, null, null, 7, null);
                }
                c0812a.f(fVar.c());
                c0812a.e(fVar.b());
                c0812a.d(fVar.a().get(i10));
            }
            if (c0812a != null) {
                arrayList.add(c0812a);
            }
        }
        return arrayList;
    }
}
