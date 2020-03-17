
package net.mcreator.enderx22.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.enderx22.item.EXMachineFrameItem;
import net.mcreator.enderx22.EnderXModElements;

@EnderXModElements.ModElement.Tag
public class EnderXItemsItemGroup extends EnderXModElements.ModElement {
	public EnderXItemsItemGroup(EnderXModElements instance) {
		super(instance, 112);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabenderxitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EXMachineFrameItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
