package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileTaskResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum TaskBtnStatus {
    UnDone(0),
    Auditing(1),
    ReWard(2),
    Done(3);


    @NotNull
    public static final a Companion = new a(null);
    private final int value;

    /* compiled from: ProfileTaskResult.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final TaskBtnStatus a(int i10) {
            TaskBtnStatus taskBtnStatus = TaskBtnStatus.UnDone;
            if (i10 == taskBtnStatus.getValue()) {
                return taskBtnStatus;
            }
            TaskBtnStatus taskBtnStatus2 = TaskBtnStatus.Done;
            if (i10 == taskBtnStatus2.getValue()) {
                return taskBtnStatus2;
            }
            TaskBtnStatus taskBtnStatus3 = TaskBtnStatus.Auditing;
            if (i10 == taskBtnStatus3.getValue()) {
                return taskBtnStatus3;
            }
            TaskBtnStatus taskBtnStatus4 = TaskBtnStatus.ReWard;
            if (i10 == taskBtnStatus4.getValue()) {
                return taskBtnStatus4;
            }
            return null;
        }
    }

    TaskBtnStatus(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
