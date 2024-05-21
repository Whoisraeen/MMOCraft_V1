package net.raeen.mmocraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.CameraType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MMOCraft.MOD_ID, value = Dist.CLIENT)
public class CameraHandler {

    private static boolean isThirdPersonView = false;

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Minecraft.getInstance().options.keyTogglePerspective.isDown()) {
            isThirdPersonView = !isThirdPersonView;
            Minecraft.getInstance().options.setCameraType(isThirdPersonView ? CameraType.THIRD_PERSON_BACK : CameraType.FIRST_PERSON);
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        // Additional camera updates or checks
    }
}
