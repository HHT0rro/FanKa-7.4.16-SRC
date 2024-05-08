package com.huawei.flexiblelayout.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.data.FLDataSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface AdapterBuilder {
    RecyclerView.Adapter newAdapter(@NonNull Context context, @NonNull FLDataSource fLDataSource);
}
