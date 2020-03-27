
package net.mcreator.enderx22.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.enderx22.itemgroup.EnderXItemsItemGroup;
import net.mcreator.enderx22.EnderXModElements;

@EnderXModElements.ModElement.Tag
public class EXSorddiamondredstoneupgradeItem extends EnderXModElements.ModElement {
	@ObjectHolder("enderx22:exsorddiamondredstoneupgrade")
	public static final Item block = null;
	public EXSorddiamondredstoneupgradeItem(EnderXModElements instance) {
		super(instance, 267);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3500;
			}

			public float getEfficiency() {
				return 21f;
			}

			public float getAttackDamage() {
				return 16f;
			}

			public int getHarvestLevel() {
				return 14;
			}

			public int getEnchantability() {
				return 85;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EXTitaniumIngotItem.block, (int) (1)));
			}
		}, 3, 0f, new Item.Properties().group(EnderXItemsItemGroup.tab)) {
		}.setRegistryName("exsorddiamondredstoneupgrade"));
	}
}
