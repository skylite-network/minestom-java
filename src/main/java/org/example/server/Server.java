package org.example.server;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.instance.LightingChunk;
import net.minestom.server.instance.block.Block;

public final class Server {
    public static void main(String[] args) {
        var server = MinecraftServer.init();
        var eventHandler = MinecraftServer.getGlobalEventHandler();
        var instanceManager = MinecraftServer.getInstanceManager();

        // Creating a world
        var instance = instanceManager.createInstanceContainer();
        instance.setChunkSupplier(LightingChunk::new);
        instance.setGenerator(unit ->
                unit.modifier().fillHeight(-64, 0, Block.STONE));

        instance.setTime(6000);
        instance.setTimeRate(0);

        // Set the player's spawning instance when they join
        eventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.setSpawningInstance(instance);
            event.getPlayer().setRespawnPoint(Pos.ZERO);
        });

        // Enable online mode and start the server
        MojangAuth.init();
        server.start("0.0.0.0", 25565);
    }
}
