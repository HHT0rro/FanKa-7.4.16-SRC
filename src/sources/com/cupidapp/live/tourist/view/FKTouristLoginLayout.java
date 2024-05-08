package com.cupidapp.live.tourist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKTouristLoginLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKTouristLoginLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public long f18693b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18694c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function0<p> f18695d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18696e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKTouristLoginLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18696e = new LinkedHashMap();
        c();
    }

    public static final boolean d(FKTouristLoginLayout this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            return this$0.f18694c;
        }
        if (action != 1) {
            return false;
        }
        this$0.b(R$id.gesture_view).performClick();
        if (this$0.f18694c) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this$0.f18693b > 300) {
                Function0<p> function0 = this$0.f18695d;
                if (function0 != null) {
                    function0.invoke();
                }
                this$0.f18693b = currentTimeMillis;
            }
        }
        return true;
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f18696e;
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

    public final void c() {
        z.a(this, R$layout.layout_tourist_login, true);
        Context context = getContext();
        s.h(context, "context");
        int i10 = R$id.top_gesture_view;
        View top_gesture_view = b(i10);
        s.h(top_gesture_view, "top_gesture_view");
        com.cupidapp.live.base.view.s.b(context, top_gesture_view);
        View top_gesture_view2 = b(i10);
        s.h(top_gesture_view2, "top_gesture_view");
        y.d(top_gesture_view2, new Function1<View, p>() { // from class: com.cupidapp.live.tourist.view.FKTouristLoginLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Function0<p> jumpToLoginCallback = FKTouristLoginLayout.this.getJumpToLoginCallback();
                if (jumpToLoginCallback != null) {
                    jumpToLoginCallback.invoke();
                }
            }
        });
        b(R$id.gesture_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.tourist.view.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d10;
                d10 = FKTouristLoginLayout.d(FKTouristLoginLayout.this, view, motionEvent);
                return d10;
            }
        });
        FKUniversalButton tourist_login_button = (FKUniversalButton) b(R$id.tourist_login_button);
        s.h(tourist_login_button, "tourist_login_button");
        y.d(tourist_login_button, new Function1<View, p>() { // from class: com.cupidapp.live.tourist.view.FKTouristLoginLayout$initView$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Function0<p> jumpToLoginCallback = FKTouristLoginLayout.this.getJumpToLoginCallback();
                if (jumpToLoginCallback != null) {
                    jumpToLoginCallback.invoke();
                }
            }
        });
    }

    public final boolean getIntercept() {
        return this.f18694c;
    }

    @Nullable
    public final Function0<p> getJumpToLoginCallback() {
        return this.f18695d;
    }

    public final void setIntercept(boolean z10) {
        this.f18694c = z10;
    }

    public final void setJumpToLoginCallback(@Nullable Function0<p> function0) {
        this.f18695d = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKTouristLoginLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18696e = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKTouristLoginLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18696e = new LinkedHashMap();
        c();
    }
}
