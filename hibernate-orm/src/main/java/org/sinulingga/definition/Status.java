package org.sinulingga.definition;

public enum Status {
    ACTIVE(true), NOT_ACTIVE(false);

    private boolean status;

    private Status(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
