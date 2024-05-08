package com.cupidapp.live.setting.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.network.model.EquityModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.setting.holder.UserServiceViewHolder;
import h1.a;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserServiceListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserServiceListAdapter extends MutableColumnRecyclerAdapter {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final RecyclerView f18100g;

    public UserServiceListAdapter(@NotNull RecyclerView recyclerView) {
        s.i(recyclerView, "recyclerView");
        this.f18100g = recyclerView;
        k().add(EquityModel.class);
        t(new RecyclerExposureHelper(ExposureScene.ProfileService, recyclerView, 0.0f, 0L, null, new Function1<List<? extends a>, p>() { // from class: com.cupidapp.live.setting.adapter.UserServiceListAdapter.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends a> list) {
                invoke2((List<a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<a> itemList) {
                s.i(itemList, "itemList");
                Iterator<a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof EquityModel) {
                        SensorsLogKeyButtonClick.UserSetting userSetting = SensorsLogKeyButtonClick.UserSetting.CustomName;
                        String trackName = ((EquityModel) a10).getTrackName();
                        if (trackName == null) {
                            trackName = "";
                        }
                        userSetting.setButtonName(trackName);
                        userSetting.show();
                    }
                }
            }
        }, 28, null));
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        UserServiceViewHolder a10 = UserServiceViewHolder.f18197c.a(parent);
        a10.k(l());
        return a10;
    }
}
