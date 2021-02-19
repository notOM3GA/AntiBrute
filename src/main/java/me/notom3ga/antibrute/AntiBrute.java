package me.notom3ga.antibrute;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class AntiBrute extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void spawn(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.PIGLIN_BRUTE) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void generate(ChunkLoadEvent event) {
        Entity[] entities = event.getChunk().getEntities();

        for (Entity entity : entities) {
            if (entity.getType() == EntityType.PIGLIN_BRUTE) {
                entity.remove();
            }
        }
    }
}
