package com.brainlet.memories;

import com.brainlet.BrainletMemories;
import com.brainlet.BrainletMemory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class RAMMemories implements BrainletMemories {

    protected HashMap<String, Map<String, Object>> memories = new HashMap<>();

    /**
     *
     * @param memory
     * @return boolean on wheter previous memory was present
     */
    @Override
    public boolean store(BrainletMemory memory) {
        return memories.put(memory.getTag(), memory.getData()) != null;
    }

    /**
     * Attempts to find a memory in RAM.
     * @param memory
     * @return null valued future if memory is not there
     */
    @Override
    public CompletableFuture<BrainletMemory> get(String memory) {

        Map<String, Object> value = memories.get(memory);
        if(value == null)
            return CompletableFuture.completedFuture(null);

        return CompletableFuture.completedFuture(new BrainletMemory(memory, value));
    }
}
