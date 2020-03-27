
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
public class EXSworddiamondredstoneplateupgradeItem extends EnderXModElements.ModElement {
	@ObjectHolder("enderx22:exsworddiamondredstoneplateupgrade")
	public static final Item block = null;
	public EXSworddiamondredstoneplateupgradeItem(EnderXModElements instance) {
		super(instance, 268);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 9500;
			}

			public float getEfficiency() {
				return 24f;
			}

			public float getAttackDamage() {
				return 19f;
			}

			public int getHarvestLevel() {
				return 16;
			}

			public int getEnchantability() {
				return 90;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EXTitaniumIngotItem.block, (int) (1)));
			}
		}, 3, 1f, new Item.Properties().group(EnderXItemsItemGroup.tab)) {
		}.setRegistryName("exsworddiamondredstoneplateupgrade"));
	}
}
