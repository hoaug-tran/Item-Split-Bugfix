package net.y9;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.nbt.NbtCompound;

public class ItemSplitBugfix implements ModInitializer {

	@Override
	public void onInitialize() {
	}

	public static void fixSplitBug(ItemStack stack) {

		if (stack.contains(DataComponentTypes.CUSTOM_DATA)) {
			NbtComponent component = stack.get(DataComponentTypes.CUSTOM_DATA);

			if (component != null) {
				NbtCompound nbt = component.copyNbt();
				if (nbt.isEmpty()) {
					stack.remove(DataComponentTypes.CUSTOM_DATA);
				}

			}

		}

	}
}