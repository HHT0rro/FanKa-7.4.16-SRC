package com.cupidapp.live.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.chat.model.ChatStatusItemModel;
import com.cupidapp.live.chat.view.CellularLayout;
import com.cupidapp.live.profile.model.PostLimitReadStatus;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: CellularParentLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CellularParentLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public float f13213b;

    /* renamed from: c, reason: collision with root package name */
    public float f13214c;

    /* renamed from: d, reason: collision with root package name */
    public float f13215d;

    /* renamed from: e, reason: collision with root package name */
    public float f13216e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public a f13217f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13218g;

    /* compiled from: CellularParentLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(@NotNull User user);

        void b(@NotNull User user);
    }

    /* compiled from: CellularParentLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements CellularLayout.a {
        public b() {
        }

        @Override // com.cupidapp.live.chat.view.CellularLayout.a
        public void a(@NotNull User user) {
            s.i(user, "user");
            a aVar = CellularParentLayout.this.f13217f;
            if (aVar != null) {
                aVar.a(user);
            }
            TextView textView = (TextView) CellularParentLayout.this.a(R$id.user_state_txt);
            ChatStatusItemModel chatStatus = user.getChatStatus();
            textView.setText(chatStatus != null ? chatStatus.getContent() : null);
            ((TextView) CellularParentLayout.this.a(R$id.user_state_time_txt)).setText(user.getChatStatusTime());
            ((ImageView) CellularParentLayout.this.a(R$id.cellular_image_border)).setImageResource(s.d(user.getReadStatus(), PostLimitReadStatus.UnRead.getValue()) ? R$mipmap.ic_state_selected : R$mipmap.icon_cellular_image_border);
        }

        @Override // com.cupidapp.live.chat.view.CellularLayout.a
        public void b(@NotNull User user) {
            s.i(user, "user");
            a aVar = CellularParentLayout.this.f13217f;
            if (aVar != null) {
                aVar.b(user);
            }
        }

        @Override // com.cupidapp.live.chat.view.CellularLayout.a
        public void c() {
            ((ImageView) CellularParentLayout.this.a(R$id.cellular_image_shadow)).setVisibility(8);
            ((ImageView) CellularParentLayout.this.a(R$id.cellular_image_border)).setVisibility(8);
            ((LinearLayout) CellularParentLayout.this.a(R$id.state_ll)).setVisibility(8);
        }

        @Override // com.cupidapp.live.chat.view.CellularLayout.a
        public void d(@NotNull ImageLoaderView view) {
            s.i(view, "view");
            CellularParentLayout cellularParentLayout = CellularParentLayout.this;
            int i10 = R$id.cellular_image_shadow;
            if (((ImageView) cellularParentLayout.a(i10)).getVisibility() != 0) {
                ((ImageView) CellularParentLayout.this.a(i10)).setVisibility(0);
            }
            CellularParentLayout cellularParentLayout2 = CellularParentLayout.this;
            int i11 = R$id.cellular_image_border;
            if (((ImageView) cellularParentLayout2.a(i11)).getVisibility() != 0) {
                ((ImageView) CellularParentLayout.this.a(i11)).setVisibility(0);
            }
            CharSequence text = ((TextView) CellularParentLayout.this.a(R$id.user_state_txt)).getText();
            s.h(text, "user_state_txt.text");
            if (text.length() > 0) {
                ((LinearLayout) CellularParentLayout.this.a(R$id.state_ll)).setVisibility(0);
            } else {
                ((LinearLayout) CellularParentLayout.this.a(R$id.state_ll)).setVisibility(8);
            }
            CellularParentLayout cellularParentLayout3 = CellularParentLayout.this;
            float f10 = cellularParentLayout3.f13213b;
            ImageView cellular_image_shadow = (ImageView) CellularParentLayout.this.a(i10);
            s.h(cellular_image_shadow, "cellular_image_shadow");
            cellularParentLayout3.m(view, f10, cellular_image_shadow);
            CellularParentLayout cellularParentLayout4 = CellularParentLayout.this;
            float f11 = cellularParentLayout4.f13214c;
            ImageView cellular_image_border = (ImageView) CellularParentLayout.this.a(i11);
            s.h(cellular_image_border, "cellular_image_border");
            cellularParentLayout4.m(view, f11, cellular_image_border);
            CellularParentLayout cellularParentLayout5 = CellularParentLayout.this;
            float f12 = cellularParentLayout5.f13215d;
            float f13 = CellularParentLayout.this.f13216e;
            int c4 = h.c(this, 14.0f);
            LinearLayout state_ll = (LinearLayout) CellularParentLayout.this.a(R$id.state_ll);
            s.h(state_ll, "state_ll");
            cellularParentLayout5.l(view, f12, f13, c4, state_ll);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellularParentLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13218g = new LinkedHashMap();
        this.f13213b = h.c(this, 120.0f) / h.c(this, 155.0f);
        this.f13214c = h.c(this, 120.0f) / h.c(this, 126.0f);
        this.f13215d = h.c(this, 120.0f) / h.c(this, 130.0f);
        this.f13216e = h.c(this, 120.0f) / h.c(this, 50.0f);
        k();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13218g;
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

    public final void i(@NotNull List<User> readUserList) {
        s.i(readUserList, "readUserList");
        ((CellularLayout) a(R$id.cellular_layout)).f(readUserList);
    }

    public final void j(@NotNull List<User> userList) {
        s.i(userList, "userList");
        ((CellularLayout) a(R$id.cellular_layout)).h(userList);
        User user = (User) CollectionsKt___CollectionsKt.V(userList);
        if ((user != null ? user.getChatStatus() : null) != null) {
            TextView textView = (TextView) a(R$id.user_state_txt);
            ChatStatusItemModel chatStatus = user.getChatStatus();
            textView.setText(chatStatus != null ? chatStatus.getContent() : null);
            ((TextView) a(R$id.user_state_time_txt)).setText(user.getChatStatusTime());
            ((LinearLayout) a(R$id.state_ll)).setVisibility(0);
        } else {
            ((LinearLayout) a(R$id.state_ll)).setVisibility(8);
        }
        ((ImageView) a(R$id.cellular_image_border)).setImageResource(s.d(user != null ? user.getReadStatus() : null, PostLimitReadStatus.UnRead.getValue()) ? R$mipmap.ic_state_selected : R$mipmap.icon_cellular_image_border);
    }

    public final void k() {
        z.a(this, R$layout.layout_cellular_parent, true);
        ((CellularLayout) a(R$id.cellular_layout)).setCellularListener(new b());
    }

    public final void l(ImageLoaderView imageLoaderView, float f10, float f11, int i10, View view) {
        float width = ((imageLoaderView.getWidth() / f10) - imageLoaderView.getWidth()) / 2.0f;
        view.layout((int) (imageLoaderView.getLeft() - width), ((int) (imageLoaderView.getTop() - ((imageLoaderView.getHeight() / f11) - imageLoaderView.getHeight()))) + i10, (int) (imageLoaderView.getRight() + width), imageLoaderView.getBottom() + i10);
    }

    public final void m(ImageLoaderView imageLoaderView, float f10, View view) {
        float width = ((imageLoaderView.getWidth() / f10) - imageLoaderView.getWidth()) / 2.0f;
        view.layout((int) (imageLoaderView.getLeft() - width), (int) (imageLoaderView.getTop() - width), (int) (imageLoaderView.getRight() + width), (int) (imageLoaderView.getBottom() + width));
    }

    public final void setCellularParentListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f13217f = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellularParentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13218g = new LinkedHashMap();
        this.f13213b = h.c(this, 120.0f) / h.c(this, 155.0f);
        this.f13214c = h.c(this, 120.0f) / h.c(this, 126.0f);
        this.f13215d = h.c(this, 120.0f) / h.c(this, 130.0f);
        this.f13216e = h.c(this, 120.0f) / h.c(this, 50.0f);
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellularParentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13218g = new LinkedHashMap();
        this.f13213b = h.c(this, 120.0f) / h.c(this, 155.0f);
        this.f13214c = h.c(this, 120.0f) / h.c(this, 126.0f);
        this.f13215d = h.c(this, 120.0f) / h.c(this, 130.0f);
        this.f13216e = h.c(this, 120.0f) / h.c(this, 50.0f);
        k();
    }
}
