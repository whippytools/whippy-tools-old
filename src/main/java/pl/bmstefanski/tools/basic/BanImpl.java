package pl.bmstefanski.tools.basic;

import pl.bmstefanski.tools.api.basic.Ban;

import java.util.UUID;

public class BanImpl implements Ban {

    private final UUID punished;
    private final UUID punisher;
    private String reason;
    private long time;

    public BanImpl(UUID punished, UUID punisher) {
        this.punished = punished;
        this.punisher = punisher;
    }

    @Override
    public UUID getPunished() {
        return punished;
    }

    @Override
    public UUID getPunisher() {
        return punisher;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public long getTime() {
        return time;
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public void setTime(long time) {
        this.time = time;
    }
}