package com.alimm.tanx.ui.image.glide;

import android.widget.AbsListView;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import com.alimm.tanx.ui.image.glide.request.target.BaseTarget;
import com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.List;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    public boolean isIncreasing;
    public int lastEnd;
    public int lastFirstVisible;
    public int lastStart;
    public final int maxPreload;
    public final PreloadSizeProvider<T> preloadDimensionProvider;
    public final PreloadModelProvider<T> preloadModelProvider;
    public final PreloadTargetQueue preloadTargetQueue;
    public int totalItemCount;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface PreloadModelProvider<U> {
        List<U> getPreloadItems(int i10);

        GenericRequestBuilder getPreloadRequestBuilder(U u10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface PreloadSizeProvider<T> {
        int[] getPreloadSize(T t2, int i10, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class PreloadTarget extends BaseTarget<Object> {
        public int photoHeight;
        public int photoWidth;

        public PreloadTarget() {
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public void getSize(SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public void onResourceReady(Object obj, GlideAnimation<? super Object> glideAnimation) {
        }

        public /* synthetic */ PreloadTarget(AnonymousClass1 anonymousClass1) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class PreloadTargetQueue {
        public final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int i10) {
            this.queue = Util.createQueue(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.queue.offer(new PreloadTarget(null));
            }
        }

        public PreloadTarget next(int i10, int i11) {
            PreloadTarget poll = this.queue.poll();
            this.queue.offer(poll);
            poll.photoWidth = i10;
            poll.photoHeight = i11;
            return poll;
        }
    }

    @Deprecated
    public ListPreloader(int i10) {
        this.isIncreasing = true;
        this.preloadModelProvider = new PreloadModelProvider<T>() { // from class: com.alimm.tanx.ui.image.glide.ListPreloader.1
            @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadModelProvider
            public List<T> getPreloadItems(int i11) {
                return ListPreloader.this.getItems(i11, i11 + 1);
            }

            @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadModelProvider
            public GenericRequestBuilder getPreloadRequestBuilder(T t2) {
                return ListPreloader.this.getRequestBuilder(t2);
            }
        };
        this.preloadDimensionProvider = new PreloadSizeProvider<T>() { // from class: com.alimm.tanx.ui.image.glide.ListPreloader.2
            @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider
            public int[] getPreloadSize(T t2, int i11, int i12) {
                return ListPreloader.this.getDimensions(t2);
            }
        };
        this.maxPreload = i10;
        this.preloadTargetQueue = new PreloadTargetQueue(i10 + 1);
    }

    private void cancelAll() {
        for (int i10 = 0; i10 < this.maxPreload; i10++) {
            Glide.clear(this.preloadTargetQueue.next(0, 0));
        }
    }

    private void preload(int i10, boolean z10) {
        if (this.isIncreasing != z10) {
            this.isIncreasing = z10;
            cancelAll();
        }
        preload(i10, (z10 ? this.maxPreload : -this.maxPreload) + i10);
    }

    private void preloadAdapterPosition(List<T> list, int i10, boolean z10) {
        int size = list.size();
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                preloadItem(list.get(i11), i10, i11);
            }
            return;
        }
        for (int i12 = size - 1; i12 >= 0; i12--) {
            preloadItem(list.get(i12), i10, i12);
        }
    }

    private void preloadItem(T t2, int i10, int i11) {
        int[] preloadSize = this.preloadDimensionProvider.getPreloadSize(t2, i10, i11);
        if (preloadSize != null) {
            this.preloadModelProvider.getPreloadRequestBuilder(t2).into((GenericRequestBuilder) this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
        }
    }

    @Deprecated
    public int[] getDimensions(T t2) {
        throw new IllegalStateException("You must either provide a PreloadDimensionProvider or override getDimensions()");
    }

    @Deprecated
    public List<T> getItems(int i10, int i11) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider or override getItems()");
    }

    @Deprecated
    public GenericRequestBuilder getRequestBuilder(T t2) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider, or override getRequestBuilder()");
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        this.totalItemCount = i12;
        int i13 = this.lastFirstVisible;
        if (i10 > i13) {
            preload(i11 + i10, true);
        } else if (i10 < i13) {
            preload(i10, false);
        }
        this.lastFirstVisible = i10;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }

    private void preload(int i10, int i11) {
        int min;
        int i12;
        if (i10 < i11) {
            i12 = Math.max(this.lastEnd, i10);
            min = i11;
        } else {
            min = Math.min(this.lastStart, i10);
            i12 = i11;
        }
        int min2 = Math.min(this.totalItemCount, min);
        int min3 = Math.min(this.totalItemCount, Math.max(0, i12));
        if (i10 < i11) {
            for (int i13 = min3; i13 < min2; i13++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i13), i13, true);
            }
        } else {
            for (int i14 = min2 - 1; i14 >= min3; i14--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i14), i14, false);
            }
        }
        this.lastStart = min3;
        this.lastEnd = min2;
    }

    public ListPreloader(PreloadModelProvider<T> preloadModelProvider, PreloadSizeProvider<T> preloadSizeProvider, int i10) {
        this.isIncreasing = true;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i10;
        this.preloadTargetQueue = new PreloadTargetQueue(i10 + 1);
    }
}
