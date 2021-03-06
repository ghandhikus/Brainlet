# Brainlet

<img src="https://i.imgur.com/szd80IM.png" width="15%" height="15%" align="right"/>

Blackbox based AI for games. Provides multiple solutions for entity mood, goal picking and identity.

## Download


### Gradle
```gradle
repositories {
    // ...
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.ghandhikus:Brainlet:master'
}
```

### Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.ghandhikus</groupId>
    <artifactId>Brainlet</artifactId>
    <version>master</version>
</dependency>
```

## Brainlet Usage
```java
    // To use brainlet you need to override Brainlet class
    // 
    // Brainlet core parts:
    // 
    // - Long-term memory
    // - Short-term memory
    // - Sensorics
    // - Identity
    // - Mood
    // - Decision-making blackbox
    // 
    //
    // Additional information:
    // - For long-term memory you should use database that won't use RAM to avoid hauling megabytes of data.
    // 
    // 
    
import com.brainlet.BlackBox;
import com.brainlet.Brainlet;
import com.brainlet.identity.MBTIIdentity;
import com.brainlet.memories.RAMMemories;
/** import com.library.ai.SqliteMemories; */ // < provided by you
import com.brainlet.plutchik.PlutchikWheel;
/** import com.library.entity.Entity; */ // < provided by you

public class EntityBrainlet extends Brainlet implements BlackBox {

    private final Entity entity;

    public EntityBrainlet(Entity entity) {
        this.entity = entity;

        this.longMemory = new SqliteMemories();
        this.shortMemory = new RAMMemories();
        this.senses = new EntitySenses(entity);
        this.identity = new MBTIIdentity();
        this.mood = new PlutchikWheel();
        this.blackBox = this;
    }

    public Entity getEntity() { return entity; }
}

```
