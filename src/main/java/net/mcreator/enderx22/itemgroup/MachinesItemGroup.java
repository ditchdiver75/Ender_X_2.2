
package net.mcreator.enderx22.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.enderx22.item.EXMachineCaseItem;
import net.mcreator.enderx22.EnderXModElements;

@EnderXModElements.ModElement.Tag
public class MachinesItemGroup extends EnderXModElements.ModElement {
	public MachinesItemGroup(EnderXModElements instance) {
		super(instance, 238);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmachines") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EXMachineCaseItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
