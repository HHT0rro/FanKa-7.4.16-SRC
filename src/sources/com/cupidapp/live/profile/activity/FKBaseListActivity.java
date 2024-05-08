package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class FKBaseListActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17609r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17610q = new LinkedHashMap();

    /* compiled from: FKBaseListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* compiled from: FKBaseListActivity.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.profile.activity.FKBaseListActivity$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public /* synthetic */ class C0167a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f17611a;

            static {
                int[] iArr = new int[FKBaseListType.values().length];
                try {
                    iArr[FKBaseListType.BlackList.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FKBaseListType.DontLookHimList.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f17611a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull FKBaseListType listType) {
            Class cls;
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(listType, "listType");
            int i10 = C0167a.f17611a[listType.ordinal()];
            if (i10 == 1) {
                cls = UserBlackListActivity.class;
            } else {
                if (i10 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                cls = FKDontLookHimUserListActivity.class;
            }
            context.startActivity(new Intent(context, (Class<?>) cls));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17610q;
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

    @NotNull
    public abstract FKBaseFragment k1();

    @NotNull
    public abstract String l1();

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_base_list);
        FKTitleBarLayout onCreate$lambda$0 = (FKTitleBarLayout) j1(R$id.base_list_title_layout);
        kotlin.jvm.internal.s.h(onCreate$lambda$0, "onCreate$lambda$0");
        FKTitleBarLayout.setSingleTitle$default(onCreate$lambda$0, l1(), null, 2, null);
        onCreate$lambda$0.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FKBaseListActivity$onCreate$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKBaseListActivity.this.onBackPressed();
            }
        });
        FKBaseActivity.g1(this, k1(), false, R$id.base_list_container_layout, false, false, 24, null);
    }
}
