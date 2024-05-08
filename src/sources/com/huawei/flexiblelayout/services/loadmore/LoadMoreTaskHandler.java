package com.huawei.flexiblelayout.services.loadmore;

import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.services.task.JavaTaskHandler;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LoadMoreTaskHandler extends JavaTaskHandler {
    public LoadMoreTaskHandler(FLMap fLMap) {
        super(fLMap);
    }

    @Override // com.huawei.flexiblelayout.services.task.JavaTaskHandler
    public void onExecute(FLayout fLayout, final FLMap fLMap) {
        LoadMoreService loadMoreService = (LoadMoreService) fLayout.getEngine().getService(LoadMoreService.class, fLayout);
        if (loadMoreService != null) {
            LoadMoreListener loadMoreListener = loadMoreService.getLoadMoreListener();
            FLDataGroup.Cursor cursor = fLayout.getDataSource().getCursor(getPosition());
            if (cursor == null) {
                return;
            }
            final FLDataGroup dataGroup = cursor.getDataGroup();
            final FLNodeData current = cursor.current();
            loadMoreListener.onLoad(fLayout, fLMap, current, new LoadedCallback() { // from class: com.huawei.flexiblelayout.services.loadmore.LoadMoreTaskHandler.1
                @Override // com.huawei.flexiblelayout.services.loadmore.LoadedCallback
                public void fail(Exception exc) {
                    LoadMoreTaskHandler.this.fail(exc);
                    current.update();
                }

                @Override // com.huawei.flexiblelayout.services.loadmore.LoadedCallback
                public void success() {
                    LoadMoreTaskHandler.this.success();
                    current.update();
                    FLMap fLMap2 = fLMap;
                    if (fLMap2 == null || !fLMap2.optBoolean("keep", false)) {
                        dataGroup.removeData(current);
                    }
                }
            });
        }
    }
}
