package com.cupidapp.live.notify.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.ai.model.AiRcmdModel;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.notify.adapter.AiRcmdAdapter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AiRcmdLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiRcmdLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f17562d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17563e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiRcmdLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17563e = new LinkedHashMap();
        this.f17562d = c.b(new Function0<AiRcmdAdapter>() { // from class: com.cupidapp.live.notify.layout.AiRcmdLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AiRcmdAdapter invoke() {
                AiRcmdAdapter aiRcmdAdapter = new AiRcmdAdapter();
                final AiRcmdLayout aiRcmdLayout = AiRcmdLayout.this;
                aiRcmdAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.layout.AiRcmdLayout$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        AiRcmdAdapter adapter;
                        AiRcmdAdapter adapter2;
                        if (obj instanceof AiRcmdModel) {
                            AiRcmdModel aiRcmdModel = (AiRcmdModel) obj;
                            boolean z10 = !aiRcmdModel.isChecked();
                            adapter = AiRcmdLayout.this.getAdapter();
                            for (Object obj2 : adapter.j()) {
                                if (obj2 instanceof AiRcmdModel) {
                                    ((AiRcmdModel) obj2).setChecked(false);
                                }
                            }
                            aiRcmdModel.setChecked(z10);
                            adapter2 = AiRcmdLayout.this.getAdapter();
                            adapter2.notifyDataSetChanged();
                        }
                    }
                });
                return aiRcmdAdapter;
            }
        });
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AiRcmdAdapter getAdapter() {
        return (AiRcmdAdapter) this.f17562d.getValue();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f17563e;
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

    public final void g(@NotNull List<AiRcmdModel> list) {
        s.i(list, "list");
        getAdapter().j().clear();
        getAdapter().e(list);
        getAdapter().notifyDataSetChanged();
    }

    @Nullable
    public final AiRcmdModel getSelectedItem() {
        for (Object obj : getAdapter().j()) {
            if (obj instanceof AiRcmdModel) {
                AiRcmdModel aiRcmdModel = (AiRcmdModel) obj;
                if (aiRcmdModel.isChecked()) {
                    return aiRcmdModel;
                }
            }
        }
        return null;
    }

    public final void h() {
        z.a(this, R$layout.layout_ai_rcmd, true);
        int i10 = R$id.ai_rcmd_rv;
        ((RecyclerView) e(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) e(i10)).setAdapter(getAdapter());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiRcmdLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17563e = new LinkedHashMap();
        this.f17562d = c.b(new Function0<AiRcmdAdapter>() { // from class: com.cupidapp.live.notify.layout.AiRcmdLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AiRcmdAdapter invoke() {
                AiRcmdAdapter aiRcmdAdapter = new AiRcmdAdapter();
                final AiRcmdLayout aiRcmdLayout = AiRcmdLayout.this;
                aiRcmdAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.layout.AiRcmdLayout$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        AiRcmdAdapter adapter;
                        AiRcmdAdapter adapter2;
                        if (obj instanceof AiRcmdModel) {
                            AiRcmdModel aiRcmdModel = (AiRcmdModel) obj;
                            boolean z10 = !aiRcmdModel.isChecked();
                            adapter = AiRcmdLayout.this.getAdapter();
                            for (Object obj2 : adapter.j()) {
                                if (obj2 instanceof AiRcmdModel) {
                                    ((AiRcmdModel) obj2).setChecked(false);
                                }
                            }
                            aiRcmdModel.setChecked(z10);
                            adapter2 = AiRcmdLayout.this.getAdapter();
                            adapter2.notifyDataSetChanged();
                        }
                    }
                });
                return aiRcmdAdapter;
            }
        });
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiRcmdLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17563e = new LinkedHashMap();
        this.f17562d = c.b(new Function0<AiRcmdAdapter>() { // from class: com.cupidapp.live.notify.layout.AiRcmdLayout$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AiRcmdAdapter invoke() {
                AiRcmdAdapter aiRcmdAdapter = new AiRcmdAdapter();
                final AiRcmdLayout aiRcmdLayout = AiRcmdLayout.this;
                aiRcmdAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.layout.AiRcmdLayout$adapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        AiRcmdAdapter adapter;
                        AiRcmdAdapter adapter2;
                        if (obj instanceof AiRcmdModel) {
                            AiRcmdModel aiRcmdModel = (AiRcmdModel) obj;
                            boolean z10 = !aiRcmdModel.isChecked();
                            adapter = AiRcmdLayout.this.getAdapter();
                            for (Object obj2 : adapter.j()) {
                                if (obj2 instanceof AiRcmdModel) {
                                    ((AiRcmdModel) obj2).setChecked(false);
                                }
                            }
                            aiRcmdModel.setChecked(z10);
                            adapter2 = AiRcmdLayout.this.getAdapter();
                            adapter2.notifyDataSetChanged();
                        }
                    }
                });
                return aiRcmdAdapter;
            }
        });
        h();
    }
}
