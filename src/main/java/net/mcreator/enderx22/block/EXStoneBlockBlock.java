
package net.mcreator.enderx22.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IWorldReader;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.enderx22.itemgroup.EnderXBlocksItemGroup;
import net.mcreator.enderx22.EnderXModElements;

import java.util.List;
import java.util.Collections;

@EnderXModElements.ModElement.Tag
public class EXStoneBlockBlock extends EnderXModElements.ModElement {
	@ObjectHolder("enderx22:exstoneblock")
	public static final Block block = null;
	public EXStoneBlockBlock(EnderXModElements instance) {
		super(instance, 156);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(EnderXBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3f, 10f).lightValue(0).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("exstoneblock");
		}

		@Override
		public int tickRate(IWorldReader world) {
			return 0;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(ExCobblestoneBlockBlock.block, (int) (1)));
		}
	}
}
