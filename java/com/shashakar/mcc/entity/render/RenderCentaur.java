package com.shashakar.mcc.entity.render;

import com.shashakar.mcc.entity.EntityCentaur;
import com.shashakar.mcc.entity.model.ModelCentaur;
import com.shashakar.mcc.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import javax.annotation.Resource;

public class RenderCentaur extends RenderLiving<EntityCentaur> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/centaur.png");
    public RenderCentaur(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCentaur(), .5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCentaur entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCentaur entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
