package net.raeen.mmocraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class CharacterSelectionScreen extends Screen {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(MMOCraft.MOD_ID, "textures/gui/character_selection.png");

    protected CharacterSelectionScreen() {
        super(Component.literal("Character Selection"));
    }

    @Override
    protected void init() {
        this.addRenderableWidget(new Button(this.width / 2 - 100, this.height / 2 - 24, 200, 20, Component.literal("Create New Character"), button -> {
            // Handle character creation
            onCreateCharacter();
        }));
        this.addRenderableWidget(new Button(this.width / 2 - 100, this.height / 2 + 24, 200, 20, Component.literal("Load Character"), button -> {
            // Handle character loading
            onLoadCharacter();
        }));
    }

    private void onCreateCharacter() {
        // TODO: Implement character creation logic
    }

    private void onLoadCharacter() {
        // TODO: Implement character loading logic
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        blit(poseStack, 0, 0, this.width, this.height, 0, 0, this.width, this.height);
        super.render(poseStack, mouseX, mouseY, partialTicks);
    }
}
