package androidx.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface AudioAttributesImpl extends VersionedParcelable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Builder {
        @NonNull
        AudioAttributesImpl build();

        @NonNull
        Builder setContentType(int i10);

        @NonNull
        Builder setFlags(int i10);

        @NonNull
        Builder setLegacyStreamType(int i10);

        @NonNull
        Builder setUsage(int i10);
    }

    @Nullable
    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();
}
