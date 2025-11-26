package net.y9.mixin;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.y9.ItemSplitBugfix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {

    @Inject(method = "insertStack(Lnet/minecraft/item/ItemStack;)Z", at = @At("HEAD"))
    public void onInsertStack(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        ItemSplitBugfix.fixSplitBug(stack);
    }

    @Inject(method = "addStack(Lnet/minecraft/item/ItemStack;)I", at = @At("HEAD"))
    public void onAddStack(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        ItemSplitBugfix.fixSplitBug(stack);
    }

    @Inject(method = "setStack", at = @At("HEAD"))
    public void onSetStack(int slot, ItemStack stack, CallbackInfo ci) {
        ItemSplitBugfix.fixSplitBug(stack);
    }
}