package org.bk.service;

import org.springframework.stereotype.Component;

@Component
public class NoOpHelper implements IServiceHelper {
    @Override
    public void help() {

    }
}
