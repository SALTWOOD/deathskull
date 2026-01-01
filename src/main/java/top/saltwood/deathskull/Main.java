package top.saltwood.deathskull;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import top.saltwood.deathskull.util.DeathHandle;

public class Main implements ModInitializer {
    // public static final String MOD_ID = "deathskull";

    @Override
    public void onInitialize() {
        registerPlayerDeathEvent();
    }

    private void registerPlayerDeathEvent() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {
            if (!(entity instanceof ServerPlayerEntity player)) return true;
            DeathHandle.handle(player);
            return true;
        });
    }
}