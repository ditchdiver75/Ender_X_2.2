
package net.mcreator.enderx22.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.enderx22.block.EXMarbleBrick2Block;
import net.mcreator.enderx22.EnderXModElements;

@EnderXModElements.ModElement.Tag
public class EnderXBlocksItemGroup extends EnderXModElements.ModElement {
	public EnderXBlocksItemGroup(EnderXModElements instance) {
		super(instance, 111);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabenderxblocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EXMarbleBrick2Block.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
