package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.android.ExclusiveAppComponent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ActivityControlSurface {
    void attachToActivity(@NonNull ExclusiveAppComponent<Activity> exclusiveAppComponent, @NonNull Lifecycle lifecycle);

    void detachFromActivity();

    void detachFromActivityForConfigChanges();

    boolean onActivityResult(int i10, int i11, @Nullable Intent intent);

    void onNewIntent(@NonNull Intent intent);

    boolean onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr);

    void onRestoreInstanceState(@Nullable Bundle bundle);

    void onSaveInstanceState(@NonNull Bundle bundle);

    void onUserLeaveHint();
}
