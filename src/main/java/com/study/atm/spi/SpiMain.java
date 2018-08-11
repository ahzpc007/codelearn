package com.study.atm.spi;

import java.util.ServiceLoader;

public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<SpiInterface> loaders = ServiceLoader.load(SpiInterface.class);
        for (SpiInterface in : loaders){
            in.spiTest();
        }
    }
}
