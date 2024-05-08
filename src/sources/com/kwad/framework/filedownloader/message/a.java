package com.kwad.framework.filedownloader.message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface a {

    /* renamed from: com.kwad.framework.filedownloader.message.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0501a extends MessageSnapshot implements a {
        private final MessageSnapshot ahl;

        public C0501a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.tV() == -3) {
                this.ahl = messageSnapshot;
                return;
            }
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tV())));
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte tV() {
            return (byte) 4;
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot vX() {
            return this.ahl;
        }
    }

    MessageSnapshot vX();
}
