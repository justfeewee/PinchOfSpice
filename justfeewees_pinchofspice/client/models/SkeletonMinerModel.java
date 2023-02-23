package io.github.justfeewee.justfeewees_pinchofspice.client.models;


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.justfeewee.justfeewees_pinchofspice.PinchOfSpice;
import io.github.justfeewee.justfeewees_pinchofspice.entities.SkeletonMiner;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class SkeletonMinerModel extends EntityModel<SkeletonMiner> implements ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(PinchOfSpice.MODID, "skeleton_miner"), "main");
	private final ModelPart head;
	private final ModelPart headwear;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	public HumanoidModel.ArmPose leftArmPose = HumanoidModel.ArmPose.EMPTY;
	public HumanoidModel.ArmPose rightArmPose = HumanoidModel.ArmPose.EMPTY;
	public boolean crouching;
	public float swimAmount;

	public SkeletonMinerModel(ModelPart root) {
		this.head = root.getChild("head");
		this.headwear = root.getChild("headwear");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		var mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition head = parts.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headwear = parts.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = parts.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = parts.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition right_arm = parts.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition left_leg = parts.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.1F));

		PartDefinition right_leg = parts.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.1F));

		return LayerDefinition.create(mesh, 64, 32);
	}

	public void prepareMobModel(SkeletonMiner entity, float p_103794_, float p_103795_, float p_103796_) {
		this.rightArmPose = HumanoidModel.ArmPose.EMPTY;
		this.leftArmPose = HumanoidModel.ArmPose.EMPTY;
		ItemStack itemstack = entity.getItemInHand(InteractionHand.MAIN_HAND);
		if (itemstack.is(Items.GOLDEN_PICKAXE) && entity.isAggressive()) {
			if (entity.getMainArm() == HumanoidArm.RIGHT) {
				this.rightArmPose = HumanoidModel.ArmPose.ITEM;
			} else {
				this.leftArmPose = HumanoidModel.ArmPose.EMPTY;
			}
		}

		super.prepareMobModel(entity, p_103794_, p_103795_, p_103796_);
	}

	@Override
	public void setupAnim(SkeletonMiner entity, float p_102867_, float p_102868_, float float4, float p_102870_, float p_102871_) {
		boolean flag = entity.getFallFlyingTicks() > 4;
		boolean flag1 = entity.isVisuallySwimming();
		this.head.yRot = p_102870_ * ((float) Math.PI / 180F);
		if (flag) {
			this.head.xRot = (-(float) Math.PI / 4F);
		} else if (this.swimAmount > 0.0F) {
			if (flag1) {
				this.head.xRot = this.rotlerpRad(this.swimAmount, this.head.xRot, (-(float) Math.PI / 4F));
			} else {
				this.head.xRot = this.rotlerpRad(this.swimAmount, this.head.xRot, p_102871_ * ((float) Math.PI / 180F));
			}
		} else {
			this.head.xRot = p_102871_ * ((float) Math.PI / 180F);
		}

		this.body.yRot = 0.0F;
		this.right_arm.z = 0.0F;
		this.right_arm.x = -5.0F;
		this.left_arm.z = 0.0F;
		this.left_arm.x = 5.0F;
		float f = 1.0F;
		if (flag) {
			f = (float) entity.getDeltaMovement().lengthSqr();
			f /= 0.2F;
			f *= f * f;
		}

		if (f < 1.0F) {
			f = 1.0F;
		}

		this.right_arm.xRot = Mth.cos(p_102867_ * 0.6662F + (float) Math.PI) * 2.0F * p_102868_ * 0.5F / f;
		this.left_arm.xRot = Mth.cos(p_102867_ * 0.6662F) * 2.0F * p_102868_ * 0.5F / f;
		this.right_arm.zRot = 0.0F;
		this.left_arm.zRot = 0.0F;
		this.right_leg.xRot = Mth.cos(p_102867_ * 0.6662F) * 1.4F * p_102868_ / f;
		this.left_leg.xRot = Mth.cos(p_102867_ * 0.6662F + (float) Math.PI) * 1.4F * p_102868_ / f;
		this.right_leg.yRot = 0.0F;
		this.left_leg.yRot = 0.0F;
		this.right_leg.zRot = 0.0F;
		this.left_leg.zRot = 0.0F;
		if (this.riding) {
			this.right_arm.xRot += (-(float) Math.PI / 5F);
			this.left_arm.xRot += (-(float) Math.PI / 5F);
			this.right_leg.xRot = -1.4137167F;
			this.right_leg.yRot = ((float) Math.PI / 10F);
			this.right_leg.zRot = 0.07853982F;
			this.left_leg.xRot = -1.4137167F;
			this.left_leg.yRot = (-(float) Math.PI / 10F);
			this.left_leg.zRot = -0.07853982F;
		}

		this.right_arm.yRot = 0.0F;
		this.left_arm.yRot = 0.0F;
		boolean flag2 = entity.getMainArm() == HumanoidArm.RIGHT;
		if (entity.isUsingItem()) {
			boolean flag3 = entity.getUsedItemHand() == InteractionHand.MAIN_HAND;
			if (flag3 == flag2) {
				this.poseRightArm(entity);
			} else {
				this.poseLeftArm(entity);
			}
		} else {
			boolean flag4 = flag2 ? this.leftArmPose.isTwoHanded() : this.rightArmPose.isTwoHanded();
			if (flag2 != flag4) {
				this.poseLeftArm(entity);
				this.poseRightArm(entity);
			} else {
				this.poseRightArm(entity);
				this.poseLeftArm(entity);
			}
		}

		this.setupAttackAnimation(entity, float4);
		if (this.crouching) {
			this.body.xRot = 0.5F;
			this.right_arm.xRot += 0.4F;
			this.left_arm.xRot += 0.4F;
			this.right_leg.z = 4.0F;
			this.left_leg.z = 4.0F;
			this.right_leg.y = 12.2F;
			this.left_leg.y = 12.2F;
			this.head.y = 4.2F;
			this.body.y = 3.2F;
			this.left_arm.y = 5.2F;
			this.right_arm.y = 5.2F;
		} else {
			this.body.xRot = 0.0F;
			this.right_leg.z = 0.1F;
			this.left_leg.z = 0.1F;
			this.right_leg.y = 12.0F;
			this.left_leg.y = 12.0F;
			this.head.y = 0.0F;
			this.body.y = 0.0F;
			this.left_arm.y = 2.0F;
			this.right_arm.y = 2.0F;
		}

		if (this.rightArmPose != HumanoidModel.ArmPose.SPYGLASS) {
			AnimationUtils.bobModelPart(this.right_arm, float4, 1.0F);
		}

		if (this.leftArmPose != HumanoidModel.ArmPose.SPYGLASS) {
			AnimationUtils.bobModelPart(this.left_arm, float4, -1.0F);
		}

		if (this.swimAmount > 0.0F) {
			float f5 = p_102867_ % 26.0F;
			HumanoidArm humanoidarm = this.getAttackArm(entity);
			float f1 = humanoidarm == HumanoidArm.RIGHT && this.attackTime > 0.0F ? 0.0F : this.swimAmount;
			float f2 = humanoidarm == HumanoidArm.LEFT && this.attackTime > 0.0F ? 0.0F : this.swimAmount;
			if (!entity.isUsingItem()) {
				if (f5 < 14.0F) {
					this.left_arm.xRot = this.rotlerpRad(f2, this.left_arm.xRot, 0.0F);
					this.right_arm.xRot = Mth.lerp(f1, this.right_arm.xRot, 0.0F);
					this.left_arm.yRot = this.rotlerpRad(f2, this.left_arm.yRot, (float)Math.PI);
					this.right_arm.yRot = Mth.lerp(f1, this.right_arm.yRot, (float)Math.PI);
					this.left_arm.zRot = this.rotlerpRad(f2, this.left_arm.zRot, (float)Math.PI + 1.8707964F * this.quadraticArmUpdate(f5) / this.quadraticArmUpdate(14.0F));
					this.right_arm.zRot = Mth.lerp(f1, this.right_arm.zRot, (float)Math.PI - 1.8707964F * this.quadraticArmUpdate(f5) / this.quadraticArmUpdate(14.0F));
				} else if (f5 >= 14.0F && f5 < 22.0F) {
					float f6 = (f5 - 14.0F) / 8.0F;
					this.left_arm.xRot = this.rotlerpRad(f2, this.left_arm.xRot, ((float)Math.PI / 2F) * f6);
					this.right_arm.xRot = Mth.lerp(f1, this.right_arm.xRot, ((float)Math.PI / 2F) * f6);
					this.left_arm.yRot = this.rotlerpRad(f2, this.left_arm.yRot, (float)Math.PI);
					this.right_arm.yRot = Mth.lerp(f1, this.right_arm.yRot, (float)Math.PI);
					this.left_arm.zRot = this.rotlerpRad(f2, this.left_arm.zRot, 5.012389F - 1.8707964F * f6);
					this.right_arm.zRot = Mth.lerp(f1, this.right_arm.zRot, 1.2707963F + 1.8707964F * f6);
				} else if (f5 >= 22.0F && f5 < 26.0F) {
					float f3 = (f5 - 22.0F) / 4.0F;
					this.left_arm.xRot = this.rotlerpRad(f2, this.left_arm.xRot, ((float)Math.PI / 2F) - ((float)Math.PI / 2F) * f3);
					this.right_arm.xRot = Mth.lerp(f1, this.right_arm.xRot, ((float)Math.PI / 2F) - ((float)Math.PI / 2F) * f3);
					this.left_arm.yRot = this.rotlerpRad(f2, this.left_arm.yRot, (float)Math.PI);
					this.right_arm.yRot = Mth.lerp(f1, this.right_arm.yRot, (float)Math.PI);
					this.left_arm.zRot = this.rotlerpRad(f2, this.left_arm.zRot, (float)Math.PI);
					this.right_arm.zRot = Mth.lerp(f1, this.right_arm.zRot, (float)Math.PI);
				}
			}
			float f7 = 0.3F;
			float f4 = 0.33333334F;
			this.left_leg.xRot = Mth.lerp(this.swimAmount, this.left_leg.xRot, 0.3F * Mth.cos(p_102867_ * 0.33333334F + (float)Math.PI));
			this.right_leg.xRot = Mth.lerp(this.swimAmount, this.right_leg.xRot, 0.3F * Mth.cos(p_102867_ * 0.33333334F));
		}
		this.headwear.copyFrom(this.head);

		ItemStack itemstack = entity.getMainHandItem();
		if (entity.isAggressive() && (itemstack.is(Items.GOLDEN_PICKAXE))) {
			AnimationUtils.animateZombieArms(this.left_arm, this.right_arm, entity.isAggressive(), this.attackTime, float4);

		}
	}
	private void poseRightArm(SkeletonMiner p_102876_){
		switch (this.rightArmPose) {
			case EMPTY:
				this.right_arm.yRot = 0.0F;
				break;
			case ITEM:
				this.right_arm.xRot = this.right_arm.xRot * 0.5F - ((float)Math.PI / 10F);
				this.right_arm.yRot = 0.0F;
		}
	}

	private void poseLeftArm(SkeletonMiner p_102879_) {
		switch (this.leftArmPose) {
			case EMPTY:
				this.left_arm.yRot = 0.0F;
				break;
			case ITEM:
				this.left_arm.xRot = this.left_arm.xRot * 0.5F - ((float)Math.PI / 10F);
				this.left_arm.yRot = 0.0F;

		}
	}
	protected void setupAttackAnimation(SkeletonMiner p_102858_, float p_102859_) {
		if (!(this.attackTime <= 0.0F)) {
			HumanoidArm humanoidarm = this.getAttackArm(p_102858_);
			ModelPart modelpart = this.getArm(humanoidarm);
			float f = this.attackTime;
			this.body.yRot = Mth.sin(Mth.sqrt(f) * ((float)Math.PI * 2F)) * 0.2F;
			if (humanoidarm == HumanoidArm.LEFT) {
				this.body.yRot *= -1.0F;
			}

			this.right_arm.z = Mth.sin(this.body.yRot) * 5.0F;
			this.right_arm.x = -Mth.cos(this.body.yRot) * 5.0F;
			this.left_arm.z = -Mth.sin(this.body.yRot) * 5.0F;
			this.left_arm.x = Mth.cos(this.body.yRot) * 5.0F;
			this.right_arm.yRot += this.body.yRot;
			this.left_arm.yRot += this.body.yRot;
			this.left_arm.xRot += this.body.yRot;
			f = 1.0F - this.attackTime;
			f *= f;
			f *= f;
			f = 1.0F - f;
			float f1 = Mth.sin(f * (float)Math.PI);
			float f2 = Mth.sin(this.attackTime * (float)Math.PI) * -(this.head.xRot - 0.7F) * 0.75F;
			modelpart.xRot -= f1 * 1.2F + f2;
			modelpart.yRot += this.body.yRot * 2.0F;
			modelpart.zRot += Mth.sin(this.attackTime * (float)Math.PI) * -0.4F;
		}
	}

	protected float rotlerpRad(float p_102836_, float p_102837_, float p_102838_) {
		float f = (p_102838_ - p_102837_) % ((float)Math.PI * 2F);
		if (f < -(float)Math.PI) {
			f += ((float)Math.PI * 2F);
		}

		if (f >= (float)Math.PI) {
			f -= ((float)Math.PI * 2F);
		}

		return p_102837_ + p_102836_ * f;
	}

	private float quadraticArmUpdate(float p_102834_) {
		return -65.0F * p_102834_ + p_102834_ * p_102834_;
	}

	public void copyPropertiesTo(HumanoidModel<SkeletonMiner> p_102873_) {
		super.copyPropertiesTo(p_102873_);
		p_102873_.leftArmPose = this.leftArmPose;
		p_102873_.rightArmPose = this.rightArmPose;
		p_102873_.crouching = this.crouching;
		p_102873_.head.copyFrom(this.head);
		p_102873_.body.copyFrom(this.body);
		p_102873_.rightArm.copyFrom(this.right_arm);
		p_102873_.leftArm.copyFrom(this.left_arm);
		p_102873_.rightLeg.copyFrom(this.right_leg);
		p_102873_.leftLeg.copyFrom(this.left_leg);
	}

	public void setAllVisible(boolean p_102880_) {
		this.head.visible = p_102880_;
		this.headwear.visible = p_102880_;
		this.body.visible = p_102880_;
		this.right_arm.visible = p_102880_;
		this.left_arm.visible = p_102880_;
		this.right_leg.visible = p_102880_;
		this.left_leg.visible = p_102880_;
	}

	public void translateToHand(HumanoidArm p_103778_, PoseStack p_103779_) {
		float f = p_103778_ == HumanoidArm.RIGHT ? 1.0F : -1.0F;
		ModelPart modelpart = this.getArm(p_103778_);
		modelpart.x += f;
		modelpart.translateAndRotate(p_103779_);
		modelpart.x -= f;
	}

	protected ModelPart getArm(HumanoidArm p_102852_) {
		return p_102852_ == HumanoidArm.LEFT ? this.left_arm : this.right_arm;
	}

	public ModelPart getHead() {
		return this.head;
	}

	private HumanoidArm getAttackArm(SkeletonMiner p_102857_) {
		HumanoidArm humanoidarm = p_102857_.getMainArm();
		return p_102857_.swingingArm == InteractionHand.MAIN_HAND ? humanoidarm : humanoidarm.getOpposite();
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headwear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}