package com.cupidapp.live.chat.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: MiniTitleRichMessageLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MiniTitleRichMessageLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f13235b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13236c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniTitleRichMessageLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13236c = new LinkedHashMap();
        this.f13235b = kotlin.c.b(new Function0<Paint>() { // from class: com.cupidapp.live.chat.view.MiniTitleRichMessageLayout$paint$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint();
                Context context2 = MiniTitleRichMessageLayout.this.getContext();
                s.h(context2, "context");
                paint.setTextSize(h.w(context2, 12));
                return paint;
            }
        });
        c();
    }

    private final Paint getPaint() {
        return (Paint) this.f13235b.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13236c;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(@org.jetbrains.annotations.NotNull final com.cupidapp.live.chat2.model.ChatMessageModel r7) {
        /*
            r6 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.s.i(r7, r0)
            int r0 = com.cupidapp.live.R$id.richTitleTextView
            android.view.View r0 = r6.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r7.getTitle()
            r0.setText(r1)
            int r0 = com.cupidapp.live.R$id.richDescriptionTextView
            android.view.View r0 = r6.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r7.getDescription()
            r0.setText(r1)
            int r0 = com.cupidapp.live.R$id.miniTitleContainerLayout
            android.view.View r0 = r6.a(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.removeAllViews()
            java.util.List r0 = r7.getMiniTitleList()
            if (r0 == 0) goto L6e
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.t.t(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator2()
        L43:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L63
            java.lang.Object r2 = r0.next()
            com.cupidapp.live.chat2.model.MiniTitleModel r2 = (com.cupidapp.live.chat2.model.MiniTitleModel) r2
            java.lang.String r2 = r2.getMiniTitle()
            android.graphics.Paint r3 = r6.getPaint()
            float r2 = z0.t.f(r2, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r1.add(r2)
            goto L43
        L63:
            java.lang.Float r0 = kotlin.collections.CollectionsKt___CollectionsKt.h0(r1)
            if (r0 == 0) goto L6e
            float r0 = r0.floatValue()
            goto L6f
        L6e:
            r0 = 0
        L6f:
            java.util.List r1 = r7.getMiniTitleList()
            if (r1 == 0) goto La3
            java.util.Iterator r1 = r1.iterator2()
        L79:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto La3
            java.lang.Object r2 = r1.next()
            com.cupidapp.live.chat2.model.MiniTitleModel r2 = (com.cupidapp.live.chat2.model.MiniTitleModel) r2
            com.cupidapp.live.chat.view.MiniTitleLayout r3 = new com.cupidapp.live.chat.view.MiniTitleLayout
            android.content.Context r4 = r6.getContext()
            java.lang.String r5 = "context"
            kotlin.jvm.internal.s.h(r4, r5)
            r3.<init>(r4)
            int r4 = (int) r0
            r3.b(r2, r4)
            int r2 = com.cupidapp.live.R$id.miniTitleContainerLayout
            android.view.View r2 = r6.a(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r2.addView(r3)
            goto L79
        La3:
            int r0 = com.cupidapp.live.R$id.richAngleTextView
            android.view.View r0 = r6.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r7.getAngleText()
            r0.setText(r1)
            com.cupidapp.live.chat.view.MiniTitleRichMessageLayout$configMiniTitleRichUi$2 r0 = new com.cupidapp.live.chat.view.MiniTitleRichMessageLayout$configMiniTitleRichUi$2
            r0.<init>()
            z0.y.d(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat.view.MiniTitleRichMessageLayout.b(com.cupidapp.live.chat2.model.ChatMessageModel):void");
    }

    public final void c() {
        z.a(this, R$layout.layout_mini_title_rich_message_template, true);
        ((TextView) a(R$id.richTitleTextView)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.richAngleTextView)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniTitleRichMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13236c = new LinkedHashMap();
        this.f13235b = kotlin.c.b(new Function0<Paint>() { // from class: com.cupidapp.live.chat.view.MiniTitleRichMessageLayout$paint$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint();
                Context context2 = MiniTitleRichMessageLayout.this.getContext();
                s.h(context2, "context");
                paint.setTextSize(h.w(context2, 12));
                return paint;
            }
        });
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniTitleRichMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13236c = new LinkedHashMap();
        this.f13235b = kotlin.c.b(new Function0<Paint>() { // from class: com.cupidapp.live.chat.view.MiniTitleRichMessageLayout$paint$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint();
                Context context2 = MiniTitleRichMessageLayout.this.getContext();
                s.h(context2, "context");
                paint.setTextSize(h.w(context2, 12));
                return paint;
            }
        });
        c();
    }
}
