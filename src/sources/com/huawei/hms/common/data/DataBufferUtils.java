package com.huawei.hms.common.data;

import android.os.Bundle;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class DataBufferUtils {
    public static final int ARGS_BUNDLE = 4;
    public static final int ARGS_COLUMN = 1;
    public static final int ARGS_CURSOR = 2;
    public static final int ARGS_STATUS = 3;
    public static final int ARGS_VERSION = 1000;
    public static final String NEXT_PAGE = "next_page";
    public static final String PREV_PAGE = "prev_page";

    private DataBufferUtils() {
    }

    private static boolean a(Bundle bundle, String str) {
        return (bundle == null || bundle.getString(str) == null) ? false : true;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        if (dataBuffer == null) {
            return new ArrayList<>();
        }
        ViewGroup.ChildListForAutoFillOrContentCapture childListForAutoFillOrContentCapture = (ArrayList<T>) new ArrayList(dataBuffer.getCount());
        Iterator<E> iterator2 = dataBuffer.iterator2();
        while (iterator2.hasNext()) {
            childListForAutoFillOrContentCapture.add(iterator2.next().freeze());
        }
        dataBuffer.release();
        return childListForAutoFillOrContentCapture;
    }

    public static boolean hasData(DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean hasNextPage(DataBuffer<?> dataBuffer) {
        if (dataBuffer == null) {
            return false;
        }
        return a(dataBuffer.getMetadata(), NEXT_PAGE);
    }

    public static boolean hasPrevPage(DataBuffer<?> dataBuffer) {
        if (dataBuffer == null) {
            return false;
        }
        return a(dataBuffer.getMetadata(), PREV_PAGE);
    }
}
