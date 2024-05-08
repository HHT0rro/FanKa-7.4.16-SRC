package io.grpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ChoiceServerCredentials extends ServerCredentials {
    private final List<ServerCredentials> creds;

    private ChoiceServerCredentials(ServerCredentials... serverCredentialsArr) {
        for (ServerCredentials serverCredentials : serverCredentialsArr) {
            Objects.requireNonNull(serverCredentials);
        }
        this.creds = Collections.unmodifiableList(new ArrayList(Arrays.asList(serverCredentialsArr)));
    }

    public static ServerCredentials create(ServerCredentials... serverCredentialsArr) {
        if (serverCredentialsArr.length != 0) {
            return new ChoiceServerCredentials(serverCredentialsArr);
        }
        throw new IllegalArgumentException("At least one credential is required");
    }

    public List<ServerCredentials> getCredentialsList() {
        return this.creds;
    }
}
