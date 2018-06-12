package com.shashakar.mcc.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCow - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelCentaur extends ModelBase {
    public ModelRenderer body_cow;
    public ModelRenderer udder;
    public ModelRenderer leg_back_left;
    public ModelRenderer leg_front_left;
    public ModelRenderer leg_back_right;
    public ModelRenderer leg_front_right;
    public ModelRenderer head_villager;
    public ModelRenderer nose_villager;
    public ModelRenderer arm_right_villager;
    public ModelRenderer arm_left_villager;
    public ModelRenderer hand_villager;
    public ModelRenderer chest_villager;
    public ModelRenderer coat_villager;

    public ModelCentaur() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.hand_villager = new ModelRenderer(this, 40, 38);
        this.hand_villager.setRotationPoint(0.0F, -12.0F, -1.0F);
        this.hand_villager.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(hand_villager, -0.7499679795819634F, 0.0F, 0.0F);
        this.head_villager = new ModelRenderer(this, 0, 0);
        this.head_villager.setRotationPoint(0.0F, -15.0F, 0.0F);
        this.head_villager.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.coat_villager = new ModelRenderer(this, 0, 38);
        this.coat_villager.setRotationPoint(0.0F, -15.0F, 0.0F);
        this.coat_villager.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.leg_back_right = new ModelRenderer(this, 0, 16);
        this.leg_back_right.setRotationPoint(-4.0F, 12.0F, 7.0F);
        this.leg_back_right.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg_front_right = new ModelRenderer(this, 0, 16);
        this.leg_front_right.setRotationPoint(-4.0F, 12.0F, -6.0F);
        this.leg_front_right.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.chest_villager = new ModelRenderer(this, 16, 20);
        this.chest_villager.setRotationPoint(0.0F, -15.0F, 0.0F);
        this.chest_villager.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.leg_front_left = new ModelRenderer(this, 0, 16);
        this.leg_front_left.setRotationPoint(4.0F, 12.0F, -6.0F);
        this.leg_front_left.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.arm_left_villager = new ModelRenderer(this, 44, 22);
        this.arm_left_villager.setRotationPoint(0.0F, -12.0F, -1.0F);
        this.arm_left_villager.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(arm_left_villager, -0.7499679795819634F, 0.0F, 0.0F);
        this.leg_back_left = new ModelRenderer(this, 0, 16);
        this.leg_back_left.setRotationPoint(4.0F, 12.0F, 7.0F);
        this.leg_back_left.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.udder = new ModelRenderer(this, 52, 0);
        this.udder.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.udder.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
        this.setRotateAngle(udder, 1.5707963267948966F, 0.0F, 0.0F);
        this.body_cow = new ModelRenderer(this, 18, 4);
        this.body_cow.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.body_cow.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.setRotateAngle(body_cow, 1.5707963267948966F, 0.0F, 0.0F);
        this.arm_right_villager = new ModelRenderer(this, 44, 22);
        this.arm_right_villager.setRotationPoint(0.0F, -12.0F, -1.0F);
        this.arm_right_villager.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(arm_right_villager, -0.7499679795819634F, 0.0F, 0.0F);
        this.nose_villager = new ModelRenderer(this, 24, 0);
        this.nose_villager.setRotationPoint(0.0F, -17.0F, 0.0F);
        this.nose_villager.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.hand_villager.render(f5);
        this.head_villager.render(f5);
        this.coat_villager.render(f5);
        this.leg_back_right.render(f5);
        this.leg_front_right.render(f5);
        this.chest_villager.render(f5);
        this.leg_front_left.render(f5);
        this.arm_left_villager.render(f5);
        this.leg_back_left.render(f5);
        this.udder.render(f5);
        this.body_cow.render(f5);
        this.arm_right_villager.render(f5);
        this.nose_villager.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.leg_front_left.rotateAngleX = MathHelper.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;
        this.leg_back_left.rotateAngleX = MathHelper.cos(limbSwing * .6662F) * 1.4F * limbSwingAmount;

        this.leg_front_right.rotateAngleX = MathHelper.cos(limbSwing * .6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg_back_right.rotateAngleX = MathHelper.cos(limbSwing * .6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.head_villager.rotateAngleY = netHeadYaw * .017453292F;
        this.head_villager.rotateAngleX = headPitch * .017453292F;
    }
}
