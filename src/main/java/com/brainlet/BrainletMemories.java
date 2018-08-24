package com.brainlet;

import java.util.concurrent.CompletableFuture;

public interface BrainletMemories {

    boolean store(BrainletMemory memory);
    CompletableFuture<BrainletMemory> get(String memory);
}
