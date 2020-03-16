
package net.mcreator.enderx22.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.enderx22.itemgroup.EnderXItemsItemGroup;
import net.mcreator.enderx22.EnderXModElements;

@EnderXModElements.ModElement.Tag
public class EXRubberTreeResinItem extends EnderXModElements.ModElement {
	@ObjectHolder("enderx22:exrubbertreeresin")
	public static final Item block = null;
	public EXRubberTreeResinItem(EnderXModElements instance) {
		super(instance, 84);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(EnderXItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("exrubbertreeresin");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
