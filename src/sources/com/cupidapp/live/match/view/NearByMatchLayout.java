package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.adapter.NearbyMatchAdapter;
import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.match.model.NearMatchModel;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.track.group.MiniProfileShowType;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByMatchLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByMatchLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public v f16990d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16991e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f16992f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16993g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByMatchLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16993g = new LinkedHashMap();
        this.f16991e = 10;
        this.f16992f = kotlin.c.b(new Function0<NearbyMatchAdapter>() { // from class: com.cupidapp.live.match.view.NearByMatchLayout$matchAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NearbyMatchAdapter invoke() {
                NearbyMatchAdapter nearbyMatchAdapter = new NearbyMatchAdapter();
                final NearByMatchLayout nearByMatchLayout = NearByMatchLayout.this;
                nearbyMatchAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByMatchLayout$matchAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof NearMatchModel) {
                            NearMatchModel nearMatchModel = (NearMatchModel) obj;
                            if (nearMatchModel.getHide()) {
                                EventBus.c().l(new ShowPurchaseDialogEvent(VipPurchaseEntranceType.NearByMapFilter, "", PurchaseProductType.SVIP));
                            } else {
                                NearbyUserModel convertNearByUser = nearMatchModel.convertNearByUser();
                                if (convertNearByUser != null) {
                                    NearByMiniProfileActivity.f16517r.a(NearByMatchLayout.this.getContext(), convertNearByUser, SensorScene.NEARBY_MATCH, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : SensorPosition.Nearby, (r27 & 256) != 0 ? null : MiniProfileShowType.NEARBY_MATCH, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? false : false);
                                }
                            }
                        }
                    }
                });
                return nearbyMatchAdapter;
            }
        });
        h();
    }

    private final NearbyMatchAdapter getMatchAdapter() {
        return (NearbyMatchAdapter) this.f16992f.getValue();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16993g;
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

    public final void g(@NotNull List<NearMatchModel> matchList, int i10, @NotNull v listener) {
        kotlin.jvm.internal.s.i(matchList, "matchList");
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f16990d = listener;
        ((RecyclerView) e(R$id.match_recyclerview)).scrollToPosition(0);
        getMatchAdapter().j().clear();
        int size = matchList.size();
        int i11 = this.f16991e;
        if (size > i11) {
            matchList = matchList.subList(0, i11);
        }
        getMatchAdapter().e(matchList);
        getMatchAdapter().notifyDataSetChanged();
        TextView textView = (TextView) e(R$id.more_match_textview);
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String string = getContext().getString(R$string.near_match_count);
        kotlin.jvm.internal.s.h(string, "context.getString(R.string.near_match_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        textView.setText(format);
    }

    public final void h() {
        z0.z.a(this, R$layout.layout_near_by_match, true);
        TextView match_textview = (TextView) e(R$id.match_textview);
        kotlin.jvm.internal.s.h(match_textview, "match_textview");
        z0.u.a(match_textview);
        int i10 = R$id.match_recyclerview;
        RecyclerView recyclerView = (RecyclerView) e(i10);
        recyclerView.setAdapter(getMatchAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        NearbyMatchAdapter matchAdapter = getMatchAdapter();
        ExposureScene exposureScene = ExposureScene.NearbyMatch;
        RecyclerView match_recyclerview = (RecyclerView) e(i10);
        kotlin.jvm.internal.s.h(match_recyclerview, "match_recyclerview");
        matchAdapter.t(new RecyclerExposureHelper(exposureScene, match_recyclerview, 0.0f, 0L, null, new Function1<List<? extends h1.a>, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByMatchLayout$initView$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> list) {
                kotlin.jvm.internal.s.i(list, "list");
                Iterator<h1.a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof NearMatchModel) {
                        NearMatchModel nearMatchModel = (NearMatchModel) a10;
                        if (!nearMatchModel.getHide()) {
                            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                            String value = SensorScene.NEARBY_MATCH.getValue();
                            User user = nearMatchModel.getUser();
                            groupSocialLog.w(value, user != null ? user.userId() : null, (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : false);
                        }
                    }
                }
            }
        }, 28, null));
        TextView more_match_textview = (TextView) e(R$id.more_match_textview);
        kotlin.jvm.internal.s.h(more_match_textview, "more_match_textview");
        z0.y.d(more_match_textview, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByMatchLayout$initView$3
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
                v vVar;
                vVar = NearByMatchLayout.this.f16990d;
                if (vVar != null) {
                    vVar.a();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByMatchLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16993g = new LinkedHashMap();
        this.f16991e = 10;
        this.f16992f = kotlin.c.b(new Function0<NearbyMatchAdapter>() { // from class: com.cupidapp.live.match.view.NearByMatchLayout$matchAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NearbyMatchAdapter invoke() {
                NearbyMatchAdapter nearbyMatchAdapter = new NearbyMatchAdapter();
                final NearByMatchLayout nearByMatchLayout = NearByMatchLayout.this;
                nearbyMatchAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByMatchLayout$matchAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof NearMatchModel) {
                            NearMatchModel nearMatchModel = (NearMatchModel) obj;
                            if (nearMatchModel.getHide()) {
                                EventBus.c().l(new ShowPurchaseDialogEvent(VipPurchaseEntranceType.NearByMapFilter, "", PurchaseProductType.SVIP));
                            } else {
                                NearbyUserModel convertNearByUser = nearMatchModel.convertNearByUser();
                                if (convertNearByUser != null) {
                                    NearByMiniProfileActivity.f16517r.a(NearByMatchLayout.this.getContext(), convertNearByUser, SensorScene.NEARBY_MATCH, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : SensorPosition.Nearby, (r27 & 256) != 0 ? null : MiniProfileShowType.NEARBY_MATCH, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? false : false);
                                }
                            }
                        }
                    }
                });
                return nearbyMatchAdapter;
            }
        });
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByMatchLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16993g = new LinkedHashMap();
        this.f16991e = 10;
        this.f16992f = kotlin.c.b(new Function0<NearbyMatchAdapter>() { // from class: com.cupidapp.live.match.view.NearByMatchLayout$matchAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NearbyMatchAdapter invoke() {
                NearbyMatchAdapter nearbyMatchAdapter = new NearbyMatchAdapter();
                final NearByMatchLayout nearByMatchLayout = NearByMatchLayout.this;
                nearbyMatchAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.NearByMatchLayout$matchAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof NearMatchModel) {
                            NearMatchModel nearMatchModel = (NearMatchModel) obj;
                            if (nearMatchModel.getHide()) {
                                EventBus.c().l(new ShowPurchaseDialogEvent(VipPurchaseEntranceType.NearByMapFilter, "", PurchaseProductType.SVIP));
                            } else {
                                NearbyUserModel convertNearByUser = nearMatchModel.convertNearByUser();
                                if (convertNearByUser != null) {
                                    NearByMiniProfileActivity.f16517r.a(NearByMatchLayout.this.getContext(), convertNearByUser, SensorScene.NEARBY_MATCH, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : SensorPosition.Nearby, (r27 & 256) != 0 ? null : MiniProfileShowType.NEARBY_MATCH, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? false : false);
                                }
                            }
                        }
                    }
                });
                return nearbyMatchAdapter;
            }
        });
        h();
    }
}
