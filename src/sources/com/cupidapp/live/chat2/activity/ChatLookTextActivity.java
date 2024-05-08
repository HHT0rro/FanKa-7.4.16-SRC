package com.cupidapp.live.chat2.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: ChatLookTextActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatLookTextActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f13291r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13292q = new LinkedHashMap();

    /* compiled from: ChatLookTextActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable String str) {
            s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) ChatLookTextActivity.class);
            intent.putExtra("CHAT_LOOK_TEXT", str);
            context.startActivity(intent);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f13292q;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_chat_look_text);
        int i10 = R$id.chat_look_text_root_layout;
        ConstraintLayout chat_look_text_root_layout = (ConstraintLayout) j1(i10);
        s.h(chat_look_text_root_layout, "chat_look_text_root_layout");
        com.cupidapp.live.base.view.s.b(this, chat_look_text_root_layout);
        ((TextView) j1(R$id.chat_look_text_view)).setText(getIntent().getStringExtra("CHAT_LOOK_TEXT"));
        ConstraintLayout chat_look_text_root_layout2 = (ConstraintLayout) j1(i10);
        s.h(chat_look_text_root_layout2, "chat_look_text_root_layout");
        y.d(chat_look_text_root_layout2, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.activity.ChatLookTextActivity$onCreate$1
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
                ChatLookTextActivity.this.onBackPressed();
            }
        });
    }
}
