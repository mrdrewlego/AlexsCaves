package com.github.alexmodguy.alexscaves.client.render.entity;

import com.github.alexmodguy.alexscaves.client.model.SubterranodonModel;
import com.github.alexmodguy.alexscaves.client.render.entity.layer.SubterranodonRiderLayer;
import com.github.alexmodguy.alexscaves.server.entity.living.SubterranodonEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SubterranodonRenderer extends MobRenderer<SubterranodonEntity, SubterranodonModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("alexscaves:textures/entity/subterranodon.png");
    private static final ResourceLocation TEXTURE_RODAN = new ResourceLocation("alexscaves:textures/entity/subterranodon_rodan.png");
    private static final ResourceLocation TEXTURE_RETRO = new ResourceLocation("alexscaves:textures/entity/subterranodon_retro.png");

    public SubterranodonRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new SubterranodonModel(), 0.5F);
        this.addLayer(new SubterranodonRiderLayer(this));

    }

    public ResourceLocation getTextureLocation(SubterranodonEntity entity) {
        return entity.hasCustomName() && "rodan".equalsIgnoreCase(entity.getName().getString()) ? TEXTURE_RODAN : entity.isRetro() ? TEXTURE_RETRO : TEXTURE;
    }
}

