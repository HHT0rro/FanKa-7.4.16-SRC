package java.time;

import java.time.Clock;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface InstantSource {
    Instant instant();

    static InstantSource system() {
        return Clock.SystemInstantSource.INSTANCE;
    }

    static InstantSource tick(InstantSource baseSource, Duration tickDuration) {
        Objects.requireNonNull(baseSource, "baseSource");
        return Clock.tick(baseSource.withZone(ZoneOffset.UTC), tickDuration);
    }

    static InstantSource fixed(Instant fixedInstant) {
        return Clock.fixed(fixedInstant, ZoneOffset.UTC);
    }

    static InstantSource offset(InstantSource baseSource, Duration offsetDuration) {
        Objects.requireNonNull(baseSource, "baseSource");
        return Clock.offset(baseSource.withZone(ZoneOffset.UTC), offsetDuration);
    }

    default long millis() {
        return instant().toEpochMilli();
    }

    default Clock withZone(ZoneId zone) {
        return new Clock.SourceClock(this, zone);
    }
}
