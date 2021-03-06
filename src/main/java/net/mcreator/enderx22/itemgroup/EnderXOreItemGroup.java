
package net.mcreator.enderx22.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.enderx22.block.EXNetherDiamondBlock;
import net.mcreator.enderx22.EnderXModElements;

@EnderXModElements.ModElement.Tag
public class EnderXOreItemGroup extends EnderXModElements.ModElement {
	public EnderXOreItemGroup(EnderXModElements instance) {
		super(instance, 110);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabenderxore") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EXNetherDiamondBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
