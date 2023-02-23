package io.github.justfeewee.justfeewees_pinchofspice.blocks;

import io.github.justfeewee.justfeewees_pinchofspice.blockentities.TinkerersWorkshopEntity;
import io.github.justfeewee.justfeewees_pinchofspice.init.BlockEntityInit;
import io.github.justfeewee.justfeewees_pinchofspice.menus.TinkerersWorkshopMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class TinkerersWorkshop extends Block implements EntityBlock {
    public TinkerersWorkshop(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityInit.TINKERERS_WORKSHOP.get().create(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(!level.isClientSide()) {
            if(level.getBlockEntity(pos) instanceof TinkerersWorkshopEntity tinkerers_workshop) {
                MenuConstructor menuConstructor = TinkerersWorkshopMenu.getServerMenu(tinkerers_workshop, pos);
                SimpleMenuProvider provider = new SimpleMenuProvider(menuConstructor, TinkerersWorkshopEntity.TITLE);
                NetworkHooks.openScreen((ServerPlayer) player, provider, pos );
            }
        }

        return InteractionResult.sidedSuccess(!level.isClientSide());
    }
}
