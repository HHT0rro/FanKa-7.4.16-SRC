package com.android.internal.os;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.Preconditions;
import dalvik.annotation.optimization.CriticalNative;
import dalvik.annotation.optimization.FastNative;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import libcore.util.NativeAllocationRegistry;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class LongArrayMultiStateCounter implements Parcelable {
    private final int mLength;
    final long mNativeObject;
    private final int mStateCount;
    private static final NativeAllocationRegistry sRegistry = NativeAllocationRegistry.createMalloced(LongArrayMultiStateCounter.class.getClassLoader(), native_getReleaseFunc());
    private static final AtomicReference<LongArrayContainer> sTmpArrayContainer = new AtomicReference<>();
    public static final Parcelable.Creator<LongArrayMultiStateCounter> CREATOR = new Parcelable.Creator<LongArrayMultiStateCounter>() { // from class: com.android.internal.os.LongArrayMultiStateCounter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LongArrayMultiStateCounter createFromParcel(Parcel in) {
            return new LongArrayMultiStateCounter(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LongArrayMultiStateCounter[] newArray(int size) {
            return new LongArrayMultiStateCounter[size];
        }
    };

    @CriticalNative
    private static native void native_addCounts(long j10, long j11);

    @CriticalNative
    private static native int native_getArrayLength(long j10);

    @CriticalNative
    private static native void native_getCounts(long j10, long j11, int i10);

    @CriticalNative
    private static native long native_getReleaseFunc();

    @CriticalNative
    private static native int native_getStateCount(long j10);

    @CriticalNative
    private static native long native_init(int i10, int i11);

    @FastNative
    private static native long native_initFromParcel(Parcel parcel);

    @CriticalNative
    private static native void native_reset(long j10);

    @CriticalNative
    private static native void native_setEnabled(long j10, boolean z10, long j11);

    @CriticalNative
    private static native void native_setState(long j10, int i10, long j11);

    @FastNative
    private native String native_toString(long j10);

    @CriticalNative
    private static native void native_updateValues(long j10, long j11, long j12);

    @FastNative
    private native void native_writeToParcel(long j10, Parcel parcel, int i10);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class LongArrayContainer {
        private static final NativeAllocationRegistry sRegistry = NativeAllocationRegistry.createMalloced(LongArrayContainer.class.getClassLoader(), native_getReleaseFunc());
        private final int mLength;
        final long mNativeObject;

        @FastNative
        private native boolean native_combineValues(long j10, long[] jArr, int[] iArr);

        @CriticalNative
        private static native long native_getReleaseFunc();

        @FastNative
        private native void native_getValues(long j10, long[] jArr);

        @CriticalNative
        private static native long native_init(int i10);

        @FastNative
        private native void native_setValues(long j10, long[] jArr);

        public LongArrayContainer(int length) {
            this.mLength = length;
            long native_init = native_init(length);
            this.mNativeObject = native_init;
            sRegistry.registerNativeAllocation(this, native_init);
        }

        public void setValues(long[] array) {
            if (array.length != this.mLength) {
                throw new IllegalArgumentException("Invalid array length: " + this.mLength + ", expected: " + this.mLength);
            }
            native_setValues(this.mNativeObject, array);
        }

        public void getValues(long[] array) {
            if (array.length != this.mLength) {
                throw new IllegalArgumentException("Invalid array length: " + this.mLength + ", expected: " + this.mLength);
            }
            native_getValues(this.mNativeObject, array);
        }

        public boolean combineValues(long[] array, int[] indexMap) {
            if (indexMap.length != this.mLength) {
                throw new IllegalArgumentException("Wrong index map size " + indexMap.length + ", expected " + this.mLength);
            }
            return native_combineValues(this.mNativeObject, array, indexMap);
        }

        public String toString() {
            long[] array = new long[this.mLength];
            getValues(array);
            return Arrays.toString(array);
        }
    }

    public LongArrayMultiStateCounter(int stateCount, int arrayLength) {
        Preconditions.checkArgumentPositive(stateCount, "stateCount must be greater than 0");
        this.mStateCount = stateCount;
        this.mLength = arrayLength;
        long native_init = native_init(stateCount, arrayLength);
        this.mNativeObject = native_init;
        sRegistry.registerNativeAllocation(this, native_init);
    }

    private LongArrayMultiStateCounter(Parcel in) {
        long native_initFromParcel = native_initFromParcel(in);
        this.mNativeObject = native_initFromParcel;
        sRegistry.registerNativeAllocation(this, native_initFromParcel);
        this.mStateCount = native_getStateCount(native_initFromParcel);
        this.mLength = native_getArrayLength(native_initFromParcel);
    }

    public int getStateCount() {
        return this.mStateCount;
    }

    public int getArrayLength() {
        return this.mLength;
    }

    public void setEnabled(boolean enabled, long timestampMs) {
        native_setEnabled(this.mNativeObject, enabled, timestampMs);
    }

    public void setState(int state, long timestampMs) {
        if (state < 0 || state >= this.mStateCount) {
            throw new IllegalArgumentException("State: " + state + ", outside the range: [0-" + (this.mStateCount - 1) + "]");
        }
        native_setState(this.mNativeObject, state, timestampMs);
    }

    public void updateValues(LongArrayContainer longArrayContainer, long timestampMs) {
        if (longArrayContainer.mLength != this.mLength) {
            throw new IllegalArgumentException("Invalid array length: " + longArrayContainer.mLength + ", expected: " + this.mLength);
        }
        native_updateValues(this.mNativeObject, longArrayContainer.mNativeObject, timestampMs);
    }

    public void addCounts(LongArrayContainer counts) {
        if (counts.mLength != this.mLength) {
            throw new IllegalArgumentException("Invalid array length: " + counts.mLength + ", expected: " + this.mLength);
        }
        native_addCounts(this.mNativeObject, counts.mNativeObject);
    }

    public void reset() {
        native_reset(this.mNativeObject);
    }

    public void getCounts(long[] counts, int state) {
        AtomicReference<LongArrayContainer> atomicReference = sTmpArrayContainer;
        LongArrayContainer container = atomicReference.getAndSet(null);
        if (container == null || container.mLength != counts.length) {
            container = new LongArrayContainer(counts.length);
        }
        getCounts(container, state);
        container.getValues(counts);
        atomicReference.set(container);
    }

    public void getCounts(LongArrayContainer longArrayContainer, int state) {
        if (state < 0 || state >= this.mStateCount) {
            throw new IllegalArgumentException("State: " + state + ", outside the range: [0-" + this.mStateCount + "]");
        }
        native_getCounts(this.mNativeObject, longArrayContainer.mNativeObject, state);
    }

    public String toString() {
        return native_toString(this.mNativeObject);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        native_writeToParcel(this.mNativeObject, dest, flags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
