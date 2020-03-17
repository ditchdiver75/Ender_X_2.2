
package net.mcreator.enderx22.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;

import net.mcreator.enderx22.EnderXModElements;
import net.mcreator.enderx22.EnderXMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@EnderXModElements.ModElement.Tag
public class LargeChestGuiGui extends EnderXModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public LargeChestGuiGui(EnderXModElements instance) {
		super(instance, 96);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		ScreenManager.registerFactory(containerType, GuiWindow::new);
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("largechestgui"));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private World world;
		private PlayerEntity entity;
		private int x, y, z;
		private IInventory internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new Inventory(126);
			if (extraData != null) {
				BlockPos pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
				TileEntity ent = inv.player != null ? inv.player.world.getTileEntity(pos) : null;
				if (ent instanceof IInventory)
					this.internal = (IInventory) ent;
			}
			internal.openInventory(inv.player);
			this.customSlots.put(0, this.addSlot(new Slot(internal, 0, -37, 1) {
			}));
			this.customSlots.put(1, this.addSlot(new Slot(internal, 1, -19, 1) {
			}));
			this.customSlots.put(2, this.addSlot(new Slot(internal, 2, -1, 1) {
			}));
			this.customSlots.put(3, this.addSlot(new Slot(internal, 3, 17, 1) {
			}));
			this.customSlots.put(4, this.addSlot(new Slot(internal, 4, 35, 1) {
			}));
			this.customSlots.put(5, this.addSlot(new Slot(internal, 5, 53, 1) {
			}));
			this.customSlots.put(6, this.addSlot(new Slot(internal, 6, 71, 1) {
			}));
			this.customSlots.put(7, this.addSlot(new Slot(internal, 7, 89, 1) {
			}));
			this.customSlots.put(8, this.addSlot(new Slot(internal, 8, 107, 1) {
			}));
			this.customSlots.put(9, this.addSlot(new Slot(internal, 9, 125, 1) {
			}));
			this.customSlots.put(10, this.addSlot(new Slot(internal, 10, 143, 1) {
			}));
			this.customSlots.put(11, this.addSlot(new Slot(internal, 11, 161, 1) {
			}));
			this.customSlots.put(12, this.addSlot(new Slot(internal, 12, 179, 1) {
			}));
			this.customSlots.put(13, this.addSlot(new Slot(internal, 13, 197, 1) {
			}));
			this.customSlots.put(14, this.addSlot(new Slot(internal, 14, -37, 19) {
			}));
			this.customSlots.put(15, this.addSlot(new Slot(internal, 15, -19, 19) {
			}));
			this.customSlots.put(16, this.addSlot(new Slot(internal, 16, -1, 19) {
			}));
			this.customSlots.put(17, this.addSlot(new Slot(internal, 17, 17, 19) {
			}));
			this.customSlots.put(18, this.addSlot(new Slot(internal, 18, 35, 19) {
			}));
			this.customSlots.put(19, this.addSlot(new Slot(internal, 19, 53, 19) {
			}));
			this.customSlots.put(20, this.addSlot(new Slot(internal, 20, 71, 19) {
			}));
			this.customSlots.put(21, this.addSlot(new Slot(internal, 21, 89, 19) {
			}));
			this.customSlots.put(22, this.addSlot(new Slot(internal, 22, 107, 19) {
			}));
			this.customSlots.put(23, this.addSlot(new Slot(internal, 23, 125, 19) {
			}));
			this.customSlots.put(24, this.addSlot(new Slot(internal, 24, 143, 19) {
			}));
			this.customSlots.put(25, this.addSlot(new Slot(internal, 25, 161, 19) {
			}));
			this.customSlots.put(26, this.addSlot(new Slot(internal, 26, 179, 19) {
			}));
			this.customSlots.put(27, this.addSlot(new Slot(internal, 27, 197, 19) {
			}));
			this.customSlots.put(28, this.addSlot(new Slot(internal, 28, -37, 37) {
			}));
			this.customSlots.put(29, this.addSlot(new Slot(internal, 29, -19, 37) {
			}));
			this.customSlots.put(30, this.addSlot(new Slot(internal, 30, -1, 37) {
			}));
			this.customSlots.put(31, this.addSlot(new Slot(internal, 31, 17, 37) {
			}));
			this.customSlots.put(32, this.addSlot(new Slot(internal, 32, 35, 37) {
			}));
			this.customSlots.put(33, this.addSlot(new Slot(internal, 33, 53, 37) {
			}));
			this.customSlots.put(34, this.addSlot(new Slot(internal, 34, 71, 37) {
			}));
			this.customSlots.put(35, this.addSlot(new Slot(internal, 35, 89, 37) {
			}));
			this.customSlots.put(36, this.addSlot(new Slot(internal, 36, 107, 37) {
			}));
			this.customSlots.put(37, this.addSlot(new Slot(internal, 37, 125, 37) {
			}));
			this.customSlots.put(38, this.addSlot(new Slot(internal, 38, 143, 37) {
			}));
			this.customSlots.put(39, this.addSlot(new Slot(internal, 39, 161, 37) {
			}));
			this.customSlots.put(40, this.addSlot(new Slot(internal, 40, 179, 37) {
			}));
			this.customSlots.put(41, this.addSlot(new Slot(internal, 41, 197, 37) {
			}));
			this.customSlots.put(42, this.addSlot(new Slot(internal, 42, -37, 55) {
			}));
			this.customSlots.put(43, this.addSlot(new Slot(internal, 43, -19, 55) {
			}));
			this.customSlots.put(44, this.addSlot(new Slot(internal, 44, -1, 55) {
			}));
			this.customSlots.put(45, this.addSlot(new Slot(internal, 45, 17, 55) {
			}));
			this.customSlots.put(46, this.addSlot(new Slot(internal, 46, 35, 55) {
			}));
			this.customSlots.put(47, this.addSlot(new Slot(internal, 47, 53, 55) {
			}));
			this.customSlots.put(48, this.addSlot(new Slot(internal, 48, 71, 55) {
			}));
			this.customSlots.put(49, this.addSlot(new Slot(internal, 49, 89, 55) {
			}));
			this.customSlots.put(50, this.addSlot(new Slot(internal, 50, 107, 55) {
			}));
			this.customSlots.put(51, this.addSlot(new Slot(internal, 51, 125, 55) {
			}));
			this.customSlots.put(52, this.addSlot(new Slot(internal, 52, 143, 55) {
			}));
			this.customSlots.put(53, this.addSlot(new Slot(internal, 53, 161, 55) {
			}));
			this.customSlots.put(54, this.addSlot(new Slot(internal, 54, 179, 55) {
			}));
			this.customSlots.put(55, this.addSlot(new Slot(internal, 55, 197, 55) {
			}));
			this.customSlots.put(56, this.addSlot(new Slot(internal, 56, -37, 73) {
			}));
			this.customSlots.put(57, this.addSlot(new Slot(internal, 57, -19, 73) {
			}));
			this.customSlots.put(58, this.addSlot(new Slot(internal, 58, -1, 73) {
			}));
			this.customSlots.put(59, this.addSlot(new Slot(internal, 59, 17, 73) {
			}));
			this.customSlots.put(60, this.addSlot(new Slot(internal, 60, 35, 73) {
			}));
			this.customSlots.put(61, this.addSlot(new Slot(internal, 61, 53, 73) {
			}));
			this.customSlots.put(62, this.addSlot(new Slot(internal, 62, 71, 73) {
			}));
			this.customSlots.put(63, this.addSlot(new Slot(internal, 63, 89, 73) {
			}));
			this.customSlots.put(64, this.addSlot(new Slot(internal, 64, 107, 73) {
			}));
			this.customSlots.put(65, this.addSlot(new Slot(internal, 65, 125, 73) {
			}));
			this.customSlots.put(66, this.addSlot(new Slot(internal, 66, 143, 73) {
			}));
			this.customSlots.put(67, this.addSlot(new Slot(internal, 67, 161, 73) {
			}));
			this.customSlots.put(68, this.addSlot(new Slot(internal, 68, 179, 73) {
			}));
			this.customSlots.put(69, this.addSlot(new Slot(internal, 69, 197, 73) {
			}));
			this.customSlots.put(70, this.addSlot(new Slot(internal, 70, -37, 91) {
			}));
			this.customSlots.put(71, this.addSlot(new Slot(internal, 71, -19, 91) {
			}));
			this.customSlots.put(72, this.addSlot(new Slot(internal, 72, -1, 91) {
			}));
			this.customSlots.put(73, this.addSlot(new Slot(internal, 73, 17, 91) {
			}));
			this.customSlots.put(74, this.addSlot(new Slot(internal, 74, 35, 91) {
			}));
			this.customSlots.put(75, this.addSlot(new Slot(internal, 75, 53, 91) {
			}));
			this.customSlots.put(76, this.addSlot(new Slot(internal, 76, 71, 91) {
			}));
			this.customSlots.put(77, this.addSlot(new Slot(internal, 77, 89, 91) {
			}));
			this.customSlots.put(78, this.addSlot(new Slot(internal, 78, 107, 91) {
			}));
			this.customSlots.put(79, this.addSlot(new Slot(internal, 79, 125, 91) {
			}));
			this.customSlots.put(80, this.addSlot(new Slot(internal, 80, 143, 91) {
			}));
			this.customSlots.put(81, this.addSlot(new Slot(internal, 81, 161, 91) {
			}));
			this.customSlots.put(82, this.addSlot(new Slot(internal, 82, 179, 91) {
			}));
			this.customSlots.put(83, this.addSlot(new Slot(internal, 83, 197, 91) {
			}));
			this.customSlots.put(84, this.addSlot(new Slot(internal, 84, -37, 109) {
			}));
			this.customSlots.put(85, this.addSlot(new Slot(internal, 85, -19, 109) {
			}));
			this.customSlots.put(86, this.addSlot(new Slot(internal, 86, -1, 109) {
			}));
			this.customSlots.put(87, this.addSlot(new Slot(internal, 87, 17, 109) {
			}));
			this.customSlots.put(88, this.addSlot(new Slot(internal, 88, 35, 109) {
			}));
			this.customSlots.put(89, this.addSlot(new Slot(internal, 89, 53, 109) {
			}));
			this.customSlots.put(90, this.addSlot(new Slot(internal, 90, 71, 109) {
			}));
			this.customSlots.put(91, this.addSlot(new Slot(internal, 91, 89, 109) {
			}));
			this.customSlots.put(92, this.addSlot(new Slot(internal, 92, 107, 109) {
			}));
			this.customSlots.put(93, this.addSlot(new Slot(internal, 93, 125, 109) {
			}));
			this.customSlots.put(94, this.addSlot(new Slot(internal, 94, 143, 109) {
			}));
			this.customSlots.put(95, this.addSlot(new Slot(internal, 95, 161, 109) {
			}));
			this.customSlots.put(96, this.addSlot(new Slot(internal, 96, 179, 109) {
			}));
			this.customSlots.put(97, this.addSlot(new Slot(internal, 97, 197, 109) {
			}));
			this.customSlots.put(98, this.addSlot(new Slot(internal, 98, -37, 127) {
			}));
			this.customSlots.put(99, this.addSlot(new Slot(internal, 99, -19, 127) {
			}));
			this.customSlots.put(100, this.addSlot(new Slot(internal, 100, -1, 127) {
			}));
			this.customSlots.put(101, this.addSlot(new Slot(internal, 101, 17, 127) {
			}));
			this.customSlots.put(102, this.addSlot(new Slot(internal, 102, 35, 127) {
			}));
			this.customSlots.put(103, this.addSlot(new Slot(internal, 103, 53, 127) {
			}));
			this.customSlots.put(104, this.addSlot(new Slot(internal, 104, 71, 127) {
			}));
			this.customSlots.put(105, this.addSlot(new Slot(internal, 105, 89, 127) {
			}));
			this.customSlots.put(106, this.addSlot(new Slot(internal, 106, 107, 127) {
			}));
			this.customSlots.put(107, this.addSlot(new Slot(internal, 107, 125, 127) {
			}));
			this.customSlots.put(108, this.addSlot(new Slot(internal, 108, 143, 127) {
			}));
			this.customSlots.put(109, this.addSlot(new Slot(internal, 109, 161, 127) {
			}));
			this.customSlots.put(110, this.addSlot(new Slot(internal, 110, 179, 127) {
			}));
			this.customSlots.put(111, this.addSlot(new Slot(internal, 111, 197, 127) {
			}));
			this.customSlots.put(112, this.addSlot(new Slot(internal, 112, -37, 145) {
			}));
			this.customSlots.put(113, this.addSlot(new Slot(internal, 113, -19, 145) {
			}));
			this.customSlots.put(114, this.addSlot(new Slot(internal, 114, -1, 145) {
			}));
			this.customSlots.put(115, this.addSlot(new Slot(internal, 115, 17, 145) {
			}));
			this.customSlots.put(116, this.addSlot(new Slot(internal, 116, 35, 145) {
			}));
			this.customSlots.put(117, this.addSlot(new Slot(internal, 117, 53, 145) {
			}));
			this.customSlots.put(118, this.addSlot(new Slot(internal, 118, 71, 145) {
			}));
			this.customSlots.put(119, this.addSlot(new Slot(internal, 119, 89, 145) {
			}));
			this.customSlots.put(120, this.addSlot(new Slot(internal, 120, 107, 145) {
			}));
			this.customSlots.put(121, this.addSlot(new Slot(internal, 121, 125, 145) {
			}));
			this.customSlots.put(122, this.addSlot(new Slot(internal, 122, 143, 145) {
			}));
			this.customSlots.put(123, this.addSlot(new Slot(internal, 123, 161, 145) {
			}));
			this.customSlots.put(124, this.addSlot(new Slot(internal, 124, 179, 145) {
			}));
			this.customSlots.put(125, this.addSlot(new Slot(internal, 125, 197, 145) {
			}));
			int si;
			int sj;
			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlot(new Slot(inv, sj + (si + 1) * 9, 0 + 8 + sj * 18, 172 + 5 + si * 18));
			for (si = 0; si < 9; ++si)
				this.addSlot(new Slot(inv, si, 0 + 8 + si * 18, 172 + 66));
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return internal.isUsableByPlayer(player);
		}

		@Override
		public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (index < 126) {
					if (!this.mergeItemStack(itemstack1, 126, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
					slot.onSlotChange(itemstack1, itemstack);
				} else if (!this.mergeItemStack(itemstack1, 0, 126, false)) {
					if (index < 126 + 27) {
						if (!this.mergeItemStack(itemstack1, 126 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 126, 126 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}
				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}
				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}
				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override /**
					 * Merges provided ItemStack with the first avaliable one in the
					 * container/player inventor between minIndex (included) and maxIndex
					 * (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the
					 * Container implementation do not check if the item is valid for the slot
					 */
		protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
			boolean flag = false;
			int i = startIndex;
			if (reverseDirection) {
				i = endIndex - 1;
			}
			if (stack.isStackable()) {
				while (!stack.isEmpty()) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot = this.inventorySlots.get(i);
					ItemStack itemstack = slot.getStack();
					if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && areItemsAndTagsEqual(stack, itemstack)) {
						int j = itemstack.getCount() + stack.getCount();
						int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
						if (j <= maxSize) {
							stack.setCount(0);
							itemstack.setCount(j);
							slot.putStack(itemstack);
							flag = true;
						} else if (itemstack.getCount() < maxSize) {
							stack.shrink(maxSize - itemstack.getCount());
							itemstack.setCount(maxSize);
							slot.putStack(itemstack);
							flag = true;
						}
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			if (!stack.isEmpty()) {
				if (reverseDirection) {
					i = endIndex - 1;
				} else {
					i = startIndex;
				}
				while (true) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot1 = this.inventorySlots.get(i);
					ItemStack itemstack1 = slot1.getStack();
					if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
						if (stack.getCount() > slot1.getSlotStackLimit()) {
							slot1.putStack(stack.split(slot1.getSlotStackLimit()));
						} else {
							slot1.putStack(stack.split(stack.getCount()));
						}
						slot1.onSlotChanged();
						flag = true;
						break;
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			return flag;
		}

		@Override
		public void onContainerClosed(PlayerEntity playerIn) {
			super.onContainerClosed(playerIn);
			internal.closeInventory(playerIn);
			if ((internal instanceof Inventory) && (playerIn instanceof ServerPlayerEntity)) {
				this.clearContainer(playerIn, playerIn.world, internal);
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				EnderXMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 256;
		}
		private static final ResourceLocation texture = new ResourceLocation("enderx22:textures/largechestgui.png");
		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			this.renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.blit(k, l, 0, 0, this.xSize, this.ySize);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("enderx22:textures/player_inventory.png"));
			this.blit(this.guiLeft + 0, this.guiTop + 0, 0, 0, 256, 256);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("enderx22:textures/inventory_large.png"));
			this.blit(this.guiLeft + -39, this.guiTop + -3, 0, 0, 256, 256);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		}

		@Override
		public void removed() {
			super.removed();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
