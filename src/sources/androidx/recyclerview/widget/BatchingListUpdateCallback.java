package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    public final ListUpdateCallback mWrapped;
    public int mLastEventType = 0;
    public int mLastEventPosition = -1;
    public int mLastEventCount = -1;
    public Object mLastEventPayload = null;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i10 = this.mLastEventType;
        if (i10 == 0) {
            return;
        }
        if (i10 == 1) {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        } else if (i10 == 2) {
            this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        } else if (i10 == 3) {
            this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i10, int i11, Object obj) {
        int i12;
        if (this.mLastEventType == 3) {
            int i13 = this.mLastEventPosition;
            int i14 = this.mLastEventCount;
            if (i10 <= i13 + i14 && (i12 = i10 + i11) >= i13 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i10, i13);
                this.mLastEventCount = Math.max(i14 + i13, i12) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i10;
        this.mLastEventCount = i11;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i10, int i11) {
        int i12;
        if (this.mLastEventType == 1 && i10 >= (i12 = this.mLastEventPosition)) {
            int i13 = this.mLastEventCount;
            if (i10 <= i12 + i13) {
                this.mLastEventCount = i13 + i11;
                this.mLastEventPosition = Math.min(i10, i12);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i10;
        this.mLastEventCount = i11;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i10, int i11) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i10, i11);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i10, int i11) {
        int i12;
        if (this.mLastEventType == 2 && (i12 = this.mLastEventPosition) >= i10 && i12 <= i10 + i11) {
            this.mLastEventCount += i11;
            this.mLastEventPosition = i10;
        } else {
            dispatchLastEvent();
            this.mLastEventPosition = i10;
            this.mLastEventCount = i11;
            this.mLastEventType = 2;
        }
    }
}
