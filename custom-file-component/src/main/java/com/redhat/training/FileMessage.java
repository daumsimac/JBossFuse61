package com.redhat.training;

import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;

import java.io.File;

public class FileMessage extends DefaultMessage {
    private File file;

    public FileMessage() {
        this(new File("."));
    }

    public FileMessage(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileMessage: " + file;
    }

    @Override
    public DefaultExchange getExchange() {
        return (DefaultExchange) super.getExchange();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public FileMessage newInstance() {
        return new FileMessage();
    }

    @Override
    protected Object createBody() {
        return file;
    }
}
